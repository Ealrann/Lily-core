package org.sheepy.common.api.adapter.impl;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.sheepy.common.api.adapter.ISheepyAdapter;
import org.sheepy.common.api.adapter.ISheepyAdapterFactory;

public abstract class AbstractSheepyAdapter implements Adapter.Internal, ISheepyAdapter
{
	/**
	 * The last notifier set to this adapter.
	 */
	protected EObject target = null;

	protected ISheepyAdapterFactory adapterFactory;

	protected SheepyAdapterWrapper creator = null;

	/**
	 * Creates an instance.
	 */
	public AbstractSheepyAdapter()
	{
		super();
	}

	@Override
	public final void setAdapterFactory(ISheepyAdapterFactory adapterFactory)
	{
		this.adapterFactory = adapterFactory;
	}

	@Override
	public final ISheepyAdapterFactory getLilyAdapterFactory()
	{
		return adapterFactory;
	}

	public boolean isSingleton()
	{
		return true;
	}

	@Override
	public boolean isAdapterForType(Class<? extends ISheepyAdapter> type)
	{
		return creator.isAdapterForType(type);
	}

	/**
	 * Does nothing; clients may override so that it does something.
	 */
	@Override
	public void notifyChanged(Notification msg)
	{
		// Do nothing.
	}

	/*
	 * Javadoc copied from interface.
	 */
	@Override
	public Notifier getTarget()
	{
		return target;
	}

	/*
	 * Javadoc copied from interface.
	 */
	@Override
	public void setTarget(Notifier newTarget)
	{
		if (target != newTarget)
		{
			if (target != null)
			{
				unload();
			}

			target = (EObject) newTarget;

			if (target != null)
			{
				load();
			}
		}
	}

	protected void load()
	{}

	protected void unload()
	{}

	/*
	 * Javadoc copied from interface.
	 */
	@Override
	public final void unsetTarget(Notifier oldTarget)
	{
		setTarget(null);
	}
}
