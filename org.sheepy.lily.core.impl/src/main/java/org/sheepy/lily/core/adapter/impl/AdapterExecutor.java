package org.sheepy.lily.core.adapter.impl;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Autorun;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.NotifyChanged;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.adapter.annotation.Tick;
import org.sheepy.lily.core.api.util.ReflectUtils;

public class AdapterExecutor<T extends IAdapter>
{
	private static final String CANNOT_CALL_METHOD = "Cannot call %s method %s.%s()";

	private static final Object[] NO_PARAMETERS = new Object[0];

	public final AdapterDomain<T> domain;
	private final T singleton;
	private final boolean isSingleton;
	private final Constructor<T> constructor;
	private final Integer tickFrequency;
	private final Integer tickPriority;
	private final Method loadMethod;
	private final Method tickMethod;
	private final Method disposeMethod;
	private final Method notifyMethod;

	public AdapterExecutor(AdapterDomain<T> domain)
	{
		this.domain = domain;

		final var type = domain.type;
		final var adapterAnnotation = ReflectUtils.gatherType(type, Adapter.class);
		final var statefullAnnotation = ReflectUtils.gatherType(type, Statefull.class);
		if (adapterAnnotation == null)
		{
			throwNoAdapterAnnotationError();
		}

		isSingleton = statefullAnnotation == null;
		constructor = gatherConstructor();
		loadMethod = ReflectUtils.gatherMethod(type, Autorun.class);
		disposeMethod = ReflectUtils.gatherMethod(type, Dispose.class);
		notifyMethod = ReflectUtils.gatherMethod(type, NotifyChanged.class);

		final var tickMethodAnnotation = ReflectUtils.gatherMethodAnnotation(type, Tick.class);
		if (tickMethodAnnotation != null)
		{
			final Tick tickAnnotation = tickMethodAnnotation.annotation;
			tickFrequency = tickAnnotation.frequency();
			tickPriority = tickAnnotation.priority();
			tickMethod = tickMethodAnnotation.method;
		}
		else
		{
			tickFrequency = null;
			tickPriority = null;
			tickMethod = null;
		}

		if(isSingleton)
		{
			singleton = createSingleton();
		}
		else
		{
			singleton = null;
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

	@SuppressWarnings("unchecked")
	private Constructor<T> gatherConstructor()
	{
		Constructor<T> res = null;
		final var constructors = domain.type.getConstructors();
		final Class<?> applicableClass = domain.targetClassifier.getInstanceClass();

		for (final Constructor<?> constructor : constructors)
		{
			if (isSingleton)
			{
				if (constructor.getParameterCount() == 0)
				{
					res = (Constructor<T>) constructor;
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
						res = (Constructor<T>) constructor;
						break;
					}
				}
				else if (constructor.getParameterCount() == 0)
				{
					res = (Constructor<T>) constructor;
				}
			}
		}

		if (res == null)
		{
			constructorNotFoundError();
		}

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

	public void load(EObject target, IAdapter adapter)
	{
		if (loadMethod != null)
		{
			invokeMethod(loadMethod, adapter, target, null);
		}
	}

	public void destroy(EObject target, IAdapter adapter)
	{
		if (disposeMethod != null)
		{
			invokeMethod(disposeMethod, adapter, target, null);
		}
	}

	public void notifyChanged(IAdapter adapter, Notification notification)
	{
		if (notifyMethod != null)
		{
			invokeMethod(notifyMethod, adapter, notification, null);
		}
	}

	public void tick(EObject target, IAdapter adapter, long stepNs)
	{
		if (tickMethod != null)
		{
			invokeMethod(tickMethod, adapter, target, stepNs);
		}
	}

	private void invokeMethod(Method method, IAdapter executor, Object param1, Object param2)
	{
		try
		{
			switch (method.getParameterCount())
			{
			case 0:
				method.invoke(executor, NO_PARAMETERS);
				break;
			case 1:
				method.invoke(executor, param1);
				break;
			case 2:
				method.invoke(executor, param1, param2);
				break;
			}
		} catch (ReflectiveOperationException | IllegalArgumentException e)
		{
			final String message = String.format(CANNOT_CALL_METHOD, method.getName(),
					domain.type.getSimpleName(), method.getName());
			new Exception(message, e).printStackTrace();
		}
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
		return loadMethod != null || isTicker();
	}

	public int getTickPriority()
	{
		return tickPriority;
	}
}
