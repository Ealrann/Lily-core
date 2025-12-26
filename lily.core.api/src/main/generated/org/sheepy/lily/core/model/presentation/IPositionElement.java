package org.sheepy.lily.core.model.presentation;

import java.util.List;
import org.joml.Vector2ic;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.sheepy.lily.core.model.types.EHorizontalRelative;
import org.sheepy.lily.core.model.types.EVerticalRelative;
import org.sheepy.lily.core.model.types.TypesModelDefinition;

public interface IPositionElement extends LMObject {
  @Override
  IModelNotifier<? extends Features<?>> notifier();
  Vector2ic position();
  EVerticalRelative verticalRelative();
  EHorizontalRelative horizontalRelative();
  void position(final Vector2ic position);
  void verticalRelative(final EVerticalRelative verticalRelative);
  void horizontalRelative(final EHorizontalRelative horizontalRelative);

  interface FeatureIDs {
    int POSITION = 1403167355;
    int VERTICAL_RELATIVE = -845051980;
    int HORIZONTAL_RELATIVE = 1165070818;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Attribute<Vector2ic, Vector2ic, Listener<Vector2ic>, Features<?>> POSITION = new AttributeBuilder<Vector2ic, Vector2ic, Listener<Vector2ic>, Features<?>>().name("position").defaultValue("0;0").id(IPositionElement.FeatureIDs.POSITION).datatype(() -> TypesModelDefinition.JavaWrappers.VECTOR2I).build();
    Attribute<EVerticalRelative, EVerticalRelative, Listener<EVerticalRelative>, Features<?>> VERTICAL_RELATIVE = new AttributeBuilder<EVerticalRelative, EVerticalRelative, Listener<EVerticalRelative>, Features<?>>().name("verticalRelative").defaultValue("TOP").id(IPositionElement.FeatureIDs.VERTICAL_RELATIVE).datatype(() -> TypesModelDefinition.Enums.E_VERTICAL_RELATIVE).build();
    Attribute<EHorizontalRelative, EHorizontalRelative, Listener<EHorizontalRelative>, Features<?>> HORIZONTAL_RELATIVE = new AttributeBuilder<EHorizontalRelative, EHorizontalRelative, Listener<EHorizontalRelative>, Features<?>>().name("horizontalRelative").defaultValue("LEFT").id(IPositionElement.FeatureIDs.HORIZONTAL_RELATIVE).datatype(() -> TypesModelDefinition.Enums.E_HORIZONTAL_RELATIVE).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(POSITION, VERTICAL_RELATIVE, HORIZONTAL_RELATIVE);
  }
}
