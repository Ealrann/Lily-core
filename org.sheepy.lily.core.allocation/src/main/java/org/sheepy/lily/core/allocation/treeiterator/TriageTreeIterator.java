package org.sheepy.lily.core.allocation.treeiterator;

import org.sheepy.lily.core.allocation.children.instance.ChildDescriptorAllocator;
import org.sheepy.lily.core.allocation.children.instance.ChildHandleAllocator;
import org.sheepy.lily.core.allocation.children.instance.ChildrenSupervisor;
import org.sheepy.lily.core.allocation.children.manager.AllocationChildrenManager;
import org.sheepy.lily.core.allocation.operation.TriageOperation;

import java.util.Optional;

public final class TriageTreeIterator extends AllocationTreeIterator<TriageTreeIterator>
{
	private final TriageOperation operation = new TriageOperation();

	private boolean force;

	public TriageTreeIterator()
	{
		super(false, false);
	}

	public void load(final AllocationChildrenManager childrenManager, final boolean force)
	{
		super.load(childrenManager);
		this.force = force;
	}

	@Override
	public Optional<TriageOperation> tryAdvance()
	{
		final var handleAllocator = tryAdvanceHandleAllocator();
		if (handleAllocator != null)
		{
			operation.setup(handleAllocator, force);
			return Optional.of(operation);
		}
		else
		{
			return Optional.empty();
		}
	}

	@Override
	protected void updateSupervisor(final ChildrenSupervisor supervisor)
	{
	}

	@Override
	protected void postUpdateSupervisor(final ChildrenSupervisor supervisor)
	{
	}

	@Override
	protected void postUpdateDescriptorAllocator(final ChildDescriptorAllocator descriptorAllocator)
	{
	}

	@Override
	protected boolean operatesOnHandleAllocator(final ChildHandleAllocator<?> handleAllocator)
	{
		return handleAllocator.canTriage(force);
	}
}
