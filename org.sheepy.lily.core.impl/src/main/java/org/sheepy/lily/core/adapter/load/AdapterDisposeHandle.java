package org.sheepy.lily.core.adapter.load;

import org.sheepy.lily.core.api.adapter.IAdapterAnnotationHandle;
import org.sheepy.lily.core.api.adapter.ILilyEObject;
import org.sheepy.lily.core.api.util.ExecutionHandle;

public final class AdapterDisposeHandle implements IAdapterAnnotationHandle
{
	private final ExecutionHandle disposeHandle;

	public AdapterDisposeHandle(final ExecutionHandle disposeHandle)
	{
		this.disposeHandle = disposeHandle;
	}

	public void dispose(ILilyEObject target)
	{
		disposeHandle.invoke(target);
	}
}
