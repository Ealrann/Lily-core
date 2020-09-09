package org.sheepy.lily.core.allocation.treeiterator;

import org.sheepy.lily.core.allocation.children.instance.ChildDescriptorAllocator;
import org.sheepy.lily.core.allocation.children.instance.ChildHandleAllocator;
import org.sheepy.lily.core.allocation.children.instance.ChildrenSupervisor;
import org.sheepy.lily.core.allocation.children.manager.AllocationChildrenManager;
import org.sheepy.lily.core.allocation.operation.BuildOperation;
import org.sheepy.lily.core.allocation.operation.IOperation;
import org.sheepy.lily.core.allocation.operation.UpdateOperation;
import org.sheepy.lily.core.api.model.ILilyEObject;

import java.util.Optional;

public final class UpdateTreeIterator extends AllocationTreeIterator<UpdateTreeIterator>
{
	private final UpdateOperation updateOperation = new UpdateOperation();
	private final BuildOperation buildOperation = new BuildOperation();

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
		final var handleAllocator = tryAdvanceHandleAllocator();
		if (handleAllocator != null)
		{
			assert handleAllocator.shouldUpdate();
			final var mainAllocation = handleAllocator.getMainAllocation();
			if (mainAllocation == null)
			{
				handleAllocator.setupBuildOperation(buildOperation);
				return Optional.of(buildOperation);
			}
			else
			{
				updateOperation.setup(mainAllocation, handleAllocator.target());
				return Optional.of(updateOperation);
			}
		}
		else
		{
			return Optional.empty();
		}
	}

	@Override
	protected void updateSupervisor(final ChildrenSupervisor supervisor)
	{
		supervisor.update(source);
	}

	@Override
	protected void postUpdateSupervisor(final ChildrenSupervisor supervisor)
	{
		supervisor.postUpdate(source);
	}

	@Override
	protected void postUpdateDescriptorAllocator(final ChildDescriptorAllocator descriptorAllocator)
	{
	}

	@Override
	protected boolean operatesOnHandleAllocator(final ChildHandleAllocator<?> currentHandleAllocator)
	{
		return currentHandleAllocator.shouldUpdate();
	}
}
