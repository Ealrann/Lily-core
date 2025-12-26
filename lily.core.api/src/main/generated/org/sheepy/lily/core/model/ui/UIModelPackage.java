package org.sheepy.lily.core.model.ui;

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

public final class UIModelPackage implements IModelPackage {
  public static final UIModelPackage Instance = new UIModelPackage();

  public static final MetaModel MODEL = new MetaModelBuilder().name("UI").domain("org.sheepy.lily.core.model").addImports(List.of("org.sheepy.lily.core.model.Types", "org.sheepy.lily.core.model.Resource", "org.sheepy.lily.core.model.Application", "org.sheepy.lily.core.model.Inference", "org.sheepy.lily.core.model.Variable", "org.sheepy.lily.core.model.Action", "org.sheepy.lily.core.model.Presentation")).genNamePackage(true).lmPackage(Instance).addGroups(UIModelDefinition.Groups.ALL).addEnums(UIModelDefinition.Enums.ALL).addUnits(UIModelDefinition.Units.ALL).addAliases(UIModelDefinition.Aliases.ALL).addJavaWrappers(UIModelDefinition.JavaWrappers.ALL).build();

  private UIModelPackage() {
  }

  @Override
  public MetaModel model() {
    return MODEL;
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T extends LMObject> Optional<IFeaturedObject.Builder<T>> builder(Group<T> group) {
    if (group == UIModelDefinition.Groups.PANEL) return Optional.of((IFeaturedObject.Builder<T>) Panel.builder());
    else if (group == UIModelDefinition.Groups.UI) return Optional.of((IFeaturedObject.Builder<T>) UI.builder());
    else if (group == UIModelDefinition.Groups.UI_PAGE) return Optional.of((IFeaturedObject.Builder<T>) UIPage.builder());
    else if (group == UIModelDefinition.Groups.DYNAMIC_ROW_LAYOUT) return Optional.of((IFeaturedObject.Builder<T>) DynamicRowLayout.builder());
    else if (group == UIModelDefinition.Groups.VARIABLE_LABEL) return Optional.of((IFeaturedObject.Builder<T>) VariableLabel.builder());
    else if (group == UIModelDefinition.Groups.LABEL) return Optional.of((IFeaturedObject.Builder<T>) Label.builder());
    else if (group == UIModelDefinition.Groups.SLIDER) return Optional.of((IFeaturedObject.Builder<T>) Slider.builder());
    else if (group == UIModelDefinition.Groups.TEXT_FIELD) return Optional.of((IFeaturedObject.Builder<T>) TextField.builder());
    else if (group == UIModelDefinition.Groups.BUTTON) return Optional.of((IFeaturedObject.Builder<T>) Button.builder());
    else if (group == UIModelDefinition.Groups.BOOLEAN_BUTTON) return Optional.of((IFeaturedObject.Builder<T>) BooleanButton.builder());
    else if (group == UIModelDefinition.Groups.BOOLEAN_ACTION_BUTTON) return Optional.of((IFeaturedObject.Builder<T>) BooleanActionButton.builder());
    else if (group == UIModelDefinition.Groups.FONT_PKG) return Optional.of((IFeaturedObject.Builder<T>) FontPkg.builder());
    else if (group == UIModelDefinition.Groups.FONT_TABLE) return Optional.of((IFeaturedObject.Builder<T>) FontTable.builder());
    else if (group == UIModelDefinition.Groups.FONT) return Optional.of((IFeaturedObject.Builder<T>) Font.builder());
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
