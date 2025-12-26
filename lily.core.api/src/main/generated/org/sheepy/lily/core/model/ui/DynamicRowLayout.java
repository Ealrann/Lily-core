package org.sheepy.lily.core.model.ui;

import java.util.List;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.IntListener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.sheepy.lily.core.model.ui.builder.DynamicRowLayoutBuilder;

public interface DynamicRowLayout extends IControl {
  static Builder builder() {
    return new DynamicRowLayoutBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  int height();
  int columnCount();
  void height(final int height);
  void columnCount(final int columnCount);

  interface FeatureIDs {
    int HEIGHT = -810048456;
    int COLUMN_COUNT = -1263967512;
  }

  interface Features<T extends Features<T>> extends IControl.Features<T> {
    Attribute<Integer, Integer, IntListener, Features<?>> HEIGHT = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("height").defaultValue("16").id(DynamicRowLayout.FeatureIDs.HEIGHT).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    Attribute<Integer, Integer, IntListener, Features<?>> COLUMN_COUNT = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("columnCount").defaultValue("1").id(DynamicRowLayout.FeatureIDs.COLUMN_COUNT).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(HEIGHT, COLUMN_COUNT);
  }

  interface Builder extends IFeaturedObject.Builder<DynamicRowLayout> {
    Builder height(int height);
    Builder columnCount(int columnCount);
  }
}
