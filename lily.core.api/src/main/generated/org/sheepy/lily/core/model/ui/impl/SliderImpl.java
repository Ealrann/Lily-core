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
import org.sheepy.lily.core.model.ui.Font;
import org.sheepy.lily.core.model.ui.Slider;
import org.sheepy.lily.core.model.ui.TextWidget;
import org.sheepy.lily.core.model.ui.UIModelDefinition;
import org.sheepy.lily.core.model.variable.IVariableResolver;

public final class SliderImpl extends FeaturedObject<Slider.Features<?>> implements Slider {
  private static final int FEATURE_COUNT = 10;
  private final ModelNotifier<Slider.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private Vector2ic position;
  private EVerticalRelative verticalRelative;
  private EHorizontalRelative horizontalRelative;
  private int width;
  private int height;
  private Font font;
  private int minValue;
  private int maxValue;
  private int step;
  private IVariableResolver variableResolver;

  public SliderImpl(final IVariableResolver variableResolver) {
    this.variableResolver = variableResolver;
    setContainer(variableResolver, Slider.FeatureIDs.VARIABLE_RESOLVER);
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<Slider.Features<?>> notifier() {
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
  public int minValue() {
    return minValue;
  }

  @Override
  public void minValue(final int minValue) {
    final var oldValue = this.minValue;
    this.minValue = minValue;
    notifier.notifyInt(Slider.FeatureIDs.MIN_VALUE, false, false, oldValue, minValue);
  }

  @Override
  public int maxValue() {
    return maxValue;
  }

  @Override
  public void maxValue(final int maxValue) {
    final var oldValue = this.maxValue;
    this.maxValue = maxValue;
    notifier.notifyInt(Slider.FeatureIDs.MAX_VALUE, false, false, oldValue, maxValue);
  }

  @Override
  public int step() {
    return step;
  }

  @Override
  public void step(final int step) {
    final var oldValue = this.step;
    this.step = step;
    notifier.notifyInt(Slider.FeatureIDs.STEP, false, false, oldValue, step);
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
    setContainer(variableResolver, Slider.FeatureIDs.VARIABLE_RESOLVER);
    beforeContainmentNotify(eventType, oldValue, variableResolver);
    notifier.notify(Slider.FeatureIDs.VARIABLE_RESOLVER, true, false, eventType, oldValue, variableResolver);
    afterContainmentNotify(eventType, oldValue, variableResolver);
  }

  @Override
  public Group<Slider> lmGroup() {
    return UIModelDefinition.Groups.SLIDER;
  }

  @Override
  protected FeatureSetter<Slider> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<Slider> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case Slider.FeatureIDs.POSITION -> 0;
      case Slider.FeatureIDs.VERTICAL_RELATIVE -> 1;
      case Slider.FeatureIDs.HORIZONTAL_RELATIVE -> 2;
      case Slider.FeatureIDs.WIDTH -> 3;
      case Slider.FeatureIDs.HEIGHT -> 4;
      case Slider.FeatureIDs.FONT -> 5;
      case Slider.FeatureIDs.MIN_VALUE -> 6;
      case Slider.FeatureIDs.MAX_VALUE -> 7;
      case Slider.FeatureIDs.STEP -> 8;
      case Slider.FeatureIDs.VARIABLE_RESOLVER -> 9;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<Slider> GET_MAP = new FeatureGetter.Builder<Slider>(FEATURE_COUNT, SliderImpl::featureIndexStatic).add(Slider.FeatureIDs.POSITION, Slider::position).add(Slider.FeatureIDs.VERTICAL_RELATIVE, Slider::verticalRelative).add(Slider.FeatureIDs.HORIZONTAL_RELATIVE, Slider::horizontalRelative).add(Slider.FeatureIDs.WIDTH, Slider::width).add(Slider.FeatureIDs.HEIGHT, Slider::height).add(Slider.FeatureIDs.FONT, Slider::font).add(Slider.FeatureIDs.MIN_VALUE, Slider::minValue).add(Slider.FeatureIDs.MAX_VALUE, Slider::maxValue).add(Slider.FeatureIDs.STEP, Slider::step).add(Slider.FeatureIDs.VARIABLE_RESOLVER, Slider::variableResolver).build();
    private static final FeatureSetter<Slider> SET_MAP = new FeatureSetter.Builder<Slider>(FEATURE_COUNT, SliderImpl::featureIndexStatic).add(Slider.FeatureIDs.POSITION, (object, value) -> ((SliderImpl) object).position((Vector2ic) value)).add(Slider.FeatureIDs.VERTICAL_RELATIVE, (object, value) -> ((SliderImpl) object).verticalRelative((EVerticalRelative) value)).add(Slider.FeatureIDs.HORIZONTAL_RELATIVE, (object, value) -> ((SliderImpl) object).horizontalRelative((EHorizontalRelative) value)).add(Slider.FeatureIDs.WIDTH, (object, value) -> ((SliderImpl) object).width((int) value)).add(Slider.FeatureIDs.HEIGHT, (object, value) -> ((SliderImpl) object).height((int) value)).add(Slider.FeatureIDs.FONT, (object, value) -> ((SliderImpl) object).font((Font) value)).add(Slider.FeatureIDs.MIN_VALUE, (object, value) -> ((SliderImpl) object).minValue((int) value)).add(Slider.FeatureIDs.MAX_VALUE, (object, value) -> ((SliderImpl) object).maxValue((int) value)).add(Slider.FeatureIDs.STEP, (object, value) -> ((SliderImpl) object).step((int) value)).add(Slider.FeatureIDs.VARIABLE_RESOLVER, (object, value) -> ((SliderImpl) object).variableResolver((IVariableResolver) value)).build();
  }
}
