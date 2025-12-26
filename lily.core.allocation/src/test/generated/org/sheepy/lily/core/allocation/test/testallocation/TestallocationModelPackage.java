package org.sheepy.lily.core.allocation.test.testallocation;

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

public final class TestallocationModelPackage implements IModelPackage {
  public static final TestallocationModelPackage Instance = new TestallocationModelPackage();

  public static final MetaModel MODEL = new MetaModelBuilder().name("Testallocation").domain("org.sheepy.lily.core.allocation.test").genNamePackage(true).lmPackage(Instance).addGroups(TestallocationModelDefinition.Groups.ALL).addEnums(TestallocationModelDefinition.Enums.ALL).addUnits(TestallocationModelDefinition.Units.ALL).addAliases(TestallocationModelDefinition.Aliases.ALL).addJavaWrappers(TestallocationModelDefinition.JavaWrappers.ALL).build();

  private TestallocationModelPackage() {
  }

  @Override
  public MetaModel model() {
    return MODEL;
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T extends LMObject> Optional<IFeaturedObject.Builder<T>> builder(Group<T> group) {
    if (group == TestallocationModelDefinition.Groups.ROOT) return Optional.of((IFeaturedObject.Builder<T>) Root.builder());
    else if (group == TestallocationModelDefinition.Groups.NODE) return Optional.of((IFeaturedObject.Builder<T>) Node.builder());
    else if (group == TestallocationModelDefinition.Groups.CONTAINER) return Optional.of((IFeaturedObject.Builder<T>) Container.builder());
    else if (group == TestallocationModelDefinition.Groups.LEAF) return Optional.of((IFeaturedObject.Builder<T>) Leaf.builder());
    else if (group == TestallocationModelDefinition.Groups.BOX) return Optional.of((IFeaturedObject.Builder<T>) Box.builder());
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
