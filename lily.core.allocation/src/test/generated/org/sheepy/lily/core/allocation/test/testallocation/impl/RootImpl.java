package org.sheepy.lily.core.allocation.test.testallocation.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.allocation.test.testallocation.AllocationObject;
import org.sheepy.lily.core.allocation.test.testallocation.Container;
import org.sheepy.lily.core.allocation.test.testallocation.Node;
import org.sheepy.lily.core.allocation.test.testallocation.Root;
import org.sheepy.lily.core.allocation.test.testallocation.TestallocationModelDefinition;

public final class RootImpl extends FeaturedObject<Root.Features<?>> implements Root {
  private static final int FEATURE_COUNT = 6;
  private final ModelNotifier<Root.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private int currentAllocationCount;
  private int totalAllocationCount;
  private int dependencyUpdateCount;
  private boolean activated;
  private final List<Node> nodes = newObservableList(Root.FeatureIDs.NODES, true, true);
  private final List<Container> containers = newObservableList(Root.FeatureIDs.CONTAINERS, true, true);

  public RootImpl() {
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<Root.Features<?>> notifier() {
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
  public List<Node> nodes() {
    return nodes;
  }

  @Override
  public List<Container> containers() {
    return containers;
  }

  @Override
  public Group<Root> lmGroup() {
    return TestallocationModelDefinition.Groups.ROOT;
  }

  @Override
  protected FeatureSetter<Root> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<Root> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case Root.FeatureIDs.CURRENT_ALLOCATION_COUNT -> 0;
      case Root.FeatureIDs.TOTAL_ALLOCATION_COUNT -> 1;
      case Root.FeatureIDs.DEPENDENCY_UPDATE_COUNT -> 2;
      case Root.FeatureIDs.ACTIVATED -> 3;
      case Root.FeatureIDs.NODES -> 4;
      case Root.FeatureIDs.CONTAINERS -> 5;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<Root> GET_MAP = new FeatureGetter.Builder<Root>(FEATURE_COUNT, RootImpl::featureIndexStatic).add(Root.FeatureIDs.CURRENT_ALLOCATION_COUNT, Root::currentAllocationCount).add(Root.FeatureIDs.TOTAL_ALLOCATION_COUNT, Root::totalAllocationCount).add(Root.FeatureIDs.DEPENDENCY_UPDATE_COUNT, Root::dependencyUpdateCount).add(Root.FeatureIDs.ACTIVATED, Root::activated).add(Root.FeatureIDs.NODES, Root::nodes).add(Root.FeatureIDs.CONTAINERS, Root::containers).build();
    private static final FeatureSetter<Root> SET_MAP = new FeatureSetter.Builder<Root>(FEATURE_COUNT, RootImpl::featureIndexStatic).add(Root.FeatureIDs.CURRENT_ALLOCATION_COUNT, (object, value) -> ((RootImpl) object).currentAllocationCount((int) value)).add(Root.FeatureIDs.TOTAL_ALLOCATION_COUNT, (object, value) -> ((RootImpl) object).totalAllocationCount((int) value)).add(Root.FeatureIDs.DEPENDENCY_UPDATE_COUNT, (object, value) -> ((RootImpl) object).dependencyUpdateCount((int) value)).add(Root.FeatureIDs.ACTIVATED, (object, value) -> ((RootImpl) object).activated((boolean) value)).build();
  }
}
