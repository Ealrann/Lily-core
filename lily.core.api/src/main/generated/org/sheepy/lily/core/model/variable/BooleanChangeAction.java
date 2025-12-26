package org.sheepy.lily.core.model.variable;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.core.model.variable.builder.BooleanChangeActionBuilder;

public interface BooleanChangeAction extends VarChangeAction {
  static Builder builder() {
    return new BooleanChangeActionBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int VARIABLE_RESOLVER = VarChangeAction.FeatureIDs.VARIABLE_RESOLVER;
  }

  interface Features<T extends Features<T>> extends VarChangeAction.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Relation<AbstractDefinedVariableResolver, AbstractDefinedVariableResolver, Listener<AbstractDefinedVariableResolver>, VarChangeAction.Features<?>> VARIABLE_RESOLVER = VarChangeAction.Features.VARIABLE_RESOLVER;
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, VARIABLE_RESOLVER);
  }

  interface Builder extends IFeaturedObject.Builder<BooleanChangeAction> {
    Builder name(String name);
    Builder variableResolver(Supplier<AbstractDefinedVariableResolver> variableResolver);
  }
}
