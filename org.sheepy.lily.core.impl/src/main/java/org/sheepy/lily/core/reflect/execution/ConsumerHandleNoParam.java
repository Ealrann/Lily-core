package org.sheepy.lily.core.reflect.execution;

import org.sheepy.lily.core.reflect.util.ReflectionUtil;
import org.sheepy.lily.core.api.reflect.ConsumerHandle;

import java.lang.invoke.LambdaConversionException;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles.Lookup;

public final class ConsumerHandleNoParam implements ConsumerHandle
{
	private final Runnable runnable;

	private ConsumerHandleNoParam(Runnable runnable)
	{
		this.runnable = runnable;
	}

	@Override
	public void invoke(Object... parameters)
	{
		runnable.run();
	}

	@Override
	public Object getLambdaFunction()
	{
		return runnable;
	}

	public static final class Builder extends ConsumerHandleBuilder
	{
		private final MethodHandle factory;

		public Builder(Lookup lookup, MethodHandle methodHandle, Class<?> type) throws LambdaConversionException
		{
			factory = ReflectionUtil.createRunnableFactory(lookup, methodHandle, type);
		}

		@Override
		public ConsumerHandle build(Object target)
		{
			try
			{
				final var runnable = (Runnable) factory.invoke(target);
				return new ConsumerHandleNoParam(runnable);

			}
			catch (final Throwable e)
			{
				e.printStackTrace();
				return null;
			}
		}
	}

	public static final class StaticBuilder extends ConsumerHandleBuilder
	{
		private final ConsumerHandle handle;

		public StaticBuilder(Lookup lookup, MethodHandle methodHandle) throws Throwable
		{
			final var runnable = ReflectionUtil.createRunnable(lookup, methodHandle);
			handle = new ConsumerHandleNoParam(runnable);
		}

		@Override
		public ConsumerHandle build(Object target)
		{
			return handle;
		}
	}
}
