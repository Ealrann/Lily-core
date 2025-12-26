package org.sheepy.lily.core.model.action.builder;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.core.model.action.Action;
import org.sheepy.lily.core.model.action.ActionList;
import org.sheepy.lily.core.model.action.ActionList.Builder;
import org.sheepy.lily.core.model.action.impl.ActionListImpl;

public final class ActionListBuilder<T extends Action> implements Builder<T> {
  private List<T> list;

  public ActionListBuilder() {
  }

  @Override
  public ActionListBuilder<T> list(List<T> list) {
    this.list = list;
    return this;
  }

  @SuppressWarnings({
      "unchecked",
      "rawtypes"
  })
  private ActionListBuilder<T> _list(final List<?> list) {
    this.list = (List<T>) list;
    return this;
  }

  @Override
  public ActionList<T> build() {
    final var built = new ActionListImpl<T>(list);
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
    private static final FeatureInserter<ActionListBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<ActionListBuilder>(1, Inserters::attributeIndex).add(ActionList.FeatureIDs.LIST, (builder, value) -> builder._list((List<?>) value)).build();
    private static final RelationLazyInserter<ActionListBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<ActionListBuilder>(0, Inserters::relationIndex).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case ActionList.FeatureIDs.LIST -> 0;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
    }
  }
}
