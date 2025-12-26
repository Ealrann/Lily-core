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
import org.sheepy.lily.core.allocation.test.testallocation.builder.LeafBuilder;

public interface Leaf extends AllocationObject {
  static Builder builder() {
    return new LeafBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<Box> boxes();

  interface FeatureIDs {
    int CURRENT_ALLOCATION_COUNT = AllocationObject.FeatureIDs.CURRENT_ALLOCATION_COUNT;
    int TOTAL_ALLOCATION_COUNT = AllocationObject.FeatureIDs.TOTAL_ALLOCATION_COUNT;
    int DEPENDENCY_UPDATE_COUNT = AllocationObject.FeatureIDs.DEPENDENCY_UPDATE_COUNT;
    int ACTIVATED = AllocationObject.FeatureIDs.ACTIVATED;
    int BOXES = -87708422;
  }

  interface Features<T extends Features<T>> extends AllocationObject.Features<T> {
    Attribute<Integer, Integer, IntListener, AllocationObject.Features<?>> CURRENT_ALLOCATION_COUNT = AllocationObject.Features.CURRENT_ALLOCATION_COUNT;
    Attribute<Integer, Integer, IntListener, AllocationObject.Features<?>> TOTAL_ALLOCATION_COUNT = AllocationObject.Features.TOTAL_ALLOCATION_COUNT;
    Attribute<Integer, Integer, IntListener, AllocationObject.Features<?>> DEPENDENCY_UPDATE_COUNT = AllocationObject.Features.DEPENDENCY_UPDATE_COUNT;
    Attribute<Boolean, Boolean, BooleanListener, AllocationObject.Features<?>> ACTIVATED = AllocationObject.Features.ACTIVATED;
    Relation<Box, List<Box>, Listener<List<Box>>, Features<?>> BOXES = new RelationBuilder<Box, List<Box>, Listener<List<Box>>, Features<?>>().name("boxes").many(true).id(Leaf.FeatureIDs.BOXES).concept(() -> TestallocationModelDefinition.Groups.BOX).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(CURRENT_ALLOCATION_COUNT, TOTAL_ALLOCATION_COUNT, DEPENDENCY_UPDATE_COUNT, ACTIVATED, BOXES);
  }

  interface Builder extends IFeaturedObject.Builder<Leaf> {
    Builder currentAllocationCount(int currentAllocationCount);
    Builder totalAllocationCount(int totalAllocationCount);
    Builder dependencyUpdateCount(int dependencyUpdateCount);
    Builder activated(boolean activated);
    Builder addBoxe(Supplier<Box> boxe);
    Builder addBoxes(List<Box> boxes);
  }
}
