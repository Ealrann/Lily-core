package org.sheepy.lily.core.api.notification.observatory.internal.allocation;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderHandle;

public interface IAdapterPOI<T extends IExtender>
{
	void listen(IExtenderHandle<T> handle);
	void sulk(IExtenderHandle<T> handle);
}
