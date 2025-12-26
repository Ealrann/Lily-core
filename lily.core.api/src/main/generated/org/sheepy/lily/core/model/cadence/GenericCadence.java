package org.sheepy.lily.core.model.cadence;

import java.util.List;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Named;
import org.sheepy.lily.core.model.application.ICadence;
import org.sheepy.lily.core.model.cadence.builder.GenericCadenceBuilder;
import org.sheepy.lily.core.model.types.LNamedElement;

public interface GenericCadence extends ICadence, LNamedElement {
  static Builder builder() {
    return new GenericCadenceBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
  }

  interface Features<T extends Features<T>> extends ICadence.Features<T>, LNamedElement.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME);
  }

  interface Builder extends IFeaturedObject.Builder<GenericCadence> {
    Builder name(String name);
  }
}
