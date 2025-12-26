package org.sheepy.lily.core.model.resource;

import java.util.List;
import org.logoce.lmf.core.api.model.BuilderSupplier;
import org.logoce.lmf.core.lang.Alias;
import org.logoce.lmf.core.lang.Enum;
import org.logoce.lmf.core.lang.Group;
import org.logoce.lmf.core.lang.JavaWrapper;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.Unit;
import org.logoce.lmf.core.lang.builder.EnumAttributeBuilder;
import org.logoce.lmf.core.lang.builder.EnumBuilder;
import org.logoce.lmf.core.lang.builder.GroupBuilder;
import org.logoce.lmf.core.lang.builder.IncludeBuilder;
import org.sheepy.lily.core.model.resource.builder.FileImageBuilder;
import org.sheepy.lily.core.model.resource.builder.FileResourceBuilder;
import org.sheepy.lily.core.model.resource.builder.LocalResourceBuilder;
import org.sheepy.lily.core.model.resource.builder.ModuleResourceBuilder;
import org.sheepy.lily.core.model.resource.builder.MusicBuilder;
import org.sheepy.lily.core.model.resource.builder.ResourcePkgBuilder;
import org.sheepy.lily.core.model.resource.builder.SoundBuilder;
import org.sheepy.lily.core.model.resource.builder.SoundContinuousBuilder;
import org.sheepy.lily.core.model.resource.builder.StringModuleResourceBuilder;
import org.sheepy.lily.core.model.types.LNamedElement;
import org.sheepy.lily.core.model.types.TypesModelDefinition;

public interface ResourceModelDefinition {
  interface Generics {
  }

  interface Groups {
    Group<IRootResource> I_ROOT_RESOURCE = new GroupBuilder<IRootResource>().name("IRootResource").addInclude(() -> new IncludeBuilder<LNamedElement>().group(() -> TypesModelDefinition.Groups.L_NAMED_ELEMENT).build()).addFeatures(IRootResource.Features.ALL).build();
    Group<IImage> I_IMAGE = new GroupBuilder<IImage>().name("IImage").addInclude(() -> new IncludeBuilder<LNamedElement>().group(() -> TypesModelDefinition.Groups.L_NAMED_ELEMENT).build()).addFeatures(IImage.Features.ALL).build();
    Group<ResourcePkg> RESOURCE_PKG = new GroupBuilder<ResourcePkg>().name("ResourcePkg").concrete(true).addFeatures(ResourcePkg.Features.ALL).lmBuilder(new BuilderSupplier<>(ResourcePkgBuilder::new)).build();
    Group<FileResource> FILE_RESOURCE = new GroupBuilder<FileResource>().name("FileResource").concrete(true).addInclude(() -> new IncludeBuilder<IRootResource>().group(() -> I_ROOT_RESOURCE).build()).addFeatures(FileResource.Features.ALL).lmBuilder(new BuilderSupplier<>(FileResourceBuilder::new)).build();
    Group<LocalResource> LOCAL_RESOURCE = new GroupBuilder<LocalResource>().name("LocalResource").concrete(true).addInclude(() -> new IncludeBuilder<FileResource>().group(() -> FILE_RESOURCE).build()).addFeatures(LocalResource.Features.ALL).lmBuilder(new BuilderSupplier<>(LocalResourceBuilder::new)).build();
    Group<AbstractModuleResource> ABSTRACT_MODULE_RESOURCE = new GroupBuilder<AbstractModuleResource>().name("AbstractModuleResource").addInclude(() -> new IncludeBuilder<FileResource>().group(() -> FILE_RESOURCE).build()).addFeatures(AbstractModuleResource.Features.ALL).build();
    Group<ModuleResource> MODULE_RESOURCE = new GroupBuilder<ModuleResource>().name("ModuleResource").concrete(true).addInclude(() -> new IncludeBuilder<AbstractModuleResource>().group(() -> ABSTRACT_MODULE_RESOURCE).build()).addFeatures(ModuleResource.Features.ALL).lmBuilder(new BuilderSupplier<>(ModuleResourceBuilder::new)).build();
    Group<StringModuleResource> STRING_MODULE_RESOURCE = new GroupBuilder<StringModuleResource>().name("StringModuleResource").concrete(true).addInclude(() -> new IncludeBuilder<AbstractModuleResource>().group(() -> ABSTRACT_MODULE_RESOURCE).build()).addFeatures(StringModuleResource.Features.ALL).lmBuilder(new BuilderSupplier<>(StringModuleResourceBuilder::new)).build();
    Group<Sound> SOUND = new GroupBuilder<Sound>().name("Sound").concrete(true).addInclude(() -> new IncludeBuilder<IRootResource>().group(() -> I_ROOT_RESOURCE).build()).addFeatures(Sound.Features.ALL).lmBuilder(new BuilderSupplier<>(SoundBuilder::new)).build();
    Group<Music> MUSIC = new GroupBuilder<Music>().name("Music").concrete(true).addInclude(() -> new IncludeBuilder<IRootResource>().group(() -> I_ROOT_RESOURCE).build()).addFeatures(Music.Features.ALL).lmBuilder(new BuilderSupplier<>(MusicBuilder::new)).build();
    Group<SoundContinuous> SOUND_CONTINUOUS = new GroupBuilder<SoundContinuous>().name("SoundContinuous").concrete(true).addInclude(() -> new IncludeBuilder<Sound>().group(() -> SOUND).build()).addFeatures(SoundContinuous.Features.ALL).lmBuilder(new BuilderSupplier<>(SoundContinuousBuilder::new)).build();
    Group<FileImage> FILE_IMAGE = new GroupBuilder<FileImage>().name("FileImage").concrete(true).addInclude(() -> new IncludeBuilder<IRootResource>().group(() -> I_ROOT_RESOURCE).build()).addInclude(() -> new IncludeBuilder<IImage>().group(() -> I_IMAGE).build()).addFeatures(FileImage.Features.ALL).lmBuilder(new BuilderSupplier<>(FileImageBuilder::new)).build();
    List<Group<?>> ALL = List.of(I_ROOT_RESOURCE, I_IMAGE, RESOURCE_PKG, FILE_RESOURCE, LOCAL_RESOURCE, ABSTRACT_MODULE_RESOURCE, MODULE_RESOURCE, STRING_MODULE_RESOURCE, SOUND, MUSIC, SOUND_CONTINUOUS, FILE_IMAGE);
  }

  interface Units {
    List<Unit<?>> ALL = List.of();
  }

  interface Enums {
    Enum<ESampling> E_SAMPLING = new EnumBuilder<ESampling>().name("ESampling").addLiterals(List.of("Linear", "0", "Nearest", "1")).addAttribute(() -> new EnumAttributeBuilder().name("value").unit(() -> LMCoreModelDefinition.Units.INT).build()).build();
    List<Enum<?>> ALL = List.of(E_SAMPLING);
  }

  interface Aliases {
    List<Alias> ALL = List.of();
  }

  interface JavaWrappers {
    List<JavaWrapper<?>> ALL = List.of();
  }
}
