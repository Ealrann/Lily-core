package org.sheepy.lily.core.allocation.test.testallocation;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.BooleanListener;
import org.logoce.lmf.core.api.notification.listener.IntListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.core.allocation.test.testallocation.builder.NodeBuilder;

public interface Node extends AllocationObject {
  static Builder builder() {
    return new NodeBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<Leaf> leaves();
  Container container();
  void container(final Container container);

  interface FeatureIDs {
    int CURRENT_ALLOCATION_COUNT = AllocationObject.FeatureIDs.CURRENT_ALLOCATION_COUNT;
    int TOTAL_ALLOCATION_COUNT = AllocationObject.FeatureIDs.TOTAL_ALLOCATION_COUNT;
    int DEPENDENCY_UPDATE_COUNT = AllocationObject.FeatureIDs.DEPENDENCY_UPDATE_COUNT;
    int ACTIVATED = AllocationObject.FeatureIDs.ACTIVATED;
    int LEAVES = 2013083735;
    int CONTAINER = -923844890;
  }

  interface Features<T extends Features<T>> extends AllocationObject.Features<T> {
    Attribute<Integer, Integer, IntListener, AllocationObject.Features<?>> CURRENT_ALLOCATION_COUNT = AllocationObject.Features.CURRENT_ALLOCATION_COUNT;
    Attribute<Integer, Integer, IntListener, AllocationObject.Features<?>> TOTAL_ALLOCATION_COUNT = AllocationObject.Features.TOTAL_ALLOCATION_COUNT;
    Attribute<Integer, Integer, IntListener, AllocationObject.Features<?>> DEPENDENCY_UPDATE_COUNT = AllocationObject.Features.DEPENDENCY_UPDATE_COUNT;
    Attribute<Boolean, Boolean, BooleanListener, AllocationObject.Features<?>> ACTIVATED = AllocationObject.Features.ACTIVATED;
    Relation<Leaf, List<Leaf>, Listener<List<Leaf>>, Features<?>> LEAVES = new RelationBuilder<Leaf, List<Leaf>, Listener<List<Leaf>>, Features<?>>().name("leaves").many(true).contains(true).id(Node.FeatureIDs.LEAVES).concept(() -> TestallocationModelDefinition.Groups.LEAF).build();
    Relation<Container, Container, Listener<Container>, Features<?>> CONTAINER = new RelationBuilder<Container, Container, Listener<Container>, Features<?>>().name("container").id(Node.FeatureIDs.CONTAINER).concept(() -> TestallocationModelDefinition.Groups.CONTAINER).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(CURRENT_ALLOCATION_COUNT, TOTAL_ALLOCATION_COUNT, DEPENDENCY_UPDATE_COUNT, ACTIVATED, LEAVES, CONTAINER);
  }

  interface Builder extends IFeaturedObject.Builder<Node> {
    Builder currentAllocationCount(int currentAllocationCount);
    Builder totalAllocationCount(int totalAllocationCount);
    Builder dependencyUpdateCount(int dependencyUpdateCount);
    Builder activated(boolean activated);
    Builder addLeave(Supplier<Leaf> leave);
    Builder container(Supplier<Container> container);
    Builder addLeaves(List<Leaf> leaves);
  }
}
