package org.sheepy.lily.core.model.types;

import java.util.List;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.sheepy.lily.core.model.types.builder.StringParameterBuilder;

public interface StringParameter extends NativeParameter<String> {
  static Builder builder() {
    return new StringParameterBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  String value();
  void value(final String value);
  String getNativeValue();

  interface FeatureIDs {
    int VALUE = -1748114260;
  }

  interface Features<T extends Features<T>> extends NativeParameter.Features<T> {
    Attribute<String, String, Listener<String>, Features<?>> VALUE = new AttributeBuilder<String, String, Listener<String>, Features<?>>().name("value").id(StringParameter.FeatureIDs.VALUE).datatype(() -> LMCoreModelDefinition.Units.STRING).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(VALUE);
  }

  interface Builder extends IFeaturedObject.Builder<StringParameter> {
    Builder value(String value);
  }
}
