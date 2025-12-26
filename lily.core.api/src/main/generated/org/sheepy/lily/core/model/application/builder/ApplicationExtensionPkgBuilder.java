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
import org.sheepy.lily.core.model.application.ApplicationExtensionPkg;
import org.sheepy.lily.core.model.application.ApplicationExtensionPkg.Builder;
import org.sheepy.lily.core.model.application.IApplicationExtension;
import org.sheepy.lily.core.model.application.impl.ApplicationExtensionPkgImpl;

public final class ApplicationExtensionPkgBuilder implements Builder {
  private final List<Supplier<IApplicationExtension>> extensions = new ArrayList<>();

  public ApplicationExtensionPkgBuilder() {
  }

  @Override
  public ApplicationExtensionPkgBuilder addExtension(Supplier<IApplicationExtension> extension) {
    this.extensions.add(extension);
    return this;
  }

  @Override
  public ApplicationExtensionPkgBuilder addExtensions(
      final List<IApplicationExtension> extensions) {
    extensions.forEach(value -> this.extensions.add(() -> value));
    return this;
  }

  @Override
  public ApplicationExtensionPkg build() {
    final var builtExtensions = BuildUtils.collectSuppliers(extensions);
    final var built = new ApplicationExtensionPkgImpl();
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
    private static final FeatureInserter<ApplicationExtensionPkgBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<ApplicationExtensionPkgBuilder>(0, Inserters::attributeIndex).build();
    private static final RelationLazyInserter<ApplicationExtensionPkgBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<ApplicationExtensionPkgBuilder>(1, Inserters::relationIndex).add(ApplicationExtensionPkg.FeatureIDs.EXTENSIONS, (builder, value) -> builder.addExtension((Supplier<IApplicationExtension>) value)).build();

    private static int attributeIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case ApplicationExtensionPkg.FeatureIDs.EXTENSIONS -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
