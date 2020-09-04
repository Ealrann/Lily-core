package org.sheepy.lily.core.allocation.children.manager;

import org.sheepy.lily.core.allocation.children.instance.ChildrenSupervisor;
import org.sheepy.lily.core.api.allocation.IAllocationContext;

import java.util.List;
import java.util.Optional;

public final class AllocationChildrenManager
{
	private final List<ChildrenSupervisor> childrenSupervisors;
	private final Optional<IAllocationContext> providedContext;

	AllocationChildrenManager(final List<ChildrenSupervisor> childrenSupervisors,
							  final Optional<IAllocationContext> providedContext)
	{
		this.childrenSupervisors = List.copyOf(childrenSupervisors);
		this.providedContext = providedContext;
	}

	public Optional<IAllocationContext> getProvidedContext()
	{
		return providedContext;
	}

	public List<ChildrenSupervisor> getSupervisors()
	{
		return childrenSupervisors;
	}
}
