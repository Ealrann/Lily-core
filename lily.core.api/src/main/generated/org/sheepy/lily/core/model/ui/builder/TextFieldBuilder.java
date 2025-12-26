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
import org.sheepy.lily.core.model.ui.TextField;
import org.sheepy.lily.core.model.ui.TextField.Builder;
import org.sheepy.lily.core.model.ui.impl.TextFieldImpl;
import org.sheepy.lily.core.model.variable.IVariableResolver;

public final class TextFieldBuilder implements Builder {
  private Vector2ic position = ((Function<String, Vector2ic>) it -> { if(it!=null){final String[] split=it.split(";");if(split.length==2){int x=Integer.parseInt(split[0]);int y=Integer.parseInt(split[1]);return new org.joml.Vector2i(x,y);}}return new org.joml.Vector2i(0,0); }).apply("0;0");
  private EVerticalRelative verticalRelative = EVerticalRelative.TOP;
  private EHorizontalRelative horizontalRelative = EHorizontalRelative.LEFT;
  private int width;
  private int height;
  private Supplier<Font> font = () -> null;
  private Supplier<IVariableResolver> variableResolver = () -> null;

  public TextFieldBuilder() {
  }

  @Override
  public TextFieldBuilder position(Vector2ic position) {
    this.position = position;
    return this;
  }

  @Override
  public TextFieldBuilder verticalRelative(EVerticalRelative verticalRelative) {
    this.verticalRelative = verticalRelative;
    return this;
  }

  @Override
  public TextFieldBuilder horizontalRelative(EHorizontalRelative horizontalRelative) {
    this.horizontalRelative = horizontalRelative;
    return this;
  }

  @Override
  public TextFieldBuilder width(int width) {
    this.width = width;
    return this;
  }

  @Override
  public TextFieldBuilder height(int height) {
    this.height = height;
    return this;
  }

  @Override
  public TextFieldBuilder font(Supplier<Font> font) {
    this.font = font;
    return this;
  }

  @Override
  public TextFieldBuilder variableResolver(Supplier<IVariableResolver> variableResolver) {
    this.variableResolver = variableResolver;
    return this;
  }

  @Override
  public TextField build() {
    final var built = new TextFieldImpl();
    built.position(position);
    built.verticalRelative(verticalRelative);
    built.horizontalRelative(horizontalRelative);
    built.width(width);
    built.height(height);
    built.font(font.get());
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
    private static final FeatureInserter<TextFieldBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<TextFieldBuilder>(5, Inserters::attributeIndex).add(TextField.FeatureIDs.POSITION, (builder, value) -> builder.position((Vector2ic) value)).add(TextField.FeatureIDs.VERTICAL_RELATIVE, (builder, value) -> builder.verticalRelative((EVerticalRelative) value)).add(TextField.FeatureIDs.HORIZONTAL_RELATIVE, (builder, value) -> builder.horizontalRelative((EHorizontalRelative) value)).add(TextField.FeatureIDs.WIDTH, (builder, value) -> builder.width((int) value)).add(TextField.FeatureIDs.HEIGHT, (builder, value) -> builder.height((int) value)).build();
    private static final RelationLazyInserter<TextFieldBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<TextFieldBuilder>(2, Inserters::relationIndex).add(TextField.FeatureIDs.FONT, (builder, value) -> builder.font((Supplier<Font>) value)).add(TextField.FeatureIDs.VARIABLE_RESOLVER, (builder, value) -> builder.variableResolver((Supplier<IVariableResolver>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case TextField.FeatureIDs.POSITION -> 0;
        case TextField.FeatureIDs.VERTICAL_RELATIVE -> 1;
        case TextField.FeatureIDs.HORIZONTAL_RELATIVE -> 2;
        case TextField.FeatureIDs.WIDTH -> 3;
        case TextField.FeatureIDs.HEIGHT -> 4;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case TextField.FeatureIDs.FONT -> 0;
        case TextField.FeatureIDs.VARIABLE_RESOLVER -> 1;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
