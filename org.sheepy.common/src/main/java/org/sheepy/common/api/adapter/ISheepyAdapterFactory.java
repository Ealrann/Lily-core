package org.sheepy.common.api.adapter;

import org.sheepy.common.model.types.SObject;

public interface ISheepyAdapterFactory
{
	<T extends ISheepyAdapter> T adapt(SObject lilyObject, Class<T> classifier);
}
