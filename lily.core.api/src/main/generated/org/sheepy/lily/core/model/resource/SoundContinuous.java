package org.sheepy.lily.core.model.resource;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.IntListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.sheepy.lily.core.model.resource.builder.SoundContinuousBuilder;

public interface SoundContinuous extends Sound {
  static Builder builder() {
    return new SoundContinuousBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  int attackMs();
  int decayMs();
  void attackMs(final int attackMs);
  void decayMs(final int decayMs);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int FILE = Sound.FeatureIDs.FILE;
    int ATTACK_MS = 749939476;
    int DECAY_MS = 856112442;
  }

  interface Features<T extends Features<T>> extends Sound.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Relation<FileResource, FileResource, Listener<FileResource>, Sound.Features<?>> FILE = Sound.Features.FILE;
    Attribute<Integer, Integer, IntListener, Features<?>> ATTACK_MS = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("attackMs").mandatory(true).id(SoundContinuous.FeatureIDs.ATTACK_MS).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    Attribute<Integer, Integer, IntListener, Features<?>> DECAY_MS = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("decayMs").mandatory(true).id(SoundContinuous.FeatureIDs.DECAY_MS).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, FILE, ATTACK_MS, DECAY_MS);
  }

  interface Builder extends IFeaturedObject.Builder<SoundContinuous> {
    Builder name(String name);
    Builder file(Supplier<FileResource> file);
    Builder attackMs(int attackMs);
    Builder decayMs(int decayMs);
  }
}
