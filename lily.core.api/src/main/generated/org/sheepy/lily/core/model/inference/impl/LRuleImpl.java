package org.sheepy.lily.core.model.inference.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.action.Action;
import org.sheepy.lily.core.model.inference.AbstractNotification;
import org.sheepy.lily.core.model.inference.Condition;
import org.sheepy.lily.core.model.inference.InferenceModelDefinition;
import org.sheepy.lily.core.model.inference.LRule;

public final class LRuleImpl extends FeaturedObject<LRule.Features<?>> implements LRule {
  private static final int FEATURE_COUNT = 3;
  private final ModelNotifier<LRule.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private AbstractNotification notification;
  private Action action;
  private final List<Condition<?>> conditions = newObservableList(LRule.FeatureIDs.CONDITIONS, true, true);

  public LRuleImpl(final AbstractNotification notification) {
    this.notification = notification;
    setContainer(notification, LRule.FeatureIDs.NOTIFICATION);
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<LRule.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public AbstractNotification notification() {
    return notification;
  }

  @Override
  public void notification(final AbstractNotification notification) {
    final var oldValue = this.notification;
    final var eventType = notification == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.notification = notification;
    setContainer(notification, LRule.FeatureIDs.NOTIFICATION);
    beforeContainmentNotify(eventType, oldValue, notification);
    notifier.notify(LRule.FeatureIDs.NOTIFICATION, true, false, eventType, oldValue, notification);
    afterContainmentNotify(eventType, oldValue, notification);
  }

  @Override
  public Action action() {
    return action;
  }

  @Override
  public void action(final Action action) {
    final var oldValue = this.action;
    final var eventType = action == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.action = action;
    notifier.notify(LRule.FeatureIDs.ACTION, false, false, eventType, oldValue, action);
  }

  @Override
  public List<Condition<?>> conditions() {
    return conditions;
  }

  @Override
  public Group<LRule> lmGroup() {
    return InferenceModelDefinition.Groups.L_RULE;
  }

  @Override
  protected FeatureSetter<LRule> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<LRule> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case LRule.FeatureIDs.NOTIFICATION -> 0;
      case LRule.FeatureIDs.ACTION -> 1;
      case LRule.FeatureIDs.CONDITIONS -> 2;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<LRule> GET_MAP = new FeatureGetter.Builder<LRule>(FEATURE_COUNT, LRuleImpl::featureIndexStatic).add(LRule.FeatureIDs.NOTIFICATION, LRule::notification).add(LRule.FeatureIDs.ACTION, LRule::action).add(LRule.FeatureIDs.CONDITIONS, LRule::conditions).build();
    private static final FeatureSetter<LRule> SET_MAP = new FeatureSetter.Builder<LRule>(FEATURE_COUNT, LRuleImpl::featureIndexStatic).add(LRule.FeatureIDs.NOTIFICATION, (object, value) -> ((LRuleImpl) object).notification((AbstractNotification) value)).add(LRule.FeatureIDs.ACTION, (object, value) -> ((LRuleImpl) object).action((Action) value)).build();
  }
}
