package org.sheepy.lily.core.allocation.test.testallocation.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.core.allocation.test.testallocation.Box;
import org.sheepy.lily.core.allocation.test.testallocation.Box.Builder;
import org.sheepy.lily.core.allocation.test.testallocation.impl.BoxImpl;

public final class BoxBuilder implements Builder {
  private int currentAllocationCount = 0;
  private int totalAllocationCount = 0;
  private int dependencyUpdateCount = 0;
  private boolean activated = true;

  public BoxBuilder() {
  }

  @Override
  public BoxBuilder currentAllocationCount(int currentAllocationCount) {
    this.currentAllocationCount = currentAllocationCount;
    return this;
  }

  @Override
  public BoxBuilder totalAllocationCount(int totalAllocationCount) {
    this.totalAllocationCount = totalAllocationCount;
    return this;
  }

  @Override
  public BoxBuilder dependencyUpdateCount(int dependencyUpdateCount) {
    this.dependencyUpdateCount = dependencyUpdateCount;
    return this;
  }

  @Override
  public BoxBuilder activated(boolean activated) {
    this.activated = activated;
    return this;
  }

  @Override
  public Box build() {
    final var built = new BoxImpl();
    built.currentAllocationCount(currentAllocationCount);
    built.totalAllocationCount(totalAllocationCount);
    built.dependencyUpdateCount(dependencyUpdateCount);
    built.activated(activated);
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
    private static final FeatureInserter<BoxBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<BoxBuilder>(4, Inserters::attributeIndex).add(Box.FeatureIDs.CURRENT_ALLOCATION_COUNT, (builder, value) -> builder.currentAllocationCount((int) value)).add(Box.FeatureIDs.TOTAL_ALLOCATION_COUNT, (builder, value) -> builder.totalAllocationCount((int) value)).add(Box.FeatureIDs.DEPENDENCY_UPDATE_COUNT, (builder, value) -> builder.dependencyUpdateCount((int) value)).add(Box.FeatureIDs.ACTIVATED, (builder, value) -> builder.activated((boolean) value)).build();
    private static final RelationLazyInserter<BoxBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<BoxBuilder>(0, Inserters::relationIndex).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case Box.FeatureIDs.CURRENT_ALLOCATION_COUNT -> 0;
        case Box.FeatureIDs.TOTAL_ALLOCATION_COUNT -> 1;
        case Box.FeatureIDs.DEPENDENCY_UPDATE_COUNT -> 2;
        case Box.FeatureIDs.ACTIVATED -> 3;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
    }
  }
}
