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
import org.sheepy.lily.core.model.resource.builder.StringModuleResourceBuilder;

public interface StringModuleResource extends AbstractModuleResource {
  static Builder builder() {
    return new StringModuleResourceBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  String moduleName();
  void moduleName(final String moduleName);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int PATH = FileResource.FeatureIDs.PATH;
    int MODULE_NAME = -1175868644;
  }

  interface Features<T extends Features<T>> extends AbstractModuleResource.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<String, String, Listener<String>, FileResource.Features<?>> PATH = FileResource.Features.PATH;
    Attribute<String, String, Listener<String>, Features<?>> MODULE_NAME = new AttributeBuilder<String, String, Listener<String>, Features<?>>().name("moduleName").mandatory(true).id(StringModuleResource.FeatureIDs.MODULE_NAME).datatype(() -> LMCoreModelDefinition.Units.STRING).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, PATH, MODULE_NAME);
  }

  interface Builder extends IFeaturedObject.Builder<StringModuleResource> {
    Builder name(String name);
    Builder path(String path);
    Builder moduleName(String moduleName);
  }
}
