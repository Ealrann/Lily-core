package org.sheepy.lily.core.reflect;

import org.sheepy.lily.core.api.reflect.IExecutionHandleBuilder;
import org.sheepy.lily.core.reflect.execution.ConsumerHandleBuilder;
import org.sheepy.lily.core.reflect.supplier.SupplierHandleBuilder;

import java.lang.reflect.Method;

public abstract class ExecutionHandleBuilder implements IExecutionHandleBuilder
{
	public static ExecutionHandleBuilder fromMethod(Method method) throws ReflectiveOperationException
	{
		if (method.getReturnType() != Void.TYPE)
		{
			return SupplierHandleBuilder.fromMethod(method);
		}
		else
		{
			return ConsumerHandleBuilder.fromMethod(method);
		}
	}
}
