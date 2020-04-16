package org.sheepy.lily.core.adapter.reflect.impl;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.adapter.reflect.ConstructorHandle;
import org.sheepy.lily.core.adapter.reflect.util.ReflectionUtil;
import org.sheepy.lily.core.api.adapter.IAdapter;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles.Lookup;
import java.util.function.Function;

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
		private final ConstructorHandle<T> handle;

		public Builder(Lookup lookup, MethodHandle methodHandle) throws Throwable
		{
			final Function<EObject, T> function = ReflectionUtil.createFunction(lookup, methodHandle);
			handle = new ConstructorHandleParam1<>(function);
		}

		@Override
		public ConstructorHandle<T> build()
		{
			return handle;
		}
	}
}
