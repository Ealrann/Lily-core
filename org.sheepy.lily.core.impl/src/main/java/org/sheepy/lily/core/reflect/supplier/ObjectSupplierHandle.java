package org.sheepy.lily.core.reflect.supplier;

import org.sheepy.lily.core.reflect.util.ReflectionUtil;
import org.sheepy.lily.core.api.reflect.SupplierHandle;

import java.lang.invoke.LambdaConversionException;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles.Lookup;
import java.util.function.Supplier;

public final class ObjectSupplierHandle implements SupplierHandle
{
	private final Supplier<Object> supplier;

	private ObjectSupplierHandle(Supplier<Object> supplier)
	{
		this.supplier = supplier;
	}

	@Override
	public Object invoke()
	{
		return supplier.get();
	}

	@Override
	public Object getLambdaFunction()
	{
		return supplier;
	}

	public static final class Builder extends SupplierHandleBuilder
	{
		private final MethodHandle factory;

		public Builder(Lookup lookup, MethodHandle methodHandle, Class<?> type) throws LambdaConversionException
		{
			factory = ReflectionUtil.createSupplierFactory(lookup, methodHandle, type);
		}

		@Override
		@SuppressWarnings("unchecked")
		public ObjectSupplierHandle build(Object target)
		{
			try
			{
				final var supplier = (Supplier<Object>) factory.invoke(target);
				return new ObjectSupplierHandle(supplier);

			}
			catch (final Throwable e)
			{
				e.printStackTrace();
				return null;
			}
		}
	}

	public static final class StaticBuilder extends SupplierHandleBuilder
	{
		private final ObjectSupplierHandle handle;

		public StaticBuilder(Lookup lookup, MethodHandle methodHandle) throws Throwable
		{
			final var supplier = ReflectionUtil.createSupplier(lookup, methodHandle);
			handle = new ObjectSupplierHandle(supplier);
		}

		@Override
		public ObjectSupplierHandle build(Object target)
		{
			return handle;
		}
	}
}
