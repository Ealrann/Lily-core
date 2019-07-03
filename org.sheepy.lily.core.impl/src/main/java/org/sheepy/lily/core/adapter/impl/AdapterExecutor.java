package org.sheepy.lily.core.adapter.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.adapter.ITickDescriptor;
import org.sheepy.lily.core.adapter.impl.ServiceAdapterRegistry.AdapterDescriptor;
import org.sheepy.lily.core.adapter.reflect.ExecutionHandle;
import org.sheepy.lily.core.api.adapter.IAdapter;

public final class AdapterExecutor<T extends IAdapter>
		extends ServiceAdapterRegistry.AdapterDescriptor<T> implements ITickDescriptor
{
	public final T adapter;
	private final EObject target;

	private final ExecutionHandle loadHandle;
	private final ExecutionHandle disposeHandle;
	private final ExecutionHandle tickHandle;
	private final ExecutionHandle notifyHandle;

	AdapterExecutor(AdapterDescriptor<T> descriptor, EObject target, T adapter)
	{
		super(descriptor.domain, descriptor.info);
		this.target = target;
		this.adapter = adapter;

		loadHandle = createHandle(descriptor.info.loadHandleBuilder);
		disposeHandle = createHandle(descriptor.info.disposeHandleBuilder);
		tickHandle = createHandle(descriptor.info.tickHandleBuilder);
		notifyHandle = createHandle(descriptor.info.notifyHandleBuilder);
	}

	private ExecutionHandle createHandle(ExecutionHandle.Builder<T> builder)
	{
		ExecutionHandle res = null;
		if (builder != null)
		{
			res = builder.build(adapter);
		}

		return res;
	}

	public void load()
	{
		if (loadHandle != null)
		{
			loadHandle.invoke(target);
		}
	}

	public void dispose()
	{
		if (disposeHandle != null)
		{
			disposeHandle.invoke(target);
		}
	}

	public void notifyChanged(Notification notification)
	{
		if (notifyHandle != null)
		{
			notifyHandle.invoke(notification, target);
		}
	}

	@Override
	public void tick(long stepNs)
	{
		tickHandle.invoke(target, stepNs);
	}

	@Override
	public String getName()
	{
		return adapter.getClass().getSimpleName();
	}

	@Override
	public int getPriority()
	{
		return info.getTickPriority();
	}

	@Override
	public int getFrequency()
	{
		return info.getTickFrequency();
	}

}
