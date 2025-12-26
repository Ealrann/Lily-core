package org.sheepy.lily.core.model.ui;

import java.util.List;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.lang.Feature;
import org.sheepy.lily.core.model.inference.IInferenceObject;

public interface IUIElement extends IInferenceObject {
  @Override
  IModelNotifier<? extends Features<?>> notifier();

  interface FeatureIDs {
  }

  interface Features<T extends Features<T>> extends IInferenceObject.Features<T> {
    List<Feature<?, ?, ?, ?>> ALL = List.of();
  }
}
