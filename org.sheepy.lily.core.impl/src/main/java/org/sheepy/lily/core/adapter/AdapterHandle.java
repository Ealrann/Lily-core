package org.sheepy.lily.core.adapter;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.adapter.annotation.AnnotationHandles;
import org.sheepy.lily.core.adapter.description.AdapterDomain;
import org.sheepy.lily.core.adapter.description.NotifyConfiguration;
import org.sheepy.lily.core.adapter.load.AdapterDisposeHandle;
import org.sheepy.lily.core.adapter.load.AdapterLoadHandle;
import org.sheepy.lily.core.adapter.observation.AdapterObservatory;
import org.sheepy.lily.core.adapter.observation.AdapterObserveHandle;
import org.sheepy.lily.core.adapter.reflect.ConstructorHandle;
import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.IAdapterAnnotationHandle;
import org.sheepy.lily.core.api.adapter.ILilyEObject;
import org.sheepy.lily.core.api.util.ExecutionHandle;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public final class AdapterHandle<T extends IAdapter>
{
	public final T adapter;
	public final List<NotifyHandle> notifyHandles;
	public final List<AnnotationHandles<?>> annotationHandles;
	private final AdapterObservatory observatory;

	private boolean loaded = false;

	public AdapterHandle(T adapter, List<NotifyHandle> notifyHandles, List<AnnotationHandles<?>> annotationHandles)
	{
		this.adapter = adapter;
		this.notifyHandles = List.copyOf(notifyHandles);
		this.annotationHandles = List.copyOf(annotationHandles);
		observatory = annotationHandlesOf(AdapterObserveHandle.class).map(AdapterObservatory::new).orElse(null);
	}

	public void load(ILilyEObject target)
	{
		if (loaded == false)
		{
			callHandles(AdapterLoadHandle.class, handle -> handle.load(target));
			if (observatory != null) observatory.observe(target);
			loaded = true;
		}
	}

	public void dispose(ILilyEObject target)
	{
		if (loaded)
		{
			if (observatory != null) observatory.shut(target);
			callHandles(AdapterDisposeHandle.class, handle -> handle.dispose(target));
			loaded = false;
		}
	}

	public boolean isAdapterForType(final Class<? extends IAdapter> type)
	{
		return type.isAssignableFrom(adapter.getClass());
	}

	private <Y extends IAdapterAnnotationHandle> void callHandles(final Class<Y> classifier, final Consumer<Y> action)
	{
		annotationHandlesOf(classifier).ifPresent(handles -> handles.call(action));
	}

	private <Y extends IAdapterAnnotationHandle> Optional<AnnotationHandles<Y>> annotationHandlesOf(Class<Y> type)
	{
		for (var handleContainer : annotationHandles)
		{
			if (handleContainer.type == type)
			{
				@SuppressWarnings("unchecked") final var castHandle = (AnnotationHandles<Y>) handleContainer;
				return Optional.of(castHandle);
			}
		}
		return Optional.empty();
	}

	public static final class NotifyHandle implements Consumer<Notification>
	{
		public final ExecutionHandle handle;
		public final int[] featureIds;

		public <T extends IAdapter> NotifyHandle(NotifyConfiguration notifyConfig, T adapter)
		{
			featureIds = notifyConfig.featureIds;
			handle = notifyConfig.notifyHandleBuilder.build(adapter);
		}

		@Override
		public void accept(Notification notification)
		{
			handle.invoke(notification, notification.getNotifier());
		}
	}

	public static final class Builder<T extends IAdapter>
	{
		private final T singleton;
		private final ConstructorHandle<T> constructorHandle;
		private final List<NotifyConfiguration> notifyConfigurations;
		private final List<AnnotationHandles.Builder<?, ?>> annotationHandleBuilders;

		public Builder(boolean isSingleton,
					   ConstructorHandle<T> constructorHandle,
					   List<NotifyConfiguration> notifyConfigurations,
					   List<AnnotationHandles.Builder<?, ?>> annotationHandleBuilders)
		{
			this.constructorHandle = constructorHandle;
			this.notifyConfigurations = notifyConfigurations;
			this.annotationHandleBuilders = annotationHandleBuilders;
			this.singleton = isSingleton ? createSingleton() : null;
		}

		private T createSingleton()
		{
			return constructorHandle.newInstance(null);
		}

		public AdapterHandle<T> build(final ILilyEObject target)
		{
			final var adapter = instantiateAdapter(target);
			final var notifyHandles = List.copyOf(buildNotifyHandles(adapter));
			final var annotationHandles = List.copyOf(createAnnotationHandleContainers(adapter, target));

			return new AdapterHandle<>(adapter, notifyHandles, annotationHandles);
		}

		public T instantiateAdapter(EObject target)
		{
			if (singleton != null)
			{
				return singleton;
			}
			else
			{
				return constructorHandle.newInstance(target);
			}
		}

		private List<AnnotationHandles<?>> createAnnotationHandleContainers(T adapter, final ILilyEObject target)
		{
			final List<AnnotationHandles<?>> annotationHandles = new ArrayList<>();
			for (var annotationHandleBuilder : annotationHandleBuilders)
			{
				annotationHandles.add(annotationHandleBuilder.build(target, adapter));
			}
			return annotationHandles;
		}

		private List<AdapterHandle.NotifyHandle> buildNotifyHandles(T adapter)
		{
			final List<AdapterHandle.NotifyHandle> res = new ArrayList<>();

			for (final var notifyConfig : notifyConfigurations)
			{
				res.add(new AdapterHandle.NotifyHandle(notifyConfig, adapter));
			}

			return res;
		}

		public static final class BuilderBuilder
		{
			public static <T extends IAdapter> AdapterHandle.Builder<T> build(final boolean isSingleton,
																			  final List<AnnotationHandles.Builder<?, ?>> handleBuilders,
																			  final List<NotifyConfiguration> notifyConfigurations,
																			  final AdapterDomain<T> domain)
			{
				final var constructor = gatherConstructor(domain, isSingleton);
				final var constructorHandle = ConstructorHandle.Builder.fromMethod(constructor).build();
				return new AdapterHandle.Builder<>(isSingleton,
												   constructorHandle,
												   notifyConfigurations,
												   handleBuilders);
			}

			private static <T extends IAdapter> Constructor<T> gatherConstructor(AdapterDomain<T> domain,
																				 boolean singleton)
			{
				Constructor<T> res = null;

				@SuppressWarnings("unchecked") final var constructors = (Constructor<T>[]) domain.type.getDeclaredConstructors();
				final var applicableClass = domain.targetClassifier.getInstanceClass();

				for (final var constructor : constructors)
				{
					if (singleton)
					{
						if (constructor.getParameterCount() == 0)
						{
							res = constructor;
							break;
						}
					}
					else
					{
						if (constructor.getParameterCount() == 1)
						{
							final Parameter parameter = constructor.getParameters()[0];
							if (parameter.getType().isAssignableFrom(applicableClass))
							{
								res = constructor;
								break;
							}
						}
						else if (constructor.getParameterCount() == 0)
						{
							res = constructor;
							break;
						}
					}
				}

				if (res == null)
				{
					constructorNotFoundError(domain.type);
				}
				else
				{
					res.setAccessible(true);
				}

				return res;
			}

			private static void constructorNotFoundError(Class<?> type)
			{
				final String message = "The class [%s] should define a public constructor with no paramters, " +
									   "or (if statefull), a constructor with one parameter, typed with the applicable class";
				final String errorMessage = String.format(message, type.getSimpleName());
				throw new IllegalStateException(errorMessage);
			}
		}
	}
}
