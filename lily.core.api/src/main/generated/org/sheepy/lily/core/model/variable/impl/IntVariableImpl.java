package org.sheepy.lily.core.model.variable.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.variable.IntVariable;
import org.sheepy.lily.core.model.variable.VariableModelDefinition;

public final class IntVariableImpl extends FeaturedObject<IntVariable.Features<?>> implements IntVariable {
  private static final int FEATURE_COUNT = 2;
  private final ModelNotifier<IntVariable.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private int value;

  public IntVariableImpl(final String name, final int value) {
    this.name = name;
    this.value = value;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<IntVariable.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public int value() {
    return value;
  }

  @Override
  public void value(final int value) {
    final var oldValue = this.value;
    this.value = value;
    notifier.notifyInt(IntVariable.FeatureIDs.VALUE, false, false, oldValue, value);
  }

  @Override
  public Group<IntVariable> lmGroup() {
    return VariableModelDefinition.Groups.INT_VARIABLE;
  }

  @Override
  protected FeatureSetter<IntVariable> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<IntVariable> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case IntVariable.FeatureIDs.NAME -> 0;
      case IntVariable.FeatureIDs.VALUE -> 1;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<IntVariable> GET_MAP = new FeatureGetter.Builder<IntVariable>(FEATURE_COUNT, IntVariableImpl::featureIndexStatic).add(IntVariable.FeatureIDs.NAME, IntVariable::name).add(IntVariable.FeatureIDs.VALUE, IntVariable::value).build();
    private static final FeatureSetter<IntVariable> SET_MAP = new FeatureSetter.Builder<IntVariable>(FEATURE_COUNT, IntVariableImpl::featureIndexStatic).add(IntVariable.FeatureIDs.VALUE, (object, value) -> ((IntVariableImpl) object).value((int) value)).build();
  }
}
