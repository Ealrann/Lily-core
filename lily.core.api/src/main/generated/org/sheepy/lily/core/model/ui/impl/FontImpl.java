package org.sheepy.lily.core.model.ui.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.ui.Font;
import org.sheepy.lily.core.model.ui.FontTable;
import org.sheepy.lily.core.model.ui.UIModelDefinition;

public final class FontImpl extends FeaturedObject<Font.Features<?>> implements Font {
  private static final int FEATURE_COUNT = 3;
  private final ModelNotifier<Font.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private final List<FontTable> tables = newObservableList(Font.FeatureIDs.TABLES, true, true);
  private float height;

  public FontImpl(final String name, final List<FontTable> tables, final float height) {
    this.name = name;
    this.tables.addAll(tables);
    this.height = height;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<Font.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public List<FontTable> tables() {
    return tables;
  }

  @Override
  public float height() {
    return height;
  }

  @Override
  public void height(final float height) {
    final var oldValue = this.height;
    this.height = height;
    notifier.notifyFloat(Font.FeatureIDs.HEIGHT, false, false, oldValue, height);
  }

  @Override
  public Group<Font> lmGroup() {
    return UIModelDefinition.Groups.FONT;
  }

  @Override
  protected FeatureSetter<Font> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<Font> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case Font.FeatureIDs.NAME -> 0;
      case Font.FeatureIDs.TABLES -> 1;
      case Font.FeatureIDs.HEIGHT -> 2;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<Font> GET_MAP = new FeatureGetter.Builder<Font>(FEATURE_COUNT, FontImpl::featureIndexStatic).add(Font.FeatureIDs.NAME, Font::name).add(Font.FeatureIDs.TABLES, Font::tables).add(Font.FeatureIDs.HEIGHT, Font::height).build();
    private static final FeatureSetter<Font> SET_MAP = new FeatureSetter.Builder<Font>(FEATURE_COUNT, FontImpl::featureIndexStatic).add(Font.FeatureIDs.HEIGHT, (object, value) -> ((FontImpl) object).height((float) value)).build();
  }
}
