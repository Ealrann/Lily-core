package org.sheepy.lily.core.api.extender;

import org.sheepy.lily.core.api.model.ILilyEObject;

public interface IExtenderHandleBuilder<E extends IExtender>
{
	IExtenderHandle<E> build(ILilyEObject target);
	Class<? extends IExtenderHandle<E>> getHandleClass();
	boolean isAuto();
}
