package org.sheepy.lily.core.api.allocation;

import org.eclipse.emf.ecore.EReference;
import org.sheepy.lily.core.api.adapter.ILilyEObject;

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

	void addDependency(IAllocable<?> dependency);
	void addDependencies(List<? extends IAllocable<?>> dependencies);
	void removeDependency(IAllocable<?> dependency);
	void removeDependencies(List<? extends IAllocable<?>> dependencies);
	void clearDependencies();

	void setChildrenContext(IAllocationContext context);

	void setAllocationCondition(Predicate<IAllocationContext> predicate);
}
