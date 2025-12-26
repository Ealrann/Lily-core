package org.sheepy.lily.core.model.action.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.action.Action;
import org.sheepy.lily.core.model.action.ActionList;
import org.sheepy.lily.core.model.action.ActionModelDefinition;

public final class ActionListImpl<T extends Action> extends FeaturedObject<ActionList.Features<?>> implements ActionList<T> {
  private static final int FEATURE_COUNT = 1;
  private final ModelNotifier<ActionList.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final List<T> list;

  public ActionListImpl(final List<T> list) {
    this.list = list;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<ActionList.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public List<T> list() {
    return list;
  }

  @Override
  public Group<ActionList<?>> lmGroup() {
    return ActionModelDefinition.Groups.ACTION_LIST;
  }

  @Override
  protected FeatureSetter<ActionList<?>> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<ActionList<?>> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case ActionList.FeatureIDs.LIST -> 0;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<ActionList<?>> GET_MAP = new FeatureGetter.Builder<ActionList<?>>(FEATURE_COUNT, ActionListImpl::featureIndexStatic).add(ActionList.FeatureIDs.LIST, ActionList::list).build();
    private static final FeatureSetter<ActionList<?>> SET_MAP = new FeatureSetter.Builder<ActionList<?>>(FEATURE_COUNT, ActionListImpl::featureIndexStatic).build();
  }
}
