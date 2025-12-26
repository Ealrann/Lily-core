package org.sheepy.lily.core.model.cadence.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.core.model.cadence.GenericCadence;
import org.sheepy.lily.core.model.cadence.GenericCadence.Builder;
import org.sheepy.lily.core.model.cadence.impl.GenericCadenceImpl;

public final class GenericCadenceBuilder implements Builder {
  private String name;

  public GenericCadenceBuilder() {
  }

  @Override
  public GenericCadenceBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public GenericCadence build() {
    final var built = new GenericCadenceImpl(name);
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
    private static final FeatureInserter<GenericCadenceBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<GenericCadenceBuilder>(1, Inserters::attributeIndex).add(GenericCadence.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).build();
    private static final RelationLazyInserter<GenericCadenceBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<GenericCadenceBuilder>(0, Inserters::relationIndex).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case GenericCadence.FeatureIDs.NAME -> 0;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
    }
  }
}
