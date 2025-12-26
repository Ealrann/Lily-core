package org.sheepy.lily.core.model.application;

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

public final class ApplicationModelPackage implements IModelPackage {
  public static final ApplicationModelPackage Instance = new ApplicationModelPackage();

  public static final MetaModel MODEL = new MetaModelBuilder().name("Application").domain("org.sheepy.lily.core.model").addImports(List.of("org.sheepy.lily.core.model.Types", "org.sheepy.lily.core.model.Resource", "org.sheepy.lily.core.model.Inference", "org.sheepy.lily.core.model.Variable")).genNamePackage(true).lmPackage(Instance).addGroups(ApplicationModelDefinition.Groups.ALL).addEnums(ApplicationModelDefinition.Enums.ALL).addUnits(ApplicationModelDefinition.Units.ALL).addAliases(ApplicationModelDefinition.Aliases.ALL).addJavaWrappers(ApplicationModelDefinition.JavaWrappers.ALL).build();

  private ApplicationModelPackage() {
  }

  @Override
  public MetaModel model() {
    return MODEL;
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T extends LMObject> Optional<IFeaturedObject.Builder<T>> builder(Group<T> group) {
    if (group == ApplicationModelDefinition.Groups.APPLICATION) return Optional.of((IFeaturedObject.Builder<T>) Application.builder());
    else if (group == ApplicationModelDefinition.Groups.APPLICATION_EXTENSION_PKG) return Optional.of((IFeaturedObject.Builder<T>) ApplicationExtensionPkg.builder());
    else if (group == ApplicationModelDefinition.Groups.TIME_CONFIGURATION) return Optional.of((IFeaturedObject.Builder<T>) TimeConfiguration.builder());
    else if (group == ApplicationModelDefinition.Groups.COMPOSITOR_EXTENSION_PKG) return Optional.of((IFeaturedObject.Builder<T>) CompositorExtensionPkg.builder());
    else if (group == ApplicationModelDefinition.Groups.SCENE) return Optional.of((IFeaturedObject.Builder<T>) Scene.builder());
    else if (group == ApplicationModelDefinition.Groups.GENERIC_SCENE_PART) return Optional.of((IFeaturedObject.Builder<T>) GenericScenePart.builder());
    else if (group == ApplicationModelDefinition.Groups.BACKGROUND_IMAGE) return Optional.of((IFeaturedObject.Builder<T>) BackgroundImage.builder());
    else if (group == ApplicationModelDefinition.Groups.SCREEN_EFFECT) return Optional.of((IFeaturedObject.Builder<T>) ScreenEffect.builder());
    else if (group == ApplicationModelDefinition.Groups.SPECIAL_EFFECT) return Optional.of((IFeaturedObject.Builder<T>) SpecialEffect.builder());
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
