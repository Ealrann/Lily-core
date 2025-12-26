package org.sheepy.lily.core.model.resource.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.core.model.resource.FileResource;
import org.sheepy.lily.core.model.resource.Music;
import org.sheepy.lily.core.model.resource.Music.Builder;
import org.sheepy.lily.core.model.resource.impl.MusicImpl;

public final class MusicBuilder implements Builder {
  private String name;
  private Supplier<FileResource> file;

  public MusicBuilder() {
  }

  @Override
  public MusicBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public MusicBuilder file(Supplier<FileResource> file) {
    this.file = file;
    return this;
  }

  @Override
  public Music build() {
    final var built = new MusicImpl(name, file.get());
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
    private static final FeatureInserter<MusicBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<MusicBuilder>(1, Inserters::attributeIndex).add(Music.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).build();
    private static final RelationLazyInserter<MusicBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<MusicBuilder>(1, Inserters::relationIndex).add(Music.FeatureIDs.FILE, (builder, value) -> builder.file((Supplier<FileResource>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case Music.FeatureIDs.NAME -> 0;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case Music.FeatureIDs.FILE -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
