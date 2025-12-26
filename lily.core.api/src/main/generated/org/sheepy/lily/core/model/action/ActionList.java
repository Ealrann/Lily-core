package org.sheepy.lily.core.model.action;

import java.util.List;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Datatype;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.logoce.lmf.core.lang.builder.GenericParameterBuilder;
import org.sheepy.lily.core.model.action.builder.ActionListBuilder;

public interface ActionList<T extends Action> extends LMObject {
  static <T extends Action> Builder<T> builder() {
    return new ActionListBuilder<>();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<T> list();

  interface FeatureIDs {
    int LIST = 1080553794;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Attribute<List<?>, List<?>, Listener<List<?>>, Features<?>> LIST = new AttributeBuilder<List<?>, List<?>, Listener<List<?>>, Features<?>>().name("list").immutable(true).mandatory(true).id(ActionList.FeatureIDs.LIST).datatype(() -> (Datatype<List<?>>) (Datatype) ActionModelDefinition.JavaWrappers.JAVA_LIST).addParameter(() -> new GenericParameterBuilder().type(() -> ActionModelDefinition.Generics.ACTION_LIST.T).build()).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(LIST);
  }

  interface Builder<T extends Action> extends IFeaturedObject.Builder<ActionList<T>> {
    Builder<T> list(List<T> list);
  }
}
