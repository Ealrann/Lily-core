package org.sheepy.lily.core.adapter.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.adapter.ITickDescriptor;
import org.sheepy.lily.core.adapter.impl.AdapterInfo.NotifyConfiguration;
import org.sheepy.lily.core.adapter.impl.AdapterInfo.TickConfiguration;
import org.sheepy.lily.core.adapter.impl.AdapterRegistry.AdapterDescriptor;
import org.sheepy.lily.core.adapter.reflect.ExecutionHandle;
import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.ILilyEObject;
import org.sheepy.lily.core.api.cadence.ETickerClock;
import org.sheepy.lily.core.api.notification.observatory.IObservatory;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.core.api.util.Operation;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.LongConsumer;
import java.util.function.ObjLongConsumer;

public final class AdapterHandle<T extends IAdapter> extends AdapterRegistry.AdapterDescriptor<T>
{
	public final T adapter;
	public final List<TickHandle> tickHandles;
	public final List<ExecutionHandle> observeHandles;
	public final List<NotifyHandle> notifyHandles;
	private final List<ExecutionHandle> loadHandles;
	private final List<ExecutionHandle> disposeHandles;
	private final ILilyEObject target;

	private IObservatory observatory = null;

	AdapterHandle(AdapterDescriptor<T> descriptor, ILilyEObject target)
	{
		super(descriptor.domain, descriptor.info);
		this.target = target;
		this.adapter = descriptor.info.create(target);

		loadHandles = List.copyOf(createHandles(descriptor.info.loadHandleBuilders));
		disposeHandles = List.copyOf(createHandles(descriptor.info.disposeHandleBuilders));
		observeHandles = List.copyOf(createHandles(descriptor.info.observeHandleBuilders));

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

	private List<ExecutionHandle> createHandles(List<ExecutionHandle.Builder> builders)
	{
		final List<ExecutionHandle> res = new ArrayList<>();
		for (final var builder : builders)
		{
			res.add(builder.build(adapter));
		}

		return res;
	}

	public void load()
	{
		final var observatoryBuilder = buildObservatory();

		for (final var loadHandle : loadHandles)
		{
			loadHandle.invoke(target);
		}

		if (!observatoryBuilder.isEmpty())
		{
			observatory = observatoryBuilder.build();
			observatory.observe(null);
		}
	}

	public void dispose()
	{
		if (observatory != null)
		{
			observatory.shut(null);
			observatory = null;
		}

		for (final var disposeHandle : disposeHandles)
		{
			disposeHandle.invoke(target);
		}
	}

	private IObservatoryBuilder buildObservatory()
	{
		final var observatoryBuilder = IObservatoryBuilder.newObservatoryBuilder(target);
		for (final var observeHandle : observeHandles)
		{
			observeHandle.invoke(observatoryBuilder);
		}
		return observatoryBuilder;
	}

	public static final class NotifyHandle implements Consumer<Notification>
	{
		public final ExecutionHandle handle;
		public final int[] featureIds;

		public <T extends IAdapter> NotifyHandle(NotifyConfiguration notifyConfig, T adapter)
		{
			featureIds = notifyConfig.featureIds;
			handle = notifyConfig.notifyHandleBuilder.build(adapter);
		}

		@Override
		public void accept(Notification notification)
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
				@SuppressWarnings("unchecked") final var oConsumer = (Consumer<EObject>) function;
				oConsumer.accept(target);
			}
			else if (function instanceof Operation)
			{
				((Operation) function).execute();
			}
			else if (function instanceof ObjLongConsumer)
			{
				@SuppressWarnings("unchecked") final var oLongConsumer = (ObjLongConsumer<EObject>) function;
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
