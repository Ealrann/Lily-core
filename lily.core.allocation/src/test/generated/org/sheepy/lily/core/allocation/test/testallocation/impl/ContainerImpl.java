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
import org.sheepy.lily.core.allocation.test.testallocation.Container;
import org.sheepy.lily.core.allocation.test.testallocation.TestallocationModelDefinition;

public final class ContainerImpl extends FeaturedObject<Container.Features<?>> implements Container {
  private static final int FEATURE_COUNT = 5;
  private final ModelNotifier<Container.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private int currentAllocationCount;
  private int totalAllocationCount;
  private int dependencyUpdateCount;
  private boolean activated;
  private final List<Box> boxes = newObservableList(Container.FeatureIDs.BOXES, true, true);

  public ContainerImpl() {
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<Container.Features<?>> notifier() {
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
  public Group<Container> lmGroup() {
    return TestallocationModelDefinition.Groups.CONTAINER;
  }

  @Override
  protected FeatureSetter<Container> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<Container> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case Container.FeatureIDs.CURRENT_ALLOCATION_COUNT -> 0;
      case Container.FeatureIDs.TOTAL_ALLOCATION_COUNT -> 1;
      case Container.FeatureIDs.DEPENDENCY_UPDATE_COUNT -> 2;
      case Container.FeatureIDs.ACTIVATED -> 3;
      case Container.FeatureIDs.BOXES -> 4;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<Container> GET_MAP = new FeatureGetter.Builder<Container>(FEATURE_COUNT, ContainerImpl::featureIndexStatic).add(Container.FeatureIDs.CURRENT_ALLOCATION_COUNT, Container::currentAllocationCount).add(Container.FeatureIDs.TOTAL_ALLOCATION_COUNT, Container::totalAllocationCount).add(Container.FeatureIDs.DEPENDENCY_UPDATE_COUNT, Container::dependencyUpdateCount).add(Container.FeatureIDs.ACTIVATED, Container::activated).add(Container.FeatureIDs.BOXES, Container::boxes).build();
    private static final FeatureSetter<Container> SET_MAP = new FeatureSetter.Builder<Container>(FEATURE_COUNT, ContainerImpl::featureIndexStatic).add(Container.FeatureIDs.CURRENT_ALLOCATION_COUNT, (object, value) -> ((ContainerImpl) object).currentAllocationCount((int) value)).add(Container.FeatureIDs.TOTAL_ALLOCATION_COUNT, (object, value) -> ((ContainerImpl) object).totalAllocationCount((int) value)).add(Container.FeatureIDs.DEPENDENCY_UPDATE_COUNT, (object, value) -> ((ContainerImpl) object).dependencyUpdateCount((int) value)).add(Container.FeatureIDs.ACTIVATED, (object, value) -> ((ContainerImpl) object).activated((boolean) value)).build();
  }
}
