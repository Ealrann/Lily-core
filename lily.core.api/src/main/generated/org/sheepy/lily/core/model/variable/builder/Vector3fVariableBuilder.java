package org.sheepy.lily.core.model.variable.builder;

import java.util.function.Supplier;
import org.joml.Vector3fc;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.core.model.variable.Vector3fVariable;
import org.sheepy.lily.core.model.variable.Vector3fVariable.Builder;
import org.sheepy.lily.core.model.variable.impl.Vector3fVariableImpl;

public final class Vector3fVariableBuilder implements Builder {
  private String name;
  private Vector3fc vector;

  public Vector3fVariableBuilder() {
  }

  @Override
  public Vector3fVariableBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public Vector3fVariableBuilder vector(Vector3fc vector) {
    this.vector = vector;
    return this;
  }

  @Override
  public Vector3fVariable build() {
    final var built = new Vector3fVariableImpl(name);
    built.vector(vector);
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
    private static final FeatureInserter<Vector3fVariableBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<Vector3fVariableBuilder>(2, Inserters::attributeIndex).add(Vector3fVariable.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(Vector3fVariable.FeatureIDs.VECTOR, (builder, value) -> builder.vector((Vector3fc) value)).build();
    private static final RelationLazyInserter<Vector3fVariableBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<Vector3fVariableBuilder>(0, Inserters::relationIndex).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case Vector3fVariable.FeatureIDs.NAME -> 0;
        case Vector3fVariable.FeatureIDs.VECTOR -> 1;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
    }
  }
}
