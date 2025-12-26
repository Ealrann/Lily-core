package org.sheepy.lily.core.model.presentation;

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

public final class PresentationModelPackage implements IModelPackage {
  public static final PresentationModelPackage Instance = new PresentationModelPackage();

  public static final MetaModel MODEL = new MetaModelBuilder().name("Presentation").domain("org.sheepy.lily.core.model").addImports(List.of("org.sheepy.lily.core.model.Types")).genNamePackage(true).lmPackage(Instance).addGroups(PresentationModelDefinition.Groups.ALL).addEnums(PresentationModelDefinition.Enums.ALL).addUnits(PresentationModelDefinition.Units.ALL).addAliases(PresentationModelDefinition.Aliases.ALL).addJavaWrappers(PresentationModelDefinition.JavaWrappers.ALL).build();

  private PresentationModelPackage() {
  }

  @Override
  public MetaModel model() {
    return MODEL;
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T extends LMObject> Optional<IFeaturedObject.Builder<T>> builder(Group<T> group) {
    if (group == PresentationModelDefinition.Groups.PRESENTATIONS) return Optional.of((IFeaturedObject.Builder<T>) Presentations.builder());
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
