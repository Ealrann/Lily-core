package org.sheepy.lily.core.api.adapter;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

public class LilyEObject extends MinimalEObjectImpl implements ILilyEObject
{
	private IAdapterManager adapterManager = null;
	private InternalEObject eContainer;

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

	@Override
	public InternalEObject eInternalContainer()
	{
		return eContainer;
	}

	@Override
	protected void eBasicSetContainer(InternalEObject newContainer)
	{
		eContainer = newContainer;
	}
}
