package org.sheepy.lily.core.extender;

import org.sheepy.lily.core.api.extender.*;
import org.sheepy.lily.core.extender.util.DescriptorContextBuilder;
import org.sheepy.lily.core.extender.util.ExtenderDescriptorBuilder;

import java.lang.invoke.MethodHandles;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class ExtenderDescriptorRegistry implements IExtenderDescriptorRegistry
{
	private final List<DescriptorContext<?>> descriptors;

	public ExtenderDescriptorRegistry()
	{
		final var mapBuilder = new ExtenderMapBuilder();

		ServiceLoader.load(IExtenderProvider.class)
					 .stream()
					 .map(ServiceLoader.Provider::get)
					 .forEach(mapBuilder::append);

		final var extenderMap = mapBuilder.build();
		final var descriptorBuilder = new ExtenderDescriptorBuilder(extenderMap.lookupMap);

		descriptors = extenderMap.extenderClasses.stream()
												 .map(descriptorBuilder::build)
												 .flatMap(Optional::stream)
												 .map(DescriptorContextBuilder::build)
												 .collect(Collectors.toUnmodifiableList());
	}

	@Override
	public Stream<IExtenderDescriptor<?>> streamDescriptors()
	{
		return descriptors.stream().map(DescriptorContext::descriptor);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends IExtender> Stream<IExtenderDescriptor<T>> streamDescriptors(final IAdaptable target,
																				  final Class<T> type)
	{
		return descriptors.stream()
						  .filter(descriptor -> descriptor.descriptor().isApplicable(target))
						  .filter(descriptor -> descriptor.descriptor().match(type))
						  .map(descriptor -> ((DescriptorContext<T>) descriptor))
						  .map(DescriptorContext::descriptor);
	}

	public Stream<DescriptorContext<?>> descriptors(final IAdaptable target)
	{
		return descriptors.stream().filter(descriptor -> descriptor.descriptor().isApplicable(target));
	}

	public record ExtenderMap(Map<Module, MethodHandles.Lookup> lookupMap,
							  List<Class<? extends IExtender>> extenderClasses) {}

	private static final class ExtenderMapBuilder
	{
		private final Map<Module, MethodHandles.Lookup> lookupMap = new HashMap<>();
		private final List<Class<? extends IExtender>> extenderClasses = new ArrayList<>();

		public void append(IExtenderProvider provider)
		{
			final var module = provider.getClass().getModule();
			assert !lookupMap.containsKey(module);
			lookupMap.put(module, provider.lookup());
			extenderClasses.addAll(provider.classifiers());
		}

		public ExtenderMap build()
		{
			return new ExtenderMap(Map.copyOf(lookupMap), List.copyOf(extenderClasses));
		}
	}
}
