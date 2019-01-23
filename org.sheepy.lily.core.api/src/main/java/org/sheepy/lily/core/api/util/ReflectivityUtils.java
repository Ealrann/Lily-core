package org.sheepy.lily.core.api.util;

import java.lang.reflect.Constructor;

import org.sheepy.lily.core.api.adapter.IAdapter;

public class ReflectivityUtils
{
	private static final Class<?>[] NO_TYPES = new Class<?>[0];
	private static final Object[] NO_OBJECTS = new Object[0];

	public static <T extends IAdapter> T constructNew(Class<T> classifier)
	{
		T res = null;
		try
		{
			Constructor<T> constructor = classifier.getConstructor(NO_TYPES);
			res = constructor.newInstance(NO_OBJECTS);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return res;
	}
}
