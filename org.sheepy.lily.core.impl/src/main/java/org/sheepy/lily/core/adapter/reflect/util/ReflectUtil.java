package org.sheepy.lily.core.adapter.reflect.util;

import java.lang.invoke.CallSite;
import java.lang.invoke.LambdaConversionException;
import java.lang.invoke.LambdaMetafactory;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.invoke.MethodType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.adapter.reflect.ConstructorHandle.Builder;
import org.sheepy.lily.core.api.util.Operation;

public final class ReflectUtil
{
	private static final MethodType TYPE_R_OPERATION = MethodType.methodType(Operation.class);
	private static final MethodType TYPE_R_CONSUMER = MethodType.methodType(Consumer.class);
	private static final MethodType TYPE_R_FUNCTION = MethodType.methodType(Function.class);
	private static final MethodType TYPE_R_SUPPLIER = MethodType.methodType(Supplier.class);
	private static final MethodType TYPE_R_BICONSUMER = MethodType.methodType(BiConsumer.class);
	private static final MethodType TYPE_VOID_VOID = MethodType.methodType(Void.TYPE);
	private static final MethodType TYPE_OBJECT_VOID = MethodType.methodType(Object.class);
	private static final MethodType TYPE_VOID_OBJECT = MethodType.methodType(	Void.TYPE,
																				Object.class);
	private static final MethodType TYPE_VOID_OBJECT_OBJECT = MethodType.methodType(Void.TYPE,
																					Object.class,
																					Object.class);
	private static final String OPERATION_EXEC_METHOD = "execute";
	private static final String CONSUMER_EXEC_METHOD = "accept";
	private static final String FUNCTION_EXEC_METHOD = "apply";
	private static final String SUPPLIER_EXEC_METHOD = "get";

	public static Lookup reachPrivateLookup(Class<?> sourceClass)
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

	public static MethodHandle unreflect(Constructor<?> constructor, Lookup lookup)
	{
		MethodHandle res = null;
		try
		{
			res = lookup.unreflectConstructor(constructor);

		} catch (final IllegalAccessException e)
		{
			e.printStackTrace();
		}

		return res;
	}

	public static MethodHandle unreflectSpecial(Method method, Lookup lookup, Class<?> caller)
	{
		MethodHandle res = null;
		try
		{
			if (Modifier.isStatic(method.getModifiers()) == false)
			{
				res = lookup.unreflectSpecial(method, caller);
			}
			else
			{
				res = lookup.unreflect(method);
			}

		} catch (final IllegalAccessException e)
		{
			e.printStackTrace();
		}

		return res;
	}

	public static Operation createOperation(Lookup lookup, MethodHandle methodHandle)
	{
		Operation operation = null;
		try
		{
			final CallSite site = LambdaMetafactory.metafactory(lookup,
																OPERATION_EXEC_METHOD,
																TYPE_R_OPERATION,
																TYPE_VOID_VOID,
																methodHandle,
																methodHandle.type());

			operation = (Operation) site.getTarget().invokeExact();

		} catch (final Throwable e)
		{
			e.printStackTrace();
		}

		return operation;
	}

	public static MethodHandle createOperationFactory(	Lookup lookup,
														MethodHandle methodHandle,
														Class<?> type)
	{
		MethodHandle res = null;
		try
		{
			final var factoryType = MethodType.methodType(Operation.class, type);
			final var site = LambdaMetafactory.metafactory(	lookup,
															OPERATION_EXEC_METHOD,
															factoryType,
															TYPE_VOID_VOID,
															methodHandle,
															TYPE_VOID_VOID);
			res = site.getTarget();
		} catch (final LambdaConversionException e)
		{
			e.printStackTrace();
		}
		return res;
	}

	public static <T> Consumer<T> createConsumer(Lookup lookup,
												 MethodHandle methodHandle)
	{
		Consumer<T> consumer = null;
		try
		{
			final var site = LambdaMetafactory.metafactory(	lookup,
															CONSUMER_EXEC_METHOD,
															TYPE_R_CONSUMER,
															TYPE_VOID_OBJECT,
															methodHandle,
															methodHandle.type());

			consumer = (Consumer<T>) site.getTarget().invokeExact();

		} catch (final Throwable e)
		{
			e.printStackTrace();
		}

		return consumer;
	}

	public static MethodHandle createConsumerFactory(	Lookup lookup,
														MethodHandle methodHandle,
														Class<?> type)
	{
		MethodHandle res = null;
		try
		{
			final var factoryType = MethodType.methodType(Consumer.class, type);
			final var targetType = methodHandle.type().dropParameterTypes(0, 1);
			final var site = LambdaMetafactory.metafactory(	lookup,
															CONSUMER_EXEC_METHOD,
															factoryType,
															TYPE_VOID_OBJECT,
															methodHandle,
															targetType);
			res = site.getTarget();
		} catch (final LambdaConversionException e)
		{
			e.printStackTrace();
		}
		return res;
	}

	public static <T> Supplier<T> createSupplier(Lookup lookup,
												 MethodHandle methodHandle)
	{
		Supplier<T> supplier = null;
		try
		{
			final CallSite site = LambdaMetafactory.metafactory(lookup,
																SUPPLIER_EXEC_METHOD,
																TYPE_R_SUPPLIER,
																TYPE_OBJECT_VOID,
																methodHandle,
																methodHandle.type());

			supplier = (Supplier<T>) site.getTarget().invokeExact();

		} catch (final Throwable e)
		{
			e.printStackTrace();
		}

		return supplier;
	}

	public static <T> BiConsumer<T, Object> createBiConsumer(Lookup lookup,
															 MethodHandle methodHandle)

	{
		BiConsumer<T, Object> consumer = null;
		try
		{
			final var site = LambdaMetafactory.metafactory(	lookup,
															CONSUMER_EXEC_METHOD,
															TYPE_R_BICONSUMER,
															TYPE_VOID_OBJECT_OBJECT,
															methodHandle,
															methodHandle.type());

			consumer = (BiConsumer<T, Object>) site.getTarget().invokeExact();

		} catch (final Throwable e)
		{
			e.printStackTrace();
		}

		return consumer;
	}

	public static MethodHandle createBiConsumerFactory(	Lookup lookup,
														MethodHandle methodHandle,
														Class<?> type)
	{
		MethodHandle res = null;
		try
		{
			final var factoryType = MethodType.methodType(BiConsumer.class, type);
			final var targetType = methodHandle.type().dropParameterTypes(0, 1);
			final var site = LambdaMetafactory.metafactory(	lookup,
															CONSUMER_EXEC_METHOD,
															factoryType,
															TYPE_VOID_OBJECT_OBJECT,
															methodHandle,
															targetType);
			res = site.getTarget();
		} catch (final LambdaConversionException e)
		{
			e.printStackTrace();
		}
		return res;
	}

	public static <T> Function<EObject, T> createFunction(Lookup lookup,
														  MethodHandle methodHandle)
	{
		Function<EObject, T> function = null;
		try
		{
			final CallSite site = LambdaMetafactory.metafactory(lookup,
																FUNCTION_EXEC_METHOD,
																TYPE_R_FUNCTION,
																methodHandle.type().generic(),
																methodHandle,
																methodHandle.type());

			function = (Function<EObject, T>) site.getTarget().invokeExact();

		} catch (final Throwable e)
		{
			e.printStackTrace();
		}

		return function;
	}
}
