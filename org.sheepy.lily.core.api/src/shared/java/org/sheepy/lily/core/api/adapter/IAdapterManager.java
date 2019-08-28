package org.sheepy.lily.core.api.adapter;

import org.eclipse.emf.common.notify.Adapter;

public interface IAdapterManager extends Adapter
{
	<T extends IAdapter> T adapt(Class<T> type);
}
