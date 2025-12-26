package org.sheepy.lily.core.model.cadence.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.cadence.CadenceModelDefinition;
import org.sheepy.lily.core.model.cadence.HaveTime;

public final class HaveTimeImpl extends FeaturedObject<HaveTime.Features<?>> implements HaveTime {
  private static final int FEATURE_COUNT = 0;
  private final ModelNotifier<HaveTime.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);

  public HaveTimeImpl() {
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<HaveTime.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public Group<HaveTime> lmGroup() {
    return CadenceModelDefinition.Groups.HAVE_TIME;
  }

  @Override
  protected FeatureSetter<HaveTime> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<HaveTime> getterMap() {
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
    private static final FeatureGetter<HaveTime> GET_MAP = new FeatureGetter.Builder<HaveTime>(FEATURE_COUNT, HaveTimeImpl::featureIndexStatic).build();
    private static final FeatureSetter<HaveTime> SET_MAP = new FeatureSetter.Builder<HaveTime>(FEATURE_COUNT, HaveTimeImpl::featureIndexStatic).build();
  }
}
