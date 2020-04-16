package org.sheepy.lily.core.api.util;

public interface ExecutionHandle
{
	void invoke(Object... parameters);

	Object getLambdaFunction();
}
