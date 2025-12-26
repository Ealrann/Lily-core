package org.sheepy.lily.core.model.types.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.core.model.types.FloatParameter;
import org.sheepy.lily.core.model.types.FloatParameter.Builder;
import org.sheepy.lily.core.model.types.impl.FloatParameterImpl;

public final class FloatParameterBuilder implements Builder {
  private float value;

  public FloatParameterBuilder() {
  }

  @Override
  public FloatParameterBuilder value(float value) {
    this.value = value;
    return this;
  }

  @Override
  public FloatParameter build() {
    final var built = new FloatParameterImpl();
    built.value(value);
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
    private static final FeatureInserter<FloatParameterBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<FloatParameterBuilder>(1, Inserters::attributeIndex).add(FloatParameter.FeatureIDs.VALUE, (builder, value) -> builder.value((float) value)).build();
    private static final RelationLazyInserter<FloatParameterBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<FloatParameterBuilder>(0, Inserters::relationIndex).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case FloatParameter.FeatureIDs.VALUE -> 0;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
    }
  }
}
