package org.sheepy.lily.core.api.adapter;

import org.eclipse.emf.ecore.EObject;

public interface ILilyEObject extends EObject
{
	void setAdapterManager(IAdapterManager adapterManager);
	IAdapterManager getAdapterManager();
}
