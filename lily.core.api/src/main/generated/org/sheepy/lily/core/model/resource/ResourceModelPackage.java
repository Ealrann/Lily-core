package org.sheepy.lily.core.model.resource;

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

public final class ResourceModelPackage implements IModelPackage {
  public static final ResourceModelPackage Instance = new ResourceModelPackage();

  public static final MetaModel MODEL = new MetaModelBuilder().name("Resource").domain("org.sheepy.lily.core.model").addImports(List.of("org.sheepy.lily.core.model.Types")).genNamePackage(true).lmPackage(Instance).addGroups(ResourceModelDefinition.Groups.ALL).addEnums(ResourceModelDefinition.Enums.ALL).addUnits(ResourceModelDefinition.Units.ALL).addAliases(ResourceModelDefinition.Aliases.ALL).addJavaWrappers(ResourceModelDefinition.JavaWrappers.ALL).build();

  private ResourceModelPackage() {
  }

  @Override
  public MetaModel model() {
    return MODEL;
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T extends LMObject> Optional<IFeaturedObject.Builder<T>> builder(Group<T> group) {
    if (group == ResourceModelDefinition.Groups.RESOURCE_PKG) return Optional.of((IFeaturedObject.Builder<T>) ResourcePkg.builder());
    else if (group == ResourceModelDefinition.Groups.FILE_RESOURCE) return Optional.of((IFeaturedObject.Builder<T>) FileResource.builder());
    else if (group == ResourceModelDefinition.Groups.LOCAL_RESOURCE) return Optional.of((IFeaturedObject.Builder<T>) LocalResource.builder());
    else if (group == ResourceModelDefinition.Groups.MODULE_RESOURCE) return Optional.of((IFeaturedObject.Builder<T>) ModuleResource.builder());
    else if (group == ResourceModelDefinition.Groups.STRING_MODULE_RESOURCE) return Optional.of((IFeaturedObject.Builder<T>) StringModuleResource.builder());
    else if (group == ResourceModelDefinition.Groups.SOUND) return Optional.of((IFeaturedObject.Builder<T>) Sound.builder());
    else if (group == ResourceModelDefinition.Groups.MUSIC) return Optional.of((IFeaturedObject.Builder<T>) Music.builder());
    else if (group == ResourceModelDefinition.Groups.SOUND_CONTINUOUS) return Optional.of((IFeaturedObject.Builder<T>) SoundContinuous.builder());
    else if (group == ResourceModelDefinition.Groups.FILE_IMAGE) return Optional.of((IFeaturedObject.Builder<T>) FileImage.builder());
    return Optional.empty();
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T> Optional<T> resolveEnumLiteral(Enum<T> enum_, String value) {
    if (enum_ == ResourceModelDefinition.Enums.E_SAMPLING) return (Optional<T>) Optional.of(ESampling.valueOf(value));
    return Optional.empty();
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T> Optional<IJavaWrapperConverter<T>> resolveJavaWrapperConverter(
      JavaWrapper<T> wrapper) {
    return Optional.empty();
  }
}
