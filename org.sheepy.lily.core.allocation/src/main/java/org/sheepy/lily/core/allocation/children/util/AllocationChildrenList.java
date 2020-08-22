package org.sheepy.lily.core.allocation.children.util;

import org.sheepy.lily.core.allocation.AllocationHandle;
import org.sheepy.lily.core.allocation.EAllocationStatus;
import org.sheepy.lily.core.allocation.children.instance.ChildInstanceAllocator;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.util.IModelExplorer;
import org.sheepy.lily.core.api.util.StreamUtil;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class AllocationChildrenList
{
	private final Runnable whenBranchDirty;
	private final Optional<Consumer<EAllocationStatus>> listener;
	private final IModelExplorer modelExplorer;
	private final LinkedList<ChildInstanceAllocators> children = new LinkedList<>();

	public AllocationChildrenList(Runnable whenBranchDirty,
								  Optional<Consumer<EAllocationStatus>> listener,
								  IModelExplorer modelExplorer)
	{
		this.whenBranchDirty = whenBranchDirty;
		this.listener = listener;
		this.modelExplorer = modelExplorer;
	}

	public void updateAllocationList(final ILilyEObject source)
	{
		final var modelIterator = modelExplorer.stream(source).iterator();
		final var listIterator = children.listIterator();

		while (modelIterator.hasNext())
		{
			final var currentElement = modelIterator.next();
			if (listIterator.hasNext())
			{
				final var currentChild = listIterator.next();
				if (currentChild.target() != currentElement)
				{
					listIterator.set(buildAllocationContainer(currentElement));
					listIterator.add(currentChild);
				}
			}
			else
			{
				listIterator.add(buildAllocationContainer(currentElement));
			}
		}
	}

	public void remove(ChildInstanceAllocators child)
	{
		children.remove(child);
	}

	public void clear()
	{
		children.clear();
	}

	private ChildInstanceAllocators buildAllocationContainer(ILilyEObject target)
	{
		final List<ChildInstanceAllocator<? extends IExtender>> containers = target.extenders()
																				   .adaptHandlesOfType(AllocationHandle.class)
																				   .map(handle -> (AllocationHandle<?>) handle)
																				   .map(this::newChildContainer)
																				   .collect(Collectors.toUnmodifiableList());
		return new ChildInstanceAllocators(target, containers);
	}

	private ChildInstanceAllocator<? extends IExtender> newChildContainer(AllocationHandle<?> handle)
	{
		return new ChildInstanceAllocator<>(handle, whenBranchDirty, listener);
	}

	public Stream<ChildInstanceAllocators> stream()
	{
		return children.stream();
	}

	public Stream<ChildInstanceAllocator<?>> streamInstanceAllocators()
	{
		return stream().flatMap(ChildInstanceAllocators::stream);
	}

	public Stream<ChildInstanceAllocators> reverseStream()
	{
		return StreamUtil.reverseStreamFromDeque(children);
	}
}
