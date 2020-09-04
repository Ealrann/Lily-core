package org.sheepy.lily.core.allocation.spliterator;

import org.sheepy.lily.core.allocation.children.instance.ChildDescriptorAllocator;
import org.sheepy.lily.core.allocation.children.instance.ChildHandleAllocator;
import org.sheepy.lily.core.allocation.children.instance.ChildrenSupervisor;
import org.sheepy.lily.core.allocation.children.manager.AllocationChildrenManager;
import org.sheepy.lily.core.allocation.operation.IOperation;

import java.util.Iterator;
import java.util.Optional;

public final class CleanupTreeIterator extends AllocationTreeIterator<CleanupTreeIterator>
{
	private boolean free;

	private Iterator<IOperation<CleanupTreeIterator>> operations = null;

	public CleanupTreeIterator()
	{
		super(true, true);
	}

	public void load(final AllocationChildrenManager childrenManager, final boolean free)
	{
		super.load(childrenManager);
		this.free = free;
	}

	@Override
	public Optional<IOperation<CleanupTreeIterator>> tryAdvance()
	{
		while (operations == null || operations.hasNext() == false)
		{
			final var handle = tryAdvanceHandleAllocator();
			if (handle != null)
			{
				operations = handle.prepareCleanupOperation(free || isIteratingRemovedElements()).iterator();
			}
			else
			{
				return Optional.empty();
			}
		}

		return Optional.ofNullable(operations.next());
	}

	@Override
	protected void updateSupervisor(final ChildrenSupervisor supervisor)
	{
	}

	@Override
	protected void postUpdateDescriptorAllocator(final ChildDescriptorAllocator descriptorAllocator)
	{
		descriptorAllocator.postCleanup();
	}

	@Override
	protected boolean operatesOnHandleAllocator(final ChildHandleAllocator<?> currentHandleAllocator)
	{
		return true;
	}
}
