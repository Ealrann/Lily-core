package org.sheepy.lily.core.model.variable.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.core.model.variable.DirectVariableResolver;
import org.sheepy.lily.core.model.variable.DirectVariableResolver.Builder;
import org.sheepy.lily.core.model.variable.impl.DirectVariableResolverImpl;

public final class DirectVariableResolverBuilder implements Builder {
  private String variableDefinition;
  private Supplier<LMObject> target = () -> null;

  public DirectVariableResolverBuilder() {
  }

  @Override
  public DirectVariableResolverBuilder variableDefinition(String variableDefinition) {
    this.variableDefinition = variableDefinition;
    return this;
  }

  @Override
  public DirectVariableResolverBuilder target(Supplier<LMObject> target) {
    this.target = target;
    return this;
  }

  @Override
  public DirectVariableResolver build() {
    final var built = new DirectVariableResolverImpl(variableDefinition, target);
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
    private static final FeatureInserter<DirectVariableResolverBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<DirectVariableResolverBuilder>(1, Inserters::attributeIndex).add(DirectVariableResolver.FeatureIDs.VARIABLE_DEFINITION, (builder, value) -> builder.variableDefinition((String) value)).build();
    private static final RelationLazyInserter<DirectVariableResolverBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<DirectVariableResolverBuilder>(1, Inserters::relationIndex).add(DirectVariableResolver.FeatureIDs.TARGET, (builder, value) -> builder.target((Supplier<LMObject>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case DirectVariableResolver.FeatureIDs.VARIABLE_DEFINITION -> 0;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case DirectVariableResolver.FeatureIDs.TARGET -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
