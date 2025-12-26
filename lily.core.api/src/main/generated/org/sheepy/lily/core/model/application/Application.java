package org.sheepy.lily.core.model.application;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.BooleanListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.Model;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.core.model.application.builder.ApplicationBuilder;
import org.sheepy.lily.core.model.resource.ResourceModelDefinition;
import org.sheepy.lily.core.model.resource.ResourcePkg;

public interface Application extends Model {
  static Builder builder() {
    return new ApplicationBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<IEngine> engines();
  boolean run();
  String title();
  Scene scene();
  TimeConfiguration timeConfiguration();
  ApplicationExtensionPkg extensionPkg();
  List<IModel> models();
  ResourcePkg resourcePkg();
  String version();
  void run(final boolean run);
  void title(final String title);
  void scene(final Scene scene);
  void timeConfiguration(final TimeConfiguration timeConfiguration);
  void extensionPkg(final ApplicationExtensionPkg extensionPkg);
  void resourcePkg(final ResourcePkg resourcePkg);
  void version(final String version);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int DOMAIN = Model.FeatureIDs.DOMAIN;
    int IMPORTS = Model.FeatureIDs.IMPORTS;
    int METAMODELS = Model.FeatureIDs.METAMODELS;
    int ENGINES = 521883899;
    int RUN = 6328853;
    int TITLE = 1788559202;
    int SCENE = 1787442582;
    int TIME_CONFIGURATION = -840047309;
    int EXTENSION_PKG = 188040387;
    int MODELS = -584585568;
    int RESOURCE_PKG = 1913716840;
    int VERSION = -1817632926;
  }

  interface Features<T extends Features<T>> extends Model.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<String, String, Listener<String>, Model.Features<?>> DOMAIN = Model.Features.DOMAIN;
    Attribute<String, List<String>, Listener<List<String>>, Model.Features<?>> IMPORTS = Model.Features.IMPORTS;
    Attribute<String, List<String>, Listener<List<String>>, Model.Features<?>> METAMODELS = Model.Features.METAMODELS;
    Relation<IEngine, List<IEngine>, Listener<List<IEngine>>, Features<?>> ENGINES = new RelationBuilder<IEngine, List<IEngine>, Listener<List<IEngine>>, Features<?>>().name("engines").many(true).contains(true).id(Application.FeatureIDs.ENGINES).concept(() -> ApplicationModelDefinition.Groups.I_ENGINE).build();
    Attribute<Boolean, Boolean, BooleanListener, Features<?>> RUN = new AttributeBuilder<Boolean, Boolean, BooleanListener, Features<?>>().name("run").defaultValue("true").id(Application.FeatureIDs.RUN).datatype(() -> LMCoreModelDefinition.Units.BOOLEAN).build();
    Attribute<String, String, Listener<String>, Features<?>> TITLE = new AttributeBuilder<String, String, Listener<String>, Features<?>>().name("title").defaultValue("Vulkan Application").id(Application.FeatureIDs.TITLE).datatype(() -> LMCoreModelDefinition.Units.STRING).build();
    Relation<Scene, Scene, Listener<Scene>, Features<?>> SCENE = new RelationBuilder<Scene, Scene, Listener<Scene>, Features<?>>().name("scene").contains(true).id(Application.FeatureIDs.SCENE).concept(() -> ApplicationModelDefinition.Groups.SCENE).build();
    Relation<TimeConfiguration, TimeConfiguration, Listener<TimeConfiguration>, Features<?>> TIME_CONFIGURATION = new RelationBuilder<TimeConfiguration, TimeConfiguration, Listener<TimeConfiguration>, Features<?>>().name("timeConfiguration").contains(true).id(Application.FeatureIDs.TIME_CONFIGURATION).concept(() -> ApplicationModelDefinition.Groups.TIME_CONFIGURATION).build();
    Relation<ApplicationExtensionPkg, ApplicationExtensionPkg, Listener<ApplicationExtensionPkg>, Features<?>> EXTENSION_PKG = new RelationBuilder<ApplicationExtensionPkg, ApplicationExtensionPkg, Listener<ApplicationExtensionPkg>, Features<?>>().name("extensionPkg").contains(true).id(Application.FeatureIDs.EXTENSION_PKG).concept(() -> ApplicationModelDefinition.Groups.APPLICATION_EXTENSION_PKG).build();
    Relation<IModel, List<IModel>, Listener<List<IModel>>, Features<?>> MODELS = new RelationBuilder<IModel, List<IModel>, Listener<List<IModel>>, Features<?>>().name("models").many(true).contains(true).id(Application.FeatureIDs.MODELS).concept(() -> ApplicationModelDefinition.Groups.I_MODEL).build();
    Relation<ResourcePkg, ResourcePkg, Listener<ResourcePkg>, Features<?>> RESOURCE_PKG = new RelationBuilder<ResourcePkg, ResourcePkg, Listener<ResourcePkg>, Features<?>>().name("resourcePkg").contains(true).id(Application.FeatureIDs.RESOURCE_PKG).concept(() -> ResourceModelDefinition.Groups.RESOURCE_PKG).build();
    Attribute<String, String, Listener<String>, Features<?>> VERSION = new AttributeBuilder<String, String, Listener<String>, Features<?>>().name("version").mandatory(true).defaultValue("0.0.0").id(Application.FeatureIDs.VERSION).datatype(() -> LMCoreModelDefinition.Units.STRING).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, DOMAIN, IMPORTS, METAMODELS, ENGINES, RUN, TITLE, SCENE, TIME_CONFIGURATION, EXTENSION_PKG, MODELS, RESOURCE_PKG, VERSION);
  }

  interface Builder extends IFeaturedObject.Builder<Application> {
    Builder name(String name);
    Builder domain(String domain);
    Builder addImport(String import_);
    Builder addMetamodel(String metamodel);
    Builder addEngine(Supplier<IEngine> engine);
    Builder run(boolean run);
    Builder title(String title);
    Builder scene(Supplier<Scene> scene);
    Builder timeConfiguration(Supplier<TimeConfiguration> timeConfiguration);
    Builder extensionPkg(Supplier<ApplicationExtensionPkg> extensionPkg);
    Builder addModel(Supplier<IModel> model);
    Builder resourcePkg(Supplier<ResourcePkg> resourcePkg);
    Builder version(String version);
    Builder addEngines(List<IEngine> engines);
    Builder addModels(List<IModel> models);
    Builder addImports(List<String> imports);
    Builder addMetamodels(List<String> metamodels);
  }
}
