package org.sheepy.lily.core.model.application.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.application.ApplicationExtensionPkg;
import org.sheepy.lily.core.model.application.ApplicationModelDefinition;
import org.sheepy.lily.core.model.application.IApplicationExtension;

public final class ApplicationExtensionPkgImpl extends FeaturedObject<ApplicationExtensionPkg.Features<?>> implements ApplicationExtensionPkg {
  private static final int FEATURE_COUNT = 1;
  private final ModelNotifier<ApplicationExtensionPkg.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final List<IApplicationExtension> extensions = newObservableList(ApplicationExtensionPkg.FeatureIDs.EXTENSIONS, true, true);

  public ApplicationExtensionPkgImpl() {
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<ApplicationExtensionPkg.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public List<IApplicationExtension> extensions() {
    return extensions;
  }

  @Override
  public Group<ApplicationExtensionPkg> lmGroup() {
    return ApplicationModelDefinition.Groups.APPLICATION_EXTENSION_PKG;
  }

  @Override
  protected FeatureSetter<ApplicationExtensionPkg> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<ApplicationExtensionPkg> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case ApplicationExtensionPkg.FeatureIDs.EXTENSIONS -> 0;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<ApplicationExtensionPkg> GET_MAP = new FeatureGetter.Builder<ApplicationExtensionPkg>(FEATURE_COUNT, ApplicationExtensionPkgImpl::featureIndexStatic).add(ApplicationExtensionPkg.FeatureIDs.EXTENSIONS, ApplicationExtensionPkg::extensions).build();
    private static final FeatureSetter<ApplicationExtensionPkg> SET_MAP = new FeatureSetter.Builder<ApplicationExtensionPkg>(FEATURE_COUNT, ApplicationExtensionPkgImpl::featureIndexStatic).build();
  }
}
