package org.sheepy.lily.core.model.application;

import java.util.List;
import java.util.function.Supplier;
import org.joml.Vector3ic;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.BooleanListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.core.model.application.builder.BackgroundImageBuilder;
import org.sheepy.lily.core.model.resource.ESampling;
import org.sheepy.lily.core.model.resource.IImage;
import org.sheepy.lily.core.model.resource.ResourceModelDefinition;
import org.sheepy.lily.core.model.types.LNamedElement;
import org.sheepy.lily.core.model.types.TypesModelDefinition;

public interface BackgroundImage extends LNamedElement, ICompositor {
  static Builder builder() {
    return new BackgroundImageBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  Vector3ic clearColor();
  ESampling sampling();
  IImage srcImage();
  IImage dstImage();
  void clearColor(final Vector3ic clearColor);
  void sampling(final ESampling sampling);
  void srcImage(final IImage srcImage);
  void dstImage(final IImage dstImage);

  interface FeatureIDs {
    int EXTENSION_PKG = ICompositor.FeatureIDs.EXTENSION_PKG;
    int ENABLED = ICompositor.FeatureIDs.ENABLED;
    int NAME = Named.FeatureIDs.NAME;
    int CLEAR_COLOR = 894507183;
    int SAMPLING = -1575777856;
    int SRC_IMAGE = 304595888;
    int DST_IMAGE = 1306443887;
  }

  interface Features<T extends Features<T>> extends LNamedElement.Features<T>, ICompositor.Features<T> {
    Relation<CompositorExtensionPkg, CompositorExtensionPkg, Listener<CompositorExtensionPkg>, ICompositor.Features<?>> EXTENSION_PKG = ICompositor.Features.EXTENSION_PKG;
    Attribute<Boolean, Boolean, BooleanListener, ICompositor.Features<?>> ENABLED = ICompositor.Features.ENABLED;
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<Vector3ic, Vector3ic, Listener<Vector3ic>, Features<?>> CLEAR_COLOR = new AttributeBuilder<Vector3ic, Vector3ic, Listener<Vector3ic>, Features<?>>().name("clearColor").mandatory(true).defaultValue("0;0;0").id(BackgroundImage.FeatureIDs.CLEAR_COLOR).datatype(() -> TypesModelDefinition.JavaWrappers.VECTOR3I).build();
    Attribute<ESampling, ESampling, Listener<ESampling>, Features<?>> SAMPLING = new AttributeBuilder<ESampling, ESampling, Listener<ESampling>, Features<?>>().name("sampling").mandatory(true).defaultValue("Linear").id(BackgroundImage.FeatureIDs.SAMPLING).datatype(() -> ResourceModelDefinition.Enums.E_SAMPLING).build();
    Relation<IImage, IImage, Listener<IImage>, Features<?>> SRC_IMAGE = new RelationBuilder<IImage, IImage, Listener<IImage>, Features<?>>().name("srcImage").id(BackgroundImage.FeatureIDs.SRC_IMAGE).concept(() -> ResourceModelDefinition.Groups.I_IMAGE).build();
    Relation<IImage, IImage, Listener<IImage>, Features<?>> DST_IMAGE = new RelationBuilder<IImage, IImage, Listener<IImage>, Features<?>>().name("dstImage").id(BackgroundImage.FeatureIDs.DST_IMAGE).concept(() -> ResourceModelDefinition.Groups.I_IMAGE).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(EXTENSION_PKG, ENABLED, NAME, CLEAR_COLOR, SAMPLING, SRC_IMAGE, DST_IMAGE);
  }

  interface Builder extends IFeaturedObject.Builder<BackgroundImage> {
    Builder extensionPkg(Supplier<CompositorExtensionPkg> extensionPkg);
    Builder enabled(boolean enabled);
    Builder name(String name);
    Builder clearColor(Vector3ic clearColor);
    Builder sampling(ESampling sampling);
    Builder srcImage(Supplier<IImage> srcImage);
    Builder dstImage(Supplier<IImage> dstImage);
  }
}
