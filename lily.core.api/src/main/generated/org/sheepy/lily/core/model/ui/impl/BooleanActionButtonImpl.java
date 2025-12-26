package org.sheepy.lily.core.model.ui.impl;

import org.joml.Vector2ic;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.action.Action;
import org.sheepy.lily.core.model.presentation.IPositionElement;
import org.sheepy.lily.core.model.presentation.ISizedElement;
import org.sheepy.lily.core.model.types.EHorizontalRelative;
import org.sheepy.lily.core.model.types.EVerticalRelative;
import org.sheepy.lily.core.model.ui.AbstractBooleanButton;
import org.sheepy.lily.core.model.ui.AbstractButton;
import org.sheepy.lily.core.model.ui.BooleanActionButton;
import org.sheepy.lily.core.model.ui.Font;
import org.sheepy.lily.core.model.ui.TextWidget;
import org.sheepy.lily.core.model.ui.UIModelDefinition;

public final class BooleanActionButtonImpl extends FeaturedObject<BooleanActionButton.Features<?>> implements BooleanActionButton {
  private static final int FEATURE_COUNT = 11;
  private final ModelNotifier<BooleanActionButton.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private Vector2ic position;
  private EVerticalRelative verticalRelative;
  private EHorizontalRelative horizontalRelative;
  private int width;
  private int height;
  private Font font;
  private String text;
  private String textWhenTrue;
  private String textWhenFalse;
  private Action actionWhenTrue;
  private Action actionWhenFalse;

  public BooleanActionButtonImpl() {
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<BooleanActionButton.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public Vector2ic position() {
    return position;
  }

  @Override
  public void position(final Vector2ic position) {
    final var oldValue = this.position;
    this.position = position;
    notifier.notify(IPositionElement.FeatureIDs.POSITION, false, false, oldValue, position);
  }

  @Override
  public EVerticalRelative verticalRelative() {
    return verticalRelative;
  }

  @Override
  public void verticalRelative(final EVerticalRelative verticalRelative) {
    final var oldValue = this.verticalRelative;
    this.verticalRelative = verticalRelative;
    notifier.notify(IPositionElement.FeatureIDs.VERTICAL_RELATIVE, false, false, oldValue, verticalRelative);
  }

  @Override
  public EHorizontalRelative horizontalRelative() {
    return horizontalRelative;
  }

  @Override
  public void horizontalRelative(final EHorizontalRelative horizontalRelative) {
    final var oldValue = this.horizontalRelative;
    this.horizontalRelative = horizontalRelative;
    notifier.notify(IPositionElement.FeatureIDs.HORIZONTAL_RELATIVE, false, false, oldValue, horizontalRelative);
  }

  @Override
  public int width() {
    return width;
  }

  @Override
  public void width(final int width) {
    final var oldValue = this.width;
    this.width = width;
    notifier.notifyInt(ISizedElement.FeatureIDs.WIDTH, false, false, oldValue, width);
  }

  @Override
  public int height() {
    return height;
  }

  @Override
  public void height(final int height) {
    final var oldValue = this.height;
    this.height = height;
    notifier.notifyInt(ISizedElement.FeatureIDs.HEIGHT, false, false, oldValue, height);
  }

  @Override
  public Font font() {
    return font;
  }

  @Override
  public void font(final Font font) {
    final var oldValue = this.font;
    final var eventType = font == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.font = font;
    notifier.notify(TextWidget.FeatureIDs.FONT, false, false, eventType, oldValue, font);
  }

  @Override
  public String text() {
    return text;
  }

  @Override
  public void text(final String text) {
    final var oldValue = this.text;
    this.text = text;
    notifier.notify(AbstractButton.FeatureIDs.TEXT, false, false, oldValue, text);
  }

  @Override
  public String textWhenTrue() {
    return textWhenTrue;
  }

  @Override
  public void textWhenTrue(final String textWhenTrue) {
    final var oldValue = this.textWhenTrue;
    this.textWhenTrue = textWhenTrue;
    notifier.notify(AbstractBooleanButton.FeatureIDs.TEXT_WHEN_TRUE, false, false, oldValue, textWhenTrue);
  }

  @Override
  public String textWhenFalse() {
    return textWhenFalse;
  }

  @Override
  public void textWhenFalse(final String textWhenFalse) {
    final var oldValue = this.textWhenFalse;
    this.textWhenFalse = textWhenFalse;
    notifier.notify(AbstractBooleanButton.FeatureIDs.TEXT_WHEN_FALSE, false, false, oldValue, textWhenFalse);
  }

  @Override
  public Action actionWhenTrue() {
    return actionWhenTrue;
  }

  @Override
  public void actionWhenTrue(final Action actionWhenTrue) {
    final var oldValue = this.actionWhenTrue;
    final var eventType = actionWhenTrue == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.actionWhenTrue = actionWhenTrue;
    setContainer(actionWhenTrue, BooleanActionButton.FeatureIDs.ACTION_WHEN_TRUE);
    beforeContainmentNotify(eventType, oldValue, actionWhenTrue);
    notifier.notify(BooleanActionButton.FeatureIDs.ACTION_WHEN_TRUE, true, false, eventType, oldValue, actionWhenTrue);
    afterContainmentNotify(eventType, oldValue, actionWhenTrue);
  }

  @Override
  public Action actionWhenFalse() {
    return actionWhenFalse;
  }

  @Override
  public void actionWhenFalse(final Action actionWhenFalse) {
    final var oldValue = this.actionWhenFalse;
    final var eventType = actionWhenFalse == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.actionWhenFalse = actionWhenFalse;
    setContainer(actionWhenFalse, BooleanActionButton.FeatureIDs.ACTION_WHEN_FALSE);
    beforeContainmentNotify(eventType, oldValue, actionWhenFalse);
    notifier.notify(BooleanActionButton.FeatureIDs.ACTION_WHEN_FALSE, true, false, eventType, oldValue, actionWhenFalse);
    afterContainmentNotify(eventType, oldValue, actionWhenFalse);
  }

  @Override
  public Group<BooleanActionButton> lmGroup() {
    return UIModelDefinition.Groups.BOOLEAN_ACTION_BUTTON;
  }

  @Override
  protected FeatureSetter<BooleanActionButton> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<BooleanActionButton> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case BooleanActionButton.FeatureIDs.POSITION -> 0;
      case BooleanActionButton.FeatureIDs.VERTICAL_RELATIVE -> 1;
      case BooleanActionButton.FeatureIDs.HORIZONTAL_RELATIVE -> 2;
      case BooleanActionButton.FeatureIDs.WIDTH -> 3;
      case BooleanActionButton.FeatureIDs.HEIGHT -> 4;
      case BooleanActionButton.FeatureIDs.FONT -> 5;
      case BooleanActionButton.FeatureIDs.TEXT -> 6;
      case BooleanActionButton.FeatureIDs.TEXT_WHEN_TRUE -> 7;
      case BooleanActionButton.FeatureIDs.TEXT_WHEN_FALSE -> 8;
      case BooleanActionButton.FeatureIDs.ACTION_WHEN_TRUE -> 9;
      case BooleanActionButton.FeatureIDs.ACTION_WHEN_FALSE -> 10;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<BooleanActionButton> GET_MAP = new FeatureGetter.Builder<BooleanActionButton>(FEATURE_COUNT, BooleanActionButtonImpl::featureIndexStatic).add(BooleanActionButton.FeatureIDs.POSITION, BooleanActionButton::position).add(BooleanActionButton.FeatureIDs.VERTICAL_RELATIVE, BooleanActionButton::verticalRelative).add(BooleanActionButton.FeatureIDs.HORIZONTAL_RELATIVE, BooleanActionButton::horizontalRelative).add(BooleanActionButton.FeatureIDs.WIDTH, BooleanActionButton::width).add(BooleanActionButton.FeatureIDs.HEIGHT, BooleanActionButton::height).add(BooleanActionButton.FeatureIDs.FONT, BooleanActionButton::font).add(BooleanActionButton.FeatureIDs.TEXT, BooleanActionButton::text).add(BooleanActionButton.FeatureIDs.TEXT_WHEN_TRUE, BooleanActionButton::textWhenTrue).add(BooleanActionButton.FeatureIDs.TEXT_WHEN_FALSE, BooleanActionButton::textWhenFalse).add(BooleanActionButton.FeatureIDs.ACTION_WHEN_TRUE, BooleanActionButton::actionWhenTrue).add(BooleanActionButton.FeatureIDs.ACTION_WHEN_FALSE, BooleanActionButton::actionWhenFalse).build();
    private static final FeatureSetter<BooleanActionButton> SET_MAP = new FeatureSetter.Builder<BooleanActionButton>(FEATURE_COUNT, BooleanActionButtonImpl::featureIndexStatic).add(BooleanActionButton.FeatureIDs.POSITION, (object, value) -> ((BooleanActionButtonImpl) object).position((Vector2ic) value)).add(BooleanActionButton.FeatureIDs.VERTICAL_RELATIVE, (object, value) -> ((BooleanActionButtonImpl) object).verticalRelative((EVerticalRelative) value)).add(BooleanActionButton.FeatureIDs.HORIZONTAL_RELATIVE, (object, value) -> ((BooleanActionButtonImpl) object).horizontalRelative((EHorizontalRelative) value)).add(BooleanActionButton.FeatureIDs.WIDTH, (object, value) -> ((BooleanActionButtonImpl) object).width((int) value)).add(BooleanActionButton.FeatureIDs.HEIGHT, (object, value) -> ((BooleanActionButtonImpl) object).height((int) value)).add(BooleanActionButton.FeatureIDs.FONT, (object, value) -> ((BooleanActionButtonImpl) object).font((Font) value)).add(BooleanActionButton.FeatureIDs.TEXT, (object, value) -> ((BooleanActionButtonImpl) object).text((String) value)).add(BooleanActionButton.FeatureIDs.TEXT_WHEN_TRUE, (object, value) -> ((BooleanActionButtonImpl) object).textWhenTrue((String) value)).add(BooleanActionButton.FeatureIDs.TEXT_WHEN_FALSE, (object, value) -> ((BooleanActionButtonImpl) object).textWhenFalse((String) value)).add(BooleanActionButton.FeatureIDs.ACTION_WHEN_TRUE, (object, value) -> ((BooleanActionButtonImpl) object).actionWhenTrue((Action) value)).add(BooleanActionButton.FeatureIDs.ACTION_WHEN_FALSE, (object, value) -> ((BooleanActionButtonImpl) object).actionWhenFalse((Action) value)).build();
  }
}
