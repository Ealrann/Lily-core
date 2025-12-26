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
import org.sheepy.lily.core.allocation.test.testallocation.builder.RootBuilder;

public interface Root extends AllocationObject {
  static Builder builder() {
    return new RootBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<Node> nodes();
  List<Container> containers();

  interface FeatureIDs {
    int CURRENT_ALLOCATION_COUNT = AllocationObject.FeatureIDs.CURRENT_ALLOCATION_COUNT;
    int TOTAL_ALLOCATION_COUNT = AllocationObject.FeatureIDs.TOTAL_ALLOCATION_COUNT;
    int DEPENDENCY_UPDATE_COUNT = AllocationObject.FeatureIDs.DEPENDENCY_UPDATE_COUNT;
    int ACTIVATED = AllocationObject.FeatureIDs.ACTIVATED;
    int NODES = 314255990;
    int CONTAINERS = 1869627245;
  }

  interface Features<T extends Features<T>> extends AllocationObject.Features<T> {
    Attribute<Integer, Integer, IntListener, AllocationObject.Features<?>> CURRENT_ALLOCATION_COUNT = AllocationObject.Features.CURRENT_ALLOCATION_COUNT;
    Attribute<Integer, Integer, IntListener, AllocationObject.Features<?>> TOTAL_ALLOCATION_COUNT = AllocationObject.Features.TOTAL_ALLOCATION_COUNT;
    Attribute<Integer, Integer, IntListener, AllocationObject.Features<?>> DEPENDENCY_UPDATE_COUNT = AllocationObject.Features.DEPENDENCY_UPDATE_COUNT;
    Attribute<Boolean, Boolean, BooleanListener, AllocationObject.Features<?>> ACTIVATED = AllocationObject.Features.ACTIVATED;
    Relation<Node, List<Node>, Listener<List<Node>>, Features<?>> NODES = new RelationBuilder<Node, List<Node>, Listener<List<Node>>, Features<?>>().name("nodes").many(true).contains(true).id(Root.FeatureIDs.NODES).concept(() -> TestallocationModelDefinition.Groups.NODE).build();
    Relation<Container, List<Container>, Listener<List<Container>>, Features<?>> CONTAINERS = new RelationBuilder<Container, List<Container>, Listener<List<Container>>, Features<?>>().name("containers").many(true).contains(true).id(Root.FeatureIDs.CONTAINERS).concept(() -> TestallocationModelDefinition.Groups.CONTAINER).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(CURRENT_ALLOCATION_COUNT, TOTAL_ALLOCATION_COUNT, DEPENDENCY_UPDATE_COUNT, ACTIVATED, NODES, CONTAINERS);
  }

  interface Builder extends IFeaturedObject.Builder<Root> {
    Builder currentAllocationCount(int currentAllocationCount);
    Builder totalAllocationCount(int totalAllocationCount);
    Builder dependencyUpdateCount(int dependencyUpdateCount);
    Builder activated(boolean activated);
    Builder addNode(Supplier<Node> node);
    Builder addContainer(Supplier<Container> container);
    Builder addNodes(List<Node> nodes);
    Builder addContainers(List<Container> containers);
  }
}
