package org.sheepy.lily.core.adapter.reflect;

import java.lang.reflect.Constructor;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.adapter.reflect.impl.ConstructorHandleNoParam;
import org.sheepy.lily.core.adapter.reflect.impl.ConstructorHandleParam1;
import org.sheepy.lily.core.adapter.reflect.util.ReflectUtil;
import org.sheepy.lily.core.api.adapter.IAdapter;

public interface ConstructorHandle<T extends IAdapter>
{
	T newInstance(EObject parameter);

	abstract class Builder<T extends IAdapter>
	{
		public static final <T extends IAdapter> Builder<T> fromMethod(Constructor<T> constructor)
		{
			final var sourceClass = constructor.getDeclaringClass();
			final int paramCount = constructor.getParameterCount();
			final var privateLookup = ReflectUtil.reachPrivateLookup(sourceClass);
			final var methodHandle = ReflectUtil.unreflect(constructor, privateLookup);

			switch (paramCount)
			{
				case 0:
					return new ConstructorHandleNoParam.Builder<>(privateLookup, methodHandle);
				case 1:
					return new ConstructorHandleParam1.Builder<>(privateLookup, methodHandle);
				default:
					throw new AssertionError("Constructor not found");
			}
		}

		public abstract ConstructorHandle<T> build();
	}
}
