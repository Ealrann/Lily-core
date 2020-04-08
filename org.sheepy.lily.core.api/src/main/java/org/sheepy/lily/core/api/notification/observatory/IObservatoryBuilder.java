package org.sheepy.lily.core.api.notification.observatory;

import org.sheepy.lily.core.api.adapter.ILilyEObject;
import org.sheepy.lily.core.api.notification.IFeatures;
import org.sheepy.lily.core.api.notification.INotifier;
import org.sheepy.lily.core.api.notification.observatory.internal.eobject.RootObservatory;

public interface IObservatoryBuilder extends IObservatory.IBuilder, IStructuralObservatoryBuilder<IObservatoryBuilder>
{
	static IObservatoryBuilder newObservatoryBuilder()
	{
		return new RootObservatory.Builder();
	}

	IObservatoryBuilder focus(ILilyEObject focus);
	<Y extends IFeatures<Y>> INotifierObservatoryBuilder<Y> focus(INotifier<Y> notifier);
	boolean isEmpty();
}
