package org.sheepy.lily.core.model.resource.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.resource.IRootResource;
import org.sheepy.lily.core.model.resource.ResourceModelDefinition;
import org.sheepy.lily.core.model.resource.ResourcePkg;

public final class ResourcePkgImpl extends FeaturedObject<ResourcePkg.Features<?>> implements ResourcePkg {
  private static final int FEATURE_COUNT = 1;
  private final ModelNotifier<ResourcePkg.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final List<IRootResource> resources = newObservableList(ResourcePkg.FeatureIDs.RESOURCES, true, true);

  public ResourcePkgImpl() {
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<ResourcePkg.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public List<IRootResource> resources() {
    return resources;
  }

  @Override
  public Group<ResourcePkg> lmGroup() {
    return ResourceModelDefinition.Groups.RESOURCE_PKG;
  }

  @Override
  protected FeatureSetter<ResourcePkg> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<ResourcePkg> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case ResourcePkg.FeatureIDs.RESOURCES -> 0;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<ResourcePkg> GET_MAP = new FeatureGetter.Builder<ResourcePkg>(FEATURE_COUNT, ResourcePkgImpl::featureIndexStatic).add(ResourcePkg.FeatureIDs.RESOURCES, ResourcePkg::resources).build();
    private static final FeatureSetter<ResourcePkg> SET_MAP = new FeatureSetter.Builder<ResourcePkg>(FEATURE_COUNT, ResourcePkgImpl::featureIndexStatic).build();
  }
}
