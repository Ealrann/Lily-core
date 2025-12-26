package org.sheepy.lily.core.allocation.test.testallocation;

import java.util.List;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.BooleanListener;
import org.logoce.lmf.core.api.notification.listener.IntListener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;

public interface AllocationObject extends LMObject {
  @Override
  IModelNotifier<? extends Features<?>> notifier();
  int currentAllocationCount();
  int totalAllocationCount();
  int dependencyUpdateCount();
  boolean activated();
  void currentAllocationCount(final int currentAllocationCount);
  void totalAllocationCount(final int totalAllocationCount);
  void dependencyUpdateCount(final int dependencyUpdateCount);
  void activated(final boolean activated);

  interface FeatureIDs {
    int CURRENT_ALLOCATION_COUNT = -1642749004;
    int TOTAL_ALLOCATION_COUNT = -2028743159;
    int DEPENDENCY_UPDATE_COUNT = -1195732131;
    int ACTIVATED = 984349363;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Attribute<Integer, Integer, IntListener, Features<?>> CURRENT_ALLOCATION_COUNT = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("currentAllocationCount").defaultValue("0").id(AllocationObject.FeatureIDs.CURRENT_ALLOCATION_COUNT).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    Attribute<Integer, Integer, IntListener, Features<?>> TOTAL_ALLOCATION_COUNT = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("totalAllocationCount").defaultValue("0").id(AllocationObject.FeatureIDs.TOTAL_ALLOCATION_COUNT).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    Attribute<Integer, Integer, IntListener, Features<?>> DEPENDENCY_UPDATE_COUNT = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("dependencyUpdateCount").defaultValue("0").id(AllocationObject.FeatureIDs.DEPENDENCY_UPDATE_COUNT).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    Attribute<Boolean, Boolean, BooleanListener, Features<?>> ACTIVATED = new AttributeBuilder<Boolean, Boolean, BooleanListener, Features<?>>().name("activated").defaultValue("true").id(AllocationObject.FeatureIDs.ACTIVATED).datatype(() -> LMCoreModelDefinition.Units.BOOLEAN).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(CURRENT_ALLOCATION_COUNT, TOTAL_ALLOCATION_COUNT, DEPENDENCY_UPDATE_COUNT, ACTIVATED);
  }
}
