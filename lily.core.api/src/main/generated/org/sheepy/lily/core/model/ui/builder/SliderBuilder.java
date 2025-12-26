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
import org.sheepy.lily.core.model.ui.Slider;
import org.sheepy.lily.core.model.ui.Slider.Builder;
import org.sheepy.lily.core.model.ui.impl.SliderImpl;
import org.sheepy.lily.core.model.variable.IVariableResolver;

public final class SliderBuilder implements Builder {
  private Vector2ic position = ((Function<String, Vector2ic>) it -> { if(it!=null){final String[] split=it.split(";");if(split.length==2){int x=Integer.parseInt(split[0]);int y=Integer.parseInt(split[1]);return new org.joml.Vector2i(x,y);}}return new org.joml.Vector2i(0,0); }).apply("0;0");
  private EVerticalRelative verticalRelative = EVerticalRelative.TOP;
  private EHorizontalRelative horizontalRelative = EHorizontalRelative.LEFT;
  private int width;
  private int height;
  private Supplier<Font> font = () -> null;
  private int minValue = 0;
  private int maxValue = 10;
  private int step = 1;
  private Supplier<IVariableResolver> variableResolver;

  public SliderBuilder() {
  }

  @Override
  public SliderBuilder position(Vector2ic position) {
    this.position = position;
    return this;
  }

  @Override
  public SliderBuilder verticalRelative(EVerticalRelative verticalRelative) {
    this.verticalRelative = verticalRelative;
    return this;
  }

  @Override
  public SliderBuilder horizontalRelative(EHorizontalRelative horizontalRelative) {
    this.horizontalRelative = horizontalRelative;
    return this;
  }

  @Override
  public SliderBuilder width(int width) {
    this.width = width;
    return this;
  }

  @Override
  public SliderBuilder height(int height) {
    this.height = height;
    return this;
  }

  @Override
  public SliderBuilder font(Supplier<Font> font) {
    this.font = font;
    return this;
  }

  @Override
  public SliderBuilder minValue(int minValue) {
    this.minValue = minValue;
    return this;
  }

  @Override
  public SliderBuilder maxValue(int maxValue) {
    this.maxValue = maxValue;
    return this;
  }

  @Override
  public SliderBuilder step(int step) {
    this.step = step;
    return this;
  }

  @Override
  public SliderBuilder variableResolver(Supplier<IVariableResolver> variableResolver) {
    this.variableResolver = variableResolver;
    return this;
  }

  @Override
  public Slider build() {
    final var built = new SliderImpl(variableResolver.get());
    built.position(position);
    built.verticalRelative(verticalRelative);
    built.horizontalRelative(horizontalRelative);
    built.width(width);
    built.height(height);
    built.font(font.get());
    built.minValue(minValue);
    built.maxValue(maxValue);
    built.step(step);
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
    private static final FeatureInserter<SliderBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<SliderBuilder>(8, Inserters::attributeIndex).add(Slider.FeatureIDs.POSITION, (builder, value) -> builder.position((Vector2ic) value)).add(Slider.FeatureIDs.VERTICAL_RELATIVE, (builder, value) -> builder.verticalRelative((EVerticalRelative) value)).add(Slider.FeatureIDs.HORIZONTAL_RELATIVE, (builder, value) -> builder.horizontalRelative((EHorizontalRelative) value)).add(Slider.FeatureIDs.WIDTH, (builder, value) -> builder.width((int) value)).add(Slider.FeatureIDs.HEIGHT, (builder, value) -> builder.height((int) value)).add(Slider.FeatureIDs.MIN_VALUE, (builder, value) -> builder.minValue((int) value)).add(Slider.FeatureIDs.MAX_VALUE, (builder, value) -> builder.maxValue((int) value)).add(Slider.FeatureIDs.STEP, (builder, value) -> builder.step((int) value)).build();
    private static final RelationLazyInserter<SliderBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<SliderBuilder>(2, Inserters::relationIndex).add(Slider.FeatureIDs.FONT, (builder, value) -> builder.font((Supplier<Font>) value)).add(Slider.FeatureIDs.VARIABLE_RESOLVER, (builder, value) -> builder.variableResolver((Supplier<IVariableResolver>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case Slider.FeatureIDs.POSITION -> 0;
        case Slider.FeatureIDs.VERTICAL_RELATIVE -> 1;
        case Slider.FeatureIDs.HORIZONTAL_RELATIVE -> 2;
        case Slider.FeatureIDs.WIDTH -> 3;
        case Slider.FeatureIDs.HEIGHT -> 4;
        case Slider.FeatureIDs.MIN_VALUE -> 5;
        case Slider.FeatureIDs.MAX_VALUE -> 6;
        case Slider.FeatureIDs.STEP -> 7;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case Slider.FeatureIDs.FONT -> 0;
        case Slider.FeatureIDs.VARIABLE_RESOLVER -> 1;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
