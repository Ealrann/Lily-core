package org.sheepy.lily.core.model.variable.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.variable.IModelVariable;
import org.sheepy.lily.core.model.variable.ModelVariablePkg;
import org.sheepy.lily.core.model.variable.VariableModelDefinition;

public final class ModelVariablePkgImpl extends FeaturedObject<ModelVariablePkg.Features<?>> implements ModelVariablePkg {
  private static final int FEATURE_COUNT = 1;
  private final ModelNotifier<ModelVariablePkg.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final List<IModelVariable> variables = newObservableList(ModelVariablePkg.FeatureIDs.VARIABLES, true, true);

  public ModelVariablePkgImpl() {
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<ModelVariablePkg.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public List<IModelVariable> variables() {
    return variables;
  }

  @Override
  public Group<ModelVariablePkg> lmGroup() {
    return VariableModelDefinition.Groups.MODEL_VARIABLE_PKG;
  }

  @Override
  protected FeatureSetter<ModelVariablePkg> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<ModelVariablePkg> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case ModelVariablePkg.FeatureIDs.VARIABLES -> 0;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<ModelVariablePkg> GET_MAP = new FeatureGetter.Builder<ModelVariablePkg>(FEATURE_COUNT, ModelVariablePkgImpl::featureIndexStatic).add(ModelVariablePkg.FeatureIDs.VARIABLES, ModelVariablePkg::variables).build();
    private static final FeatureSetter<ModelVariablePkg> SET_MAP = new FeatureSetter.Builder<ModelVariablePkg>(FEATURE_COUNT, ModelVariablePkgImpl::featureIndexStatic).build();
  }
}
