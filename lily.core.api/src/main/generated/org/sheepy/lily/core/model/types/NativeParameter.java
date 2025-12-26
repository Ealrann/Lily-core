package org.sheepy.lily.core.model.types;

import java.util.List;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.lang.Feature;

public interface NativeParameter<T> extends Parameter {
  @Override
  IModelNotifier<? extends Features<?>> notifier();

  default T getNativeValue() {
    throw new UnsupportedOperationException("Operation 'getNativeValue' is not implemented");
  }

  interface FeatureIDs {
  }

  interface Features<T extends Features<T>> extends Parameter.Features<T> {
    List<Feature<?, ?, ?, ?>> ALL = List.of();
  }
}
