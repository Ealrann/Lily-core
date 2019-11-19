package org.sheepy.lily.core.adapter.impl;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.adapter.reflect.ConstructorHandle;
import org.sheepy.lily.core.adapter.reflect.ExecutionHandle;
import org.sheepy.lily.core.adapter.reflect.ExecutionHandle.Builder;
import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.Load;
import org.sheepy.lily.core.api.adapter.annotation.NotifyChanged;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.adapter.annotation.Tick;
import org.sheepy.lily.core.api.cadence.ETickerClock;
import org.sheepy.lily.core.api.util.ReflectUtils;

public final class AdapterInfo<T extends IAdapter>
{
	public final AdapterDomain<T> domain;

	private final ConstructorHandle<T> constructorHandle;

	public final ExecutionHandle.Builder loadHandleBuilder;
	public final ExecutionHandle.Builder disposeHandleBuilder;

	private final T singleton;
	private final boolean isSingleton;
	private final boolean lazy;

	public final List<TickConfiguration> tickConfigurations;
	public final List<NotifyConfiguration> notifyConfigurations;

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
		loadHandleBuilder = createHandleBuilder(type, Load.class);
		disposeHandleBuilder = createHandleBuilder(type, Dispose.class);

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

			final var handler = new TickConfiguration(	tickHandleBuilder,
														tickFrequency,
														tickPriority,
														clock);
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

			final var featureIds = convertFeatureList(annotation.featureIds());
			final var notifyHandleBuilder = ExecutionHandle.Builder.fromMethod(notifyMethod.method);

			res.add(new NotifyConfiguration(notifyHandleBuilder, featureIds));
		}
		return res;
	}

	private static List<Integer> convertFeatureList(int[] featureIds)
	{
		final List<Integer> res = new ArrayList<>();
		for (final var id : featureIds)
		{
			res.add(id);
		}
		return List.copyOf(res);
	}

	private static double computeFrequency(final Tick tickAnnotation)
	{
		final int frequency = tickAnnotation.frequency();
		final var frequencyRef = tickAnnotation.frequencyRef();

		return (double) frequency / frequencyRef.toSeconds(1);
	}

	private static final ExecutionHandle.Builder createHandleBuilder(	Class<?> type,
																		Class<? extends Annotation> annotationClass)
	{
		final var method = ReflectUtils.gatherMethod(type, annotationClass);
		return createHandleBuilder(method);
	}

	private static ExecutionHandle.Builder createHandleBuilder(Method method)
	{
		if (method != null)
		{
			return ExecutionHandle.Builder.fromMethod(method);
		}
		else
		{
			return null;
		}
	}

	private T createSingleton()
	{
		return constructorHandle.newInstance(null);
	}

	private Constructor<T> gatherConstructor()
	{
		Constructor<T> res = null;

		@SuppressWarnings("unchecked")
		final var constructors = (Constructor<T>[]) domain.type.getDeclaredConstructors();
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

		res.setAccessible(true);
		return res;
	}

	private void constructorNotFoundError()
	{
		final String message = "The class [%s] should define a public constructor with no paramters, "
				+ "or (if statefull), a constructor with one parameter, typed with the applicable class";
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
		T res = null;
		if (isSingleton == true)
		{
			res = singleton;
		}
		else
		{
			res = constructorHandle.newInstance(target);
		}

		return res;
	}

	public boolean isAutoAdapter()
	{
		return tickConfigurations.isEmpty() == false
				|| lazy == false
				|| (isSingleton && notifyConfigurations.isEmpty() == false);
	}

	public static final class NotifyConfiguration
	{
		public final Builder notifyHandleBuilder;
		public final List<Integer> featureIds;

		public NotifyConfiguration(	ExecutionHandle.Builder notifyHandleBuilder,
									List<Integer> featureIds)
		{
			this.notifyHandleBuilder = notifyHandleBuilder;
			this.featureIds = List.copyOf(featureIds);
		}
	}

	public static final class TickConfiguration
	{
		public final ExecutionHandle.Builder tickHandleBuilder;
		public final Double tickFrequency;
		public final Integer tickPriority;
		public final ETickerClock clock;

		public TickConfiguration(	ExecutionHandle.Builder tickHandleBuilder,
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
