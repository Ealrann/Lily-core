package org.sheepy.lily.core.allocation.test.testallocation.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.allocation.test.testallocation.AllocationObject;
import org.sheepy.lily.core.allocation.test.testallocation.Box;
import org.sheepy.lily.core.allocation.test.testallocation.TestallocationModelDefinition;

public final class BoxImpl extends FeaturedObject<Box.Features<?>> implements Box {
  private static final int FEATURE_COUNT = 4;
  private final ModelNotifier<Box.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private int currentAllocationCount;
  private int totalAllocationCount;
  private int dependencyUpdateCount;
  private boolean activated;

  public BoxImpl() {
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<Box.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public int currentAllocationCount() {
    return currentAllocationCount;
  }

  @Override
  public void currentAllocationCount(final int currentAllocationCount) {
    final var oldValue = this.currentAllocationCount;
    this.currentAllocationCount = currentAllocationCount;
    notifier.notifyInt(AllocationObject.FeatureIDs.CURRENT_ALLOCATION_COUNT, false, false, oldValue, currentAllocationCount);
  }

  @Override
  public int totalAllocationCount() {
    return totalAllocationCount;
  }

  @Override
  public void totalAllocationCount(final int totalAllocationCount) {
    final var oldValue = this.totalAllocationCount;
    this.totalAllocationCount = totalAllocationCount;
    notifier.notifyInt(AllocationObject.FeatureIDs.TOTAL_ALLOCATION_COUNT, false, false, oldValue, totalAllocationCount);
  }

  @Override
  public int dependencyUpdateCount() {
    return dependencyUpdateCount;
  }

  @Override
  public void dependencyUpdateCount(final int dependencyUpdateCount) {
    final var oldValue = this.dependencyUpdateCount;
    this.dependencyUpdateCount = dependencyUpdateCount;
    notifier.notifyInt(AllocationObject.FeatureIDs.DEPENDENCY_UPDATE_COUNT, false, false, oldValue, dependencyUpdateCount);
  }

  @Override
  public boolean activated() {
    return activated;
  }

  @Override
  public void activated(final boolean activated) {
    final var oldValue = this.activated;
    this.activated = activated;
    notifier.notifyBoolean(AllocationObject.FeatureIDs.ACTIVATED, false, false, oldValue, activated);
  }

  @Override
  public Group<Box> lmGroup() {
    return TestallocationModelDefinition.Groups.BOX;
  }

  @Override
  protected FeatureSetter<Box> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<Box> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case Box.FeatureIDs.CURRENT_ALLOCATION_COUNT -> 0;
      case Box.FeatureIDs.TOTAL_ALLOCATION_COUNT -> 1;
      case Box.FeatureIDs.DEPENDENCY_UPDATE_COUNT -> 2;
      case Box.FeatureIDs.ACTIVATED -> 3;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<Box> GET_MAP = new FeatureGetter.Builder<Box>(FEATURE_COUNT, BoxImpl::featureIndexStatic).add(Box.FeatureIDs.CURRENT_ALLOCATION_COUNT, Box::currentAllocationCount).add(Box.FeatureIDs.TOTAL_ALLOCATION_COUNT, Box::totalAllocationCount).add(Box.FeatureIDs.DEPENDENCY_UPDATE_COUNT, Box::dependencyUpdateCount).add(Box.FeatureIDs.ACTIVATED, Box::activated).build();
    private static final FeatureSetter<Box> SET_MAP = new FeatureSetter.Builder<Box>(FEATURE_COUNT, BoxImpl::featureIndexStatic).add(Box.FeatureIDs.CURRENT_ALLOCATION_COUNT, (object, value) -> ((BoxImpl) object).currentAllocationCount((int) value)).add(Box.FeatureIDs.TOTAL_ALLOCATION_COUNT, (object, value) -> ((BoxImpl) object).totalAllocationCount((int) value)).add(Box.FeatureIDs.DEPENDENCY_UPDATE_COUNT, (object, value) -> ((BoxImpl) object).dependencyUpdateCount((int) value)).add(Box.FeatureIDs.ACTIVATED, (object, value) -> ((BoxImpl) object).activated((boolean) value)).build();
  }
}
