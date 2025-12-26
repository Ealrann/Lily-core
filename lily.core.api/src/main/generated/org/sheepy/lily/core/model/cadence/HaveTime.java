package org.sheepy.lily.core.model.cadence;

import java.util.List;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.lang.Feature;
import org.sheepy.lily.core.model.cadence.builder.HaveTimeBuilder;

public interface HaveTime extends ICadenceCondition {
  static Builder builder() {
    return new HaveTimeBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();

  interface FeatureIDs {
  }

  interface Features<T extends Features<T>> extends ICadenceCondition.Features<T> {
    List<Feature<?, ?, ?, ?>> ALL = List.of();
  }

  interface Builder extends IFeaturedObject.Builder<HaveTime> {
  }
}
