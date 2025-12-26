package org.sheepy.lily.core.model.application.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.core.model.application.CompositorExtensionPkg;
import org.sheepy.lily.core.model.application.GenericScenePart;
import org.sheepy.lily.core.model.application.GenericScenePart.Builder;
import org.sheepy.lily.core.model.application.impl.GenericScenePartImpl;

public final class GenericScenePartBuilder implements Builder {
  private String name;
  private Supplier<CompositorExtensionPkg> extensionPkg = () -> null;
  private boolean enabled = true;

  public GenericScenePartBuilder() {
  }

  @Override
  public GenericScenePartBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public GenericScenePartBuilder extensionPkg(Supplier<CompositorExtensionPkg> extensionPkg) {
    this.extensionPkg = extensionPkg;
    return this;
  }

  @Override
  public GenericScenePartBuilder enabled(boolean enabled) {
    this.enabled = enabled;
    return this;
  }

  @Override
  public GenericScenePart build() {
    final var built = new GenericScenePartImpl(name, enabled);
    built.extensionPkg(extensionPkg.get());
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
    private static final FeatureInserter<GenericScenePartBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<GenericScenePartBuilder>(2, Inserters::attributeIndex).add(GenericScenePart.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(GenericScenePart.FeatureIDs.ENABLED, (builder, value) -> builder.enabled((boolean) value)).build();
    private static final RelationLazyInserter<GenericScenePartBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<GenericScenePartBuilder>(1, Inserters::relationIndex).add(GenericScenePart.FeatureIDs.EXTENSION_PKG, (builder, value) -> builder.extensionPkg((Supplier<CompositorExtensionPkg>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case GenericScenePart.FeatureIDs.NAME -> 0;
        case GenericScenePart.FeatureIDs.ENABLED -> 1;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case GenericScenePart.FeatureIDs.EXTENSION_PKG -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
