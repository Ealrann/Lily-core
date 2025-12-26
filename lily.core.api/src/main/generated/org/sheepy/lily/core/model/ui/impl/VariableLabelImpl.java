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
import org.sheepy.lily.core.model.ui.AbstractLabel;
import org.sheepy.lily.core.model.ui.Font;
import org.sheepy.lily.core.model.ui.TextWidget;
import org.sheepy.lily.core.model.ui.UIModelDefinition;
import org.sheepy.lily.core.model.ui.VariableLabel;
import org.sheepy.lily.core.model.variable.IVariableResolver;

public final class VariableLabelImpl extends FeaturedObject<VariableLabel.Features<?>> implements VariableLabel {
  private static final int FEATURE_COUNT = 11;
  private final ModelNotifier<VariableLabel.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private Vector2ic position;
  private EVerticalRelative verticalRelative;
  private EHorizontalRelative horizontalRelative;
  private int width;
  private int height;
  private Font font;
  private String text;
  private float fontScale;
  private IVariableResolver variableResolver;
  private boolean showName;
  private String format;

  public VariableLabelImpl(final IVariableResolver variableResolver, final boolean showName) {
    this.variableResolver = variableResolver;
    this.showName = showName;
    setContainer(variableResolver, VariableLabel.FeatureIDs.VARIABLE_RESOLVER);
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<VariableLabel.Features<?>> notifier() {
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
    notifier.notify(AbstractLabel.FeatureIDs.TEXT, false, false, oldValue, text);
  }

  @Override
  public float fontScale() {
    return fontScale;
  }

  @Override
  public void fontScale(final float fontScale) {
    final var oldValue = this.fontScale;
    this.fontScale = fontScale;
    notifier.notifyFloat(AbstractLabel.FeatureIDs.FONT_SCALE, false, false, oldValue, fontScale);
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
    setContainer(variableResolver, VariableLabel.FeatureIDs.VARIABLE_RESOLVER);
    beforeContainmentNotify(eventType, oldValue, variableResolver);
    notifier.notify(VariableLabel.FeatureIDs.VARIABLE_RESOLVER, true, false, eventType, oldValue, variableResolver);
    afterContainmentNotify(eventType, oldValue, variableResolver);
  }

  @Override
  public boolean showName() {
    return showName;
  }

  @Override
  public void showName(final boolean showName) {
    final var oldValue = this.showName;
    this.showName = showName;
    notifier.notifyBoolean(VariableLabel.FeatureIDs.SHOW_NAME, false, false, oldValue, showName);
  }

  @Override
  public String format() {
    return format;
  }

  @Override
  public void format(final String format) {
    final var oldValue = this.format;
    this.format = format;
    notifier.notify(VariableLabel.FeatureIDs.FORMAT, false, false, oldValue, format);
  }

  @Override
  public Group<VariableLabel> lmGroup() {
    return UIModelDefinition.Groups.VARIABLE_LABEL;
  }

  @Override
  protected FeatureSetter<VariableLabel> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<VariableLabel> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case VariableLabel.FeatureIDs.POSITION -> 0;
      case VariableLabel.FeatureIDs.VERTICAL_RELATIVE -> 1;
      case VariableLabel.FeatureIDs.HORIZONTAL_RELATIVE -> 2;
      case VariableLabel.FeatureIDs.WIDTH -> 3;
      case VariableLabel.FeatureIDs.HEIGHT -> 4;
      case VariableLabel.FeatureIDs.FONT -> 5;
      case VariableLabel.FeatureIDs.TEXT -> 6;
      case VariableLabel.FeatureIDs.FONT_SCALE -> 7;
      case VariableLabel.FeatureIDs.VARIABLE_RESOLVER -> 8;
      case VariableLabel.FeatureIDs.SHOW_NAME -> 9;
      case VariableLabel.FeatureIDs.FORMAT -> 10;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<VariableLabel> GET_MAP = new FeatureGetter.Builder<VariableLabel>(FEATURE_COUNT, VariableLabelImpl::featureIndexStatic).add(VariableLabel.FeatureIDs.POSITION, VariableLabel::position).add(VariableLabel.FeatureIDs.VERTICAL_RELATIVE, VariableLabel::verticalRelative).add(VariableLabel.FeatureIDs.HORIZONTAL_RELATIVE, VariableLabel::horizontalRelative).add(VariableLabel.FeatureIDs.WIDTH, VariableLabel::width).add(VariableLabel.FeatureIDs.HEIGHT, VariableLabel::height).add(VariableLabel.FeatureIDs.FONT, VariableLabel::font).add(VariableLabel.FeatureIDs.TEXT, VariableLabel::text).add(VariableLabel.FeatureIDs.FONT_SCALE, VariableLabel::fontScale).add(VariableLabel.FeatureIDs.VARIABLE_RESOLVER, VariableLabel::variableResolver).add(VariableLabel.FeatureIDs.SHOW_NAME, VariableLabel::showName).add(VariableLabel.FeatureIDs.FORMAT, VariableLabel::format).build();
    private static final FeatureSetter<VariableLabel> SET_MAP = new FeatureSetter.Builder<VariableLabel>(FEATURE_COUNT, VariableLabelImpl::featureIndexStatic).add(VariableLabel.FeatureIDs.POSITION, (object, value) -> ((VariableLabelImpl) object).position((Vector2ic) value)).add(VariableLabel.FeatureIDs.VERTICAL_RELATIVE, (object, value) -> ((VariableLabelImpl) object).verticalRelative((EVerticalRelative) value)).add(VariableLabel.FeatureIDs.HORIZONTAL_RELATIVE, (object, value) -> ((VariableLabelImpl) object).horizontalRelative((EHorizontalRelative) value)).add(VariableLabel.FeatureIDs.WIDTH, (object, value) -> ((VariableLabelImpl) object).width((int) value)).add(VariableLabel.FeatureIDs.HEIGHT, (object, value) -> ((VariableLabelImpl) object).height((int) value)).add(VariableLabel.FeatureIDs.FONT, (object, value) -> ((VariableLabelImpl) object).font((Font) value)).add(VariableLabel.FeatureIDs.TEXT, (object, value) -> ((VariableLabelImpl) object).text((String) value)).add(VariableLabel.FeatureIDs.FONT_SCALE, (object, value) -> ((VariableLabelImpl) object).fontScale((float) value)).add(VariableLabel.FeatureIDs.VARIABLE_RESOLVER, (object, value) -> ((VariableLabelImpl) object).variableResolver((IVariableResolver) value)).add(VariableLabel.FeatureIDs.SHOW_NAME, (object, value) -> ((VariableLabelImpl) object).showName((boolean) value)).add(VariableLabel.FeatureIDs.FORMAT, (object, value) -> ((VariableLabelImpl) object).format((String) value)).build();
  }
}
