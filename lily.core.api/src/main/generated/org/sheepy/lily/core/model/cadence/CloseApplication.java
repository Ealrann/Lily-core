package org.sheepy.lily.core.model.cadence;

import java.util.List;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.lang.Feature;
import org.sheepy.lily.core.model.cadence.builder.CloseApplicationBuilder;

public interface CloseApplication extends ICadenceTask {
  static Builder builder() {
    return new CloseApplicationBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();

  interface FeatureIDs {
  }

  interface Features<T extends Features<T>> extends ICadenceTask.Features<T> {
    List<Feature<?, ?, ?, ?>> ALL = List.of();
  }

  interface Builder extends IFeaturedObject.Builder<CloseApplication> {
  }
}
