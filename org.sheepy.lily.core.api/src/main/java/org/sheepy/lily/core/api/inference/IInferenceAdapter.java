package org.sheepy.lily.core.api.inference;

import org.eclipse.emf.ecore.EClass;
import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.core.model.inference.IInferenceObject;
import org.sheepy.lily.core.model.inference.Inferer;
import org.sheepy.lily.core.model.inference.LNotification;
import org.sheepy.lily.core.model.inference.ParameteredNotification;
import org.sheepy.lily.core.model.root.LObject;
import org.sheepy.lily.core.model.types.Parameter;

public interface IInferenceAdapter extends IAdapter
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
		return IAdapterFactoryService.INSTANCE.adapt(part, IInferenceAdapter.class);
	}
}
