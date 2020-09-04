package org.sheepy.lily.core.allocation.spliterator;

import org.sheepy.lily.core.allocation.children.instance.ChildDescriptorAllocator;
import org.sheepy.lily.core.allocation.children.instance.ChildHandleAllocator;
import org.sheepy.lily.core.allocation.children.instance.ChildrenSupervisor;
import org.sheepy.lily.core.allocation.children.manager.AllocationChildrenManager;
import org.sheepy.lily.core.allocation.operation.IOperation;
import org.sheepy.lily.core.api.model.ILilyEObject;

import java.util.Optional;

public final class UpdateTreeIterator extends AllocationTreeIterator<UpdateTreeIterator>
{
	private ILilyEObject source;

	public UpdateTreeIterator()
	{
		super(false, false);
	}

	public void load(final ILilyEObject source, final AllocationChildrenManager childrenManager)
	{
		this.source = source;
		super.load(childrenManager);
	}

	@Override
	public Optional<IOperation<UpdateTreeIterator>> tryAdvance()
	{
		return Optional.ofNullable(tryAdvanceHandleAllocator()).map(ChildHandleAllocator::prepareUpdateOperation);
	}

	@Override
	protected void updateSupervisor(final ChildrenSupervisor supervisor)
	{
		supervisor.update(source);
	}

	@Override
	protected void postUpdateDescriptorAllocator(final ChildDescriptorAllocator descriptorAllocator)
	{
		descriptorAllocator.postUpdate();
	}

	@Override
	protected boolean operatesOnHandleAllocator(final ChildHandleAllocator<?> currentHandleAllocator)
	{
		return this.currentHandleAllocator.shouldUpdate();
	}
}
