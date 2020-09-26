package org.sheepy.lily.core.reflect.constructor;

import org.sheepy.lily.core.api.reflect.ConstructorHandle;
import org.sheepy.lily.core.reflect.util.MethodHandleContext;
import org.sheepy.lily.core.reflect.util.ReflectionUtil;

import java.lang.reflect.Constructor;
import java.util.function.BiFunction;

public final class ConstructorHandleParam2<T> implements ConstructorHandle<T>
{
	private final BiFunction<Object, Object, T> function;
	private final Constructor<T> constructor;

	private ConstructorHandleParam2(BiFunction<Object, Object, T> function, Constructor<T> constructor)
	{
		this.function = function;
		this.constructor = constructor;
	}

	@Override
	public T newInstance(Object... parameters)
	{
		return function.apply(parameters[0], parameters[1]);
	}

	@Override
	public Constructor<T> getJavaConstructor()
	{
		return constructor;
	}

	public static final class Builder<T> extends ConstructorHandleBuilder<T>
	{
		private final ConstructorHandle<T> handle;

		public Builder(final MethodHandleContext context, final Constructor<T> constructor) throws Throwable
		{
			final BiFunction<Object, Object, T> function = ReflectionUtil.createBiFunction(context);
			handle = new ConstructorHandleParam2<>(function, constructor);
		}

		@Override
		public ConstructorHandle<T> build()
		{
			return handle;
		}
	}
}
