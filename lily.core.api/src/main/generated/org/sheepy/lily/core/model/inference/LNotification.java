package org.sheepy.lily.core.model.inference;

import java.util.List;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.lang.Feature;

public interface LNotification extends AbstractNotification {
  @Override
  IModelNotifier<? extends Features<?>> notifier();

  interface FeatureIDs {
  }

  interface Features<T extends Features<T>> extends AbstractNotification.Features<T> {
    List<Feature<?, ?, ?, ?>> ALL = List.of();
  }
}
