package org.sheepy.lily.core.allocation.test.testallocation.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.util.BuildUtils;
import org.sheepy.lily.core.allocation.test.testallocation.Box;
import org.sheepy.lily.core.allocation.test.testallocation.Leaf;
import org.sheepy.lily.core.allocation.test.testallocation.Leaf.Builder;
import org.sheepy.lily.core.allocation.test.testallocation.impl.LeafImpl;

public final class LeafBuilder implements Builder {
  private int currentAllocationCount = 0;
  private int totalAllocationCount = 0;
  private int dependencyUpdateCount = 0;
  private boolean activated = true;
  private final List<Supplier<Box>> boxes = new ArrayList<>();

  public LeafBuilder() {
  }

  @Override
  public LeafBuilder currentAllocationCount(int currentAllocationCount) {
    this.currentAllocationCount = currentAllocationCount;
    return this;
  }

  @Override
  public LeafBuilder totalAllocationCount(int totalAllocationCount) {
    this.totalAllocationCount = totalAllocationCount;
    return this;
  }

  @Override
  public LeafBuilder dependencyUpdateCount(int dependencyUpdateCount) {
    this.dependencyUpdateCount = dependencyUpdateCount;
    return this;
  }

  @Override
  public LeafBuilder activated(boolean activated) {
    this.activated = activated;
    return this;
  }

  @Override
  public LeafBuilder addBoxe(Supplier<Box> boxe) {
    this.boxes.add(boxe);
    return this;
  }

  @Override
  public LeafBuilder addBoxes(final List<Box> boxes) {
    boxes.forEach(value -> this.boxes.add(() -> value));
    return this;
  }

  @Override
  public Leaf build() {
    final var builtBoxes = BuildUtils.collectSuppliers(boxes);
    final var built = new LeafImpl();
    built.currentAllocationCount(currentAllocationCount);
    built.totalAllocationCount(totalAllocationCount);
    built.dependencyUpdateCount(dependencyUpdateCount);
    built.activated(activated);
    built.boxes().addAll(builtBoxes);
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
    private static final FeatureInserter<LeafBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<LeafBuilder>(4, Inserters::attributeIndex).add(Leaf.FeatureIDs.CURRENT_ALLOCATION_COUNT, (builder, value) -> builder.currentAllocationCount((int) value)).add(Leaf.FeatureIDs.TOTAL_ALLOCATION_COUNT, (builder, value) -> builder.totalAllocationCount((int) value)).add(Leaf.FeatureIDs.DEPENDENCY_UPDATE_COUNT, (builder, value) -> builder.dependencyUpdateCount((int) value)).add(Leaf.FeatureIDs.ACTIVATED, (builder, value) -> builder.activated((boolean) value)).build();
    private static final RelationLazyInserter<LeafBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<LeafBuilder>(1, Inserters::relationIndex).add(Leaf.FeatureIDs.BOXES, (builder, value) -> builder.addBoxe((Supplier<Box>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case Leaf.FeatureIDs.CURRENT_ALLOCATION_COUNT -> 0;
        case Leaf.FeatureIDs.TOTAL_ALLOCATION_COUNT -> 1;
        case Leaf.FeatureIDs.DEPENDENCY_UPDATE_COUNT -> 2;
        case Leaf.FeatureIDs.ACTIVATED -> 3;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case Leaf.FeatureIDs.BOXES -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
