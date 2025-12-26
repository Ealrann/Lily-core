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
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.core.model.presentation.IPositionElement;
import org.sheepy.lily.core.model.presentation.ISizedElement;
import org.sheepy.lily.core.model.types.EHorizontalRelative;
import org.sheepy.lily.core.model.types.EVerticalRelative;
import org.sheepy.lily.core.model.ui.builder.VariableLabelBuilder;
import org.sheepy.lily.core.model.variable.IVariableResolver;
import org.sheepy.lily.core.model.variable.VariableModelDefinition;

public interface VariableLabel extends AbstractLabel {
  static Builder builder() {
    return new VariableLabelBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  IVariableResolver variableResolver();
  boolean showName();
  String format();
  void variableResolver(final IVariableResolver variableResolver);
  void showName(final boolean showName);
  void format(final String format);

  interface FeatureIDs {
    int POSITION = IPositionElement.FeatureIDs.POSITION;
    int VERTICAL_RELATIVE = IPositionElement.FeatureIDs.VERTICAL_RELATIVE;
    int HORIZONTAL_RELATIVE = IPositionElement.FeatureIDs.HORIZONTAL_RELATIVE;
    int WIDTH = ISizedElement.FeatureIDs.WIDTH;
    int HEIGHT = ISizedElement.FeatureIDs.HEIGHT;
    int FONT = TextWidget.FeatureIDs.FONT;
    int TEXT = AbstractLabel.FeatureIDs.TEXT;
    int FONT_SCALE = AbstractLabel.FeatureIDs.FONT_SCALE;
    int VARIABLE_RESOLVER = -66283928;
    int SHOW_NAME = -662435602;
    int FORMAT = 487307069;
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
    Relation<IVariableResolver, IVariableResolver, Listener<IVariableResolver>, Features<?>> VARIABLE_RESOLVER = new RelationBuilder<IVariableResolver, IVariableResolver, Listener<IVariableResolver>, Features<?>>().name("variableResolver").mandatory(true).contains(true).id(VariableLabel.FeatureIDs.VARIABLE_RESOLVER).concept(() -> VariableModelDefinition.Groups.I_VARIABLE_RESOLVER).build();
    Attribute<Boolean, Boolean, BooleanListener, Features<?>> SHOW_NAME = new AttributeBuilder<Boolean, Boolean, BooleanListener, Features<?>>().name("showName").mandatory(true).defaultValue("true").id(VariableLabel.FeatureIDs.SHOW_NAME).datatype(() -> LMCoreModelDefinition.Units.BOOLEAN).build();
    Attribute<String, String, Listener<String>, Features<?>> FORMAT = new AttributeBuilder<String, String, Listener<String>, Features<?>>().name("format").id(VariableLabel.FeatureIDs.FORMAT).datatype(() -> LMCoreModelDefinition.Units.STRING).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(POSITION, VERTICAL_RELATIVE, HORIZONTAL_RELATIVE, WIDTH, HEIGHT, FONT, TEXT, FONT_SCALE, VARIABLE_RESOLVER, SHOW_NAME, FORMAT);
  }

  interface Builder extends IFeaturedObject.Builder<VariableLabel> {
    Builder position(Vector2ic position);
    Builder verticalRelative(EVerticalRelative verticalRelative);
    Builder horizontalRelative(EHorizontalRelative horizontalRelative);
    Builder width(int width);
    Builder height(int height);
    Builder font(Supplier<Font> font);
    Builder text(String text);
    Builder fontScale(float fontScale);
    Builder variableResolver(Supplier<IVariableResolver> variableResolver);
    Builder showName(boolean showName);
    Builder format(String format);
  }
}
