package org.sheepy.common.api.adapter;

import org.eclipse.emf.ecore.EObject;

public interface ISheepyAdapterFactory
{
	<T extends ISheepyAdapter> T adapt(EObject lilyObject, Class<T> classifier);
}
