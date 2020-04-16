package org.sheepy.lily.core.adapter.observation;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.IAdapterAnnotationService;
import org.sheepy.lily.core.api.adapter.ILilyEObject;
import org.sheepy.lily.core.api.adapter.annotation.Observe;
import org.sheepy.lily.core.api.util.ExecutionHandle;

public class AdapterObserveService implements IAdapterAnnotationService<Observe, AdapterObserveHandle>
{
	@Override
	public Class<AdapterObserveHandle> handleClass()
	{
		return AdapterObserveHandle.class;
	}

	@Override
	public Class<Observe> annotationClass()
	{
		return Observe.class;
	}

	@Override
	public boolean forceLoadIfAnnotated()
	{
		return false;
	}

	@Override
	public AdapterObserveHandle buildHandle(final ILilyEObject target,
											final IAdapter adapter,
											final Observe annotation,
											final ExecutionHandle handle)
	{
		return new AdapterObserveHandle(handle);
	}
}
