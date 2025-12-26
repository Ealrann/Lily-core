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
import org.sheepy.lily.core.model.ui.FontPkg;
import org.sheepy.lily.core.model.ui.FontPkg.Builder;
import org.sheepy.lily.core.model.ui.impl.FontPkgImpl;

public final class FontPkgBuilder implements Builder {
  private final List<Supplier<Font>> fonts = new ArrayList<>();

  public FontPkgBuilder() {
  }

  @Override
  public FontPkgBuilder addFont(Supplier<Font> font) {
    this.fonts.add(font);
    return this;
  }

  @Override
  public FontPkgBuilder addFonts(final List<Font> fonts) {
    fonts.forEach(value -> this.fonts.add(() -> value));
    return this;
  }

  @Override
  public FontPkg build() {
    final var builtFonts = BuildUtils.collectSuppliers(fonts);
    final var built = new FontPkgImpl(builtFonts);
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
    private static final FeatureInserter<FontPkgBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<FontPkgBuilder>(0, Inserters::attributeIndex).build();
    private static final RelationLazyInserter<FontPkgBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<FontPkgBuilder>(1, Inserters::relationIndex).add(FontPkg.FeatureIDs.FONTS, (builder, value) -> builder.addFont((Supplier<Font>) value)).build();

    private static int attributeIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case FontPkg.FeatureIDs.FONTS -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
