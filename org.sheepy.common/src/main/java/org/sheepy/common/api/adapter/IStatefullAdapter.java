package org.sheepy.common.api.adapter;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

public interface IStatefullAdapter extends ISingletonAdapter, Adapter.Internal
{
	@Override
	default Notifier getTarget()
	{
		return null;
	}

	@Override
	default void unsetTarget(Notifier oldTarget)
	{}
}
