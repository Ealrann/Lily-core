package org.sheepy.lily.core.adapter.load;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.IAdapterAnnotationService;
import org.sheepy.lily.core.api.adapter.ILilyEObject;
import org.sheepy.lily.core.api.adapter.annotation.Load;
import org.sheepy.lily.core.api.util.ExecutionHandle;

public class AdapterLoadService implements IAdapterAnnotationService<Load, AdapterLoadHandle>
{
	@Override
	public Class<AdapterLoadHandle> handleClass()
	{
		return AdapterLoadHandle.class;
	}

	@Override
	public Class<Load> annotationClass()
	{
		return Load.class;
	}

	@Override
	public boolean forceLoadIfAnnotated()
	{
		return false;
	}

	@Override
	public AdapterLoadHandle buildHandle(final ILilyEObject target,
										 final IAdapter adapter,
										 final Load annotation,
										 final ExecutionHandle handle)
	{
		return new AdapterLoadHandle(handle);
	}
}
