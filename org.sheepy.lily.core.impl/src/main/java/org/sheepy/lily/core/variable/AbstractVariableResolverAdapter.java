package org.sheepy.lily.core.variable;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.api.adapter.impl.AbstractStatefullAdapter;
import org.sheepy.lily.core.api.util.FeatureDefinition;
import org.sheepy.lily.core.api.variable.IVariableResolverAdapter;
import org.sheepy.lily.core.model.variable.IVariableResolver;

public abstract class AbstractVariableResolverAdapter<T extends IVariableResolver>
		extends AbstractStatefullAdapter implements IVariableResolverAdapter<T>
{
	private Adapter adapter = null;
	private List<IVariableListener> listeners;
	private EObject resolvedTarget;

	@Override
	public void unsetTarget(Notifier oldTarget)
	{
		if (adapter != null)
		{
			resolvedTarget.eAdapters().remove(adapter);
		}
	}

	@Override
	public void addListener(IVariableListener listener)
	{
		if (adapter == null)
		{
			loadAdapter();
		}
		listeners.add(listener);
	}

	private void loadAdapter()
	{
		listeners = new ArrayList<>();
		adapter = new AdapterImpl()
		{
			@Override
			public void notifyChanged(Notification notification)
			{
				if (getFeatureDefinition().match(notification))
				{
					fireListeners(notification);
				}
			}
		};

		resolvedTarget = getResolvedTarget();
		resolvedTarget.eAdapters().add(adapter);
	}

	private void fireListeners(Notification notification)
	{
		for (IVariableListener listener : listeners)
		{
			listener.onVariableChange(notification.getOldValue(), notification.getNewValue());
		}
	}

	@Override
	public void removeListener(IVariableListener listener)
	{
		if (listeners != null)
		{
			listeners.remove(listener);
		}
	}

	protected abstract FeatureDefinition getFeatureDefinition();
	protected abstract EObject getResolvedTarget();
}
