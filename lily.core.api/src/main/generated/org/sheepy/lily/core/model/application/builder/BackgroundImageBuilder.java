package org.sheepy.lily.core.model.application.builder;

import java.util.function.Function;
import java.util.function.Supplier;
import org.joml.Vector3ic;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.core.model.application.BackgroundImage;
import org.sheepy.lily.core.model.application.BackgroundImage.Builder;
import org.sheepy.lily.core.model.application.CompositorExtensionPkg;
import org.sheepy.lily.core.model.application.impl.BackgroundImageImpl;
import org.sheepy.lily.core.model.resource.ESampling;
import org.sheepy.lily.core.model.resource.IImage;

public final class BackgroundImageBuilder implements Builder {
  private Supplier<CompositorExtensionPkg> extensionPkg = () -> null;
  private boolean enabled = true;
  private String name;
  private Vector3ic clearColor = ((Function<String, Vector3ic>) it -> { if(it!=null){final String[] split=it.split(";");if(split.length==3){int x=Integer.parseInt(split[0]);int y=Integer.parseInt(split[1]);int z=Integer.parseInt(split[2]);return new org.joml.Vector3i(x,y,z);}}return new org.joml.Vector3i(0,0,0); }).apply("0;0;0");
  private ESampling sampling = ESampling.Linear;
  private Supplier<IImage> srcImage = () -> null;
  private Supplier<IImage> dstImage = () -> null;

  public BackgroundImageBuilder() {
  }

  @Override
  public BackgroundImageBuilder extensionPkg(Supplier<CompositorExtensionPkg> extensionPkg) {
    this.extensionPkg = extensionPkg;
    return this;
  }

  @Override
  public BackgroundImageBuilder enabled(boolean enabled) {
    this.enabled = enabled;
    return this;
  }

  @Override
  public BackgroundImageBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public BackgroundImageBuilder clearColor(Vector3ic clearColor) {
    this.clearColor = clearColor;
    return this;
  }

  @Override
  public BackgroundImageBuilder sampling(ESampling sampling) {
    this.sampling = sampling;
    return this;
  }

  @Override
  public BackgroundImageBuilder srcImage(Supplier<IImage> srcImage) {
    this.srcImage = srcImage;
    return this;
  }

  @Override
  public BackgroundImageBuilder dstImage(Supplier<IImage> dstImage) {
    this.dstImage = dstImage;
    return this;
  }

  @Override
  public BackgroundImage build() {
    final var built = new BackgroundImageImpl(enabled, name, clearColor, sampling);
    built.extensionPkg(extensionPkg.get());
    built.srcImage(srcImage.get());
    built.dstImage(dstImage.get());
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
    private static final FeatureInserter<BackgroundImageBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<BackgroundImageBuilder>(4, Inserters::attributeIndex).add(BackgroundImage.FeatureIDs.ENABLED, (builder, value) -> builder.enabled((boolean) value)).add(BackgroundImage.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(BackgroundImage.FeatureIDs.CLEAR_COLOR, (builder, value) -> builder.clearColor((Vector3ic) value)).add(BackgroundImage.FeatureIDs.SAMPLING, (builder, value) -> builder.sampling((ESampling) value)).build();
    private static final RelationLazyInserter<BackgroundImageBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<BackgroundImageBuilder>(3, Inserters::relationIndex).add(BackgroundImage.FeatureIDs.EXTENSION_PKG, (builder, value) -> builder.extensionPkg((Supplier<CompositorExtensionPkg>) value)).add(BackgroundImage.FeatureIDs.SRC_IMAGE, (builder, value) -> builder.srcImage((Supplier<IImage>) value)).add(BackgroundImage.FeatureIDs.DST_IMAGE, (builder, value) -> builder.dstImage((Supplier<IImage>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case BackgroundImage.FeatureIDs.ENABLED -> 0;
        case BackgroundImage.FeatureIDs.NAME -> 1;
        case BackgroundImage.FeatureIDs.CLEAR_COLOR -> 2;
        case BackgroundImage.FeatureIDs.SAMPLING -> 3;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case BackgroundImage.FeatureIDs.EXTENSION_PKG -> 0;
        case BackgroundImage.FeatureIDs.SRC_IMAGE -> 1;
        case BackgroundImage.FeatureIDs.DST_IMAGE -> 2;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
