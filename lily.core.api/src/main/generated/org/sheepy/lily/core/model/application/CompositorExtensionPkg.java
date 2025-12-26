package org.sheepy.lily.core.model.application;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.core.model.application.builder.CompositorExtensionPkgBuilder;

public interface CompositorExtensionPkg extends LMObject {
  static Builder builder() {
    return new CompositorExtensionPkgBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<ICompositorExtension> extensions();

  interface FeatureIDs {
    int EXTENSIONS = -1795862764;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Relation<ICompositorExtension, List<ICompositorExtension>, Listener<List<ICompositorExtension>>, Features<?>> EXTENSIONS = new RelationBuilder<ICompositorExtension, List<ICompositorExtension>, Listener<List<ICompositorExtension>>, Features<?>>().name("extensions").many(true).contains(true).id(CompositorExtensionPkg.FeatureIDs.EXTENSIONS).concept(() -> ApplicationModelDefinition.Groups.I_COMPOSITOR_EXTENSION).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(EXTENSIONS);
  }

  interface Builder extends IFeaturedObject.Builder<CompositorExtensionPkg> {
    Builder addExtension(Supplier<ICompositorExtension> extension);
    Builder addExtensions(List<ICompositorExtension> extensions);
  }
}
