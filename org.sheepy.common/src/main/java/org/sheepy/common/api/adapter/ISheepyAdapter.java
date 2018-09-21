package org.sheepy.common.api.adapter;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EClass;
import org.sheepy.common.model.types.SObject;

public interface ISheepyAdapter extends Adapter
{
	@Override
	@SuppressWarnings("unchecked")
	default boolean isAdapterForType(Object type)
	{
		if (type instanceof Class<?>)
			return isAdapterForType((Class<? extends ISheepyAdapter>) type);
		else return false;
	}

	boolean isAdapterForType(Class<? extends ISheepyAdapter> type);

	boolean isApplicable(EClass eClass);

	ISheepyAdapterFactory getLilyAdapterFactory();

	void setLilyAdapterFactory(ISheepyAdapterFactory adapterFactory);

	void removeAllAdapters();

	ISheepyAdapter createAdapter(SObject lilyObject, Class<? extends ISheepyAdapter> type);
	
	 /**
	 * If true, be used only if no other implementation is provided
	 *
	 * @return
	 */
	 boolean isDefaultAdapter();
}
