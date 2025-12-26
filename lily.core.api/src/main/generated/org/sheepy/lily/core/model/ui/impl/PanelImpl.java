package org.sheepy.lily.core.model.ui.impl;

import java.util.List;
import org.joml.Vector2ic;
import org.joml.Vector4ic;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.presentation.IPositionElement;
import org.sheepy.lily.core.model.presentation.ISizedElement;
import org.sheepy.lily.core.model.resource.IImage;
import org.sheepy.lily.core.model.types.EHorizontalRelative;
import org.sheepy.lily.core.model.types.EVerticalRelative;
import org.sheepy.lily.core.model.ui.IControl;
import org.sheepy.lily.core.model.ui.IPanel;
import org.sheepy.lily.core.model.ui.Panel;
import org.sheepy.lily.core.model.ui.UIModelDefinition;

public final class PanelImpl extends FeaturedObject<Panel.Features<?>> implements Panel {
  private static final int FEATURE_COUNT = 16;
  private final ModelNotifier<Panel.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private int width;
  private int height;
  private Vector2ic position;
  private EVerticalRelative verticalRelative;
  private EHorizontalRelative horizontalRelative;
  private final String name;
  private boolean catchInputs;
  private boolean reportingHover;
  private final List<IControl> controls = newObservableList(Panel.FeatureIDs.CONTROLS, true, true);
  private boolean showTitle;
  private boolean minimizable;
  private boolean movable;
  private boolean minimized;
  private IImage backgroundImage;
  private Vector4ic backgroundColor;
  private Vector4ic borderColor;

  public PanelImpl(final String name, final boolean catchInputs, final boolean reportingHover,
      final Vector4ic backgroundColor, final Vector4ic borderColor) {
    this.name = name;
    this.catchInputs = catchInputs;
    this.reportingHover = reportingHover;
    this.backgroundColor = backgroundColor;
    this.borderColor = borderColor;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<Panel.Features<?>> notifier() {
    return notifier;
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
  public String name() {
    return name;
  }

  @Override
  public boolean catchInputs() {
    return catchInputs;
  }

  @Override
  public void catchInputs(final boolean catchInputs) {
    final var oldValue = this.catchInputs;
    this.catchInputs = catchInputs;
    notifier.notifyBoolean(IPanel.FeatureIDs.CATCH_INPUTS, false, false, oldValue, catchInputs);
  }

  @Override
  public boolean reportingHover() {
    return reportingHover;
  }

  @Override
  public void reportingHover(final boolean reportingHover) {
    final var oldValue = this.reportingHover;
    this.reportingHover = reportingHover;
    notifier.notifyBoolean(IPanel.FeatureIDs.REPORTING_HOVER, false, false, oldValue, reportingHover);
  }

  @Override
  public List<IControl> controls() {
    return controls;
  }

  @Override
  public boolean showTitle() {
    return showTitle;
  }

  @Override
  public void showTitle(final boolean showTitle) {
    final var oldValue = this.showTitle;
    this.showTitle = showTitle;
    notifier.notifyBoolean(Panel.FeatureIDs.SHOW_TITLE, false, false, oldValue, showTitle);
  }

  @Override
  public boolean minimizable() {
    return minimizable;
  }

  @Override
  public void minimizable(final boolean minimizable) {
    final var oldValue = this.minimizable;
    this.minimizable = minimizable;
    notifier.notifyBoolean(Panel.FeatureIDs.MINIMIZABLE, false, false, oldValue, minimizable);
  }

  @Override
  public boolean movable() {
    return movable;
  }

  @Override
  public void movable(final boolean movable) {
    final var oldValue = this.movable;
    this.movable = movable;
    notifier.notifyBoolean(Panel.FeatureIDs.MOVABLE, false, false, oldValue, movable);
  }

  @Override
  public boolean minimized() {
    return minimized;
  }

  @Override
  public void minimized(final boolean minimized) {
    final var oldValue = this.minimized;
    this.minimized = minimized;
    notifier.notifyBoolean(Panel.FeatureIDs.MINIMIZED, false, false, oldValue, minimized);
  }

  @Override
  public IImage backgroundImage() {
    return backgroundImage;
  }

  @Override
  public void backgroundImage(final IImage backgroundImage) {
    final var oldValue = this.backgroundImage;
    final var eventType = backgroundImage == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.backgroundImage = backgroundImage;
    notifier.notify(Panel.FeatureIDs.BACKGROUND_IMAGE, false, false, eventType, oldValue, backgroundImage);
  }

  @Override
  public Vector4ic backgroundColor() {
    return backgroundColor;
  }

  @Override
  public void backgroundColor(final Vector4ic backgroundColor) {
    final var oldValue = this.backgroundColor;
    this.backgroundColor = backgroundColor;
    notifier.notify(Panel.FeatureIDs.BACKGROUND_COLOR, false, false, oldValue, backgroundColor);
  }

  @Override
  public Vector4ic borderColor() {
    return borderColor;
  }

  @Override
  public void borderColor(final Vector4ic borderColor) {
    final var oldValue = this.borderColor;
    this.borderColor = borderColor;
    notifier.notify(Panel.FeatureIDs.BORDER_COLOR, false, false, oldValue, borderColor);
  }

  @Override
  public Group<Panel> lmGroup() {
    return UIModelDefinition.Groups.PANEL;
  }

  @Override
  protected FeatureSetter<Panel> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<Panel> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case Panel.FeatureIDs.WIDTH -> 0;
      case Panel.FeatureIDs.HEIGHT -> 1;
      case Panel.FeatureIDs.POSITION -> 2;
      case Panel.FeatureIDs.VERTICAL_RELATIVE -> 3;
      case Panel.FeatureIDs.HORIZONTAL_RELATIVE -> 4;
      case Panel.FeatureIDs.NAME -> 5;
      case Panel.FeatureIDs.CATCH_INPUTS -> 6;
      case Panel.FeatureIDs.REPORTING_HOVER -> 7;
      case Panel.FeatureIDs.CONTROLS -> 8;
      case Panel.FeatureIDs.SHOW_TITLE -> 9;
      case Panel.FeatureIDs.MINIMIZABLE -> 10;
      case Panel.FeatureIDs.MOVABLE -> 11;
      case Panel.FeatureIDs.MINIMIZED -> 12;
      case Panel.FeatureIDs.BACKGROUND_IMAGE -> 13;
      case Panel.FeatureIDs.BACKGROUND_COLOR -> 14;
      case Panel.FeatureIDs.BORDER_COLOR -> 15;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<Panel> GET_MAP = new FeatureGetter.Builder<Panel>(FEATURE_COUNT, PanelImpl::featureIndexStatic).add(Panel.FeatureIDs.WIDTH, Panel::width).add(Panel.FeatureIDs.HEIGHT, Panel::height).add(Panel.FeatureIDs.POSITION, Panel::position).add(Panel.FeatureIDs.VERTICAL_RELATIVE, Panel::verticalRelative).add(Panel.FeatureIDs.HORIZONTAL_RELATIVE, Panel::horizontalRelative).add(Panel.FeatureIDs.NAME, Panel::name).add(Panel.FeatureIDs.CATCH_INPUTS, Panel::catchInputs).add(Panel.FeatureIDs.REPORTING_HOVER, Panel::reportingHover).add(Panel.FeatureIDs.CONTROLS, Panel::controls).add(Panel.FeatureIDs.SHOW_TITLE, Panel::showTitle).add(Panel.FeatureIDs.MINIMIZABLE, Panel::minimizable).add(Panel.FeatureIDs.MOVABLE, Panel::movable).add(Panel.FeatureIDs.MINIMIZED, Panel::minimized).add(Panel.FeatureIDs.BACKGROUND_IMAGE, Panel::backgroundImage).add(Panel.FeatureIDs.BACKGROUND_COLOR, Panel::backgroundColor).add(Panel.FeatureIDs.BORDER_COLOR, Panel::borderColor).build();
    private static final FeatureSetter<Panel> SET_MAP = new FeatureSetter.Builder<Panel>(FEATURE_COUNT, PanelImpl::featureIndexStatic).add(Panel.FeatureIDs.WIDTH, (object, value) -> ((PanelImpl) object).width((int) value)).add(Panel.FeatureIDs.HEIGHT, (object, value) -> ((PanelImpl) object).height((int) value)).add(Panel.FeatureIDs.POSITION, (object, value) -> ((PanelImpl) object).position((Vector2ic) value)).add(Panel.FeatureIDs.VERTICAL_RELATIVE, (object, value) -> ((PanelImpl) object).verticalRelative((EVerticalRelative) value)).add(Panel.FeatureIDs.HORIZONTAL_RELATIVE, (object, value) -> ((PanelImpl) object).horizontalRelative((EHorizontalRelative) value)).add(Panel.FeatureIDs.CATCH_INPUTS, (object, value) -> ((PanelImpl) object).catchInputs((boolean) value)).add(Panel.FeatureIDs.REPORTING_HOVER, (object, value) -> ((PanelImpl) object).reportingHover((boolean) value)).add(Panel.FeatureIDs.SHOW_TITLE, (object, value) -> ((PanelImpl) object).showTitle((boolean) value)).add(Panel.FeatureIDs.MINIMIZABLE, (object, value) -> ((PanelImpl) object).minimizable((boolean) value)).add(Panel.FeatureIDs.MOVABLE, (object, value) -> ((PanelImpl) object).movable((boolean) value)).add(Panel.FeatureIDs.MINIMIZED, (object, value) -> ((PanelImpl) object).minimized((boolean) value)).add(Panel.FeatureIDs.BACKGROUND_IMAGE, (object, value) -> ((PanelImpl) object).backgroundImage((IImage) value)).add(Panel.FeatureIDs.BACKGROUND_COLOR, (object, value) -> ((PanelImpl) object).backgroundColor((Vector4ic) value)).add(Panel.FeatureIDs.BORDER_COLOR, (object, value) -> ((PanelImpl) object).borderColor((Vector4ic) value)).build();
  }
}
