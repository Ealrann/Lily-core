package org.sheepy.lily.core.allocation;

import org.sheepy.lily.core.allocation.internal.AllocationConfiguration;
import org.sheepy.lily.core.allocation.internal.AllocationState;
import org.sheepy.lily.core.allocation.internal.IDependencyListener;
import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.core.api.allocation.IAllocationConfigurator;
import org.sheepy.lily.core.api.allocation.IAllocationContext;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public final class AllocationManager<T extends IAllocationContext>
{
	private final AllocationManagerFactory<?> factory;
	private final IDependencyListener dependencyListener = this::dependencyChanged;
	private final AllocationConfigurator configurator = new AllocationConfigurator();
	public final AllocationState<T> state;

	private AllocationConfiguration<T> configuration = null;
	private AllocationManager<T> childrenContextManager = null;

	static <T extends IAllocationContext> AllocationManager<T> newManager(AllocationManagerFactory<?> factory,
																		  AllocationManager<?> parent,
																		  AllocationState<T> state)
	{
		return new AllocationManager<>(factory, parent, state);
	}

	static <T extends IAllocationContext> AllocationManager<T> newContextManager(AllocationManagerFactory<?> factory,
																				 AllocationState<T> state)
	{
		return new AllocationManager<>(factory, null, state);
	}

	protected AllocationManager(AllocationManagerFactory<?> factory,
								AllocationManager<?> parent,
								AllocationState<T> state)
	{
		this.factory = factory;
		this.state = state;

		if (parent != null)
		{
			assert parent.configuration.children.contains(this) == false;
			parent.configuration.children.add(this);
		}
	}

	@SuppressWarnings("unchecked")
	public void configure(IAllocationContext context)
	{
		cleanConfiguration(false);
		configuration = new AllocationConfiguration<>((T) context);
		state.allocable.configureAllocation(configurator, (T) context);
	}

	@SuppressWarnings("unchecked")
	private void configureChildrenContext(IAllocationContext childrenContext)
	{
		configuration.setChildrenContext(childrenContext);
		if (childrenContext instanceof IAllocable<?>)
		{
			final var allocableContext = (IAllocable<T>) childrenContext;
			childrenContextManager = factory.createContext(this, allocableContext);
			childrenContextManager.configure(configuration.context);
		}
		else
		{
			childrenContextManager = null;
		}
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
				dep.removeListener(dependencyListener);
			}
			configuration = null;
		}
	}

	public void allocate()
	{
		if (state.isBranchDirty())
		{
			try
			{
				if (childrenContextManager != null)
				{
					childrenContextManager.allocate();
					configuration.childContext().beforeChildrenAllocation();
				}
				configuration.allocateChildren();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				if (childrenContextManager != null)
				{
					configuration.childContext().afterChildrenAllocation();
				}
			}
			state.setBranchDirty(false);
		}

		state.tryAllocate(configuration);
	}

	public void free()
	{
		free(false);
	}

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

		state.free(configuration.context, dirtyOnly);

		if (!dirtyOnly || state.isBranchDirty())
		{
			configuration.freeChildren(dirtyOnly);
			if (childrenContextManager != null)
			{
				childrenContextManager.free(dirtyOnly);
			}
			state.markBranchAsDirty();
		}
	}

	public boolean isBranchDirty()
	{
		return state.isBranchDirty();
	}

	private void dependencyChanged(IDependencyListener.EChangeNature changeNature)
	{
		if (changeNature != IDependencyListener.EChangeNature.Allocated)
		{
			state.markDirty();
		}
		else if (state.is(EAllocationStatus.AllocationDelayed) && configuration.areDependenciesAllocated())
		{
			state.allocate(configuration.context);
		}
	}

	public void appendInfo(StringBuilder appendTo, int depth)
	{
		appendTo.append(System.lineSeparator());
		appendTo.append("-".repeat(Math.max(0, depth)));
		appendTo.append('[' + state.toString() + "] ");
		if (configuration != null) configuration.appendInfo(appendTo, depth);
	}

	public Collection<? extends AllocationManager<?>> getChildren()
	{
		return configuration.children;
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
		public void setChildrenContext(IAllocationContext newChildrenContext)
		{
			configureChildrenContext(newChildrenContext);
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

				state.markBranchAsDirty();
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
						if (oldAllocableDependency == child.state.allocable)
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

				state.markBranchAsDirty();
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
				addDependency(newDeps.get(i));
			}
		}

		@Override
		public void addDependency(final IAllocable<?> newDependency)
		{
			final var state = factory.getOrCreateState(newDependency);
			configuration.dependencies.add(state);
			state.addListener(dependencyListener);
			if (state.is(EAllocationStatus.Allocated)) setDirty();
		}

		@Override
		public void removeDependencies(List<? extends IAllocable<?>> oldDeps)
		{
			for (int i = 0; i < oldDeps.size(); i++)
			{
				final var oldAllocableDependency = oldDeps.get(i);
				removeDependency(oldAllocableDependency);
			}
		}

		@Override
		public void removeDependency(final IAllocable<?> oldAllocableDependency)
		{
			final var it = configuration.dependencies.iterator();
			while (it.hasNext())
			{
				final var dependency = it.next();
				if (oldAllocableDependency == dependency.allocable)
				{
					dependency.removeListener(dependencyListener);
					it.remove();
					break;
				}
			}
			if (state.is(EAllocationStatus.Allocated)) setDirty();
		}

		@Override
		public void clearDependencies()
		{
			for (final var dependency : configuration.dependencies)
			{
				dependency.removeListener(dependencyListener);
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
			state.markDirty();
		}
	}
}
