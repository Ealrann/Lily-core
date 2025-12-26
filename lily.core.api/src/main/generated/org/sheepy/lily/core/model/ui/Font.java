package org.sheepy.lily.core.model.ui;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.FloatListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.core.model.resource.IRootResource;
import org.sheepy.lily.core.model.ui.builder.FontBuilder;

public interface Font extends IRootResource {
  static Builder builder() {
    return new FontBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<FontTable> tables();
  float height();
  void height(final float height);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int TABLES = -239347700;
    int HEIGHT = -578999602;
  }

  interface Features<T extends Features<T>> extends IRootResource.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Relation<FontTable, List<FontTable>, Listener<List<FontTable>>, Features<?>> TABLES = new RelationBuilder<FontTable, List<FontTable>, Listener<List<FontTable>>, Features<?>>().name("tables").many(true).mandatory(true).contains(true).id(Font.FeatureIDs.TABLES).concept(() -> UIModelDefinition.Groups.FONT_TABLE).build();
    Attribute<Float, Float, FloatListener, Features<?>> HEIGHT = new AttributeBuilder<Float, Float, FloatListener, Features<?>>().name("height").mandatory(true).defaultValue("18f").id(Font.FeatureIDs.HEIGHT).datatype(() -> LMCoreModelDefinition.Units.FLOAT).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, TABLES, HEIGHT);
  }

  interface Builder extends IFeaturedObject.Builder<Font> {
    Builder name(String name);
    Builder addTable(Supplier<FontTable> table);
    Builder height(float height);
    Builder addTables(List<FontTable> tables);
  }
}
