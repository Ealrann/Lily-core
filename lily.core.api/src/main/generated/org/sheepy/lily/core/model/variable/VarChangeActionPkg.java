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
import org.sheepy.lily.core.model.variable.builder.VarChangeActionPkgBuilder;

public interface VarChangeActionPkg extends LMObject {
  static Builder builder() {
    return new VarChangeActionPkgBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<VarChangeAction> actions();

  interface FeatureIDs {
    int ACTIONS = 205201694;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Relation<VarChangeAction, List<VarChangeAction>, Listener<List<VarChangeAction>>, Features<?>> ACTIONS = new RelationBuilder<VarChangeAction, List<VarChangeAction>, Listener<List<VarChangeAction>>, Features<?>>().name("actions").many(true).contains(true).id(VarChangeActionPkg.FeatureIDs.ACTIONS).concept(() -> VariableModelDefinition.Groups.VAR_CHANGE_ACTION).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(ACTIONS);
  }

  interface Builder extends IFeaturedObject.Builder<VarChangeActionPkg> {
    Builder addAction(Supplier<VarChangeAction> action);
    Builder addActions(List<VarChangeAction> actions);
  }
}
