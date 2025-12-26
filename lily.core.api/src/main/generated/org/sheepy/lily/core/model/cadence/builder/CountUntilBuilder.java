package org.sheepy.lily.core.model.cadence.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.core.model.cadence.CountUntil;
import org.sheepy.lily.core.model.cadence.CountUntil.Builder;
import org.sheepy.lily.core.model.cadence.impl.CountUntilImpl;

public final class CountUntilBuilder implements Builder {
  private int totalCount = 1;
  private int currentCount = 0;

  public CountUntilBuilder() {
  }

  @Override
  public CountUntilBuilder totalCount(int totalCount) {
    this.totalCount = totalCount;
    return this;
  }

  @Override
  public CountUntilBuilder currentCount(int currentCount) {
    this.currentCount = currentCount;
    return this;
  }

  @Override
  public CountUntil build() {
    final var built = new CountUntilImpl(totalCount, currentCount);
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
    private static final FeatureInserter<CountUntilBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<CountUntilBuilder>(2, Inserters::attributeIndex).add(CountUntil.FeatureIDs.TOTAL_COUNT, (builder, value) -> builder.totalCount((int) value)).add(CountUntil.FeatureIDs.CURRENT_COUNT, (builder, value) -> builder.currentCount((int) value)).build();
    private static final RelationLazyInserter<CountUntilBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<CountUntilBuilder>(0, Inserters::relationIndex).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case CountUntil.FeatureIDs.TOTAL_COUNT -> 0;
        case CountUntil.FeatureIDs.CURRENT_COUNT -> 1;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
    }
  }
}
