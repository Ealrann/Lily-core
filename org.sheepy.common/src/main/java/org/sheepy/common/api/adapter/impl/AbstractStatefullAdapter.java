package org.sheepy.common.api.adapter.impl;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.sheepy.common.api.adapter.ISingletonAdapter;
import org.sheepy.common.api.adapter.IStatefullAdapter;

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
	public boolean isAdapterForType(Class<? extends ISingletonAdapter> type)
	{
		return ((Class<?>) type).isInstance(this);
	}
}
