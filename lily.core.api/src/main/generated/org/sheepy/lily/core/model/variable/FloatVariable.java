package org.sheepy.lily.core.model.variable;

import java.util.List;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.FloatListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.sheepy.lily.core.model.variable.builder.FloatVariableBuilder;

public interface FloatVariable extends IModelVariable {
  static Builder builder() {
    return new FloatVariableBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  float value();
  void value(final float value);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int VALUE = 205947667;
  }

  interface Features<T extends Features<T>> extends IModelVariable.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<Float, Float, FloatListener, Features<?>> VALUE = new AttributeBuilder<Float, Float, FloatListener, Features<?>>().name("value").mandatory(true).id(FloatVariable.FeatureIDs.VALUE).datatype(() -> LMCoreModelDefinition.Units.FLOAT).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, VALUE);
  }

  interface Builder extends IFeaturedObject.Builder<FloatVariable> {
    Builder name(String name);
    Builder value(float value);
  }
}
