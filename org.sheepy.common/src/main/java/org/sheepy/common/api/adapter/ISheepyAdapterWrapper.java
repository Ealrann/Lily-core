package org.sheepy.common.api.adapter;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

public interface ISheepyAdapterWrapper
{
	ISheepyAdapter adapt(EObject target, ISheepyAdapterFactory adapterFactory);

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
