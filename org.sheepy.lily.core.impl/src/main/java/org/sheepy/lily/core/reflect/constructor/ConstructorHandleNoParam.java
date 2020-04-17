package org.sheepy.lily.core.reflect.constructor;

import org.sheepy.lily.core.reflect.util.ReflectionUtil;
import org.sheepy.lily.core.api.reflect.ConstructorHandle;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.reflect.Constructor;
import java.util.function.Supplier;

public final class ConstructorHandleNoParam<T> implements ConstructorHandle<T>
{
	private final Supplier<T> supplier;
	private final Constructor<T> constructor;

	private ConstructorHandleNoParam(Supplier<T> supplier, Constructor<T> constructor)
	{
		this.supplier = supplier;
		this.constructor = constructor;
	}

	@Override
	public T newInstance(Object... parameters)
	{
		return supplier.get();
	}

	@Override
	public Constructor<T> getJavaConstructor()
	{
		return constructor;
	}

	public static final class Builder<T> extends ConstructorHandleBuilder<T>
	{
		private final ConstructorHandle<T> handle;

		public Builder(Lookup lookup, MethodHandle methodHandle, Constructor<T> constructor) throws Throwable
		{
			final Supplier<T> supplier = ReflectionUtil.createSupplier(lookup, methodHandle);
			handle = new ConstructorHandleNoParam<>(supplier, constructor);
		}

		@Override
		public ConstructorHandle<T> build()
		{
			return handle;
		}
	}
}
