package org.sheepy.lily.core.allocation.test.testallocation.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.allocation.test.testallocation.AllocationObject;
import org.sheepy.lily.core.allocation.test.testallocation.Container;
import org.sheepy.lily.core.allocation.test.testallocation.Leaf;
import org.sheepy.lily.core.allocation.test.testallocation.Node;
import org.sheepy.lily.core.allocation.test.testallocation.TestallocationModelDefinition;

public final class NodeImpl extends FeaturedObject<Node.Features<?>> implements Node {
  private static final int FEATURE_COUNT = 6;
  private final ModelNotifier<Node.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private int currentAllocationCount;
  private int totalAllocationCount;
  private int dependencyUpdateCount;
  private boolean activated;
  private final List<Leaf> leaves = newObservableList(Node.FeatureIDs.LEAVES, true, true);
  private Container container;

  public NodeImpl() {
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<Node.Features<?>> notifier() {
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
  public List<Leaf> leaves() {
    return leaves;
  }

  @Override
  public Container container() {
    return container;
  }

  @Override
  public void container(final Container container) {
    final var oldValue = this.container;
    final var eventType = container == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.container = container;
    notifier.notify(Node.FeatureIDs.CONTAINER, false, false, eventType, oldValue, container);
  }

  @Override
  public Group<Node> lmGroup() {
    return TestallocationModelDefinition.Groups.NODE;
  }

  @Override
  protected FeatureSetter<Node> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<Node> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case Node.FeatureIDs.CURRENT_ALLOCATION_COUNT -> 0;
      case Node.FeatureIDs.TOTAL_ALLOCATION_COUNT -> 1;
      case Node.FeatureIDs.DEPENDENCY_UPDATE_COUNT -> 2;
      case Node.FeatureIDs.ACTIVATED -> 3;
      case Node.FeatureIDs.LEAVES -> 4;
      case Node.FeatureIDs.CONTAINER -> 5;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<Node> GET_MAP = new FeatureGetter.Builder<Node>(FEATURE_COUNT, NodeImpl::featureIndexStatic).add(Node.FeatureIDs.CURRENT_ALLOCATION_COUNT, Node::currentAllocationCount).add(Node.FeatureIDs.TOTAL_ALLOCATION_COUNT, Node::totalAllocationCount).add(Node.FeatureIDs.DEPENDENCY_UPDATE_COUNT, Node::dependencyUpdateCount).add(Node.FeatureIDs.ACTIVATED, Node::activated).add(Node.FeatureIDs.LEAVES, Node::leaves).add(Node.FeatureIDs.CONTAINER, Node::container).build();
    private static final FeatureSetter<Node> SET_MAP = new FeatureSetter.Builder<Node>(FEATURE_COUNT, NodeImpl::featureIndexStatic).add(Node.FeatureIDs.CURRENT_ALLOCATION_COUNT, (object, value) -> ((NodeImpl) object).currentAllocationCount((int) value)).add(Node.FeatureIDs.TOTAL_ALLOCATION_COUNT, (object, value) -> ((NodeImpl) object).totalAllocationCount((int) value)).add(Node.FeatureIDs.DEPENDENCY_UPDATE_COUNT, (object, value) -> ((NodeImpl) object).dependencyUpdateCount((int) value)).add(Node.FeatureIDs.ACTIVATED, (object, value) -> ((NodeImpl) object).activated((boolean) value)).add(Node.FeatureIDs.CONTAINER, (object, value) -> ((NodeImpl) object).container((Container) value)).build();
  }
}
