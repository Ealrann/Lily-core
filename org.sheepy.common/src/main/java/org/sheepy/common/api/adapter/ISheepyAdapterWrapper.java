package org.sheepy.common.api.adapter;

import org.eclipse.emf.ecore.EClass;
import org.sheepy.common.model.types.SObject;

public interface ISheepyAdapterWrapper
{
	ISheepyAdapter adapt(SObject target, ISheepyAdapterFactory adapterFactory);

	@SuppressWarnings("unchecked")
	default boolean isAdapterForType(Object type)
	{
		if (type instanceof Class<?>)
			return isAdapterForType((Class<? extends ISheepyAdapter>) type);
		else return false;
	}

	boolean isAdapterForType(Class<? extends ISheepyAdapter> type);

	boolean isDefaultAdapter();

	boolean isApplicable(EClass eClass);

}
