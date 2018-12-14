package org.sheepy.common.api.inference;

import org.eclipse.emf.ecore.EClass;
import org.sheepy.common.api.adapter.IServiceAdapterFactory;
import org.sheepy.common.api.adapter.ISingletonAdapter;
import org.sheepy.common.model.inference.IInferenceObject;
import org.sheepy.common.model.inference.Inferer;
import org.sheepy.common.model.inference.LNotification;
import org.sheepy.common.model.inference.ParameteredNotification;
import org.sheepy.common.model.root.LObject;
import org.sheepy.common.model.types.Parameter;

public interface IInferenceAdapter extends ISingletonAdapter
{
	void postNotification(LObject unit, LNotification notification);

	<T extends Parameter> void postNotification(LObject unit,
												ParameteredNotification<T> notification,
												T parameter);

	void addInferer(Inferer inferer);
	void removeInferer(Inferer inferer);

	/**
	 * @param clazz
	 *            The {@link LNotification} eClass listened
	 * @param listener
	 */
	void addNotificationListener(EClass clazz, INotificationListener listener);

	/**
	 * @param clazz
	 *            The {@link LNotification} eClass listened
	 * @param listener
	 */
	void removeNotificationListener(EClass clazz, INotificationListener listener);

	public interface INotificationListener
	{
		void onNotification(LObject unit, LNotification notification);
		<T extends Parameter> void onNotification(	LObject unit,
													ParameteredNotification<T> notification,
													T parameter);
	}

	static IInferenceAdapter adapt(IInferenceObject part)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(part, IInferenceAdapter.class);
	}
}
