package org.sheepy.lily.core.adapter.impl;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.adapter.reflect.ExecutionHandle;
import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Autorun;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.NotifyChanged;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.adapter.annotation.Tick;
import org.sheepy.lily.core.api.util.ReflectUtils;

public final class AdapterInfo<T extends IAdapter>
{
	private static final Object[] NO_PARAMETERS = new Object[0];

	public final AdapterDomain<T> domain;

	public final ExecutionHandle.Builder<T> loadHandleBuilder;
	public final ExecutionHandle.Builder<T> disposeHandleBuilder;
	public final ExecutionHandle.Builder<T> tickHandleBuilder;
	public final ExecutionHandle.Builder<T> notifyHandleBuilder;

	private final T singleton;
	private final boolean isSingleton;
	private final Constructor<T> constructor;
	private final boolean autorunConstructor;
	private final Integer tickFrequency;
	private final Integer tickPriority;

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
		constructor = gatherConstructor();
		autorunConstructor = constructor.isAnnotationPresent(Autorun.class);
		loadHandleBuilder = createHandleBuilder(type, Autorun.class);
		disposeHandleBuilder = createHandleBuilder(type, Dispose.class);
		notifyHandleBuilder = createHandleBuilder(type, NotifyChanged.class);

		final var tickMethodAnnotation = ReflectUtils.gatherMethodAnnotation(type, Tick.class);
		if (tickMethodAnnotation != null)
		{
			final Tick tickAnnotation = tickMethodAnnotation.annotation;
			tickFrequency = tickAnnotation.frequency();
			tickPriority = tickAnnotation.priority();
			tickHandleBuilder = ExecutionHandle.Builder.fromMethod(tickMethodAnnotation.method);
		}
		else
		{
			tickFrequency = null;
			tickPriority = null;
			tickHandleBuilder = null;
		}

		if (isSingleton)
		{
			singleton = createSingleton();
		}
		else
		{
			singleton = null;
		}
	}

	private final ExecutionHandle.Builder<T> createHandleBuilder(	Class<?> type,
																	Class<? extends Annotation> annotationClass)
	{
		final var method = ReflectUtils.gatherMethod(type, annotationClass);
		return createHandleBuilder(method);
	}

	private ExecutionHandle.Builder<T> createHandleBuilder(Method method)
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
		T res = null;
		if (isSingleton)
		{
			try
			{
				res = constructor.newInstance(NO_PARAMETERS);
			} catch (ReflectiveOperationException | IllegalArgumentException e)
			{
				e.printStackTrace();
			}
		}
		return res;
	}

	private Constructor<T> gatherConstructor()
	{
		Constructor<T> res = null;

		@SuppressWarnings("unchecked")
		final var constructors = (Constructor<T>[]) domain.type.getConstructors();
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
					}
				}
				else if (constructor.getParameterCount() == 0)
				{
					if (res == null)
					{
						res = constructor;
					}
				}

				if (res != null)
				{
					if (constructor.isAnnotationPresent(Autorun.class))
					{
						// Autorun has priority
						break;
					}
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
		throw new AssertionError(errorMessage);
	}

	private void throwNoAdapterAnnotationError() throws AssertionError
	{
		final String adapterName = domain.type.getSimpleName();
		final String annotationName = Adapter.class.getSimpleName();
		final String message = "The class [%s] is not annoted with @%s";
		final String errorMessage = String.format(message, adapterName, annotationName);
		throw new AssertionError(errorMessage);
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
			try
			{
				if (constructor.getParameterCount() == 0)
				{
					res = constructor.newInstance(NO_PARAMETERS);
				}
				else
				{
					res = constructor.newInstance(target);
				}
			} catch (ReflectiveOperationException | IllegalArgumentException e)
			{
				System.err.println("Cannot instanciate " + domain.type.getSimpleName());
				final var cause = e.getCause();
				if (cause != null) cause.printStackTrace();
				else e.printStackTrace();
			}
		}

		return res;
	}

	public boolean isTicker()
	{
		return tickFrequency != null;
	}

	public int getTickFrequency()
	{
		return tickFrequency;
	}

	public boolean isAutoAdapter()
	{
		return loadHandleBuilder != null
				|| isTicker()
				|| autorunConstructor
				|| (isSingleton && notifyHandleBuilder != null);
	}

	public int getTickPriority()
	{
		return tickPriority;
	}
}
