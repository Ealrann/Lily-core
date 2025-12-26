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
import org.sheepy.lily.core.model.ui.Label;
import org.sheepy.lily.core.model.ui.TextWidget;
import org.sheepy.lily.core.model.ui.UIModelDefinition;

public final class LabelImpl extends FeaturedObject<Label.Features<?>> implements Label {
  private static final int FEATURE_COUNT = 11;
  private final ModelNotifier<Label.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private Vector2ic position;
  private EVerticalRelative verticalRelative;
  private EHorizontalRelative horizontalRelative;
  private int width;
  private int height;
  private Font font;
  private String text;
  private float fontScale;
  private boolean wrap;
  private boolean narrator;
  private int narrationSpeed;

  public LabelImpl(final boolean wrap, final boolean narrator) {
    this.wrap = wrap;
    this.narrator = narrator;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<Label.Features<?>> notifier() {
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
  public boolean wrap() {
    return wrap;
  }

  @Override
  public void wrap(final boolean wrap) {
    final var oldValue = this.wrap;
    this.wrap = wrap;
    notifier.notifyBoolean(Label.FeatureIDs.WRAP, false, false, oldValue, wrap);
  }

  @Override
  public boolean narrator() {
    return narrator;
  }

  @Override
  public void narrator(final boolean narrator) {
    final var oldValue = this.narrator;
    this.narrator = narrator;
    notifier.notifyBoolean(Label.FeatureIDs.NARRATOR, false, false, oldValue, narrator);
  }

  @Override
  public int narrationSpeed() {
    return narrationSpeed;
  }

  @Override
  public void narrationSpeed(final int narrationSpeed) {
    final var oldValue = this.narrationSpeed;
    this.narrationSpeed = narrationSpeed;
    notifier.notifyInt(Label.FeatureIDs.NARRATION_SPEED, false, false, oldValue, narrationSpeed);
  }

  @Override
  public Group<Label> lmGroup() {
    return UIModelDefinition.Groups.LABEL;
  }

  @Override
  protected FeatureSetter<Label> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<Label> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case Label.FeatureIDs.POSITION -> 0;
      case Label.FeatureIDs.VERTICAL_RELATIVE -> 1;
      case Label.FeatureIDs.HORIZONTAL_RELATIVE -> 2;
      case Label.FeatureIDs.WIDTH -> 3;
      case Label.FeatureIDs.HEIGHT -> 4;
      case Label.FeatureIDs.FONT -> 5;
      case Label.FeatureIDs.TEXT -> 6;
      case Label.FeatureIDs.FONT_SCALE -> 7;
      case Label.FeatureIDs.WRAP -> 8;
      case Label.FeatureIDs.NARRATOR -> 9;
      case Label.FeatureIDs.NARRATION_SPEED -> 10;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<Label> GET_MAP = new FeatureGetter.Builder<Label>(FEATURE_COUNT, LabelImpl::featureIndexStatic).add(Label.FeatureIDs.POSITION, Label::position).add(Label.FeatureIDs.VERTICAL_RELATIVE, Label::verticalRelative).add(Label.FeatureIDs.HORIZONTAL_RELATIVE, Label::horizontalRelative).add(Label.FeatureIDs.WIDTH, Label::width).add(Label.FeatureIDs.HEIGHT, Label::height).add(Label.FeatureIDs.FONT, Label::font).add(Label.FeatureIDs.TEXT, Label::text).add(Label.FeatureIDs.FONT_SCALE, Label::fontScale).add(Label.FeatureIDs.WRAP, Label::wrap).add(Label.FeatureIDs.NARRATOR, Label::narrator).add(Label.FeatureIDs.NARRATION_SPEED, Label::narrationSpeed).build();
    private static final FeatureSetter<Label> SET_MAP = new FeatureSetter.Builder<Label>(FEATURE_COUNT, LabelImpl::featureIndexStatic).add(Label.FeatureIDs.POSITION, (object, value) -> ((LabelImpl) object).position((Vector2ic) value)).add(Label.FeatureIDs.VERTICAL_RELATIVE, (object, value) -> ((LabelImpl) object).verticalRelative((EVerticalRelative) value)).add(Label.FeatureIDs.HORIZONTAL_RELATIVE, (object, value) -> ((LabelImpl) object).horizontalRelative((EHorizontalRelative) value)).add(Label.FeatureIDs.WIDTH, (object, value) -> ((LabelImpl) object).width((int) value)).add(Label.FeatureIDs.HEIGHT, (object, value) -> ((LabelImpl) object).height((int) value)).add(Label.FeatureIDs.FONT, (object, value) -> ((LabelImpl) object).font((Font) value)).add(Label.FeatureIDs.TEXT, (object, value) -> ((LabelImpl) object).text((String) value)).add(Label.FeatureIDs.FONT_SCALE, (object, value) -> ((LabelImpl) object).fontScale((float) value)).add(Label.FeatureIDs.WRAP, (object, value) -> ((LabelImpl) object).wrap((boolean) value)).add(Label.FeatureIDs.NARRATOR, (object, value) -> ((LabelImpl) object).narrator((boolean) value)).add(Label.FeatureIDs.NARRATION_SPEED, (object, value) -> ((LabelImpl) object).narrationSpeed((int) value)).build();
  }
}
