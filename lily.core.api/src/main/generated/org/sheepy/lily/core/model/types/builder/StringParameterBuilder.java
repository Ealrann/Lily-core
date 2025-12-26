package org.sheepy.lily.core.model.types.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.core.model.types.StringParameter;
import org.sheepy.lily.core.model.types.StringParameter.Builder;
import org.sheepy.lily.core.model.types.impl.StringParameterImpl;

public final class StringParameterBuilder implements Builder {
  private String value;

  public StringParameterBuilder() {
  }

  @Override
  public StringParameterBuilder value(String value) {
    this.value = value;
    return this;
  }

  @Override
  public StringParameter build() {
    final var built = new StringParameterImpl();
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
    private static final FeatureInserter<StringParameterBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<StringParameterBuilder>(1, Inserters::attributeIndex).add(StringParameter.FeatureIDs.VALUE, (builder, value) -> builder.value((String) value)).build();
    private static final RelationLazyInserter<StringParameterBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<StringParameterBuilder>(0, Inserters::relationIndex).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case StringParameter.FeatureIDs.VALUE -> 0;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
    }
  }
}
