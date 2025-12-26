package org.sheepy.lily.core.model.cadence.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.core.model.cadence.PrintUPS;
import org.sheepy.lily.core.model.cadence.PrintUPS.Builder;
import org.sheepy.lily.core.model.cadence.impl.PrintUPSImpl;

public final class PrintUPSBuilder implements Builder {
  private int printEveryMs = 2000;

  public PrintUPSBuilder() {
  }

  @Override
  public PrintUPSBuilder printEveryMs(int printEveryMs) {
    this.printEveryMs = printEveryMs;
    return this;
  }

  @Override
  public PrintUPS build() {
    final var built = new PrintUPSImpl(printEveryMs);
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
    private static final FeatureInserter<PrintUPSBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<PrintUPSBuilder>(1, Inserters::attributeIndex).add(PrintUPS.FeatureIDs.PRINT_EVERY_MS, (builder, value) -> builder.printEveryMs((int) value)).build();
    private static final RelationLazyInserter<PrintUPSBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<PrintUPSBuilder>(0, Inserters::relationIndex).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case PrintUPS.FeatureIDs.PRINT_EVERY_MS -> 0;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
    }
  }
}
