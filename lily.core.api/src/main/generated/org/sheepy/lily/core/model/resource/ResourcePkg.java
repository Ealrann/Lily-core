package org.sheepy.lily.core.model.resource;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.core.model.resource.builder.ResourcePkgBuilder;

public interface ResourcePkg extends LMObject {
  static Builder builder() {
    return new ResourcePkgBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<IRootResource> resources();

  interface FeatureIDs {
    int RESOURCES = -1533350337;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Relation<IRootResource, List<IRootResource>, Listener<List<IRootResource>>, Features<?>> RESOURCES = new RelationBuilder<IRootResource, List<IRootResource>, Listener<List<IRootResource>>, Features<?>>().name("resources").many(true).contains(true).id(ResourcePkg.FeatureIDs.RESOURCES).concept(() -> ResourceModelDefinition.Groups.I_ROOT_RESOURCE).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(RESOURCES);
  }

  interface Builder extends IFeaturedObject.Builder<ResourcePkg> {
    Builder addResource(Supplier<IRootResource> resource);
    Builder addResources(List<IRootResource> resources);
  }
}
