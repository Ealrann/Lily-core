package org.sheepy.lily.core.model.ui.impl;

import java.util.List;
import org.joml.Vector2ic;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.action.Action;
import org.sheepy.lily.core.model.action.ActionList;
import org.sheepy.lily.core.model.inference.IInferenceObject;
import org.sheepy.lily.core.model.presentation.IPositionElement;
import org.sheepy.lily.core.model.presentation.ISizedElement;
import org.sheepy.lily.core.model.types.EHorizontalRelative;
import org.sheepy.lily.core.model.types.EKeyState;
import org.sheepy.lily.core.model.types.EVerticalRelative;
import org.sheepy.lily.core.model.ui.AbstractButton;
import org.sheepy.lily.core.model.ui.Button;
import org.sheepy.lily.core.model.ui.Font;
import org.sheepy.lily.core.model.ui.TextWidget;
import org.sheepy.lily.core.model.ui.UIModelDefinition;

public final class ButtonImpl extends FeaturedObject<Button.Features<?>> implements Button {
  private static final int FEATURE_COUNT = 10;
  private final ModelNotifier<Button.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private Vector2ic position;
  private EVerticalRelative verticalRelative;
  private EHorizontalRelative horizontalRelative;
  private int width;
  private int height;
  private Font font;
  private String text;
  private int shortcut;
  private EKeyState state;
  private final List<Action> actions = newObservableList(Button.FeatureIDs.ACTIONS, true, true);

  public ButtonImpl() {
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<Button.Features<?>> notifier() {
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
  public int shortcut() {
    return shortcut;
  }

  @Override
  public void shortcut(final int shortcut) {
    final var oldValue = this.shortcut;
    this.shortcut = shortcut;
    notifier.notifyInt(Button.FeatureIDs.SHORTCUT, false, false, oldValue, shortcut);
  }

  @Override
  public EKeyState state() {
    return state;
  }

  @Override
  public void state(final EKeyState state) {
    final var oldValue = this.state;
    this.state = state;
    notifier.notify(Button.FeatureIDs.STATE, false, false, oldValue, state);
  }

  @Override
  public List<Action> actions() {
    return actions;
  }

  @Override
  public Group<Button> lmGroup() {
    return UIModelDefinition.Groups.BUTTON;
  }

  @Override
  protected FeatureSetter<Button> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<Button> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case Button.FeatureIDs.POSITION -> 0;
      case Button.FeatureIDs.VERTICAL_RELATIVE -> 1;
      case Button.FeatureIDs.HORIZONTAL_RELATIVE -> 2;
      case Button.FeatureIDs.WIDTH -> 3;
      case Button.FeatureIDs.HEIGHT -> 4;
      case Button.FeatureIDs.FONT -> 5;
      case Button.FeatureIDs.TEXT -> 6;
      case Button.FeatureIDs.SHORTCUT -> 7;
      case Button.FeatureIDs.STATE -> 8;
      case Button.FeatureIDs.ACTIONS -> 9;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  @Override
  public ActionList<?> lActions() {
    throw new UnsupportedOperationException("Operation 'lActions' is not implemented");
  }

  @Override
  public IInferenceObject getExecutor() {
    throw new UnsupportedOperationException("Operation 'getExecutor' is not implemented");
  }

  private static final class Inserters {
    private static final FeatureGetter<Button> GET_MAP = new FeatureGetter.Builder<Button>(FEATURE_COUNT, ButtonImpl::featureIndexStatic).add(Button.FeatureIDs.POSITION, Button::position).add(Button.FeatureIDs.VERTICAL_RELATIVE, Button::verticalRelative).add(Button.FeatureIDs.HORIZONTAL_RELATIVE, Button::horizontalRelative).add(Button.FeatureIDs.WIDTH, Button::width).add(Button.FeatureIDs.HEIGHT, Button::height).add(Button.FeatureIDs.FONT, Button::font).add(Button.FeatureIDs.TEXT, Button::text).add(Button.FeatureIDs.SHORTCUT, Button::shortcut).add(Button.FeatureIDs.STATE, Button::state).add(Button.FeatureIDs.ACTIONS, Button::actions).build();
    private static final FeatureSetter<Button> SET_MAP = new FeatureSetter.Builder<Button>(FEATURE_COUNT, ButtonImpl::featureIndexStatic).add(Button.FeatureIDs.POSITION, (object, value) -> ((ButtonImpl) object).position((Vector2ic) value)).add(Button.FeatureIDs.VERTICAL_RELATIVE, (object, value) -> ((ButtonImpl) object).verticalRelative((EVerticalRelative) value)).add(Button.FeatureIDs.HORIZONTAL_RELATIVE, (object, value) -> ((ButtonImpl) object).horizontalRelative((EHorizontalRelative) value)).add(Button.FeatureIDs.WIDTH, (object, value) -> ((ButtonImpl) object).width((int) value)).add(Button.FeatureIDs.HEIGHT, (object, value) -> ((ButtonImpl) object).height((int) value)).add(Button.FeatureIDs.FONT, (object, value) -> ((ButtonImpl) object).font((Font) value)).add(Button.FeatureIDs.TEXT, (object, value) -> ((ButtonImpl) object).text((String) value)).add(Button.FeatureIDs.SHORTCUT, (object, value) -> ((ButtonImpl) object).shortcut((int) value)).add(Button.FeatureIDs.STATE, (object, value) -> ((ButtonImpl) object).state((EKeyState) value)).build();
  }
}
