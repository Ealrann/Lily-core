package org.sheepy.lily.core.model.presentation.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.util.BuildUtils;
import org.sheepy.lily.core.model.presentation.IPresentationPkg;
import org.sheepy.lily.core.model.presentation.Presentations;
import org.sheepy.lily.core.model.presentation.Presentations.Builder;
import org.sheepy.lily.core.model.presentation.impl.PresentationsImpl;

public final class PresentationsBuilder implements Builder {
  private final List<Supplier<IPresentationPkg>> presentationPkgs = new ArrayList<>();

  public PresentationsBuilder() {
  }

  @Override
  public PresentationsBuilder addPresentationPkg(Supplier<IPresentationPkg> presentationPkg) {
    this.presentationPkgs.add(presentationPkg);
    return this;
  }

  @Override
  public PresentationsBuilder addPresentationPkgs(final List<IPresentationPkg> presentationPkgs) {
    presentationPkgs.forEach(value -> this.presentationPkgs.add(() -> value));
    return this;
  }

  @Override
  public Presentations build() {
    final var builtPresentationPkgs = BuildUtils.collectSuppliers(presentationPkgs);
    final var built = new PresentationsImpl();
    built.presentationPkgs().addAll(builtPresentationPkgs);
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
    private static final FeatureInserter<PresentationsBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<PresentationsBuilder>(0, Inserters::attributeIndex).build();
    private static final RelationLazyInserter<PresentationsBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<PresentationsBuilder>(1, Inserters::relationIndex).add(Presentations.FeatureIDs.PRESENTATION_PKGS, (builder, value) -> builder.addPresentationPkg((Supplier<IPresentationPkg>) value)).build();

    private static int attributeIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case Presentations.FeatureIDs.PRESENTATION_PKGS -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
