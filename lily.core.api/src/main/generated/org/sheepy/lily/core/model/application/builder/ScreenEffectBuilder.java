package org.sheepy.lily.core.model.application.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.core.model.application.CompositorExtensionPkg;
import org.sheepy.lily.core.model.application.ScreenEffect;
import org.sheepy.lily.core.model.application.ScreenEffect.Builder;
import org.sheepy.lily.core.model.application.SpecialEffect;
import org.sheepy.lily.core.model.application.impl.ScreenEffectImpl;
import org.sheepy.lily.core.model.resource.IImage;

public final class ScreenEffectBuilder implements Builder {
  private Supplier<CompositorExtensionPkg> extensionPkg = () -> null;
  private boolean enabled = true;
  private String name;
  private Supplier<IImage> srcImage = () -> null;
  private Supplier<IImage> dstImage;
  private Supplier<SpecialEffect> effect;

  public ScreenEffectBuilder() {
  }

  @Override
  public ScreenEffectBuilder extensionPkg(Supplier<CompositorExtensionPkg> extensionPkg) {
    this.extensionPkg = extensionPkg;
    return this;
  }

  @Override
  public ScreenEffectBuilder enabled(boolean enabled) {
    this.enabled = enabled;
    return this;
  }

  @Override
  public ScreenEffectBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public ScreenEffectBuilder srcImage(Supplier<IImage> srcImage) {
    this.srcImage = srcImage;
    return this;
  }

  @Override
  public ScreenEffectBuilder dstImage(Supplier<IImage> dstImage) {
    this.dstImage = dstImage;
    return this;
  }

  @Override
  public ScreenEffectBuilder effect(Supplier<SpecialEffect> effect) {
    this.effect = effect;
    return this;
  }

  @Override
  public ScreenEffect build() {
    final var built = new ScreenEffectImpl(enabled, name, dstImage.get(), effect.get());
    built.extensionPkg(extensionPkg.get());
    built.srcImage(srcImage.get());
    return built;
  }

  @Override
  public <AttributeType> void push(final Attribute<?, ?, ?, ?> attribute,
      final AttributeType value) {
    Inserters.ATTRIBUTE_INSERTER.push(this, attribute.id(), value);
  }

  @Override
  public <RelationType extends LMObject> void push(final Relation<RelationType, ?, ?, ?> relation,
      final Supplier<RelationType> supplier) {
    Inserters.RELATION_INSERTER.push(this, relation.id(), supplier);
  }

  private static final class Inserters {
    private static final FeatureInserter<ScreenEffectBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<ScreenEffectBuilder>(2, Inserters::attributeIndex).add(ScreenEffect.FeatureIDs.ENABLED, (builder, value) -> builder.enabled((boolean) value)).add(ScreenEffect.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).build();
    private static final RelationLazyInserter<ScreenEffectBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<ScreenEffectBuilder>(4, Inserters::relationIndex).add(ScreenEffect.FeatureIDs.EXTENSION_PKG, (builder, value) -> builder.extensionPkg((Supplier<CompositorExtensionPkg>) value)).add(ScreenEffect.FeatureIDs.SRC_IMAGE, (builder, value) -> builder.srcImage((Supplier<IImage>) value)).add(ScreenEffect.FeatureIDs.DST_IMAGE, (builder, value) -> builder.dstImage((Supplier<IImage>) value)).add(ScreenEffect.FeatureIDs.EFFECT, (builder, value) -> builder.effect((Supplier<SpecialEffect>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case ScreenEffect.FeatureIDs.ENABLED -> 0;
        case ScreenEffect.FeatureIDs.NAME -> 1;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case ScreenEffect.FeatureIDs.EXTENSION_PKG -> 0;
        case ScreenEffect.FeatureIDs.SRC_IMAGE -> 1;
        case ScreenEffect.FeatureIDs.DST_IMAGE -> 2;
        case ScreenEffect.FeatureIDs.EFFECT -> 3;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
