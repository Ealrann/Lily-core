package org.sheepy.lily.core.model.maintainer;

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

public final class MaintainerModelPackage implements IModelPackage {
  public static final MaintainerModelPackage Instance = new MaintainerModelPackage();

  public static final MetaModel MODEL = new MetaModelBuilder().name("Maintainer").domain("org.sheepy.lily.core.model").genNamePackage(true).lmPackage(Instance).addGroups(MaintainerModelDefinition.Groups.ALL).addEnums(MaintainerModelDefinition.Enums.ALL).addUnits(MaintainerModelDefinition.Units.ALL).addAliases(MaintainerModelDefinition.Aliases.ALL).addJavaWrappers(MaintainerModelDefinition.JavaWrappers.ALL).build();

  private MaintainerModelPackage() {
  }

  @Override
  public MetaModel model() {
    return MODEL;
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T extends LMObject> Optional<IFeaturedObject.Builder<T>> builder(Group<T> group) {
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
