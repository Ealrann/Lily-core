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
import org.sheepy.lily.core.model.ui.TextField;
import org.sheepy.lily.core.model.ui.TextWidget;
import org.sheepy.lily.core.model.ui.UIModelDefinition;
import org.sheepy.lily.core.model.variable.IVariableResolver;

public final class TextFieldImpl extends FeaturedObject<TextField.Features<?>> implements TextField {
  private static final int FEATURE_COUNT = 7;
  private final ModelNotifier<TextField.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private Vector2ic position;
  private EVerticalRelative verticalRelative;
  private EHorizontalRelative horizontalRelative;
  private int width;
  private int height;
  private Font font;
  private IVariableResolver variableResolver;

  public TextFieldImpl() {
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<TextField.Features<?>> notifier() {
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
  public IVariableResolver variableResolver() {
    return variableResolver;
  }

  @Override
  public void variableResolver(final IVariableResolver variableResolver) {
    final var oldValue = this.variableResolver;
    final var eventType = variableResolver == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.variableResolver = variableResolver;
    setContainer(variableResolver, TextField.FeatureIDs.VARIABLE_RESOLVER);
    beforeContainmentNotify(eventType, oldValue, variableResolver);
    notifier.notify(TextField.FeatureIDs.VARIABLE_RESOLVER, true, false, eventType, oldValue, variableResolver);
    afterContainmentNotify(eventType, oldValue, variableResolver);
  }

  @Override
  public Group<TextField> lmGroup() {
    return UIModelDefinition.Groups.TEXT_FIELD;
  }

  @Override
  protected FeatureSetter<TextField> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<TextField> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case TextField.FeatureIDs.POSITION -> 0;
      case TextField.FeatureIDs.VERTICAL_RELATIVE -> 1;
      case TextField.FeatureIDs.HORIZONTAL_RELATIVE -> 2;
      case TextField.FeatureIDs.WIDTH -> 3;
      case TextField.FeatureIDs.HEIGHT -> 4;
      case TextField.FeatureIDs.FONT -> 5;
      case TextField.FeatureIDs.VARIABLE_RESOLVER -> 6;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<TextField> GET_MAP = new FeatureGetter.Builder<TextField>(FEATURE_COUNT, TextFieldImpl::featureIndexStatic).add(TextField.FeatureIDs.POSITION, TextField::position).add(TextField.FeatureIDs.VERTICAL_RELATIVE, TextField::verticalRelative).add(TextField.FeatureIDs.HORIZONTAL_RELATIVE, TextField::horizontalRelative).add(TextField.FeatureIDs.WIDTH, TextField::width).add(TextField.FeatureIDs.HEIGHT, TextField::height).add(TextField.FeatureIDs.FONT, TextField::font).add(TextField.FeatureIDs.VARIABLE_RESOLVER, TextField::variableResolver).build();
    private static final FeatureSetter<TextField> SET_MAP = new FeatureSetter.Builder<TextField>(FEATURE_COUNT, TextFieldImpl::featureIndexStatic).add(TextField.FeatureIDs.POSITION, (object, value) -> ((TextFieldImpl) object).position((Vector2ic) value)).add(TextField.FeatureIDs.VERTICAL_RELATIVE, (object, value) -> ((TextFieldImpl) object).verticalRelative((EVerticalRelative) value)).add(TextField.FeatureIDs.HORIZONTAL_RELATIVE, (object, value) -> ((TextFieldImpl) object).horizontalRelative((EHorizontalRelative) value)).add(TextField.FeatureIDs.WIDTH, (object, value) -> ((TextFieldImpl) object).width((int) value)).add(TextField.FeatureIDs.HEIGHT, (object, value) -> ((TextFieldImpl) object).height((int) value)).add(TextField.FeatureIDs.FONT, (object, value) -> ((TextFieldImpl) object).font((Font) value)).add(TextField.FeatureIDs.VARIABLE_RESOLVER, (object, value) -> ((TextFieldImpl) object).variableResolver((IVariableResolver) value)).build();
  }
}
