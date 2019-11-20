package org.sheepy.lily.core.adapter.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.LongConsumer;
import java.util.function.ObjLongConsumer;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.adapter.ITickDescriptor;
import org.sheepy.lily.core.adapter.impl.AdapterInfo.NotifyConfiguration;
import org.sheepy.lily.core.adapter.impl.AdapterInfo.TickConfiguration;
import org.sheepy.lily.core.adapter.impl.AdapterRegistry.AdapterDescriptor;
import org.sheepy.lily.core.adapter.reflect.ExecutionHandle;
import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.INotificationListener;
import org.sheepy.lily.core.api.cadence.ETickerClock;
import org.sheepy.lily.core.api.util.Operation;

public final class AdapterHandle<T extends IAdapter> extends AdapterRegistry.AdapterDescriptor<T>
{
	public final T adapter;
	public final List<TickHandle> tickHandles;
	public final List<NotifyHandle> notifyHandles;

	private final EObject target;
	private final ExecutionHandle loadHandle;
	private final ExecutionHandle disposeHandle;

	AdapterHandle(AdapterDescriptor<T> descriptor, EObject target)
	{
		super(descriptor.domain, descriptor.info);
		this.target = target;
		this.adapter = descriptor.info.create(target);

		loadHandle = createHandle(descriptor.info.loadHandleBuilder);
		disposeHandle = createHandle(descriptor.info.disposeHandleBuilder);

		tickHandles = List.copyOf(buildTickHandles(descriptor));
		notifyHandles = List.copyOf(buildNotifyHandles(descriptor));
	}

	private List<TickHandle> buildTickHandles(AdapterDescriptor<T> descriptor)
	{
		final List<TickHandle> res = new ArrayList<>();

		for (final var tickConfig : descriptor.info.tickConfigurations)
		{
			res.add(new TickHandle(tickConfig));
		}

		return res;
	}

	private List<NotifyHandle> buildNotifyHandles(AdapterDescriptor<T> descriptor)
	{
		final List<NotifyHandle> res = new ArrayList<>();

		for (final var tickConfig : descriptor.info.notifyConfigurations)
		{
			res.add(new NotifyHandle(tickConfig, adapter));
		}

		return res;
	}

	private ExecutionHandle createHandle(ExecutionHandle.Builder builder)
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

	public static final class NotifyHandle implements INotificationListener
	{
		public final ExecutionHandle handle;
		public final int[] featureIds;

		public <T extends IAdapter> NotifyHandle(NotifyConfiguration notifyConfig, T adapter)
		{
			featureIds = notifyConfig.featureIds;
			handle = notifyConfig.notifyHandleBuilder.build(adapter);
		}

		@Override
		public void notifyChanged(Notification notification)
		{
			handle.invoke(notification, notification.getNotifier());
		}
	}

	public final class TickHandle implements ITickDescriptor
	{
		private final TickConfiguration configuration;
		private final ExecutionHandle handle;

		public TickHandle(TickConfiguration configuration)
		{
			this.configuration = configuration;
			handle = configuration.tickHandleBuilder.build(adapter);
		}

		@Override
		public double getFrequency()
		{
			return configuration.tickFrequency;
		}

		@Override
		public void tick(long stepNs)
		{
			final var function = handle.getLambdaFunction();

			// Let's do our best to avoid autoboxing
			if (function instanceof LongConsumer)
			{
				((LongConsumer) function).accept(stepNs);
			}
			else if (function instanceof Consumer)
			{
				@SuppressWarnings("unchecked")
				final var oConsumer = (Consumer<EObject>) function;
				oConsumer.accept(target);
			}
			else if (function instanceof Operation)
			{
				((Operation) function).execute();
			}
			else if (function instanceof ObjLongConsumer)
			{
				@SuppressWarnings("unchecked")
				final var oLongConsumer = (ObjLongConsumer<EObject>) function;
				oLongConsumer.accept(target, stepNs);
			}
			else
			{
				throwError();
			}
		}

		private void throwError() throws AssertionError
		{
			throw new AssertionError("Invalid ticker");
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
