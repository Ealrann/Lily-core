package org.sheepy.common.api.adapter;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;

/**
 * Allows fast adapter resolution.
 * 
 * @author ealrann
 */
public class AdapterIndexer extends AdapterImpl implements Adapter
{
	private Map<Class<?>, Object> map = new HashMap<>(8);

	@Override
	public void notifyChanged(Notification msg)
	{
		super.notifyChanged(msg);

		if (msg.getEventType() == Notification.REMOVING_ADAPTER)
		{
			Adapter removedAdapter = (Adapter) msg.getOldValue();
			removeAdapter(removedAdapter);
		}
	}

	public void removeAdapter(Adapter adapter)
	{
		while (map.values().remove(adapter))
			;
	}

	@SuppressWarnings("unchecked")
	public <T extends Adapter> T adapt(AdapterFactory adapterFactory, Notifier target,
			Class<T> type)
	{
		T res = (T) map.get(type);

		if (res == null)
		{
			for (Adapter adapter : target.eAdapters())
			{
				if (adapter.isAdapterForType(type))
				{
					res = type.cast(adapter);
					map.put(type, res);
					break;
				}
			}

			if (res == null)
			{
				synchronized (this)
				{
					res = type.cast(map.get(type));
					if (res == null)
					{
						res = type.cast(adapterFactory.adaptNew(target, type));
						map.put(type, res);
					}
				}
			}
		}

		return res;
	}
}
