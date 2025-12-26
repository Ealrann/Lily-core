package org.sheepy.lily.core.model.ui.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.core.model.ui.DynamicRowLayout;
import org.sheepy.lily.core.model.ui.DynamicRowLayout.Builder;
import org.sheepy.lily.core.model.ui.impl.DynamicRowLayoutImpl;

public final class DynamicRowLayoutBuilder implements Builder {
  private int height = 16;
  private int columnCount = 1;

  public DynamicRowLayoutBuilder() {
  }

  @Override
  public DynamicRowLayoutBuilder height(int height) {
    this.height = height;
    return this;
  }

  @Override
  public DynamicRowLayoutBuilder columnCount(int columnCount) {
    this.columnCount = columnCount;
    return this;
  }

  @Override
  public DynamicRowLayout build() {
    final var built = new DynamicRowLayoutImpl();
    built.height(height);
    built.columnCount(columnCount);
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
    private static final FeatureInserter<DynamicRowLayoutBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<DynamicRowLayoutBuilder>(2, Inserters::attributeIndex).add(DynamicRowLayout.FeatureIDs.HEIGHT, (builder, value) -> builder.height((int) value)).add(DynamicRowLayout.FeatureIDs.COLUMN_COUNT, (builder, value) -> builder.columnCount((int) value)).build();
    private static final RelationLazyInserter<DynamicRowLayoutBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<DynamicRowLayoutBuilder>(0, Inserters::relationIndex).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case DynamicRowLayout.FeatureIDs.HEIGHT -> 0;
        case DynamicRowLayout.FeatureIDs.COLUMN_COUNT -> 1;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
    }
  }
}
