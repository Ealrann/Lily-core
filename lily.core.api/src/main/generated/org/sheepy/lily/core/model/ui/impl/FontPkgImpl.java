package org.sheepy.lily.core.model.ui.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.ui.Font;
import org.sheepy.lily.core.model.ui.FontPkg;
import org.sheepy.lily.core.model.ui.UIModelDefinition;

public final class FontPkgImpl extends FeaturedObject<FontPkg.Features<?>> implements FontPkg {
  private static final int FEATURE_COUNT = 1;
  private final ModelNotifier<FontPkg.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final List<Font> fonts = newObservableList(FontPkg.FeatureIDs.FONTS, true, true);

  public FontPkgImpl(final List<Font> fonts) {
    this.fonts.addAll(fonts);
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<FontPkg.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public List<Font> fonts() {
    return fonts;
  }

  @Override
  public Group<FontPkg> lmGroup() {
    return UIModelDefinition.Groups.FONT_PKG;
  }

  @Override
  protected FeatureSetter<FontPkg> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<FontPkg> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case FontPkg.FeatureIDs.FONTS -> 0;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<FontPkg> GET_MAP = new FeatureGetter.Builder<FontPkg>(FEATURE_COUNT, FontPkgImpl::featureIndexStatic).add(FontPkg.FeatureIDs.FONTS, FontPkg::fonts).build();
    private static final FeatureSetter<FontPkg> SET_MAP = new FeatureSetter.Builder<FontPkg>(FEATURE_COUNT, FontPkgImpl::featureIndexStatic).build();
  }
}
