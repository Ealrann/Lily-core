package org.sheepy.lily.core.model.action.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.action.ActionModelDefinition;
import org.sheepy.lily.core.model.action.CloseApplicationAction;

public final class CloseApplicationActionImpl extends FeaturedObject<CloseApplicationAction.Features<?>> implements CloseApplicationAction {
  private static final int FEATURE_COUNT = 1;
  private final ModelNotifier<CloseApplicationAction.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;

  public CloseApplicationActionImpl(final String name) {
    this.name = name;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<CloseApplicationAction.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public Group<CloseApplicationAction> lmGroup() {
    return ActionModelDefinition.Groups.CLOSE_APPLICATION_ACTION;
  }

  @Override
  protected FeatureSetter<CloseApplicationAction> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<CloseApplicationAction> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case CloseApplicationAction.FeatureIDs.NAME -> 0;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<CloseApplicationAction> GET_MAP = new FeatureGetter.Builder<CloseApplicationAction>(FEATURE_COUNT, CloseApplicationActionImpl::featureIndexStatic).add(CloseApplicationAction.FeatureIDs.NAME, CloseApplicationAction::name).build();
    private static final FeatureSetter<CloseApplicationAction> SET_MAP = new FeatureSetter.Builder<CloseApplicationAction>(FEATURE_COUNT, CloseApplicationActionImpl::featureIndexStatic).build();
  }
}
