package org.sheepy.lily.core.adapter.reflect;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

import org.sheepy.lily.core.adapter.reflect.impl.ExecutionHandleNoParam;
import org.sheepy.lily.core.adapter.reflect.impl.ExecutionHandleParam1;
import org.sheepy.lily.core.adapter.reflect.impl.ExecutionHandleParam2;
import org.sheepy.lily.core.adapter.reflect.impl.ExecutionHandleStaticNoParam;
import org.sheepy.lily.core.adapter.reflect.impl.ExecutionHandleStaticParam1;
import org.sheepy.lily.core.adapter.reflect.impl.ExecutionHandleStaticParam2;
import org.sheepy.lily.core.api.adapter.IAdapter;

public interface ExecutionHandle
{
	void invoke(Object... parameters);

	public static abstract class Builder<T extends IAdapter>
	{
		public static final <T extends IAdapter> Builder<T> fromMethod(Method method)
		{
			final int paramCount = method.getParameterCount();
			final var privateLookup = reachPrivateLookup(method.getDeclaringClass());
			final var methodHandle = unreflect(method, privateLookup);
			final var staticMethod = Modifier.isStatic(method.getModifiers());
			@SuppressWarnings("unchecked")
			final var sourceClass = (Class<T>) method.getDeclaringClass();

			final List<Class<?>> params = new ArrayList<>();
			final List<Class<?>> sourceClassAndParams = new ArrayList<>();
			if (!staticMethod) sourceClassAndParams.add(sourceClass);
			for (final Parameter param : method.getParameters())
			{
				final var type = param.getType();
				params.add(type);
				sourceClassAndParams.add(type);
			}

			switch (paramCount)
			{
			case 0:
				if (staticMethod)
					return new ExecutionHandleStaticNoParam.Builder<>(privateLookup, methodHandle);
				else return new ExecutionHandleNoParam.Builder<T>(privateLookup, methodHandle,
						sourceClass);
			case 1:
				if (staticMethod) return new ExecutionHandleStaticParam1.Builder<>(privateLookup,
						methodHandle, params);
				else return new ExecutionHandleParam1.Builder<>(privateLookup, methodHandle,
						sourceClassAndParams);
			case 2:
				if (staticMethod) return new ExecutionHandleStaticParam2.Builder<>(privateLookup,
						methodHandle, params);
				else return new ExecutionHandleParam2.Builder<>(privateLookup, methodHandle,
						sourceClassAndParams);
			default:
				return null;
			}
		}

		private static final Lookup reachPrivateLookup(Class<?> sourceClass)
		{
			final var otherModule = sourceClass.getModule();
			final var thisModule = Builder.class.getModule();
			final boolean canRead = thisModule.canRead(otherModule);
			if (canRead == false)
			{
				thisModule.addReads(otherModule);
			}

			Lookup res = null;
			try
			{
				res = MethodHandles.privateLookupIn(sourceClass, MethodHandles.lookup());
			} catch (final IllegalAccessException e)
			{
				e.printStackTrace();
			}
			return res;
		}

		private static final MethodHandle unreflect(Method method, Lookup lookup)
		{
			MethodHandle res = null;
			try
			{
				res = lookup.unreflect(method);

			} catch (final IllegalAccessException e)
			{
				e.printStackTrace();
			}

			return res;
		}

		public abstract ExecutionHandle build(T adapter);
	}

	@FunctionalInterface
	public static interface Operation
	{
		void execute();
	}

	@FunctionalInterface
	public static interface TriConsumer<T, U, V>
	{
		void accept(T p1, U p2, V p3);
	}
}
