package org.sheepy.lily.core.model.variable.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.core.model.variable.AbstractDefinedVariableResolver;
import org.sheepy.lily.core.model.variable.BooleanChangeAction;
import org.sheepy.lily.core.model.variable.BooleanChangeAction.Builder;
import org.sheepy.lily.core.model.variable.impl.BooleanChangeActionImpl;

public final class BooleanChangeActionBuilder implements Builder {
  private String name;
  private Supplier<AbstractDefinedVariableResolver> variableResolver;

  public BooleanChangeActionBuilder() {
  }

  @Override
  public BooleanChangeActionBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public BooleanChangeActionBuilder variableResolver(
      Supplier<AbstractDefinedVariableResolver> variableResolver) {
    this.variableResolver = variableResolver;
    return this;
  }

  @Override
  public BooleanChangeAction build() {
    final var built = new BooleanChangeActionImpl(name, variableResolver.get());
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
    private static final FeatureInserter<BooleanChangeActionBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<BooleanChangeActionBuilder>(1, Inserters::attributeIndex).add(BooleanChangeAction.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).build();
    private static final RelationLazyInserter<BooleanChangeActionBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<BooleanChangeActionBuilder>(1, Inserters::relationIndex).add(BooleanChangeAction.FeatureIDs.VARIABLE_RESOLVER, (builder, value) -> builder.variableResolver((Supplier<AbstractDefinedVariableResolver>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case BooleanChangeAction.FeatureIDs.NAME -> 0;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case BooleanChangeAction.FeatureIDs.VARIABLE_RESOLVER -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
