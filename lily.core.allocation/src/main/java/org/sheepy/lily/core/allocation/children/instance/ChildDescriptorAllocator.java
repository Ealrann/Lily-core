package org.sheepy.lily.core.allocation.children.instance;

import org.sheepy.lily.core.allocation.children.util.HandleChildrenList;
import org.logoce.lmf.core.lang.LMObject;
import org.sheepy.lily.core.allocation.description.AllocationDescriptor;

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

	public void removeChildren(final List<LMObject> removedChildren)
	{
		handleChildren.removeChildren(removedChildren);
	}

	public void reload(final List<LMObject> children)
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
