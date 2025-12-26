package org.sheepy.lily.core.model.variable;

import java.util.List;
import java.util.Optional;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IJavaWrapperConverter;
import org.logoce.lmf.core.api.model.IModelPackage;
import org.logoce.lmf.core.lang.Enum;
import org.logoce.lmf.core.lang.Group;
import org.logoce.lmf.core.lang.JavaWrapper;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.MetaModel;
import org.logoce.lmf.core.lang.builder.MetaModelBuilder;

public final class VariableModelPackage implements IModelPackage {
  public static final VariableModelPackage Instance = new VariableModelPackage();

  public static final MetaModel MODEL = new MetaModelBuilder().name("Variable").domain("org.sheepy.lily.core.model").addImports(List.of("org.sheepy.lily.core.model.Types", "org.sheepy.lily.core.model.Action")).genNamePackage(true).lmPackage(Instance).addGroups(VariableModelDefinition.Groups.ALL).addEnums(VariableModelDefinition.Enums.ALL).addUnits(VariableModelDefinition.Units.ALL).addAliases(VariableModelDefinition.Aliases.ALL).addJavaWrappers(VariableModelDefinition.JavaWrappers.ALL).build();

  private VariableModelPackage() {
  }

  @Override
  public MetaModel model() {
    return MODEL;
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T extends LMObject> Optional<IFeaturedObject.Builder<T>> builder(Group<T> group) {
    if (group == VariableModelDefinition.Groups.CHAIN_VARIABLE_RESOLVER) return Optional.of((IFeaturedObject.Builder<T>) ChainVariableResolver.builder());
    else if (group == VariableModelDefinition.Groups.CHAIN_RESOLVER) return Optional.of((IFeaturedObject.Builder<T>) ChainResolver.builder());
    else if (group == VariableModelDefinition.Groups.DIRECT_VARIABLE_RESOLVER) return Optional.of((IFeaturedObject.Builder<T>) DirectVariableResolver.builder());
    else if (group == VariableModelDefinition.Groups.BOOLEAN_CHANGE_ACTION) return Optional.of((IFeaturedObject.Builder<T>) BooleanChangeAction.builder());
    else if (group == VariableModelDefinition.Groups.INT_CHANGE_ACTION) return Optional.of((IFeaturedObject.Builder<T>) IntChangeAction.builder());
    else if (group == VariableModelDefinition.Groups.VAR_CHANGE_ACTION_PKG) return Optional.of((IFeaturedObject.Builder<T>) VarChangeActionPkg.builder());
    else if (group == VariableModelDefinition.Groups.MODEL_VARIABLE_PKG) return Optional.of((IFeaturedObject.Builder<T>) ModelVariablePkg.builder());
    else if (group == VariableModelDefinition.Groups.INT_VARIABLE) return Optional.of((IFeaturedObject.Builder<T>) IntVariable.builder());
    else if (group == VariableModelDefinition.Groups.FLOAT_VARIABLE) return Optional.of((IFeaturedObject.Builder<T>) FloatVariable.builder());
    else if (group == VariableModelDefinition.Groups.VECTOR3F_VARIABLE) return Optional.of((IFeaturedObject.Builder<T>) Vector3fVariable.builder());
    else if (group == VariableModelDefinition.Groups.DURATION_VARIABLE) return Optional.of((IFeaturedObject.Builder<T>) DurationVariable.builder());
    else if (group == VariableModelDefinition.Groups.SET_VARIABLE_ACTION) return Optional.of((IFeaturedObject.Builder<T>) SetVariableAction.builder());
    return Optional.empty();
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T> Optional<T> resolveEnumLiteral(Enum<T> enum_, String value) {
    return Optional.empty();
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T> Optional<IJavaWrapperConverter<T>> resolveJavaWrapperConverter(
      JavaWrapper<T> wrapper) {
    return Optional.empty();
  }
}
