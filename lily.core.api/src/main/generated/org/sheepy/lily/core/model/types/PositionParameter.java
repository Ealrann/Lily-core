package org.sheepy.lily.core.model.types;

import java.util.List;
import org.joml.Vector2ic;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.lang.Feature;

public interface PositionParameter extends Parameter {
  @Override
  IModelNotifier<? extends Features<?>> notifier();

  default Vector2ic getPosition() {
    throw new UnsupportedOperationException("Operation 'getPosition' is not implemented");
  }

  interface FeatureIDs {
  }

  interface Features<T extends Features<T>> extends Parameter.Features<T> {
    List<Feature<?, ?, ?, ?>> ALL = List.of();
  }
}
