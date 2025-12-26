package org.sheepy.lily.core.model.variable.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.util.BuildUtils;
import org.sheepy.lily.core.model.variable.VarChangeAction;
import org.sheepy.lily.core.model.variable.VarChangeActionPkg;
import org.sheepy.lily.core.model.variable.VarChangeActionPkg.Builder;
import org.sheepy.lily.core.model.variable.impl.VarChangeActionPkgImpl;

public final class VarChangeActionPkgBuilder implements Builder {
  private final List<Supplier<VarChangeAction>> actions = new ArrayList<>();

  public VarChangeActionPkgBuilder() {
  }

  @Override
  public VarChangeActionPkgBuilder addAction(Supplier<VarChangeAction> action) {
    this.actions.add(action);
    return this;
  }

  @Override
  public VarChangeActionPkgBuilder addActions(final List<VarChangeAction> actions) {
    actions.forEach(value -> this.actions.add(() -> value));
    return this;
  }

  @Override
  public VarChangeActionPkg build() {
    final var builtActions = BuildUtils.collectSuppliers(actions);
    final var built = new VarChangeActionPkgImpl();
    built.actions().addAll(builtActions);
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
    private static final FeatureInserter<VarChangeActionPkgBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<VarChangeActionPkgBuilder>(0, Inserters::attributeIndex).build();
    private static final RelationLazyInserter<VarChangeActionPkgBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<VarChangeActionPkgBuilder>(1, Inserters::relationIndex).add(VarChangeActionPkg.FeatureIDs.ACTIONS, (builder, value) -> builder.addAction((Supplier<VarChangeAction>) value)).build();

    private static int attributeIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case VarChangeActionPkg.FeatureIDs.ACTIONS -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
