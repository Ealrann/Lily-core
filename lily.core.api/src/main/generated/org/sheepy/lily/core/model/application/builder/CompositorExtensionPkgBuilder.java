package org.sheepy.lily.core.model.application.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.util.BuildUtils;
import org.sheepy.lily.core.model.application.CompositorExtensionPkg;
import org.sheepy.lily.core.model.application.CompositorExtensionPkg.Builder;
import org.sheepy.lily.core.model.application.ICompositorExtension;
import org.sheepy.lily.core.model.application.impl.CompositorExtensionPkgImpl;

public final class CompositorExtensionPkgBuilder implements Builder {
  private final List<Supplier<ICompositorExtension>> extensions = new ArrayList<>();

  public CompositorExtensionPkgBuilder() {
  }

  @Override
  public CompositorExtensionPkgBuilder addExtension(Supplier<ICompositorExtension> extension) {
    this.extensions.add(extension);
    return this;
  }

  @Override
  public CompositorExtensionPkgBuilder addExtensions(final List<ICompositorExtension> extensions) {
    extensions.forEach(value -> this.extensions.add(() -> value));
    return this;
  }

  @Override
  public CompositorExtensionPkg build() {
    final var builtExtensions = BuildUtils.collectSuppliers(extensions);
    final var built = new CompositorExtensionPkgImpl();
    built.extensions().addAll(builtExtensions);
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
    private static final FeatureInserter<CompositorExtensionPkgBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<CompositorExtensionPkgBuilder>(0, Inserters::attributeIndex).build();
    private static final RelationLazyInserter<CompositorExtensionPkgBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<CompositorExtensionPkgBuilder>(1, Inserters::relationIndex).add(CompositorExtensionPkg.FeatureIDs.EXTENSIONS, (builder, value) -> builder.addExtension((Supplier<ICompositorExtension>) value)).build();

    private static int attributeIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case CompositorExtensionPkg.FeatureIDs.EXTENSIONS -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
