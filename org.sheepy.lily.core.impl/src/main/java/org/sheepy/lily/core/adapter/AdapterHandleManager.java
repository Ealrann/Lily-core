package org.sheepy.lily.core.adapter;

import org.sheepy.lily.core.adapter.description.AdapterDescriptor;
import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.IAdapterRegistry;
import org.sheepy.lily.core.api.adapter.ILilyEObject;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class AdapterHandleManager
{
	private static final AdapterRegistry REGISTRY = (AdapterRegistry) IAdapterRegistry.INSTANCE;
	private static final String ADAPTER_CREATION_LOOP = "Adapter creation loop: ";

	private final Deque<AdapterDescriptor<?>> constructingAdapters = new ArrayDeque<>();

	private boolean constructing = false;

	public List<AdapterHandle<?>> buildAutoAdapters(ILilyEObject target)
	{
		final List<AdapterHandle<?>> res = new ArrayList<>();
		final var autoAdapters = REGISTRY.getDefinitionsFor(target);
		for (int i = 0; i < autoAdapters.size(); i++)
		{
			final var descriptor = autoAdapters.get(i);
			if (!descriptor.domain.lazy)
			{
				final var handle = createHandle(target, descriptor, false);
				res.add(handle);
			}
		}
		return res;
	}

	public <T extends IAdapter> AdapterHandle<T> createHandle(ILilyEObject target, Class<T> type, boolean load)
	{
		final var descriptor = REGISTRY.getDescriptorFor(target, type);
		if (descriptor != null)
		{
			return createHandle(target, descriptor, load);
		}
		else
		{
			return null;
		}
	}

	private <T extends IAdapter> AdapterHandle<T> createHandle(ILilyEObject target,
															   final AdapterDescriptor<T> descriptor,
															   boolean load)
	{
		if (constructing && constructingAdapters.contains(descriptor))
		{
			throwAdapterCreationLoopException();
		}

		constructing = true;
		constructingAdapters.addLast(descriptor);

		final var handle = descriptor.handleBuilder.build(target);

		if (constructingAdapters.removeLast() != descriptor) throwBadError();
		constructing = !constructingAdapters.isEmpty();

		return handle;
	}

	private void throwAdapterCreationLoopException() throws AssertionError
	{
		final var classLoop = constructingAdapters.stream()
												  .map(n -> n.domain.type.getSimpleName())
												  .collect(Collectors.joining(", "));

		throw new AssertionError(ADAPTER_CREATION_LOOP + classLoop);
	}

	private static void throwBadError() throws AssertionError
	{
		throw new AssertionError("Something went really wrong");
	}
}
