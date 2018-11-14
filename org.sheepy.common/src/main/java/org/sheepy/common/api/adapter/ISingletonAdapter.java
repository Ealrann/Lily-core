package org.sheepy.common.api.adapter;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClass;
import org.sheepy.common.api.service.IStandaloneService;

public interface ISingletonAdapter extends Adapter, IStandaloneService, Cloneable
{
	boolean isAdapterForType(Class<? extends ISingletonAdapter> type);

	boolean isApplicable(EClass eClass);

	IServiceAdapterFactory getAdapterFactory();

	void setAdapterFactory(IServiceAdapterFactory adapterFactory);

	ISingletonAdapter clone();

	@Override
	default void notifyChanged(Notification notification)
	{}

	@Override
	default Notifier getTarget()
	{
		throw new AssertionError("No target availlable for singleton Adapter");
	}

	@Override
	default void setTarget(Notifier newTarget)
	{}

	@Override
	@SuppressWarnings("unchecked")
	default boolean isAdapterForType(Object type)
	{
		if (type instanceof Class<?>)
			return isAdapterForType((Class<? extends ISingletonAdapter>) type);
		else return false;
	}
}
