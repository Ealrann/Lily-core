package org.sheepy.lily.core.variable;

import org.eclipse.emf.common.notify.Notification;
import org.sheepy.lily.core.api.adapter.Dispose;
import org.sheepy.lily.core.api.adapter.Load;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.logoce.notification.api.Notifier;
import org.sheepy.lily.core.api.util.FeatureDefinition;
import org.sheepy.lily.core.api.variable.IVariableResolverAdapter;
import org.sheepy.lily.core.model.variable.IVariableResolver;

import java.util.List;
import java.util.function.Consumer;

public abstract class AbstractDefinedVariableResolverAdapter<T extends IVariableResolver> extends Notifier<IVariableResolverAdapter.Features> implements
																																			  IVariableResolverAdapter<T>
{
	private final Consumer<Notification> adapter = this::fireListeners;
	private ILilyEObject resolvedTarget;
	private int featureID;

	public AbstractDefinedVariableResolverAdapter()
	{
		super(List.of(Features.Value));
	}

	@Load
	private void load()
	{
		resolvedTarget = getResolvedTarget();
		final var resolvedEclass = resolvedTarget.eClass();
		featureID = resolvedEclass.getFeatureID(getFeatureDefinition().feature);
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
