package org.sheepy.lily.core.reflect;

import org.sheepy.lily.core.api.reflect.IExecutionHandleBuilder;
import org.sheepy.lily.core.reflect.execution.ConsumerHandleBuilder;
import org.sheepy.lily.core.reflect.supplier.SupplierHandleBuilder;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;

public abstract sealed class ExecutionHandleBuilder implements IExecutionHandleBuilder permits ConsumerHandleBuilder,
																							   SupplierHandleBuilder
{
	public static ExecutionHandleBuilder fromMethod(final MethodHandles.Lookup lookup,
													final Method method) throws ReflectiveOperationException
	{
		if (method.getReturnType() != Void.TYPE)
		{
			return SupplierHandleBuilder.fromMethod(lookup, method);
		}
		else
		{
			return ConsumerHandleBuilder.fromMethod(lookup, method);
		}
	}
}
