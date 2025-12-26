package org.sheepy.lily.core.model.ui.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.application.CompositorExtensionPkg;
import org.sheepy.lily.core.model.application.ICompositor;
import org.sheepy.lily.core.model.resource.IImage;
import org.sheepy.lily.core.model.ui.FontPkg;
import org.sheepy.lily.core.model.ui.UI;
import org.sheepy.lily.core.model.ui.UIModelDefinition;
import org.sheepy.lily.core.model.ui.UIPage;

public final class UIImpl extends FeaturedObject<UI.Features<?>> implements UI {
  private static final int FEATURE_COUNT = 7;
  private final ModelNotifier<UI.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private CompositorExtensionPkg extensionPkg;
  private boolean enabled;
  private final List<UIPage> uiPages = newObservableList(UI.FeatureIDs.UI_PAGES, true, true);
  private UIPage currentUIPage;
  private FontPkg fontPkg;
  private IImage dstImage;
  private final List<IImage> images = newObservableList(UI.FeatureIDs.IMAGES, true, false);

  public UIImpl(final boolean enabled, final FontPkg fontPkg) {
    this.enabled = enabled;
    this.fontPkg = fontPkg;
    setContainer(fontPkg, UI.FeatureIDs.FONT_PKG);
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<UI.Features<?>> notifier() {
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
  public List<UIPage> uiPages() {
    return uiPages;
  }

  @Override
  public UIPage currentUIPage() {
    return currentUIPage;
  }

  @Override
  public void currentUIPage(final UIPage currentUIPage) {
    final var oldValue = this.currentUIPage;
    final var eventType = currentUIPage == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.currentUIPage = currentUIPage;
    notifier.notify(UI.FeatureIDs.CURRENTUI_PAGE, false, false, eventType, oldValue, currentUIPage);
  }

  @Override
  public FontPkg fontPkg() {
    return fontPkg;
  }

  @Override
  public void fontPkg(final FontPkg fontPkg) {
    final var oldValue = this.fontPkg;
    final var eventType = fontPkg == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.fontPkg = fontPkg;
    setContainer(fontPkg, UI.FeatureIDs.FONT_PKG);
    beforeContainmentNotify(eventType, oldValue, fontPkg);
    notifier.notify(UI.FeatureIDs.FONT_PKG, true, false, eventType, oldValue, fontPkg);
    afterContainmentNotify(eventType, oldValue, fontPkg);
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
    notifier.notify(UI.FeatureIDs.DST_IMAGE, false, false, eventType, oldValue, dstImage);
  }

  @Override
  public List<IImage> images() {
    return images;
  }

  @Override
  public Group<UI> lmGroup() {
    return UIModelDefinition.Groups.UI;
  }

  @Override
  protected FeatureSetter<UI> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<UI> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case UI.FeatureIDs.EXTENSION_PKG -> 0;
      case UI.FeatureIDs.ENABLED -> 1;
      case UI.FeatureIDs.UI_PAGES -> 2;
      case UI.FeatureIDs.CURRENTUI_PAGE -> 3;
      case UI.FeatureIDs.FONT_PKG -> 4;
      case UI.FeatureIDs.DST_IMAGE -> 5;
      case UI.FeatureIDs.IMAGES -> 6;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<UI> GET_MAP = new FeatureGetter.Builder<UI>(FEATURE_COUNT, UIImpl::featureIndexStatic).add(UI.FeatureIDs.EXTENSION_PKG, UI::extensionPkg).add(UI.FeatureIDs.ENABLED, UI::enabled).add(UI.FeatureIDs.UI_PAGES, UI::uiPages).add(UI.FeatureIDs.CURRENTUI_PAGE, UI::currentUIPage).add(UI.FeatureIDs.FONT_PKG, UI::fontPkg).add(UI.FeatureIDs.DST_IMAGE, UI::dstImage).add(UI.FeatureIDs.IMAGES, UI::images).build();
    private static final FeatureSetter<UI> SET_MAP = new FeatureSetter.Builder<UI>(FEATURE_COUNT, UIImpl::featureIndexStatic).add(UI.FeatureIDs.EXTENSION_PKG, (object, value) -> ((UIImpl) object).extensionPkg((CompositorExtensionPkg) value)).add(UI.FeatureIDs.ENABLED, (object, value) -> ((UIImpl) object).enabled((boolean) value)).add(UI.FeatureIDs.CURRENTUI_PAGE, (object, value) -> ((UIImpl) object).currentUIPage((UIPage) value)).add(UI.FeatureIDs.FONT_PKG, (object, value) -> ((UIImpl) object).fontPkg((FontPkg) value)).add(UI.FeatureIDs.DST_IMAGE, (object, value) -> ((UIImpl) object).dstImage((IImage) value)).build();
  }
}
