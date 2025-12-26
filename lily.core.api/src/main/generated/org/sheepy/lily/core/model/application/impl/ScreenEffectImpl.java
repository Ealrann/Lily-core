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
import org.sheepy.lily.core.model.application.ICompositor;
import org.sheepy.lily.core.model.application.ScreenEffect;
import org.sheepy.lily.core.model.application.SpecialEffect;
import org.sheepy.lily.core.model.resource.IImage;

public final class ScreenEffectImpl extends FeaturedObject<ScreenEffect.Features<?>> implements ScreenEffect {
  private static final int FEATURE_COUNT = 6;
  private final ModelNotifier<ScreenEffect.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private CompositorExtensionPkg extensionPkg;
  private boolean enabled;
  private final String name;
  private IImage srcImage;
  private IImage dstImage;
  private SpecialEffect effect;

  public ScreenEffectImpl(final boolean enabled, final String name, final IImage dstImage,
      final SpecialEffect effect) {
    this.enabled = enabled;
    this.name = name;
    this.dstImage = dstImage;
    this.effect = effect;
    setContainer(effect, ScreenEffect.FeatureIDs.EFFECT);
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<ScreenEffect.Features<?>> notifier() {
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
  public IImage srcImage() {
    return srcImage;
  }

  @Override
  public void srcImage(final IImage srcImage) {
    final var oldValue = this.srcImage;
    final var eventType = srcImage == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.srcImage = srcImage;
    notifier.notify(ScreenEffect.FeatureIDs.SRC_IMAGE, false, false, eventType, oldValue, srcImage);
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
    notifier.notify(ScreenEffect.FeatureIDs.DST_IMAGE, false, false, eventType, oldValue, dstImage);
  }

  @Override
  public SpecialEffect effect() {
    return effect;
  }

  @Override
  public void effect(final SpecialEffect effect) {
    final var oldValue = this.effect;
    final var eventType = effect == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.effect = effect;
    setContainer(effect, ScreenEffect.FeatureIDs.EFFECT);
    beforeContainmentNotify(eventType, oldValue, effect);
    notifier.notify(ScreenEffect.FeatureIDs.EFFECT, true, false, eventType, oldValue, effect);
    afterContainmentNotify(eventType, oldValue, effect);
  }

  @Override
  public Group<ScreenEffect> lmGroup() {
    return ApplicationModelDefinition.Groups.SCREEN_EFFECT;
  }

  @Override
  protected FeatureSetter<ScreenEffect> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<ScreenEffect> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case ScreenEffect.FeatureIDs.EXTENSION_PKG -> 0;
      case ScreenEffect.FeatureIDs.ENABLED -> 1;
      case ScreenEffect.FeatureIDs.NAME -> 2;
      case ScreenEffect.FeatureIDs.SRC_IMAGE -> 3;
      case ScreenEffect.FeatureIDs.DST_IMAGE -> 4;
      case ScreenEffect.FeatureIDs.EFFECT -> 5;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<ScreenEffect> GET_MAP = new FeatureGetter.Builder<ScreenEffect>(FEATURE_COUNT, ScreenEffectImpl::featureIndexStatic).add(ScreenEffect.FeatureIDs.EXTENSION_PKG, ScreenEffect::extensionPkg).add(ScreenEffect.FeatureIDs.ENABLED, ScreenEffect::enabled).add(ScreenEffect.FeatureIDs.NAME, ScreenEffect::name).add(ScreenEffect.FeatureIDs.SRC_IMAGE, ScreenEffect::srcImage).add(ScreenEffect.FeatureIDs.DST_IMAGE, ScreenEffect::dstImage).add(ScreenEffect.FeatureIDs.EFFECT, ScreenEffect::effect).build();
    private static final FeatureSetter<ScreenEffect> SET_MAP = new FeatureSetter.Builder<ScreenEffect>(FEATURE_COUNT, ScreenEffectImpl::featureIndexStatic).add(ScreenEffect.FeatureIDs.EXTENSION_PKG, (object, value) -> ((ScreenEffectImpl) object).extensionPkg((CompositorExtensionPkg) value)).add(ScreenEffect.FeatureIDs.ENABLED, (object, value) -> ((ScreenEffectImpl) object).enabled((boolean) value)).add(ScreenEffect.FeatureIDs.SRC_IMAGE, (object, value) -> ((ScreenEffectImpl) object).srcImage((IImage) value)).add(ScreenEffect.FeatureIDs.DST_IMAGE, (object, value) -> ((ScreenEffectImpl) object).dstImage((IImage) value)).add(ScreenEffect.FeatureIDs.EFFECT, (object, value) -> ((ScreenEffectImpl) object).effect((SpecialEffect) value)).build();
  }
}
