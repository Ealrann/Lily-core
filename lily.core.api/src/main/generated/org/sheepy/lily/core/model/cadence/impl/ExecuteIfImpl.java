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
import org.sheepy.lily.core.model.cadence.ExecuteIf;
import org.sheepy.lily.core.model.cadence.ICadenceCondition;
import org.sheepy.lily.core.model.cadence.ICadenceTask;

public final class ExecuteIfImpl extends FeaturedObject<ExecuteIf.Features<?>> implements ExecuteIf {
  private static final int FEATURE_COUNT = 2;
  private final ModelNotifier<ExecuteIf.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final List<ICadenceTask> tasks = newObservableList(CadenceTaskPkg.FeatureIDs.TASKS, true, true);
  private final List<ICadenceCondition> conditions = newObservableList(ExecuteIf.FeatureIDs.CONDITIONS, true, true);

  public ExecuteIfImpl() {
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<ExecuteIf.Features<?>> notifier() {
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
  public Group<ExecuteIf> lmGroup() {
    return CadenceModelDefinition.Groups.EXECUTE_IF;
  }

  @Override
  protected FeatureSetter<ExecuteIf> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<ExecuteIf> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case ExecuteIf.FeatureIDs.TASKS -> 0;
      case ExecuteIf.FeatureIDs.CONDITIONS -> 1;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<ExecuteIf> GET_MAP = new FeatureGetter.Builder<ExecuteIf>(FEATURE_COUNT, ExecuteIfImpl::featureIndexStatic).add(ExecuteIf.FeatureIDs.TASKS, ExecuteIf::tasks).add(ExecuteIf.FeatureIDs.CONDITIONS, ExecuteIf::conditions).build();
    private static final FeatureSetter<ExecuteIf> SET_MAP = new FeatureSetter.Builder<ExecuteIf>(FEATURE_COUNT, ExecuteIfImpl::featureIndexStatic).build();
  }
}
