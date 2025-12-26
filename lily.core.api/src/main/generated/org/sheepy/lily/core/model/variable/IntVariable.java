package org.sheepy.lily.core.model.variable;

import java.util.List;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.IntListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.sheepy.lily.core.model.variable.builder.IntVariableBuilder;

public interface IntVariable extends IModelVariable {
  static Builder builder() {
    return new IntVariableBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  int value();
  void value(final int value);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int VALUE = 677090406;
  }

  interface Features<T extends Features<T>> extends IModelVariable.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<Integer, Integer, IntListener, Features<?>> VALUE = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("value").mandatory(true).id(IntVariable.FeatureIDs.VALUE).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, VALUE);
  }

  interface Builder extends IFeaturedObject.Builder<IntVariable> {
    Builder name(String name);
    Builder value(int value);
  }
}
