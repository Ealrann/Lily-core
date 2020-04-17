package org.sheepy.lily.core.api.util;

import org.sheepy.lily.core.api.extender.IExtender;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public final class ReflectUtils
{
	private static final Class<?>[] NO_TYPES = new Class<?>[0];
	private static final Object[] NO_OBJECTS = new Object[0];

	public static <T extends IExtender> T constructNew(Class<T> classifier)
	{
		T res = null;
		try
		{
			final Constructor<T> constructor = classifier.getConstructor(NO_TYPES);
			res = constructor.newInstance(NO_OBJECTS);
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
		return res;
	}

	public static <T extends Annotation> Method gatherAnnotatedMethod(Class<?> type, Class<? extends T> annotationClass)
	{
		Method res = null;

		final var methodAnnotation = gatherAnnotatedMethods(type, annotationClass);
		if (methodAnnotation.isEmpty() == false)
		{
			res = methodAnnotation.get(0).method();
		}

		return res;
	}

	public static <T extends Annotation> List<AnnotatedMethod<T>> gatherAnnotatedMethods(Class<?> type,
																						 Class<? extends T> annotationClass)
	{
		final List<AnnotatedMethod<T>> res = new ArrayList<>();
		while (type != null)
		{
			for (final var method : type.getDeclaredMethods())
			{
				final var annotation = method.getAnnotation(annotationClass);
				if (annotation != null)
				{
					res.add(new AnnotatedMethod<>(method, annotation));
				}
			}
			type = type.getSuperclass();
		}

		return List.copyOf(res);
	}

	public static List<AnnotatedMethod<?>> gatherAnnotatedMethods(Class<?> type)
	{
		final List<AnnotatedMethod<?>> res = new ArrayList<>();
		while (type != Object.class)
		{
			for (final var method : type.getDeclaredMethods())
			{
				for (final var annotation : method.getDeclaredAnnotations())
				{
					final String packageName = annotation.annotationType().getPackageName();
					if (!packageName.startsWith("java") && !packageName.startsWith("sun"))
					{
						res.add(new AnnotatedMethod<>(method, annotation));
					}
				}
			}
			type = type.getSuperclass();
		}

		return List.copyOf(res);
	}

	public static record AnnotatedMethod<T extends Annotation>(Method method, T annotation)
	{
	}
}
