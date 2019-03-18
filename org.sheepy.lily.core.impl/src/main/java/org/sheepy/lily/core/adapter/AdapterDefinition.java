package org.sheepy.lily.core.adapter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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
import org.sheepy.lily.core.api.util.ReflectivityUtils;

public class AdapterDefinition
{
	private static final Object[] NO_PARAMETERS = new Object[0];

	public final AdapterDomain domain;
	private final IAdapter pattern;
	private final boolean isSingleton;
	private final Constructor<IAdapter> constructor;
	private final Method loadMethod;
	private final Method disposeMethod;
	private final Method notifyMethod;

	public AdapterDefinition(Class<? extends IAdapter> adapterClass)
	{
		var adapterAnnotation = gatherAnnotation(Adapter.class, adapterClass);
		var statefullAnnotation = gatherAnnotation(Statefull.class, adapterClass);
		if (adapterAnnotation == null)
		{
			throwNoAdapterAnnotationError();
		}

		domain = new AdapterDomain(adapterAnnotation, adapterClass);
		isSingleton = statefullAnnotation == null;
		constructor = gatherConstructor();
		loadMethod = gatherMethod(Autorun.class);
		disposeMethod = gatherMethod(Dispose.class);
		notifyMethod = gatherMethod(NotifyChanged.class);
		pattern = loadPattern();

		analyze();
	}

	private IAdapter loadPattern()
	{
		IAdapter pattern = null;
		if (isSingleton)
		{
			try
			{
				pattern = constructor.newInstance(NO_PARAMETERS);
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e)
			{
				e.printStackTrace();
			}
		}
		return pattern;
	}

	private Method gatherMethod(Class<? extends Annotation> annotationClass)
	{
		Method res = null;
		var methods = domain.type.getDeclaredMethods();
		for (Method method : methods)
		{
			for (Annotation annotation : method.getAnnotations())
			{
				if (annotation.annotationType() == annotationClass)
				{
					res = method;
					break;
				}
			}
		}
		return res;
	}

	@SuppressWarnings("unchecked")
	private Constructor<IAdapter> gatherConstructor()
	{
		Constructor<IAdapter> res = null;
		var constructors = domain.type.getConstructors();
		Class<?> applicableClass = domain.targetClassifier.getInstanceClass();

		for (Constructor<?> constructor : constructors)
		{
			if (isSingleton)
			{
				if (constructor.getParameterCount() == 0)
				{
					res = (Constructor<IAdapter>) constructor;
					break;
				}
			}
			else
			{
				if (constructor.getParameterCount() == 1)
				{
					Parameter parameter = constructor.getParameters()[0];
					if (ReflectivityUtils.isSuperType(parameter.getType(), applicableClass))
					{
						res = (Constructor<IAdapter>) constructor;
						break;
					}
				}
				else if (constructor.getParameterCount() == 0)
				{
					res = (Constructor<IAdapter>) constructor;
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
		String message = "The class [%s] should define a public constructor with no paramters, "
				+ "or (if statefull), a constructor with one parameter, typed with the applicable class";
		String errorMessage = String.format(message, domain.type.getSimpleName());
		throw new AssertionError(errorMessage);
	}

	@SuppressWarnings("unchecked")
	private static <T extends Annotation> T gatherAnnotation(	Class<T> annotationClass,
																Class<?> type)
	{
		T res = null;
		for (Annotation annotation : type.getAnnotations())
		{
			if (annotation.annotationType() == annotationClass)
			{
				res = (T) annotation;
				break;
			}
		}

		return res;
	}

	private void throwNoAdapterAnnotationError() throws AssertionError
	{
		String adapterName = domain.type.getSimpleName();
		String annotationName = Adapter.class.getSimpleName();
		String message = "The class [%s] is not annoted with @%s";
		String errorMessage = String.format(message, adapterName, annotationName);
		throw new AssertionError(errorMessage);
	}

	private void analyze()
	{

	}

	public IAdapter create(EObject target)
	{
		IAdapter res = null;
		if (isSingleton == true)
		{
			res = pattern;
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
					res = constructor
							.newInstance(domain.targetClassifier.getInstanceClass().cast(target));
				}
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e)
			{
				new Exception("Cannot instanciate " + domain.type.getSimpleName(), e)
						.printStackTrace();
			}
		}

		return res;
	}

	public void load(EObject target, IAdapter adapter)
	{
		if (loadMethod != null)
		{
			try
			{
				if (loadMethod.getParameterCount() == 0)
				{
					loadMethod.invoke(adapter, NO_PARAMETERS);
				}
				else
				{
					loadMethod.invoke(adapter,
							domain.targetClassifier.getInstanceClass().cast(target));
				}
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e)
			{
				String message = String.format("Cannot call @Autorun method %s.%s()",
						domain.type.getSimpleName(), loadMethod.getName());
				new Exception(message, e).printStackTrace();
			}
		}
	}

	public void destroy(EObject target, IAdapter adapter)
	{
		if (disposeMethod != null)
		{
			try
			{
				if (disposeMethod.getParameterCount() == 0)
				{
					disposeMethod.invoke(adapter, NO_PARAMETERS);
				}
				else
				{
					disposeMethod.invoke(adapter,
							domain.targetClassifier.getInstanceClass().cast(target));
				}
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e)
			{
				String message = String.format("Cannot call @Dispose method %s.%s()",
						domain.type.getSimpleName(), loadMethod.getName());
				new Exception(message, e).printStackTrace();
			}
		}
	}

	public void notifyChanged(IAdapter adapter, Notification notification)
	{
		if (notifyMethod != null)
		{
			try
			{
				if (notifyMethod.getParameterCount() == 0)
				{
					notifyMethod.invoke(adapter, NO_PARAMETERS);
				}
				else
				{
					notifyMethod.invoke(adapter, notification);
				}
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e)
			{
				String message = String.format("Cannot call @NotifyChanged method %s.%s()",
						domain.type.getSimpleName(), loadMethod.getName());
				new Exception(message, e).printStackTrace();
			}
		}
	}

	public boolean isAutoAdapter()
	{
		return loadMethod != null;
	}

	public boolean isNamedAdapter()
	{
		return domain.targetName.isEmpty() == false;
	}

	public boolean isApplicable(EObject eObject)
	{
		return domain.isApplicable(eObject);
	}

	public boolean isAdapterForType(Class<? extends IAdapter> type)
	{
		return domain.isAdapterForType(type);
	}
}
