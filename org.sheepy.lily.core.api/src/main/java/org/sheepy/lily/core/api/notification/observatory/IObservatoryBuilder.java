package org.sheepy.lily.core.api.notification.observatory;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EReference;
import org.sheepy.lily.core.api.adapter.ILilyEObject;
import org.sheepy.lily.core.api.adapter.INotifierAdapter;
import org.sheepy.lily.core.api.notification.IFeature;
import org.sheepy.lily.core.api.notification.observatory.internal.eobject.StaticObservatory;

import java.util.function.Consumer;

public interface IObservatoryBuilder extends IObservatory.IBuilder
{
	static IObservatoryBuilder newObservatoryBuilder(ILilyEObject root)
	{
		return new StaticObservatory.Builder(root);
	}

	IObservatoryBuilder focus(ILilyEObject object);
	IEObjectObservatoryBuilder<ILilyEObject> focus(EReference reference);
	<T extends ILilyEObject> IEObjectObservatoryBuilder<T> focus(EReference reference, Class<T> cast);
	<T extends IFeature<?, ?>> IAdapterObservatoryBuilder<T> focus(Class<? extends INotifierAdapter<T>> classifier);

	IObservatoryBuilder listen(Consumer<Notification> listener, int... features);
	IObservatoryBuilder listenNoParam(Runnable listener, int... features);
}
