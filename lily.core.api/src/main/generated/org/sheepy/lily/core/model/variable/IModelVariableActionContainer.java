package org.sheepy.lily.core.model.variable;

import java.util.List;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.RelationBuilder;

public interface IModelVariableActionContainer extends LMObject {
  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<IModelVariableAction> actions();

  interface FeatureIDs {
    int ACTIONS = -502218090;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Relation<IModelVariableAction, List<IModelVariableAction>, Listener<List<IModelVariableAction>>, Features<?>> ACTIONS = new RelationBuilder<IModelVariableAction, List<IModelVariableAction>, Listener<List<IModelVariableAction>>, Features<?>>().name("actions").many(true).contains(true).id(IModelVariableActionContainer.FeatureIDs.ACTIONS).concept(() -> VariableModelDefinition.Groups.I_MODEL_VARIABLE_ACTION).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(ACTIONS);
  }
}
