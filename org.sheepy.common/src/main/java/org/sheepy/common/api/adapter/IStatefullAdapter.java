package org.sheepy.common.api.adapter;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

public interface IStatefullAdapter extends IServiceAdapter, Adapter.Internal
{
	@Override
	default void notifyChanged(Notification notification)
	{}

	@Override
	default Notifier getTarget()
	{
		return null;
	}

	@Override
	default void unsetTarget(Notifier oldTarget)
	{}

	@Override
	@SuppressWarnings("unchecked")
	default boolean isAdapterForType(Object type)
	{
		if (type instanceof Class<?>)
			return isAdapterForType((Class<? extends IServiceAdapter>) type);
		else return false;
	}
}
