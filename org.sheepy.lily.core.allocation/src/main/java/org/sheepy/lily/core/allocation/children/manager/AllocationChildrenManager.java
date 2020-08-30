package org.sheepy.lily.core.allocation.children.manager;

import org.sheepy.lily.core.allocation.children.instance.ChildrenSupervisor;
import org.sheepy.lily.core.allocation.operation.IOperationNode;
import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.util.StreamUtil;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

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

	public Stream<IOperationNode> prepareTriage(final boolean forceTriage)
	{
		return childrenSupervisors.stream().flatMap(a -> a.prepareTriage(forceTriage));
	}

	public Stream<IOperationNode> prepareUpdate(ILilyEObject source)
	{
		return childrenSupervisors.stream().flatMap(s -> s.prepareUpdate(source));
	}

	public Stream<IOperationNode> prepareCleanup(final boolean free)
	{
		return StreamUtil.reverseStream(childrenSupervisors).flatMap(s -> s.prepareCleanup(free));
	}

	public Optional<IAllocationContext> getProvidedContext()
	{
		return providedContext;
	}
}
