package org.sheepy.common.api.adapter;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;

public interface ISheepyAdapterRegistry
{
	Collection<ISheepyAdapterWrapper> getRegisteredAdapters();

	ISheepyAdapterWrapper getAdapterFor(EObject target, Class<? extends ISheepyAdapter> type);
}
