package org.sheepy.lily.core.model.cadence.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.cadence.CadenceModelDefinition;
import org.sheepy.lily.core.model.cadence.CadenceTaskPkg;
import org.sheepy.lily.core.model.cadence.ExecuteWhile;
import org.sheepy.lily.core.model.cadence.ICadenceCondition;
import org.sheepy.lily.core.model.cadence.ICadenceTask;

public final class ExecuteWhileImpl extends FeaturedObject<ExecuteWhile.Features<?>> implements ExecuteWhile {
  private static final int FEATURE_COUNT = 2;
  private final ModelNotifier<ExecuteWhile.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final List<ICadenceTask> tasks = newObservableList(CadenceTaskPkg.FeatureIDs.TASKS, true, true);
  private final List<ICadenceCondition> conditions = newObservableList(ExecuteWhile.FeatureIDs.CONDITIONS, true, true);

  public ExecuteWhileImpl() {
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<ExecuteWhile.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public List<ICadenceTask> tasks() {
    return tasks;
  }

  @Override
  public List<ICadenceCondition> conditions() {
    return conditions;
  }

  @Override
  public Group<ExecuteWhile> lmGroup() {
    return CadenceModelDefinition.Groups.EXECUTE_WHILE;
  }

  @Override
  protected FeatureSetter<ExecuteWhile> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<ExecuteWhile> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case ExecuteWhile.FeatureIDs.TASKS -> 0;
      case ExecuteWhile.FeatureIDs.CONDITIONS -> 1;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<ExecuteWhile> GET_MAP = new FeatureGetter.Builder<ExecuteWhile>(FEATURE_COUNT, ExecuteWhileImpl::featureIndexStatic).add(ExecuteWhile.FeatureIDs.TASKS, ExecuteWhile::tasks).add(ExecuteWhile.FeatureIDs.CONDITIONS, ExecuteWhile::conditions).build();
    private static final FeatureSetter<ExecuteWhile> SET_MAP = new FeatureSetter.Builder<ExecuteWhile>(FEATURE_COUNT, ExecuteWhileImpl::featureIndexStatic).build();
  }
}
