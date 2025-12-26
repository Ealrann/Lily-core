package org.sheepy.lily.core.model.variable.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.variable.AbstractDefinedVariableResolver;
import org.sheepy.lily.core.model.variable.BooleanChangeAction;
import org.sheepy.lily.core.model.variable.VarChangeAction;
import org.sheepy.lily.core.model.variable.VariableModelDefinition;

public final class BooleanChangeActionImpl extends FeaturedObject<BooleanChangeAction.Features<?>> implements BooleanChangeAction {
  private static final int FEATURE_COUNT = 2;
  private final ModelNotifier<BooleanChangeAction.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private AbstractDefinedVariableResolver variableResolver;

  public BooleanChangeActionImpl(final String name,
      final AbstractDefinedVariableResolver variableResolver) {
    this.name = name;
    this.variableResolver = variableResolver;
    setContainer(variableResolver, VarChangeAction.FeatureIDs.VARIABLE_RESOLVER);
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<BooleanChangeAction.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public AbstractDefinedVariableResolver variableResolver() {
    return variableResolver;
  }

  @Override
  public void variableResolver(final AbstractDefinedVariableResolver variableResolver) {
    final var oldValue = this.variableResolver;
    final var eventType = variableResolver == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.variableResolver = variableResolver;
    setContainer(variableResolver, VarChangeAction.FeatureIDs.VARIABLE_RESOLVER);
    beforeContainmentNotify(eventType, oldValue, variableResolver);
    notifier.notify(VarChangeAction.FeatureIDs.VARIABLE_RESOLVER, true, false, eventType, oldValue, variableResolver);
    afterContainmentNotify(eventType, oldValue, variableResolver);
  }

  @Override
  public Group<BooleanChangeAction> lmGroup() {
    return VariableModelDefinition.Groups.BOOLEAN_CHANGE_ACTION;
  }

  @Override
  protected FeatureSetter<BooleanChangeAction> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<BooleanChangeAction> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case BooleanChangeAction.FeatureIDs.NAME -> 0;
      case BooleanChangeAction.FeatureIDs.VARIABLE_RESOLVER -> 1;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<BooleanChangeAction> GET_MAP = new FeatureGetter.Builder<BooleanChangeAction>(FEATURE_COUNT, BooleanChangeActionImpl::featureIndexStatic).add(BooleanChangeAction.FeatureIDs.NAME, BooleanChangeAction::name).add(BooleanChangeAction.FeatureIDs.VARIABLE_RESOLVER, BooleanChangeAction::variableResolver).build();
    private static final FeatureSetter<BooleanChangeAction> SET_MAP = new FeatureSetter.Builder<BooleanChangeAction>(FEATURE_COUNT, BooleanChangeActionImpl::featureIndexStatic).add(BooleanChangeAction.FeatureIDs.VARIABLE_RESOLVER, (object, value) -> ((BooleanChangeActionImpl) object).variableResolver((AbstractDefinedVariableResolver) value)).build();
  }
}
