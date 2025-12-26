package org.sheepy.lily.core.model.ui.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.util.BuildUtils;
import org.sheepy.lily.core.model.ui.Font;
import org.sheepy.lily.core.model.ui.Font.Builder;
import org.sheepy.lily.core.model.ui.FontTable;
import org.sheepy.lily.core.model.ui.impl.FontImpl;

public final class FontBuilder implements Builder {
  private String name;
  private final List<Supplier<FontTable>> tables = new ArrayList<>();
  private float height = 18f;

  public FontBuilder() {
  }

  @Override
  public FontBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public FontBuilder addTable(Supplier<FontTable> table) {
    this.tables.add(table);
    return this;
  }

  @Override
  public FontBuilder addTables(final List<FontTable> tables) {
    tables.forEach(value -> this.tables.add(() -> value));
    return this;
  }

  @Override
  public FontBuilder height(float height) {
    this.height = height;
    return this;
  }

  @Override
  public Font build() {
    final var builtTables = BuildUtils.collectSuppliers(tables);
    final var built = new FontImpl(name, builtTables, height);
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
    private static final FeatureInserter<FontBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<FontBuilder>(2, Inserters::attributeIndex).add(Font.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(Font.FeatureIDs.HEIGHT, (builder, value) -> builder.height((float) value)).build();
    private static final RelationLazyInserter<FontBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<FontBuilder>(1, Inserters::relationIndex).add(Font.FeatureIDs.TABLES, (builder, value) -> builder.addTable((Supplier<FontTable>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case Font.FeatureIDs.NAME -> 0;
        case Font.FeatureIDs.HEIGHT -> 1;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case Font.FeatureIDs.TABLES -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
