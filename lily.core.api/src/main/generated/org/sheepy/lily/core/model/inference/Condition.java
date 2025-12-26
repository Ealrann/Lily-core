package org.sheepy.lily.core.model.inference;

import java.util.List;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.core.model.types.Parameter;
import org.sheepy.lily.core.model.types.TypesModelDefinition;

public interface Condition<T extends Parameter> extends LMObject {
  @Override
  IModelNotifier<? extends Features<?>> notifier();
  T value();
  LNotification definition();
  void value(final T value);
  void definition(final LNotification definition);

  default Class<T> getType() {
    throw new UnsupportedOperationException("Operation 'getType' is not implemented");
  }

  default boolean match(T compareTo) {
    throw new UnsupportedOperationException("Operation 'match' is not implemented");
  }

  interface FeatureIDs {
    int VALUE = -925824177;
    int DEFINITION = -1390660043;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Relation<Parameter, Parameter, Listener<Parameter>, Features<?>> VALUE = new RelationBuilder<Parameter, Parameter, Listener<Parameter>, Features<?>>().name("value").contains(true).id(Condition.FeatureIDs.VALUE).concept(() -> TypesModelDefinition.Groups.PARAMETER).build();
    Relation<LNotification, LNotification, Listener<LNotification>, Features<?>> DEFINITION = new RelationBuilder<LNotification, LNotification, Listener<LNotification>, Features<?>>().name("definition").id(Condition.FeatureIDs.DEFINITION).concept(() -> InferenceModelDefinition.Groups.L_NOTIFICATION).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(VALUE, DEFINITION);
  }
}
