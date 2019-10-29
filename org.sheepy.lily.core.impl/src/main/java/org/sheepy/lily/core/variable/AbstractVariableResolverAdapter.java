package org.sheepy.lily.core.variable;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.sheepy.lily.core.api.adapter.ILilyEObject;
import org.sheepy.lily.core.api.adapter.INotificationListener;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.util.FeatureDefinition;
import org.sheepy.lily.core.api.variable.IVariableResolverAdapter;
import org.sheepy.lily.core.model.variable.IVariableResolver;

@Statefull
public abstract class AbstractVariableResolverAdapter<T extends IVariableResolver>
		implements IVariableResolverAdapter<T>
{
	private INotificationListener adapter = null;
	private List<INotificationListener> listeners;
	private ILilyEObject resolvedTarget;
	private int featureID;

	@Dispose
	public void unsetTarget()
	{
		if (adapter != null)
		{
			resolvedTarget.removeListener(adapter, featureID);
		}
	}

	private void loadAdapter()
	{
		listeners = new ArrayList<>();
		adapter = this::fireListeners;
		resolvedTarget = getResolvedTarget();
		featureID = getFeatureDefinition().feature.getFeatureID();
		resolvedTarget.addListener(adapter, featureID);
	}

	private void fireListeners(Notification notification)
	{
		for (final var listener : listeners)
		{
			listener.notifyChanged(notification);
		}
	}

	@Override
	public void addListener(INotificationListener listener)
	{
		if (adapter == null)
		{
			loadAdapter();
		}
		listeners.add(listener);
	}

	@Override
	public void removeListener(INotificationListener listener)
	{
		if (listeners != null)
		{
			listeners.remove(listener);
		}
	}

	protected abstract FeatureDefinition getFeatureDefinition();

	protected abstract ILilyEObject getResolvedTarget();
}
