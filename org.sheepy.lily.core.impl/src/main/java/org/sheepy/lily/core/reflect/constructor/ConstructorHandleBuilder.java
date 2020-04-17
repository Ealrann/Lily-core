package org.sheepy.lily.core.reflect.constructor;

import org.sheepy.lily.core.reflect.util.ReflectionUtil;
import org.sheepy.lily.core.api.reflect.ConstructorHandle;

import java.lang.reflect.Constructor;

public abstract class ConstructorHandleBuilder<T>
{
	public static final <T> ConstructorHandleBuilder<T> fromMethod(Constructor<T> constructor) throws ReflectiveOperationException
	{
		final var sourceClass = constructor.getDeclaringClass();
		final int paramCount = constructor.getParameterCount();
		final var privateLookup = ReflectionUtil.reachLookup(sourceClass);

		try
		{
			final var methodHandle = ReflectionUtil.unreflect(constructor, privateLookup);
			return switch (paramCount)
					{
						case 0 -> new ConstructorHandleNoParam.Builder<>(privateLookup, methodHandle, constructor);
						case 1 -> new ConstructorHandleParam1.Builder<>(privateLookup, methodHandle, constructor);
						case 2 -> new ConstructorHandleParam2.Builder<>(privateLookup, methodHandle, constructor);
						default -> new ConstructorHandleParamN.Builder<>(methodHandle, constructor);
					};
		}
		catch (final Throwable e)
		{
			throw new ReflectiveOperationException("Cannot create Handle for Constructor: " + constructor, e);
		}
	}

	public abstract ConstructorHandle<T> build();
}
