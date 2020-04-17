package org.sheepy.lily.core.reflect.supplier;

import org.sheepy.lily.core.reflect.ExecutionHandleBuilder;
import org.sheepy.lily.core.reflect.util.ReflectionUtil;
import org.sheepy.lily.core.api.reflect.SupplierHandle;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public abstract class SupplierHandleBuilder extends ExecutionHandleBuilder
{
	public static final SupplierHandleBuilder fromMethod(Method method) throws ReflectiveOperationException
	{
		final var type = method.getDeclaringClass();
		final var lookup = ReflectionUtil.reachLookup(type);
		final var isStatic = Modifier.isStatic(method.getModifiers());

		try
		{
			final var methodHandle = ReflectionUtil.unreflect(method, lookup, type);
			return buildNoArgs(type, lookup, methodHandle, isStatic);
		}
		catch (final Throwable e)
		{
			throw new ReflectiveOperationException("Cannot create Handle for Method: " + method, e);
		}
	}

	private static SupplierHandleBuilder buildNoArgs(final Class<?> type,
													 final Lookup lookup,
													 final MethodHandle methodHandle,
													 final boolean isStatic) throws Throwable
	{
		if (methodHandle.type().returnType() == Boolean.TYPE)
		{
			if (isStatic) return new BooleanSupplierHandle.StaticBuilder(lookup, methodHandle);
			else return new BooleanSupplierHandle.Builder(lookup, methodHandle, type);
		}
		else
		{
			if (isStatic) return new ObjectSupplierHandle.StaticBuilder(lookup, methodHandle);
			else return new ObjectSupplierHandle.Builder(lookup, methodHandle, type);
		}
	}

	@Override
	public abstract SupplierHandle build(Object target);
}