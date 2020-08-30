package org.sheepy.lily.core.allocation.operator.internal;

import org.sheepy.lily.core.allocation.AllocationHandle;
import org.sheepy.lily.core.allocation.operation.IOperationNode;
import org.sheepy.lily.core.allocation.operator.OperationContext;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderDescriptor;
import org.sheepy.lily.core.api.extender.IExtenderDescriptorRegistry;

import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

public final class OperationBuilder
{
	private final OperationContext context;
	private final boolean reverse;

	public OperationBuilder(final OperationContext context, final boolean reverse)
	{
		this.context = context;
		this.reverse = reverse;
	}

	public Stream<AllocationLayer> rootLayers(final Function<AllocationHandle<?>, Optional<IOperationNode>> nodeBuilder)
	{
		return IExtenderDescriptorRegistry.INSTANCE.streamDescriptors(context.target(), context.type())
												   .map(this::adaptHandle)
												   .map(nodeBuilder)
												   .flatMap(Optional::stream)
												   .map(this::newWrapper)
												   .map(Stream::of)
												   .map(stream -> new AllocationLayer(stream,
																					  context.rootContext(),
																					  true));
	}

	private AllocationHandle<?> adaptHandle(final IExtenderDescriptor<? extends IExtender> descriptor)
	{
		return (AllocationHandle<?>) context.target().extenders().adaptHandleFromDescriptor(descriptor);
	}

	public OperationWrapper newWrapper(IOperationNode node)
	{
		return new OperationWrapper(node, reverse);
	}
}
