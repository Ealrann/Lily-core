package org.sheepy.lily.core.model.resource.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.core.model.resource.LocalResource;
import org.sheepy.lily.core.model.resource.LocalResource.Builder;
import org.sheepy.lily.core.model.resource.impl.LocalResourceImpl;

public final class LocalResourceBuilder implements Builder {
  private String name;
  private String path;

  public LocalResourceBuilder() {
  }

  @Override
  public LocalResourceBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public LocalResourceBuilder path(String path) {
    this.path = path;
    return this;
  }

  @Override
  public LocalResource build() {
    final var built = new LocalResourceImpl(name, path);
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
    private static final FeatureInserter<LocalResourceBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<LocalResourceBuilder>(2, Inserters::attributeIndex).add(LocalResource.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(LocalResource.FeatureIDs.PATH, (builder, value) -> builder.path((String) value)).build();
    private static final RelationLazyInserter<LocalResourceBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<LocalResourceBuilder>(0, Inserters::relationIndex).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case LocalResource.FeatureIDs.NAME -> 0;
        case LocalResource.FeatureIDs.PATH -> 1;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
    }
  }
}
