package org.sheepy.lily.core.model.variable;

import java.util.List;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.core.model.action.Action;

public interface VarChangeAction extends Action {
  @Override
  IModelNotifier<? extends Features<?>> notifier();
  AbstractDefinedVariableResolver variableResolver();
  void variableResolver(final AbstractDefinedVariableResolver variableResolver);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int VARIABLE_RESOLVER = 751367051;
  }

  interface Features<T extends Features<T>> extends Action.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Relation<AbstractDefinedVariableResolver, AbstractDefinedVariableResolver, Listener<AbstractDefinedVariableResolver>, Features<?>> VARIABLE_RESOLVER = new RelationBuilder<AbstractDefinedVariableResolver, AbstractDefinedVariableResolver, Listener<AbstractDefinedVariableResolver>, Features<?>>().name("variableResolver").mandatory(true).contains(true).id(VarChangeAction.FeatureIDs.VARIABLE_RESOLVER).concept(() -> VariableModelDefinition.Groups.ABSTRACT_DEFINED_VARIABLE_RESOLVER).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, VARIABLE_RESOLVER);
  }
}
