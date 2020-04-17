package org.sheepy.lily.core.api.reflect;

public interface ConsumerHandle extends ExecutionHandle
{
	void invoke(Object... parameters);

	Object getLambdaFunction();
}
