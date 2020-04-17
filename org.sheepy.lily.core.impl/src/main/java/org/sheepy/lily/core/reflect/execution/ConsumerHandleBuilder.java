package org.sheepy.lily.core.reflect.execution;

import org.sheepy.lily.core.reflect.ExecutionHandleBuilder;
import org.sheepy.lily.core.reflect.util.ReflectionUtil;
import org.sheepy.lily.core.api.reflect.ConsumerHandle;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public abstract class ConsumerHandleBuilder extends ExecutionHandleBuilder
{
	public static final ConsumerHandleBuilder fromMethod(Method method) throws ReflectiveOperationException
	{
		final var type = method.getDeclaringClass();
		final int paramCount = method.getParameterCount();
		final var lookup = ReflectionUtil.reachLookup(type);
		final var isStatic = Modifier.isStatic(method.getModifiers());

		try
		{
			final var methodHandle = ReflectionUtil.unreflect(method, lookup, type);
			return switch (paramCount)
					{
						case 0 -> buildNoArgs(type, lookup, methodHandle, isStatic);
						case 1 -> build1Args(type, lookup, methodHandle, isStatic);
						case 2 -> build2Args(type, lookup, methodHandle, isStatic);
						default -> null;
					};
		}
		catch (final Throwable e)
		{
			throw new ReflectiveOperationException("Cannot create Handle for Method: " + method, e);
		}
	}

	private static ConsumerHandleBuilder buildNoArgs(final Class<?> type,
													 final Lookup lookup,
													 final MethodHandle methodHandle,
													 final boolean isStatic) throws Throwable
	{
		if (isStatic) return new ConsumerHandleNoParam.StaticBuilder(lookup, methodHandle);
		else return new ConsumerHandleNoParam.Builder(lookup, methodHandle, type);
	}

	private static ConsumerHandleBuilder build1Args(final Class<?> type,
													final Lookup lookup,
													final MethodHandle methodHandle,
													final boolean isStatic) throws Throwable
	{
		if (methodHandle.type().lastParameterType() == Long.TYPE)
		{
			if (isStatic) return new ConsumerHandle1ParamLong.StaticBuilder(lookup, methodHandle);
			else return new ConsumerHandle1ParamLong.Builder(lookup, methodHandle, type);
		}
		else
		{
			if (isStatic) return new ConsumerHandle1Param.StaticBuilder(lookup, methodHandle);
			else return new ConsumerHandle1Param.Builder(lookup, methodHandle, type);
		}
	}

	private static ConsumerHandleBuilder build2Args(final Class<?> type,
													final Lookup lookup,
													final MethodHandle methodHandle,
													final boolean isStatic) throws Throwable
	{
		if (methodHandle.type().lastParameterType() == Long.TYPE)
		{
			if (isStatic) return new ConsumerHandle2ParamObjLong.StaticBuilder(lookup, methodHandle);
			else return new ConsumerHandle2ParamObjLong.Builder(lookup, methodHandle, type);
		}
		else
		{
			if (isStatic) return new ConsumerHandle2Param.StaticBuilder(lookup, methodHandle);
			else return new ConsumerHandle2Param.Builder(lookup, methodHandle, type);
		}
	}

	@Override
	public abstract ConsumerHandle build(Object target);
}
