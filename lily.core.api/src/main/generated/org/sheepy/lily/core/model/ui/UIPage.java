package org.sheepy.lily.core.model.ui;

import java.util.List;
import java.util.function.Supplier;
import org.joml.Vector2ic;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.IntListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.core.model.presentation.IPositionElement;
import org.sheepy.lily.core.model.presentation.ISizedElement;
import org.sheepy.lily.core.model.types.EHorizontalRelative;
import org.sheepy.lily.core.model.types.EVerticalRelative;
import org.sheepy.lily.core.model.types.LNamedElement;
import org.sheepy.lily.core.model.ui.builder.UIPageBuilder;

public interface UIPage extends ISizedElement, LNamedElement {
  static Builder builder() {
    return new UIPageBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<IPanel> panels();

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int POSITION = IPositionElement.FeatureIDs.POSITION;
    int VERTICAL_RELATIVE = IPositionElement.FeatureIDs.VERTICAL_RELATIVE;
    int HORIZONTAL_RELATIVE = IPositionElement.FeatureIDs.HORIZONTAL_RELATIVE;
    int WIDTH = ISizedElement.FeatureIDs.WIDTH;
    int HEIGHT = ISizedElement.FeatureIDs.HEIGHT;
    int PANELS = -1253825470;
  }

  interface Features<T extends Features<T>> extends ISizedElement.Features<T>, LNamedElement.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<Vector2ic, Vector2ic, Listener<Vector2ic>, IPositionElement.Features<?>> POSITION = IPositionElement.Features.POSITION;
    Attribute<EVerticalRelative, EVerticalRelative, Listener<EVerticalRelative>, IPositionElement.Features<?>> VERTICAL_RELATIVE = IPositionElement.Features.VERTICAL_RELATIVE;
    Attribute<EHorizontalRelative, EHorizontalRelative, Listener<EHorizontalRelative>, IPositionElement.Features<?>> HORIZONTAL_RELATIVE = IPositionElement.Features.HORIZONTAL_RELATIVE;
    Attribute<Integer, Integer, IntListener, ISizedElement.Features<?>> WIDTH = ISizedElement.Features.WIDTH;
    Attribute<Integer, Integer, IntListener, ISizedElement.Features<?>> HEIGHT = ISizedElement.Features.HEIGHT;
    Relation<IPanel, List<IPanel>, Listener<List<IPanel>>, Features<?>> PANELS = new RelationBuilder<IPanel, List<IPanel>, Listener<List<IPanel>>, Features<?>>().name("panels").many(true).contains(true).id(UIPage.FeatureIDs.PANELS).concept(() -> UIModelDefinition.Groups.I_PANEL).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, POSITION, VERTICAL_RELATIVE, HORIZONTAL_RELATIVE, WIDTH, HEIGHT, PANELS);
  }

  interface Builder extends IFeaturedObject.Builder<UIPage> {
    Builder name(String name);
    Builder position(Vector2ic position);
    Builder verticalRelative(EVerticalRelative verticalRelative);
    Builder horizontalRelative(EHorizontalRelative horizontalRelative);
    Builder width(int width);
    Builder height(int height);
    Builder addPanel(Supplier<IPanel> panel);
    Builder addPanels(List<IPanel> panels);
  }
}
