package org.sheepy.lily.core.model.variable;

import java.util.List;
import org.logoce.lmf.core.api.model.BuilderSupplier;
import org.logoce.lmf.core.lang.Alias;
import org.logoce.lmf.core.lang.Enum;
import org.logoce.lmf.core.lang.Group;
import org.logoce.lmf.core.lang.JavaWrapper;
import org.logoce.lmf.core.lang.Primitive;
import org.logoce.lmf.core.lang.Unit;
import org.logoce.lmf.core.lang.builder.GroupBuilder;
import org.logoce.lmf.core.lang.builder.IncludeBuilder;
import org.logoce.lmf.core.lang.builder.JavaWrapperBuilder;
import org.logoce.lmf.core.lang.builder.UnitBuilder;
import org.sheepy.lily.core.api.util.FeatureDefinition;
import org.sheepy.lily.core.model.action.Action;
import org.sheepy.lily.core.model.action.ActionModelDefinition;
import org.sheepy.lily.core.model.types.LNamedElement;
import org.sheepy.lily.core.model.types.TypesModelDefinition;
import org.sheepy.lily.core.model.variable.builder.BooleanChangeActionBuilder;
import org.sheepy.lily.core.model.variable.builder.ChainResolverBuilder;
import org.sheepy.lily.core.model.variable.builder.ChainVariableResolverBuilder;
import org.sheepy.lily.core.model.variable.builder.DirectVariableResolverBuilder;
import org.sheepy.lily.core.model.variable.builder.DurationVariableBuilder;
import org.sheepy.lily.core.model.variable.builder.FloatVariableBuilder;
import org.sheepy.lily.core.model.variable.builder.IntChangeActionBuilder;
import org.sheepy.lily.core.model.variable.builder.IntVariableBuilder;
import org.sheepy.lily.core.model.variable.builder.ModelVariablePkgBuilder;
import org.sheepy.lily.core.model.variable.builder.SetVariableActionBuilder;
import org.sheepy.lily.core.model.variable.builder.VarChangeActionPkgBuilder;
import org.sheepy.lily.core.model.variable.builder.Vector3fVariableBuilder;

public interface VariableModelDefinition {
  interface Generics {
  }

  interface Groups {
    Group<IVariableResolver> I_VARIABLE_RESOLVER = new GroupBuilder<IVariableResolver>().name("IVariableResolver").addFeatures(IVariableResolver.Features.ALL).build();
    Group<IDefinitionContainer> I_DEFINITION_CONTAINER = new GroupBuilder<IDefinitionContainer>().name("IDefinitionContainer").addFeatures(IDefinitionContainer.Features.ALL).build();
    Group<ChainVariableResolver> CHAIN_VARIABLE_RESOLVER = new GroupBuilder<ChainVariableResolver>().name("ChainVariableResolver").concrete(true).addInclude(() -> new IncludeBuilder<IVariableResolver>().group(() -> I_VARIABLE_RESOLVER).build()).addFeatures(ChainVariableResolver.Features.ALL).lmBuilder(new BuilderSupplier<>(ChainVariableResolverBuilder::new)).build();
    Group<ChainResolver> CHAIN_RESOLVER = new GroupBuilder<ChainResolver>().name("ChainResolver").concrete(true).addInclude(() -> new IncludeBuilder<IDefinitionContainer>().group(() -> I_DEFINITION_CONTAINER).build()).addFeatures(ChainResolver.Features.ALL).lmBuilder(new BuilderSupplier<>(ChainResolverBuilder::new)).build();
    Group<AbstractDefinedVariableResolver> ABSTRACT_DEFINED_VARIABLE_RESOLVER = new GroupBuilder<AbstractDefinedVariableResolver>().name("AbstractDefinedVariableResolver").addInclude(() -> new IncludeBuilder<IVariableResolver>().group(() -> I_VARIABLE_RESOLVER).build()).addInclude(() -> new IncludeBuilder<IDefinitionContainer>().group(() -> I_DEFINITION_CONTAINER).build()).addFeatures(AbstractDefinedVariableResolver.Features.ALL).build();
    Group<DirectVariableResolver> DIRECT_VARIABLE_RESOLVER = new GroupBuilder<DirectVariableResolver>().name("DirectVariableResolver").concrete(true).addInclude(() -> new IncludeBuilder<AbstractDefinedVariableResolver>().group(() -> ABSTRACT_DEFINED_VARIABLE_RESOLVER).build()).addFeatures(DirectVariableResolver.Features.ALL).lmBuilder(new BuilderSupplier<>(DirectVariableResolverBuilder::new)).build();
    Group<VarChangeAction> VAR_CHANGE_ACTION = new GroupBuilder<VarChangeAction>().name("VarChangeAction").addInclude(() -> new IncludeBuilder<Action>().group(() -> ActionModelDefinition.Groups.ACTION).build()).addFeatures(VarChangeAction.Features.ALL).build();
    Group<BooleanChangeAction> BOOLEAN_CHANGE_ACTION = new GroupBuilder<BooleanChangeAction>().name("BooleanChangeAction").concrete(true).addInclude(() -> new IncludeBuilder<VarChangeAction>().group(() -> VAR_CHANGE_ACTION).build()).addFeatures(BooleanChangeAction.Features.ALL).lmBuilder(new BuilderSupplier<>(BooleanChangeActionBuilder::new)).build();
    Group<IntChangeAction> INT_CHANGE_ACTION = new GroupBuilder<IntChangeAction>().name("IntChangeAction").concrete(true).addInclude(() -> new IncludeBuilder<VarChangeAction>().group(() -> VAR_CHANGE_ACTION).build()).addFeatures(IntChangeAction.Features.ALL).lmBuilder(new BuilderSupplier<>(IntChangeActionBuilder::new)).build();
    Group<VarChangeActionPkg> VAR_CHANGE_ACTION_PKG = new GroupBuilder<VarChangeActionPkg>().name("VarChangeActionPkg").concrete(true).addFeatures(VarChangeActionPkg.Features.ALL).lmBuilder(new BuilderSupplier<>(VarChangeActionPkgBuilder::new)).build();
    Group<IModelVariable> I_MODEL_VARIABLE = new GroupBuilder<IModelVariable>().name("IModelVariable").addInclude(() -> new IncludeBuilder<LNamedElement>().group(() -> TypesModelDefinition.Groups.L_NAMED_ELEMENT).build()).addFeatures(IModelVariable.Features.ALL).build();
    Group<ModelVariablePkg> MODEL_VARIABLE_PKG = new GroupBuilder<ModelVariablePkg>().name("ModelVariablePkg").concrete(true).addFeatures(ModelVariablePkg.Features.ALL).lmBuilder(new BuilderSupplier<>(ModelVariablePkgBuilder::new)).build();
    Group<IntVariable> INT_VARIABLE = new GroupBuilder<IntVariable>().name("IntVariable").concrete(true).addInclude(() -> new IncludeBuilder<IModelVariable>().group(() -> I_MODEL_VARIABLE).build()).addFeatures(IntVariable.Features.ALL).lmBuilder(new BuilderSupplier<>(IntVariableBuilder::new)).build();
    Group<FloatVariable> FLOAT_VARIABLE = new GroupBuilder<FloatVariable>().name("FloatVariable").concrete(true).addInclude(() -> new IncludeBuilder<IModelVariable>().group(() -> I_MODEL_VARIABLE).build()).addFeatures(FloatVariable.Features.ALL).lmBuilder(new BuilderSupplier<>(FloatVariableBuilder::new)).build();
    Group<Vector3fVariable> VECTOR3F_VARIABLE = new GroupBuilder<Vector3fVariable>().name("Vector3fVariable").concrete(true).addInclude(() -> new IncludeBuilder<IModelVariable>().group(() -> I_MODEL_VARIABLE).build()).addFeatures(Vector3fVariable.Features.ALL).lmBuilder(new BuilderSupplier<>(Vector3fVariableBuilder::new)).build();
    Group<DurationVariable> DURATION_VARIABLE = new GroupBuilder<DurationVariable>().name("DurationVariable").concrete(true).addInclude(() -> new IncludeBuilder<IModelVariable>().group(() -> I_MODEL_VARIABLE).build()).addFeatures(DurationVariable.Features.ALL).lmBuilder(new BuilderSupplier<>(DurationVariableBuilder::new)).build();
    Group<IModelVariableAction> I_MODEL_VARIABLE_ACTION = new GroupBuilder<IModelVariableAction>().name("IModelVariableAction").addFeatures(IModelVariableAction.Features.ALL).build();
    Group<IModelVariableActionContainer> I_MODEL_VARIABLE_ACTION_CONTAINER = new GroupBuilder<IModelVariableActionContainer>().name("IModelVariableActionContainer").addFeatures(IModelVariableActionContainer.Features.ALL).build();
    Group<SetVariableAction> SET_VARIABLE_ACTION = new GroupBuilder<SetVariableAction>().name("SetVariableAction").concrete(true).addInclude(() -> new IncludeBuilder<IModelVariableAction>().group(() -> I_MODEL_VARIABLE_ACTION).build()).addFeatures(SetVariableAction.Features.ALL).lmBuilder(new BuilderSupplier<>(SetVariableActionBuilder::new)).build();
    List<Group<?>> ALL = List.of(I_VARIABLE_RESOLVER, I_DEFINITION_CONTAINER, CHAIN_VARIABLE_RESOLVER, CHAIN_RESOLVER, ABSTRACT_DEFINED_VARIABLE_RESOLVER, DIRECT_VARIABLE_RESOLVER, VAR_CHANGE_ACTION, BOOLEAN_CHANGE_ACTION, INT_CHANGE_ACTION, VAR_CHANGE_ACTION_PKG, I_MODEL_VARIABLE, MODEL_VARIABLE_PKG, INT_VARIABLE, FLOAT_VARIABLE, VECTOR3F_VARIABLE, DURATION_VARIABLE, I_MODEL_VARIABLE_ACTION, I_MODEL_VARIABLE_ACTION_CONTAINER, SET_VARIABLE_ACTION);
  }

  interface Units {
    Unit<String> VARIABLE_DEFINITION = new UnitBuilder<String>().name("VariableDefinition").primitive(Primitive.String).build();
    List<Unit<?>> ALL = List.of(VARIABLE_DEFINITION);
  }

  interface Enums {
    List<Enum<?>> ALL = List.of();
  }

  interface Aliases {
    List<Alias> ALL = List.of();
  }

  interface JavaWrappers {
    JavaWrapper<FeatureDefinition> L_RESOLVED_VARIABLE_FEATURE = new JavaWrapperBuilder<FeatureDefinition>().name("LResolvedVariableFeature").qualifiedClassName("org.sheepy.lily.core.api.util.FeatureDefinition").build();
    List<JavaWrapper<?>> ALL = List.of(L_RESOLVED_VARIABLE_FEATURE);
  }
}
