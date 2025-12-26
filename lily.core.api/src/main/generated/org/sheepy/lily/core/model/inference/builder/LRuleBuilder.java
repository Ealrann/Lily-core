package org.sheepy.lily.core.model.inference.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.util.BuildUtils;
import org.sheepy.lily.core.model.action.Action;
import org.sheepy.lily.core.model.inference.AbstractNotification;
import org.sheepy.lily.core.model.inference.Condition;
import org.sheepy.lily.core.model.inference.LRule;
import org.sheepy.lily.core.model.inference.LRule.Builder;
import org.sheepy.lily.core.model.inference.impl.LRuleImpl;

public final class LRuleBuilder implements Builder {
  private Supplier<AbstractNotification> notification;
  private Supplier<Action> action = () -> null;
  private final List<Supplier<Condition<?>>> conditions = new ArrayList<>();

  public LRuleBuilder() {
  }

  @Override
  public LRuleBuilder notification(Supplier<AbstractNotification> notification) {
    this.notification = notification;
    return this;
  }

  @Override
  public LRuleBuilder action(Supplier<Action> action) {
    this.action = action;
    return this;
  }

  @Override
  public LRuleBuilder addCondition(Supplier<Condition<?>> condition) {
    this.conditions.add(condition);
    return this;
  }

  @Override
  public LRuleBuilder addConditions(final List<Condition<?>> conditions) {
    conditions.forEach(value -> this.conditions.add(() -> value));
    return this;
  }

  @Override
  public LRule build() {
    final var builtConditions = BuildUtils.collectSuppliers(conditions);
    final var built = new LRuleImpl(notification.get());
    built.action(action.get());
    built.conditions().addAll(builtConditions);
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
    private static final FeatureInserter<LRuleBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<LRuleBuilder>(0, Inserters::attributeIndex).build();
    private static final RelationLazyInserter<LRuleBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<LRuleBuilder>(3, Inserters::relationIndex).add(LRule.FeatureIDs.NOTIFICATION, (builder, value) -> builder.notification((Supplier<AbstractNotification>) value)).add(LRule.FeatureIDs.ACTION, (builder, value) -> builder.action((Supplier<Action>) value)).add(LRule.FeatureIDs.CONDITIONS, (builder, value) -> builder.addCondition((Supplier<Condition<?>>) value)).build();

    private static int attributeIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case LRule.FeatureIDs.NOTIFICATION -> 0;
        case LRule.FeatureIDs.ACTION -> 1;
        case LRule.FeatureIDs.CONDITIONS -> 2;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
