package org.sheepy.lily.core.model.application.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.util.BuildUtils;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.core.model.application.Application.Builder;
import org.sheepy.lily.core.model.application.ApplicationExtensionPkg;
import org.sheepy.lily.core.model.application.IEngine;
import org.sheepy.lily.core.model.application.IModel;
import org.sheepy.lily.core.model.application.Scene;
import org.sheepy.lily.core.model.application.TimeConfiguration;
import org.sheepy.lily.core.model.application.impl.ApplicationImpl;
import org.sheepy.lily.core.model.resource.ResourcePkg;

public final class ApplicationBuilder implements Builder {
  private String name;
  private String domain;
  private final List<String> imports = new ArrayList<>();
  private final List<String> metamodels = new ArrayList<>();
  private final List<Supplier<IEngine>> engines = new ArrayList<>();
  private boolean run = true;
  private String title = "Vulkan Application";
  private Supplier<Scene> scene = () -> null;
  private Supplier<TimeConfiguration> timeConfiguration = () -> null;
  private Supplier<ApplicationExtensionPkg> extensionPkg = () -> null;
  private final List<Supplier<IModel>> models = new ArrayList<>();
  private Supplier<ResourcePkg> resourcePkg = () -> null;
  private String version = "0.0.0";

  public ApplicationBuilder() {
  }

  @Override
  public ApplicationBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public ApplicationBuilder domain(String domain) {
    this.domain = domain;
    return this;
  }

  @Override
  public ApplicationBuilder addImport(String import_) {
    this.imports.add(import_);
    return this;
  }

  @Override
  public ApplicationBuilder addImports(final List<String> imports) {
    this.imports.addAll(imports);
    return this;
  }

  @Override
  public ApplicationBuilder addMetamodel(String metamodel) {
    this.metamodels.add(metamodel);
    return this;
  }

  @Override
  public ApplicationBuilder addMetamodels(final List<String> metamodels) {
    this.metamodels.addAll(metamodels);
    return this;
  }

  @Override
  public ApplicationBuilder addEngine(Supplier<IEngine> engine) {
    this.engines.add(engine);
    return this;
  }

  @Override
  public ApplicationBuilder addEngines(final List<IEngine> engines) {
    engines.forEach(value -> this.engines.add(() -> value));
    return this;
  }

  @Override
  public ApplicationBuilder run(boolean run) {
    this.run = run;
    return this;
  }

  @Override
  public ApplicationBuilder title(String title) {
    this.title = title;
    return this;
  }

  @Override
  public ApplicationBuilder scene(Supplier<Scene> scene) {
    this.scene = scene;
    return this;
  }

  @Override
  public ApplicationBuilder timeConfiguration(Supplier<TimeConfiguration> timeConfiguration) {
    this.timeConfiguration = timeConfiguration;
    return this;
  }

  @Override
  public ApplicationBuilder extensionPkg(Supplier<ApplicationExtensionPkg> extensionPkg) {
    this.extensionPkg = extensionPkg;
    return this;
  }

  @Override
  public ApplicationBuilder addModel(Supplier<IModel> model) {
    this.models.add(model);
    return this;
  }

  @Override
  public ApplicationBuilder addModels(final List<IModel> models) {
    models.forEach(value -> this.models.add(() -> value));
    return this;
  }

  @Override
  public ApplicationBuilder resourcePkg(Supplier<ResourcePkg> resourcePkg) {
    this.resourcePkg = resourcePkg;
    return this;
  }

  @Override
  public ApplicationBuilder version(String version) {
    this.version = version;
    return this;
  }

  @Override
  public Application build() {
    final var builtEngines = BuildUtils.collectSuppliers(engines);
    final var builtModels = BuildUtils.collectSuppliers(models);
    final var built = new ApplicationImpl(name, domain, imports, metamodels, version);
    built.engines().addAll(builtEngines);
    built.run(run);
    built.title(title);
    built.scene(scene.get());
    built.timeConfiguration(timeConfiguration.get());
    built.extensionPkg(extensionPkg.get());
    built.models().addAll(builtModels);
    built.resourcePkg(resourcePkg.get());
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
    private static final FeatureInserter<ApplicationBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<ApplicationBuilder>(7, Inserters::attributeIndex).add(Application.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(Application.FeatureIDs.DOMAIN, (builder, value) -> builder.domain((String) value)).add(Application.FeatureIDs.IMPORTS, (builder, value) -> builder.addImport((String) value)).add(Application.FeatureIDs.METAMODELS, (builder, value) -> builder.addMetamodel((String) value)).add(Application.FeatureIDs.RUN, (builder, value) -> builder.run((boolean) value)).add(Application.FeatureIDs.TITLE, (builder, value) -> builder.title((String) value)).add(Application.FeatureIDs.VERSION, (builder, value) -> builder.version((String) value)).build();
    private static final RelationLazyInserter<ApplicationBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<ApplicationBuilder>(6, Inserters::relationIndex).add(Application.FeatureIDs.ENGINES, (builder, value) -> builder.addEngine((Supplier<IEngine>) value)).add(Application.FeatureIDs.SCENE, (builder, value) -> builder.scene((Supplier<Scene>) value)).add(Application.FeatureIDs.TIME_CONFIGURATION, (builder, value) -> builder.timeConfiguration((Supplier<TimeConfiguration>) value)).add(Application.FeatureIDs.EXTENSION_PKG, (builder, value) -> builder.extensionPkg((Supplier<ApplicationExtensionPkg>) value)).add(Application.FeatureIDs.MODELS, (builder, value) -> builder.addModel((Supplier<IModel>) value)).add(Application.FeatureIDs.RESOURCE_PKG, (builder, value) -> builder.resourcePkg((Supplier<ResourcePkg>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case Application.FeatureIDs.NAME -> 0;
        case Application.FeatureIDs.DOMAIN -> 1;
        case Application.FeatureIDs.IMPORTS -> 2;
        case Application.FeatureIDs.METAMODELS -> 3;
        case Application.FeatureIDs.RUN -> 4;
        case Application.FeatureIDs.TITLE -> 5;
        case Application.FeatureIDs.VERSION -> 6;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case Application.FeatureIDs.ENGINES -> 0;
        case Application.FeatureIDs.SCENE -> 1;
        case Application.FeatureIDs.TIME_CONFIGURATION -> 2;
        case Application.FeatureIDs.EXTENSION_PKG -> 3;
        case Application.FeatureIDs.MODELS -> 4;
        case Application.FeatureIDs.RESOURCE_PKG -> 5;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
