package org.sheepy.lily.core.adapter.reflect.impl;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles.Lookup;
import java.util.function.Function;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.adapter.reflect.ConstructorHandle;
import org.sheepy.lily.core.adapter.reflect.util.ReflectUtil;
import org.sheepy.lily.core.api.adapter.IAdapter;

public final class ConstructorHandleParam1<T extends IAdapter> implements ConstructorHandle<T>
{
	private final Function<EObject, T> function;

	private ConstructorHandleParam1(Function<EObject, T> function)
	{
		this.function = function;
	}

	@Override
	public T newInstance(EObject parameter)
	{
		return function.apply(parameter);
	}

	public static final class Builder<T extends IAdapter> extends ConstructorHandle.Builder<T>
	{
		private final Function<EObject, T> function;

		public Builder(Lookup lookup, MethodHandle methodHandle)
		{
			this.function = ReflectUtil.createFunction(lookup, methodHandle);
		}

		@Override
		public ConstructorHandle<T> build()
		{
			return new ConstructorHandleParam1<>(function);
		}
	}
}