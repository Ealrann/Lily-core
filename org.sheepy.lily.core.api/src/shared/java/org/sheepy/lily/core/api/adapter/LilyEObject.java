package org.sheepy.lily.core.api.adapter;

import org.eclipse.emf.ecore.impl.EObjectImpl;

public class LilyEObject extends EObjectImpl implements ILilyEObject
{
	private static final String CANNOT_FIND_ADAPTER_S_FOR_CLASS_S = "Cannot find adapter [%s] for class [%s]";

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

	@Override
	public <T extends IAdapter> T adapt(Class<T> type)
	{
		if (adapterManager != null)
		{
			return adapterManager.adapt(type);
		}
		else
		{
			return IAdapterFactoryService.INSTANCE.adapt(this, type);
		}
	}

	@Override
	public <T extends IAdapter> T adaptNotNull(Class<T> type)
	{
		final T adapt = adapt(type);
		if (adapt == null)
		{
			final var message = String.format(	CANNOT_FIND_ADAPTER_S_FOR_CLASS_S,
												type.getSimpleName(),
												eClass().getName());
			throw new NullPointerException(message);
		}
		return adapt;
	}
}
