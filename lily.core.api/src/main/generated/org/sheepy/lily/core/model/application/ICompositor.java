package org.sheepy.lily.core.model.application;

import java.util.List;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.BooleanListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.core.model.inference.IInferenceObject;

public interface ICompositor extends IInferenceObject {
  @Override
  IModelNotifier<? extends Features<?>> notifier();
  CompositorExtensionPkg extensionPkg();
  boolean enabled();
  void extensionPkg(final CompositorExtensionPkg extensionPkg);
  void enabled(final boolean enabled);

  interface FeatureIDs {
    int EXTENSION_PKG = -206077175;
    int ENABLED = -1036452923;
  }

  interface Features<T extends Features<T>> extends IInferenceObject.Features<T> {
    Relation<CompositorExtensionPkg, CompositorExtensionPkg, Listener<CompositorExtensionPkg>, Features<?>> EXTENSION_PKG = new RelationBuilder<CompositorExtensionPkg, CompositorExtensionPkg, Listener<CompositorExtensionPkg>, Features<?>>().name("extensionPkg").contains(true).id(ICompositor.FeatureIDs.EXTENSION_PKG).concept(() -> ApplicationModelDefinition.Groups.COMPOSITOR_EXTENSION_PKG).build();
    Attribute<Boolean, Boolean, BooleanListener, Features<?>> ENABLED = new AttributeBuilder<Boolean, Boolean, BooleanListener, Features<?>>().name("enabled").mandatory(true).defaultValue("true").id(ICompositor.FeatureIDs.ENABLED).datatype(() -> LMCoreModelDefinition.Units.BOOLEAN).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(EXTENSION_PKG, ENABLED);
  }
}
