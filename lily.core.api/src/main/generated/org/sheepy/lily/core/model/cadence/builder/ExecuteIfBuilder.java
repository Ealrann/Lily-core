package org.sheepy.lily.core.model.cadence.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.util.BuildUtils;
import org.sheepy.lily.core.model.cadence.ExecuteIf;
import org.sheepy.lily.core.model.cadence.ExecuteIf.Builder;
import org.sheepy.lily.core.model.cadence.ICadenceCondition;
import org.sheepy.lily.core.model.cadence.ICadenceTask;
import org.sheepy.lily.core.model.cadence.impl.ExecuteIfImpl;

public final class ExecuteIfBuilder implements Builder {
  private final List<Supplier<ICadenceTask>> tasks = new ArrayList<>();
  private final List<Supplier<ICadenceCondition>> conditions = new ArrayList<>();

  public ExecuteIfBuilder() {
  }

  @Override
  public ExecuteIfBuilder addTask(Supplier<ICadenceTask> task) {
    this.tasks.add(task);
    return this;
  }

  @Override
  public ExecuteIfBuilder addTasks(final List<ICadenceTask> tasks) {
    tasks.forEach(value -> this.tasks.add(() -> value));
    return this;
  }

  @Override
  public ExecuteIfBuilder addCondition(Supplier<ICadenceCondition> condition) {
    this.conditions.add(condition);
    return this;
  }

  @Override
  public ExecuteIfBuilder addConditions(final List<ICadenceCondition> conditions) {
    conditions.forEach(value -> this.conditions.add(() -> value));
    return this;
  }

  @Override
  public ExecuteIf build() {
    final var builtTasks = BuildUtils.collectSuppliers(tasks);
    final var builtConditions = BuildUtils.collectSuppliers(conditions);
    final var built = new ExecuteIfImpl();
    built.tasks().addAll(builtTasks);
    built.conditions().addAll(builtConditions);
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
    private static final FeatureInserter<ExecuteIfBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<ExecuteIfBuilder>(0, Inserters::attributeIndex).build();
    private static final RelationLazyInserter<ExecuteIfBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<ExecuteIfBuilder>(2, Inserters::relationIndex).add(ExecuteIf.FeatureIDs.TASKS, (builder, value) -> builder.addTask((Supplier<ICadenceTask>) value)).add(ExecuteIf.FeatureIDs.CONDITIONS, (builder, value) -> builder.addCondition((Supplier<ICadenceCondition>) value)).build();

    private static int attributeIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case ExecuteIf.FeatureIDs.TASKS -> 0;
        case ExecuteIf.FeatureIDs.CONDITIONS -> 1;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
