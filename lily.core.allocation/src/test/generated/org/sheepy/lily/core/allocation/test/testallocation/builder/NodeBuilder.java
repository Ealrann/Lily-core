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
import org.sheepy.lily.core.allocation.test.testallocation.Container;
import org.sheepy.lily.core.allocation.test.testallocation.Leaf;
import org.sheepy.lily.core.allocation.test.testallocation.Node;
import org.sheepy.lily.core.allocation.test.testallocation.Node.Builder;
import org.sheepy.lily.core.allocation.test.testallocation.impl.NodeImpl;

public final class NodeBuilder implements Builder {
  private int currentAllocationCount = 0;
  private int totalAllocationCount = 0;
  private int dependencyUpdateCount = 0;
  private boolean activated = true;
  private final List<Supplier<Leaf>> leaves = new ArrayList<>();
  private Supplier<Container> container = () -> null;

  public NodeBuilder() {
  }

  @Override
  public NodeBuilder currentAllocationCount(int currentAllocationCount) {
    this.currentAllocationCount = currentAllocationCount;
    return this;
  }

  @Override
  public NodeBuilder totalAllocationCount(int totalAllocationCount) {
    this.totalAllocationCount = totalAllocationCount;
    return this;
  }

  @Override
  public NodeBuilder dependencyUpdateCount(int dependencyUpdateCount) {
    this.dependencyUpdateCount = dependencyUpdateCount;
    return this;
  }

  @Override
  public NodeBuilder activated(boolean activated) {
    this.activated = activated;
    return this;
  }

  @Override
  public NodeBuilder addLeave(Supplier<Leaf> leave) {
    this.leaves.add(leave);
    return this;
  }

  @Override
  public NodeBuilder addLeaves(final List<Leaf> leaves) {
    leaves.forEach(value -> this.leaves.add(() -> value));
    return this;
  }

  @Override
  public NodeBuilder container(Supplier<Container> container) {
    this.container = container;
    return this;
  }

  @Override
  public Node build() {
    final var builtLeaves = BuildUtils.collectSuppliers(leaves);
    final var built = new NodeImpl();
    built.currentAllocationCount(currentAllocationCount);
    built.totalAllocationCount(totalAllocationCount);
    built.dependencyUpdateCount(dependencyUpdateCount);
    built.activated(activated);
    built.leaves().addAll(builtLeaves);
    built.container(container.get());
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
    private static final FeatureInserter<NodeBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<NodeBuilder>(4, Inserters::attributeIndex).add(Node.FeatureIDs.CURRENT_ALLOCATION_COUNT, (builder, value) -> builder.currentAllocationCount((int) value)).add(Node.FeatureIDs.TOTAL_ALLOCATION_COUNT, (builder, value) -> builder.totalAllocationCount((int) value)).add(Node.FeatureIDs.DEPENDENCY_UPDATE_COUNT, (builder, value) -> builder.dependencyUpdateCount((int) value)).add(Node.FeatureIDs.ACTIVATED, (builder, value) -> builder.activated((boolean) value)).build();
    private static final RelationLazyInserter<NodeBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<NodeBuilder>(2, Inserters::relationIndex).add(Node.FeatureIDs.LEAVES, (builder, value) -> builder.addLeave((Supplier<Leaf>) value)).add(Node.FeatureIDs.CONTAINER, (builder, value) -> builder.container((Supplier<Container>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case Node.FeatureIDs.CURRENT_ALLOCATION_COUNT -> 0;
        case Node.FeatureIDs.TOTAL_ALLOCATION_COUNT -> 1;
        case Node.FeatureIDs.DEPENDENCY_UPDATE_COUNT -> 2;
        case Node.FeatureIDs.ACTIVATED -> 3;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case Node.FeatureIDs.LEAVES -> 0;
        case Node.FeatureIDs.CONTAINER -> 1;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
