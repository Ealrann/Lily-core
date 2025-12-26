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
import org.sheepy.lily.core.model.cadence.Cadence;
import org.sheepy.lily.core.model.cadence.Cadence.Builder;
import org.sheepy.lily.core.model.cadence.ICadenceTask;
import org.sheepy.lily.core.model.cadence.impl.CadenceImpl;

public final class CadenceBuilder implements Builder {
  private final List<Supplier<ICadenceTask>> tasks = new ArrayList<>();
  private int frequency = -1;
  private boolean printUPS = false;

  public CadenceBuilder() {
  }

  @Override
  public CadenceBuilder addTask(Supplier<ICadenceTask> task) {
    this.tasks.add(task);
    return this;
  }

  @Override
  public CadenceBuilder addTasks(final List<ICadenceTask> tasks) {
    tasks.forEach(value -> this.tasks.add(() -> value));
    return this;
  }

  @Override
  public CadenceBuilder frequency(int frequency) {
    this.frequency = frequency;
    return this;
  }

  @Override
  public CadenceBuilder printUPS(boolean printUPS) {
    this.printUPS = printUPS;
    return this;
  }

  @Override
  public Cadence build() {
    final var builtTasks = BuildUtils.collectSuppliers(tasks);
    final var built = new CadenceImpl(frequency, printUPS);
    built.tasks().addAll(builtTasks);
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
    private static final FeatureInserter<CadenceBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<CadenceBuilder>(2, Inserters::attributeIndex).add(Cadence.FeatureIDs.FREQUENCY, (builder, value) -> builder.frequency((int) value)).add(Cadence.FeatureIDs.PRINTUPS, (builder, value) -> builder.printUPS((boolean) value)).build();
    private static final RelationLazyInserter<CadenceBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<CadenceBuilder>(1, Inserters::relationIndex).add(Cadence.FeatureIDs.TASKS, (builder, value) -> builder.addTask((Supplier<ICadenceTask>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case Cadence.FeatureIDs.FREQUENCY -> 0;
        case Cadence.FeatureIDs.PRINTUPS -> 1;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case Cadence.FeatureIDs.TASKS -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
