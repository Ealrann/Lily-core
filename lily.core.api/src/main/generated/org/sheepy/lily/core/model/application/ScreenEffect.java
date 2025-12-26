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
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.core.model.application.builder.ScreenEffectBuilder;
import org.sheepy.lily.core.model.resource.IImage;
import org.sheepy.lily.core.model.resource.ResourceModelDefinition;
import org.sheepy.lily.core.model.types.LNamedElement;

public interface ScreenEffect extends LNamedElement, ICompositor {
  static Builder builder() {
    return new ScreenEffectBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  IImage srcImage();
  IImage dstImage();
  SpecialEffect effect();
  void srcImage(final IImage srcImage);
  void dstImage(final IImage dstImage);
  void effect(final SpecialEffect effect);

  interface FeatureIDs {
    int EXTENSION_PKG = ICompositor.FeatureIDs.EXTENSION_PKG;
    int ENABLED = ICompositor.FeatureIDs.ENABLED;
    int NAME = Named.FeatureIDs.NAME;
    int SRC_IMAGE = -1798864568;
    int DST_IMAGE = -797016569;
    int EFFECT = -914204350;
  }

  interface Features<T extends Features<T>> extends LNamedElement.Features<T>, ICompositor.Features<T> {
    Relation<CompositorExtensionPkg, CompositorExtensionPkg, Listener<CompositorExtensionPkg>, ICompositor.Features<?>> EXTENSION_PKG = ICompositor.Features.EXTENSION_PKG;
    Attribute<Boolean, Boolean, BooleanListener, ICompositor.Features<?>> ENABLED = ICompositor.Features.ENABLED;
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Relation<IImage, IImage, Listener<IImage>, Features<?>> SRC_IMAGE = new RelationBuilder<IImage, IImage, Listener<IImage>, Features<?>>().name("srcImage").id(ScreenEffect.FeatureIDs.SRC_IMAGE).concept(() -> ResourceModelDefinition.Groups.I_IMAGE).build();
    Relation<IImage, IImage, Listener<IImage>, Features<?>> DST_IMAGE = new RelationBuilder<IImage, IImage, Listener<IImage>, Features<?>>().name("dstImage").mandatory(true).id(ScreenEffect.FeatureIDs.DST_IMAGE).concept(() -> ResourceModelDefinition.Groups.I_IMAGE).build();
    Relation<SpecialEffect, SpecialEffect, Listener<SpecialEffect>, Features<?>> EFFECT = new RelationBuilder<SpecialEffect, SpecialEffect, Listener<SpecialEffect>, Features<?>>().name("effect").mandatory(true).contains(true).id(ScreenEffect.FeatureIDs.EFFECT).concept(() -> ApplicationModelDefinition.Groups.SPECIAL_EFFECT).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(EXTENSION_PKG, ENABLED, NAME, SRC_IMAGE, DST_IMAGE, EFFECT);
  }

  interface Builder extends IFeaturedObject.Builder<ScreenEffect> {
    Builder extensionPkg(Supplier<CompositorExtensionPkg> extensionPkg);
    Builder enabled(boolean enabled);
    Builder name(String name);
    Builder srcImage(Supplier<IImage> srcImage);
    Builder dstImage(Supplier<IImage> dstImage);
    Builder effect(Supplier<SpecialEffect> effect);
  }
}
