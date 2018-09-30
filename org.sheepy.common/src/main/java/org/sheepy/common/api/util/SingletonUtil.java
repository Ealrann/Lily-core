package org.sheepy.common.api.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class SingletonUtil
{
	public static boolean isSingleton(Class<?> classifier)
	{
		boolean res = false;

		res |= hasNonStaticFields(classifier);
		res |= checkSuperInterfaces(classifier);
		res |= checkSuperClass(classifier);

		return res;
	}

	private static boolean checkSuperInterfaces(Class<?> classifier)
	{
		for (Class<?> iface : classifier.getInterfaces())
		{
			if (isSingleton(iface))
			{
				return true;
			}
		}
		return false;
	}

	private static boolean checkSuperClass(Class<?> classifier)
	{
		Class<?> superclass = classifier.getSuperclass();
		if (superclass != null && isSingleton(superclass))
		{
			return true;
		}
		return false;
	}

	private static boolean hasNonStaticFields(Class<?> classifier)
	{
		for (Field field : classifier.getDeclaredFields())
		{
			if (Modifier.isStatic(field.getModifiers()) == false)
			{
				return true;
			}
		}
		return false;
	}
}
