package org.sheepy.lily.core.model.ui;

import java.util.List;
import java.util.function.Supplier;
import org.joml.Vector2ic;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.BooleanListener;
import org.logoce.lmf.core.api.notification.listener.FloatListener;
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
import org.sheepy.lily.core.model.ui.builder.LabelBuilder;

public interface Label extends AbstractLabel {
  static Builder builder() {
    return new LabelBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  boolean wrap();
  boolean narrator();
  int narrationSpeed();
  void wrap(final boolean wrap);
  void narrator(final boolean narrator);
  void narrationSpeed(final int narrationSpeed);

  interface FeatureIDs {
    int POSITION = IPositionElement.FeatureIDs.POSITION;
    int VERTICAL_RELATIVE = IPositionElement.FeatureIDs.VERTICAL_RELATIVE;
    int HORIZONTAL_RELATIVE = IPositionElement.FeatureIDs.HORIZONTAL_RELATIVE;
    int WIDTH = ISizedElement.FeatureIDs.WIDTH;
    int HEIGHT = ISizedElement.FeatureIDs.HEIGHT;
    int FONT = TextWidget.FeatureIDs.FONT;
    int TEXT = AbstractLabel.FeatureIDs.TEXT;
    int FONT_SCALE = AbstractLabel.FeatureIDs.FONT_SCALE;
    int WRAP = 136874356;
    int NARRATOR = 943101747;
    int NARRATION_SPEED = -1056404881;
  }

  interface Features<T extends Features<T>> extends AbstractLabel.Features<T> {
    Attribute<Vector2ic, Vector2ic, Listener<Vector2ic>, IPositionElement.Features<?>> POSITION = IPositionElement.Features.POSITION;
    Attribute<EVerticalRelative, EVerticalRelative, Listener<EVerticalRelative>, IPositionElement.Features<?>> VERTICAL_RELATIVE = IPositionElement.Features.VERTICAL_RELATIVE;
    Attribute<EHorizontalRelative, EHorizontalRelative, Listener<EHorizontalRelative>, IPositionElement.Features<?>> HORIZONTAL_RELATIVE = IPositionElement.Features.HORIZONTAL_RELATIVE;
    Attribute<Integer, Integer, IntListener, ISizedElement.Features<?>> WIDTH = ISizedElement.Features.WIDTH;
    Attribute<Integer, Integer, IntListener, ISizedElement.Features<?>> HEIGHT = ISizedElement.Features.HEIGHT;
    Relation<Font, Font, Listener<Font>, TextWidget.Features<?>> FONT = TextWidget.Features.FONT;
    Attribute<String, String, Listener<String>, AbstractLabel.Features<?>> TEXT = AbstractLabel.Features.TEXT;
    Attribute<Float, Float, FloatListener, AbstractLabel.Features<?>> FONT_SCALE = AbstractLabel.Features.FONT_SCALE;
    Attribute<Boolean, Boolean, BooleanListener, Features<?>> WRAP = new AttributeBuilder<Boolean, Boolean, BooleanListener, Features<?>>().name("wrap").mandatory(true).defaultValue("false").id(Label.FeatureIDs.WRAP).datatype(() -> LMCoreModelDefinition.Units.BOOLEAN).build();
    Attribute<Boolean, Boolean, BooleanListener, Features<?>> NARRATOR = new AttributeBuilder<Boolean, Boolean, BooleanListener, Features<?>>().name("narrator").mandatory(true).defaultValue("false").id(Label.FeatureIDs.NARRATOR).datatype(() -> LMCoreModelDefinition.Units.BOOLEAN).build();
    Attribute<Integer, Integer, IntListener, Features<?>> NARRATION_SPEED = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("narrationSpeed").defaultValue("100").id(Label.FeatureIDs.NARRATION_SPEED).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(POSITION, VERTICAL_RELATIVE, HORIZONTAL_RELATIVE, WIDTH, HEIGHT, FONT, TEXT, FONT_SCALE, WRAP, NARRATOR, NARRATION_SPEED);
  }

  interface Builder extends IFeaturedObject.Builder<Label> {
    Builder position(Vector2ic position);
    Builder verticalRelative(EVerticalRelative verticalRelative);
    Builder horizontalRelative(EHorizontalRelative horizontalRelative);
    Builder width(int width);
    Builder height(int height);
    Builder font(Supplier<Font> font);
    Builder text(String text);
    Builder fontScale(float fontScale);
    Builder wrap(boolean wrap);
    Builder narrator(boolean narrator);
    Builder narrationSpeed(int narrationSpeed);
  }
}
