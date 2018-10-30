package org.sheepy.common.api.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class SingletonUtil
{
	@Deprecated
	public static boolean isSingleton(Class<?> classifier)
	{
		var iterator = new ClassHierarchyIterator(classifier);
		while (iterator.hasNext())
		{
			Class<?> currentClass = iterator.next();
			if (hasNonStaticFields(currentClass))
			{
				return false;
			}
		}

		return true;
	}

	private static boolean hasNonStaticFields(Class<?> classifier)
	{
		for (Field field : classifier.getDeclaredFields())
		{
			if (Modifier.isStatic(field.getModifiers()) == false && field.isSynthetic() == false)
			{
				return true;
			}
		}
		return false;
	}
}
