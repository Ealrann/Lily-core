package org.sheepy.lily.core.model.variable.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.variable.IModelVariable;
import org.sheepy.lily.core.model.variable.SetVariableAction;
import org.sheepy.lily.core.model.variable.VariableModelDefinition;

public final class SetVariableActionImpl extends FeaturedObject<SetVariableAction.Features<?>> implements SetVariableAction {
  private static final int FEATURE_COUNT = 2;
  private final ModelNotifier<SetVariableAction.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private String value;
  private IModelVariable variable;

  public SetVariableActionImpl(final String value, final IModelVariable variable) {
    this.value = value;
    this.variable = variable;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<SetVariableAction.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public String value() {
    return value;
  }

  @Override
  public void value(final String value) {
    final var oldValue = this.value;
    this.value = value;
    notifier.notify(SetVariableAction.FeatureIDs.VALUE, false, false, oldValue, value);
  }

  @Override
  public IModelVariable variable() {
    return variable;
  }

  @Override
  public void variable(final IModelVariable variable) {
    final var oldValue = this.variable;
    final var eventType = variable == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.variable = variable;
    notifier.notify(SetVariableAction.FeatureIDs.VARIABLE, false, false, eventType, oldValue, variable);
  }

  @Override
  public Group<SetVariableAction> lmGroup() {
    return VariableModelDefinition.Groups.SET_VARIABLE_ACTION;
  }

  @Override
  protected FeatureSetter<SetVariableAction> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<SetVariableAction> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case SetVariableAction.FeatureIDs.VALUE -> 0;
      case SetVariableAction.FeatureIDs.VARIABLE -> 1;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<SetVariableAction> GET_MAP = new FeatureGetter.Builder<SetVariableAction>(FEATURE_COUNT, SetVariableActionImpl::featureIndexStatic).add(SetVariableAction.FeatureIDs.VALUE, SetVariableAction::value).add(SetVariableAction.FeatureIDs.VARIABLE, SetVariableAction::variable).build();
    private static final FeatureSetter<SetVariableAction> SET_MAP = new FeatureSetter.Builder<SetVariableAction>(FEATURE_COUNT, SetVariableActionImpl::featureIndexStatic).add(SetVariableAction.FeatureIDs.VALUE, (object, value) -> ((SetVariableActionImpl) object).value((String) value)).add(SetVariableAction.FeatureIDs.VARIABLE, (object, value) -> ((SetVariableActionImpl) object).variable((IModelVariable) value)).build();
  }
}
