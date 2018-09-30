package org.sheepy.common.api.adapter.impl;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.sheepy.common.api.adapter.ISheepyAdapter;
import org.sheepy.common.api.adapter.ISheepyAdapterFactory;
import org.sheepy.common.api.adapter.ISheepyAdapterRegistry;
import org.sheepy.common.api.adapter.ISheepyAdapterWrapper;
import org.sheepy.common.model.types.SObject;

/**
 * Extensible Mapped AdapterFactory.
 * 
 * @author Ealrann
 *
 */
public abstract class AbstractSheepyAdapterFactory implements ISheepyAdapterFactory
{

	private ISheepyAdapterRegistry registry = null;

	private void load()
	{
		if (registry == null)
		{
			registry = getRegistry();
		}
	}

	public boolean isFactoryForType(Object object)
	{
		load();
		for (ISheepyAdapterWrapper extension : registry.getRegisteredAdapters())
		{
			if (extension.isAdapterForType(object))
			{
				return true;
			}
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public Adapter adapt(Notifier target, Object type)
	{
		return adapt((SObject) target, (Class<ISheepyAdapter>) type);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends ISheepyAdapter> T adapt(SObject target, Class<T> type)
	{
		load();
		ISheepyAdapterWrapper extension = registry.getAdapterFor(target, type);
		T res = (T) extension.adapt(target, this);

		if (res == null)
		{
			logUnregisteredAdapter(target, type);
		}

		return res;
	}

	private void logUnregisteredAdapter(SObject target, Class<?> type)
	{
		if (type instanceof Class) System.err.println("Error : Can't adapt "
				+ ((EObject) target).eClass().getName()
				+ " to "
				+ ((Class<?>) type).getSimpleName());
		else System.err.println("Error : Can't adapt "
				+ ((EObject) target).eClass().getName()
				+ " to "
				+ type.getClass().getSimpleName());
	}

	protected abstract ISheepyAdapterRegistry getRegistry();
}
