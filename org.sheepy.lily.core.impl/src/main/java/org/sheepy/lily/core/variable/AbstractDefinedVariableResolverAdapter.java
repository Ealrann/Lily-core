package org.sheepy.lily.core.variable;

import org.eclipse.emf.common.notify.Notification;
import org.sheepy.lily.core.api.adapter.ILilyEObject;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.Load;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.notification.Notifier;
import org.sheepy.lily.core.api.util.FeatureDefinition;
import org.sheepy.lily.core.api.variable.IVariableResolverAdapter;
import org.sheepy.lily.core.model.variable.IVariableResolver;

import java.util.function.Consumer;

@Statefull
public abstract class AbstractDefinedVariableResolverAdapter<T extends IVariableResolver> extends Notifier<IVariableResolverAdapter.Features> implements
																																			  IVariableResolverAdapter<T>
{
	private final Consumer<Notification> adapter = this::fireListeners;
	private ILilyEObject resolvedTarget;
	private int featureID;

	public AbstractDefinedVariableResolverAdapter()
	{
		super(Features.values().length);
	}

	@Load
	private void load()
	{
		resolvedTarget = getResolvedTarget();
		featureID = getFeatureDefinition().feature.getFeatureID();
		resolvedTarget.listen(adapter, featureID);
	}

	@Dispose
	public void unsetTarget()
	{
		resolvedTarget.sulk(adapter, featureID);
	}

	private void fireListeners(Notification notification)
	{
		final Object newValue = notification.getNewValue();
		notify(Features.Value, newValue);
	}

	protected abstract FeatureDefinition getFeatureDefinition();

	protected abstract ILilyEObject getResolvedTarget();
}
