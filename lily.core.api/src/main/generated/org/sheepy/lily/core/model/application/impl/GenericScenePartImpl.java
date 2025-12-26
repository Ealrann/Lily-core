package org.sheepy.lily.core.model.application.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.application.ApplicationModelDefinition;
import org.sheepy.lily.core.model.application.CompositorExtensionPkg;
import org.sheepy.lily.core.model.application.GenericScenePart;
import org.sheepy.lily.core.model.application.ICompositor;

public final class GenericScenePartImpl extends FeaturedObject<GenericScenePart.Features<?>> implements GenericScenePart {
  private static final int FEATURE_COUNT = 3;
  private final ModelNotifier<GenericScenePart.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private CompositorExtensionPkg extensionPkg;
  private boolean enabled;

  public GenericScenePartImpl(final String name, final boolean enabled) {
    this.name = name;
    this.enabled = enabled;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<GenericScenePart.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public CompositorExtensionPkg extensionPkg() {
    return extensionPkg;
  }

  @Override
  public void extensionPkg(final CompositorExtensionPkg extensionPkg) {
    final var oldValue = this.extensionPkg;
    final var eventType = extensionPkg == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.extensionPkg = extensionPkg;
    setContainer(extensionPkg, ICompositor.FeatureIDs.EXTENSION_PKG);
    beforeContainmentNotify(eventType, oldValue, extensionPkg);
    notifier.notify(ICompositor.FeatureIDs.EXTENSION_PKG, true, false, eventType, oldValue, extensionPkg);
    afterContainmentNotify(eventType, oldValue, extensionPkg);
  }

  @Override
  public boolean enabled() {
    return enabled;
  }

  @Override
  public void enabled(final boolean enabled) {
    final var oldValue = this.enabled;
    this.enabled = enabled;
    notifier.notifyBoolean(ICompositor.FeatureIDs.ENABLED, false, false, oldValue, enabled);
  }

  @Override
  public Group<GenericScenePart> lmGroup() {
    return ApplicationModelDefinition.Groups.GENERIC_SCENE_PART;
  }

  @Override
  protected FeatureSetter<GenericScenePart> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<GenericScenePart> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case GenericScenePart.FeatureIDs.NAME -> 0;
      case GenericScenePart.FeatureIDs.EXTENSION_PKG -> 1;
      case GenericScenePart.FeatureIDs.ENABLED -> 2;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<GenericScenePart> GET_MAP = new FeatureGetter.Builder<GenericScenePart>(FEATURE_COUNT, GenericScenePartImpl::featureIndexStatic).add(GenericScenePart.FeatureIDs.NAME, GenericScenePart::name).add(GenericScenePart.FeatureIDs.EXTENSION_PKG, GenericScenePart::extensionPkg).add(GenericScenePart.FeatureIDs.ENABLED, GenericScenePart::enabled).build();
    private static final FeatureSetter<GenericScenePart> SET_MAP = new FeatureSetter.Builder<GenericScenePart>(FEATURE_COUNT, GenericScenePartImpl::featureIndexStatic).add(GenericScenePart.FeatureIDs.EXTENSION_PKG, (object, value) -> ((GenericScenePartImpl) object).extensionPkg((CompositorExtensionPkg) value)).add(GenericScenePart.FeatureIDs.ENABLED, (object, value) -> ((GenericScenePartImpl) object).enabled((boolean) value)).build();
  }
}
