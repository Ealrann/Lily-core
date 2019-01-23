package org.sheepy.lily.core.api.adapter.impl;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.IStatefullAdapter;

public abstract class AbstractStatefullAdapter extends AbstractSingletonAdapter implements IStatefullAdapter
{
	protected EObject target = null;
	
	public AbstractStatefullAdapter()
	{
		super();
	}

	@Override
	public void setTarget(Notifier newTarget)
	{
		this.target = (EObject) newTarget;
	}
	
	@Override
	public Notifier getTarget()
	{
		return target;
	}
	
	@Override
	public void unsetTarget(Notifier oldTarget)
	{
		target = null;
	}

	@Override
	public boolean isAdapterForType(Class<? extends IAdapter> type)
	{
		return ((Class<?>) type).isInstance(this);
	}
}
