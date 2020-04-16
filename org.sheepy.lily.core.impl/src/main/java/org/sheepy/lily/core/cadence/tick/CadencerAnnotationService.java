package org.sheepy.lily.core.cadence.tick;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.IAdapterAnnotationService;
import org.sheepy.lily.core.api.adapter.ILilyEObject;
import org.sheepy.lily.core.api.cadence.Tick;
import org.sheepy.lily.core.api.util.ExecutionHandle;

public final class CadencerAnnotationService implements IAdapterAnnotationService<Tick, TickHandle>
{
	@Override
	public Class<Tick> annotationClass()
	{
		return Tick.class;
	}

	@Override
	public Class<TickHandle> handleClass()
	{
		return TickHandle.class;
	}

	@Override
	public boolean forceLoadIfAnnotated()
	{
		return true;
	}

	@Override
	public TickHandle buildHandle(ILilyEObject target, IAdapter adapter, Tick annotation, ExecutionHandle handle)
	{
		final var configuration = new TickConfiguration(annotation);
		return new TickHandle(target, handle, configuration, adapter.getClass().getSimpleName());
	}
}
