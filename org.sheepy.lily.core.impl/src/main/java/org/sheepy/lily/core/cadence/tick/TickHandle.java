package org.sheepy.lily.core.cadence.tick;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.api.cadence.ETickerClock;
import org.sheepy.lily.core.api.cadence.Tick;
import org.logoce.extender.api.IAdapterDescriptor;
import org.logoce.extender.api.IAdapterHandle;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.logoce.extender.api.reflect.ConsumerHandle;

import java.util.function.Consumer;
import java.util.function.LongConsumer;
import java.util.function.ObjLongConsumer;
import java.util.stream.Stream;

public final class TickHandle
{
	public final ILilyEObject target;
	private final IAdapterHandle<?> handle;
	private final TickConfiguration configuration;
	private final String adapterName;

	public TickHandle(ILilyEObject target,
					  IAdapterHandle<?> handle,
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

	public Stream<LongConsumer> prepareTickOperations()
	{
		return handle.annotatedHandles(Tick.class)
					 .filter(this::match)
					 .map(this::tickOperation);
	}

	private LongConsumer tickOperation(final IAdapterHandle.AnnotatedHandle<Tick> tickAnnotatedHandle)
	{
		final var consumerHandle = (ConsumerHandle) tickAnnotatedHandle.executionHandle();
		final var function = consumerHandle.getLambdaFunction();

		// Let's do our best to avoid autoboxing
		if (function instanceof LongConsumer longConsumer)
		{
			return longConsumer;
		}
		else if (function instanceof Consumer)
		{
			@SuppressWarnings("unchecked") final var oConsumer = (Consumer<EObject>) function;
			return stepNs -> oConsumer.accept(target);
		}
		else if (function instanceof Runnable runnable)
		{
			return stepNs -> runnable.run();
		}
		else if (function instanceof ObjLongConsumer)
		{
			@SuppressWarnings("unchecked") final var oLongConsumer = (ObjLongConsumer<EObject>) function;
			return stepNs -> oLongConsumer.accept(target, stepNs);
		}
		else
		{
			throwError();
			return stepNs -> {};
		}
	}

	private boolean match(final IAdapterHandle.AnnotatedHandle<Tick> handle)
	{
		return handle.annotation() == configuration.annotation();
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
		private final IAdapterDescriptor<?> descriptor;
		private final TickConfiguration tickConfiguration;
		private final String adapterName;

		public Builder(final IAdapterDescriptor<?> descriptor, Tick annotation)
		{
			this.descriptor = descriptor;
			tickConfiguration = new TickConfiguration(annotation);
			adapterName = descriptor.extenderClass()
									.getSimpleName();
		}

		public boolean isApplicable(ILilyEObject target)
		{
			return descriptor.isApplicable(target);
		}

		public TickHandle build(ILilyEObject target)
		{
			final var handle = target.adapterManager()
									 .adaptHandle(descriptor);
			return new TickHandle(target, handle, tickConfiguration, adapterName);
		}
	}
}
