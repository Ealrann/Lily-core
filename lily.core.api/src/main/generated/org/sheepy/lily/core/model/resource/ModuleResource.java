package org.sheepy.lily.core.model.resource;

import java.util.List;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.sheepy.lily.core.model.resource.builder.ModuleResourceBuilder;
import org.sheepy.lily.core.model.types.TypesModelDefinition;

public interface ModuleResource extends AbstractModuleResource {
  static Builder builder() {
    return new ModuleResourceBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  Module module();
  void module(final Module module);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int PATH = FileResource.FeatureIDs.PATH;
    int MODULE = -1834620670;
  }

  interface Features<T extends Features<T>> extends AbstractModuleResource.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<String, String, Listener<String>, FileResource.Features<?>> PATH = FileResource.Features.PATH;
    Attribute<Module, Module, Listener<Module>, Features<?>> MODULE = new AttributeBuilder<Module, Module, Listener<Module>, Features<?>>().name("module").mandatory(true).id(ModuleResource.FeatureIDs.MODULE).datatype(() -> TypesModelDefinition.JavaWrappers.JAVA_MODULE).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, PATH, MODULE);
  }

  interface Builder extends IFeaturedObject.Builder<ModuleResource> {
    Builder name(String name);
    Builder path(String path);
    Builder module(Module module);
  }
}
