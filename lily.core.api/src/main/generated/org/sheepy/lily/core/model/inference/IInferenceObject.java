package org.sheepy.lily.core.model.inference;

import java.util.List;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMObject;

public interface IInferenceObject extends LMObject {
  @Override
  IModelNotifier<? extends Features<?>> notifier();

  default IInferenceObject lInferenceObject() {
    throw new UnsupportedOperationException("Operation 'lInferenceObject' is not implemented");
  }

  interface FeatureIDs {
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    List<Feature<?, ?, ?, ?>> ALL = List.of();
  }
}
