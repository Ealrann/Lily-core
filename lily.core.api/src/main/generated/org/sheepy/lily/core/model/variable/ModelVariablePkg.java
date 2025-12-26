package org.sheepy.lily.core.model.variable;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.core.model.variable.builder.ModelVariablePkgBuilder;

public interface ModelVariablePkg extends LMObject {
  static Builder builder() {
    return new ModelVariablePkgBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<IModelVariable> variables();

  interface FeatureIDs {
    int VARIABLES = -1874025120;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Relation<IModelVariable, List<IModelVariable>, Listener<List<IModelVariable>>, Features<?>> VARIABLES = new RelationBuilder<IModelVariable, List<IModelVariable>, Listener<List<IModelVariable>>, Features<?>>().name("variables").many(true).contains(true).id(ModelVariablePkg.FeatureIDs.VARIABLES).concept(() -> VariableModelDefinition.Groups.I_MODEL_VARIABLE).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(VARIABLES);
  }

  interface Builder extends IFeaturedObject.Builder<ModelVariablePkg> {
    Builder addVariable(Supplier<IModelVariable> variable);
    Builder addVariables(List<IModelVariable> variables);
  }
}
