package org.sheepy.lily.core.model.types.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.types.BooleanParameter;
import org.sheepy.lily.core.model.types.TypesModelDefinition;

public final class BooleanParameterImpl extends FeaturedObject<BooleanParameter.Features<?>> implements BooleanParameter {
  private static final int FEATURE_COUNT = 1;
  private final ModelNotifier<BooleanParameter.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private boolean value;

  public BooleanParameterImpl() {
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<BooleanParameter.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public boolean value() {
    return value;
  }

  @Override
  public void value(final boolean value) {
    final var oldValue = this.value;
    this.value = value;
    notifier.notifyBoolean(BooleanParameter.FeatureIDs.VALUE, false, false, oldValue, value);
  }

  @Override
  public Group<BooleanParameter> lmGroup() {
    return TypesModelDefinition.Groups.BOOLEAN_PARAMETER;
  }

  @Override
  protected FeatureSetter<BooleanParameter> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<BooleanParameter> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case BooleanParameter.FeatureIDs.VALUE -> 0;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  @Override
  public Boolean getNativeValue() {
    return this.value();
  }

  private static final class Inserters {
    private static final FeatureGetter<BooleanParameter> GET_MAP = new FeatureGetter.Builder<BooleanParameter>(FEATURE_COUNT, BooleanParameterImpl::featureIndexStatic).add(BooleanParameter.FeatureIDs.VALUE, BooleanParameter::value).build();
    private static final FeatureSetter<BooleanParameter> SET_MAP = new FeatureSetter.Builder<BooleanParameter>(FEATURE_COUNT, BooleanParameterImpl::featureIndexStatic).add(BooleanParameter.FeatureIDs.VALUE, (object, value) -> ((BooleanParameterImpl) object).value((boolean) value)).build();
  }
}
