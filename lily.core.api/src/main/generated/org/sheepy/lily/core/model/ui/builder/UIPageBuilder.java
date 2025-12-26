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
import org.sheepy.lily.core.model.types.EHorizontalRelative;
import org.sheepy.lily.core.model.types.EVerticalRelative;
import org.sheepy.lily.core.model.ui.IPanel;
import org.sheepy.lily.core.model.ui.UIPage;
import org.sheepy.lily.core.model.ui.UIPage.Builder;
import org.sheepy.lily.core.model.ui.impl.UIPageImpl;

public final class UIPageBuilder implements Builder {
  private String name;
  private Vector2ic position = ((Function<String, Vector2ic>) it -> { if(it!=null){final String[] split=it.split(";");if(split.length==2){int x=Integer.parseInt(split[0]);int y=Integer.parseInt(split[1]);return new org.joml.Vector2i(x,y);}}return new org.joml.Vector2i(0,0); }).apply("0;0");
  private EVerticalRelative verticalRelative = EVerticalRelative.TOP;
  private EHorizontalRelative horizontalRelative = EHorizontalRelative.LEFT;
  private int width;
  private int height;
  private final List<Supplier<IPanel>> panels = new ArrayList<>();

  public UIPageBuilder() {
  }

  @Override
  public UIPageBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public UIPageBuilder position(Vector2ic position) {
    this.position = position;
    return this;
  }

  @Override
  public UIPageBuilder verticalRelative(EVerticalRelative verticalRelative) {
    this.verticalRelative = verticalRelative;
    return this;
  }

  @Override
  public UIPageBuilder horizontalRelative(EHorizontalRelative horizontalRelative) {
    this.horizontalRelative = horizontalRelative;
    return this;
  }

  @Override
  public UIPageBuilder width(int width) {
    this.width = width;
    return this;
  }

  @Override
  public UIPageBuilder height(int height) {
    this.height = height;
    return this;
  }

  @Override
  public UIPageBuilder addPanel(Supplier<IPanel> panel) {
    this.panels.add(panel);
    return this;
  }

  @Override
  public UIPageBuilder addPanels(final List<IPanel> panels) {
    panels.forEach(value -> this.panels.add(() -> value));
    return this;
  }

  @Override
  public UIPage build() {
    final var builtPanels = BuildUtils.collectSuppliers(panels);
    final var built = new UIPageImpl(name);
    built.position(position);
    built.verticalRelative(verticalRelative);
    built.horizontalRelative(horizontalRelative);
    built.width(width);
    built.height(height);
    built.panels().addAll(builtPanels);
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
    private static final FeatureInserter<UIPageBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<UIPageBuilder>(6, Inserters::attributeIndex).add(UIPage.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(UIPage.FeatureIDs.POSITION, (builder, value) -> builder.position((Vector2ic) value)).add(UIPage.FeatureIDs.VERTICAL_RELATIVE, (builder, value) -> builder.verticalRelative((EVerticalRelative) value)).add(UIPage.FeatureIDs.HORIZONTAL_RELATIVE, (builder, value) -> builder.horizontalRelative((EHorizontalRelative) value)).add(UIPage.FeatureIDs.WIDTH, (builder, value) -> builder.width((int) value)).add(UIPage.FeatureIDs.HEIGHT, (builder, value) -> builder.height((int) value)).build();
    private static final RelationLazyInserter<UIPageBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<UIPageBuilder>(1, Inserters::relationIndex).add(UIPage.FeatureIDs.PANELS, (builder, value) -> builder.addPanel((Supplier<IPanel>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case UIPage.FeatureIDs.NAME -> 0;
        case UIPage.FeatureIDs.POSITION -> 1;
        case UIPage.FeatureIDs.VERTICAL_RELATIVE -> 2;
        case UIPage.FeatureIDs.HORIZONTAL_RELATIVE -> 3;
        case UIPage.FeatureIDs.WIDTH -> 4;
        case UIPage.FeatureIDs.HEIGHT -> 5;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case UIPage.FeatureIDs.PANELS -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
