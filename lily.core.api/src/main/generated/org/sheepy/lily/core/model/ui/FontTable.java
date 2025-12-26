package org.sheepy.lily.core.model.ui;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.core.model.resource.FileResource;
import org.sheepy.lily.core.model.resource.ResourceModelDefinition;
import org.sheepy.lily.core.model.types.ECharTable;
import org.sheepy.lily.core.model.types.LNamedElement;
import org.sheepy.lily.core.model.types.TypesModelDefinition;
import org.sheepy.lily.core.model.ui.builder.FontTableBuilder;

public interface FontTable extends LNamedElement {
  static Builder builder() {
    return new FontTableBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  FileResource file();
  List<ECharTable> charTables();
  void file(final FileResource file);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int FILE = 193407419;
    int CHAR_TABLES = -357487014;
  }

  interface Features<T extends Features<T>> extends LNamedElement.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Relation<FileResource, FileResource, Listener<FileResource>, Features<?>> FILE = new RelationBuilder<FileResource, FileResource, Listener<FileResource>, Features<?>>().name("file").mandatory(true).contains(true).id(FontTable.FeatureIDs.FILE).concept(() -> ResourceModelDefinition.Groups.FILE_RESOURCE).build();
    Attribute<ECharTable, List<ECharTable>, Listener<List<ECharTable>>, Features<?>> CHAR_TABLES = new AttributeBuilder<ECharTable, List<ECharTable>, Listener<List<ECharTable>>, Features<?>>().name("charTables").many(true).mandatory(true).id(FontTable.FeatureIDs.CHAR_TABLES).datatype(() -> TypesModelDefinition.Enums.E_CHAR_TABLE).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, FILE, CHAR_TABLES);
  }

  interface Builder extends IFeaturedObject.Builder<FontTable> {
    Builder name(String name);
    Builder file(Supplier<FileResource> file);
    Builder addCharTable(ECharTable charTable);
    Builder addCharTables(List<ECharTable> charTables);
  }
}
