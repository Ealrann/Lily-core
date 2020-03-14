package org.sheepy.lily.core.api.notification.observatory;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EReference;
import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.ILilyEObject;
import org.sheepy.lily.core.api.adapter.INotifierAdapter;
import org.sheepy.lily.core.api.notification.IFeature;

import java.util.function.Consumer;

public interface IStructuralObservatoryBuilder<C extends IStructuralObservatoryBuilder<C>> extends IObservatory.IBuilder
{
	IEObjectObservatoryBuilder<ILilyEObject> explore(EReference reference);
	<Sub extends ILilyEObject> IEObjectObservatoryBuilder<Sub> explore(EReference reference, Class<Sub> cast);

	<T extends IAdapter> IAdapterObservatoryBuilder<T> adapt(Class<T> classifier);
	<F extends IFeature<?, ?>> INotifierAdapterObservatoryBuilder<F, ? extends INotifierAdapter<F>> adaptNotifier(Class<? extends INotifierAdapter<F>> classifier);

	C listen(Consumer<Notification> listener, int... features);
	C listenNoParam(Runnable listener, int... features);
}
