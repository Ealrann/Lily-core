package org.sheepy.lily.core.model.application.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.core.model.application.ApplicationExtensionPkg;
import org.sheepy.lily.core.model.application.ApplicationModelDefinition;
import org.sheepy.lily.core.model.application.IEngine;
import org.sheepy.lily.core.model.application.IModel;
import org.sheepy.lily.core.model.application.Scene;
import org.sheepy.lily.core.model.application.TimeConfiguration;
import org.sheepy.lily.core.model.resource.ResourcePkg;

public final class ApplicationImpl extends FeaturedObject<Application.Features<?>> implements Application {
  private static final int FEATURE_COUNT = 13;
  private final ModelNotifier<Application.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private final String domain;
  private final List<String> imports;
  private final List<String> metamodels;
  private final List<IEngine> engines = newObservableList(Application.FeatureIDs.ENGINES, true, true);
  private boolean run;
  private String title;
  private Scene scene;
  private TimeConfiguration timeConfiguration;
  private ApplicationExtensionPkg extensionPkg;
  private final List<IModel> models = newObservableList(Application.FeatureIDs.MODELS, true, true);
  private ResourcePkg resourcePkg;
  private String version;

  public ApplicationImpl(final String name, final String domain, final List<String> imports,
      final List<String> metamodels, final String version) {
    this.name = name;
    this.domain = domain;
    this.imports = List.copyOf(imports);
    this.metamodels = List.copyOf(metamodels);
    this.version = version;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<Application.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public String domain() {
    return domain;
  }

  @Override
  public List<String> imports() {
    return imports;
  }

  @Override
  public List<String> metamodels() {
    return metamodels;
  }

  @Override
  public List<IEngine> engines() {
    return engines;
  }

  @Override
  public boolean run() {
    return run;
  }

  @Override
  public void run(final boolean run) {
    final var oldValue = this.run;
    this.run = run;
    notifier.notifyBoolean(Application.FeatureIDs.RUN, false, false, oldValue, run);
  }

  @Override
  public String title() {
    return title;
  }

  @Override
  public void title(final String title) {
    final var oldValue = this.title;
    this.title = title;
    notifier.notify(Application.FeatureIDs.TITLE, false, false, oldValue, title);
  }

  @Override
  public Scene scene() {
    return scene;
  }

  @Override
  public void scene(final Scene scene) {
    final var oldValue = this.scene;
    final var eventType = scene == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.scene = scene;
    setContainer(scene, Application.FeatureIDs.SCENE);
    beforeContainmentNotify(eventType, oldValue, scene);
    notifier.notify(Application.FeatureIDs.SCENE, true, false, eventType, oldValue, scene);
    afterContainmentNotify(eventType, oldValue, scene);
  }

  @Override
  public TimeConfiguration timeConfiguration() {
    return timeConfiguration;
  }

  @Override
  public void timeConfiguration(final TimeConfiguration timeConfiguration) {
    final var oldValue = this.timeConfiguration;
    final var eventType = timeConfiguration == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.timeConfiguration = timeConfiguration;
    setContainer(timeConfiguration, Application.FeatureIDs.TIME_CONFIGURATION);
    beforeContainmentNotify(eventType, oldValue, timeConfiguration);
    notifier.notify(Application.FeatureIDs.TIME_CONFIGURATION, true, false, eventType, oldValue, timeConfiguration);
    afterContainmentNotify(eventType, oldValue, timeConfiguration);
  }

  @Override
  public ApplicationExtensionPkg extensionPkg() {
    return extensionPkg;
  }

  @Override
  public void extensionPkg(final ApplicationExtensionPkg extensionPkg) {
    final var oldValue = this.extensionPkg;
    final var eventType = extensionPkg == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.extensionPkg = extensionPkg;
    setContainer(extensionPkg, Application.FeatureIDs.EXTENSION_PKG);
    beforeContainmentNotify(eventType, oldValue, extensionPkg);
    notifier.notify(Application.FeatureIDs.EXTENSION_PKG, true, false, eventType, oldValue, extensionPkg);
    afterContainmentNotify(eventType, oldValue, extensionPkg);
  }

  @Override
  public List<IModel> models() {
    return models;
  }

  @Override
  public ResourcePkg resourcePkg() {
    return resourcePkg;
  }

  @Override
  public void resourcePkg(final ResourcePkg resourcePkg) {
    final var oldValue = this.resourcePkg;
    final var eventType = resourcePkg == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.resourcePkg = resourcePkg;
    setContainer(resourcePkg, Application.FeatureIDs.RESOURCE_PKG);
    beforeContainmentNotify(eventType, oldValue, resourcePkg);
    notifier.notify(Application.FeatureIDs.RESOURCE_PKG, true, false, eventType, oldValue, resourcePkg);
    afterContainmentNotify(eventType, oldValue, resourcePkg);
  }

  @Override
  public String version() {
    return version;
  }

  @Override
  public void version(final String version) {
    final var oldValue = this.version;
    this.version = version;
    notifier.notify(Application.FeatureIDs.VERSION, false, false, oldValue, version);
  }

  @Override
  public Group<Application> lmGroup() {
    return ApplicationModelDefinition.Groups.APPLICATION;
  }

  @Override
  protected FeatureSetter<Application> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<Application> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case Application.FeatureIDs.NAME -> 0;
      case Application.FeatureIDs.DOMAIN -> 1;
      case Application.FeatureIDs.IMPORTS -> 2;
      case Application.FeatureIDs.METAMODELS -> 3;
      case Application.FeatureIDs.ENGINES -> 4;
      case Application.FeatureIDs.RUN -> 5;
      case Application.FeatureIDs.TITLE -> 6;
      case Application.FeatureIDs.SCENE -> 7;
      case Application.FeatureIDs.TIME_CONFIGURATION -> 8;
      case Application.FeatureIDs.EXTENSION_PKG -> 9;
      case Application.FeatureIDs.MODELS -> 10;
      case Application.FeatureIDs.RESOURCE_PKG -> 11;
      case Application.FeatureIDs.VERSION -> 12;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<Application> GET_MAP = new FeatureGetter.Builder<Application>(FEATURE_COUNT, ApplicationImpl::featureIndexStatic).add(Application.FeatureIDs.NAME, Application::name).add(Application.FeatureIDs.DOMAIN, Application::domain).add(Application.FeatureIDs.IMPORTS, Application::imports).add(Application.FeatureIDs.METAMODELS, Application::metamodels).add(Application.FeatureIDs.ENGINES, Application::engines).add(Application.FeatureIDs.RUN, Application::run).add(Application.FeatureIDs.TITLE, Application::title).add(Application.FeatureIDs.SCENE, Application::scene).add(Application.FeatureIDs.TIME_CONFIGURATION, Application::timeConfiguration).add(Application.FeatureIDs.EXTENSION_PKG, Application::extensionPkg).add(Application.FeatureIDs.MODELS, Application::models).add(Application.FeatureIDs.RESOURCE_PKG, Application::resourcePkg).add(Application.FeatureIDs.VERSION, Application::version).build();
    private static final FeatureSetter<Application> SET_MAP = new FeatureSetter.Builder<Application>(FEATURE_COUNT, ApplicationImpl::featureIndexStatic).add(Application.FeatureIDs.RUN, (object, value) -> ((ApplicationImpl) object).run((boolean) value)).add(Application.FeatureIDs.TITLE, (object, value) -> ((ApplicationImpl) object).title((String) value)).add(Application.FeatureIDs.SCENE, (object, value) -> ((ApplicationImpl) object).scene((Scene) value)).add(Application.FeatureIDs.TIME_CONFIGURATION, (object, value) -> ((ApplicationImpl) object).timeConfiguration((TimeConfiguration) value)).add(Application.FeatureIDs.EXTENSION_PKG, (object, value) -> ((ApplicationImpl) object).extensionPkg((ApplicationExtensionPkg) value)).add(Application.FeatureIDs.RESOURCE_PKG, (object, value) -> ((ApplicationImpl) object).resourcePkg((ResourcePkg) value)).add(Application.FeatureIDs.VERSION, (object, value) -> ((ApplicationImpl) object).version((String) value)).build();
  }
}
