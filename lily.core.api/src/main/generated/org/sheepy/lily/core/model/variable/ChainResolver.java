package org.sheepy.lily.core.model.variable;

import java.util.List;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.sheepy.lily.core.model.variable.builder.ChainResolverBuilder;

public interface ChainResolver extends IDefinitionContainer {
  static Builder builder() {
    return new ChainResolverBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();

  interface FeatureIDs {
    int VARIABLE_DEFINITION = IDefinitionContainer.FeatureIDs.VARIABLE_DEFINITION;
  }

  interface Features<T extends Features<T>> extends IDefinitionContainer.Features<T> {
    Attribute<String, String, Listener<String>, IDefinitionContainer.Features<?>> VARIABLE_DEFINITION = IDefinitionContainer.Features.VARIABLE_DEFINITION;
    List<Feature<?, ?, ?, ?>> ALL = List.of(VARIABLE_DEFINITION);
  }

  interface Builder extends IFeaturedObject.Builder<ChainResolver> {
    Builder variableDefinition(String variableDefinition);
  }
}
