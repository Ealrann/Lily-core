package org.sheepy.lily.core.model.resource.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.util.BuildUtils;
import org.sheepy.lily.core.model.resource.IRootResource;
import org.sheepy.lily.core.model.resource.ResourcePkg;
import org.sheepy.lily.core.model.resource.ResourcePkg.Builder;
import org.sheepy.lily.core.model.resource.impl.ResourcePkgImpl;

public final class ResourcePkgBuilder implements Builder {
  private final List<Supplier<IRootResource>> resources = new ArrayList<>();

  public ResourcePkgBuilder() {
  }

  @Override
  public ResourcePkgBuilder addResource(Supplier<IRootResource> resource) {
    this.resources.add(resource);
    return this;
  }

  @Override
  public ResourcePkgBuilder addResources(final List<IRootResource> resources) {
    resources.forEach(value -> this.resources.add(() -> value));
    return this;
  }

  @Override
  public ResourcePkg build() {
    final var builtResources = BuildUtils.collectSuppliers(resources);
    final var built = new ResourcePkgImpl();
    built.resources().addAll(builtResources);
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
    private static final FeatureInserter<ResourcePkgBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<ResourcePkgBuilder>(0, Inserters::attributeIndex).build();
    private static final RelationLazyInserter<ResourcePkgBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<ResourcePkgBuilder>(1, Inserters::relationIndex).add(ResourcePkg.FeatureIDs.RESOURCES, (builder, value) -> builder.addResource((Supplier<IRootResource>) value)).build();

    private static int attributeIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case ResourcePkg.FeatureIDs.RESOURCES -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
