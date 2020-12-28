package org.sheepy.lily.core.api.extender;

public interface IExtenderHandleBuilder<E extends IExtender>
{
	IExtenderHandle<E> build(IAdaptable target);
	Class<? extends IExtenderHandle<E>> getHandleClass();
}
