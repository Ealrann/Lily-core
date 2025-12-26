package org.sheepy.lily.core.model.resource;

import java.util.List;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Named;
import org.sheepy.lily.core.model.resource.builder.LocalResourceBuilder;

public interface LocalResource extends FileResource {
  static Builder builder() {
    return new LocalResourceBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int PATH = FileResource.FeatureIDs.PATH;
  }

  interface Features<T extends Features<T>> extends FileResource.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<String, String, Listener<String>, FileResource.Features<?>> PATH = FileResource.Features.PATH;
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, PATH);
  }

  interface Builder extends IFeaturedObject.Builder<LocalResource> {
    Builder name(String name);
    Builder path(String path);
  }
}
