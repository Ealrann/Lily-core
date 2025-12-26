package org.sheepy.lily.core.model.types.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.util.BuildUtils;
import org.sheepy.lily.core.model.types.ModelPart;
import org.sheepy.lily.core.model.types.ModelPart.Builder;
import org.sheepy.lily.core.model.types.impl.ModelPartImpl;

public final class ModelPartBuilder implements Builder {
  private String name;
  private String domain;
  private final List<String> imports = new ArrayList<>();
  private final List<String> metamodels = new ArrayList<>();
  private final List<Supplier<LMObject>> children = new ArrayList<>();

  public ModelPartBuilder() {
  }

  @Override
  public ModelPartBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public ModelPartBuilder domain(String domain) {
    this.domain = domain;
    return this;
  }

  @Override
  public ModelPartBuilder addImport(String import_) {
    this.imports.add(import_);
    return this;
  }

  @Override
  public ModelPartBuilder addImports(final List<String> imports) {
    this.imports.addAll(imports);
    return this;
  }

  @Override
  public ModelPartBuilder addMetamodel(String metamodel) {
    this.metamodels.add(metamodel);
    return this;
  }

  @Override
  public ModelPartBuilder addMetamodels(final List<String> metamodels) {
    this.metamodels.addAll(metamodels);
    return this;
  }

  @Override
  public ModelPartBuilder addChildren(Supplier<LMObject> children) {
    this.children.add(children);
    return this;
  }

  @Override
  public ModelPartBuilder addChildren(final List<LMObject> children) {
    children.forEach(value -> this.children.add(() -> value));
    return this;
  }

  @Override
  public ModelPart build() {
    final var builtChildren = BuildUtils.collectSuppliers(children);
    final var built = new ModelPartImpl(name, domain, imports, metamodels);
    built.children().addAll(builtChildren);
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
    private static final FeatureInserter<ModelPartBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<ModelPartBuilder>(4, Inserters::attributeIndex).add(ModelPart.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(ModelPart.FeatureIDs.DOMAIN, (builder, value) -> builder.domain((String) value)).add(ModelPart.FeatureIDs.IMPORTS, (builder, value) -> builder.addImport((String) value)).add(ModelPart.FeatureIDs.METAMODELS, (builder, value) -> builder.addMetamodel((String) value)).build();
    private static final RelationLazyInserter<ModelPartBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<ModelPartBuilder>(1, Inserters::relationIndex).add(ModelPart.FeatureIDs.CHILDREN, (builder, value) -> builder.addChildren((Supplier<LMObject>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case ModelPart.FeatureIDs.NAME -> 0;
        case ModelPart.FeatureIDs.DOMAIN -> 1;
        case ModelPart.FeatureIDs.IMPORTS -> 2;
        case ModelPart.FeatureIDs.METAMODELS -> 3;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case ModelPart.FeatureIDs.CHILDREN -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
