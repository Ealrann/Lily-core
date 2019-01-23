package org.sheepy.lily.core.api.inference;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.api.adapter.IAutoAdapter;
import org.sheepy.lily.core.api.adapter.impl.AbstractStatefullAdapter;
import org.sheepy.lily.core.api.inference.IInferenceAdapter.INotificationListener;
import org.sheepy.lily.core.model.inference.IInferenceObject;
import org.sheepy.lily.core.model.inference.LNotification;
import org.sheepy.lily.core.model.inference.ParameteredNotification;
import org.sheepy.lily.core.model.root.LObject;
import org.sheepy.lily.core.model.types.Parameter;

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
