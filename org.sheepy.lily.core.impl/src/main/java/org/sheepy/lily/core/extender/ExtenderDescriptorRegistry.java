package org.sheepy.lily.core.extender;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.api.extender.*;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.extender.util.ExtenderDescriptorBuilder;

import java.lang.annotation.Annotation;
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
												 .map(DescriptorContext::new)
												 .collect(Collectors.toUnmodifiableList());
	}

	@Override
	public Stream<IExtenderDescriptor<?>> streamDescriptors()
	{
		return descriptors.stream().map(DescriptorContext::descriptor);
	}

	@Override
	public Stream<IExtenderDescriptor<?>> streamDescriptors(final EObject target)
	{
		return descriptors(target).map(DescriptorContext::descriptor);
	}

	@Override
	public <T extends IExtender> Stream<IExtenderDescriptor<T>> streamDescriptors(final EObject target,
																				  final Class<T> type)
	{
		return descriptors(target, type).map(DescriptorContext::descriptor);
	}

	public Stream<DescriptorContext<?>> descriptors(final EObject target)
	{
		return descriptors.stream().filter(descriptor -> descriptor.descriptor.isApplicable(target));
	}

	@SuppressWarnings("unchecked")
	public <T extends IExtender> Stream<DescriptorContext<T>> descriptors(final EObject target, final Class<T> type)
	{
		return descriptors.stream()
						  .filter(descriptor -> descriptor.descriptor.isExtenderForType(type))
						  .filter(descriptor -> descriptor.descriptor.isApplicable(target))
						  .map(descriptor -> ((DescriptorContext<T>) descriptor));
	}

	@SuppressWarnings("unchecked")
	public <T extends IExtender> Optional<DescriptorContext<T>> getWrapper(final IExtenderDescription<T> descriptor)
	{
		return descriptors.stream()
						  .filter(wrapper -> wrapper.descriptor == descriptor)
						  .findAny()
						  .map(wrapper -> (DescriptorContext<T>) wrapper);
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

	public static record DescriptorContext<T extends IExtender>(IExtenderDescriptor<T> descriptor,
																IExtenderHandleBuilder<T> handleBuilder)
	{
		public DescriptorContext(ExtenderDescriptor<T> descriptor)
		{
			this(descriptor, newBuilder(descriptor));
		}

		public IExtenderHandle<T> newHandle(ILilyEObject target)
		{
			return handleBuilder.build(target);
		}

		public boolean isAuto()
		{
			return handleBuilder.isAuto();
		}

		private static <T extends IExtender> IExtenderHandleBuilder<T> newBuilder(final ExtenderDescriptor<T> descriptor)
		{
			for (var factory : IExtenderHandleFactory.FACTORIES)
			{
				final Class<? extends Annotation> factoryAnnotation = factory.describedBy();
				if (descriptor.containsClassAnnotation(factoryAnnotation))
				{
					return factory.newBuilder(descriptor);
				}
			}
			return null;
		}
	}
}
