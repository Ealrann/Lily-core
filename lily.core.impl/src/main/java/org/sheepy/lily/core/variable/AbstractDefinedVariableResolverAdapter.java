package org.sheepy.lily.core.variable;

import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.notification.Notification;
import org.sheepy.lily.core.api.adapter.Dispose;
import org.sheepy.lily.core.api.adapter.Load;
import org.sheepy.lily.core.api.adapter.NotifierAdapter;
import org.sheepy.lily.core.api.util.FeatureDefinition;
import org.sheepy.lily.core.api.variable.IVariableResolverAdapter;
import org.sheepy.lily.core.model.variable.IVariableResolver;

import java.util.List;
import java.util.function.Consumer;

public abstract class AbstractDefinedVariableResolverAdapter<T extends IVariableResolver> extends NotifierAdapter<IVariableResolverAdapter.Features>
	implements IVariableResolverAdapter<T>
{
	private final Consumer<Notification> adapter = this::fireListeners;

	private IFeaturedObject resolvedTarget;
	private int featureId;

	protected AbstractDefinedVariableResolverAdapter()
	{
		super(List.of(Features.Value));
	}

	@Load
	private void load()
	{
		resolvedTarget = getResolvedTarget();
		featureId = getFeatureDefinition().feature.id();
		resolvedTarget.notifier().listen(adapter, featureId);
	}

	@Dispose
	public void unsetTarget()
	{
		resolvedTarget.notifier().sulk(adapter, featureId);
	}

	private void fireListeners(final Notification notification)
	{
		notify(Features.Value, notification.newValue());
	}

	protected abstract FeatureDefinition getFeatureDefinition();

	protected abstract IFeaturedObject getResolvedTarget();
}
