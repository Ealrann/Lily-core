package org.sheepy.lily.core.cadence.tick;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.api.adapter.IAdapterAnnotationHandle;
import org.sheepy.lily.core.api.adapter.ILilyEObject;
import org.sheepy.lily.core.api.cadence.ETickerClock;
import org.sheepy.lily.core.api.util.ExecutionHandle;
import org.sheepy.lily.core.api.util.Operation;

import java.util.function.Consumer;
import java.util.function.LongConsumer;
import java.util.function.ObjLongConsumer;

public class TickHandle implements IAdapterAnnotationHandle
{
	private final ILilyEObject target;
	private final ExecutionHandle handle;
	private final TickConfiguration configuration;
	private final String adapterName;

	public TickHandle(ILilyEObject target, ExecutionHandle handle, TickConfiguration configuration, String adapterName)
	{
		this.target = target;
		this.handle = handle;
		this.configuration = configuration;
		this.adapterName = adapterName;
	}

	public double getFrequency()
	{
		return configuration.tickFrequency;
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
		return configuration.tickPriority;
	}

	public ETickerClock getClock()
	{
		return configuration.clock;
	}
}
