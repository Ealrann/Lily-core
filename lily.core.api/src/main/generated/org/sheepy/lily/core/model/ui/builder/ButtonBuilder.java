package org.sheepy.lily.core.model.ui.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import org.joml.Vector2ic;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.util.BuildUtils;
import org.sheepy.lily.core.model.action.Action;
import org.sheepy.lily.core.model.types.EHorizontalRelative;
import org.sheepy.lily.core.model.types.EKeyState;
import org.sheepy.lily.core.model.types.EVerticalRelative;
import org.sheepy.lily.core.model.ui.Button;
import org.sheepy.lily.core.model.ui.Button.Builder;
import org.sheepy.lily.core.model.ui.Font;
import org.sheepy.lily.core.model.ui.impl.ButtonImpl;

public final class ButtonBuilder implements Builder {
  private Vector2ic position = ((Function<String, Vector2ic>) it -> { if(it!=null){final String[] split=it.split(";");if(split.length==2){int x=Integer.parseInt(split[0]);int y=Integer.parseInt(split[1]);return new org.joml.Vector2i(x,y);}}return new org.joml.Vector2i(0,0); }).apply("0;0");
  private EVerticalRelative verticalRelative = EVerticalRelative.TOP;
  private EHorizontalRelative horizontalRelative = EHorizontalRelative.LEFT;
  private int width;
  private int height;
  private Supplier<Font> font = () -> null;
  private String text = "";
  private int shortcut;
  private EKeyState state = EKeyState.RELEASED;
  private final List<Supplier<Action>> actions = new ArrayList<>();

  public ButtonBuilder() {
  }

  @Override
  public ButtonBuilder position(Vector2ic position) {
    this.position = position;
    return this;
  }

  @Override
  public ButtonBuilder verticalRelative(EVerticalRelative verticalRelative) {
    this.verticalRelative = verticalRelative;
    return this;
  }

  @Override
  public ButtonBuilder horizontalRelative(EHorizontalRelative horizontalRelative) {
    this.horizontalRelative = horizontalRelative;
    return this;
  }

  @Override
  public ButtonBuilder width(int width) {
    this.width = width;
    return this;
  }

  @Override
  public ButtonBuilder height(int height) {
    this.height = height;
    return this;
  }

  @Override
  public ButtonBuilder font(Supplier<Font> font) {
    this.font = font;
    return this;
  }

  @Override
  public ButtonBuilder text(String text) {
    this.text = text;
    return this;
  }

  @Override
  public ButtonBuilder shortcut(int shortcut) {
    this.shortcut = shortcut;
    return this;
  }

  @Override
  public ButtonBuilder state(EKeyState state) {
    this.state = state;
    return this;
  }

  @Override
  public ButtonBuilder addAction(Supplier<Action> action) {
    this.actions.add(action);
    return this;
  }

  @Override
  public ButtonBuilder addActions(final List<Action> actions) {
    actions.forEach(value -> this.actions.add(() -> value));
    return this;
  }

  @Override
  public Button build() {
    final var builtActions = BuildUtils.collectSuppliers(actions);
    final var built = new ButtonImpl();
    built.position(position);
    built.verticalRelative(verticalRelative);
    built.horizontalRelative(horizontalRelative);
    built.width(width);
    built.height(height);
    built.font(font.get());
    built.text(text);
    built.shortcut(shortcut);
    built.state(state);
    built.actions().addAll(builtActions);
    return built;
  }

  @Override
  public <AttributeType> void push(final Attribute<?, ?, ?, ?> attribute,
      final AttributeType value) {
    Inserters.ATTRIBUTE_INSERTER.push(this, attribute.id(), value);
  }

  @Override
  public <RelationType extends LMObject> void push(final Relation<RelationType, ?, ?, ?> relation,
      final Supplier<RelationType> supplier) {
    Inserters.RELATION_INSERTER.push(this, relation.id(), supplier);
  }

  private static final class Inserters {
    private static final FeatureInserter<ButtonBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<ButtonBuilder>(8, Inserters::attributeIndex).add(Button.FeatureIDs.POSITION, (builder, value) -> builder.position((Vector2ic) value)).add(Button.FeatureIDs.VERTICAL_RELATIVE, (builder, value) -> builder.verticalRelative((EVerticalRelative) value)).add(Button.FeatureIDs.HORIZONTAL_RELATIVE, (builder, value) -> builder.horizontalRelative((EHorizontalRelative) value)).add(Button.FeatureIDs.WIDTH, (builder, value) -> builder.width((int) value)).add(Button.FeatureIDs.HEIGHT, (builder, value) -> builder.height((int) value)).add(Button.FeatureIDs.TEXT, (builder, value) -> builder.text((String) value)).add(Button.FeatureIDs.SHORTCUT, (builder, value) -> builder.shortcut((int) value)).add(Button.FeatureIDs.STATE, (builder, value) -> builder.state((EKeyState) value)).build();
    private static final RelationLazyInserter<ButtonBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<ButtonBuilder>(2, Inserters::relationIndex).add(Button.FeatureIDs.FONT, (builder, value) -> builder.font((Supplier<Font>) value)).add(Button.FeatureIDs.ACTIONS, (builder, value) -> builder.addAction((Supplier<Action>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case Button.FeatureIDs.POSITION -> 0;
        case Button.FeatureIDs.VERTICAL_RELATIVE -> 1;
        case Button.FeatureIDs.HORIZONTAL_RELATIVE -> 2;
        case Button.FeatureIDs.WIDTH -> 3;
        case Button.FeatureIDs.HEIGHT -> 4;
        case Button.FeatureIDs.TEXT -> 5;
        case Button.FeatureIDs.SHORTCUT -> 6;
        case Button.FeatureIDs.STATE -> 7;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case Button.FeatureIDs.FONT -> 0;
        case Button.FeatureIDs.ACTIONS -> 1;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
