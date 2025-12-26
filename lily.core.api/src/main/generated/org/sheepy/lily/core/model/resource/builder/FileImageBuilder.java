package org.sheepy.lily.core.model.resource.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.core.model.resource.FileImage;
import org.sheepy.lily.core.model.resource.FileImage.Builder;
import org.sheepy.lily.core.model.resource.FileResource;
import org.sheepy.lily.core.model.resource.impl.FileImageImpl;

public final class FileImageBuilder implements Builder {
  private String name;
  private Supplier<FileResource> file;

  public FileImageBuilder() {
  }

  @Override
  public FileImageBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public FileImageBuilder file(Supplier<FileResource> file) {
    this.file = file;
    return this;
  }

  @Override
  public FileImage build() {
    final var built = new FileImageImpl(name, file.get());
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
    private static final FeatureInserter<FileImageBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<FileImageBuilder>(1, Inserters::attributeIndex).add(FileImage.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).build();
    private static final RelationLazyInserter<FileImageBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<FileImageBuilder>(1, Inserters::relationIndex).add(FileImage.FeatureIDs.FILE, (builder, value) -> builder.file((Supplier<FileResource>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case FileImage.FeatureIDs.NAME -> 0;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case FileImage.FeatureIDs.FILE -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
