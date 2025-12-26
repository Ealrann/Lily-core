package org.sheepy.lily.core.model.application.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import org.joml.Vector2ic;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.util.BuildUtils;
import org.sheepy.lily.core.model.application.ICompositor;
import org.sheepy.lily.core.model.application.Scene;
import org.sheepy.lily.core.model.application.Scene.Builder;
import org.sheepy.lily.core.model.application.impl.SceneImpl;
import org.sheepy.lily.core.model.resource.ResourcePkg;

public final class SceneBuilder implements Builder {
  private final List<Supplier<ICompositor>> compositors = new ArrayList<>();
  private boolean fullscreen = false;
  private boolean resizeable = false;
  private Vector2ic size = ((Function<String, Vector2ic>) it -> { if(it!=null){final String[] split=it.split(";");if(split.length==2){int x=Integer.parseInt(split[0]);int y=Integer.parseInt(split[1]);return new org.joml.Vector2i(x,y);}}return new org.joml.Vector2i(0,0); }).apply("400;400");
  private Supplier<ResourcePkg> resourcePkg = () -> null;

  public SceneBuilder() {
  }

  @Override
  public SceneBuilder addCompositor(Supplier<ICompositor> compositor) {
    this.compositors.add(compositor);
    return this;
  }

  @Override
  public SceneBuilder addCompositors(final List<ICompositor> compositors) {
    compositors.forEach(value -> this.compositors.add(() -> value));
    return this;
  }

  @Override
  public SceneBuilder fullscreen(boolean fullscreen) {
    this.fullscreen = fullscreen;
    return this;
  }

  @Override
  public SceneBuilder resizeable(boolean resizeable) {
    this.resizeable = resizeable;
    return this;
  }

  @Override
  public SceneBuilder size(Vector2ic size) {
    this.size = size;
    return this;
  }

  @Override
  public SceneBuilder resourcePkg(Supplier<ResourcePkg> resourcePkg) {
    this.resourcePkg = resourcePkg;
    return this;
  }

  @Override
  public Scene build() {
    final var builtCompositors = BuildUtils.collectSuppliers(compositors);
    final var built = new SceneImpl();
    built.compositors().addAll(builtCompositors);
    built.fullscreen(fullscreen);
    built.resizeable(resizeable);
    built.size(size);
    built.resourcePkg(resourcePkg.get());
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
    private static final FeatureInserter<SceneBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<SceneBuilder>(3, Inserters::attributeIndex).add(Scene.FeatureIDs.FULLSCREEN, (builder, value) -> builder.fullscreen((boolean) value)).add(Scene.FeatureIDs.RESIZEABLE, (builder, value) -> builder.resizeable((boolean) value)).add(Scene.FeatureIDs.SIZE, (builder, value) -> builder.size((Vector2ic) value)).build();
    private static final RelationLazyInserter<SceneBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<SceneBuilder>(2, Inserters::relationIndex).add(Scene.FeatureIDs.COMPOSITORS, (builder, value) -> builder.addCompositor((Supplier<ICompositor>) value)).add(Scene.FeatureIDs.RESOURCE_PKG, (builder, value) -> builder.resourcePkg((Supplier<ResourcePkg>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case Scene.FeatureIDs.FULLSCREEN -> 0;
        case Scene.FeatureIDs.RESIZEABLE -> 1;
        case Scene.FeatureIDs.SIZE -> 2;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case Scene.FeatureIDs.COMPOSITORS -> 0;
        case Scene.FeatureIDs.RESOURCE_PKG -> 1;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
