package org.sheepy.lily.core.model.ui;

import java.util.List;
import java.util.function.Supplier;
import org.joml.Vector2ic;
import org.joml.Vector4ic;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.BooleanListener;
import org.logoce.lmf.core.api.notification.listener.IntListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.core.model.presentation.IPositionElement;
import org.sheepy.lily.core.model.presentation.ISizedElement;
import org.sheepy.lily.core.model.resource.IImage;
import org.sheepy.lily.core.model.resource.ResourceModelDefinition;
import org.sheepy.lily.core.model.types.EHorizontalRelative;
import org.sheepy.lily.core.model.types.EVerticalRelative;
import org.sheepy.lily.core.model.types.TypesModelDefinition;
import org.sheepy.lily.core.model.ui.builder.PanelBuilder;

public interface Panel extends IPanel, ISizedElement {
  static Builder builder() {
    return new PanelBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<IControl> controls();
  boolean showTitle();
  boolean minimizable();
  boolean movable();
  boolean minimized();
  IImage backgroundImage();
  Vector4ic backgroundColor();
  Vector4ic borderColor();
  void showTitle(final boolean showTitle);
  void minimizable(final boolean minimizable);
  void movable(final boolean movable);
  void minimized(final boolean minimized);
  void backgroundImage(final IImage backgroundImage);
  void backgroundColor(final Vector4ic backgroundColor);
  void borderColor(final Vector4ic borderColor);

  interface FeatureIDs {
    int WIDTH = ISizedElement.FeatureIDs.WIDTH;
    int HEIGHT = ISizedElement.FeatureIDs.HEIGHT;
    int POSITION = IPositionElement.FeatureIDs.POSITION;
    int VERTICAL_RELATIVE = IPositionElement.FeatureIDs.VERTICAL_RELATIVE;
    int HORIZONTAL_RELATIVE = IPositionElement.FeatureIDs.HORIZONTAL_RELATIVE;
    int NAME = Named.FeatureIDs.NAME;
    int CATCH_INPUTS = IPanel.FeatureIDs.CATCH_INPUTS;
    int REPORTING_HOVER = IPanel.FeatureIDs.REPORTING_HOVER;
    int CONTROLS = -2093202992;
    int SHOW_TITLE = -1983507071;
    int MINIMIZABLE = -1883607257;
    int MOVABLE = 85838868;
    int MINIMIZED = 748877228;
    int BACKGROUND_IMAGE = 1763878003;
    int BACKGROUND_COLOR = 1758407291;
    int BORDER_COLOR = -1837859523;
  }

  interface Features<T extends Features<T>> extends IPanel.Features<T>, ISizedElement.Features<T> {
    Attribute<Integer, Integer, IntListener, ISizedElement.Features<?>> WIDTH = ISizedElement.Features.WIDTH;
    Attribute<Integer, Integer, IntListener, ISizedElement.Features<?>> HEIGHT = ISizedElement.Features.HEIGHT;
    Attribute<Vector2ic, Vector2ic, Listener<Vector2ic>, IPositionElement.Features<?>> POSITION = IPositionElement.Features.POSITION;
    Attribute<EVerticalRelative, EVerticalRelative, Listener<EVerticalRelative>, IPositionElement.Features<?>> VERTICAL_RELATIVE = IPositionElement.Features.VERTICAL_RELATIVE;
    Attribute<EHorizontalRelative, EHorizontalRelative, Listener<EHorizontalRelative>, IPositionElement.Features<?>> HORIZONTAL_RELATIVE = IPositionElement.Features.HORIZONTAL_RELATIVE;
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<Boolean, Boolean, BooleanListener, IPanel.Features<?>> CATCH_INPUTS = IPanel.Features.CATCH_INPUTS;
    Attribute<Boolean, Boolean, BooleanListener, IPanel.Features<?>> REPORTING_HOVER = IPanel.Features.REPORTING_HOVER;
    Relation<IControl, List<IControl>, Listener<List<IControl>>, Features<?>> CONTROLS = new RelationBuilder<IControl, List<IControl>, Listener<List<IControl>>, Features<?>>().name("controls").many(true).contains(true).id(Panel.FeatureIDs.CONTROLS).concept(() -> UIModelDefinition.Groups.I_CONTROL).build();
    Attribute<Boolean, Boolean, BooleanListener, Features<?>> SHOW_TITLE = new AttributeBuilder<Boolean, Boolean, BooleanListener, Features<?>>().name("showTitle").defaultValue("false").id(Panel.FeatureIDs.SHOW_TITLE).datatype(() -> LMCoreModelDefinition.Units.BOOLEAN).build();
    Attribute<Boolean, Boolean, BooleanListener, Features<?>> MINIMIZABLE = new AttributeBuilder<Boolean, Boolean, BooleanListener, Features<?>>().name("minimizable").defaultValue("false").id(Panel.FeatureIDs.MINIMIZABLE).datatype(() -> LMCoreModelDefinition.Units.BOOLEAN).build();
    Attribute<Boolean, Boolean, BooleanListener, Features<?>> MOVABLE = new AttributeBuilder<Boolean, Boolean, BooleanListener, Features<?>>().name("movable").defaultValue("false").id(Panel.FeatureIDs.MOVABLE).datatype(() -> LMCoreModelDefinition.Units.BOOLEAN).build();
    Attribute<Boolean, Boolean, BooleanListener, Features<?>> MINIMIZED = new AttributeBuilder<Boolean, Boolean, BooleanListener, Features<?>>().name("minimized").defaultValue("false").id(Panel.FeatureIDs.MINIMIZED).datatype(() -> LMCoreModelDefinition.Units.BOOLEAN).build();
    Relation<IImage, IImage, Listener<IImage>, Features<?>> BACKGROUND_IMAGE = new RelationBuilder<IImage, IImage, Listener<IImage>, Features<?>>().name("backgroundImage").id(Panel.FeatureIDs.BACKGROUND_IMAGE).concept(() -> ResourceModelDefinition.Groups.I_IMAGE).build();
    Attribute<Vector4ic, Vector4ic, Listener<Vector4ic>, Features<?>> BACKGROUND_COLOR = new AttributeBuilder<Vector4ic, Vector4ic, Listener<Vector4ic>, Features<?>>().name("backgroundColor").mandatory(true).defaultValue("90;90;90;150").id(Panel.FeatureIDs.BACKGROUND_COLOR).datatype(() -> TypesModelDefinition.JavaWrappers.VECTOR4I).build();
    Attribute<Vector4ic, Vector4ic, Listener<Vector4ic>, Features<?>> BORDER_COLOR = new AttributeBuilder<Vector4ic, Vector4ic, Listener<Vector4ic>, Features<?>>().name("borderColor").mandatory(true).defaultValue("60;60;60;150").id(Panel.FeatureIDs.BORDER_COLOR).datatype(() -> TypesModelDefinition.JavaWrappers.VECTOR4I).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(WIDTH, HEIGHT, POSITION, VERTICAL_RELATIVE, HORIZONTAL_RELATIVE, NAME, CATCH_INPUTS, REPORTING_HOVER, CONTROLS, SHOW_TITLE, MINIMIZABLE, MOVABLE, MINIMIZED, BACKGROUND_IMAGE, BACKGROUND_COLOR, BORDER_COLOR);
  }

  interface Builder extends IFeaturedObject.Builder<Panel> {
    Builder width(int width);
    Builder height(int height);
    Builder position(Vector2ic position);
    Builder verticalRelative(EVerticalRelative verticalRelative);
    Builder horizontalRelative(EHorizontalRelative horizontalRelative);
    Builder name(String name);
    Builder catchInputs(boolean catchInputs);
    Builder reportingHover(boolean reportingHover);
    Builder addControl(Supplier<IControl> control);
    Builder showTitle(boolean showTitle);
    Builder minimizable(boolean minimizable);
    Builder movable(boolean movable);
    Builder minimized(boolean minimized);
    Builder backgroundImage(Supplier<IImage> backgroundImage);
    Builder backgroundColor(Vector4ic backgroundColor);
    Builder borderColor(Vector4ic borderColor);
    Builder addControls(List<IControl> controls);
  }
}
