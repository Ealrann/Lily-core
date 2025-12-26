package org.sheepy.lily.core.model.ui.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.ui.DynamicRowLayout;
import org.sheepy.lily.core.model.ui.UIModelDefinition;

public final class DynamicRowLayoutImpl extends FeaturedObject<DynamicRowLayout.Features<?>> implements DynamicRowLayout {
  private static final int FEATURE_COUNT = 2;
  private final ModelNotifier<DynamicRowLayout.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private int height;
  private int columnCount;

  public DynamicRowLayoutImpl() {
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<DynamicRowLayout.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public int height() {
    return height;
  }

  @Override
  public void height(final int height) {
    final var oldValue = this.height;
    this.height = height;
    notifier.notifyInt(DynamicRowLayout.FeatureIDs.HEIGHT, false, false, oldValue, height);
  }

  @Override
  public int columnCount() {
    return columnCount;
  }

  @Override
  public void columnCount(final int columnCount) {
    final var oldValue = this.columnCount;
    this.columnCount = columnCount;
    notifier.notifyInt(DynamicRowLayout.FeatureIDs.COLUMN_COUNT, false, false, oldValue, columnCount);
  }

  @Override
  public Group<DynamicRowLayout> lmGroup() {
    return UIModelDefinition.Groups.DYNAMIC_ROW_LAYOUT;
  }

  @Override
  protected FeatureSetter<DynamicRowLayout> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<DynamicRowLayout> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case DynamicRowLayout.FeatureIDs.HEIGHT -> 0;
      case DynamicRowLayout.FeatureIDs.COLUMN_COUNT -> 1;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<DynamicRowLayout> GET_MAP = new FeatureGetter.Builder<DynamicRowLayout>(FEATURE_COUNT, DynamicRowLayoutImpl::featureIndexStatic).add(DynamicRowLayout.FeatureIDs.HEIGHT, DynamicRowLayout::height).add(DynamicRowLayout.FeatureIDs.COLUMN_COUNT, DynamicRowLayout::columnCount).build();
    private static final FeatureSetter<DynamicRowLayout> SET_MAP = new FeatureSetter.Builder<DynamicRowLayout>(FEATURE_COUNT, DynamicRowLayoutImpl::featureIndexStatic).add(DynamicRowLayout.FeatureIDs.HEIGHT, (object, value) -> ((DynamicRowLayoutImpl) object).height((int) value)).add(DynamicRowLayout.FeatureIDs.COLUMN_COUNT, (object, value) -> ((DynamicRowLayoutImpl) object).columnCount((int) value)).build();
  }
}
