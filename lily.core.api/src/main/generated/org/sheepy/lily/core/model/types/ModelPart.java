package org.sheepy.lily.core.model.types;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Model;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.core.model.types.builder.ModelPartBuilder;

public interface ModelPart extends Model {
  static Builder builder() {
    return new ModelPartBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<LMObject> children();

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int DOMAIN = Model.FeatureIDs.DOMAIN;
    int IMPORTS = Model.FeatureIDs.IMPORTS;
    int METAMODELS = Model.FeatureIDs.METAMODELS;
    int CHILDREN = -1525288064;
  }

  interface Features<T extends Features<T>> extends Model.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<String, String, Listener<String>, Model.Features<?>> DOMAIN = Model.Features.DOMAIN;
    Attribute<String, List<String>, Listener<List<String>>, Model.Features<?>> IMPORTS = Model.Features.IMPORTS;
    Attribute<String, List<String>, Listener<List<String>>, Model.Features<?>> METAMODELS = Model.Features.METAMODELS;
    Relation<LMObject, List<LMObject>, Listener<List<LMObject>>, Features<?>> CHILDREN = new RelationBuilder<LMObject, List<LMObject>, Listener<List<LMObject>>, Features<?>>().name("children").many(true).contains(true).id(ModelPart.FeatureIDs.CHILDREN).concept(() -> LMCoreModelDefinition.Groups.LM_OBJECT).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, DOMAIN, IMPORTS, METAMODELS, CHILDREN);
  }

  interface Builder extends IFeaturedObject.Builder<ModelPart> {
    Builder name(String name);
    Builder domain(String domain);
    Builder addImport(String import_);
    Builder addMetamodel(String metamodel);
    Builder addChildren(Supplier<LMObject> children);
    Builder addChildren(List<LMObject> children);
    Builder addImports(List<String> imports);
    Builder addMetamodels(List<String> metamodels);
  }
}
