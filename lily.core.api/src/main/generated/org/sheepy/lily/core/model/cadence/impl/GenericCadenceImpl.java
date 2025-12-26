package org.sheepy.lily.core.model.cadence.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.cadence.CadenceModelDefinition;
import org.sheepy.lily.core.model.cadence.GenericCadence;

public final class GenericCadenceImpl extends FeaturedObject<GenericCadence.Features<?>> implements GenericCadence {
  private static final int FEATURE_COUNT = 1;
  private final ModelNotifier<GenericCadence.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;

  public GenericCadenceImpl(final String name) {
    this.name = name;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<GenericCadence.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public Group<GenericCadence> lmGroup() {
    return CadenceModelDefinition.Groups.GENERIC_CADENCE;
  }

  @Override
  protected FeatureSetter<GenericCadence> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<GenericCadence> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case GenericCadence.FeatureIDs.NAME -> 0;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<GenericCadence> GET_MAP = new FeatureGetter.Builder<GenericCadence>(FEATURE_COUNT, GenericCadenceImpl::featureIndexStatic).add(GenericCadence.FeatureIDs.NAME, GenericCadence::name).build();
    private static final FeatureSetter<GenericCadence> SET_MAP = new FeatureSetter.Builder<GenericCadence>(FEATURE_COUNT, GenericCadenceImpl::featureIndexStatic).build();
  }
}
