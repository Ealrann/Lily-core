package org.sheepy.lily.core.model.resource.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.core.model.resource.StringModuleResource;
import org.sheepy.lily.core.model.resource.StringModuleResource.Builder;
import org.sheepy.lily.core.model.resource.impl.StringModuleResourceImpl;

public final class StringModuleResourceBuilder implements Builder {
  private String name;
  private String path;
  private String moduleName;

  public StringModuleResourceBuilder() {
  }

  @Override
  public StringModuleResourceBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public StringModuleResourceBuilder path(String path) {
    this.path = path;
    return this;
  }

  @Override
  public StringModuleResourceBuilder moduleName(String moduleName) {
    this.moduleName = moduleName;
    return this;
  }

  @Override
  public StringModuleResource build() {
    final var built = new StringModuleResourceImpl(name, path, moduleName);
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
    private static final FeatureInserter<StringModuleResourceBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<StringModuleResourceBuilder>(3, Inserters::attributeIndex).add(StringModuleResource.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(StringModuleResource.FeatureIDs.PATH, (builder, value) -> builder.path((String) value)).add(StringModuleResource.FeatureIDs.MODULE_NAME, (builder, value) -> builder.moduleName((String) value)).build();
    private static final RelationLazyInserter<StringModuleResourceBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<StringModuleResourceBuilder>(0, Inserters::relationIndex).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case StringModuleResource.FeatureIDs.NAME -> 0;
        case StringModuleResource.FeatureIDs.PATH -> 1;
        case StringModuleResource.FeatureIDs.MODULE_NAME -> 2;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
    }
  }
}
