package org.sheepy.lily.core.model.inference;

import java.util.List;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.lang.Feature;

public interface Sensor extends IInferenceObject {
  @Override
  IModelNotifier<? extends Features<?>> notifier();

  interface FeatureIDs {
  }

  interface Features<T extends Features<T>> extends IInferenceObject.Features<T> {
    List<Feature<?, ?, ?, ?>> ALL = List.of();
  }
}
