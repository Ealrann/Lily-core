package org.sheepy.lily.core.model.variable;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.core.model.variable.builder.SetVariableActionBuilder;

public interface SetVariableAction extends IModelVariableAction {
  static Builder builder() {
    return new SetVariableActionBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  String value();
  IModelVariable variable();
  void value(final String value);
  void variable(final IModelVariable variable);

  interface FeatureIDs {
    int VALUE = -179067921;
    int VARIABLE = -102381762;
  }

  interface Features<T extends Features<T>> extends IModelVariableAction.Features<T> {
    Attribute<String, String, Listener<String>, Features<?>> VALUE = new AttributeBuilder<String, String, Listener<String>, Features<?>>().name("value").mandatory(true).id(SetVariableAction.FeatureIDs.VALUE).datatype(() -> LMCoreModelDefinition.Units.STRING).build();
    Relation<IModelVariable, IModelVariable, Listener<IModelVariable>, Features<?>> VARIABLE = new RelationBuilder<IModelVariable, IModelVariable, Listener<IModelVariable>, Features<?>>().name("variable").mandatory(true).id(SetVariableAction.FeatureIDs.VARIABLE).concept(() -> VariableModelDefinition.Groups.I_MODEL_VARIABLE).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(VALUE, VARIABLE);
  }

  interface Builder extends IFeaturedObject.Builder<SetVariableAction> {
    Builder value(String value);
    Builder variable(Supplier<IModelVariable> variable);
  }
}
