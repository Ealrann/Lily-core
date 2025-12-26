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
import org.sheepy.lily.core.model.ui.VariableLabel;
import org.sheepy.lily.core.model.ui.VariableLabel.Builder;
import org.sheepy.lily.core.model.ui.impl.VariableLabelImpl;
import org.sheepy.lily.core.model.variable.IVariableResolver;

public final class VariableLabelBuilder implements Builder {
  private Vector2ic position = ((Function<String, Vector2ic>) it -> { if(it!=null){final String[] split=it.split(";");if(split.length==2){int x=Integer.parseInt(split[0]);int y=Integer.parseInt(split[1]);return new org.joml.Vector2i(x,y);}}return new org.joml.Vector2i(0,0); }).apply("0;0");
  private EVerticalRelative verticalRelative = EVerticalRelative.TOP;
  private EHorizontalRelative horizontalRelative = EHorizontalRelative.LEFT;
  private int width;
  private int height;
  private Supplier<Font> font = () -> null;
  private String text = "";
  private float fontScale = 1f;
  private Supplier<IVariableResolver> variableResolver;
  private boolean showName = true;
  private String format;

  public VariableLabelBuilder() {
  }

  @Override
  public VariableLabelBuilder position(Vector2ic position) {
    this.position = position;
    return this;
  }

  @Override
  public VariableLabelBuilder verticalRelative(EVerticalRelative verticalRelative) {
    this.verticalRelative = verticalRelative;
    return this;
  }

  @Override
  public VariableLabelBuilder horizontalRelative(EHorizontalRelative horizontalRelative) {
    this.horizontalRelative = horizontalRelative;
    return this;
  }

  @Override
  public VariableLabelBuilder width(int width) {
    this.width = width;
    return this;
  }

  @Override
  public VariableLabelBuilder height(int height) {
    this.height = height;
    return this;
  }

  @Override
  public VariableLabelBuilder font(Supplier<Font> font) {
    this.font = font;
    return this;
  }

  @Override
  public VariableLabelBuilder text(String text) {
    this.text = text;
    return this;
  }

  @Override
  public VariableLabelBuilder fontScale(float fontScale) {
    this.fontScale = fontScale;
    return this;
  }

  @Override
  public VariableLabelBuilder variableResolver(Supplier<IVariableResolver> variableResolver) {
    this.variableResolver = variableResolver;
    return this;
  }

  @Override
  public VariableLabelBuilder showName(boolean showName) {
    this.showName = showName;
    return this;
  }

  @Override
  public VariableLabelBuilder format(String format) {
    this.format = format;
    return this;
  }

  @Override
  public VariableLabel build() {
    final var built = new VariableLabelImpl(variableResolver.get(), showName);
    built.position(position);
    built.verticalRelative(verticalRelative);
    built.horizontalRelative(horizontalRelative);
    built.width(width);
    built.height(height);
    built.font(font.get());
    built.text(text);
    built.fontScale(fontScale);
    built.format(format);
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
    private static final FeatureInserter<VariableLabelBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<VariableLabelBuilder>(9, Inserters::attributeIndex).add(VariableLabel.FeatureIDs.POSITION, (builder, value) -> builder.position((Vector2ic) value)).add(VariableLabel.FeatureIDs.VERTICAL_RELATIVE, (builder, value) -> builder.verticalRelative((EVerticalRelative) value)).add(VariableLabel.FeatureIDs.HORIZONTAL_RELATIVE, (builder, value) -> builder.horizontalRelative((EHorizontalRelative) value)).add(VariableLabel.FeatureIDs.WIDTH, (builder, value) -> builder.width((int) value)).add(VariableLabel.FeatureIDs.HEIGHT, (builder, value) -> builder.height((int) value)).add(VariableLabel.FeatureIDs.TEXT, (builder, value) -> builder.text((String) value)).add(VariableLabel.FeatureIDs.FONT_SCALE, (builder, value) -> builder.fontScale((float) value)).add(VariableLabel.FeatureIDs.SHOW_NAME, (builder, value) -> builder.showName((boolean) value)).add(VariableLabel.FeatureIDs.FORMAT, (builder, value) -> builder.format((String) value)).build();
    private static final RelationLazyInserter<VariableLabelBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<VariableLabelBuilder>(2, Inserters::relationIndex).add(VariableLabel.FeatureIDs.FONT, (builder, value) -> builder.font((Supplier<Font>) value)).add(VariableLabel.FeatureIDs.VARIABLE_RESOLVER, (builder, value) -> builder.variableResolver((Supplier<IVariableResolver>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case VariableLabel.FeatureIDs.POSITION -> 0;
        case VariableLabel.FeatureIDs.VERTICAL_RELATIVE -> 1;
        case VariableLabel.FeatureIDs.HORIZONTAL_RELATIVE -> 2;
        case VariableLabel.FeatureIDs.WIDTH -> 3;
        case VariableLabel.FeatureIDs.HEIGHT -> 4;
        case VariableLabel.FeatureIDs.TEXT -> 5;
        case VariableLabel.FeatureIDs.FONT_SCALE -> 6;
        case VariableLabel.FeatureIDs.SHOW_NAME -> 7;
        case VariableLabel.FeatureIDs.FORMAT -> 8;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case VariableLabel.FeatureIDs.FONT -> 0;
        case VariableLabel.FeatureIDs.VARIABLE_RESOLVER -> 1;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
