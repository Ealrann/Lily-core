package org.sheepy.lily.core.model.application;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.core.model.application.builder.SpecialEffectBuilder;
import org.sheepy.lily.core.model.resource.FileResource;
import org.sheepy.lily.core.model.resource.IRootResource;
import org.sheepy.lily.core.model.resource.ResourceModelDefinition;
import org.sheepy.lily.core.model.types.LNamedElement;
import org.sheepy.lily.core.model.variable.IModelVariable;
import org.sheepy.lily.core.model.variable.VariableModelDefinition;

public interface SpecialEffect extends LNamedElement, IRootResource {
  static Builder builder() {
    return new SpecialEffectBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  FileResource shader();
  List<IModelVariable> inputs();
  void shader(final FileResource shader);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int SHADER = 1028279681;
    int INPUTS = 747992965;
  }

  interface Features<T extends Features<T>> extends LNamedElement.Features<T>, IRootResource.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Relation<FileResource, FileResource, Listener<FileResource>, Features<?>> SHADER = new RelationBuilder<FileResource, FileResource, Listener<FileResource>, Features<?>>().name("shader").mandatory(true).contains(true).id(SpecialEffect.FeatureIDs.SHADER).concept(() -> ResourceModelDefinition.Groups.FILE_RESOURCE).build();
    Relation<IModelVariable, List<IModelVariable>, Listener<List<IModelVariable>>, Features<?>> INPUTS = new RelationBuilder<IModelVariable, List<IModelVariable>, Listener<List<IModelVariable>>, Features<?>>().name("inputs").many(true).id(SpecialEffect.FeatureIDs.INPUTS).concept(() -> VariableModelDefinition.Groups.I_MODEL_VARIABLE).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, SHADER, INPUTS);
  }

  interface Builder extends IFeaturedObject.Builder<SpecialEffect> {
    Builder name(String name);
    Builder shader(Supplier<FileResource> shader);
    Builder addInput(Supplier<IModelVariable> input);
    Builder addInputs(List<IModelVariable> inputs);
  }
}
