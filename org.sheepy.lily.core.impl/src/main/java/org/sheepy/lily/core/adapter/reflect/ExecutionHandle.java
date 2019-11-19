package org.sheepy.lily.core.adapter.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.sheepy.lily.core.adapter.reflect.impl.ExecutionHandle1Param;
import org.sheepy.lily.core.adapter.reflect.impl.ExecutionHandle2Param;
import org.sheepy.lily.core.adapter.reflect.impl.ExecutionHandleNoParam;
import org.sheepy.lily.core.adapter.reflect.util.ReflectUtil;
import org.sheepy.lily.core.api.adapter.IAdapter;

public interface ExecutionHandle
{
	void invoke(Object... parameters);

	public static abstract class Builder
	{
		public static final Builder fromMethod(Method method)
		{
			final var type = method.getDeclaringClass();
			final int paramCount = method.getParameterCount();
			final var privateLookup = ReflectUtil.reachPrivateLookup(type);
			final var methodHandle = ReflectUtil.unreflect(method, privateLookup);
			final var staticMethod = Modifier.isStatic(method.getModifiers());

			switch (paramCount)
			{
			case 0:
				if (staticMethod)
					return new ExecutionHandleNoParam.StaticBuilder(privateLookup, methodHandle);
				else return new ExecutionHandleNoParam.Builder(privateLookup, methodHandle, type);
			case 1:
				if (staticMethod)
					return new ExecutionHandle1Param.StaticBuilder(privateLookup, methodHandle);
				else return new ExecutionHandle1Param.Builder(privateLookup, methodHandle, type);
			case 2:
				if (staticMethod)
					return new ExecutionHandle2Param.StaticBuilder(privateLookup, methodHandle);
				else return new ExecutionHandle2Param.Builder(privateLookup, methodHandle, type);
			default:
				return null;
			}
		}

		public abstract ExecutionHandle build(IAdapter adapter);
	}
}
