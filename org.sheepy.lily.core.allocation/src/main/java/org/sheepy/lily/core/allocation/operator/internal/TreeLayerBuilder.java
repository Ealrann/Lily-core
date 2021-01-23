package org.sheepy.lily.core.allocation.operator.internal;

import org.logoce.extender.api.IAdapter;
import org.logoce.extender.api.IAdapterDescriptor;
import org.logoce.extender.api.IAdapterDescriptorRegistry;
import org.sheepy.lily.core.allocation.AllocationHandle;
import org.sheepy.lily.core.allocation.operation.IOperation;
import org.sheepy.lily.core.allocation.operator.OperationContext;
import org.sheepy.lily.core.allocation.treeiterator.AllocationTreeIterator;

import java.util.Optional;
import java.util.function.Function;

public final class TreeLayerBuilder
{
	private final OperationContext context;
	private final boolean reverse;

	public TreeLayerBuilder(final OperationContext context, final boolean reverse)
	{
		this.context = context;
		this.reverse = reverse;
	}

	public <T extends AllocationTreeIterator<T>> ILayer<T> rootLayer(final Function<AllocationHandle<?>, Optional<? extends IOperation<T>>> operationBuilder)
	{
		final var stream = IAdapterDescriptorRegistry.INSTANCE.streamDescriptors(context.target(), context.type())
															  .map(this::adaptHandle)
															  .map(operationBuilder)
															  .flatMap(Optional::stream)
															  .map(this::newWrapper);

		return new RootLayer<>(stream.iterator(), context.rootContext());
	}

	private AllocationHandle<?> adaptHandle(final IAdapterDescriptor<? extends IAdapter> descriptor)
	{
		return (AllocationHandle<?>) context.target()
											.adapterManager()
											.adaptHandle(descriptor);
	}

	private <T extends AllocationTreeIterator<T>> OperationWrapper<T> newWrapper(IOperation<T> operation)
	{
		final var operationWrapper = new OperationWrapper<T>(reverse);
		operationWrapper.load(operation);
		return operationWrapper;
	}
}
