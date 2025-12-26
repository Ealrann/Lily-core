package org.sheepy.lily.core.model.ui;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.BooleanListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.core.model.application.CompositorExtensionPkg;
import org.sheepy.lily.core.model.application.ICompositor;
import org.sheepy.lily.core.model.resource.IImage;
import org.sheepy.lily.core.model.resource.ResourceModelDefinition;
import org.sheepy.lily.core.model.ui.builder.UIBuilder;

public interface UI extends ICompositor {
  static Builder builder() {
    return new UIBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<UIPage> uiPages();
  UIPage currentUIPage();
  FontPkg fontPkg();
  IImage dstImage();
  List<IImage> images();
  void currentUIPage(final UIPage currentUIPage);
  void fontPkg(final FontPkg fontPkg);
  void dstImage(final IImage dstImage);

  interface FeatureIDs {
    int EXTENSION_PKG = ICompositor.FeatureIDs.EXTENSION_PKG;
    int ENABLED = ICompositor.FeatureIDs.ENABLED;
    int UI_PAGES = -946528530;
    int CURRENTUI_PAGE = 195930330;
    int FONT_PKG = -1174157221;
    int DST_IMAGE = -1841823496;
    int IMAGES = -1339708070;
  }

  interface Features<T extends Features<T>> extends ICompositor.Features<T> {
    Relation<CompositorExtensionPkg, CompositorExtensionPkg, Listener<CompositorExtensionPkg>, ICompositor.Features<?>> EXTENSION_PKG = ICompositor.Features.EXTENSION_PKG;
    Attribute<Boolean, Boolean, BooleanListener, ICompositor.Features<?>> ENABLED = ICompositor.Features.ENABLED;
    Relation<UIPage, List<UIPage>, Listener<List<UIPage>>, Features<?>> UI_PAGES = new RelationBuilder<UIPage, List<UIPage>, Listener<List<UIPage>>, Features<?>>().name("uiPages").many(true).contains(true).id(UI.FeatureIDs.UI_PAGES).concept(() -> UIModelDefinition.Groups.UI_PAGE).build();
    Relation<UIPage, UIPage, Listener<UIPage>, Features<?>> CURRENTUI_PAGE = new RelationBuilder<UIPage, UIPage, Listener<UIPage>, Features<?>>().name("currentUIPage").id(UI.FeatureIDs.CURRENTUI_PAGE).concept(() -> UIModelDefinition.Groups.UI_PAGE).build();
    Relation<FontPkg, FontPkg, Listener<FontPkg>, Features<?>> FONT_PKG = new RelationBuilder<FontPkg, FontPkg, Listener<FontPkg>, Features<?>>().name("fontPkg").mandatory(true).contains(true).id(UI.FeatureIDs.FONT_PKG).concept(() -> UIModelDefinition.Groups.FONT_PKG).build();
    Relation<IImage, IImage, Listener<IImage>, Features<?>> DST_IMAGE = new RelationBuilder<IImage, IImage, Listener<IImage>, Features<?>>().name("dstImage").id(UI.FeatureIDs.DST_IMAGE).concept(() -> ResourceModelDefinition.Groups.I_IMAGE).build();
    Relation<IImage, List<IImage>, Listener<List<IImage>>, Features<?>> IMAGES = new RelationBuilder<IImage, List<IImage>, Listener<List<IImage>>, Features<?>>().name("images").many(true).id(UI.FeatureIDs.IMAGES).concept(() -> ResourceModelDefinition.Groups.I_IMAGE).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(EXTENSION_PKG, ENABLED, UI_PAGES, CURRENTUI_PAGE, FONT_PKG, DST_IMAGE, IMAGES);
  }

  interface Builder extends IFeaturedObject.Builder<UI> {
    Builder extensionPkg(Supplier<CompositorExtensionPkg> extensionPkg);
    Builder enabled(boolean enabled);
    Builder addUiPage(Supplier<UIPage> uiPage);
    Builder currentUIPage(Supplier<UIPage> currentUIPage);
    Builder fontPkg(Supplier<FontPkg> fontPkg);
    Builder dstImage(Supplier<IImage> dstImage);
    Builder addImage(Supplier<IImage> image);
    Builder addUiPages(List<UIPage> uiPages);
    Builder addImages(List<IImage> images);
  }
}
