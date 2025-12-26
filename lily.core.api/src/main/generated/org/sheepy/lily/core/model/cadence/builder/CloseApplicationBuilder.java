package org.sheepy.lily.core.model.cadence.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.core.model.cadence.CloseApplication;
import org.sheepy.lily.core.model.cadence.CloseApplication.Builder;
import org.sheepy.lily.core.model.cadence.impl.CloseApplicationImpl;

public final class CloseApplicationBuilder implements Builder {
  public CloseApplicationBuilder() {
  }

  @Override
  public CloseApplication build() {
    final var built = new CloseApplicationImpl();
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
    private static final FeatureInserter<CloseApplicationBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<CloseApplicationBuilder>(0, Inserters::attributeIndex).build();
    private static final RelationLazyInserter<CloseApplicationBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<CloseApplicationBuilder>(0, Inserters::relationIndex).build();

    private static int attributeIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
    }

    private static int relationIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
    }
  }
}
