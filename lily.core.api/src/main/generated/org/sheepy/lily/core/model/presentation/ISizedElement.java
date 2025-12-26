package org.sheepy.lily.core.model.presentation;

import java.util.List;
import org.joml.Vector2ic;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.IntListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.sheepy.lily.core.model.types.EHorizontalRelative;
import org.sheepy.lily.core.model.types.EVerticalRelative;

public interface ISizedElement extends IPositionElement {
  @Override
  IModelNotifier<? extends Features<?>> notifier();
  int width();
  int height();
  void width(final int width);
  void height(final int height);

  interface FeatureIDs {
    int POSITION = IPositionElement.FeatureIDs.POSITION;
    int VERTICAL_RELATIVE = IPositionElement.FeatureIDs.VERTICAL_RELATIVE;
    int HORIZONTAL_RELATIVE = IPositionElement.FeatureIDs.HORIZONTAL_RELATIVE;
    int WIDTH = -1331036272;
    int HEIGHT = 1254553757;
  }

  interface Features<T extends Features<T>> extends IPositionElement.Features<T> {
    Attribute<Vector2ic, Vector2ic, Listener<Vector2ic>, IPositionElement.Features<?>> POSITION = IPositionElement.Features.POSITION;
    Attribute<EVerticalRelative, EVerticalRelative, Listener<EVerticalRelative>, IPositionElement.Features<?>> VERTICAL_RELATIVE = IPositionElement.Features.VERTICAL_RELATIVE;
    Attribute<EHorizontalRelative, EHorizontalRelative, Listener<EHorizontalRelative>, IPositionElement.Features<?>> HORIZONTAL_RELATIVE = IPositionElement.Features.HORIZONTAL_RELATIVE;
    Attribute<Integer, Integer, IntListener, Features<?>> WIDTH = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("width").id(ISizedElement.FeatureIDs.WIDTH).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    Attribute<Integer, Integer, IntListener, Features<?>> HEIGHT = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("height").id(ISizedElement.FeatureIDs.HEIGHT).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(POSITION, VERTICAL_RELATIVE, HORIZONTAL_RELATIVE, WIDTH, HEIGHT);
  }
}
