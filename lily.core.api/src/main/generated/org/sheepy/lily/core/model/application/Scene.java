package org.sheepy.lily.core.model.application;

import java.util.List;
import java.util.function.Supplier;
import org.joml.Vector2ic;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.BooleanListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.core.model.application.builder.SceneBuilder;
import org.sheepy.lily.core.model.resource.ResourceModelDefinition;
import org.sheepy.lily.core.model.resource.ResourcePkg;
import org.sheepy.lily.core.model.types.TypesModelDefinition;

public interface Scene extends LMObject {
  static Builder builder() {
    return new SceneBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<ICompositor> compositors();
  boolean fullscreen();
  boolean resizeable();
  Vector2ic size();
  ResourcePkg resourcePkg();
  void fullscreen(final boolean fullscreen);
  void resizeable(final boolean resizeable);
  void size(final Vector2ic size);
  void resourcePkg(final ResourcePkg resourcePkg);

  interface FeatureIDs {
    int COMPOSITORS = 1188331096;
    int FULLSCREEN = -2041295563;
    int RESIZEABLE = -101021304;
    int SIZE = -1569991429;
    int RESOURCE_PKG = -1033195356;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Relation<ICompositor, List<ICompositor>, Listener<List<ICompositor>>, Features<?>> COMPOSITORS = new RelationBuilder<ICompositor, List<ICompositor>, Listener<List<ICompositor>>, Features<?>>().name("compositors").many(true).contains(true).id(Scene.FeatureIDs.COMPOSITORS).concept(() -> ApplicationModelDefinition.Groups.I_COMPOSITOR).build();
    Attribute<Boolean, Boolean, BooleanListener, Features<?>> FULLSCREEN = new AttributeBuilder<Boolean, Boolean, BooleanListener, Features<?>>().name("fullscreen").defaultValue("false").id(Scene.FeatureIDs.FULLSCREEN).datatype(() -> LMCoreModelDefinition.Units.BOOLEAN).build();
    Attribute<Boolean, Boolean, BooleanListener, Features<?>> RESIZEABLE = new AttributeBuilder<Boolean, Boolean, BooleanListener, Features<?>>().name("resizeable").defaultValue("false").id(Scene.FeatureIDs.RESIZEABLE).datatype(() -> LMCoreModelDefinition.Units.BOOLEAN).build();
    Attribute<Vector2ic, Vector2ic, Listener<Vector2ic>, Features<?>> SIZE = new AttributeBuilder<Vector2ic, Vector2ic, Listener<Vector2ic>, Features<?>>().name("size").defaultValue("400;400").id(Scene.FeatureIDs.SIZE).datatype(() -> TypesModelDefinition.JavaWrappers.VECTOR2I).build();
    Relation<ResourcePkg, ResourcePkg, Listener<ResourcePkg>, Features<?>> RESOURCE_PKG = new RelationBuilder<ResourcePkg, ResourcePkg, Listener<ResourcePkg>, Features<?>>().name("resourcePkg").contains(true).id(Scene.FeatureIDs.RESOURCE_PKG).concept(() -> ResourceModelDefinition.Groups.RESOURCE_PKG).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(COMPOSITORS, FULLSCREEN, RESIZEABLE, SIZE, RESOURCE_PKG);
  }

  interface Builder extends IFeaturedObject.Builder<Scene> {
    Builder addCompositor(Supplier<ICompositor> compositor);
    Builder fullscreen(boolean fullscreen);
    Builder resizeable(boolean resizeable);
    Builder size(Vector2ic size);
    Builder resourcePkg(Supplier<ResourcePkg> resourcePkg);
    Builder addCompositors(List<ICompositor> compositors);
  }
}
