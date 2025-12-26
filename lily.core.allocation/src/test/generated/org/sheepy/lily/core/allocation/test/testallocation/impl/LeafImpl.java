package org.sheepy.lily.core.allocation.test.testallocation.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.allocation.test.testallocation.AllocationObject;
import org.sheepy.lily.core.allocation.test.testallocation.Box;
import org.sheepy.lily.core.allocation.test.testallocation.Leaf;
import org.sheepy.lily.core.allocation.test.testallocation.TestallocationModelDefinition;

public final class LeafImpl extends FeaturedObject<Leaf.Features<?>> implements Leaf {
  private static final int FEATURE_COUNT = 5;
  private final ModelNotifier<Leaf.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private int currentAllocationCount;
  private int totalAllocationCount;
  private int dependencyUpdateCount;
  private boolean activated;
  private final List<Box> boxes = newObservableList(Leaf.FeatureIDs.BOXES, true, false);

  public LeafImpl() {
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<Leaf.Features<?>> notifier() {
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
  public List<Box> boxes() {
    return boxes;
  }

  @Override
  public Group<Leaf> lmGroup() {
    return TestallocationModelDefinition.Groups.LEAF;
  }

  @Override
  protected FeatureSetter<Leaf> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<Leaf> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case Leaf.FeatureIDs.CURRENT_ALLOCATION_COUNT -> 0;
      case Leaf.FeatureIDs.TOTAL_ALLOCATION_COUNT -> 1;
      case Leaf.FeatureIDs.DEPENDENCY_UPDATE_COUNT -> 2;
      case Leaf.FeatureIDs.ACTIVATED -> 3;
      case Leaf.FeatureIDs.BOXES -> 4;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<Leaf> GET_MAP = new FeatureGetter.Builder<Leaf>(FEATURE_COUNT, LeafImpl::featureIndexStatic).add(Leaf.FeatureIDs.CURRENT_ALLOCATION_COUNT, Leaf::currentAllocationCount).add(Leaf.FeatureIDs.TOTAL_ALLOCATION_COUNT, Leaf::totalAllocationCount).add(Leaf.FeatureIDs.DEPENDENCY_UPDATE_COUNT, Leaf::dependencyUpdateCount).add(Leaf.FeatureIDs.ACTIVATED, Leaf::activated).add(Leaf.FeatureIDs.BOXES, Leaf::boxes).build();
    private static final FeatureSetter<Leaf> SET_MAP = new FeatureSetter.Builder<Leaf>(FEATURE_COUNT, LeafImpl::featureIndexStatic).add(Leaf.FeatureIDs.CURRENT_ALLOCATION_COUNT, (object, value) -> ((LeafImpl) object).currentAllocationCount((int) value)).add(Leaf.FeatureIDs.TOTAL_ALLOCATION_COUNT, (object, value) -> ((LeafImpl) object).totalAllocationCount((int) value)).add(Leaf.FeatureIDs.DEPENDENCY_UPDATE_COUNT, (object, value) -> ((LeafImpl) object).dependencyUpdateCount((int) value)).add(Leaf.FeatureIDs.ACTIVATED, (object, value) -> ((LeafImpl) object).activated((boolean) value)).build();
  }
}
