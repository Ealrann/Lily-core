package org.sheepy.lily.core.api.notification.observatory;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EReference;
import org.sheepy.lily.core.api.adapter.ILilyEObject;
import org.sheepy.lily.core.api.adapter.INotifierAdapter;
import org.sheepy.lily.core.api.notification.IFeature;

import java.util.function.Consumer;

public interface IEObjectObservatoryBuilder<T extends ILilyEObject> extends IObservatory.IBuilder
{
	IObservatoryBuilder focus(ILilyEObject object);
	IEObjectObservatoryBuilder<ILilyEObject> focus(EReference reference);
	<Y extends ILilyEObject> IEObjectObservatoryBuilder<Y> focus(EReference reference, Class<Y> cast);
	<Y extends IFeature<?, ?>> IAdapterObservatoryBuilder<Y> focus(Class<? extends INotifierAdapter<Y>> classifier);

	IEObjectObservatoryBuilder<T> listen(Consumer<Notification> listener, int... features);
	IEObjectObservatoryBuilder<T> listenNoParam(Runnable listener, int... features);
	IEObjectObservatoryBuilder<T> listenAdd(Consumer<T> onAddedObject);
	IEObjectObservatoryBuilder<T> listenRemove(Consumer<T> onRemovedObject);
}
