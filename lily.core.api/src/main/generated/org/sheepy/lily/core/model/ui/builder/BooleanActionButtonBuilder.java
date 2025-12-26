package org.sheepy.lily.core.model.ui.builder;

import java.util.function.Function;
import java.util.function.Supplier;
import org.joml.Vector2ic;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.core.model.action.Action;
import org.sheepy.lily.core.model.types.EHorizontalRelative;
import org.sheepy.lily.core.model.types.EVerticalRelative;
import org.sheepy.lily.core.model.ui.BooleanActionButton;
import org.sheepy.lily.core.model.ui.BooleanActionButton.Builder;
import org.sheepy.lily.core.model.ui.Font;
import org.sheepy.lily.core.model.ui.impl.BooleanActionButtonImpl;

public final class BooleanActionButtonBuilder implements Builder {
  private Vector2ic position = ((Function<String, Vector2ic>) it -> { if(it!=null){final String[] split=it.split(";");if(split.length==2){int x=Integer.parseInt(split[0]);int y=Integer.parseInt(split[1]);return new org.joml.Vector2i(x,y);}}return new org.joml.Vector2i(0,0); }).apply("0;0");
  private EVerticalRelative verticalRelative = EVerticalRelative.TOP;
  private EHorizontalRelative horizontalRelative = EHorizontalRelative.LEFT;
  private int width;
  private int height;
  private Supplier<Font> font = () -> null;
  private String text = "";
  private String textWhenTrue;
  private String textWhenFalse;
  private Supplier<Action> actionWhenTrue = () -> null;
  private Supplier<Action> actionWhenFalse = () -> null;

  public BooleanActionButtonBuilder() {
  }

  @Override
  public BooleanActionButtonBuilder position(Vector2ic position) {
    this.position = position;
    return this;
  }

  @Override
  public BooleanActionButtonBuilder verticalRelative(EVerticalRelative verticalRelative) {
    this.verticalRelative = verticalRelative;
    return this;
  }

  @Override
  public BooleanActionButtonBuilder horizontalRelative(EHorizontalRelative horizontalRelative) {
    this.horizontalRelative = horizontalRelative;
    return this;
  }

  @Override
  public BooleanActionButtonBuilder width(int width) {
    this.width = width;
    return this;
  }

  @Override
  public BooleanActionButtonBuilder height(int height) {
    this.height = height;
    return this;
  }

  @Override
  public BooleanActionButtonBuilder font(Supplier<Font> font) {
    this.font = font;
    return this;
  }

  @Override
  public BooleanActionButtonBuilder text(String text) {
    this.text = text;
    return this;
  }

  @Override
  public BooleanActionButtonBuilder textWhenTrue(String textWhenTrue) {
    this.textWhenTrue = textWhenTrue;
    return this;
  }

  @Override
  public BooleanActionButtonBuilder textWhenFalse(String textWhenFalse) {
    this.textWhenFalse = textWhenFalse;
    return this;
  }

  @Override
  public BooleanActionButtonBuilder actionWhenTrue(Supplier<Action> actionWhenTrue) {
    this.actionWhenTrue = actionWhenTrue;
    return this;
  }

  @Override
  public BooleanActionButtonBuilder actionWhenFalse(Supplier<Action> actionWhenFalse) {
    this.actionWhenFalse = actionWhenFalse;
    return this;
  }

  @Override
  public BooleanActionButton build() {
    final var built = new BooleanActionButtonImpl();
    built.position(position);
    built.verticalRelative(verticalRelative);
    built.horizontalRelative(horizontalRelative);
    built.width(width);
    built.height(height);
    built.font(font.get());
    built.text(text);
    built.textWhenTrue(textWhenTrue);
    built.textWhenFalse(textWhenFalse);
    built.actionWhenTrue(actionWhenTrue.get());
    built.actionWhenFalse(actionWhenFalse.get());
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
    private static final FeatureInserter<BooleanActionButtonBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<BooleanActionButtonBuilder>(8, Inserters::attributeIndex).add(BooleanActionButton.FeatureIDs.POSITION, (builder, value) -> builder.position((Vector2ic) value)).add(BooleanActionButton.FeatureIDs.VERTICAL_RELATIVE, (builder, value) -> builder.verticalRelative((EVerticalRelative) value)).add(BooleanActionButton.FeatureIDs.HORIZONTAL_RELATIVE, (builder, value) -> builder.horizontalRelative((EHorizontalRelative) value)).add(BooleanActionButton.FeatureIDs.WIDTH, (builder, value) -> builder.width((int) value)).add(BooleanActionButton.FeatureIDs.HEIGHT, (builder, value) -> builder.height((int) value)).add(BooleanActionButton.FeatureIDs.TEXT, (builder, value) -> builder.text((String) value)).add(BooleanActionButton.FeatureIDs.TEXT_WHEN_TRUE, (builder, value) -> builder.textWhenTrue((String) value)).add(BooleanActionButton.FeatureIDs.TEXT_WHEN_FALSE, (builder, value) -> builder.textWhenFalse((String) value)).build();
    private static final RelationLazyInserter<BooleanActionButtonBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<BooleanActionButtonBuilder>(3, Inserters::relationIndex).add(BooleanActionButton.FeatureIDs.FONT, (builder, value) -> builder.font((Supplier<Font>) value)).add(BooleanActionButton.FeatureIDs.ACTION_WHEN_TRUE, (builder, value) -> builder.actionWhenTrue((Supplier<Action>) value)).add(BooleanActionButton.FeatureIDs.ACTION_WHEN_FALSE, (builder, value) -> builder.actionWhenFalse((Supplier<Action>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case BooleanActionButton.FeatureIDs.POSITION -> 0;
        case BooleanActionButton.FeatureIDs.VERTICAL_RELATIVE -> 1;
        case BooleanActionButton.FeatureIDs.HORIZONTAL_RELATIVE -> 2;
        case BooleanActionButton.FeatureIDs.WIDTH -> 3;
        case BooleanActionButton.FeatureIDs.HEIGHT -> 4;
        case BooleanActionButton.FeatureIDs.TEXT -> 5;
        case BooleanActionButton.FeatureIDs.TEXT_WHEN_TRUE -> 6;
        case BooleanActionButton.FeatureIDs.TEXT_WHEN_FALSE -> 7;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case BooleanActionButton.FeatureIDs.FONT -> 0;
        case BooleanActionButton.FeatureIDs.ACTION_WHEN_TRUE -> 1;
        case BooleanActionButton.FeatureIDs.ACTION_WHEN_FALSE -> 2;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
