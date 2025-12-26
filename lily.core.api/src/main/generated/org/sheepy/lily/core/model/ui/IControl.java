package org.sheepy.lily.core.model.ui;

import java.util.List;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.lang.Feature;

public interface IControl extends IUIElement {
  @Override
  IModelNotifier<? extends Features<?>> notifier();

  interface FeatureIDs {
  }

  interface Features<T extends Features<T>> extends IUIElement.Features<T> {
    List<Feature<?, ?, ?, ?>> ALL = List.of();
  }
}
