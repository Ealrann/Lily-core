package org.sheepy.lily.core.api.reflect;

public interface SupplierHandle extends ExecutionHandle
{
	Object invoke();

	Object getLambdaFunction();
}
