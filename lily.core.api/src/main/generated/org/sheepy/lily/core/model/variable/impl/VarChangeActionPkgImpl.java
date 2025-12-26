package org.sheepy.lily.core.model.variable.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.variable.VarChangeAction;
import org.sheepy.lily.core.model.variable.VarChangeActionPkg;
import org.sheepy.lily.core.model.variable.VariableModelDefinition;

public final class VarChangeActionPkgImpl extends FeaturedObject<VarChangeActionPkg.Features<?>> implements VarChangeActionPkg {
  private static final int FEATURE_COUNT = 1;
  private final ModelNotifier<VarChangeActionPkg.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final List<VarChangeAction> actions = newObservableList(VarChangeActionPkg.FeatureIDs.ACTIONS, true, true);

  public VarChangeActionPkgImpl() {
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<VarChangeActionPkg.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public List<VarChangeAction> actions() {
    return actions;
  }

  @Override
  public Group<VarChangeActionPkg> lmGroup() {
    return VariableModelDefinition.Groups.VAR_CHANGE_ACTION_PKG;
  }

  @Override
  protected FeatureSetter<VarChangeActionPkg> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<VarChangeActionPkg> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case VarChangeActionPkg.FeatureIDs.ACTIONS -> 0;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<VarChangeActionPkg> GET_MAP = new FeatureGetter.Builder<VarChangeActionPkg>(FEATURE_COUNT, VarChangeActionPkgImpl::featureIndexStatic).add(VarChangeActionPkg.FeatureIDs.ACTIONS, VarChangeActionPkg::actions).build();
    private static final FeatureSetter<VarChangeActionPkg> SET_MAP = new FeatureSetter.Builder<VarChangeActionPkg>(FEATURE_COUNT, VarChangeActionPkgImpl::featureIndexStatic).build();
  }
}
