package org.sheepy.lily.core.adapter.load;

import org.sheepy.lily.core.api.adapter.IAdapterAnnotationHandle;
import org.sheepy.lily.core.api.adapter.ILilyEObject;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.core.api.util.ExecutionHandle;

public final class AdapterLoadHandle implements IAdapterAnnotationHandle
{
	private final ExecutionHandle loadHandle;

	public AdapterLoadHandle(final ExecutionHandle loadHandle)
	{
		this.loadHandle = loadHandle;
	}

	public void load(ILilyEObject target)
	{
		loadHandle.invoke(target);
	}
}
