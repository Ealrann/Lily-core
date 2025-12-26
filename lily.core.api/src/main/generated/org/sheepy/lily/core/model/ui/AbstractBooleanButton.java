package org.sheepy.lily.core.model.ui;

import java.util.List;
import org.joml.Vector2ic;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.IntListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.sheepy.lily.core.model.presentation.IPositionElement;
import org.sheepy.lily.core.model.presentation.ISizedElement;
import org.sheepy.lily.core.model.types.EHorizontalRelative;
import org.sheepy.lily.core.model.types.EVerticalRelative;

public interface AbstractBooleanButton extends AbstractButton {
  @Override
  IModelNotifier<? extends Features<?>> notifier();
  String textWhenTrue();
  String textWhenFalse();
  void textWhenTrue(final String textWhenTrue);
  void textWhenFalse(final String textWhenFalse);

  interface FeatureIDs {
    int POSITION = IPositionElement.FeatureIDs.POSITION;
    int VERTICAL_RELATIVE = IPositionElement.FeatureIDs.VERTICAL_RELATIVE;
    int HORIZONTAL_RELATIVE = IPositionElement.FeatureIDs.HORIZONTAL_RELATIVE;
    int WIDTH = ISizedElement.FeatureIDs.WIDTH;
    int HEIGHT = ISizedElement.FeatureIDs.HEIGHT;
    int FONT = TextWidget.FeatureIDs.FONT;
    int TEXT = AbstractButton.FeatureIDs.TEXT;
    int TEXT_WHEN_TRUE = 771917915;
    int TEXT_WHEN_FALSE = -1853792266;
  }

  interface Features<T extends Features<T>> extends AbstractButton.Features<T> {
    Attribute<Vector2ic, Vector2ic, Listener<Vector2ic>, IPositionElement.Features<?>> POSITION = IPositionElement.Features.POSITION;
    Attribute<EVerticalRelative, EVerticalRelative, Listener<EVerticalRelative>, IPositionElement.Features<?>> VERTICAL_RELATIVE = IPositionElement.Features.VERTICAL_RELATIVE;
    Attribute<EHorizontalRelative, EHorizontalRelative, Listener<EHorizontalRelative>, IPositionElement.Features<?>> HORIZONTAL_RELATIVE = IPositionElement.Features.HORIZONTAL_RELATIVE;
    Attribute<Integer, Integer, IntListener, ISizedElement.Features<?>> WIDTH = ISizedElement.Features.WIDTH;
    Attribute<Integer, Integer, IntListener, ISizedElement.Features<?>> HEIGHT = ISizedElement.Features.HEIGHT;
    Relation<Font, Font, Listener<Font>, TextWidget.Features<?>> FONT = TextWidget.Features.FONT;
    Attribute<String, String, Listener<String>, AbstractButton.Features<?>> TEXT = AbstractButton.Features.TEXT;
    Attribute<String, String, Listener<String>, Features<?>> TEXT_WHEN_TRUE = new AttributeBuilder<String, String, Listener<String>, Features<?>>().name("textWhenTrue").id(AbstractBooleanButton.FeatureIDs.TEXT_WHEN_TRUE).datatype(() -> LMCoreModelDefinition.Units.STRING).build();
    Attribute<String, String, Listener<String>, Features<?>> TEXT_WHEN_FALSE = new AttributeBuilder<String, String, Listener<String>, Features<?>>().name("textWhenFalse").id(AbstractBooleanButton.FeatureIDs.TEXT_WHEN_FALSE).datatype(() -> LMCoreModelDefinition.Units.STRING).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(POSITION, VERTICAL_RELATIVE, HORIZONTAL_RELATIVE, WIDTH, HEIGHT, FONT, TEXT, TEXT_WHEN_TRUE, TEXT_WHEN_FALSE);
  }
}
