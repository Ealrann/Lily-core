package org.sheepy.lily.core.model.application;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.BooleanListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.core.model.application.builder.GenericScenePartBuilder;
import org.sheepy.lily.core.model.types.LNamedElement;

public interface GenericScenePart extends ICompositor, LNamedElement {
  static Builder builder() {
    return new GenericScenePartBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int EXTENSION_PKG = ICompositor.FeatureIDs.EXTENSION_PKG;
    int ENABLED = ICompositor.FeatureIDs.ENABLED;
  }

  interface Features<T extends Features<T>> extends ICompositor.Features<T>, LNamedElement.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Relation<CompositorExtensionPkg, CompositorExtensionPkg, Listener<CompositorExtensionPkg>, ICompositor.Features<?>> EXTENSION_PKG = ICompositor.Features.EXTENSION_PKG;
    Attribute<Boolean, Boolean, BooleanListener, ICompositor.Features<?>> ENABLED = ICompositor.Features.ENABLED;
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, EXTENSION_PKG, ENABLED);
  }

  interface Builder extends IFeaturedObject.Builder<GenericScenePart> {
    Builder name(String name);
    Builder extensionPkg(Supplier<CompositorExtensionPkg> extensionPkg);
    Builder enabled(boolean enabled);
  }
}
