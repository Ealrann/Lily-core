package org.sheepy.lily.core.adapter.reflect;

import java.lang.invoke.CallSite;
import java.lang.invoke.LambdaMetafactory;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

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

	public static final class Builder<T extends IAdapter>
	{
		private final MethodHandle methodHandle;
		private final int parameterCount;
		private final boolean staticMethod;
		private final List<Class<?>> params;
		private final List<Class<?>> sourceClassAndParams;
		private final Class<?> sourceClass;
		private final Lookup privateLookup;

		public Builder(Method method)
		{
			staticMethod = Modifier.isStatic(method.getModifiers());
			parameterCount = method.getParameterCount();
			sourceClass = method.getDeclaringClass();
			privateLookup = reachPrivateLookup();
			methodHandle = unreflect(method);

			params = new ArrayList<>();
			sourceClassAndParams = new ArrayList<>();
			if (!staticMethod) sourceClassAndParams.add(sourceClass);
			for (final Parameter param : method.getParameters())
			{
				final var type = param.getType();
				params.add(type);
				sourceClassAndParams.add(type);
			}
		}

		private Lookup reachPrivateLookup()
		{
			final var otherModule = sourceClass.getModule();
			final var thisModule = Builder.class.getModule();
			final boolean canRead = thisModule.canRead(otherModule);
			if (canRead == false)
			{
				thisModule.addReads(otherModule);
			}

			Lookup tmpLookup = null;
			try
			{
				tmpLookup = MethodHandles.privateLookupIn(sourceClass, MethodHandles.lookup());
			} catch (final IllegalAccessException e)
			{
				e.printStackTrace();
			}
			return tmpLookup;
		}

		public ExecutionHandle build(T adapter)
		{
			switch (parameterCount)
			{
			case 0:
				if (staticMethod) return new ExecutionHandleStaticNoParam<>(createOperation());
				else return new ExecutionHandleNoParam<>(adapter, createConsumer());
			case 1:
				if (staticMethod) return new ExecutionHandleStaticParam1(createStaticParam1());
				else return new ExecutionHandleParam1<>(adapter, createConsumerParam1());
			case 2:
				if (staticMethod) return new ExecutionHandleStaticParam2(createStaticParam2());
				else return new ExecutionHandleParam2<>(adapter, createConsumerParam2());
			default:
				return null;
			}
		}

		private Operation createOperation()
		{
			Operation operation = null;
			try
			{
				final CallSite site = LambdaMetafactory.metafactory(privateLookup, "execute",
						MethodType.methodType(Operation.class),
						MethodType.methodType(Void.TYPE, Void.TYPE), methodHandle,
						MethodType.methodType(Void.TYPE, Void.TYPE));

				operation = (Operation) site.getTarget().invokeExact();

			} catch (final Throwable e)
			{
				e.printStackTrace();
			}

			return operation;
		}

		private Consumer<T> createConsumer()
		{
			Consumer<T> consumer = null;
			try
			{
				final CallSite site = LambdaMetafactory.metafactory(privateLookup, "accept",
						MethodType.methodType(Consumer.class),
						MethodType.methodType(Void.TYPE, Object.class), methodHandle,
						MethodType.methodType(Void.TYPE, sourceClass));

				consumer = (Consumer<T>) site.getTarget().invokeExact();

			} catch (final Throwable e)
			{
				e.printStackTrace();
			}

			return consumer;
		}

		private Consumer<Object> createStaticParam1()
		{
			Consumer<Object> consumer = null;
			try
			{
				final CallSite site = LambdaMetafactory.metafactory(privateLookup, "accept",
						MethodType.methodType(Consumer.class),
						MethodType.methodType(Void.TYPE, Object.class), methodHandle,
						MethodType.methodType(Void.TYPE, params));

				consumer = (Consumer<Object>) site.getTarget().invokeExact();

			} catch (final Throwable e)
			{
				e.printStackTrace();
			}

			return consumer;
		}

		private BiConsumer<Object, Object> createStaticParam2()
		{
			BiConsumer<Object, Object> consumer = null;
			try
			{
				final CallSite site = LambdaMetafactory.metafactory(privateLookup, "accept",
						MethodType.methodType(Consumer.class),
						MethodType.methodType(Void.TYPE, Object.class, Object.class), methodHandle,
						MethodType.methodType(Void.TYPE, params));

				consumer = (BiConsumer<Object, Object>) site.getTarget().invokeExact();

			} catch (final Throwable e)
			{
				e.printStackTrace();
			}

			return consumer;
		}

		private BiConsumer<T, Object> createConsumerParam1()
		{
			BiConsumer<T, Object> consumer = null;
			try
			{
				final CallSite site = LambdaMetafactory.metafactory(privateLookup, "accept",
						MethodType.methodType(BiConsumer.class),
						MethodType.methodType(Void.TYPE, Object.class, Object.class), methodHandle,
						MethodType.methodType(Void.TYPE, sourceClassAndParams));

				consumer = (BiConsumer<T, Object>) site.getTarget().invokeExact();

			} catch (final Throwable e)
			{
				e.printStackTrace();
			}

			return consumer;
		}

		private TriConsumer<T, Object, Object> createConsumerParam2()
		{
			TriConsumer<T, Object, Object> consumer = null;
			try
			{
				final CallSite site = LambdaMetafactory.metafactory(privateLookup, "accept",
						MethodType.methodType(BiConsumer.class),
						MethodType.methodType(Void.TYPE, Object.class, Object.class), methodHandle,
						MethodType.methodType(Void.TYPE, sourceClassAndParams));

				consumer = (TriConsumer<T, Object, Object>) site.getTarget().invokeExact();

			} catch (final Throwable e)
			{
				e.printStackTrace();
			}

			return consumer;
		}

		private MethodHandle unreflect(Method method)
		{
			MethodHandle res = null;
			try
			{
				res = privateLookup.unreflect(method);

			} catch (final IllegalAccessException e)
			{
				e.printStackTrace();
			}

			return res;
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
}
