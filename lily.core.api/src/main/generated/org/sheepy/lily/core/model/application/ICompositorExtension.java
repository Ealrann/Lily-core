package org.sheepy.lily.core.model.application;

import java.util.List;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMObject;

public interface ICompositorExtension extends LMObject {
  @Override
  IModelNotifier<? extends Features<?>> notifier();

  interface FeatureIDs {
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    List<Feature<?, ?, ?, ?>> ALL = List.of();
  }
}
