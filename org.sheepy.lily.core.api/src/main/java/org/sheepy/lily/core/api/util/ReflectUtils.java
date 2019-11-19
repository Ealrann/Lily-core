package org.sheepy.lily.core.api.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

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

		final var methodAnnotation = gatherAnnotatedMethods(type, annotationClass);
		if (methodAnnotation.isEmpty() == false)
		{
			res = methodAnnotation.get(0).method;
		}

		return res;
	}

	public static <T extends Annotation> List<AnnotatedMethod<T>> gatherAnnotatedMethods(	Class<?> type,
																							Class<? extends T> annotationClass)
	{
		final List<AnnotatedMethod<T>> res = new ArrayList<>();

		final var methods = type.getDeclaredMethods();
		for (final Method method : methods)
		{
			final var annotation = method.getAnnotation(annotationClass);

			if (annotation != null)
			{
				res.add(new AnnotatedMethod<>(method, annotation));
			}
		}

		return List.copyOf(res);
	}

	public static class AnnotatedMethod<T extends Annotation>
	{
		public final Method method;
		public final T annotation;

		private AnnotatedMethod(Method method, T annotation)
		{
			this.method = method;
			this.annotation = annotation;

		}
	}
}
