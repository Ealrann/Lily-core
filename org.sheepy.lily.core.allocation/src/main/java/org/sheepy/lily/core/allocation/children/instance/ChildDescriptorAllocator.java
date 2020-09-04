package org.sheepy.lily.core.allocation.children.instance;

import org.sheepy.lily.core.allocation.children.manager.ChildrenInjector;
import org.sheepy.lily.core.allocation.children.util.HandleChildrenList;
import org.sheepy.lily.core.allocation.description.AllocationDescriptor;
import org.sheepy.lily.core.allocation.instance.AllocationInstance;
import org.sheepy.lily.core.api.model.ILilyEObject;

import java.util.List;
import java.util.stream.Collectors;

public final class ChildDescriptorAllocator
{
	private final AllocationDescriptor<?> descriptor;
	private final List<ChildrenInjector> injectors;

	private final HandleChildrenList handleChildren;

	public ChildDescriptorAllocator(final AllocationDescriptor<?> descriptor,
									final List<ChildrenInjector> injectors,
									final Runnable whenBranchDirty)
	{
		this.descriptor = descriptor;
		this.injectors = injectors;

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

	public void postUpdate()
	{
		final var collection = handleChildren.stream()
											 .map(ChildHandleAllocator::getMainAllocation)
											 .map(AllocationInstance::getAllocation)
											 .collect(Collectors.toUnmodifiableList());

		for (final var injector : injectors)
		{
			injector.inject(collection);
		}
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
