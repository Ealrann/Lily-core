package org.sheepy.lily.core.model.resource.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.core.model.resource.ModuleResource;
import org.sheepy.lily.core.model.resource.ModuleResource.Builder;
import org.sheepy.lily.core.model.resource.impl.ModuleResourceImpl;

public final class ModuleResourceBuilder implements Builder {
  private String name;
  private String path;
  private Module module;

  public ModuleResourceBuilder() {
  }

  @Override
  public ModuleResourceBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public ModuleResourceBuilder path(String path) {
    this.path = path;
    return this;
  }

  @Override
  public ModuleResourceBuilder module(Module module) {
    this.module = module;
    return this;
  }

  @Override
  public ModuleResource build() {
    final var built = new ModuleResourceImpl(name, path, module);
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
    private static final FeatureInserter<ModuleResourceBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<ModuleResourceBuilder>(3, Inserters::attributeIndex).add(ModuleResource.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(ModuleResource.FeatureIDs.PATH, (builder, value) -> builder.path((String) value)).add(ModuleResource.FeatureIDs.MODULE, (builder, value) -> builder.module((Module) value)).build();
    private static final RelationLazyInserter<ModuleResourceBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<ModuleResourceBuilder>(0, Inserters::relationIndex).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case ModuleResource.FeatureIDs.NAME -> 0;
        case ModuleResource.FeatureIDs.PATH -> 1;
        case ModuleResource.FeatureIDs.MODULE -> 2;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
    }
  }
}
