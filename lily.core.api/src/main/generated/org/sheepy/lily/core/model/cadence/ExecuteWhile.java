package org.sheepy.lily.core.model.cadence;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.core.model.cadence.builder.ExecuteWhileBuilder;

public interface ExecuteWhile extends CadenceTaskPkg {
  static Builder builder() {
    return new ExecuteWhileBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<ICadenceCondition> conditions();

  interface FeatureIDs {
    int TASKS = CadenceTaskPkg.FeatureIDs.TASKS;
    int CONDITIONS = 161841963;
  }

  interface Features<T extends Features<T>> extends CadenceTaskPkg.Features<T> {
    Relation<ICadenceTask, List<ICadenceTask>, Listener<List<ICadenceTask>>, CadenceTaskPkg.Features<?>> TASKS = CadenceTaskPkg.Features.TASKS;
    Relation<ICadenceCondition, List<ICadenceCondition>, Listener<List<ICadenceCondition>>, Features<?>> CONDITIONS = new RelationBuilder<ICadenceCondition, List<ICadenceCondition>, Listener<List<ICadenceCondition>>, Features<?>>().name("conditions").many(true).contains(true).id(ExecuteWhile.FeatureIDs.CONDITIONS).concept(() -> CadenceModelDefinition.Groups.I_CADENCE_CONDITION).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(TASKS, CONDITIONS);
  }

  interface Builder extends IFeaturedObject.Builder<ExecuteWhile> {
    Builder addTask(Supplier<ICadenceTask> task);
    Builder addCondition(Supplier<ICadenceCondition> condition);
    Builder addTasks(List<ICadenceTask> tasks);
    Builder addConditions(List<ICadenceCondition> conditions);
  }
}
