package org.sheepy.lily.core.model.variable.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.core.model.variable.FloatVariable;
import org.sheepy.lily.core.model.variable.FloatVariable.Builder;
import org.sheepy.lily.core.model.variable.impl.FloatVariableImpl;

public final class FloatVariableBuilder implements Builder {
  private String name;
  private float value;

  public FloatVariableBuilder() {
  }

  @Override
  public FloatVariableBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public FloatVariableBuilder value(float value) {
    this.value = value;
    return this;
  }

  @Override
  public FloatVariable build() {
    final var built = new FloatVariableImpl(name, value);
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
    private static final FeatureInserter<FloatVariableBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<FloatVariableBuilder>(2, Inserters::attributeIndex).add(FloatVariable.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(FloatVariable.FeatureIDs.VALUE, (builder, value) -> builder.value((float) value)).build();
    private static final RelationLazyInserter<FloatVariableBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<FloatVariableBuilder>(0, Inserters::relationIndex).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case FloatVariable.FeatureIDs.NAME -> 0;
        case FloatVariable.FeatureIDs.VALUE -> 1;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
    }
  }
}
