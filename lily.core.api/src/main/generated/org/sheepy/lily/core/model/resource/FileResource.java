package org.sheepy.lily.core.model.resource;

import java.util.List;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.sheepy.lily.core.model.resource.builder.FileResourceBuilder;

public interface FileResource extends IRootResource {
  static Builder builder() {
    return new FileResourceBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  String path();
  void path(final String path);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int PATH = 1097421995;
  }

  interface Features<T extends Features<T>> extends IRootResource.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<String, String, Listener<String>, Features<?>> PATH = new AttributeBuilder<String, String, Listener<String>, Features<?>>().name("path").mandatory(true).id(FileResource.FeatureIDs.PATH).datatype(() -> LMCoreModelDefinition.Units.STRING).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, PATH);
  }

  interface Builder extends IFeaturedObject.Builder<FileResource> {
    Builder name(String name);
    Builder path(String path);
  }
}
