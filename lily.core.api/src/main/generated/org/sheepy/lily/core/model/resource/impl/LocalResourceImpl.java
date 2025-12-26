package org.sheepy.lily.core.model.resource.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.resource.FileResource;
import org.sheepy.lily.core.model.resource.LocalResource;
import org.sheepy.lily.core.model.resource.ResourceModelDefinition;

public final class LocalResourceImpl extends FeaturedObject<LocalResource.Features<?>> implements LocalResource {
  private static final int FEATURE_COUNT = 2;
  private final ModelNotifier<LocalResource.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private String path;

  public LocalResourceImpl(final String name, final String path) {
    this.name = name;
    this.path = path;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<LocalResource.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public String path() {
    return path;
  }

  @Override
  public void path(final String path) {
    final var oldValue = this.path;
    this.path = path;
    notifier.notify(FileResource.FeatureIDs.PATH, false, false, oldValue, path);
  }

  @Override
  public Group<LocalResource> lmGroup() {
    return ResourceModelDefinition.Groups.LOCAL_RESOURCE;
  }

  @Override
  protected FeatureSetter<LocalResource> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<LocalResource> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case LocalResource.FeatureIDs.NAME -> 0;
      case LocalResource.FeatureIDs.PATH -> 1;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<LocalResource> GET_MAP = new FeatureGetter.Builder<LocalResource>(FEATURE_COUNT, LocalResourceImpl::featureIndexStatic).add(LocalResource.FeatureIDs.NAME, LocalResource::name).add(LocalResource.FeatureIDs.PATH, LocalResource::path).build();
    private static final FeatureSetter<LocalResource> SET_MAP = new FeatureSetter.Builder<LocalResource>(FEATURE_COUNT, LocalResourceImpl::featureIndexStatic).add(LocalResource.FeatureIDs.PATH, (object, value) -> ((LocalResourceImpl) object).path((String) value)).build();
  }
}
