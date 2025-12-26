package org.sheepy.lily.core.model.application.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.application.ApplicationModelDefinition;
import org.sheepy.lily.core.model.application.CompositorExtensionPkg;
import org.sheepy.lily.core.model.application.ICompositorExtension;

public final class CompositorExtensionPkgImpl extends FeaturedObject<CompositorExtensionPkg.Features<?>> implements CompositorExtensionPkg {
  private static final int FEATURE_COUNT = 1;
  private final ModelNotifier<CompositorExtensionPkg.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final List<ICompositorExtension> extensions = newObservableList(CompositorExtensionPkg.FeatureIDs.EXTENSIONS, true, true);

  public CompositorExtensionPkgImpl() {
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<CompositorExtensionPkg.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public List<ICompositorExtension> extensions() {
    return extensions;
  }

  @Override
  public Group<CompositorExtensionPkg> lmGroup() {
    return ApplicationModelDefinition.Groups.COMPOSITOR_EXTENSION_PKG;
  }

  @Override
  protected FeatureSetter<CompositorExtensionPkg> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<CompositorExtensionPkg> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case CompositorExtensionPkg.FeatureIDs.EXTENSIONS -> 0;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<CompositorExtensionPkg> GET_MAP = new FeatureGetter.Builder<CompositorExtensionPkg>(FEATURE_COUNT, CompositorExtensionPkgImpl::featureIndexStatic).add(CompositorExtensionPkg.FeatureIDs.EXTENSIONS, CompositorExtensionPkg::extensions).build();
    private static final FeatureSetter<CompositorExtensionPkg> SET_MAP = new FeatureSetter.Builder<CompositorExtensionPkg>(FEATURE_COUNT, CompositorExtensionPkgImpl::featureIndexStatic).build();
  }
}
