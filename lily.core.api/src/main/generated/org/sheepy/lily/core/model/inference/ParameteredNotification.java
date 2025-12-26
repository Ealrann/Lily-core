package org.sheepy.lily.core.model.inference;

import java.util.List;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.lang.Feature;
import org.sheepy.lily.core.model.types.Parameter;

public interface ParameteredNotification<T extends Parameter> extends AbstractNotification {
  @Override
  IModelNotifier<? extends Features<?>> notifier();

  interface FeatureIDs {
  }

  interface Features<T extends Features<T>> extends AbstractNotification.Features<T> {
    List<Feature<?, ?, ?, ?>> ALL = List.of();
  }
}
