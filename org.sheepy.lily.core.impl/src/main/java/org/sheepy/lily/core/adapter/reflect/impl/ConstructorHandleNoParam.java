package org.sheepy.lily.core.adapter.reflect.impl;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles.Lookup;
import java.util.function.Supplier;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.adapter.reflect.ConstructorHandle;
import org.sheepy.lily.core.adapter.reflect.util.ReflectUtil;
import org.sheepy.lily.core.api.adapter.IAdapter;

public final class ConstructorHandleNoParam<T extends IAdapter> implements ConstructorHandle<T>
{
	private final Supplier<T> supplier;

	private ConstructorHandleNoParam(Supplier<T> supplier)
	{
		this.supplier = supplier;
	}

	@Override
	public T newInstance(EObject parameter)
	{
		return supplier.get();
	}

	public static final class Builder<T extends IAdapter> extends ConstructorHandle.Builder<T>
	{
		private final Supplier<T> supplier;

		public Builder(Lookup lookup, MethodHandle methodHandle, Class<T> sourceClass)
		{
			this.supplier = ReflectUtil.createSupplier(lookup, methodHandle);
		}

		@Override
		public ConstructorHandle<T> build()
		{
			return new ConstructorHandleNoParam<>(supplier);
		}
	}
}
