package org.sheepy.lily.core.model.variable;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.IntListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.sheepy.lily.core.model.variable.builder.IntChangeActionBuilder;

public interface IntChangeAction extends VarChangeAction {
  static Builder builder() {
    return new IntChangeActionBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  int value();
  void value(final int value);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int VARIABLE_RESOLVER = VarChangeAction.FeatureIDs.VARIABLE_RESOLVER;
    int VALUE = 978025200;
  }

  interface Features<T extends Features<T>> extends VarChangeAction.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Relation<AbstractDefinedVariableResolver, AbstractDefinedVariableResolver, Listener<AbstractDefinedVariableResolver>, VarChangeAction.Features<?>> VARIABLE_RESOLVER = VarChangeAction.Features.VARIABLE_RESOLVER;
    Attribute<Integer, Integer, IntListener, Features<?>> VALUE = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("value").mandatory(true).id(IntChangeAction.FeatureIDs.VALUE).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, VARIABLE_RESOLVER, VALUE);
  }

  interface Builder extends IFeaturedObject.Builder<IntChangeAction> {
    Builder name(String name);
    Builder variableResolver(Supplier<AbstractDefinedVariableResolver> variableResolver);
    Builder value(int value);
  }
}
