package org.sheepy.lily.core.api.notification.observatory;

import org.eclipse.emf.common.notify.Notification;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.notification.IFeatures;
import org.sheepy.lily.core.api.notification.INotifier;

import java.util.function.Consumer;

public interface IStructuralObservatoryBuilder<C extends IStructuralObservatoryBuilder<C>>
{
	IEObjectObservatoryBuilder<ILilyEObject> explore(int referenceId);
	<Target extends ILilyEObject> IEObjectObservatoryBuilder<Target> explore(int referenceId, Class<Target> cast);
	IEObjectObservatoryBuilder<ILilyEObject> exploreParent();
	<Target extends ILilyEObject> IEObjectObservatoryBuilder<Target> exploreParent(Class<Target> cast);

	<T extends IExtender> IAdapterObservatoryBuilder<T> adapt(Class<T> classifier);
	<F extends IFeatures<F>, T extends IExtender & INotifier<F>> INotifierAdapterObservatoryBuilder<F, T> adaptNotifier(
			Class<T> classifier);

	C listen(Consumer<Notification> listener, int... features);
	C listenNoParam(Runnable listener, int... features);
}
