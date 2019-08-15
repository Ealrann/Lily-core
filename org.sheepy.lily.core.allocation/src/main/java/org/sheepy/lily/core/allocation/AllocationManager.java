package org.sheepy.lily.core.allocation;

import java.util.ArrayList;
import java.util.List;

import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.core.api.allocation.IAllocationConfiguration;
import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.core.api.allocation.IAllocationManager;
import org.sheepy.lily.core.api.allocation.IAllocationService;

public final class AllocationManager<T extends IAllocationContext> implements IAllocationManager<T>
{
	public static final AllocationService allocationService = (AllocationService) IAllocationService.INSTANCE;

	public final IAllocable<T> allocable;
	public final List<IDependencyListener> listeners = new ArrayList<>();

	private AllocationManager<?> parent;
	private boolean virtual = false;
	private AllocationConfiguration configuration = null;

	private boolean dirtyBranch = true;
	private boolean allocated = false;

	static final <T extends IAllocationContext> AllocationManager<T> newManager(AllocationManager<?> parent,
																				IAllocable<T> allocable)
	{
		final AllocationManager<T> res = new AllocationManager<>(allocable);
		if (parent != null) res.setParent(parent, false);
		return res;
	}

	static final <T extends IAllocationContext> AllocationManager<T> newContextManager(	AllocationManager<?> parent,
																						IAllocable<T> allocable)
	{
		final AllocationManager<T> res = new AllocationManager<>(allocable);
		if (parent != null) res.setParent(parent, true);
		return res;
	}

	static final <T extends IAllocationContext> AllocationManager<T> newVirtualManager(IAllocable<T> allocable)
	{
		final AllocationManager<T> res = new AllocationManager<>(allocable);
		res.virtual = true;
		return res;
	}

	private AllocationManager(IAllocable<T> allocable)
	{
		assert allocable != null;

		this.allocable = allocable;
	}

	void setParent(AllocationManager<?> parent, boolean isContext)
	{
		this.parent = parent;
		if (isContext == false)
		{
			assert parent.configuration.children.contains(this) == false;
			parent.configuration.children.add(this);
		}
		virtual = false;
	}

	boolean isVirtual()
	{
		return virtual;
	}

	@Override
	@SuppressWarnings("unchecked")
	public void configure(IAllocationContext context)
	{
		cleanConfiguration();

		configuration = new AllocationConfiguration((T) context);

		allocable.configureAllocation(configuration, (T) context);
	}

	private void cleanConfiguration()
	{
		if (configuration != null)
		{
			configuration.clean();
			configuration = null;
		}
	}

	@Override
	public void allocate()
	{
		if (dirtyBranch)
		{
			configuration.allocateChildren();
			dirtyBranch = false;
		}

		if (configuration.dirty || !allocated)
		{
			allocated = true;
			allocable.allocate(configuration.context);
			configuration.dirty = false;
		}
	}

	@Override
	public void free()
	{
		free(false);
	}

	@Override
	public void freeDirtyElements()
	{
		free(true);
	}

	public void free(boolean dirtyOnly)
	{
		if (allocated && (!dirtyOnly || configuration.dirty))
		{
			allocable.free(configuration.context);
			allocated = false;
		}

		if (!dirtyOnly || dirtyBranch)
		{
			configuration.freeChildren(dirtyOnly);
			dirtyBranch();
		}
	}

	@Override
	public boolean isBranchDirty()
	{
		return dirtyBranch;
	}

	private void dirtyBranch()
	{
		if (this.dirtyBranch == false)
		{
			this.dirtyBranch = true;
			if (parent != null)
			{
				parent.dirtyBranch();
			}
		}
	}

	private void fireDirtyChange()
	{
		for (final var listener : listeners)
		{
			listener.markedAsDirty();
		}
	}

	private final class AllocationConfiguration implements IAllocationConfiguration
	{
		public final List<AllocationManager<?>> children = new ArrayList<>();
		public final List<AllocationManager<?>> dependencies = new ArrayList<>();

		private IAllocationContext childrenContext = null;
		private AllocationManager<T> childrenContextManager = null;

		private T context = null;
		private boolean dirty = false;

		private final IDependencyListener dependencyListener = () ->
		{
			setDirty();
		};

		private AllocationConfiguration(T context)
		{
			this.context = context;
		}

		public void allocateChildren()
		{
			if (childrenContextManager != null)
			{
				childrenContextManager.allocate();
			}

			for (int i = 0; i < children.size(); i++)
			{
				final var allocationManager = children.get(i);
				allocationManager.allocate();
			}
		}

		private void freeChildren(boolean dirtyOnly)
		{
			for (int i = children.size() - 1; i >= 0; i--)
			{
				final var allocationManager = children.get(i);
				allocationManager.free(dirtyOnly);
			}

			if (childrenContextManager != null)
			{
				childrenContextManager.free(dirtyOnly);
			}
		}

		private void clean()
		{
			for (final var dep : configuration.dependencies)
			{
				dep.listeners.remove(dependencyListener);
			}
		}

		@Override
		@SuppressWarnings("unchecked")
		public void setChildrenContext(IAllocationContext newChildrenContext)
		{
			this.childrenContext = newChildrenContext;

			if (newChildrenContext != null && newChildrenContext instanceof IAllocable<?>)
			{
				childrenContextManager = allocationService.getOrCreateContext(
						AllocationManager.this, (IAllocable<T>) newChildrenContext);

				childrenContextManager.configure(this.context);
			}
			else
			{
				childrenContextManager = null;
			}
		}

		private IAllocationContext childContext()
		{
			final IAllocationContext childContext = childrenContext != null
					? childrenContext
					: context;
			return childContext;
		}

		@Override
		public void addChildren(List<? extends IAllocable<?>> newChildren)
		{
			if (newChildren.isEmpty() == false)
			{
				for (final var child : newChildren)
				{
					assert child != null;

					final var childManager = allocationService.getOrCreate(AllocationManager.this,
							(IAllocable<?>) child);

					childManager.configure(childContext());

					if (allocated)
					{
						childManager.allocate();
					}
				}
				dirtyBranch();
			}
		}

		@Override
		public void removeChildren(List<? extends IAllocable<?>> oldChildren)
		{
			for (final var allocable : oldChildren)
			{
				final var manager = allocationService.unregister(allocable);
				this.children.remove(manager);
			}
		}

		@Override
		public void clearChildren()
		{
			for (final var child : children)
			{
				allocationService.unregister(child.allocable);
			}
			this.children.clear();
		}

		@Override
		public void addDependencies(List<? extends IAllocable<?>> newDependencies)
		{
			for (final var dependency : newDependencies)
			{
				final var manager = allocationService.getOrCreateVirtual(dependency);
				this.dependencies.add(manager);
				manager.listeners.add(dependencyListener);
			}
		}

		@Override
		public void removeDependencies(List<? extends IAllocable<?>> oldDependencies)
		{
			for (final var dependency : oldDependencies)
			{
				final var manager = allocationService.getManager(dependency);
				this.dependencies.remove(manager);
				manager.listeners.remove(dependencyListener);
			}
		}

		@Override
		public void clearDependencies()
		{
			for (final var dependency : dependencies)
			{
				dependency.listeners.remove(dependencyListener);
			}
			dependencies.clear();
		}

		@Override
		public void setDirty()
		{
			if (dirty == false)
			{
				dirty = true;
				if (parent != null)
				{
					parent.dirtyBranch();
				}
				fireDirtyChange();
			}
		}
	}

	private interface IDependencyListener
	{
		void markedAsDirty();
	}
}
