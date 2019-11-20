package org.sheepy.lily.core.adapter.reflect;

import java.lang.invoke.LambdaConversionException;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.sheepy.lily.core.adapter.reflect.impl.ExecutionHandle1Param;
import org.sheepy.lily.core.adapter.reflect.impl.ExecutionHandle1ParamLong;
import org.sheepy.lily.core.adapter.reflect.impl.ExecutionHandle2Param;
import org.sheepy.lily.core.adapter.reflect.impl.ExecutionHandle2ParamObjLong;
import org.sheepy.lily.core.adapter.reflect.impl.ExecutionHandleNoParam;
import org.sheepy.lily.core.adapter.reflect.util.ReflectUtil;
import org.sheepy.lily.core.api.adapter.IAdapter;

public interface ExecutionHandle
{
	void invoke(Object... parameters);

	Object getLambdaFunction();

	public static abstract class Builder
	{
		public static final Builder fromMethod(Method method)
		{
			final var type = method.getDeclaringClass();
			final int paramCount = method.getParameterCount();
			final var lookup = ReflectUtil.reachPrivateLookup(type);
			final var methodHandle = ReflectUtil.unreflectSpecial(method, lookup, type);
			final var isStatic = Modifier.isStatic(method.getModifiers());

			try
			{
				switch (paramCount)
				{
				case 0:
					return buildNoArgs(type, lookup, methodHandle, isStatic);
				case 1:

					return build1Args(type, lookup, methodHandle, isStatic);

				case 2:
					return build2Args(type, lookup, methodHandle, isStatic);
				}
			} catch (final Throwable e)
			{
				e.printStackTrace();
			}

			return null;
		}

		private static Builder buildNoArgs(	final Class<?> type,
											final Lookup lookup,
											final MethodHandle methodHandle,
											final boolean isStatic)
		{
			if (isStatic) return new ExecutionHandleNoParam.StaticBuilder(lookup, methodHandle);
			else return new ExecutionHandleNoParam.Builder(lookup, methodHandle, type);
		}

		private static Builder build1Args(	final Class<?> type,
											final Lookup lookup,
											final MethodHandle methodHandle,
											final boolean isStatic)
				throws Throwable,
				LambdaConversionException
		{
			if (methodHandle.type().lastParameterType() == Long.TYPE)
			{
				if (isStatic)
					return new ExecutionHandle1ParamLong.StaticBuilder(lookup, methodHandle);
				else return new ExecutionHandle1ParamLong.Builder(lookup, methodHandle, type);
			}
			else
			{
				if (isStatic) return new ExecutionHandle1Param.StaticBuilder(lookup, methodHandle);
				else return new ExecutionHandle1Param.Builder(lookup, methodHandle, type);
			}
		}

		private static Builder build2Args(	final Class<?> type,
											final Lookup lookup,
											final MethodHandle methodHandle,
											final boolean isStatic)
				throws Throwable,
				LambdaConversionException
		{
			if (methodHandle.type().lastParameterType() == Long.TYPE)
			{
				if (isStatic)
					return new ExecutionHandle2ParamObjLong.StaticBuilder(lookup, methodHandle);
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
}
