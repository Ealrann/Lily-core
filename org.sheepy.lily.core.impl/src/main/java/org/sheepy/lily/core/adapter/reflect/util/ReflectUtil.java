package org.sheepy.lily.core.adapter.reflect.util;

import java.lang.invoke.CallSite;
import java.lang.invoke.LambdaMetafactory;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.invoke.MethodType;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import org.sheepy.lily.core.adapter.reflect.ExecutionHandle.Operation;
import org.sheepy.lily.core.adapter.reflect.ExecutionHandle.TriConsumer;

public class ReflectUtil
{
	private static final MethodType TYPE_R_OPERATION = MethodType.methodType(Operation.class);
	private static final MethodType TYPE_R_CONSUMER = MethodType.methodType(Consumer.class);
	private static final MethodType TYPE_R_BICONSUMER = MethodType.methodType(BiConsumer.class);
	private static final MethodType TYPE_R_TRICONSUMER = MethodType.methodType(TriConsumer.class);
	private static final MethodType TYPE_VOID_VOID = MethodType.methodType(Void.TYPE);
	private static final MethodType TYPE_VOID_OBJECT = MethodType.methodType(Void.TYPE,
			Object.class);
	private static final MethodType TYPE_VOID_OBJECT_OBJECT = MethodType.methodType(Void.TYPE,
			Object.class, Object.class);
	private static final MethodType TYPE_VOID_OBJECT_OBJECT_OBJECT = MethodType
			.methodType(Void.TYPE, Object.class, Object.class, Object.class);
	private static final String OPERATION_EXEC_METHOD = "execute";
	private static final String CONSUMER_EXEC_METHOD = "accept";

	public static final Operation createOperation(Lookup lookup, MethodHandle methodHandle)
	{
		Operation operation = null;
		try
		{
			final CallSite site = LambdaMetafactory.metafactory(lookup, OPERATION_EXEC_METHOD,
					TYPE_R_OPERATION, TYPE_VOID_VOID, methodHandle, TYPE_VOID_VOID);

			operation = (Operation) site.getTarget().invokeExact();

		} catch (final Throwable e)
		{
			e.printStackTrace();
		}

		return operation;
	}

	public static final <T extends Object> Consumer<T> createConsumer(	Lookup lookup,
																		MethodHandle methodHandle,
																		List<Class<?>> params)
	{
		Consumer<T> consumer = null;
		try
		{
			final CallSite site = LambdaMetafactory.metafactory(lookup, CONSUMER_EXEC_METHOD,
					TYPE_R_CONSUMER, TYPE_VOID_OBJECT, methodHandle,
					MethodType.methodType(Void.TYPE, params));

			consumer = (Consumer<T>) site.getTarget().invokeExact();

		} catch (final Throwable e)
		{
			e.printStackTrace();
		}

		return consumer;
	}

	public static final <T extends Object> BiConsumer<T, Object> createBiConsumer(	Lookup lookup,
																					MethodHandle methodHandle,
																					List<Class<?>> params)
	{
		BiConsumer<T, Object> consumer = null;
		try
		{
			final CallSite site = LambdaMetafactory.metafactory(lookup, CONSUMER_EXEC_METHOD,
					TYPE_R_BICONSUMER, TYPE_VOID_OBJECT_OBJECT, methodHandle,
					MethodType.methodType(Void.TYPE, params));

			consumer = (BiConsumer<T, Object>) site.getTarget().invokeExact();

		} catch (final Throwable e)
		{
			e.printStackTrace();
		}

		return consumer;
	}

	public static final <T extends Object> TriConsumer<T, Object, Object> createTriConsumer(Lookup lookup,
																							MethodHandle methodHandle,
																							List<Class<?>> params)
	{
		TriConsumer<T, Object, Object> consumer = null;
		try
		{
			final CallSite site = LambdaMetafactory.metafactory(lookup, CONSUMER_EXEC_METHOD,
					TYPE_R_TRICONSUMER, TYPE_VOID_OBJECT_OBJECT_OBJECT, methodHandle,
					MethodType.methodType(Void.TYPE, params));

			consumer = (TriConsumer<T, Object, Object>) site.getTarget().invokeExact();

		} catch (final Throwable e)
		{
			e.printStackTrace();
		}

		return consumer;
	}
}
