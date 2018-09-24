package org.sheepy.common.api.adapter.impl;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sheepy.common.api.adapter.ISheepyAdapter;
import org.sheepy.common.api.adapter.ISheepyAdapterFactory;
import org.sheepy.common.api.adapter.ISheepyAdapterRegistry;
import org.sheepy.common.model.types.SObject;

/**
 * Extensible Mapped AdapterFactory.
 * 
 * @author Ealrann
 *
 */
public abstract class AbstractSheepyAdapterFactory extends AdapterFactoryImpl
		implements ISheepyAdapterFactory
{

	private ISheepyAdapterRegistry registry = null;

	private void load()
	{
		if (registry == null)
		{
			registry = getRegistry();
		}
	}

	@Override
	public boolean isFactoryForType(Object object)
	{
		load();
		for (ISheepyAdapter extension : registry.getRegisteredAdapters())
		{
			if (extension.isAdapterForType(object))
			{
				return true;
			}
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Adapter createAdapter(Notifier target, Object adapterType)
	{
		load();
		ISheepyAdapter adapter = null;
		EClass clazz = ((EObject) target).eClass();

		ISheepyAdapter defaultExtension = null;
		ISheepyAdapter retainedExtension = null;

		for (ISheepyAdapter extension : registry.getRegisteredAdapters())
		{
			if (extension.isAdapterForType(adapterType) && extension.isApplicable(clazz))
			{
				if (extension.isDefaultAdapter())
				{
					defaultExtension = extension;
				}
				else
				{
					retainedExtension = extension;
					break;
				}
			}
		}

		if (retainedExtension == null)
		{
			retainedExtension = defaultExtension;
		}

		if (retainedExtension != null)
		{
			adapter = retainedExtension.createAdapter((SObject) target,
					(Class<? extends ISheepyAdapter>) adapterType);

			adapter.setAdapterFactory(this);
		}

		return adapter;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Adapter adapt(Notifier target, Object type)
	{
		return adapt((SObject) target, (Class<ISheepyAdapter>) type);
	}

	@Override
	public <T extends ISheepyAdapter> T adapt(SObject sheepyObject, Class<T> type)
	{
		load();
		T res = sheepyObject.lAdapterIndexer().adapt(this, sheepyObject, type);

		if (res == null)
		{
			if (type instanceof Class) System.err.println("Error : Can't adapt "
					+ ((EObject) sheepyObject).eClass().getName()
					+ " to "
					+ ((Class<?>) type).getSimpleName());
			else System.err.println("Error : Can't adapt "
					+ ((EObject) sheepyObject).eClass().getName()
					+ " to "
					+ type.getClass().getSimpleName());
		}
		return res;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends ISheepyAdapter> T adaptNew(SObject sheepyObject, Class<T> type)
	{
		return (T) adaptNew((Notifier) sheepyObject, type);
	}

	protected abstract ISheepyAdapterRegistry getRegistry();
}
