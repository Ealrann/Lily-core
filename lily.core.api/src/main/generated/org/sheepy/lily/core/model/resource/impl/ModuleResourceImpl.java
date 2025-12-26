package org.sheepy.lily.core.model.resource.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.resource.FileResource;
import org.sheepy.lily.core.model.resource.ModuleResource;
import org.sheepy.lily.core.model.resource.ResourceModelDefinition;

public final class ModuleResourceImpl extends FeaturedObject<ModuleResource.Features<?>> implements ModuleResource {
  private static final int FEATURE_COUNT = 3;
  private final ModelNotifier<ModuleResource.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private String path;
  private Module module;

  public ModuleResourceImpl(final String name, final String path, final Module module) {
    this.name = name;
    this.path = path;
    this.module = module;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<ModuleResource.Features<?>> notifier() {
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
  public Module module() {
    return module;
  }

  @Override
  public void module(final Module module) {
    final var oldValue = this.module;
    this.module = module;
    notifier.notify(ModuleResource.FeatureIDs.MODULE, false, false, oldValue, module);
  }

  @Override
  public Group<ModuleResource> lmGroup() {
    return ResourceModelDefinition.Groups.MODULE_RESOURCE;
  }

  @Override
  protected FeatureSetter<ModuleResource> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<ModuleResource> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case ModuleResource.FeatureIDs.NAME -> 0;
      case ModuleResource.FeatureIDs.PATH -> 1;
      case ModuleResource.FeatureIDs.MODULE -> 2;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<ModuleResource> GET_MAP = new FeatureGetter.Builder<ModuleResource>(FEATURE_COUNT, ModuleResourceImpl::featureIndexStatic).add(ModuleResource.FeatureIDs.NAME, ModuleResource::name).add(ModuleResource.FeatureIDs.PATH, ModuleResource::path).add(ModuleResource.FeatureIDs.MODULE, ModuleResource::module).build();
    private static final FeatureSetter<ModuleResource> SET_MAP = new FeatureSetter.Builder<ModuleResource>(FEATURE_COUNT, ModuleResourceImpl::featureIndexStatic).add(ModuleResource.FeatureIDs.PATH, (object, value) -> ((ModuleResourceImpl) object).path((String) value)).add(ModuleResource.FeatureIDs.MODULE, (object, value) -> ((ModuleResourceImpl) object).module((Module) value)).build();
  }
}
