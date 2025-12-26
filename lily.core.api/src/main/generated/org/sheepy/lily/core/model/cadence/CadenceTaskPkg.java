package org.sheepy.lily.core.model.cadence;

import java.util.List;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.RelationBuilder;

public interface CadenceTaskPkg extends ICadenceTask {
  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<ICadenceTask> tasks();

  interface FeatureIDs {
    int TASKS = -508470923;
  }

  interface Features<T extends Features<T>> extends ICadenceTask.Features<T> {
    Relation<ICadenceTask, List<ICadenceTask>, Listener<List<ICadenceTask>>, Features<?>> TASKS = new RelationBuilder<ICadenceTask, List<ICadenceTask>, Listener<List<ICadenceTask>>, Features<?>>().name("tasks").many(true).contains(true).id(CadenceTaskPkg.FeatureIDs.TASKS).concept(() -> CadenceModelDefinition.Groups.I_CADENCE_TASK).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(TASKS);
  }
}
