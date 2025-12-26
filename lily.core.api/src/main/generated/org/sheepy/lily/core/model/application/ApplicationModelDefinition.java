package org.sheepy.lily.core.model.application;

import java.util.List;
import org.logoce.lmf.core.api.model.BuilderSupplier;
import org.logoce.lmf.core.lang.Alias;
import org.logoce.lmf.core.lang.Enum;
import org.logoce.lmf.core.lang.Group;
import org.logoce.lmf.core.lang.JavaWrapper;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.Model;
import org.logoce.lmf.core.lang.Unit;
import org.logoce.lmf.core.lang.builder.GroupBuilder;
import org.logoce.lmf.core.lang.builder.IncludeBuilder;
import org.sheepy.lily.core.model.application.builder.ApplicationBuilder;
import org.sheepy.lily.core.model.application.builder.ApplicationExtensionPkgBuilder;
import org.sheepy.lily.core.model.application.builder.BackgroundImageBuilder;
import org.sheepy.lily.core.model.application.builder.CompositorExtensionPkgBuilder;
import org.sheepy.lily.core.model.application.builder.GenericScenePartBuilder;
import org.sheepy.lily.core.model.application.builder.SceneBuilder;
import org.sheepy.lily.core.model.application.builder.ScreenEffectBuilder;
import org.sheepy.lily.core.model.application.builder.SpecialEffectBuilder;
import org.sheepy.lily.core.model.application.builder.TimeConfigurationBuilder;
import org.sheepy.lily.core.model.inference.IInferenceObject;
import org.sheepy.lily.core.model.inference.InferenceModelDefinition;
import org.sheepy.lily.core.model.resource.IRootResource;
import org.sheepy.lily.core.model.resource.ResourceModelDefinition;
import org.sheepy.lily.core.model.types.LNamedElement;
import org.sheepy.lily.core.model.types.TypesModelDefinition;

public interface ApplicationModelDefinition {
  interface Generics {
  }

  interface Groups {
    Group<Application> APPLICATION = new GroupBuilder<Application>().name("Application").concrete(true).addInclude(() -> new IncludeBuilder<Model>().group(() -> LMCoreModelDefinition.Groups.MODEL).build()).addFeatures(Application.Features.ALL).lmBuilder(new BuilderSupplier<>(ApplicationBuilder::new)).build();
    Group<IApplicationExtension> I_APPLICATION_EXTENSION = new GroupBuilder<IApplicationExtension>().name("IApplicationExtension").addInclude(() -> new IncludeBuilder<LNamedElement>().group(() -> TypesModelDefinition.Groups.L_NAMED_ELEMENT).build()).addFeatures(IApplicationExtension.Features.ALL).build();
    Group<ApplicationExtensionPkg> APPLICATION_EXTENSION_PKG = new GroupBuilder<ApplicationExtensionPkg>().name("ApplicationExtensionPkg").concrete(true).addFeatures(ApplicationExtensionPkg.Features.ALL).lmBuilder(new BuilderSupplier<>(ApplicationExtensionPkgBuilder::new)).build();
    Group<TimeConfiguration> TIME_CONFIGURATION = new GroupBuilder<TimeConfiguration>().name("TimeConfiguration").concrete(true).addFeatures(TimeConfiguration.Features.ALL).lmBuilder(new BuilderSupplier<>(TimeConfigurationBuilder::new)).build();
    Group<IEngine> I_ENGINE = new GroupBuilder<IEngine>().name("IEngine").addFeatures(IEngine.Features.ALL).build();
    Group<IModel> I_MODEL = new GroupBuilder<IModel>().name("IModel").addFeatures(IModel.Features.ALL).build();
    Group<ICompositor> I_COMPOSITOR = new GroupBuilder<ICompositor>().name("ICompositor").addInclude(() -> new IncludeBuilder<IInferenceObject>().group(() -> InferenceModelDefinition.Groups.I_INFERENCE_OBJECT).build()).addFeatures(ICompositor.Features.ALL).build();
    Group<CompositorExtensionPkg> COMPOSITOR_EXTENSION_PKG = new GroupBuilder<CompositorExtensionPkg>().name("CompositorExtensionPkg").concrete(true).addFeatures(CompositorExtensionPkg.Features.ALL).lmBuilder(new BuilderSupplier<>(CompositorExtensionPkgBuilder::new)).build();
    Group<ICompositorExtension> I_COMPOSITOR_EXTENSION = new GroupBuilder<ICompositorExtension>().name("ICompositorExtension").addFeatures(ICompositorExtension.Features.ALL).build();
    Group<ICadence> I_CADENCE = new GroupBuilder<ICadence>().name("ICadence").addFeatures(ICadence.Features.ALL).build();
    Group<Scene> SCENE = new GroupBuilder<Scene>().name("Scene").concrete(true).addFeatures(Scene.Features.ALL).lmBuilder(new BuilderSupplier<>(SceneBuilder::new)).build();
    Group<GenericScenePart> GENERIC_SCENE_PART = new GroupBuilder<GenericScenePart>().name("GenericScenePart").concrete(true).addInclude(() -> new IncludeBuilder<ICompositor>().group(() -> I_COMPOSITOR).build()).addInclude(() -> new IncludeBuilder<LNamedElement>().group(() -> TypesModelDefinition.Groups.L_NAMED_ELEMENT).build()).addFeatures(GenericScenePart.Features.ALL).lmBuilder(new BuilderSupplier<>(GenericScenePartBuilder::new)).build();
    Group<BackgroundImage> BACKGROUND_IMAGE = new GroupBuilder<BackgroundImage>().name("BackgroundImage").concrete(true).addInclude(() -> new IncludeBuilder<LNamedElement>().group(() -> TypesModelDefinition.Groups.L_NAMED_ELEMENT).build()).addInclude(() -> new IncludeBuilder<ICompositor>().group(() -> I_COMPOSITOR).build()).addFeatures(BackgroundImage.Features.ALL).lmBuilder(new BuilderSupplier<>(BackgroundImageBuilder::new)).build();
    Group<ScreenEffect> SCREEN_EFFECT = new GroupBuilder<ScreenEffect>().name("ScreenEffect").concrete(true).addInclude(() -> new IncludeBuilder<LNamedElement>().group(() -> TypesModelDefinition.Groups.L_NAMED_ELEMENT).build()).addInclude(() -> new IncludeBuilder<ICompositor>().group(() -> I_COMPOSITOR).build()).addFeatures(ScreenEffect.Features.ALL).lmBuilder(new BuilderSupplier<>(ScreenEffectBuilder::new)).build();
    Group<SpecialEffect> SPECIAL_EFFECT = new GroupBuilder<SpecialEffect>().name("SpecialEffect").concrete(true).addInclude(() -> new IncludeBuilder<LNamedElement>().group(() -> TypesModelDefinition.Groups.L_NAMED_ELEMENT).build()).addInclude(() -> new IncludeBuilder<IRootResource>().group(() -> ResourceModelDefinition.Groups.I_ROOT_RESOURCE).build()).addFeatures(SpecialEffect.Features.ALL).lmBuilder(new BuilderSupplier<>(SpecialEffectBuilder::new)).build();
    List<Group<?>> ALL = List.of(APPLICATION, I_APPLICATION_EXTENSION, APPLICATION_EXTENSION_PKG, TIME_CONFIGURATION, I_ENGINE, I_MODEL, I_COMPOSITOR, COMPOSITOR_EXTENSION_PKG, I_COMPOSITOR_EXTENSION, I_CADENCE, SCENE, GENERIC_SCENE_PART, BACKGROUND_IMAGE, SCREEN_EFFECT, SPECIAL_EFFECT);
  }

  interface Units {
    List<Unit<?>> ALL = List.of();
  }

  interface Enums {
    List<Enum<?>> ALL = List.of();
  }

  interface Aliases {
    List<Alias> ALL = List.of();
  }

  interface JavaWrappers {
    List<JavaWrapper<?>> ALL = List.of();
  }
}
