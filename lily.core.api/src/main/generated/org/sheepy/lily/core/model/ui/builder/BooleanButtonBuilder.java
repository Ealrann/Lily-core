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
import org.sheepy.lily.core.model.ui.BooleanButton;
import org.sheepy.lily.core.model.ui.BooleanButton.Builder;
import org.sheepy.lily.core.model.ui.Font;
import org.sheepy.lily.core.model.ui.impl.BooleanButtonImpl;
import org.sheepy.lily.core.model.variable.IVariableResolver;

public final class BooleanButtonBuilder implements Builder {
  private Vector2ic position = ((Function<String, Vector2ic>) it -> { if(it!=null){final String[] split=it.split(";");if(split.length==2){int x=Integer.parseInt(split[0]);int y=Integer.parseInt(split[1]);return new org.joml.Vector2i(x,y);}}return new org.joml.Vector2i(0,0); }).apply("0;0");
  private EVerticalRelative verticalRelative = EVerticalRelative.TOP;
  private EHorizontalRelative horizontalRelative = EHorizontalRelative.LEFT;
  private int width;
  private int height;
  private Supplier<Font> font = () -> null;
  private String text = "";
  private String textWhenTrue;
  private String textWhenFalse;
  private Supplier<IVariableResolver> variableResolver = () -> null;

  public BooleanButtonBuilder() {
  }

  @Override
  public BooleanButtonBuilder position(Vector2ic position) {
    this.position = position;
    return this;
  }

  @Override
  public BooleanButtonBuilder verticalRelative(EVerticalRelative verticalRelative) {
    this.verticalRelative = verticalRelative;
    return this;
  }

  @Override
  public BooleanButtonBuilder horizontalRelative(EHorizontalRelative horizontalRelative) {
    this.horizontalRelative = horizontalRelative;
    return this;
  }

  @Override
  public BooleanButtonBuilder width(int width) {
    this.width = width;
    return this;
  }

  @Override
  public BooleanButtonBuilder height(int height) {
    this.height = height;
    return this;
  }

  @Override
  public BooleanButtonBuilder font(Supplier<Font> font) {
    this.font = font;
    return this;
  }

  @Override
  public BooleanButtonBuilder text(String text) {
    this.text = text;
    return this;
  }

  @Override
  public BooleanButtonBuilder textWhenTrue(String textWhenTrue) {
    this.textWhenTrue = textWhenTrue;
    return this;
  }

  @Override
  public BooleanButtonBuilder textWhenFalse(String textWhenFalse) {
    this.textWhenFalse = textWhenFalse;
    return this;
  }

  @Override
  public BooleanButtonBuilder variableResolver(Supplier<IVariableResolver> variableResolver) {
    this.variableResolver = variableResolver;
    return this;
  }

  @Override
  public BooleanButton build() {
    final var built = new BooleanButtonImpl();
    built.position(position);
    built.verticalRelative(verticalRelative);
    built.horizontalRelative(horizontalRelative);
    built.width(width);
    built.height(height);
    built.font(font.get());
    built.text(text);
    built.textWhenTrue(textWhenTrue);
    built.textWhenFalse(textWhenFalse);
    built.variableResolver(variableResolver.get());
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
    private static final FeatureInserter<BooleanButtonBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<BooleanButtonBuilder>(8, Inserters::attributeIndex).add(BooleanButton.FeatureIDs.POSITION, (builder, value) -> builder.position((Vector2ic) value)).add(BooleanButton.FeatureIDs.VERTICAL_RELATIVE, (builder, value) -> builder.verticalRelative((EVerticalRelative) value)).add(BooleanButton.FeatureIDs.HORIZONTAL_RELATIVE, (builder, value) -> builder.horizontalRelative((EHorizontalRelative) value)).add(BooleanButton.FeatureIDs.WIDTH, (builder, value) -> builder.width((int) value)).add(BooleanButton.FeatureIDs.HEIGHT, (builder, value) -> builder.height((int) value)).add(BooleanButton.FeatureIDs.TEXT, (builder, value) -> builder.text((String) value)).add(BooleanButton.FeatureIDs.TEXT_WHEN_TRUE, (builder, value) -> builder.textWhenTrue((String) value)).add(BooleanButton.FeatureIDs.TEXT_WHEN_FALSE, (builder, value) -> builder.textWhenFalse((String) value)).build();
    private static final RelationLazyInserter<BooleanButtonBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<BooleanButtonBuilder>(2, Inserters::relationIndex).add(BooleanButton.FeatureIDs.FONT, (builder, value) -> builder.font((Supplier<Font>) value)).add(BooleanButton.FeatureIDs.VARIABLE_RESOLVER, (builder, value) -> builder.variableResolver((Supplier<IVariableResolver>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case BooleanButton.FeatureIDs.POSITION -> 0;
        case BooleanButton.FeatureIDs.VERTICAL_RELATIVE -> 1;
        case BooleanButton.FeatureIDs.HORIZONTAL_RELATIVE -> 2;
        case BooleanButton.FeatureIDs.WIDTH -> 3;
        case BooleanButton.FeatureIDs.HEIGHT -> 4;
        case BooleanButton.FeatureIDs.TEXT -> 5;
        case BooleanButton.FeatureIDs.TEXT_WHEN_TRUE -> 6;
        case BooleanButton.FeatureIDs.TEXT_WHEN_FALSE -> 7;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case BooleanButton.FeatureIDs.FONT -> 0;
        case BooleanButton.FeatureIDs.VARIABLE_RESOLVER -> 1;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
