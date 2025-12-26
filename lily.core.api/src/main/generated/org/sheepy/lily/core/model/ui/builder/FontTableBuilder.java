package org.sheepy.lily.core.model.ui.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.core.model.resource.FileResource;
import org.sheepy.lily.core.model.types.ECharTable;
import org.sheepy.lily.core.model.ui.FontTable;
import org.sheepy.lily.core.model.ui.FontTable.Builder;
import org.sheepy.lily.core.model.ui.impl.FontTableImpl;

public final class FontTableBuilder implements Builder {
  private String name;
  private Supplier<FileResource> file;
  private final List<ECharTable> charTables = new ArrayList<>();

  public FontTableBuilder() {
  }

  @Override
  public FontTableBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public FontTableBuilder file(Supplier<FileResource> file) {
    this.file = file;
    return this;
  }

  @Override
  public FontTableBuilder addCharTable(ECharTable charTable) {
    this.charTables.add(charTable);
    return this;
  }

  @Override
  public FontTableBuilder addCharTables(final List<ECharTable> charTables) {
    this.charTables.addAll(charTables);
    return this;
  }

  @Override
  public FontTable build() {
    final var built = new FontTableImpl(name, file.get(), charTables);
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
    private static final FeatureInserter<FontTableBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<FontTableBuilder>(2, Inserters::attributeIndex).add(FontTable.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(FontTable.FeatureIDs.CHAR_TABLES, (builder, value) -> builder.addCharTable((ECharTable) value)).build();
    private static final RelationLazyInserter<FontTableBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<FontTableBuilder>(1, Inserters::relationIndex).add(FontTable.FeatureIDs.FILE, (builder, value) -> builder.file((Supplier<FileResource>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case FontTable.FeatureIDs.NAME -> 0;
        case FontTable.FeatureIDs.CHAR_TABLES -> 1;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case FontTable.FeatureIDs.FILE -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
