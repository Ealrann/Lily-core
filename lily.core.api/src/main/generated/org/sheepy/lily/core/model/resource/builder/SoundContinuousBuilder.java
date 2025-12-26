package org.sheepy.lily.core.model.resource.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.core.model.resource.FileResource;
import org.sheepy.lily.core.model.resource.SoundContinuous;
import org.sheepy.lily.core.model.resource.SoundContinuous.Builder;
import org.sheepy.lily.core.model.resource.impl.SoundContinuousImpl;

public final class SoundContinuousBuilder implements Builder {
  private String name;
  private Supplier<FileResource> file;
  private int attackMs;
  private int decayMs;

  public SoundContinuousBuilder() {
  }

  @Override
  public SoundContinuousBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public SoundContinuousBuilder file(Supplier<FileResource> file) {
    this.file = file;
    return this;
  }

  @Override
  public SoundContinuousBuilder attackMs(int attackMs) {
    this.attackMs = attackMs;
    return this;
  }

  @Override
  public SoundContinuousBuilder decayMs(int decayMs) {
    this.decayMs = decayMs;
    return this;
  }

  @Override
  public SoundContinuous build() {
    final var built = new SoundContinuousImpl(name, file.get(), attackMs, decayMs);
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
    private static final FeatureInserter<SoundContinuousBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<SoundContinuousBuilder>(3, Inserters::attributeIndex).add(SoundContinuous.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(SoundContinuous.FeatureIDs.ATTACK_MS, (builder, value) -> builder.attackMs((int) value)).add(SoundContinuous.FeatureIDs.DECAY_MS, (builder, value) -> builder.decayMs((int) value)).build();
    private static final RelationLazyInserter<SoundContinuousBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<SoundContinuousBuilder>(1, Inserters::relationIndex).add(SoundContinuous.FeatureIDs.FILE, (builder, value) -> builder.file((Supplier<FileResource>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case SoundContinuous.FeatureIDs.NAME -> 0;
        case SoundContinuous.FeatureIDs.ATTACK_MS -> 1;
        case SoundContinuous.FeatureIDs.DECAY_MS -> 2;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case SoundContinuous.FeatureIDs.FILE -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
