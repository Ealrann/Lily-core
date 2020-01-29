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

	static final <T extends IAllocationContext> AllocationManager<T> newContextManager(AllocationManagerFactory<?> factory,
																					   AllocationManager<?> parent,
																					   IAllocable<T> allocable)
	{
		final AllocationManager<T> res = new AllocationManager<>(factory, allocable);
		if (parent != null) res.setParent(parent, true);
		return res;
	}

	static final <T extends IAllocationContext> AllocationManager<T> newVirtualManager(AllocationManagerFactory<?> factory,
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
		cleanConfiguration(false);
		configuration = new AllocationConfiguration<>((T) context);
		allocable.configureAllocation(configurator, (T) context);
	}

	private void cleanConfiguration(boolean deep)
	{
		if (configuration != null)
		{
			if (deep)
			{
				for (final var child : configuration.children)
				{
					child.cleanConfiguration(true);
				}
			}

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

		if (status == EAllocationStatus.NotAllocated)
		{
			if (configuration.isAllocable())
			{
				dirty = false;
				if (configuration.areDependenciesAllocated())
				{
					doAllocate();
				}
				else
				{
					status = EAllocationStatus.AllocationDelayed;
				}
			}
			else
			{
				status = EAllocationStatus.CannotAllocate;
			}
		}
	}

	private void doAllocate()
	{
		status = EAllocationStatus.Allocated;
		allocable.allocate(configuration.context);
		fireChange(IDependencyListener.EChangeNature.Allocated);
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
		while (configuration.childrenToRemove.isEmpty() == false)
		{
			final var childToRemove = configuration.childrenToRemove.pop();
			childToRemove.free();
			childToRemove.cleanConfiguration(true);
			configuration.children.remove(childToRemove);
		}
		configuration.childrenToRemove.clear();

		if (status != EAllocationStatus.NotAllocated && (!dirtyOnly || dirty))
		{
			if (status == EAllocationStatus.Allocated)
			{
				allocable.free(configuration.context);
				fireChange(IDependencyListener.EChangeNature.Free);
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

	public boolean isDirty()
	{
		return dirty;
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

	private void dependencyChanged(AllocationManager<?> source,
								   IDependencyListener.EChangeNature changeNature)
	{
		if (changeNature != IDependencyListener.EChangeNature.Allocated)
		{
			setDirty();
		}
		else if (status == EAllocationStatus.AllocationDelayed
				&& configuration.areDependenciesAllocated())
		{
			doAllocate();
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
			fireChange(IDependencyListener.EChangeNature.Dirty);
		}
	}

	private void fireChange(IDependencyListener.EChangeNature nature)
	{
		for (final var listener : listeners)
		{
			listener.onChange(this, nature);
		}
	}

	public void appendInfo(StringBuilder appendTo, int depth)
	{
		appendTo.append(System.lineSeparator());
		appendTo.append("-".repeat(Math.max(0, depth)));
		appendTo.append('[' + allocable.getClass()
									   .getSimpleName() + "] ");

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
				childrenContextManager = factory.createContext(AllocationManager.this,
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
			addChildren(newChildren, false);
		}

		@Override
		public void addChildren(List<? extends IAllocable<?>> newChildren, boolean allocateNow)
		{
			if (newChildren.isEmpty() == false)
			{
				for (final var newChild : newChildren)
				{
					final var childManager = factory.create(AllocationManager.this, newChild);
					childManager.configure(configuration.childContext());

					if (allocateNow)
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
			removeChildren(oldChildren, false);
		}

		@Override
		public void removeChildren(List<? extends IAllocable<?>> oldChildren, boolean freeNow)
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
							if (freeNow)
							{
								child.free();
								child.cleanConfiguration(true);
								it.remove();
							}
							else
							{
								configuration.childrenToRemove.add(child);
							}

							break;
						}
					}
				}

				markBranchAsDirty();
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
		enum EChangeNature
		{
			Dirty,
			Allocated,
			Free
		}

		void onChange(AllocationManager<?> source, EChangeNature changeNature);
	}
}
