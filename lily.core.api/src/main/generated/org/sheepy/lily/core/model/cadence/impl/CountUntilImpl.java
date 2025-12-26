package org.sheepy.lily.core.model.cadence.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.cadence.CadenceModelDefinition;
import org.sheepy.lily.core.model.cadence.CountUntil;

public final class CountUntilImpl extends FeaturedObject<CountUntil.Features<?>> implements CountUntil {
  private static final int FEATURE_COUNT = 2;
  private final ModelNotifier<CountUntil.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private int totalCount;
  private int currentCount;

  public CountUntilImpl(final int totalCount, final int currentCount) {
    this.totalCount = totalCount;
    this.currentCount = currentCount;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<CountUntil.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public int totalCount() {
    return totalCount;
  }

  @Override
  public void totalCount(final int totalCount) {
    final var oldValue = this.totalCount;
    this.totalCount = totalCount;
    notifier.notifyInt(CountUntil.FeatureIDs.TOTAL_COUNT, false, false, oldValue, totalCount);
  }

  @Override
  public int currentCount() {
    return currentCount;
  }

  @Override
  public void currentCount(final int currentCount) {
    final var oldValue = this.currentCount;
    this.currentCount = currentCount;
    notifier.notifyInt(CountUntil.FeatureIDs.CURRENT_COUNT, false, false, oldValue, currentCount);
  }

  @Override
  public Group<CountUntil> lmGroup() {
    return CadenceModelDefinition.Groups.COUNT_UNTIL;
  }

  @Override
  protected FeatureSetter<CountUntil> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<CountUntil> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case CountUntil.FeatureIDs.TOTAL_COUNT -> 0;
      case CountUntil.FeatureIDs.CURRENT_COUNT -> 1;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<CountUntil> GET_MAP = new FeatureGetter.Builder<CountUntil>(FEATURE_COUNT, CountUntilImpl::featureIndexStatic).add(CountUntil.FeatureIDs.TOTAL_COUNT, CountUntil::totalCount).add(CountUntil.FeatureIDs.CURRENT_COUNT, CountUntil::currentCount).build();
    private static final FeatureSetter<CountUntil> SET_MAP = new FeatureSetter.Builder<CountUntil>(FEATURE_COUNT, CountUntilImpl::featureIndexStatic).add(CountUntil.FeatureIDs.TOTAL_COUNT, (object, value) -> ((CountUntilImpl) object).totalCount((int) value)).add(CountUntil.FeatureIDs.CURRENT_COUNT, (object, value) -> ((CountUntilImpl) object).currentCount((int) value)).build();
  }
}
