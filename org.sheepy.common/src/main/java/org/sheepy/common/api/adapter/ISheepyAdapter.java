package org.sheepy.common.api.adapter;

import org.eclipse.emf.common.notify.Adapter;

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

	ISheepyAdapterFactory getLilyAdapterFactory();

	void setAdapterFactory(ISheepyAdapterFactory adapterFactory);
}
