package org.sheepy.lily.core.adapter;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.adapter.annotation.AnnotationHandles;
import org.sheepy.lily.core.adapter.description.AdapterDomain;
import org.sheepy.lily.core.adapter.description.NotifyConfiguration;
import org.sheepy.lily.core.adapter.reflect.ConstructorHandle;
import org.sheepy.lily.core.adapter.reflect.ExecutionHandleBuilder;
import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.ILilyEObject;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.Load;
import org.sheepy.lily.core.api.adapter.annotation.Observe;
import org.sheepy.lily.core.api.notification.observatory.IObservatory;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.core.api.util.ExecutionHandle;
import org.sheepy.lily.core.api.util.ReflectUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public final class AdapterHandle<T extends IAdapter>
{
	public final T adapter;
	public final List<ExecutionHandle> observeHandles;
	public final List<NotifyHandle> notifyHandles;
	public final List<AnnotationHandles<?>> annotationHandles;
	private final List<ExecutionHandle> loadHandles;
	private final List<ExecutionHandle> disposeHandles;

	private boolean loaded = false;
	private IObservatory observatory = null;

	public AdapterHandle(T adapter,
						 List<ExecutionHandle> loadHandles,
						 List<ExecutionHandle> disposeHandles,
						 List<ExecutionHandle> observeHandles,
						 List<NotifyHandle> notifyHandles,
						 List<AnnotationHandles<?>> annotationHandles)
	{
		this.adapter = adapter;
		this.loadHandles = List.copyOf(loadHandles);
		this.disposeHandles = List.copyOf(disposeHandles);
		this.observeHandles = List.copyOf(observeHandles);
		this.notifyHandles = List.copyOf(notifyHandles);
		this.annotationHandles = List.copyOf(annotationHandles);
	}

	public void load(ILilyEObject target)
	{
		if (loaded == false)
		{
			final var observatoryBuilder = buildObservatory();

			for (final var loadHandle : loadHandles)
			{
				loadHandle.invoke(target);
			}

			if (!observatoryBuilder.isEmpty())
			{
				observatory = observatoryBuilder.build();
				observatory.observe(target);
			}
			loaded = true;
		}
	}

	public void dispose(ILilyEObject target)
	{
		if (loaded)
		{
			if (observatory != null)
			{
				observatory.shut(target);
				observatory = null;
			}

			for (final var disposeHandle : disposeHandles)
			{
				disposeHandle.invoke(target);
			}
			loaded = false;
		}
	}

	private IObservatoryBuilder buildObservatory()
	{
		final var observatoryBuilder = IObservatoryBuilder.newObservatoryBuilder();
		for (final var observeHandle : observeHandles)
		{
			observeHandle.invoke(observatoryBuilder);
		}
		return observatoryBuilder;
	}

	public boolean isAdapterForType(final Class<? extends IAdapter> type)
	{
		return type.isAssignableFrom(adapter.getClass());
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
		private final List<ExecutionHandleBuilder> loadHandleBuilders;
		private final List<ExecutionHandleBuilder> disposeHandleBuilders;
		private final List<ExecutionHandleBuilder> observeHandleBuilders;
		private final List<NotifyConfiguration> notifyConfigurations;
		private final List<AnnotationHandles.Builder<?, ?>> annotationHandleBuilders;

		public Builder(boolean isSingleton,
					   ConstructorHandle<T> constructorHandle,
					   List<ExecutionHandleBuilder> loadHandleBuilders,
					   List<ExecutionHandleBuilder> disposeHandleBuilders,
					   List<ExecutionHandleBuilder> observeHandleBuilders,
					   List<NotifyConfiguration> notifyConfigurations,
					   List<AnnotationHandles.Builder<?, ?>> annotationHandleBuilders)
		{
			this.constructorHandle = constructorHandle;
			this.loadHandleBuilders = loadHandleBuilders;
			this.disposeHandleBuilders = disposeHandleBuilders;
			this.observeHandleBuilders = observeHandleBuilders;
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
			final var loadHandles = List.copyOf(createHandles(loadHandleBuilders, adapter));
			final var disposeHandles = List.copyOf(createHandles(disposeHandleBuilders, adapter));
			final var observeHandles = List.copyOf(createHandles(observeHandleBuilders, adapter));
			final var notifyHandles = List.copyOf(buildNotifyHandles(adapter));
			final var annotationHandles = List.copyOf(createAnnotationHandleContainers(adapter, target));

			return new AdapterHandle<>(adapter,
									   loadHandles,
									   disposeHandles,
									   observeHandles,
									   notifyHandles,
									   annotationHandles);
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

		private List<ExecutionHandle> createHandles(List<ExecutionHandleBuilder> builders, T adapter)
		{
			final List<ExecutionHandle> res = new ArrayList<>();
			for (final var builder : builders)
			{
				res.add(builder.build(adapter));
			}

			return res;
		}

		public static final class BuilderBuilder
		{
			public static <T extends IAdapter> AdapterHandle.Builder<T> build(final Class<T> type,
																			  final boolean isSingleton,
																			  final List<AnnotationHandles.Builder<?, ?>> handleBuilders,
																			  final List<NotifyConfiguration> notifyConfigurations,
																			  final AdapterDomain<T> domain)
			{
				final var constructor = gatherConstructor(domain, isSingleton);
				final var constructorHandle = ConstructorHandle.Builder.fromMethod(constructor).build();
				final var loadHandleBuilders = List.copyOf(createHandleBuilders(type, Load.class));
				final var disposeHandleBuilders = List.copyOf(createHandleBuilders(type, Dispose.class));
				final var observeHandleBuilders = List.copyOf(createHandleBuilders(type, Observe.class));

				return new AdapterHandle.Builder<>(isSingleton,
												   constructorHandle,
												   loadHandleBuilders,
												   disposeHandleBuilders,
												   observeHandleBuilders,
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

			private static List<ExecutionHandleBuilder> createHandleBuilders(Class<?> type,
																			 Class<? extends Annotation> annotationClass)
			{
				final List<ExecutionHandleBuilder> res = new ArrayList<>();
				final var annotatedMethods = ReflectUtils.gatherAnnotatedMethods(type, annotationClass);
				for (final var annotatedMethod : annotatedMethods)
				{
					res.add(ExecutionHandleBuilder.fromMethod(annotatedMethod.method));
				}
				return res;
			}
		}
	}
}
