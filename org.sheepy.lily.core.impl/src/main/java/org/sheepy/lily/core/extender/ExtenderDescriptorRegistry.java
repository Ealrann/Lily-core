package org.sheepy.lily.core.extender;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.api.extender.*;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.extender.util.ExtenderDescriptorBuilder;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ServiceLoader;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class ExtenderDescriptorRegistry implements IExtenderDescriptorRegistry
{
	private static final List<IExtenderProvider> ADAPTERS = ServiceLoader.load(IExtenderProvider.class)
																		 .stream()
																		 .map(ServiceLoader.Provider::get)
																		 .collect(Collectors.toList());

	private final List<DescriptorWraper<?>> descriptors = new ArrayList<>();

	public ExtenderDescriptorRegistry()
	{
		for (final var adapters : ADAPTERS)
		{
			for (final var adapterClass : adapters.classifiers())
			{
				createDescriptor(adapterClass);
			}
		}
	}

	public void register(Class<? extends IExtender> classifier)
	{
		createDescriptor(classifier);
	}

	private void createDescriptor(final Class<? extends IExtender> extenderClass)
	{
		try
		{
			final var descriptor = ExtenderDescriptorBuilder.build(extenderClass);
			descriptors.add(new DescriptorWraper<>(descriptor));
		}
		catch (ReflectiveOperationException e)
		{
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public <T extends IExtender> Stream<DescriptorWraper<T>> descriptors(final EObject target, final Class<T> type)
	{
		return descriptors.stream()
						  .filter(descriptor -> descriptor.descriptor.isExtenderForType(type))
						  .filter(descriptor -> descriptor.descriptor.isApplicable(target))
						  .map(descriptor -> ((DescriptorWraper<T>) descriptor));
	}

	@Override
	public Stream<IExtenderDescriptor<?>> streamDescriptors(final EObject target)
	{
		return descriptors.stream()
						  .filter(descriptor -> descriptor.descriptor.isApplicable(target))
						  .map(d -> d.descriptor);
	}

	@Override
	public Stream<IExtenderDescriptor<?>> streamDescriptors()
	{
		return descriptors.stream().map(d -> d.descriptor);
	}

	public Stream<DescriptorWraper<?>> descriptors(final EObject target)
	{
		return descriptors.stream().filter(descriptor -> descriptor.descriptor.isApplicable(target));
	}

	@SuppressWarnings("unchecked")
	public <T extends IExtender> Optional<DescriptorWraper<T>> getWrapper(final IExtenderDescriptor<T> descriptor)
	{
		return descriptors.stream()
						  .filter(wrapper -> wrapper.descriptor == descriptor)
						  .findAny()
						  .map(wrapper -> (DescriptorWraper<T>) wrapper);
	}

	public static record DescriptorWraper<T extends IExtender>(IExtenderDescriptor<T>descriptor,
															   IExtenderHandleBuilder<T>builder)
	{
		public DescriptorWraper(IExtenderDescriptor<T> descriptor)
		{
			this(descriptor, newBuilder(descriptor));
		}

		public IExtenderHandle<T> newHandle(ILilyEObject target)
		{
			return builder.build(target);
		}

		public boolean isAuto()
		{
			return builder.isAuto();
		}

		private static <T extends IExtender> IExtenderHandleBuilder<T> newBuilder(final IExtenderDescriptor<T> descriptor)
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
