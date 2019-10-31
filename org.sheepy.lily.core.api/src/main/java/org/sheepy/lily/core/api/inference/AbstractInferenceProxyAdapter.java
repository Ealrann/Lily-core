//package org.sheepy.lily.core.api.inference;
//
//import org.eclipse.emf.ecore.EClass;
//import org.eclipse.emf.ecore.EObject;
//import org.sheepy.lily.core.api.adapter.IAdapter;
//import org.sheepy.lily.core.api.adapter.annotation.Dispose;
//import org.sheepy.lily.core.api.adapter.annotation.Load;
//import org.sheepy.lily.core.api.adapter.annotation.Statefull;
//import org.sheepy.lily.core.api.inference.IInferenceAdapter.INotificationListener;
//import org.sheepy.lily.core.model.inference.IInferenceObject;
//import org.sheepy.lily.core.model.inference.LNotification;
//import org.sheepy.lily.core.model.inference.ParameteredNotification;
//import org.sheepy.lily.core.model.root.LObject;
//import org.sheepy.lily.core.model.types.Parameter;
//
///**
// * Will redirect Notifications from a source to the target inferenceObject
// */
//@Statefull
//public abstract class AbstractInferenceProxyAdapter implements IAdapter, INotificationListener
//{
//	private IInferenceObject initialInferenceObject = null;
//
//	@Load
//	public void load(EObject unit)
//	{
//		initialInferenceObject = (IInferenceObject) unit;
//
//		final LObject sourceNotificationObject = getNotificationSourceObject(initialInferenceObject);
//
//		final var adapter = sourceNotificationObject.adaptNotNull(IInferenceAdapter.class);
//		adapter.addNotificationListener(getNotificationEClassToRedirect(), this);
//	}
//
//	@Dispose
//	public void dispose()
//	{
//		final LObject sourceNotificationObject = getNotificationSourceObject(initialInferenceObject);
//
//		final var adapter = sourceNotificationObject.adaptNotNull(IInferenceAdapter.class);
//		adapter.removeNotificationListener(getNotificationEClassToRedirect(), this);
//
//		initialInferenceObject = null;
//	}
//
//	@Override
//	public void onNotification(LObject sourceNotified, LNotification notification)
//	{
//		final var lInferenceObject = initialInferenceObject.lInferenceObject();
//		final var adapter = lInferenceObject.adaptNotNull(IInferenceAdapter.class);
//
//		adapter.postNotification(sourceNotified, notification);
//	}
//
//	@Override
//	public <T extends Parameter> void onNotification(	LObject sourceNotified,
//														ParameteredNotification<T> notification,
//														T parameter)
//	{
//		final var lInferenceObject = initialInferenceObject.lInferenceObject();
//		final var adapter = lInferenceObject.adaptNotNull(IInferenceAdapter.class);
//
//		adapter.postNotification(sourceNotified, notification, parameter);
//	}
//
//	protected abstract LObject getNotificationSourceObject(IInferenceObject unit);
//
//	protected abstract EClass getNotificationEClassToRedirect();
//}
