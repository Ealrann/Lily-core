package org.sheepy.lily.core.api.notification.observatory.internal.allocation;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderHandle;

public class AdapterNoParamPOI<T extends IExtender> implements IAdapterPOI<T>
{
	private final Runnable onNewExtender;

	public AdapterNoParamPOI(final Runnable onNewExtender)
	{
		this.onNewExtender = onNewExtender;
	}

	@Override
	public void listen(final IExtenderHandle<T> handle)
	{
		if (handle.isExtenderChangeable())
		{
			handle.listenNoParam(onNewExtender);
		}
	}

	@Override
	public void sulk(final IExtenderHandle<T> handle)
	{
		if (handle.isExtenderChangeable())
		{
			handle.sulkNoParam(onNewExtender);
		}
	}
}
