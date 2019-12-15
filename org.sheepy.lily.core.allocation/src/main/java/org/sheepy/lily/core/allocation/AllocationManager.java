package org.sheepy.lily.core.allocation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

import org.sheepy.lily.core.allocation.internal.AllocationConfiguration;
import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.core.api.allocation.IAllocationConfigurator;
import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.core.api.allocation.IAllocationManager;

public class AllocationManager<T extends IAllocationContext> implements IAllocationManager<T>
{
	public final IAllocable<T> allocable;
	public final List<IDependencyListener> listeners = new ArrayList<>();
	private final AllocationManagerFactory<?> factory;
	private final IDependencyListener dependencyListener = this::dependencyChanged;
	private final AllocationConfigurator configurator = new AllocationConfigurator();

	private boolean dirty = false;
	private AllocationManager<?> parent;
	private boolean virtual = false;
	private AllocationConfiguration<T> configuration = null;
	private AllocationManager<T> childrenContextManager = null;
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
		configuration = new AllocationConfiguration<>((T) context);
		allocable.configureAllocation(configurator, (T) context);
	}

	private void cleanConfiguration()
	{
		if (configuration != null)
		{
			for (final var dep : configuration.dependencies)
			{
				dep.listeners.remove(dependencyListener);
			}
			configuration = null;
		}
	}

	@Override
	public void allocate()
	{
		if (dirtyBranch)
		{
			if (childrenContextManager != null)
			{
				childrenContextManager.allocate();
			}
			configuration.allocateChildren();
			dirtyBranch = false;
		}

		if (dirty || status == EAllocationStatus.NotAllocated)
		{
			if (configuration.isAllocable())
			{
				if (configuration.areDependenciesAllocated())
				{
					status = EAllocationStatus.Allocated;
					doAllocate();
				}
				else
				{
					status = EAllocationStatus.AllocationDelayed;
				}
				dirty = false;
			}
			else
			{
				status = EAllocationStatus.CannotAllocate;
			}
		}
	}

	private void doAllocate()
	{
		allocable.allocate(configuration.context);
		fireChange();
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
		if (status != EAllocationStatus.NotAllocated && (!dirtyOnly || dirty))
		{
			if (status == EAllocationStatus.Allocated)
			{
				allocable.free(configuration.context);
				fireChange();
			}
			status = EAllocationStatus.NotAllocated;
		}

		if (!dirtyOnly || dirtyBranch)
		{
			configuration.freeChildren(dirtyOnly);
			if (childrenContextManager != null)
			{
				childrenContextManager.free(dirtyOnly);
			}
			markBranchAsDirty();
		}
	}

	@Override
	public boolean isBranchDirty()
	{
		return dirtyBranch;
	}

	private void markBranchAsDirty()
	{
		if (this.dirtyBranch == false)
		{
			this.dirtyBranch = true;
			if (parent != null)
			{
				parent.markBranchAsDirty();
			}
		}
	}

	private void dependencyChanged()
	{
		if (status == EAllocationStatus.AllocationDelayed
				&& configuration.areDependenciesAllocated())
		{
			allocable.allocate(configuration.context);
			fireChange();
		}
		else
		{
			setDirty();
		}
	}

	public void setDirty()
	{
		if (dirty == false)
		{
			dirty = true;
			if (parent != null)
			{
				parent.markBranchAsDirty();
			}
			fireChange();
		}
	}

	private void fireChange()
	{
		for (final var listener : listeners)
		{
			listener.onChange();
		}
	}

	public void appendInfo(StringBuilder appendTo, int depth)
	{
		appendTo.append(System.lineSeparator());
		for (int i = 0; i < depth; i++)
		{
			appendTo.append('-');
		}
		appendTo.append('[' + allocable.getClass().getSimpleName() + "] ");

		configuration.appendInfo(appendTo, depth);
	}

	public Collection<? extends AllocationManager<?>> getChildren()
	{
		return configuration.children;
	}

	public EAllocationStatus getStatus()
	{
		return status;
	}

	@Override
	public String toString()
	{
		final var sb = new StringBuilder();
		appendInfo(sb, 0);
		return sb.toString();
	}

	private final class AllocationConfigurator implements IAllocationConfigurator
	{
		@Override
		@SuppressWarnings("unchecked")
		public void setChildrenContext(IAllocationContext newChildrenContext)
		{
			configuration.setChildrenContext(newChildrenContext);
			if (newChildrenContext != null && newChildrenContext instanceof IAllocable<?>)
			{
				childrenContextManager = factory.createContext(	AllocationManager.this,
																(IAllocable<T>) newChildrenContext);
				childrenContextManager.configure(configuration.context);
			}
			else
			{
				childrenContextManager = null;
			}
		}

		@Override
		public void addChildren(List<? extends IAllocable<?>> newChildren)
		{
			if (newChildren.isEmpty() == false)
			{
				for (final var newChild : newChildren)
				{
					final var childManager = factory.create(AllocationManager.this, newChild);
					childManager.configure(configuration.childContext());

					if (status == EAllocationStatus.Allocated)
					{
						childManager.allocate();
					}
				}

				markBranchAsDirty();
			}
		}

		@Override
		public void removeChildren(List<? extends IAllocable<?>> oldChildren)
		{
			if (oldChildren.isEmpty() == false)
			{
				for (int i = 0; i < oldChildren.size(); i++)
				{
					final var oldAllocableDependency = oldChildren.get(i);
					final var it = configuration.children.iterator();
					while (it.hasNext())
					{
						final var child = it.next();
						if (oldAllocableDependency == child.allocable)
						{
							child.free();
							it.remove();
							break;
						}
					}
				}
			}
		}

		@Override
		public void clearChildren()
		{
			final var it = configuration.children.iterator();
			while (it.hasNext())
			{
				final var child = it.next();
				child.free();
				it.remove();
				break;
			}
		}

		@Override
		public void addDependencies(List<? extends IAllocable<?>> newDeps)
		{
			for (int i = 0; i < newDeps.size(); i++)
			{
				final var newAllocableDep = newDeps.get(i);
				final var dep = factory.getOrCreateVirtual(newAllocableDep);
				configuration.dependencies.add(dep);
				dep.listeners.add(dependencyListener);
			}
		}

		@Override
		public void removeDependencies(List<? extends IAllocable<?>> oldDeps)
		{
			final var it = configuration.dependencies.iterator();
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
			for (final var dependency : configuration.dependencies)
			{
				dependency.listeners.remove(dependencyListener);
			}
			configuration.dependencies.clear();
		}

		@Override
		public void setAllocationCondition(Predicate<IAllocationContext> predicate)
		{
			configuration.setAllocationCondition(predicate);
		}

		@Override
		public void setDirty()
		{
			AllocationManager.this.setDirty();
		}
	}

	private interface IDependencyListener
	{
		void onChange();
	}
}
