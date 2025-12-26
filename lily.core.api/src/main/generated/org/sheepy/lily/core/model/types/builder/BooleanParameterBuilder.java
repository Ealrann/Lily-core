package org.sheepy.lily.core.model.types.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.core.model.types.BooleanParameter;
import org.sheepy.lily.core.model.types.BooleanParameter.Builder;
import org.sheepy.lily.core.model.types.impl.BooleanParameterImpl;

public final class BooleanParameterBuilder implements Builder {
  private boolean value;

  public BooleanParameterBuilder() {
  }

  @Override
  public BooleanParameterBuilder value(boolean value) {
    this.value = value;
    return this;
  }

  @Override
  public BooleanParameter build() {
    final var built = new BooleanParameterImpl();
    built.value(value);
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
    private static final FeatureInserter<BooleanParameterBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<BooleanParameterBuilder>(1, Inserters::attributeIndex).add(BooleanParameter.FeatureIDs.VALUE, (builder, value) -> builder.value((boolean) value)).build();
    private static final RelationLazyInserter<BooleanParameterBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<BooleanParameterBuilder>(0, Inserters::relationIndex).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case BooleanParameter.FeatureIDs.VALUE -> 0;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
    }
  }
}
