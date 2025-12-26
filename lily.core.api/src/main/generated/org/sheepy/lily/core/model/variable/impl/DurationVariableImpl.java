package org.sheepy.lily.core.model.variable.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.variable.DurationVariable;
import org.sheepy.lily.core.model.variable.VariableModelDefinition;

public final class DurationVariableImpl extends FeaturedObject<DurationVariable.Features<?>> implements DurationVariable {
  private static final int FEATURE_COUNT = 1;
  private final ModelNotifier<DurationVariable.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;

  public DurationVariableImpl(final String name) {
    this.name = name;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<DurationVariable.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public Group<DurationVariable> lmGroup() {
    return VariableModelDefinition.Groups.DURATION_VARIABLE;
  }

  @Override
  protected FeatureSetter<DurationVariable> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<DurationVariable> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case DurationVariable.FeatureIDs.NAME -> 0;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<DurationVariable> GET_MAP = new FeatureGetter.Builder<DurationVariable>(FEATURE_COUNT, DurationVariableImpl::featureIndexStatic).add(DurationVariable.FeatureIDs.NAME, DurationVariable::name).build();
    private static final FeatureSetter<DurationVariable> SET_MAP = new FeatureSetter.Builder<DurationVariable>(FEATURE_COUNT, DurationVariableImpl::featureIndexStatic).build();
  }
}
