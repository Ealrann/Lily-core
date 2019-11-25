package org.sheepy.lily.core.allocation;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.core.api.allocation.IAllocationConfiguration;
import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.core.api.allocation.IAllocationManager;

public class AllocationManager<T extends IAllocationContext> implements IAllocationManager<T>
{
	public final IAllocable<T> allocable;
	public final List<IDependencyListener> listeners = new ArrayList<>();
	private final AllocationManagerFactory<?> factory;

	private AllocationManager<?> parent;
	private boolean virtual = false;
	private AllocationConfiguration configuration = null;

	private boolean dirtyBranch = true;
	private EAllocationStatus status = EAllocationStatus.NotAllocated;

	static final <T extends IAllocationContext> AllocationManager<T> newManager(AllocationManagerFactory<?> factory,
																				AllocationManager<?> parent,
																				IAllocable<T> allocable)
	{
		final AllocationManager<T> res = new AllocationManager<>(factory, allocable);
		if (parent != null) res.setParent(parent, false);
		return res;
	}

	static final <T extends IAllocationContext> AllocationManager<T> newContextManager(	AllocationManagerFactory<?> factory,
																						AllocationManager<?> parent,
																						IAllocable<T> allocable)
	{
		final AllocationManager<T> res = new AllocationManager<>(factory, allocable);
		if (parent != null) res.setParent(parent, true);
		return res;
	}

	static final <T extends IAllocationContext> AllocationManager<T> newVirtualManager(	AllocationManagerFactory<?> factory,
																						IAllocable<T> allocable)
	{
		final AllocationManager<T> res = new AllocationManager<>(factory, allocable);
		res.virtual = true;
		return res;
	}

	protected AllocationManager(AllocationManagerFactory<?> factory, IAllocable<T> allocable)
	{
		this.factory = factory;
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

		if (configuration.dirty || status == EAllocationStatus.NotAllocated)
		{
			if (configuration.isAllocable())
			{
				status = EAllocationStatus.Allocated;
				allocable.allocate(configuration.context);
				configuration.dirty = false;
			}
			else
			{
				status = EAllocationStatus.CannotAllocate;
			}
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
		if (status != EAllocationStatus.NotAllocated && (!dirtyOnly || configuration.dirty))
		{
			if (status == EAllocationStatus.Allocated)
			{
				allocable.free(configuration.context);
			}
			status = EAllocationStatus.NotAllocated;
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

	public AllocationManager<?> searchManager(IAllocable<?> allocable)
	{
		if (this.allocable == allocable)
		{
			return this;
		}
		else
		{
			for (final var child : configuration.children)
			{
				final var childSearch = child.searchManager(allocable);
				if (childSearch != null)
				{
					return childSearch;
				}
			}
		}
		return null;
	}

	private void fireDirtyChange()
	{
		for (final var listener : listeners)
		{
			listener.markedAsDirty();
		}
	}

	private void appendInfo(StringBuilder appendTo, int depth)
	{
		appendTo.append(System.lineSeparator());
		for (int i = 0; i < depth; i++)
		{
			appendTo.append('-');
		}
		appendTo.append('[' + allocable.getClass().getSimpleName() + "] ");

		if (configuration.dependencies.isEmpty() == false)
		{
			appendTo.append("Dependencies: ");
			for (final var dep : configuration.dependencies)
			{
				appendTo.append(dep.allocable.getClass().getSimpleName());
			}
		}

		for (final var child : configuration.children)
		{
			child.appendInfo(appendTo, depth + 1);
		}
	}

	@Override
	public String toString()
	{
		final var sb = new StringBuilder();
		appendInfo(sb, 0);
		return sb.toString();
	}

	private final class AllocationConfiguration implements IAllocationConfiguration
	{

		public final List<AllocationManager<?>> children = new ArrayList<>();
		public final List<AllocationManager<?>> dependencies = new ArrayList<>();

		private final IDependencyListener dependencyListener = this::setDirty;

		private IAllocationContext childrenContext = null;
		private AllocationManager<T> childrenContextManager = null;
		private T context = null;
		private boolean dirty = false;
		private Predicate<IAllocationContext> allocationCondition;

		private AllocationConfiguration(T context)
		{
			this.context = context;
		}

		public boolean isAllocable()
		{
			boolean res = true;

			if (allocationCondition != null)
			{
				res &= allocationCondition.test(context);
			}

			for (int i = 0; i < dependencies.size(); i++)
			{
				var dep = dependencies.get(i);
				if (dep.status != EAllocationStatus.Allocated)
				{
					res &= false;
					break;
				}
			}

			return res;
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
				childrenContextManager = factory.createContext(	AllocationManager.this,
																(IAllocable<T>) newChildrenContext);

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

					final var childManager = factory.create(AllocationManager.this, child);
					childManager.configure(childContext());

					if (status == EAllocationStatus.Allocated)
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

			final var it = children.iterator();
			while (it.hasNext())
			{
				final var child = it.next();
				for (int i = 0; i < oldChildren.size(); i++)
				{
					final var oldAllocableDependency = oldChildren.get(i);
					if (oldAllocableDependency == child.allocable)
					{
						child.free();
						it.remove();
						break;
					}
				}
			}
		}

		@Override
		public void clearChildren()
		{
			for (final var child : children)
			{
				child.free();
			}
			this.children.clear();
		}

		@Override
		public void addDependencies(List<? extends IAllocable<?>> newDeps)
		{
			for (int i = 0; i < newDeps.size(); i++)
			{
				final var newAllocableDep = newDeps.get(i);
				final var dep = factory.getOrCreateVirtual(newAllocableDep);
				this.dependencies.add(dep);
				dep.listeners.add(dependencyListener);
			}
		}

		@Override
		public void removeDependencies(List<? extends IAllocable<?>> oldDeps)
		{
			final var it = dependencies.iterator();
			while (it.hasNext())
			{
				final var dependency = it.next();
				for (int i = 0; i < oldDeps.size(); i++)
				{
					final var oldAllocableDependency = oldDeps.get(i);
					if (oldAllocableDependency == dependency.allocable)
					{
						dependency.listeners.remove(dependencyListener);
						it.remove();
						break;
					}
				}
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

		@Override
		public void setAllocationCondition(Predicate<IAllocationContext> predicate)
		{
			this.allocationCondition = predicate;
		}
	}

	private interface IDependencyListener
	{
		void markedAsDirty();
	}
}
