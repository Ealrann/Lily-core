package org.sheepy.lily.core.model.variable.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.variable.AbstractDefinedVariableResolver;
import org.sheepy.lily.core.model.variable.IntChangeAction;
import org.sheepy.lily.core.model.variable.VarChangeAction;
import org.sheepy.lily.core.model.variable.VariableModelDefinition;

public final class IntChangeActionImpl extends FeaturedObject<IntChangeAction.Features<?>> implements IntChangeAction {
  private static final int FEATURE_COUNT = 3;
  private final ModelNotifier<IntChangeAction.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private AbstractDefinedVariableResolver variableResolver;
  private int value;

  public IntChangeActionImpl(final String name,
      final AbstractDefinedVariableResolver variableResolver, final int value) {
    this.name = name;
    this.variableResolver = variableResolver;
    this.value = value;
    setContainer(variableResolver, VarChangeAction.FeatureIDs.VARIABLE_RESOLVER);
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<IntChangeAction.Features<?>> notifier() {
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
  public int value() {
    return value;
  }

  @Override
  public void value(final int value) {
    final var oldValue = this.value;
    this.value = value;
    notifier.notifyInt(IntChangeAction.FeatureIDs.VALUE, false, false, oldValue, value);
  }

  @Override
  public Group<IntChangeAction> lmGroup() {
    return VariableModelDefinition.Groups.INT_CHANGE_ACTION;
  }

  @Override
  protected FeatureSetter<IntChangeAction> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<IntChangeAction> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case IntChangeAction.FeatureIDs.NAME -> 0;
      case IntChangeAction.FeatureIDs.VARIABLE_RESOLVER -> 1;
      case IntChangeAction.FeatureIDs.VALUE -> 2;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<IntChangeAction> GET_MAP = new FeatureGetter.Builder<IntChangeAction>(FEATURE_COUNT, IntChangeActionImpl::featureIndexStatic).add(IntChangeAction.FeatureIDs.NAME, IntChangeAction::name).add(IntChangeAction.FeatureIDs.VARIABLE_RESOLVER, IntChangeAction::variableResolver).add(IntChangeAction.FeatureIDs.VALUE, IntChangeAction::value).build();
    private static final FeatureSetter<IntChangeAction> SET_MAP = new FeatureSetter.Builder<IntChangeAction>(FEATURE_COUNT, IntChangeActionImpl::featureIndexStatic).add(IntChangeAction.FeatureIDs.VARIABLE_RESOLVER, (object, value) -> ((IntChangeActionImpl) object).variableResolver((AbstractDefinedVariableResolver) value)).add(IntChangeAction.FeatureIDs.VALUE, (object, value) -> ((IntChangeActionImpl) object).value((int) value)).build();
  }
}
