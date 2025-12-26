package org.sheepy.lily.core.model.variable.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.util.BuildUtils;
import org.sheepy.lily.core.model.variable.IModelVariable;
import org.sheepy.lily.core.model.variable.ModelVariablePkg;
import org.sheepy.lily.core.model.variable.ModelVariablePkg.Builder;
import org.sheepy.lily.core.model.variable.impl.ModelVariablePkgImpl;

public final class ModelVariablePkgBuilder implements Builder {
  private final List<Supplier<IModelVariable>> variables = new ArrayList<>();

  public ModelVariablePkgBuilder() {
  }

  @Override
  public ModelVariablePkgBuilder addVariable(Supplier<IModelVariable> variable) {
    this.variables.add(variable);
    return this;
  }

  @Override
  public ModelVariablePkgBuilder addVariables(final List<IModelVariable> variables) {
    variables.forEach(value -> this.variables.add(() -> value));
    return this;
  }

  @Override
  public ModelVariablePkg build() {
    final var builtVariables = BuildUtils.collectSuppliers(variables);
    final var built = new ModelVariablePkgImpl();
    built.variables().addAll(builtVariables);
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
    private static final FeatureInserter<ModelVariablePkgBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<ModelVariablePkgBuilder>(0, Inserters::attributeIndex).build();
    private static final RelationLazyInserter<ModelVariablePkgBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<ModelVariablePkgBuilder>(1, Inserters::relationIndex).add(ModelVariablePkg.FeatureIDs.VARIABLES, (builder, value) -> builder.addVariable((Supplier<IModelVariable>) value)).build();

    private static int attributeIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case ModelVariablePkg.FeatureIDs.VARIABLES -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
