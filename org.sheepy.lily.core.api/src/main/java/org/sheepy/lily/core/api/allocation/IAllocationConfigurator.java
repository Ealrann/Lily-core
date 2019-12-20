package org.sheepy.lily.core.api.allocation;

import java.util.List;
import java.util.function.Predicate;

public interface IAllocationConfigurator
{
	enum Features
	{
		Dirty,
		Children,
		Dependencies,
		ChildrenContext
	}

	void setDirty();

	void addChildren(List<? extends IAllocable<?>> children);
	void addChildren(List<? extends IAllocable<?>> children, boolean allocateNow);
	void removeChildren(List<? extends IAllocable<?>> children);
	void removeChildren(List<? extends IAllocable<?>> children, boolean freeNow);
	void clearChildren();

	void addDependencies(List<? extends IAllocable<?>> dependencies);
	void removeDependencies(List<? extends IAllocable<?>> dependencies);
	void clearDependencies();

	void setChildrenContext(IAllocationContext context);

	void setAllocationCondition(Predicate<IAllocationContext> predicate);
}
