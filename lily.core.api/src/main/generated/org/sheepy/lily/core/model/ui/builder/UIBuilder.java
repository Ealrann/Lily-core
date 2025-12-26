package org.sheepy.lily.core.model.ui.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.util.BuildUtils;
import org.sheepy.lily.core.model.application.CompositorExtensionPkg;
import org.sheepy.lily.core.model.resource.IImage;
import org.sheepy.lily.core.model.ui.FontPkg;
import org.sheepy.lily.core.model.ui.UI;
import org.sheepy.lily.core.model.ui.UI.Builder;
import org.sheepy.lily.core.model.ui.UIPage;
import org.sheepy.lily.core.model.ui.impl.UIImpl;

public final class UIBuilder implements Builder {
  private Supplier<CompositorExtensionPkg> extensionPkg = () -> null;
  private boolean enabled = true;
  private final List<Supplier<UIPage>> uiPages = new ArrayList<>();
  private Supplier<UIPage> currentUIPage = () -> null;
  private Supplier<FontPkg> fontPkg;
  private Supplier<IImage> dstImage = () -> null;
  private final List<Supplier<IImage>> images = new ArrayList<>();

  public UIBuilder() {
  }

  @Override
  public UIBuilder extensionPkg(Supplier<CompositorExtensionPkg> extensionPkg) {
    this.extensionPkg = extensionPkg;
    return this;
  }

  @Override
  public UIBuilder enabled(boolean enabled) {
    this.enabled = enabled;
    return this;
  }

  @Override
  public UIBuilder addUiPage(Supplier<UIPage> uiPage) {
    this.uiPages.add(uiPage);
    return this;
  }

  @Override
  public UIBuilder addUiPages(final List<UIPage> uiPages) {
    uiPages.forEach(value -> this.uiPages.add(() -> value));
    return this;
  }

  @Override
  public UIBuilder currentUIPage(Supplier<UIPage> currentUIPage) {
    this.currentUIPage = currentUIPage;
    return this;
  }

  @Override
  public UIBuilder fontPkg(Supplier<FontPkg> fontPkg) {
    this.fontPkg = fontPkg;
    return this;
  }

  @Override
  public UIBuilder dstImage(Supplier<IImage> dstImage) {
    this.dstImage = dstImage;
    return this;
  }

  @Override
  public UIBuilder addImage(Supplier<IImage> image) {
    this.images.add(image);
    return this;
  }

  @Override
  public UIBuilder addImages(final List<IImage> images) {
    images.forEach(value -> this.images.add(() -> value));
    return this;
  }

  @Override
  public UI build() {
    final var builtUiPages = BuildUtils.collectSuppliers(uiPages);
    final var builtImages = BuildUtils.collectSuppliers(images);
    final var built = new UIImpl(enabled, fontPkg.get());
    built.extensionPkg(extensionPkg.get());
    built.uiPages().addAll(builtUiPages);
    built.currentUIPage(currentUIPage.get());
    built.dstImage(dstImage.get());
    built.images().addAll(builtImages);
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
    private static final FeatureInserter<UIBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<UIBuilder>(1, Inserters::attributeIndex).add(UI.FeatureIDs.ENABLED, (builder, value) -> builder.enabled((boolean) value)).build();
    private static final RelationLazyInserter<UIBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<UIBuilder>(6, Inserters::relationIndex).add(UI.FeatureIDs.EXTENSION_PKG, (builder, value) -> builder.extensionPkg((Supplier<CompositorExtensionPkg>) value)).add(UI.FeatureIDs.UI_PAGES, (builder, value) -> builder.addUiPage((Supplier<UIPage>) value)).add(UI.FeatureIDs.CURRENTUI_PAGE, (builder, value) -> builder.currentUIPage((Supplier<UIPage>) value)).add(UI.FeatureIDs.FONT_PKG, (builder, value) -> builder.fontPkg((Supplier<FontPkg>) value)).add(UI.FeatureIDs.DST_IMAGE, (builder, value) -> builder.dstImage((Supplier<IImage>) value)).add(UI.FeatureIDs.IMAGES, (builder, value) -> builder.addImage((Supplier<IImage>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case UI.FeatureIDs.ENABLED -> 0;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case UI.FeatureIDs.EXTENSION_PKG -> 0;
        case UI.FeatureIDs.UI_PAGES -> 1;
        case UI.FeatureIDs.CURRENTUI_PAGE -> 2;
        case UI.FeatureIDs.FONT_PKG -> 3;
        case UI.FeatureIDs.DST_IMAGE -> 4;
        case UI.FeatureIDs.IMAGES -> 5;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
