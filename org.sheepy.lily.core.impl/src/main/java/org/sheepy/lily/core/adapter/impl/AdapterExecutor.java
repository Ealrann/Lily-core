package org.sheepy.lily.core.adapter.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.adapter.ITickDescriptor;
import org.sheepy.lily.core.adapter.impl.AdapterInfo.TickConfiguration;
import org.sheepy.lily.core.adapter.impl.ServiceAdapterRegistry.AdapterDescriptor;
import org.sheepy.lily.core.adapter.reflect.ExecutionHandle;
import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.cadence.ETickerClock;

public final class AdapterExecutor<T extends IAdapter>
		extends ServiceAdapterRegistry.AdapterDescriptor<T>
{
	public final T adapter;
	public final List<TickHandle> tickHandles;

	private final EObject target;
	private final ExecutionHandle loadHandle;
	private final ExecutionHandle disposeHandle;
	private final ExecutionHandle notifyHandle;

	AdapterExecutor(AdapterDescriptor<T> descriptor, EObject target, T adapter)
	{
		super(descriptor.domain, descriptor.info);
		this.target = target;
		this.adapter = adapter;

		loadHandle = createHandle(descriptor.info.loadHandleBuilder);
		disposeHandle = createHandle(descriptor.info.disposeHandleBuilder);
		notifyHandle = createHandle(descriptor.info.notifyHandleBuilder);
		tickHandles = List.copyOf(buildTickHandles(descriptor));
	}

	private List<TickHandle> buildTickHandles(AdapterDescriptor<T> descriptor)
	{
		final List<TickHandle> res = new ArrayList<>();

		for (final var tickConfig : descriptor.info.tickConfiguration)
		{
			res.add(new TickHandle(tickConfig));
		}

		return res;
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

	public final class TickHandle implements ITickDescriptor
	{
		private final TickConfiguration<T> configuration;
		private final ExecutionHandle handle;

		public TickHandle(TickConfiguration<T> configuration)
		{
			this.configuration = configuration;
			handle = configuration.tickHandleBuilder.build(adapter);
		}

		@Override
		public double getFrequency()
		{
			return configuration.tickFrequency;
		}

		/**
		 * TODO stepNs is autoboxed here. Finally, the step value can be retrieved in Application,
		 * is that really usefull to share it by argument ?
		 */
		@Override
		public void tick(long stepNs)
		{
			handle.invoke(stepNs, target);
		}

		@Override
		public String getName()
		{
			return adapter.getClass().getSimpleName();
		}

		@Override
		public int getPriority()
		{
			return configuration.tickPriority;
		}

		@Override
		public ETickerClock getClock()
		{
			return configuration.clock;
		}
	}
}
