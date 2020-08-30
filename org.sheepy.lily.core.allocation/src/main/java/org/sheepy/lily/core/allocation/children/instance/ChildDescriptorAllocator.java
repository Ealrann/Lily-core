package org.sheepy.lily.core.allocation.children.instance;

import org.sheepy.lily.core.allocation.AllocationHandle;
import org.sheepy.lily.core.allocation.children.manager.ChildrenInjector;
import org.sheepy.lily.core.allocation.children.util.HandleChildrenList;
import org.sheepy.lily.core.allocation.description.AllocationDescriptor;
import org.sheepy.lily.core.allocation.instance.AllocationInstance;
import org.sheepy.lily.core.allocation.operation.IOperationNode;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.model.ILilyEObject;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
		final var extenderDescriptor = descriptor.extenderDescriptor();
		final var handleStream = children.stream()
										 .filter(extenderDescriptor::isApplicable)
										 .map(ILilyEObject::extenders)
										 .map(e -> e.adaptHandleFromDescriptor(extenderDescriptor))
										 .map(h -> (AllocationHandle<?>) h);

		handleChildren.reload(handleStream);
	}

	public Stream<IOperationNode> prepareTriage(final boolean forceTriage)
	{
		return handleChildren.prepareTriage(forceTriage);
	}

	public Stream<IOperationNode> prepareCleanup(final boolean free)
	{
		return handleChildren.prepareCleanup(free);
	}

	public Stream<IOperationNode> prepareUpdate()
	{
		final var updateStream = handleChildren.prepareUpdate();
		final var injectionStream = prepareInjection();

		return Stream.concat(updateStream, injectionStream);
	}

	private Stream<IOperationNode> prepareInjection()
	{
		final var childrenCollector = new ChildrenCollector();
		return injectors.stream().map(injector -> injector.prepareInjection(childrenCollector));
	}

	public AllocationDescriptor<?> descriptor()
	{
		return descriptor;
	}

	private final class ChildrenCollector implements Supplier<List<IExtender>>
	{
		private boolean collected = false;
		private List<IExtender> collection;

		@Override
		public List<IExtender> get()
		{
			if (collected == false) collect();
			return collection;
		}

		private void collect()
		{
			collection = handleChildren.stream()
									   .map(ChildHandleAllocator::getMainAllocation)
									   .map(AllocationInstance::getAllocation)
									   .collect(Collectors.toUnmodifiableList());
			collected = true;
		}
	}
}
