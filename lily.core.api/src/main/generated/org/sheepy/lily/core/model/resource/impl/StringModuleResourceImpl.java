package org.sheepy.lily.core.model.resource.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.resource.FileResource;
import org.sheepy.lily.core.model.resource.ResourceModelDefinition;
import org.sheepy.lily.core.model.resource.StringModuleResource;

public final class StringModuleResourceImpl extends FeaturedObject<StringModuleResource.Features<?>> implements StringModuleResource {
  private static final int FEATURE_COUNT = 3;
  private final ModelNotifier<StringModuleResource.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private String path;
  private String moduleName;

  public StringModuleResourceImpl(final String name, final String path, final String moduleName) {
    this.name = name;
    this.path = path;
    this.moduleName = moduleName;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<StringModuleResource.Features<?>> notifier() {
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
  public String moduleName() {
    return moduleName;
  }

  @Override
  public void moduleName(final String moduleName) {
    final var oldValue = this.moduleName;
    this.moduleName = moduleName;
    notifier.notify(StringModuleResource.FeatureIDs.MODULE_NAME, false, false, oldValue, moduleName);
  }

  @Override
  public Group<StringModuleResource> lmGroup() {
    return ResourceModelDefinition.Groups.STRING_MODULE_RESOURCE;
  }

  @Override
  protected FeatureSetter<StringModuleResource> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<StringModuleResource> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case StringModuleResource.FeatureIDs.NAME -> 0;
      case StringModuleResource.FeatureIDs.PATH -> 1;
      case StringModuleResource.FeatureIDs.MODULE_NAME -> 2;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<StringModuleResource> GET_MAP = new FeatureGetter.Builder<StringModuleResource>(FEATURE_COUNT, StringModuleResourceImpl::featureIndexStatic).add(StringModuleResource.FeatureIDs.NAME, StringModuleResource::name).add(StringModuleResource.FeatureIDs.PATH, StringModuleResource::path).add(StringModuleResource.FeatureIDs.MODULE_NAME, StringModuleResource::moduleName).build();
    private static final FeatureSetter<StringModuleResource> SET_MAP = new FeatureSetter.Builder<StringModuleResource>(FEATURE_COUNT, StringModuleResourceImpl::featureIndexStatic).add(StringModuleResource.FeatureIDs.PATH, (object, value) -> ((StringModuleResourceImpl) object).path((String) value)).add(StringModuleResource.FeatureIDs.MODULE_NAME, (object, value) -> ((StringModuleResourceImpl) object).moduleName((String) value)).build();
  }
}
