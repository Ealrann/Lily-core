package org.sheepy.lily.core.model.variable.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.core.model.variable.DurationVariable;
import org.sheepy.lily.core.model.variable.DurationVariable.Builder;
import org.sheepy.lily.core.model.variable.impl.DurationVariableImpl;

public final class DurationVariableBuilder implements Builder {
  private String name;

  public DurationVariableBuilder() {
  }

  @Override
  public DurationVariableBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public DurationVariable build() {
    final var built = new DurationVariableImpl(name);
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
    private static final FeatureInserter<DurationVariableBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<DurationVariableBuilder>(1, Inserters::attributeIndex).add(DurationVariable.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).build();
    private static final RelationLazyInserter<DurationVariableBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<DurationVariableBuilder>(0, Inserters::relationIndex).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case DurationVariable.FeatureIDs.NAME -> 0;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
    }
  }
}
