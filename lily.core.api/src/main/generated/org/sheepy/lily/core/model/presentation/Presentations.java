package org.sheepy.lily.core.model.presentation;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.core.model.presentation.builder.PresentationsBuilder;

public interface Presentations extends LMObject {
  static Builder builder() {
    return new PresentationsBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<IPresentationPkg> presentationPkgs();

  interface FeatureIDs {
    int PRESENTATION_PKGS = -451743072;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Relation<IPresentationPkg, List<IPresentationPkg>, Listener<List<IPresentationPkg>>, Features<?>> PRESENTATION_PKGS = new RelationBuilder<IPresentationPkg, List<IPresentationPkg>, Listener<List<IPresentationPkg>>, Features<?>>().name("presentationPkgs").many(true).contains(true).id(Presentations.FeatureIDs.PRESENTATION_PKGS).concept(() -> PresentationModelDefinition.Groups.I_PRESENTATION_PKG).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(PRESENTATION_PKGS);
  }

  interface Builder extends IFeaturedObject.Builder<Presentations> {
    Builder addPresentationPkg(Supplier<IPresentationPkg> presentationPkg);
    Builder addPresentationPkgs(List<IPresentationPkg> presentationPkgs);
  }
}
