package org.sheepy.lily.core.adapter.load;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.IAdapterAnnotationService;
import org.sheepy.lily.core.api.adapter.ILilyEObject;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.util.ExecutionHandle;

public class AdapterDisposeService implements IAdapterAnnotationService<Dispose, AdapterDisposeHandle>
{
	@Override
	public Class<AdapterDisposeHandle> handleClass()
	{
		return AdapterDisposeHandle.class;
	}

	@Override
	public Class<Dispose> annotationClass()
	{
		return Dispose.class;
	}

	@Override
	public boolean forceLoadIfAnnotated()
	{
		return false;
	}

	@Override
	public AdapterDisposeHandle buildHandle(final ILilyEObject target,
											final IAdapter adapter,
											final Dispose annotation,
											final ExecutionHandle handle)
	{
		return new AdapterDisposeHandle(handle);
	}
}
