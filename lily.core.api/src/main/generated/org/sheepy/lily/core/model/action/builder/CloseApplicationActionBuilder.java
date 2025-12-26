package org.sheepy.lily.core.model.action.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.core.model.action.CloseApplicationAction;
import org.sheepy.lily.core.model.action.CloseApplicationAction.Builder;
import org.sheepy.lily.core.model.action.impl.CloseApplicationActionImpl;

public final class CloseApplicationActionBuilder implements Builder {
  private String name;

  public CloseApplicationActionBuilder() {
  }

  @Override
  public CloseApplicationActionBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public CloseApplicationAction build() {
    final var built = new CloseApplicationActionImpl(name);
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
    private static final FeatureInserter<CloseApplicationActionBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<CloseApplicationActionBuilder>(1, Inserters::attributeIndex).add(CloseApplicationAction.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).build();
    private static final RelationLazyInserter<CloseApplicationActionBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<CloseApplicationActionBuilder>(0, Inserters::relationIndex).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case CloseApplicationAction.FeatureIDs.NAME -> 0;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
    }
  }
}
