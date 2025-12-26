package org.sheepy.lily.core.model.cadence;

import java.util.List;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.IntListener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.sheepy.lily.core.model.cadence.builder.CountUntilBuilder;

public interface CountUntil extends ICadenceCondition {
  static Builder builder() {
    return new CountUntilBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  int totalCount();
  int currentCount();
  void totalCount(final int totalCount);
  void currentCount(final int currentCount);

  interface FeatureIDs {
    int TOTAL_COUNT = 860174635;
    int CURRENT_COUNT = 1924149270;
  }

  interface Features<T extends Features<T>> extends ICadenceCondition.Features<T> {
    Attribute<Integer, Integer, IntListener, Features<?>> TOTAL_COUNT = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("totalCount").mandatory(true).defaultValue("1").id(CountUntil.FeatureIDs.TOTAL_COUNT).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    Attribute<Integer, Integer, IntListener, Features<?>> CURRENT_COUNT = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("currentCount").mandatory(true).defaultValue("0").id(CountUntil.FeatureIDs.CURRENT_COUNT).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(TOTAL_COUNT, CURRENT_COUNT);
  }

  interface Builder extends IFeaturedObject.Builder<CountUntil> {
    Builder totalCount(int totalCount);
    Builder currentCount(int currentCount);
  }
}
