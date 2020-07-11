package org.sheepy.lily.core.allocation.children.util;

import org.sheepy.lily.core.allocation.AllocationHandle;
import org.sheepy.lily.core.allocation.EAllocationStatus;
import org.sheepy.lily.core.allocation.children.instance.ChildInstanceAllocator;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.util.IModelExplorer;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public final class AllocationChildrenListUpdater
{
	private final Runnable whenBranchDirty;
	private final Optional<Consumer<EAllocationStatus>> listener;
	private final IModelExplorer modelExplorer;

	public AllocationChildrenListUpdater(Runnable whenBranchDirty,
										 Optional<Consumer<EAllocationStatus>> listener,
										 IModelExplorer modelExplorer)
	{
		this.whenBranchDirty = whenBranchDirty;
		this.listener = listener;
		this.modelExplorer = modelExplorer;
	}

	public void updateAllocationList(LinkedList<ChildAllocationContainer> listToUpdate, final ILilyEObject source)
	{
		final var modelIterator = modelExplorer.stream(source).iterator();
		final var listIterator = listToUpdate.listIterator();

		while (modelIterator.hasNext())
		{
			final var currentElement = modelIterator.next();
			if (listIterator.hasNext())
			{
				if (listIterator.next().target() != currentElement)
				{
					listIterator.previous();
					listIterator.add(buildAllocationContainer(currentElement));
				}
			}
			else
			{
				listIterator.add(buildAllocationContainer(currentElement));
			}
		}
	}

	private ChildAllocationContainer buildAllocationContainer(ILilyEObject target)
	{
		final List<ChildInstanceAllocator<? extends IExtender>> containers = target.adapters()
																				   .adaptHandlesOfType(AllocationHandle.class)
																				   .map(handle -> (AllocationHandle<?>) handle)
																				   .map(this::newChildContainer)
																				   .collect(Collectors.toUnmodifiableList());
		return new ChildAllocationContainer(target, containers);
	}

	private ChildInstanceAllocator<? extends IExtender> newChildContainer(AllocationHandle<?> handle)
	{
		return new ChildInstanceAllocator<>(handle, whenBranchDirty, listener);
	}
}