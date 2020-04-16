package org.sheepy.lily.core.adapter.description;

import org.sheepy.lily.core.adapter.reflect.ExecutionHandleBuilder;

public final class NotifyConfiguration
{
	public final ExecutionHandleBuilder notifyHandleBuilder;
	public final int[] featureIds;

	public NotifyConfiguration(ExecutionHandleBuilder notifyHandleBuilder, int[] featureIds)
	{
		this.notifyHandleBuilder = notifyHandleBuilder;
		this.featureIds = featureIds;
	}
}
