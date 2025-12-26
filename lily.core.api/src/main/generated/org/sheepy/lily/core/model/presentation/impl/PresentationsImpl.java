package org.sheepy.lily.core.model.presentation.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.presentation.IPresentationPkg;
import org.sheepy.lily.core.model.presentation.PresentationModelDefinition;
import org.sheepy.lily.core.model.presentation.Presentations;

public final class PresentationsImpl extends FeaturedObject<Presentations.Features<?>> implements Presentations {
  private static final int FEATURE_COUNT = 1;
  private final ModelNotifier<Presentations.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final List<IPresentationPkg> presentationPkgs = newObservableList(Presentations.FeatureIDs.PRESENTATION_PKGS, true, true);

  public PresentationsImpl() {
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<Presentations.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public List<IPresentationPkg> presentationPkgs() {
    return presentationPkgs;
  }

  @Override
  public Group<Presentations> lmGroup() {
    return PresentationModelDefinition.Groups.PRESENTATIONS;
  }

  @Override
  protected FeatureSetter<Presentations> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<Presentations> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case Presentations.FeatureIDs.PRESENTATION_PKGS -> 0;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<Presentations> GET_MAP = new FeatureGetter.Builder<Presentations>(FEATURE_COUNT, PresentationsImpl::featureIndexStatic).add(Presentations.FeatureIDs.PRESENTATION_PKGS, Presentations::presentationPkgs).build();
    private static final FeatureSetter<Presentations> SET_MAP = new FeatureSetter.Builder<Presentations>(FEATURE_COUNT, PresentationsImpl::featureIndexStatic).build();
  }
}
