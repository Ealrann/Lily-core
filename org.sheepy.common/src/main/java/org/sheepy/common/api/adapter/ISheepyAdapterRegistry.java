package org.sheepy.common.api.adapter;

import java.util.Collection;

import org.sheepy.common.model.types.SObject;

public interface ISheepyAdapterRegistry
{
	Collection<ISheepyAdapterWrapper> getRegisteredAdapters();

	ISheepyAdapterWrapper getAdapterFor(SObject target, Class<? extends ISheepyAdapter> type);
}
