package org.sheepy.lily.core.model.types;

import java.util.List;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.BooleanListener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.sheepy.lily.core.model.types.builder.BooleanParameterBuilder;

public interface BooleanParameter extends NativeParameter<Boolean> {
  static Builder builder() {
    return new BooleanParameterBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  boolean value();
  void value(final boolean value);
  Boolean getNativeValue();

  interface FeatureIDs {
    int VALUE = -121543141;
  }

  interface Features<T extends Features<T>> extends NativeParameter.Features<T> {
    Attribute<Boolean, Boolean, BooleanListener, Features<?>> VALUE = new AttributeBuilder<Boolean, Boolean, BooleanListener, Features<?>>().name("value").id(BooleanParameter.FeatureIDs.VALUE).datatype(() -> LMCoreModelDefinition.Units.BOOLEAN).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(VALUE);
  }

  interface Builder extends IFeaturedObject.Builder<BooleanParameter> {
    Builder value(boolean value);
  }
}
