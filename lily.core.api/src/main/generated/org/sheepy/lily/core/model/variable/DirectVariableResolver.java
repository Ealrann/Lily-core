package org.sheepy.lily.core.model.variable;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.core.model.variable.builder.DirectVariableResolverBuilder;

public interface DirectVariableResolver extends AbstractDefinedVariableResolver {
  static Builder builder() {
    return new DirectVariableResolverBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  LMObject target();

  interface FeatureIDs {
    int VARIABLE_DEFINITION = IDefinitionContainer.FeatureIDs.VARIABLE_DEFINITION;
    int TARGET = -306450204;
  }

  interface Features<T extends Features<T>> extends AbstractDefinedVariableResolver.Features<T> {
    Attribute<String, String, Listener<String>, IDefinitionContainer.Features<?>> VARIABLE_DEFINITION = IDefinitionContainer.Features.VARIABLE_DEFINITION;
    Relation<LMObject, LMObject, Listener<LMObject>, Features<?>> TARGET = new RelationBuilder<LMObject, LMObject, Listener<LMObject>, Features<?>>().name("target").immutable(true).lazy(true).id(DirectVariableResolver.FeatureIDs.TARGET).concept(() -> LMCoreModelDefinition.Groups.LM_OBJECT).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(VARIABLE_DEFINITION, TARGET);
  }

  interface Builder extends IFeaturedObject.Builder<DirectVariableResolver> {
    Builder variableDefinition(String variableDefinition);
    Builder target(Supplier<LMObject> target);
  }
}
