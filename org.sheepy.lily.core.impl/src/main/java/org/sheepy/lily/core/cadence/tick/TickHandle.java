package org.sheepy.lily.core.cadence.tick;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.api.cadence.ETickerClock;
import org.sheepy.lily.core.api.cadence.Tick;
import org.sheepy.lily.core.api.extender.IExtenderDescriptor;
import org.sheepy.lily.core.api.extender.IExtenderHandle;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.reflect.ConsumerHandle;

import java.util.function.Consumer;
import java.util.function.LongConsumer;
import java.util.function.ObjLongConsumer;

public final class TickHandle
{
	public final ILilyEObject target;
	private final IExtenderHandle<?> handle;
	private final TickConfiguration configuration;
	private final String adapterName;

	public TickHandle(ILilyEObject target,
					  IExtenderHandle<?> handle,
					  TickConfiguration configuration,
					  String adapterName)
	{
		this.target = target;
		this.handle = handle;
		this.configuration = configuration;
		this.adapterName = adapterName;
	}

	public double getFrequency()
	{
		return configuration.tickFrequency();
	}

	public void tick(final long stepNs)
	{
		handle.annotatedHandles(Tick.class)
			  .filter(handle -> handle.annotation() == configuration.annotation())
			  .forEach(handle -> tick(stepNs, handle));
	}

	private void tick(final long stepNs, final IExtenderHandle.AnnotatedHandle<Tick> tickAnnotatedHandle)
	{
		final var consumerHandle = (ConsumerHandle) tickAnnotatedHandle.executionHandle();
		final var function = consumerHandle.getLambdaFunction();

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
		else if (function instanceof Runnable)
		{
			((Runnable) function).run();
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

	private static void throwError() throws AssertionError
	{
		throw new AssertionError("Invalid ticker");
	}

	public String getName()
	{
		return adapterName;
	}

	public int getPriority()
	{
		return configuration.tickPriority();
	}

	public ETickerClock getClock()
	{
		return configuration.clock();
	}

	public static final class Builder
	{
		private final IExtenderDescriptor<?> descriptor;
		private final TickConfiguration tickConfiguration;
		private final String adapterName;

		public Builder(final IExtenderDescriptor<?> descriptor, Tick annotation)
		{
			this.descriptor = descriptor;
			tickConfiguration = new TickConfiguration(annotation);
			adapterName = descriptor.extenderClass().getSimpleName();
		}

		public boolean isApplicable(ILilyEObject target)
		{
			return descriptor.isApplicable(target);
		}

		public TickHandle build(ILilyEObject target)
		{
			final var handle = target.adapters().adaptHandleFromDescriptor(descriptor);
			return new TickHandle(target, handle, tickConfiguration, adapterName);
		}
	}
}
