package org.sheepy.lily.core.api.util;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.sheepy.lily.core.api.adapter.IAdapter;

public final class ExecutionHandle
{
	private final MethodHandle methodHandle;
	private final int paramCount;

	private ExecutionHandle(MethodHandle methodHandle, int paramCount)
	{
		this.methodHandle = methodHandle;
		this.paramCount = paramCount;
	}

	public <T extends Object> void invoke(T param1, Object param2)
	{
		try
		{
			switch (paramCount)
			{
			case 0:
				methodHandle.invokeExact();
				break;
			case 1:
				methodHandle.invoke(param1);
				break;
			case 2:
				methodHandle.invoke(param1, param2);
				break;
			}
		} catch (

		final Throwable e)
		{
			e.printStackTrace();
		}
	}

	public static final class Builder
	{
		private final MethodHandle methodHandle;
		private final int parameterCount;
		private final boolean staticMethod;

		public Builder(Method method)
		{
			staticMethod = Modifier.isStatic(method.getModifiers());
			methodHandle = unreflect(method);
			parameterCount = method.getParameterCount();
		}

		public ExecutionHandle build(IAdapter bindTo)
		{
			final var bindedHandle = staticMethod ? methodHandle : methodHandle.bindTo(bindTo);
			return new ExecutionHandle(bindedHandle, parameterCount);
		}

		private static MethodHandle unreflect(Method method)
		{
			MethodHandle res = null;
			try
			{
				final var tickMethod = method;
				res = MethodHandles.publicLookup().unreflect(tickMethod);

			} catch (final IllegalAccessException e)
			{
				e.printStackTrace();
			}

			return res;
		}
	}
}