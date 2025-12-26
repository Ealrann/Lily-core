package org.sheepy.lily.core.model.variable.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.core.model.variable.ChainResolver;
import org.sheepy.lily.core.model.variable.ChainResolver.Builder;
import org.sheepy.lily.core.model.variable.impl.ChainResolverImpl;

public final class ChainResolverBuilder implements Builder {
  private String variableDefinition;

  public ChainResolverBuilder() {
  }

  @Override
  public ChainResolverBuilder variableDefinition(String variableDefinition) {
    this.variableDefinition = variableDefinition;
    return this;
  }

  @Override
  public ChainResolver build() {
    final var built = new ChainResolverImpl(variableDefinition);
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
    private static final FeatureInserter<ChainResolverBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<ChainResolverBuilder>(1, Inserters::attributeIndex).add(ChainResolver.FeatureIDs.VARIABLE_DEFINITION, (builder, value) -> builder.variableDefinition((String) value)).build();
    private static final RelationLazyInserter<ChainResolverBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<ChainResolverBuilder>(0, Inserters::relationIndex).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case ChainResolver.FeatureIDs.VARIABLE_DEFINITION -> 0;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
    }
  }
}
