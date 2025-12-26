package org.sheepy.lily.core.model.variable.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.variable.FloatVariable;
import org.sheepy.lily.core.model.variable.VariableModelDefinition;

public final class FloatVariableImpl extends FeaturedObject<FloatVariable.Features<?>> implements FloatVariable {
  private static final int FEATURE_COUNT = 2;
  private final ModelNotifier<FloatVariable.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private float value;

  public FloatVariableImpl(final String name, final float value) {
    this.name = name;
    this.value = value;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<FloatVariable.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public float value() {
    return value;
  }

  @Override
  public void value(final float value) {
    final var oldValue = this.value;
    this.value = value;
    notifier.notifyFloat(FloatVariable.FeatureIDs.VALUE, false, false, oldValue, value);
  }

  @Override
  public Group<FloatVariable> lmGroup() {
    return VariableModelDefinition.Groups.FLOAT_VARIABLE;
  }

  @Override
  protected FeatureSetter<FloatVariable> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<FloatVariable> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case FloatVariable.FeatureIDs.NAME -> 0;
      case FloatVariable.FeatureIDs.VALUE -> 1;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<FloatVariable> GET_MAP = new FeatureGetter.Builder<FloatVariable>(FEATURE_COUNT, FloatVariableImpl::featureIndexStatic).add(FloatVariable.FeatureIDs.NAME, FloatVariable::name).add(FloatVariable.FeatureIDs.VALUE, FloatVariable::value).build();
    private static final FeatureSetter<FloatVariable> SET_MAP = new FeatureSetter.Builder<FloatVariable>(FEATURE_COUNT, FloatVariableImpl::featureIndexStatic).add(FloatVariable.FeatureIDs.VALUE, (object, value) -> ((FloatVariableImpl) object).value((float) value)).build();
  }
}
