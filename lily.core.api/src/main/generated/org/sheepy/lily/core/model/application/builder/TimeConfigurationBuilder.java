package org.sheepy.lily.core.model.application.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.core.model.application.TimeConfiguration;
import org.sheepy.lily.core.model.application.TimeConfiguration.Builder;
import org.sheepy.lily.core.model.application.impl.TimeConfigurationImpl;
import org.sheepy.lily.core.model.types.ETimeUnit;

public final class TimeConfigurationBuilder implements Builder {
  private long timeStep = 1;
  private ETimeUnit unit = ETimeUnit.SECONDS;
  private double timeFactor = 1;

  public TimeConfigurationBuilder() {
  }

  @Override
  public TimeConfigurationBuilder timeStep(long timeStep) {
    this.timeStep = timeStep;
    return this;
  }

  @Override
  public TimeConfigurationBuilder unit(ETimeUnit unit) {
    this.unit = unit;
    return this;
  }

  @Override
  public TimeConfigurationBuilder timeFactor(double timeFactor) {
    this.timeFactor = timeFactor;
    return this;
  }

  @Override
  public TimeConfiguration build() {
    final var built = new TimeConfigurationImpl(timeStep, unit, timeFactor);
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
    private static final FeatureInserter<TimeConfigurationBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<TimeConfigurationBuilder>(3, Inserters::attributeIndex).add(TimeConfiguration.FeatureIDs.TIME_STEP, (builder, value) -> builder.timeStep((long) value)).add(TimeConfiguration.FeatureIDs.UNIT, (builder, value) -> builder.unit((ETimeUnit) value)).add(TimeConfiguration.FeatureIDs.TIME_FACTOR, (builder, value) -> builder.timeFactor((double) value)).build();
    private static final RelationLazyInserter<TimeConfigurationBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<TimeConfigurationBuilder>(0, Inserters::relationIndex).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case TimeConfiguration.FeatureIDs.TIME_STEP -> 0;
        case TimeConfiguration.FeatureIDs.UNIT -> 1;
        case TimeConfiguration.FeatureIDs.TIME_FACTOR -> 2;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
    }
  }
}
