package org.sheepy.lily.core.api.adapter;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClass;
import org.sheepy.lily.core.api.service.IService;

public interface IAdapter extends Adapter, IService
{
	boolean isAdapterForType(Class<? extends IAdapter> type);

	boolean isApplicable(EClass eClass);

	IServiceAdapterFactory getAdapterFactory();

	void setAdapterFactory(IServiceAdapterFactory adapterFactory);

	@Override
	default void notifyChanged(Notification notification)
	{}

	@Override
	default Notifier getTarget()
	{
		throw new AssertionError("No target availlable for singleton Adapter");
	}

	@Override
	default void setTarget(Notifier target)
	{}

	@Override
	@SuppressWarnings("unchecked")
	default boolean isAdapterForType(Object type)
	{
		if (type instanceof Class<?>)
			return isAdapterForType((Class<? extends IAdapter>) type);
		else return false;
	}
}
