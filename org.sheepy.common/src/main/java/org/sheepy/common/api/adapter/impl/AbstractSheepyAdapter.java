package org.sheepy.common.api.adapter.impl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.sheepy.common.api.adapter.ISheepyAdapter;
import org.sheepy.common.api.adapter.ISheepyAdapterFactory;
import org.sheepy.common.model.types.SObject;

public abstract class AbstractSheepyAdapter
		implements Adapter.Internal, ISheepyAdapter
{
	/**
	 * The last notifier set to this adapter.
	 */
	protected SObject target = null;

	protected ISheepyAdapterFactory adapterFactory;

	protected AbstractSheepyAdapter creator = null;

	protected HashMap<SObject, AbstractSheepyAdapter> targets = null;

	/**
	 * Creates an instance.
	 */
	public AbstractSheepyAdapter()
	{
		super();
	}

	@Override
	public final void setLilyAdapterFactory(ISheepyAdapterFactory adapterFactory)
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
	public boolean isDefaultAdapter()
	{
		return false;
	}

	@Override
	public boolean isAdapterForType(Class<? extends ISheepyAdapter> type)
	{
		return ((Class<?>) type).isInstance(this);
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
		target = (SObject) newTarget;
	}

	private void registerAdapter(	SObject newTarget,
									AbstractSheepyAdapter adapter)
	{
		if (creator != null)
		{
			creator.registerAdapter(newTarget, adapter);
		}
		else
		{
			if (targets == null)
			{
				targets = new HashMap<>();
			}
			targets.put(newTarget, adapter);
		}
	}

	/*
	 * Javadoc copied from interface.
	 */
	@Override
	public final void unsetTarget(Notifier oldTarget)
	{
		setTarget(null);

		unregisterAdapter(oldTarget, this);
	}

	private void unregisterAdapter(	Notifier newTarget,
									AbstractSheepyAdapter adapter)
	{
		if (creator != null)
		{
			creator.unregisterAdapter(newTarget, adapter);
		}
		else
		{
			if (targets != null)
			{
				targets.remove(newTarget, adapter);
			}
		}
	}

	@Override
	public void removeAllAdapters()
	{
		if (creator != null)
		{
			creator.removeAllAdapters();
		}
		else if (targets != null)
		{
			for (Notifier notifier : new ArrayList<>(targets.keySet()))
			{
				if (notifier instanceof SObject)
				{
					((SObject) notifier).getAdapterIndexer()
							.removeAdapter(targets.get(notifier));
				}
				notifier.eAdapters().remove(targets.get(notifier));
			}
		}
	}

	@Override
	public ISheepyAdapter createAdapter(SObject lilyObject,
										Class<? extends ISheepyAdapter> type)
	{
		AbstractSheepyAdapter adapter = null;

		if (isSingleton())
		{
			adapter = this;
		}
		else
		{
			adapter = instantiateNew();
			adapter.creator = this;
		}

		registerAdapter(lilyObject, adapter);

		return adapter;
	}

	protected AbstractSheepyAdapter instantiateNew()
	{
		AbstractSheepyAdapter res = null;
		// If the service already exists, we make a new Instance
		try
		{
			Constructor<? extends AbstractSheepyAdapter> constructor = getClass()
					.getConstructor();
			res = constructor.newInstance();

		} catch (NoSuchMethodException | SecurityException
				| InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e)
		{
			e.printStackTrace();
		}

		return res;
	}
}
