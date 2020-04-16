package org.sheepy.lily.core.adapter.description;

import org.sheepy.lily.core.adapter.AdapterHandle;
import org.sheepy.lily.core.adapter.annotation.AnnotationHandles;
import org.sheepy.lily.core.adapter.reflect.ExecutionHandleBuilder;
import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.IAdapterAnnotationService;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.NotifyChanged;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.util.ReflectUtils;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public final class AdapterDescriptor<T extends IAdapter>
{
	public final AdapterDomain<T> domain;
	public final AdapterHandle.Builder<T> handleBuilder;

	public AdapterDescriptor(AdapterDomain<T> domain, AdapterHandle.Builder<T> handleBuilder)
	{
		this.domain = domain;
		this.handleBuilder = handleBuilder;
	}

	public boolean isNamedAdapter()
	{
		return domain.targetName.isEmpty() == false;
	}

	public static final class Builder
	{
		private final Collection<IAdapterAnnotationService<?, ?>> annotationServices;

		public Builder(Collection<IAdapterAnnotationService<?, ?>> annotationServices)
		{
			this.annotationServices = annotationServices;
		}

		public <T extends IAdapter> AdapterDescriptor<T> build(Class<T> type)
		{
			final var adapterAnnotation = type.getAnnotation(Adapter.class);
			if (adapterAnnotation == null) throwNoAdapterAnnotationError(type);

			final boolean isSingleton = !type.isAnnotationPresent(Statefull.class);
			final var handleBuilders = List.copyOf(buildAnnotationHandleBuilders(annotationServices, type));
			final var forceLoad = handleBuilders.stream()
												.map(b -> b.service)
												.anyMatch(IAdapterAnnotationService::forceLoadIfAnnotated);
			final var notifyConfigurations = List.copyOf(buildNotifyConfigurations(type));
			final var domain = AdapterDomain.Builder.build(type,
														   adapterAnnotation,
														   isSingleton,
														   forceLoad,
														   notifyConfigurations);
			final var handleBuilder = AdapterHandle.Builder.BuilderBuilder.build(type,
																				 isSingleton,
																				 handleBuilders,
																				 notifyConfigurations,
																				 domain);

			return new AdapterDescriptor<T>(domain, handleBuilder);
		}

		private static List<NotifyConfiguration> buildNotifyConfigurations(final Class<?> type)
		{
			final List<NotifyConfiguration> res = new ArrayList<>();
			final var notifyMethods = ReflectUtils.gatherAnnotatedMethods(type, NotifyChanged.class);
			for (final var notifyMethod : notifyMethods)
			{
				final NotifyChanged annotation = notifyMethod.annotation;

				final var featureIds = annotation.featureIds();
				final var notifyHandleBuilder = ExecutionHandleBuilder.fromMethod(notifyMethod.method);

				res.add(new NotifyConfiguration(notifyHandleBuilder, featureIds));
			}
			return res;
		}

		private static void throwNoAdapterAnnotationError(Class<?> type) throws IllegalStateException
		{
			final String adapterName = type.getSimpleName();
			final String annotationName = Adapter.class.getSimpleName();
			final String message = "The class [%s] is not annoted with @%s";
			final String errorMessage = String.format(message, adapterName, annotationName);
			throw new IllegalStateException(errorMessage);
		}

		private static Collection<AnnotationHandles.Builder<?, ?>> buildAnnotationHandleBuilders(Collection<? extends IAdapterAnnotationService<?, ?>> services,
																								 Class<?> adapterClass)
		{
			final List<AnnotationHandles.Builder<?, ?>> builders = new ArrayList<>();
			for (var service : services)
			{
				final var builder = constructBuilder(service, adapterClass);
				builder.ifPresent(builders::add);
			}
			return List.copyOf(builders);
		}

		private static <T extends Annotation> Optional<AnnotationHandles.Builder<T, ?>> constructBuilder(final IAdapterAnnotationService<T, ?> service,
																										 final Class<?> adapterClass)
		{
			final var annotationClass = service.annotationClass();
			final var annotatedMethods = ReflectUtils.gatherAnnotatedMethods(adapterClass, annotationClass);
			if (annotatedMethods.isEmpty() == false)
			{
				return Optional.of(new AnnotationHandles.Builder<>(service, annotatedMethods));
			}
			else
			{
				return Optional.empty();
			}
		}
	}
}
