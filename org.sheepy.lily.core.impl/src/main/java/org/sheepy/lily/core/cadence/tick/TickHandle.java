package org.sheepy.lily.core.cadence.tick;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.api.cadence.ETickerClock;
import org.sheepy.lily.core.api.cadence.Tick;
import org.sheepy.lily.core.api.extender.IExtenderHandle;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.reflect.ConsumerHandle;

import java.util.function.Consumer;
import java.util.function.LongConsumer;
import java.util.function.ObjLongConsumer;
import java.util.stream.Stream;

public final class TickHandle
{
	private final ILilyEObject target;
	private final ConsumerHandle handle;
	private final TickConfiguration configuration;
	private final String adapterName;

	public TickHandle(ILilyEObject target, ConsumerHandle handle, TickConfiguration configuration, String adapterName)
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
		public final ILilyEObject target;
		private final IExtenderHandle<?> handle;

		public Builder(final ILilyEObject target, final IExtenderHandle<?> handle)
		{
			this.target = target;
			this.handle = handle;
		}

		public Stream<TickHandle> build()
		{
			return handle.annotatedHandles(Tick.class).map(this::buildTickHandles);
		}

		private TickHandle buildTickHandles(final IExtenderHandle.AnnotatedHandle<Tick> annotatedHandle)
		{
			final var config = new TickConfiguration(annotatedHandle.annotation);
			final var adapterName = handle.getExtender().getClass().getSimpleName();
			return new TickHandle(target, (ConsumerHandle) annotatedHandle.executionHandle, config, adapterName);
		}
	}
}
