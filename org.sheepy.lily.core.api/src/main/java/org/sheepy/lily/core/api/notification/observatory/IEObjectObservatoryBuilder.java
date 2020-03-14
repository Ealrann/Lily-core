package org.sheepy.lily.core.api.notification.observatory;

import org.sheepy.lily.core.api.adapter.ILilyEObject;

import java.util.function.Consumer;

public interface IEObjectObservatoryBuilder<L extends ILilyEObject> extends IStructuralObservatoryBuilder<IEObjectObservatoryBuilder<L>>
{
	IEObjectObservatoryBuilder<L> listenAdd(Consumer<L> onAddedObject);
	IEObjectObservatoryBuilder<L> listenRemove(Consumer<L> onRemovedObject);
}
