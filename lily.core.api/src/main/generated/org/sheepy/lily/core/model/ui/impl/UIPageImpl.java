package org.sheepy.lily.core.model.ui.impl;

import java.util.List;
import org.joml.Vector2ic;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.presentation.IPositionElement;
import org.sheepy.lily.core.model.presentation.ISizedElement;
import org.sheepy.lily.core.model.types.EHorizontalRelative;
import org.sheepy.lily.core.model.types.EVerticalRelative;
import org.sheepy.lily.core.model.ui.IPanel;
import org.sheepy.lily.core.model.ui.UIModelDefinition;
import org.sheepy.lily.core.model.ui.UIPage;

public final class UIPageImpl extends FeaturedObject<UIPage.Features<?>> implements UIPage {
  private static final int FEATURE_COUNT = 7;
  private final ModelNotifier<UIPage.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private Vector2ic position;
  private EVerticalRelative verticalRelative;
  private EHorizontalRelative horizontalRelative;
  private int width;
  private int height;
  private final List<IPanel> panels = newObservableList(UIPage.FeatureIDs.PANELS, true, true);

  public UIPageImpl(final String name) {
    this.name = name;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<UIPage.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public String name() {
    return name;
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
  public List<IPanel> panels() {
    return panels;
  }

  @Override
  public Group<UIPage> lmGroup() {
    return UIModelDefinition.Groups.UI_PAGE;
  }

  @Override
  protected FeatureSetter<UIPage> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<UIPage> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case UIPage.FeatureIDs.NAME -> 0;
      case UIPage.FeatureIDs.POSITION -> 1;
      case UIPage.FeatureIDs.VERTICAL_RELATIVE -> 2;
      case UIPage.FeatureIDs.HORIZONTAL_RELATIVE -> 3;
      case UIPage.FeatureIDs.WIDTH -> 4;
      case UIPage.FeatureIDs.HEIGHT -> 5;
      case UIPage.FeatureIDs.PANELS -> 6;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<UIPage> GET_MAP = new FeatureGetter.Builder<UIPage>(FEATURE_COUNT, UIPageImpl::featureIndexStatic).add(UIPage.FeatureIDs.NAME, UIPage::name).add(UIPage.FeatureIDs.POSITION, UIPage::position).add(UIPage.FeatureIDs.VERTICAL_RELATIVE, UIPage::verticalRelative).add(UIPage.FeatureIDs.HORIZONTAL_RELATIVE, UIPage::horizontalRelative).add(UIPage.FeatureIDs.WIDTH, UIPage::width).add(UIPage.FeatureIDs.HEIGHT, UIPage::height).add(UIPage.FeatureIDs.PANELS, UIPage::panels).build();
    private static final FeatureSetter<UIPage> SET_MAP = new FeatureSetter.Builder<UIPage>(FEATURE_COUNT, UIPageImpl::featureIndexStatic).add(UIPage.FeatureIDs.POSITION, (object, value) -> ((UIPageImpl) object).position((Vector2ic) value)).add(UIPage.FeatureIDs.VERTICAL_RELATIVE, (object, value) -> ((UIPageImpl) object).verticalRelative((EVerticalRelative) value)).add(UIPage.FeatureIDs.HORIZONTAL_RELATIVE, (object, value) -> ((UIPageImpl) object).horizontalRelative((EHorizontalRelative) value)).add(UIPage.FeatureIDs.WIDTH, (object, value) -> ((UIPageImpl) object).width((int) value)).add(UIPage.FeatureIDs.HEIGHT, (object, value) -> ((UIPageImpl) object).height((int) value)).build();
  }
}
