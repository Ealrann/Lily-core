package org.sheepy.lily.core.model.variable;

import java.util.List;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;

public interface IDefinitionContainer extends LMObject {
  @Override
  IModelNotifier<? extends Features<?>> notifier();
  String variableDefinition();
  void variableDefinition(final String variableDefinition);

  interface FeatureIDs {
    int VARIABLE_DEFINITION = 455970280;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Attribute<String, String, Listener<String>, Features<?>> VARIABLE_DEFINITION = new AttributeBuilder<String, String, Listener<String>, Features<?>>().name("variableDefinition").mandatory(true).id(IDefinitionContainer.FeatureIDs.VARIABLE_DEFINITION).datatype(() -> VariableModelDefinition.Units.VARIABLE_DEFINITION).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(VARIABLE_DEFINITION);
  }
}
