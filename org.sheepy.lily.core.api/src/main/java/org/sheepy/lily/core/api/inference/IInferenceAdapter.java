package org.sheepy.lily.core.api.inference;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.model.inference.Inferer;
import org.sheepy.lily.core.model.inference.LNotification;
import org.sheepy.lily.core.model.inference.ParameteredNotification;
import org.sheepy.lily.core.model.types.Parameter;

public interface IInferenceAdapter extends IExtender
{
	void postNotification(EObject unit, LNotification notification);

	<T extends Parameter> void postNotification(EObject unit, ParameteredNotification<T> notification, T parameter);

	void addInferer(Inferer inferer);

	void removeInferer(Inferer inferer);

	void addNotificationListener(EClass listenedEclass, IInferenceListener listener);

	void removeNotificationListener(EClass listenedEclass, IInferenceListener listener);

	interface IInferenceListener
	{
		void onNotification(EObject unit, LNotification notification);

		<T extends Parameter> void onNotification(EObject unit, ParameteredNotification<T> notification, T parameter);
	}
}
