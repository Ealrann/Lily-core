package org.sheepy.lily.core.allocation.spliterator;

import org.sheepy.lily.core.allocation.children.instance.ChildDescriptorAllocator;
import org.sheepy.lily.core.allocation.children.instance.ChildHandleAllocator;
import org.sheepy.lily.core.allocation.children.instance.ChildrenSupervisor;
import org.sheepy.lily.core.allocation.children.manager.AllocationChildrenManager;
import org.sheepy.lily.core.allocation.operation.IOperation;

import java.util.Optional;

public final class TriageTreeIterator extends AllocationTreeIterator<TriageTreeIterator>
{
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
	public Optional<IOperation<TriageTreeIterator>> tryAdvance()
	{
		final var handle = tryAdvanceHandleAllocator();
		if (handle != null)
		{
			return Optional.of(handle.prepareTriageOperation(force));
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
	protected void postUpdateDescriptorAllocator(final ChildDescriptorAllocator descriptorAllocator)
	{
	}

	@Override
	protected boolean operatesOnHandleAllocator(final ChildHandleAllocator<?> handleAllocator)
	{
		return handleAllocator.canTriage();
	}
}
