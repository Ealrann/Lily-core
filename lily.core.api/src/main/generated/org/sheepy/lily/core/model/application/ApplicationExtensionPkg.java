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
import org.sheepy.lily.core.model.application.builder.ApplicationExtensionPkgBuilder;

public interface ApplicationExtensionPkg extends LMObject {
  static Builder builder() {
    return new ApplicationExtensionPkgBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<IApplicationExtension> extensions();

  interface FeatureIDs {
    int EXTENSIONS = -1315444739;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Relation<IApplicationExtension, List<IApplicationExtension>, Listener<List<IApplicationExtension>>, Features<?>> EXTENSIONS = new RelationBuilder<IApplicationExtension, List<IApplicationExtension>, Listener<List<IApplicationExtension>>, Features<?>>().name("extensions").many(true).contains(true).id(ApplicationExtensionPkg.FeatureIDs.EXTENSIONS).concept(() -> ApplicationModelDefinition.Groups.I_APPLICATION_EXTENSION).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(EXTENSIONS);
  }

  interface Builder extends IFeaturedObject.Builder<ApplicationExtensionPkg> {
    Builder addExtension(Supplier<IApplicationExtension> extension);
    Builder addExtensions(List<IApplicationExtension> extensions);
  }
}
