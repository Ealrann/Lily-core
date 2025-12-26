package org.sheepy.lily.core.model.application.impl;

import org.joml.Vector3ic;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.application.ApplicationModelDefinition;
import org.sheepy.lily.core.model.application.BackgroundImage;
import org.sheepy.lily.core.model.application.CompositorExtensionPkg;
import org.sheepy.lily.core.model.application.ICompositor;
import org.sheepy.lily.core.model.resource.ESampling;
import org.sheepy.lily.core.model.resource.IImage;

public final class BackgroundImageImpl extends FeaturedObject<BackgroundImage.Features<?>> implements BackgroundImage {
  private static final int FEATURE_COUNT = 7;
  private final ModelNotifier<BackgroundImage.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private CompositorExtensionPkg extensionPkg;
  private boolean enabled;
  private final String name;
  private Vector3ic clearColor;
  private ESampling sampling;
  private IImage srcImage;
  private IImage dstImage;

  public BackgroundImageImpl(final boolean enabled, final String name, final Vector3ic clearColor,
      final ESampling sampling) {
    this.enabled = enabled;
    this.name = name;
    this.clearColor = clearColor;
    this.sampling = sampling;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<BackgroundImage.Features<?>> notifier() {
    return notifier;
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
  public String name() {
    return name;
  }

  @Override
  public Vector3ic clearColor() {
    return clearColor;
  }

  @Override
  public void clearColor(final Vector3ic clearColor) {
    final var oldValue = this.clearColor;
    this.clearColor = clearColor;
    notifier.notify(BackgroundImage.FeatureIDs.CLEAR_COLOR, false, false, oldValue, clearColor);
  }

  @Override
  public ESampling sampling() {
    return sampling;
  }

  @Override
  public void sampling(final ESampling sampling) {
    final var oldValue = this.sampling;
    this.sampling = sampling;
    notifier.notify(BackgroundImage.FeatureIDs.SAMPLING, false, false, oldValue, sampling);
  }

  @Override
  public IImage srcImage() {
    return srcImage;
  }

  @Override
  public void srcImage(final IImage srcImage) {
    final var oldValue = this.srcImage;
    final var eventType = srcImage == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.srcImage = srcImage;
    notifier.notify(BackgroundImage.FeatureIDs.SRC_IMAGE, false, false, eventType, oldValue, srcImage);
  }

  @Override
  public IImage dstImage() {
    return dstImage;
  }

  @Override
  public void dstImage(final IImage dstImage) {
    final var oldValue = this.dstImage;
    final var eventType = dstImage == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.dstImage = dstImage;
    notifier.notify(BackgroundImage.FeatureIDs.DST_IMAGE, false, false, eventType, oldValue, dstImage);
  }

  @Override
  public Group<BackgroundImage> lmGroup() {
    return ApplicationModelDefinition.Groups.BACKGROUND_IMAGE;
  }

  @Override
  protected FeatureSetter<BackgroundImage> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<BackgroundImage> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case BackgroundImage.FeatureIDs.EXTENSION_PKG -> 0;
      case BackgroundImage.FeatureIDs.ENABLED -> 1;
      case BackgroundImage.FeatureIDs.NAME -> 2;
      case BackgroundImage.FeatureIDs.CLEAR_COLOR -> 3;
      case BackgroundImage.FeatureIDs.SAMPLING -> 4;
      case BackgroundImage.FeatureIDs.SRC_IMAGE -> 5;
      case BackgroundImage.FeatureIDs.DST_IMAGE -> 6;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<BackgroundImage> GET_MAP = new FeatureGetter.Builder<BackgroundImage>(FEATURE_COUNT, BackgroundImageImpl::featureIndexStatic).add(BackgroundImage.FeatureIDs.EXTENSION_PKG, BackgroundImage::extensionPkg).add(BackgroundImage.FeatureIDs.ENABLED, BackgroundImage::enabled).add(BackgroundImage.FeatureIDs.NAME, BackgroundImage::name).add(BackgroundImage.FeatureIDs.CLEAR_COLOR, BackgroundImage::clearColor).add(BackgroundImage.FeatureIDs.SAMPLING, BackgroundImage::sampling).add(BackgroundImage.FeatureIDs.SRC_IMAGE, BackgroundImage::srcImage).add(BackgroundImage.FeatureIDs.DST_IMAGE, BackgroundImage::dstImage).build();
    private static final FeatureSetter<BackgroundImage> SET_MAP = new FeatureSetter.Builder<BackgroundImage>(FEATURE_COUNT, BackgroundImageImpl::featureIndexStatic).add(BackgroundImage.FeatureIDs.EXTENSION_PKG, (object, value) -> ((BackgroundImageImpl) object).extensionPkg((CompositorExtensionPkg) value)).add(BackgroundImage.FeatureIDs.ENABLED, (object, value) -> ((BackgroundImageImpl) object).enabled((boolean) value)).add(BackgroundImage.FeatureIDs.CLEAR_COLOR, (object, value) -> ((BackgroundImageImpl) object).clearColor((Vector3ic) value)).add(BackgroundImage.FeatureIDs.SAMPLING, (object, value) -> ((BackgroundImageImpl) object).sampling((ESampling) value)).add(BackgroundImage.FeatureIDs.SRC_IMAGE, (object, value) -> ((BackgroundImageImpl) object).srcImage((IImage) value)).add(BackgroundImage.FeatureIDs.DST_IMAGE, (object, value) -> ((BackgroundImageImpl) object).dstImage((IImage) value)).build();
  }
}
