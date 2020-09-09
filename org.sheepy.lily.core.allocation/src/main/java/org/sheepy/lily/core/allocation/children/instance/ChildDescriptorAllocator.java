package org.sheepy.lily.core.allocation.children.instance;

import org.sheepy.lily.core.allocation.children.util.HandleChildrenList;
import org.sheepy.lily.core.allocation.description.AllocationDescriptor;
import org.sheepy.lily.core.api.model.ILilyEObject;

import java.util.List;

public final class ChildDescriptorAllocator
{
	private final AllocationDescriptor<?> descriptor;
	private final HandleChildrenList handleChildren;

	public ChildDescriptorAllocator(final AllocationDescriptor<?> descriptor, final Runnable whenBranchDirty)
	{
		this.descriptor = descriptor;
		handleChildren = new HandleChildrenList(whenBranchDirty);
	}

	public void removeChildren(final List<ILilyEObject> removedChildren)
	{
		handleChildren.removeChildren(removedChildren);
	}

	public void reload(final List<ILilyEObject> children)
	{
		final var handleStream = descriptor.adaptHandles(children.stream());
		handleChildren.reload(handleStream);
	}

	public void postCleanup()
	{
		handleChildren.postCleanup();
	}

	public AllocationDescriptor<?> descriptor()
	{
		return descriptor;
	}

	public List<ChildHandleAllocator<?>> getHandles()
	{
		return handleChildren.getHandleAllocators();
	}

	public List<ChildHandleAllocator<?>> getRemovedHandles()
	{
		return handleChildren.getRemovedHandleAllocators();
	}
}
