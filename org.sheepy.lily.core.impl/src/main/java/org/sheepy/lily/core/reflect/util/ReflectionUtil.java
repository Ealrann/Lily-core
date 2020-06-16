package org.sheepy.lily.core.reflect.util;

import java.lang.invoke.*;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.function.*;

public final class ReflectionUtil
{
	private static final MethodType TYPE_R_RUNNABLE = MethodType.methodType(Runnable.class);
	private static final MethodType TYPE_R_CONSUMER = MethodType.methodType(Consumer.class);
	private static final MethodType TYPE_R_FUNCTION = MethodType.methodType(Function.class);
	private static final MethodType TYPE_R_BIFUNCTION = MethodType.methodType(BiFunction.class);
	private static final MethodType TYPE_R_SUPPLIER = MethodType.methodType(Supplier.class);
	private static final MethodType TYPE_R_BICONSUMER = MethodType.methodType(BiConsumer.class);
	private static final MethodType TYPE_VOID_VOID = MethodType.methodType(Void.TYPE);
	private static final MethodType TYPE_OBJECT_VOID = MethodType.methodType(Object.class);
	private static final MethodType TYPE_VOID_OBJECT = MethodType.methodType(Void.TYPE, Object.class);
	private static final MethodType TYPE_VOID_OBJECT_OBJECT = MethodType.methodType(Void.TYPE,
																					Object.class,
																					Object.class);
	private static final String RUNNABLE_EXEC_METHOD = "run";
	private static final String CONSUMER_EXEC_METHOD = "accept";
	private static final String FUNCTION_EXEC_METHOD = "apply";
	private static final String SUPPLIER_EXEC_METHOD = "get";

	private static final Module MODULE = ReflectionUtil.class.getModule();

	public static Lookup reachLookup(Class<?> targetClass) throws IllegalAccessException
	{
		final var otherModule = targetClass.getModule();
		final boolean canRead = MODULE.canRead(otherModule);
		if (canRead == false)
		{
			MODULE.addReads(otherModule);
		}

		return MethodHandles.privateLookupIn(targetClass, MethodHandles.lookup());
	}

	public static MethodHandle unreflect(Constructor<?> constructor, Lookup lookup) throws IllegalAccessException
	{
		return lookup.unreflectConstructor(constructor);
	}

	public static MethodHandle unreflect(Method method, Lookup lookup, Class<?> caller) throws IllegalAccessException
	{
		if (Modifier.isStatic(method.getModifiers()) == false)
		{
			return lookup.unreflectSpecial(method, caller);
		}
		else
		{
			return lookup.unreflect(method);
		}
	}

	public static Runnable createRunnable(Lookup lookup, MethodHandle methodHandle) throws Throwable
	{
		final CallSite site = LambdaMetafactory.metafactory(lookup,
															RUNNABLE_EXEC_METHOD,
															TYPE_R_RUNNABLE,
															TYPE_VOID_VOID,
															methodHandle,
															methodHandle.type());
		return (Runnable) site.getTarget().invokeExact();
	}

	public static MethodHandle createRunnableFactory(Lookup lookup,
													 MethodHandle methodHandle,
													 Class<?> type) throws LambdaConversionException
	{
		final var factoryType = MethodType.methodType(Runnable.class, type);
		final var site = LambdaMetafactory.metafactory(lookup,
													   RUNNABLE_EXEC_METHOD,
													   factoryType,
													   TYPE_VOID_VOID,
													   methodHandle,
													   TYPE_VOID_VOID);
		return site.getTarget();
	}

	@SuppressWarnings("unchecked")
	public static <T> Consumer<T> createConsumer(Lookup lookup, MethodHandle methodHandle) throws Throwable
	{
		final var site = LambdaMetafactory.metafactory(lookup,
													   CONSUMER_EXEC_METHOD,
													   TYPE_R_CONSUMER,
													   TYPE_VOID_OBJECT,
													   methodHandle,
													   methodHandle.type());
		return (Consumer<T>) site.getTarget().invokeExact();
	}

	public static MethodHandle createConsumerFactory(Lookup lookup,
													 MethodHandle methodHandle,
													 Class<?> type) throws LambdaConversionException
	{
		final var factoryType = MethodType.methodType(Consumer.class, type);
		final var targetType = methodHandle.type().dropParameterTypes(0, 1);
		final var site = LambdaMetafactory.metafactory(lookup,
													   CONSUMER_EXEC_METHOD,
													   factoryType,
													   TYPE_VOID_OBJECT,
													   methodHandle,
													   targetType);
		return site.getTarget();
	}

	@SuppressWarnings("unchecked")
	public static <T> Supplier<T> createSupplier(Lookup lookup, MethodHandle methodHandle) throws Throwable
	{
		final CallSite site = LambdaMetafactory.metafactory(lookup,
															SUPPLIER_EXEC_METHOD,
															TYPE_R_SUPPLIER,
															TYPE_OBJECT_VOID,
															methodHandle,
															methodHandle.type());
		return (Supplier<T>) site.getTarget().invokeExact();
	}

	public static MethodHandle createSupplierFactory(Lookup lookup,
													 MethodHandle methodHandle,
													 Class<?> type) throws LambdaConversionException
	{
		final var factoryType = MethodType.methodType(Supplier.class, type);
		final var site = LambdaMetafactory.metafactory(lookup,
													   SUPPLIER_EXEC_METHOD,
													   factoryType,
													   TYPE_OBJECT_VOID,
													   methodHandle,
													   TYPE_OBJECT_VOID);
		return site.getTarget();
	}

	@SuppressWarnings("unchecked")
	public static <T> BiConsumer<T, Object> createBiConsumer(Lookup lookup, MethodHandle methodHandle) throws Throwable
	{
		final var site = LambdaMetafactory.metafactory(lookup,
													   CONSUMER_EXEC_METHOD,
													   TYPE_R_BICONSUMER,
													   TYPE_VOID_OBJECT_OBJECT,
													   methodHandle,
													   methodHandle.type());
		return (BiConsumer<T, Object>) site.getTarget().invokeExact();
	}

	public static MethodHandle createBiConsumerFactory(Lookup lookup,
													   MethodHandle methodHandle,
													   Class<?> type) throws LambdaConversionException
	{
		final var factoryType = MethodType.methodType(BiConsumer.class, type);
		final var targetType = methodHandle.type().dropParameterTypes(0, 1);
		final var site = LambdaMetafactory.metafactory(lookup,
													   CONSUMER_EXEC_METHOD,
													   factoryType,
													   TYPE_VOID_OBJECT_OBJECT,
													   methodHandle,
													   targetType);
		return site.getTarget();
	}

	@SuppressWarnings("unchecked")
	public static <T> Function<Object, T> createFunction(Lookup lookup, MethodHandle methodHandle) throws Throwable
	{
		final CallSite site = LambdaMetafactory.metafactory(lookup,
															FUNCTION_EXEC_METHOD,
															TYPE_R_FUNCTION,
															methodHandle.type().generic(),
															methodHandle,
															methodHandle.type());
		return (Function<Object, T>) site.getTarget().invokeExact();
	}

	@SuppressWarnings("unchecked")
	public static <T> BiFunction<Object, Object, T> createBiFunction(Lookup lookup,
																	 MethodHandle methodHandle) throws Throwable
	{
		final CallSite site = LambdaMetafactory.metafactory(lookup,
															FUNCTION_EXEC_METHOD,
															TYPE_R_BIFUNCTION,
															methodHandle.type().generic(),
															methodHandle,
															methodHandle.type());
		return (BiFunction<Object, Object, T>) site.getTarget().invokeExact();
	}
}
