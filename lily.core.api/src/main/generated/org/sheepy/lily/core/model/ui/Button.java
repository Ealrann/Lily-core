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
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.core.model.action.Action;
import org.sheepy.lily.core.model.action.ActionList;
import org.sheepy.lily.core.model.action.ActionModelDefinition;
import org.sheepy.lily.core.model.inference.IInferenceObject;
import org.sheepy.lily.core.model.presentation.IPositionElement;
import org.sheepy.lily.core.model.presentation.ISizedElement;
import org.sheepy.lily.core.model.types.EHorizontalRelative;
import org.sheepy.lily.core.model.types.EKeyState;
import org.sheepy.lily.core.model.types.EVerticalRelative;
import org.sheepy.lily.core.model.types.TypesModelDefinition;
import org.sheepy.lily.core.model.ui.builder.ButtonBuilder;

public interface Button extends AbstractButton {
  static Builder builder() {
    return new ButtonBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  int shortcut();
  EKeyState state();
  List<Action> actions();
  void shortcut(final int shortcut);
  void state(final EKeyState state);
  ActionList<?> lActions();
  IInferenceObject getExecutor();

  interface FeatureIDs {
    int POSITION = IPositionElement.FeatureIDs.POSITION;
    int VERTICAL_RELATIVE = IPositionElement.FeatureIDs.VERTICAL_RELATIVE;
    int HORIZONTAL_RELATIVE = IPositionElement.FeatureIDs.HORIZONTAL_RELATIVE;
    int WIDTH = ISizedElement.FeatureIDs.WIDTH;
    int HEIGHT = ISizedElement.FeatureIDs.HEIGHT;
    int FONT = TextWidget.FeatureIDs.FONT;
    int TEXT = AbstractButton.FeatureIDs.TEXT;
    int SHORTCUT = -1571338838;
    int STATE = 1621915053;
    int ACTIONS = 322577177;
  }

  interface Features<T extends Features<T>> extends AbstractButton.Features<T> {
    Attribute<Vector2ic, Vector2ic, Listener<Vector2ic>, IPositionElement.Features<?>> POSITION = IPositionElement.Features.POSITION;
    Attribute<EVerticalRelative, EVerticalRelative, Listener<EVerticalRelative>, IPositionElement.Features<?>> VERTICAL_RELATIVE = IPositionElement.Features.VERTICAL_RELATIVE;
    Attribute<EHorizontalRelative, EHorizontalRelative, Listener<EHorizontalRelative>, IPositionElement.Features<?>> HORIZONTAL_RELATIVE = IPositionElement.Features.HORIZONTAL_RELATIVE;
    Attribute<Integer, Integer, IntListener, ISizedElement.Features<?>> WIDTH = ISizedElement.Features.WIDTH;
    Attribute<Integer, Integer, IntListener, ISizedElement.Features<?>> HEIGHT = ISizedElement.Features.HEIGHT;
    Relation<Font, Font, Listener<Font>, TextWidget.Features<?>> FONT = TextWidget.Features.FONT;
    Attribute<String, String, Listener<String>, AbstractButton.Features<?>> TEXT = AbstractButton.Features.TEXT;
    Attribute<Integer, Integer, IntListener, Features<?>> SHORTCUT = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("shortcut").id(Button.FeatureIDs.SHORTCUT).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    Attribute<EKeyState, EKeyState, Listener<EKeyState>, Features<?>> STATE = new AttributeBuilder<EKeyState, EKeyState, Listener<EKeyState>, Features<?>>().name("state").id(Button.FeatureIDs.STATE).datatype(() -> TypesModelDefinition.Enums.E_KEY_STATE).build();
    Relation<Action, List<Action>, Listener<List<Action>>, Features<?>> ACTIONS = new RelationBuilder<Action, List<Action>, Listener<List<Action>>, Features<?>>().name("actions").many(true).contains(true).id(Button.FeatureIDs.ACTIONS).concept(() -> ActionModelDefinition.Groups.ACTION).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(POSITION, VERTICAL_RELATIVE, HORIZONTAL_RELATIVE, WIDTH, HEIGHT, FONT, TEXT, SHORTCUT, STATE, ACTIONS);
  }

  interface Builder extends IFeaturedObject.Builder<Button> {
    Builder position(Vector2ic position);
    Builder verticalRelative(EVerticalRelative verticalRelative);
    Builder horizontalRelative(EHorizontalRelative horizontalRelative);
    Builder width(int width);
    Builder height(int height);
    Builder font(Supplier<Font> font);
    Builder text(String text);
    Builder shortcut(int shortcut);
    Builder state(EKeyState state);
    Builder addAction(Supplier<Action> action);
    Builder addActions(List<Action> actions);
  }
}
