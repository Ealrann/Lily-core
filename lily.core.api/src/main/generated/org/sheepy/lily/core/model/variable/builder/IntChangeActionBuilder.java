package org.sheepy.lily.core.model.variable.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.core.model.variable.AbstractDefinedVariableResolver;
import org.sheepy.lily.core.model.variable.IntChangeAction;
import org.sheepy.lily.core.model.variable.IntChangeAction.Builder;
import org.sheepy.lily.core.model.variable.impl.IntChangeActionImpl;

public final class IntChangeActionBuilder implements Builder {
  private String name;
  private Supplier<AbstractDefinedVariableResolver> variableResolver;
  private int value;

  public IntChangeActionBuilder() {
  }

  @Override
  public IntChangeActionBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public IntChangeActionBuilder variableResolver(
      Supplier<AbstractDefinedVariableResolver> variableResolver) {
    this.variableResolver = variableResolver;
    return this;
  }

  @Override
  public IntChangeActionBuilder value(int value) {
    this.value = value;
    return this;
  }

  @Override
  public IntChangeAction build() {
    final var built = new IntChangeActionImpl(name, variableResolver.get(), value);
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
    private static final FeatureInserter<IntChangeActionBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<IntChangeActionBuilder>(2, Inserters::attributeIndex).add(IntChangeAction.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(IntChangeAction.FeatureIDs.VALUE, (builder, value) -> builder.value((int) value)).build();
    private static final RelationLazyInserter<IntChangeActionBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<IntChangeActionBuilder>(1, Inserters::relationIndex).add(IntChangeAction.FeatureIDs.VARIABLE_RESOLVER, (builder, value) -> builder.variableResolver((Supplier<AbstractDefinedVariableResolver>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case IntChangeAction.FeatureIDs.NAME -> 0;
        case IntChangeAction.FeatureIDs.VALUE -> 1;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case IntChangeAction.FeatureIDs.VARIABLE_RESOLVER -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
