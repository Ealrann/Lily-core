package org.sheepy.lily.core.model.resource.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.resource.FileResource;
import org.sheepy.lily.core.model.resource.ResourceModelDefinition;

public final class FileResourceImpl extends FeaturedObject<FileResource.Features<?>> implements FileResource {
  private static final int FEATURE_COUNT = 2;
  private final ModelNotifier<FileResource.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private String path;

  public FileResourceImpl(final String name, final String path) {
    this.name = name;
    this.path = path;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<FileResource.Features<?>> notifier() {
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
  public Group<FileResource> lmGroup() {
    return ResourceModelDefinition.Groups.FILE_RESOURCE;
  }

  @Override
  protected FeatureSetter<FileResource> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<FileResource> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case FileResource.FeatureIDs.NAME -> 0;
      case FileResource.FeatureIDs.PATH -> 1;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<FileResource> GET_MAP = new FeatureGetter.Builder<FileResource>(FEATURE_COUNT, FileResourceImpl::featureIndexStatic).add(FileResource.FeatureIDs.NAME, FileResource::name).add(FileResource.FeatureIDs.PATH, FileResource::path).build();
    private static final FeatureSetter<FileResource> SET_MAP = new FeatureSetter.Builder<FileResource>(FEATURE_COUNT, FileResourceImpl::featureIndexStatic).add(FileResource.FeatureIDs.PATH, (object, value) -> ((FileResourceImpl) object).path((String) value)).build();
  }
}
