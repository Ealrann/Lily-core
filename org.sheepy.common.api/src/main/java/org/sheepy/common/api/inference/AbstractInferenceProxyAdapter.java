package org.sheepy.common.api.inference;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sheepy.common.api.adapter.IAutoAdapter;
import org.sheepy.common.api.adapter.impl.AbstractStatefullAdapter;
import org.sheepy.common.api.inference.IInferenceAdapter.INotificationListener;
import org.sheepy.common.model.inference.IInferenceObject;
import org.sheepy.common.model.inference.LNotification;
import org.sheepy.common.model.inference.ParameteredNotification;
import org.sheepy.common.model.root.LObject;
import org.sheepy.common.model.types.Parameter;

/**
 * Will redirect Notifications from a source to the target inferenceObject
 * 
 * @author ealrann
 *
 */
public abstract class AbstractInferenceProxyAdapter extends AbstractStatefullAdapter
		implements IAutoAdapter, INotificationListener
{
	private IInferenceObject initialInferenceObject = null;

	@Override
	public void load(EObject unit)
	{
		initialInferenceObject = (IInferenceObject) unit;

		LObject sourceNotificationObject = getNotificationSourceObject(initialInferenceObject);

		IInferenceAdapter adapter = adapterFactory.adapt(sourceNotificationObject,
				IInferenceAdapter.class);
		adapter.addNotificationListener(getNotificationEClassToRedirect(), this);
	}

	@Override
	public void dispose(EObject unit)
	{
		LObject sourceNotificationObject = getNotificationSourceObject(initialInferenceObject);

		IInferenceAdapter adapter = IInferenceAdapter.adapt(sourceNotificationObject);
		adapter.removeNotificationListener(getNotificationEClassToRedirect(), this);

		initialInferenceObject = null;
	}

	@Override
	public void onNotification(LObject sourceNotified, LNotification notification)
	{
		IInferenceAdapter adapter = IInferenceAdapter
				.adapt(initialInferenceObject.lInferenceObject());

		adapter.postNotification(sourceNotified, notification);
	}

	@Override
	public <T extends Parameter> void onNotification(	LObject sourceNotified,
														ParameteredNotification<T> notification,
														T parameter)
	{
		IInferenceAdapter adapter = adapterFactory.adapt(initialInferenceObject.lInferenceObject(),
				IInferenceAdapter.class);

		adapter.postNotification(sourceNotified, notification, parameter);
	}

	protected abstract LObject getNotificationSourceObject(IInferenceObject unit);

	protected abstract EClass getNotificationEClassToRedirect();
}
