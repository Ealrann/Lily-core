package org.sheepy.lily.core.adapter.impl;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.adapter.reflect.ConstructorHandle;
import org.sheepy.lily.core.adapter.reflect.ExecutionHandle;
import org.sheepy.lily.core.adapter.reflect.ExecutionHandle.Builder;
import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.annotation.*;
import org.sheepy.lily.core.api.cadence.ETickerClock;
import org.sheepy.lily.core.api.util.ReflectUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

public final class AdapterInfo<T extends IAdapter>
{
	public final AdapterDomain<T> domain;

	private final ConstructorHandle<T> constructorHandle;

	public final List<ExecutionHandle.Builder> loadHandleBuilders;
	public final List<ExecutionHandle.Builder> disposeHandleBuilders;
	public final List<ExecutionHandle.Builder> observeHandleBuilders;
	public final List<TickConfiguration> tickConfigurations;
	public final List<NotifyConfiguration> notifyConfigurations;

	private final T singleton;
	private final boolean isSingleton;
	private final boolean lazy;

	public AdapterInfo(AdapterDomain<T> domain)
	{
		this.domain = domain;

		final var type = domain.type;
		final var adapterAnnotation = type.getAnnotation(Adapter.class);
		if (adapterAnnotation == null)
		{
			throwNoAdapterAnnotationError();
		}

		isSingleton = !type.isAnnotationPresent(Statefull.class);
		final var constructor = gatherConstructor();
		constructorHandle = ConstructorHandle.Builder.fromMethod(constructor).build();
		loadHandleBuilders = List.copyOf(createHandleBuilders(type, Load.class));
		disposeHandleBuilders = List.copyOf(createHandleBuilders(type, Dispose.class));
		observeHandleBuilders = List.copyOf(createHandleBuilders(type, Observe.class));

		lazy = adapterAnnotation.lazy();
		tickConfigurations = List.copyOf(buildTickerConfigurations(type));
		notifyConfigurations = List.copyOf(buildNotifyConfigurations(type));

		if (isSingleton)
		{
			singleton = createSingleton();
		}
		else
		{
			singleton = null;
		}
	}

	private List<TickConfiguration> buildTickerConfigurations(final Class<T> type)
	{
		final List<TickConfiguration> res = new ArrayList<>();
		final var tickMethods = ReflectUtils.gatherAnnotatedMethods(type, Tick.class);
		for (final var tickMethod : tickMethods)
		{
			final Tick tickAnnotation = tickMethod.annotation;
			final var tickFrequency = computeFrequency(tickAnnotation);

			final var tickPriority = tickAnnotation.priority();
			final var clock = tickAnnotation.clock();
			final var tickHandleBuilder = ExecutionHandle.Builder.fromMethod(tickMethod.method);

			final var handler = new TickConfiguration(tickHandleBuilder, tickFrequency, tickPriority, clock);
			res.add(handler);
		}
		return res;
	}

	private List<NotifyConfiguration> buildNotifyConfigurations(final Class<T> type)
	{
		final List<NotifyConfiguration> res = new ArrayList<>();
		final var notifyMethods = ReflectUtils.gatherAnnotatedMethods(type, NotifyChanged.class);
		for (final var notifyMethod : notifyMethods)
		{
			final NotifyChanged annotation = notifyMethod.annotation;

			final var featureIds = annotation.featureIds();
			final var notifyHandleBuilder = ExecutionHandle.Builder.fromMethod(notifyMethod.method);

			res.add(new NotifyConfiguration(notifyHandleBuilder, featureIds));
		}
		return res;
	}

	private static double computeFrequency(final Tick tickAnnotation)
	{
		final int frequency = tickAnnotation.frequency();
		final var frequencyRef = tickAnnotation.frequencyRef();

		return (double) frequency / frequencyRef.toSeconds(1);
	}

	private static List<ExecutionHandle.Builder> createHandleBuilders(Class<?> type,
																	  Class<? extends Annotation> annotationClass)
	{
		final List<ExecutionHandle.Builder> res = new ArrayList<>();
		final var annotatedMethods = ReflectUtils.gatherAnnotatedMethods(type, annotationClass);
		for (final var annotatedMethod : annotatedMethods)
		{
			res.add(ExecutionHandle.Builder.fromMethod(annotatedMethod.method));
		}
		return res;
	}

	private T createSingleton()
	{
		return constructorHandle.newInstance(null);
	}

	private Constructor<T> gatherConstructor()
	{
		Constructor<T> res = null;

		@SuppressWarnings("unchecked") final var constructors = (Constructor<T>[]) domain.type.getDeclaredConstructors();
		final var applicableClass = domain.targetClassifier.getInstanceClass();

		for (final var constructor : constructors)
		{
			if (isSingleton)
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
			constructorNotFoundError();
		}
		else
		{
			res.setAccessible(true);
		}

		return res;
	}

	private void constructorNotFoundError()
	{
		final String message = "The class [%s] should define a public constructor with no paramters, " + "or (if statefull), a constructor with one parameter, typed with the applicable class";
		final String errorMessage = String.format(message, domain.type.getSimpleName());
		throw new IllegalStateException(errorMessage);
	}

	private void throwNoAdapterAnnotationError() throws AssertionError
	{
		final String adapterName = domain.type.getSimpleName();
		final String annotationName = Adapter.class.getSimpleName();
		final String message = "The class [%s] is not annoted with @%s";
		final String errorMessage = String.format(message, adapterName, annotationName);
		throw new IllegalStateException(errorMessage);
	}

	public T create(EObject target)
	{
		if (isSingleton == true)
		{
			return singleton;
		}
		else
		{
			return constructorHandle.newInstance(target);
		}
	}

	public boolean isAutoAdapter()
	{
		return observeHandleBuilders.isEmpty() == false || tickConfigurations.isEmpty() == false || lazy == false || (isSingleton && notifyConfigurations
				.isEmpty() == false);
	}

	public static final class NotifyConfiguration
	{
		public final Builder notifyHandleBuilder;
		public final int[] featureIds;

		public NotifyConfiguration(ExecutionHandle.Builder notifyHandleBuilder, int[] featureIds)
		{
			this.notifyHandleBuilder = notifyHandleBuilder;
			this.featureIds = featureIds;
		}
	}

	public static final class TickConfiguration
	{
		public final ExecutionHandle.Builder tickHandleBuilder;
		public final Double tickFrequency;
		public final Integer tickPriority;
		public final ETickerClock clock;

		public TickConfiguration(ExecutionHandle.Builder tickHandleBuilder,
								 Double tickFrequency,
								 Integer tickPriority,
								 ETickerClock clock)
		{
			this.tickHandleBuilder = tickHandleBuilder;
			this.tickFrequency = tickFrequency;
			this.tickPriority = tickPriority;
			this.clock = clock;
		}
	}
}
