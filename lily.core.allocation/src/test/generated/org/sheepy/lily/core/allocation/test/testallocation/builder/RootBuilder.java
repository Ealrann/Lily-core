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
import org.sheepy.lily.core.allocation.test.testallocation.Node;
import org.sheepy.lily.core.allocation.test.testallocation.Root;
import org.sheepy.lily.core.allocation.test.testallocation.Root.Builder;
import org.sheepy.lily.core.allocation.test.testallocation.impl.RootImpl;

public final class RootBuilder implements Builder {
  private int currentAllocationCount = 0;
  private int totalAllocationCount = 0;
  private int dependencyUpdateCount = 0;
  private boolean activated = true;
  private final List<Supplier<Node>> nodes = new ArrayList<>();
  private final List<Supplier<Container>> containers = new ArrayList<>();

  public RootBuilder() {
  }

  @Override
  public RootBuilder currentAllocationCount(int currentAllocationCount) {
    this.currentAllocationCount = currentAllocationCount;
    return this;
  }

  @Override
  public RootBuilder totalAllocationCount(int totalAllocationCount) {
    this.totalAllocationCount = totalAllocationCount;
    return this;
  }

  @Override
  public RootBuilder dependencyUpdateCount(int dependencyUpdateCount) {
    this.dependencyUpdateCount = dependencyUpdateCount;
    return this;
  }

  @Override
  public RootBuilder activated(boolean activated) {
    this.activated = activated;
    return this;
  }

  @Override
  public RootBuilder addNode(Supplier<Node> node) {
    this.nodes.add(node);
    return this;
  }

  @Override
  public RootBuilder addNodes(final List<Node> nodes) {
    nodes.forEach(value -> this.nodes.add(() -> value));
    return this;
  }

  @Override
  public RootBuilder addContainer(Supplier<Container> container) {
    this.containers.add(container);
    return this;
  }

  @Override
  public RootBuilder addContainers(final List<Container> containers) {
    containers.forEach(value -> this.containers.add(() -> value));
    return this;
  }

  @Override
  public Root build() {
    final var builtNodes = BuildUtils.collectSuppliers(nodes);
    final var builtContainers = BuildUtils.collectSuppliers(containers);
    final var built = new RootImpl();
    built.currentAllocationCount(currentAllocationCount);
    built.totalAllocationCount(totalAllocationCount);
    built.dependencyUpdateCount(dependencyUpdateCount);
    built.activated(activated);
    built.nodes().addAll(builtNodes);
    built.containers().addAll(builtContainers);
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
    private static final FeatureInserter<RootBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<RootBuilder>(4, Inserters::attributeIndex).add(Root.FeatureIDs.CURRENT_ALLOCATION_COUNT, (builder, value) -> builder.currentAllocationCount((int) value)).add(Root.FeatureIDs.TOTAL_ALLOCATION_COUNT, (builder, value) -> builder.totalAllocationCount((int) value)).add(Root.FeatureIDs.DEPENDENCY_UPDATE_COUNT, (builder, value) -> builder.dependencyUpdateCount((int) value)).add(Root.FeatureIDs.ACTIVATED, (builder, value) -> builder.activated((boolean) value)).build();
    private static final RelationLazyInserter<RootBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<RootBuilder>(2, Inserters::relationIndex).add(Root.FeatureIDs.NODES, (builder, value) -> builder.addNode((Supplier<Node>) value)).add(Root.FeatureIDs.CONTAINERS, (builder, value) -> builder.addContainer((Supplier<Container>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case Root.FeatureIDs.CURRENT_ALLOCATION_COUNT -> 0;
        case Root.FeatureIDs.TOTAL_ALLOCATION_COUNT -> 1;
        case Root.FeatureIDs.DEPENDENCY_UPDATE_COUNT -> 2;
        case Root.FeatureIDs.ACTIVATED -> 3;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case Root.FeatureIDs.NODES -> 0;
        case Root.FeatureIDs.CONTAINERS -> 1;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
