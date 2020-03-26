package org.sheepy.lily.core.adapter.reflect;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.adapter.reflect.impl.ConstructorHandleNoParam;
import org.sheepy.lily.core.adapter.reflect.impl.ConstructorHandleParam1;
import org.sheepy.lily.core.adapter.reflect.util.ReflectUtil;
import org.sheepy.lily.core.api.adapter.IAdapter;

import java.lang.reflect.Constructor;

public interface ConstructorHandle<T extends IAdapter>
{
	T newInstance(EObject parameter);

	abstract class Builder<T extends IAdapter>
	{
		public static final <T extends IAdapter> Builder<T> fromMethod(Constructor<T> constructor)
		{
			final var sourceClass = constructor.getDeclaringClass();
			final int paramCount = constructor.getParameterCount();
			final var privateLookup = ReflectUtil.reachLookup(sourceClass);

			try
			{
				final var methodHandle = ReflectUtil.unreflect(constructor, privateLookup);
				return switch (paramCount)
						{
							case 0 -> new ConstructorHandleNoParam.Builder<>(privateLookup, methodHandle);
							case 1 -> new ConstructorHandleParam1.Builder<>(privateLookup, methodHandle);
							default -> throw new AssertionError("Constructor not found");
						};
			}
			catch (final Throwable e)
			{
				new Exception("Cannot create Handle for Constructor: " + constructor, e).printStackTrace();
				return null;
			}
		}

		public abstract ConstructorHandle<T> build();
	}
}
