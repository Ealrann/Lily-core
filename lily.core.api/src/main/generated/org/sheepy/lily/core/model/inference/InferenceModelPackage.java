package org.sheepy.lily.core.model.inference;

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

public final class InferenceModelPackage implements IModelPackage {
  public static final InferenceModelPackage Instance = new InferenceModelPackage();

  public static final MetaModel MODEL = new MetaModelBuilder().name("Inference").domain("org.sheepy.lily.core.model").addImports(List.of("org.sheepy.lily.core.model.Types", "org.sheepy.lily.core.model.Action")).genNamePackage(true).lmPackage(Instance).addGroups(InferenceModelDefinition.Groups.ALL).addEnums(InferenceModelDefinition.Enums.ALL).addUnits(InferenceModelDefinition.Units.ALL).addAliases(InferenceModelDefinition.Aliases.ALL).addJavaWrappers(InferenceModelDefinition.JavaWrappers.ALL).build();

  private InferenceModelPackage() {
  }

  @Override
  public MetaModel model() {
    return MODEL;
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T extends LMObject> Optional<IFeaturedObject.Builder<T>> builder(Group<T> group) {
    if (group == InferenceModelDefinition.Groups.L_RULE) return Optional.of((IFeaturedObject.Builder<T>) LRule.builder());
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
