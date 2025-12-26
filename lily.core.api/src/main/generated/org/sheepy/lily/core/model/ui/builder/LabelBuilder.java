package org.sheepy.lily.core.model.ui.builder;

import java.util.function.Function;
import java.util.function.Supplier;
import org.joml.Vector2ic;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.core.model.types.EHorizontalRelative;
import org.sheepy.lily.core.model.types.EVerticalRelative;
import org.sheepy.lily.core.model.ui.Font;
import org.sheepy.lily.core.model.ui.Label;
import org.sheepy.lily.core.model.ui.Label.Builder;
import org.sheepy.lily.core.model.ui.impl.LabelImpl;

public final class LabelBuilder implements Builder {
  private Vector2ic position = ((Function<String, Vector2ic>) it -> { if(it!=null){final String[] split=it.split(";");if(split.length==2){int x=Integer.parseInt(split[0]);int y=Integer.parseInt(split[1]);return new org.joml.Vector2i(x,y);}}return new org.joml.Vector2i(0,0); }).apply("0;0");
  private EVerticalRelative verticalRelative = EVerticalRelative.TOP;
  private EHorizontalRelative horizontalRelative = EHorizontalRelative.LEFT;
  private int width;
  private int height;
  private Supplier<Font> font = () -> null;
  private String text = "";
  private float fontScale = 1f;
  private boolean wrap = false;
  private boolean narrator = false;
  private int narrationSpeed = 100;

  public LabelBuilder() {
  }

  @Override
  public LabelBuilder position(Vector2ic position) {
    this.position = position;
    return this;
  }

  @Override
  public LabelBuilder verticalRelative(EVerticalRelative verticalRelative) {
    this.verticalRelative = verticalRelative;
    return this;
  }

  @Override
  public LabelBuilder horizontalRelative(EHorizontalRelative horizontalRelative) {
    this.horizontalRelative = horizontalRelative;
    return this;
  }

  @Override
  public LabelBuilder width(int width) {
    this.width = width;
    return this;
  }

  @Override
  public LabelBuilder height(int height) {
    this.height = height;
    return this;
  }

  @Override
  public LabelBuilder font(Supplier<Font> font) {
    this.font = font;
    return this;
  }

  @Override
  public LabelBuilder text(String text) {
    this.text = text;
    return this;
  }

  @Override
  public LabelBuilder fontScale(float fontScale) {
    this.fontScale = fontScale;
    return this;
  }

  @Override
  public LabelBuilder wrap(boolean wrap) {
    this.wrap = wrap;
    return this;
  }

  @Override
  public LabelBuilder narrator(boolean narrator) {
    this.narrator = narrator;
    return this;
  }

  @Override
  public LabelBuilder narrationSpeed(int narrationSpeed) {
    this.narrationSpeed = narrationSpeed;
    return this;
  }

  @Override
  public Label build() {
    final var built = new LabelImpl(wrap, narrator);
    built.position(position);
    built.verticalRelative(verticalRelative);
    built.horizontalRelative(horizontalRelative);
    built.width(width);
    built.height(height);
    built.font(font.get());
    built.text(text);
    built.fontScale(fontScale);
    built.narrationSpeed(narrationSpeed);
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
    private static final FeatureInserter<LabelBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<LabelBuilder>(10, Inserters::attributeIndex).add(Label.FeatureIDs.POSITION, (builder, value) -> builder.position((Vector2ic) value)).add(Label.FeatureIDs.VERTICAL_RELATIVE, (builder, value) -> builder.verticalRelative((EVerticalRelative) value)).add(Label.FeatureIDs.HORIZONTAL_RELATIVE, (builder, value) -> builder.horizontalRelative((EHorizontalRelative) value)).add(Label.FeatureIDs.WIDTH, (builder, value) -> builder.width((int) value)).add(Label.FeatureIDs.HEIGHT, (builder, value) -> builder.height((int) value)).add(Label.FeatureIDs.TEXT, (builder, value) -> builder.text((String) value)).add(Label.FeatureIDs.FONT_SCALE, (builder, value) -> builder.fontScale((float) value)).add(Label.FeatureIDs.WRAP, (builder, value) -> builder.wrap((boolean) value)).add(Label.FeatureIDs.NARRATOR, (builder, value) -> builder.narrator((boolean) value)).add(Label.FeatureIDs.NARRATION_SPEED, (builder, value) -> builder.narrationSpeed((int) value)).build();
    private static final RelationLazyInserter<LabelBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<LabelBuilder>(1, Inserters::relationIndex).add(Label.FeatureIDs.FONT, (builder, value) -> builder.font((Supplier<Font>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case Label.FeatureIDs.POSITION -> 0;
        case Label.FeatureIDs.VERTICAL_RELATIVE -> 1;
        case Label.FeatureIDs.HORIZONTAL_RELATIVE -> 2;
        case Label.FeatureIDs.WIDTH -> 3;
        case Label.FeatureIDs.HEIGHT -> 4;
        case Label.FeatureIDs.TEXT -> 5;
        case Label.FeatureIDs.FONT_SCALE -> 6;
        case Label.FeatureIDs.WRAP -> 7;
        case Label.FeatureIDs.NARRATOR -> 8;
        case Label.FeatureIDs.NARRATION_SPEED -> 9;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case Label.FeatureIDs.FONT -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
