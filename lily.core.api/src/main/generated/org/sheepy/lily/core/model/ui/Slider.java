package org.sheepy.lily.core.model.ui;

import java.util.List;
import java.util.function.Supplier;
import org.joml.Vector2ic;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.IntListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.core.model.presentation.IPositionElement;
import org.sheepy.lily.core.model.presentation.ISizedElement;
import org.sheepy.lily.core.model.types.EHorizontalRelative;
import org.sheepy.lily.core.model.types.EVerticalRelative;
import org.sheepy.lily.core.model.ui.builder.SliderBuilder;
import org.sheepy.lily.core.model.variable.IVariableResolver;
import org.sheepy.lily.core.model.variable.VariableModelDefinition;

public interface Slider extends TextWidget {
  static Builder builder() {
    return new SliderBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  int minValue();
  int maxValue();
  int step();
  IVariableResolver variableResolver();
  void minValue(final int minValue);
  void maxValue(final int maxValue);
  void step(final int step);
  void variableResolver(final IVariableResolver variableResolver);

  interface FeatureIDs {
    int POSITION = IPositionElement.FeatureIDs.POSITION;
    int VERTICAL_RELATIVE = IPositionElement.FeatureIDs.VERTICAL_RELATIVE;
    int HORIZONTAL_RELATIVE = IPositionElement.FeatureIDs.HORIZONTAL_RELATIVE;
    int WIDTH = ISizedElement.FeatureIDs.WIDTH;
    int HEIGHT = ISizedElement.FeatureIDs.HEIGHT;
    int FONT = TextWidget.FeatureIDs.FONT;
    int MIN_VALUE = -1326470444;
    int MAX_VALUE = 449726210;
    int STEP = 506996193;
    int VARIABLE_RESOLVER = 1858461239;
  }

  interface Features<T extends Features<T>> extends TextWidget.Features<T> {
    Attribute<Vector2ic, Vector2ic, Listener<Vector2ic>, IPositionElement.Features<?>> POSITION = IPositionElement.Features.POSITION;
    Attribute<EVerticalRelative, EVerticalRelative, Listener<EVerticalRelative>, IPositionElement.Features<?>> VERTICAL_RELATIVE = IPositionElement.Features.VERTICAL_RELATIVE;
    Attribute<EHorizontalRelative, EHorizontalRelative, Listener<EHorizontalRelative>, IPositionElement.Features<?>> HORIZONTAL_RELATIVE = IPositionElement.Features.HORIZONTAL_RELATIVE;
    Attribute<Integer, Integer, IntListener, ISizedElement.Features<?>> WIDTH = ISizedElement.Features.WIDTH;
    Attribute<Integer, Integer, IntListener, ISizedElement.Features<?>> HEIGHT = ISizedElement.Features.HEIGHT;
    Relation<Font, Font, Listener<Font>, TextWidget.Features<?>> FONT = TextWidget.Features.FONT;
    Attribute<Integer, Integer, IntListener, Features<?>> MIN_VALUE = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("minValue").defaultValue("0").id(Slider.FeatureIDs.MIN_VALUE).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    Attribute<Integer, Integer, IntListener, Features<?>> MAX_VALUE = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("maxValue").defaultValue("10").id(Slider.FeatureIDs.MAX_VALUE).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    Attribute<Integer, Integer, IntListener, Features<?>> STEP = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("step").defaultValue("1").id(Slider.FeatureIDs.STEP).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    Relation<IVariableResolver, IVariableResolver, Listener<IVariableResolver>, Features<?>> VARIABLE_RESOLVER = new RelationBuilder<IVariableResolver, IVariableResolver, Listener<IVariableResolver>, Features<?>>().name("variableResolver").mandatory(true).contains(true).id(Slider.FeatureIDs.VARIABLE_RESOLVER).concept(() -> VariableModelDefinition.Groups.I_VARIABLE_RESOLVER).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(POSITION, VERTICAL_RELATIVE, HORIZONTAL_RELATIVE, WIDTH, HEIGHT, FONT, MIN_VALUE, MAX_VALUE, STEP, VARIABLE_RESOLVER);
  }

  interface Builder extends IFeaturedObject.Builder<Slider> {
    Builder position(Vector2ic position);
    Builder verticalRelative(EVerticalRelative verticalRelative);
    Builder horizontalRelative(EHorizontalRelative horizontalRelative);
    Builder width(int width);
    Builder height(int height);
    Builder font(Supplier<Font> font);
    Builder minValue(int minValue);
    Builder maxValue(int maxValue);
    Builder step(int step);
    Builder variableResolver(Supplier<IVariableResolver> variableResolver);
  }
}
