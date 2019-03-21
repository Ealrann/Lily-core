package org.sheepy.lily.core.api.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.sheepy.lily.core.api.adapter.IAdapter;

public class ReflectUtils
{
	private static final Class<?>[] NO_TYPES = new Class<?>[0];
	private static final Object[] NO_OBJECTS = new Object[0];

	public static <T extends IAdapter> T constructNew(Class<T> classifier)
	{
		T res = null;
		try
		{
			final Constructor<T> constructor = classifier.getConstructor(NO_TYPES);
			res = constructor.newInstance(NO_OBJECTS);
		} catch (final Exception e)
		{
			e.printStackTrace();
		}
		return res;
	}

	public static final <T extends Annotation> Method gatherMethod(	Class<?> type,
																	Class<? extends T> annotationClass)
	{
		Method res = null;

		final var methodAnnotation = gatherMethodAnnotation(type, annotationClass);
		if (methodAnnotation != null)
		{
			res = methodAnnotation.method;
		}

		return res;
	}

	@SuppressWarnings("unchecked")
	public static <T extends Annotation> MethodAnnotation<T> gatherMethodAnnotation(Class<?> type,
																					Class<? extends T> annotationClass)
	{
		MethodAnnotation<T> res = null;

		final var methods = type.getMethods();
		FOUND: for (final Method method : methods)
		{
			for (final Annotation annotation : method.getAnnotations())
			{
				if (annotation.annotationType() == annotationClass)
				{
					res = new MethodAnnotation<T>(method, (T) annotation);
					break FOUND;
				}
			}
		}

		return res;
	}

	@SuppressWarnings("unchecked")
	public static <T extends Annotation> T gatherType(Class<?> type, Class<T> annotationClass)
	{
		T res = null;
		for (final Annotation annotation : type.getAnnotations())
		{
			if (annotation.annotationType() == annotationClass)
			{
				res = (T) annotation;
				break;
			}
		}

		return res;
	}

	public static class MethodAnnotation<T extends Annotation>
	{
		public final Method method;
		public final T annotation;

		private MethodAnnotation(Method method, T annotation)
		{
			this.method = method;
			this.annotation = annotation;

		}
	}
}
