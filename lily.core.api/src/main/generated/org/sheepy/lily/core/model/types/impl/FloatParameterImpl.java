package org.sheepy.lily.core.model.types.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.types.FloatParameter;
import org.sheepy.lily.core.model.types.TypesModelDefinition;

public final class FloatParameterImpl extends FeaturedObject<FloatParameter.Features<?>> implements FloatParameter {
  private static final int FEATURE_COUNT = 1;
  private final ModelNotifier<FloatParameter.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private float value;

  public FloatParameterImpl() {
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<FloatParameter.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public float value() {
    return value;
  }

  @Override
  public void value(final float value) {
    final var oldValue = this.value;
    this.value = value;
    notifier.notifyFloat(FloatParameter.FeatureIDs.VALUE, false, false, oldValue, value);
  }

  @Override
  public Group<FloatParameter> lmGroup() {
    return TypesModelDefinition.Groups.FLOAT_PARAMETER;
  }

  @Override
  protected FeatureSetter<FloatParameter> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<FloatParameter> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case FloatParameter.FeatureIDs.VALUE -> 0;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  @Override
  public Float getNativeValue() {
    return this.value();
  }

  private static final class Inserters {
    private static final FeatureGetter<FloatParameter> GET_MAP = new FeatureGetter.Builder<FloatParameter>(FEATURE_COUNT, FloatParameterImpl::featureIndexStatic).add(FloatParameter.FeatureIDs.VALUE, FloatParameter::value).build();
    private static final FeatureSetter<FloatParameter> SET_MAP = new FeatureSetter.Builder<FloatParameter>(FEATURE_COUNT, FloatParameterImpl::featureIndexStatic).add(FloatParameter.FeatureIDs.VALUE, (object, value) -> ((FloatParameterImpl) object).value((float) value)).build();
  }
}
