package org.sheepy.lily.core.api.adapter;

import org.eclipse.emf.ecore.impl.EObjectImpl;

public class LilyEObject extends EObjectImpl implements ILilyEObject
{
	private IAdapterManager adapterManager = null;

	@Override
	public void setAdapterManager(IAdapterManager adapterManager)
	{
		if (this.adapterManager != null)
		{
			eAdapters().remove(this.adapterManager);
		}

		this.adapterManager = adapterManager;

		if (adapterManager != null)
		{
			eAdapters().add(adapterManager);
		}
	}

	@Override
	public IAdapterManager getAdapterManager()
	{
		return adapterManager;
	}
}
