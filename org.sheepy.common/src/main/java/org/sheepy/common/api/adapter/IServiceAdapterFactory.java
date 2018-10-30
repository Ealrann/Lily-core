package org.sheepy.common.api.adapter;

import org.eclipse.emf.ecore.EObject;

public interface IServiceAdapterFactory
{
	<T extends IServiceAdapter> T adapt(EObject lilyObject, Class<T> classifier);

	void loadAutoAdapters(EObject target);

	void disposeAutoAdapters(EObject target);
}
