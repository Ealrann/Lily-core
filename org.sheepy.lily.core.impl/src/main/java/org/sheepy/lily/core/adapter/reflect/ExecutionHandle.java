package org.sheepy.lily.core.adapter.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.sheepy.lily.core.adapter.reflect.impl.ExecutionHandleNoParam;
import org.sheepy.lily.core.adapter.reflect.impl.ExecutionHandleParam1;
import org.sheepy.lily.core.adapter.reflect.impl.ExecutionHandleParam2;
import org.sheepy.lily.core.adapter.reflect.impl.ExecutionHandleStaticNoParam;
import org.sheepy.lily.core.adapter.reflect.impl.ExecutionHandleStaticParam1;
import org.sheepy.lily.core.adapter.reflect.impl.ExecutionHandleStaticParam2;
import org.sheepy.lily.core.adapter.reflect.util.ReflectUtil;
import org.sheepy.lily.core.api.adapter.IAdapter;

public interface ExecutionHandle
{
	void invoke(Object... parameters);

	public static abstract class Builder<T extends IAdapter>
	{
		public static final <T extends IAdapter> Builder<T> fromMethod(Method method)
		{
			@SuppressWarnings("unchecked")
			final var sourceClass = (Class<T>) method.getDeclaringClass();
			final int paramCount = method.getParameterCount();
			final var privateLookup = ReflectUtil.reachPrivateLookup(sourceClass);
			final var methodHandle = ReflectUtil.unreflect(method, privateLookup);
			final var staticMethod = Modifier.isStatic(method.getModifiers());

			switch (paramCount)
			{
			case 0:
				if (staticMethod)
					return new ExecutionHandleStaticNoParam.Builder<>(privateLookup, methodHandle);
				else return new ExecutionHandleNoParam.Builder<T>(privateLookup, methodHandle);
			case 1:
				if (staticMethod)
					return new ExecutionHandleStaticParam1.Builder<>(privateLookup, methodHandle);
				else return new ExecutionHandleParam1.Builder<>(privateLookup, methodHandle);
			case 2:
				if (staticMethod)
					return new ExecutionHandleStaticParam2.Builder<>(privateLookup, methodHandle);
				else return new ExecutionHandleParam2.Builder<>(privateLookup, methodHandle);
			default:
				return null;
			}
		}

		public abstract ExecutionHandle build(T adapter);
	}
}
