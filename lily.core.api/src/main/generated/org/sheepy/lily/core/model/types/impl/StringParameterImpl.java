package org.sheepy.lily.core.model.types.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.types.StringParameter;
import org.sheepy.lily.core.model.types.TypesModelDefinition;

public final class StringParameterImpl extends FeaturedObject<StringParameter.Features<?>> implements StringParameter {
  private static final int FEATURE_COUNT = 1;
  private final ModelNotifier<StringParameter.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private String value;

  public StringParameterImpl() {
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<StringParameter.Features<?>> notifier() {
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
    notifier.notify(StringParameter.FeatureIDs.VALUE, false, false, oldValue, value);
  }

  @Override
  public Group<StringParameter> lmGroup() {
    return TypesModelDefinition.Groups.STRING_PARAMETER;
  }

  @Override
  protected FeatureSetter<StringParameter> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<StringParameter> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case StringParameter.FeatureIDs.VALUE -> 0;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  @Override
  public String getNativeValue() {
    return this.value();
  }

  private static final class Inserters {
    private static final FeatureGetter<StringParameter> GET_MAP = new FeatureGetter.Builder<StringParameter>(FEATURE_COUNT, StringParameterImpl::featureIndexStatic).add(StringParameter.FeatureIDs.VALUE, StringParameter::value).build();
    private static final FeatureSetter<StringParameter> SET_MAP = new FeatureSetter.Builder<StringParameter>(FEATURE_COUNT, StringParameterImpl::featureIndexStatic).add(StringParameter.FeatureIDs.VALUE, (object, value) -> ((StringParameterImpl) object).value((String) value)).build();
  }
}
