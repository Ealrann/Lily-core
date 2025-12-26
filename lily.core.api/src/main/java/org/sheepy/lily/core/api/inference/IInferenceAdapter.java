package org.sheepy.lily.core.api.inference;

import org.logoce.lmf.core.api.extender.IAdapter;
import org.logoce.lmf.core.lang.Group;
import org.logoce.lmf.core.lang.LMObject;
import org.sheepy.lily.core.model.inference.Inferer;
import org.sheepy.lily.core.model.inference.LNotification;
import org.sheepy.lily.core.model.inference.ParameteredNotification;
import org.sheepy.lily.core.model.types.Parameter;

public interface IInferenceAdapter extends IAdapter
{
	void postNotification(LMObject unit, LNotification notification);

	<T extends Parameter> void postNotification(LMObject unit, ParameteredNotification<T> notification, T parameter);

	void addInferer(Inferer inferer);

	void removeInferer(Inferer inferer);

	void addNotificationListener(Group<?> listenedGroup, IInferenceListener listener);

	void removeNotificationListener(Group<?> listenedGroup, IInferenceListener listener);

	interface IInferenceListener
	{
		void onNotification(LMObject unit, LNotification notification);

		<T extends Parameter> void onNotification(LMObject unit, ParameteredNotification<T> notification, T parameter);
	}
}

