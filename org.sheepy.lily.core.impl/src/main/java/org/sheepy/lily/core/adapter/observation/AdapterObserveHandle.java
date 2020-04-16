package org.sheepy.lily.core.adapter.observation;

import org.sheepy.lily.core.api.adapter.IAdapterAnnotationHandle;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.core.api.util.ExecutionHandle;

public final class AdapterObserveHandle implements IAdapterAnnotationHandle
{
	private final ExecutionHandle observeHandle;

	public AdapterObserveHandle(final ExecutionHandle observeHandle)
	{
		this.observeHandle = observeHandle;
	}

	public void buildObservatory(IObservatoryBuilder builder)
	{
		observeHandle.invoke(builder);
	}
}
