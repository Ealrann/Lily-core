package org.sheepy.lily.core.model.cadence.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.cadence.CadenceModelDefinition;
import org.sheepy.lily.core.model.cadence.CloseApplication;

public final class CloseApplicationImpl extends FeaturedObject<CloseApplication.Features<?>> implements CloseApplication {
  private static final int FEATURE_COUNT = 0;
  private final ModelNotifier<CloseApplication.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);

  public CloseApplicationImpl() {
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<CloseApplication.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public Group<CloseApplication> lmGroup() {
    return CadenceModelDefinition.Groups.CLOSE_APPLICATION;
  }

  @Override
  protected FeatureSetter<CloseApplication> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<CloseApplication> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    throw new IllegalArgumentException("Unknown featureId: " + featureId);
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<CloseApplication> GET_MAP = new FeatureGetter.Builder<CloseApplication>(FEATURE_COUNT, CloseApplicationImpl::featureIndexStatic).build();
    private static final FeatureSetter<CloseApplication> SET_MAP = new FeatureSetter.Builder<CloseApplication>(FEATURE_COUNT, CloseApplicationImpl::featureIndexStatic).build();
  }
}
