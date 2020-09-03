package org.sheepy.lily.core.api.notification.observatory.internal.allocation;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderHandle;

public final class AdapterPOI<T extends IExtender> implements IAdapterPOI<T>
{
	private final IExtenderHandle.ExtenderListener<T> onNewExtender;

	public AdapterPOI(final IExtenderHandle.ExtenderListener<T> onNewExtender)
	{
		this.onNewExtender = onNewExtender;
	}

	@Override
	public void listen(final IExtenderHandle<T> handle)
	{
		handle.listen(onNewExtender);
	}

	@Override
	public void sulk(final IExtenderHandle<T> handle)
	{
		handle.sulk(onNewExtender);
	}
}
