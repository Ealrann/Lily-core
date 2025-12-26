package org.sheepy.lily.core.model.ui.impl;

import org.joml.Vector2ic;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.presentation.IPositionElement;
import org.sheepy.lily.core.model.presentation.ISizedElement;
import org.sheepy.lily.core.model.types.EHorizontalRelative;
import org.sheepy.lily.core.model.types.EVerticalRelative;
import org.sheepy.lily.core.model.ui.AbstractBooleanButton;
import org.sheepy.lily.core.model.ui.AbstractButton;
import org.sheepy.lily.core.model.ui.BooleanButton;
import org.sheepy.lily.core.model.ui.Font;
import org.sheepy.lily.core.model.ui.TextWidget;
import org.sheepy.lily.core.model.ui.UIModelDefinition;
import org.sheepy.lily.core.model.variable.IVariableResolver;

public final class BooleanButtonImpl extends FeaturedObject<BooleanButton.Features<?>> implements BooleanButton {
  private static final int FEATURE_COUNT = 10;
  private final ModelNotifier<BooleanButton.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private Vector2ic position;
  private EVerticalRelative verticalRelative;
  private EHorizontalRelative horizontalRelative;
  private int width;
  private int height;
  private Font font;
  private String text;
  private String textWhenTrue;
  private String textWhenFalse;
  private IVariableResolver variableResolver;

  public BooleanButtonImpl() {
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<BooleanButton.Features<?>> notifier() {
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
  public IVariableResolver variableResolver() {
    return variableResolver;
  }

  @Override
  public void variableResolver(final IVariableResolver variableResolver) {
    final var oldValue = this.variableResolver;
    final var eventType = variableResolver == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.variableResolver = variableResolver;
    setContainer(variableResolver, BooleanButton.FeatureIDs.VARIABLE_RESOLVER);
    beforeContainmentNotify(eventType, oldValue, variableResolver);
    notifier.notify(BooleanButton.FeatureIDs.VARIABLE_RESOLVER, true, false, eventType, oldValue, variableResolver);
    afterContainmentNotify(eventType, oldValue, variableResolver);
  }

  @Override
  public Group<BooleanButton> lmGroup() {
    return UIModelDefinition.Groups.BOOLEAN_BUTTON;
  }

  @Override
  protected FeatureSetter<BooleanButton> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<BooleanButton> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case BooleanButton.FeatureIDs.POSITION -> 0;
      case BooleanButton.FeatureIDs.VERTICAL_RELATIVE -> 1;
      case BooleanButton.FeatureIDs.HORIZONTAL_RELATIVE -> 2;
      case BooleanButton.FeatureIDs.WIDTH -> 3;
      case BooleanButton.FeatureIDs.HEIGHT -> 4;
      case BooleanButton.FeatureIDs.FONT -> 5;
      case BooleanButton.FeatureIDs.TEXT -> 6;
      case BooleanButton.FeatureIDs.TEXT_WHEN_TRUE -> 7;
      case BooleanButton.FeatureIDs.TEXT_WHEN_FALSE -> 8;
      case BooleanButton.FeatureIDs.VARIABLE_RESOLVER -> 9;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<BooleanButton> GET_MAP = new FeatureGetter.Builder<BooleanButton>(FEATURE_COUNT, BooleanButtonImpl::featureIndexStatic).add(BooleanButton.FeatureIDs.POSITION, BooleanButton::position).add(BooleanButton.FeatureIDs.VERTICAL_RELATIVE, BooleanButton::verticalRelative).add(BooleanButton.FeatureIDs.HORIZONTAL_RELATIVE, BooleanButton::horizontalRelative).add(BooleanButton.FeatureIDs.WIDTH, BooleanButton::width).add(BooleanButton.FeatureIDs.HEIGHT, BooleanButton::height).add(BooleanButton.FeatureIDs.FONT, BooleanButton::font).add(BooleanButton.FeatureIDs.TEXT, BooleanButton::text).add(BooleanButton.FeatureIDs.TEXT_WHEN_TRUE, BooleanButton::textWhenTrue).add(BooleanButton.FeatureIDs.TEXT_WHEN_FALSE, BooleanButton::textWhenFalse).add(BooleanButton.FeatureIDs.VARIABLE_RESOLVER, BooleanButton::variableResolver).build();
    private static final FeatureSetter<BooleanButton> SET_MAP = new FeatureSetter.Builder<BooleanButton>(FEATURE_COUNT, BooleanButtonImpl::featureIndexStatic).add(BooleanButton.FeatureIDs.POSITION, (object, value) -> ((BooleanButtonImpl) object).position((Vector2ic) value)).add(BooleanButton.FeatureIDs.VERTICAL_RELATIVE, (object, value) -> ((BooleanButtonImpl) object).verticalRelative((EVerticalRelative) value)).add(BooleanButton.FeatureIDs.HORIZONTAL_RELATIVE, (object, value) -> ((BooleanButtonImpl) object).horizontalRelative((EHorizontalRelative) value)).add(BooleanButton.FeatureIDs.WIDTH, (object, value) -> ((BooleanButtonImpl) object).width((int) value)).add(BooleanButton.FeatureIDs.HEIGHT, (object, value) -> ((BooleanButtonImpl) object).height((int) value)).add(BooleanButton.FeatureIDs.FONT, (object, value) -> ((BooleanButtonImpl) object).font((Font) value)).add(BooleanButton.FeatureIDs.TEXT, (object, value) -> ((BooleanButtonImpl) object).text((String) value)).add(BooleanButton.FeatureIDs.TEXT_WHEN_TRUE, (object, value) -> ((BooleanButtonImpl) object).textWhenTrue((String) value)).add(BooleanButton.FeatureIDs.TEXT_WHEN_FALSE, (object, value) -> ((BooleanButtonImpl) object).textWhenFalse((String) value)).add(BooleanButton.FeatureIDs.VARIABLE_RESOLVER, (object, value) -> ((BooleanButtonImpl) object).variableResolver((IVariableResolver) value)).build();
  }
}
