package org.sheepy.lily.core.model.ui.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import org.joml.Vector2ic;
import org.joml.Vector4ic;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.util.BuildUtils;
import org.sheepy.lily.core.model.resource.IImage;
import org.sheepy.lily.core.model.types.EHorizontalRelative;
import org.sheepy.lily.core.model.types.EVerticalRelative;
import org.sheepy.lily.core.model.ui.IControl;
import org.sheepy.lily.core.model.ui.Panel;
import org.sheepy.lily.core.model.ui.Panel.Builder;
import org.sheepy.lily.core.model.ui.impl.PanelImpl;

public final class PanelBuilder implements Builder {
  private int width;
  private int height;
  private Vector2ic position = ((Function<String, Vector2ic>) it -> { if(it!=null){final String[] split=it.split(";");if(split.length==2){int x=Integer.parseInt(split[0]);int y=Integer.parseInt(split[1]);return new org.joml.Vector2i(x,y);}}return new org.joml.Vector2i(0,0); }).apply("0;0");
  private EVerticalRelative verticalRelative = EVerticalRelative.TOP;
  private EHorizontalRelative horizontalRelative = EHorizontalRelative.LEFT;
  private String name;
  private boolean catchInputs = true;
  private boolean reportingHover = true;
  private final List<Supplier<IControl>> controls = new ArrayList<>();
  private boolean showTitle = false;
  private boolean minimizable = false;
  private boolean movable = false;
  private boolean minimized = false;
  private Supplier<IImage> backgroundImage = () -> null;
  private Vector4ic backgroundColor = ((Function<String, Vector4ic>) it -> { if(it!=null){final String[] split=it.split(";");if(split.length==4){int x=Integer.parseInt(split[0]);int y=Integer.parseInt(split[1]);int z=Integer.parseInt(split[2]);int w=Integer.parseInt(split[3]);return new org.joml.Vector4i(x,y,z,w);}}return new org.joml.Vector4i(0,0,0,0); }).apply("90;90;90;150");
  private Vector4ic borderColor = ((Function<String, Vector4ic>) it -> { if(it!=null){final String[] split=it.split(";");if(split.length==4){int x=Integer.parseInt(split[0]);int y=Integer.parseInt(split[1]);int z=Integer.parseInt(split[2]);int w=Integer.parseInt(split[3]);return new org.joml.Vector4i(x,y,z,w);}}return new org.joml.Vector4i(0,0,0,0); }).apply("60;60;60;150");

  public PanelBuilder() {
  }

  @Override
  public PanelBuilder width(int width) {
    this.width = width;
    return this;
  }

  @Override
  public PanelBuilder height(int height) {
    this.height = height;
    return this;
  }

  @Override
  public PanelBuilder position(Vector2ic position) {
    this.position = position;
    return this;
  }

  @Override
  public PanelBuilder verticalRelative(EVerticalRelative verticalRelative) {
    this.verticalRelative = verticalRelative;
    return this;
  }

  @Override
  public PanelBuilder horizontalRelative(EHorizontalRelative horizontalRelative) {
    this.horizontalRelative = horizontalRelative;
    return this;
  }

  @Override
  public PanelBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public PanelBuilder catchInputs(boolean catchInputs) {
    this.catchInputs = catchInputs;
    return this;
  }

  @Override
  public PanelBuilder reportingHover(boolean reportingHover) {
    this.reportingHover = reportingHover;
    return this;
  }

  @Override
  public PanelBuilder addControl(Supplier<IControl> control) {
    this.controls.add(control);
    return this;
  }

  @Override
  public PanelBuilder addControls(final List<IControl> controls) {
    controls.forEach(value -> this.controls.add(() -> value));
    return this;
  }

  @Override
  public PanelBuilder showTitle(boolean showTitle) {
    this.showTitle = showTitle;
    return this;
  }

  @Override
  public PanelBuilder minimizable(boolean minimizable) {
    this.minimizable = minimizable;
    return this;
  }

  @Override
  public PanelBuilder movable(boolean movable) {
    this.movable = movable;
    return this;
  }

  @Override
  public PanelBuilder minimized(boolean minimized) {
    this.minimized = minimized;
    return this;
  }

  @Override
  public PanelBuilder backgroundImage(Supplier<IImage> backgroundImage) {
    this.backgroundImage = backgroundImage;
    return this;
  }

  @Override
  public PanelBuilder backgroundColor(Vector4ic backgroundColor) {
    this.backgroundColor = backgroundColor;
    return this;
  }

  @Override
  public PanelBuilder borderColor(Vector4ic borderColor) {
    this.borderColor = borderColor;
    return this;
  }

  @Override
  public Panel build() {
    final var builtControls = BuildUtils.collectSuppliers(controls);
    final var built = new PanelImpl(name, catchInputs, reportingHover, backgroundColor, borderColor);
    built.width(width);
    built.height(height);
    built.position(position);
    built.verticalRelative(verticalRelative);
    built.horizontalRelative(horizontalRelative);
    built.controls().addAll(builtControls);
    built.showTitle(showTitle);
    built.minimizable(minimizable);
    built.movable(movable);
    built.minimized(minimized);
    built.backgroundImage(backgroundImage.get());
    return built;
  }

  @Override
  public <AttributeType> void push(final Attribute<?, ?, ?, ?> attribute,
      final AttributeType value) {
    Inserters.ATTRIBUTE_INSERTER.push(this, attribute.id(), value);
  }

  @Override
  public <RelationType extends LMObject> void push(final Relation<RelationType, ?, ?, ?> relation,
      final Supplier<RelationType> supplier) {
    Inserters.RELATION_INSERTER.push(this, relation.id(), supplier);
  }

  private static final class Inserters {
    private static final FeatureInserter<PanelBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<PanelBuilder>(14, Inserters::attributeIndex).add(Panel.FeatureIDs.WIDTH, (builder, value) -> builder.width((int) value)).add(Panel.FeatureIDs.HEIGHT, (builder, value) -> builder.height((int) value)).add(Panel.FeatureIDs.POSITION, (builder, value) -> builder.position((Vector2ic) value)).add(Panel.FeatureIDs.VERTICAL_RELATIVE, (builder, value) -> builder.verticalRelative((EVerticalRelative) value)).add(Panel.FeatureIDs.HORIZONTAL_RELATIVE, (builder, value) -> builder.horizontalRelative((EHorizontalRelative) value)).add(Panel.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(Panel.FeatureIDs.CATCH_INPUTS, (builder, value) -> builder.catchInputs((boolean) value)).add(Panel.FeatureIDs.REPORTING_HOVER, (builder, value) -> builder.reportingHover((boolean) value)).add(Panel.FeatureIDs.SHOW_TITLE, (builder, value) -> builder.showTitle((boolean) value)).add(Panel.FeatureIDs.MINIMIZABLE, (builder, value) -> builder.minimizable((boolean) value)).add(Panel.FeatureIDs.MOVABLE, (builder, value) -> builder.movable((boolean) value)).add(Panel.FeatureIDs.MINIMIZED, (builder, value) -> builder.minimized((boolean) value)).add(Panel.FeatureIDs.BACKGROUND_COLOR, (builder, value) -> builder.backgroundColor((Vector4ic) value)).add(Panel.FeatureIDs.BORDER_COLOR, (builder, value) -> builder.borderColor((Vector4ic) value)).build();
    private static final RelationLazyInserter<PanelBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<PanelBuilder>(2, Inserters::relationIndex).add(Panel.FeatureIDs.CONTROLS, (builder, value) -> builder.addControl((Supplier<IControl>) value)).add(Panel.FeatureIDs.BACKGROUND_IMAGE, (builder, value) -> builder.backgroundImage((Supplier<IImage>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case Panel.FeatureIDs.WIDTH -> 0;
        case Panel.FeatureIDs.HEIGHT -> 1;
        case Panel.FeatureIDs.POSITION -> 2;
        case Panel.FeatureIDs.VERTICAL_RELATIVE -> 3;
        case Panel.FeatureIDs.HORIZONTAL_RELATIVE -> 4;
        case Panel.FeatureIDs.NAME -> 5;
        case Panel.FeatureIDs.CATCH_INPUTS -> 6;
        case Panel.FeatureIDs.REPORTING_HOVER -> 7;
        case Panel.FeatureIDs.SHOW_TITLE -> 8;
        case Panel.FeatureIDs.MINIMIZABLE -> 9;
        case Panel.FeatureIDs.MOVABLE -> 10;
        case Panel.FeatureIDs.MINIMIZED -> 11;
        case Panel.FeatureIDs.BACKGROUND_COLOR -> 12;
        case Panel.FeatureIDs.BORDER_COLOR -> 13;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case Panel.FeatureIDs.CONTROLS -> 0;
        case Panel.FeatureIDs.BACKGROUND_IMAGE -> 1;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
