package org.sheepy.lily.core.model.cadence;

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

public final class CadenceModelPackage implements IModelPackage {
  public static final CadenceModelPackage Instance = new CadenceModelPackage();

  public static final MetaModel MODEL = new MetaModelBuilder().name("Cadence").domain("org.sheepy.lily.core.model").addImports(List.of("org.sheepy.lily.core.model.Application", "org.sheepy.lily.core.model.Types")).genNamePackage(true).lmPackage(Instance).addGroups(CadenceModelDefinition.Groups.ALL).addEnums(CadenceModelDefinition.Enums.ALL).addUnits(CadenceModelDefinition.Units.ALL).addAliases(CadenceModelDefinition.Aliases.ALL).addJavaWrappers(CadenceModelDefinition.JavaWrappers.ALL).build();

  private CadenceModelPackage() {
  }

  @Override
  public MetaModel model() {
    return MODEL;
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T extends LMObject> Optional<IFeaturedObject.Builder<T>> builder(Group<T> group) {
    if (group == CadenceModelDefinition.Groups.CADENCE) return Optional.of((IFeaturedObject.Builder<T>) Cadence.builder());
    else if (group == CadenceModelDefinition.Groups.EXECUTE_WHILE) return Optional.of((IFeaturedObject.Builder<T>) ExecuteWhile.builder());
    else if (group == CadenceModelDefinition.Groups.EXECUTE_IF) return Optional.of((IFeaturedObject.Builder<T>) ExecuteIf.builder());
    else if (group == CadenceModelDefinition.Groups.PRINTUPS) return Optional.of((IFeaturedObject.Builder<T>) PrintUPS.builder());
    else if (group == CadenceModelDefinition.Groups.HAVE_TIME) return Optional.of((IFeaturedObject.Builder<T>) HaveTime.builder());
    else if (group == CadenceModelDefinition.Groups.COUNT_UNTIL) return Optional.of((IFeaturedObject.Builder<T>) CountUntil.builder());
    else if (group == CadenceModelDefinition.Groups.CLOSE_APPLICATION) return Optional.of((IFeaturedObject.Builder<T>) CloseApplication.builder());
    else if (group == CadenceModelDefinition.Groups.GENERIC_CADENCE) return Optional.of((IFeaturedObject.Builder<T>) GenericCadence.builder());
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
