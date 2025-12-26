package org.sheepy.lily.core.model.variable.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.core.model.variable.IModelVariable;
import org.sheepy.lily.core.model.variable.SetVariableAction;
import org.sheepy.lily.core.model.variable.SetVariableAction.Builder;
import org.sheepy.lily.core.model.variable.impl.SetVariableActionImpl;

public final class SetVariableActionBuilder implements Builder {
  private String value;
  private Supplier<IModelVariable> variable;

  public SetVariableActionBuilder() {
  }

  @Override
  public SetVariableActionBuilder value(String value) {
    this.value = value;
    return this;
  }

  @Override
  public SetVariableActionBuilder variable(Supplier<IModelVariable> variable) {
    this.variable = variable;
    return this;
  }

  @Override
  public SetVariableAction build() {
    final var built = new SetVariableActionImpl(value, variable.get());
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
    private static final FeatureInserter<SetVariableActionBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<SetVariableActionBuilder>(1, Inserters::attributeIndex).add(SetVariableAction.FeatureIDs.VALUE, (builder, value) -> builder.value((String) value)).build();
    private static final RelationLazyInserter<SetVariableActionBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<SetVariableActionBuilder>(1, Inserters::relationIndex).add(SetVariableAction.FeatureIDs.VARIABLE, (builder, value) -> builder.variable((Supplier<IModelVariable>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case SetVariableAction.FeatureIDs.VALUE -> 0;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case SetVariableAction.FeatureIDs.VARIABLE -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
