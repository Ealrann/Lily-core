package org.sheepy.lily.core.model.inference;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.core.model.action.Action;
import org.sheepy.lily.core.model.action.ActionModelDefinition;
import org.sheepy.lily.core.model.inference.builder.LRuleBuilder;

public interface LRule extends LMObject {
  static Builder builder() {
    return new LRuleBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  AbstractNotification notification();
  Action action();
  List<Condition<?>> conditions();
  void notification(final AbstractNotification notification);
  void action(final Action action);

  interface FeatureIDs {
    int NOTIFICATION = -1631923328;
    int ACTION = 80518283;
    int CONDITIONS = -1223679347;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Relation<AbstractNotification, AbstractNotification, Listener<AbstractNotification>, Features<?>> NOTIFICATION = new RelationBuilder<AbstractNotification, AbstractNotification, Listener<AbstractNotification>, Features<?>>().name("notification").mandatory(true).contains(true).id(LRule.FeatureIDs.NOTIFICATION).concept(() -> InferenceModelDefinition.Groups.ABSTRACT_NOTIFICATION).build();
    Relation<Action, Action, Listener<Action>, Features<?>> ACTION = new RelationBuilder<Action, Action, Listener<Action>, Features<?>>().name("action").id(LRule.FeatureIDs.ACTION).concept(() -> ActionModelDefinition.Groups.ACTION).build();
    Relation<Condition<?>, List<Condition<?>>, Listener<List<Condition<?>>>, Features<?>> CONDITIONS = new RelationBuilder<Condition<?>, List<Condition<?>>, Listener<List<Condition<?>>>, Features<?>>().name("conditions").many(true).contains(true).id(LRule.FeatureIDs.CONDITIONS).concept(() -> InferenceModelDefinition.Groups.CONDITION).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NOTIFICATION, ACTION, CONDITIONS);
  }

  interface Builder extends IFeaturedObject.Builder<LRule> {
    Builder notification(Supplier<AbstractNotification> notification);
    Builder action(Supplier<Action> action);
    Builder addCondition(Supplier<Condition<?>> condition);
    Builder addConditions(List<Condition<?>> conditions);
  }
}
