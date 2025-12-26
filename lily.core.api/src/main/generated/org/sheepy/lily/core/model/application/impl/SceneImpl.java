package org.sheepy.lily.core.model.application.impl;

import java.util.List;
import org.joml.Vector2ic;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.application.ApplicationModelDefinition;
import org.sheepy.lily.core.model.application.ICompositor;
import org.sheepy.lily.core.model.application.Scene;
import org.sheepy.lily.core.model.resource.ResourcePkg;

public final class SceneImpl extends FeaturedObject<Scene.Features<?>> implements Scene {
  private static final int FEATURE_COUNT = 5;
  private final ModelNotifier<Scene.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final List<ICompositor> compositors = newObservableList(Scene.FeatureIDs.COMPOSITORS, true, true);
  private boolean fullscreen;
  private boolean resizeable;
  private Vector2ic size;
  private ResourcePkg resourcePkg;

  public SceneImpl() {
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<Scene.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public List<ICompositor> compositors() {
    return compositors;
  }

  @Override
  public boolean fullscreen() {
    return fullscreen;
  }

  @Override
  public void fullscreen(final boolean fullscreen) {
    final var oldValue = this.fullscreen;
    this.fullscreen = fullscreen;
    notifier.notifyBoolean(Scene.FeatureIDs.FULLSCREEN, false, false, oldValue, fullscreen);
  }

  @Override
  public boolean resizeable() {
    return resizeable;
  }

  @Override
  public void resizeable(final boolean resizeable) {
    final var oldValue = this.resizeable;
    this.resizeable = resizeable;
    notifier.notifyBoolean(Scene.FeatureIDs.RESIZEABLE, false, false, oldValue, resizeable);
  }

  @Override
  public Vector2ic size() {
    return size;
  }

  @Override
  public void size(final Vector2ic size) {
    final var oldValue = this.size;
    this.size = size;
    notifier.notify(Scene.FeatureIDs.SIZE, false, false, oldValue, size);
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
    setContainer(resourcePkg, Scene.FeatureIDs.RESOURCE_PKG);
    beforeContainmentNotify(eventType, oldValue, resourcePkg);
    notifier.notify(Scene.FeatureIDs.RESOURCE_PKG, true, false, eventType, oldValue, resourcePkg);
    afterContainmentNotify(eventType, oldValue, resourcePkg);
  }

  @Override
  public Group<Scene> lmGroup() {
    return ApplicationModelDefinition.Groups.SCENE;
  }

  @Override
  protected FeatureSetter<Scene> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<Scene> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case Scene.FeatureIDs.COMPOSITORS -> 0;
      case Scene.FeatureIDs.FULLSCREEN -> 1;
      case Scene.FeatureIDs.RESIZEABLE -> 2;
      case Scene.FeatureIDs.SIZE -> 3;
      case Scene.FeatureIDs.RESOURCE_PKG -> 4;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<Scene> GET_MAP = new FeatureGetter.Builder<Scene>(FEATURE_COUNT, SceneImpl::featureIndexStatic).add(Scene.FeatureIDs.COMPOSITORS, Scene::compositors).add(Scene.FeatureIDs.FULLSCREEN, Scene::fullscreen).add(Scene.FeatureIDs.RESIZEABLE, Scene::resizeable).add(Scene.FeatureIDs.SIZE, Scene::size).add(Scene.FeatureIDs.RESOURCE_PKG, Scene::resourcePkg).build();
    private static final FeatureSetter<Scene> SET_MAP = new FeatureSetter.Builder<Scene>(FEATURE_COUNT, SceneImpl::featureIndexStatic).add(Scene.FeatureIDs.FULLSCREEN, (object, value) -> ((SceneImpl) object).fullscreen((boolean) value)).add(Scene.FeatureIDs.RESIZEABLE, (object, value) -> ((SceneImpl) object).resizeable((boolean) value)).add(Scene.FeatureIDs.SIZE, (object, value) -> ((SceneImpl) object).size((Vector2ic) value)).add(Scene.FeatureIDs.RESOURCE_PKG, (object, value) -> ((SceneImpl) object).resourcePkg((ResourcePkg) value)).build();
  }
}
