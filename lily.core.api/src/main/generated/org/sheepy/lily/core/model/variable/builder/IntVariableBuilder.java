package org.sheepy.lily.core.model.variable.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.core.model.variable.IntVariable;
import org.sheepy.lily.core.model.variable.IntVariable.Builder;
import org.sheepy.lily.core.model.variable.impl.IntVariableImpl;

public final class IntVariableBuilder implements Builder {
  private String name;
  private int value;

  public IntVariableBuilder() {
  }

  @Override
  public IntVariableBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public IntVariableBuilder value(int value) {
    this.value = value;
    return this;
  }

  @Override
  public IntVariable build() {
    final var built = new IntVariableImpl(name, value);
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
    private static final FeatureInserter<IntVariableBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<IntVariableBuilder>(2, Inserters::attributeIndex).add(IntVariable.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(IntVariable.FeatureIDs.VALUE, (builder, value) -> builder.value((int) value)).build();
    private static final RelationLazyInserter<IntVariableBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<IntVariableBuilder>(0, Inserters::relationIndex).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case IntVariable.FeatureIDs.NAME -> 0;
        case IntVariable.FeatureIDs.VALUE -> 1;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
    }
  }
}
