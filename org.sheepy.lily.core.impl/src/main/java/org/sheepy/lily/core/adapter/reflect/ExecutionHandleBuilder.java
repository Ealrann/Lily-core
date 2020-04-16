package org.sheepy.lily.core.adapter.reflect;

import org.sheepy.lily.core.adapter.reflect.impl.*;
import org.sheepy.lily.core.adapter.reflect.util.ReflectionUtil;
import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.util.ExecutionHandle;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public abstract class ExecutionHandleBuilder
{
	public static final ExecutionHandleBuilder fromMethod(Method method)
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
			new Exception("Cannot create Handle for Method: " + method, e).printStackTrace();
			return null;
		}
	}

	private static ExecutionHandleBuilder buildNoArgs(final Class<?> type,
													  final Lookup lookup,
													  final MethodHandle methodHandle,
													  final boolean isStatic) throws Throwable
	{
		if (isStatic) return new ExecutionHandleNoParam.StaticBuilder(lookup, methodHandle);
		else return new ExecutionHandleNoParam.Builder(lookup, methodHandle, type);
	}

	private static ExecutionHandleBuilder build1Args(final Class<?> type,
													 final Lookup lookup,
													 final MethodHandle methodHandle,
													 final boolean isStatic) throws Throwable
	{
		if (methodHandle.type().lastParameterType() == Long.TYPE)
		{
			if (isStatic) return new ExecutionHandle1ParamLong.StaticBuilder(lookup, methodHandle);
			else return new ExecutionHandle1ParamLong.Builder(lookup, methodHandle, type);
		}
		else
		{
			if (isStatic) return new ExecutionHandle1Param.StaticBuilder(lookup, methodHandle);
			else return new ExecutionHandle1Param.Builder(lookup, methodHandle, type);
		}
	}

	private static ExecutionHandleBuilder build2Args(final Class<?> type,
													 final Lookup lookup,
													 final MethodHandle methodHandle,
													 final boolean isStatic) throws Throwable
	{
		if (methodHandle.type().lastParameterType() == Long.TYPE)
		{
			if (isStatic) return new ExecutionHandle2ParamObjLong.StaticBuilder(lookup, methodHandle);
			else return new ExecutionHandle2ParamObjLong.Builder(lookup, methodHandle, type);
		}
		else
		{
			if (isStatic) return new ExecutionHandle2Param.StaticBuilder(lookup, methodHandle);
			else return new ExecutionHandle2Param.Builder(lookup, methodHandle, type);
		}
	}

	public abstract ExecutionHandle build(IAdapter adapter);
}