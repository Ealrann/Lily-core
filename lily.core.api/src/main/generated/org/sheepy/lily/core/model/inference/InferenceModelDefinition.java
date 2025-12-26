package org.sheepy.lily.core.model.inference;

import java.util.List;
import org.logoce.lmf.core.api.model.BuilderSupplier;
import org.logoce.lmf.core.lang.Alias;
import org.logoce.lmf.core.lang.BoundType;
import org.logoce.lmf.core.lang.Enum;
import org.logoce.lmf.core.lang.Generic;
import org.logoce.lmf.core.lang.Group;
import org.logoce.lmf.core.lang.JavaWrapper;
import org.logoce.lmf.core.lang.Unit;
import org.logoce.lmf.core.lang.builder.GenericBuilder;
import org.logoce.lmf.core.lang.builder.GenericExtensionBuilder;
import org.logoce.lmf.core.lang.builder.GroupBuilder;
import org.logoce.lmf.core.lang.builder.IncludeBuilder;
import org.logoce.lmf.core.lang.builder.JavaWrapperBuilder;
import org.sheepy.lily.core.model.inference.builder.LRuleBuilder;
import org.sheepy.lily.core.model.types.Parameter;
import org.sheepy.lily.core.model.types.TypesModelDefinition;

public interface InferenceModelDefinition {
  interface Generics {
    interface PARAMETERED_NOTIFICATION {
      Generic<? extends Parameter> T = new GenericBuilder<Parameter>().name("T").extension(() -> new GenericExtensionBuilder().type(() -> TypesModelDefinition.Groups.PARAMETER).boundType(BoundType.Extends).build()).build();
      List<Generic<?>> ALL = List.of(T);
    }

    interface CONDITION {
      Generic<? extends Parameter> T = new GenericBuilder<Parameter>().name("T").extension(() -> new GenericExtensionBuilder().type(() -> TypesModelDefinition.Groups.PARAMETER).boundType(BoundType.Extends).build()).build();
      List<Generic<?>> ALL = List.of(T);
    }
  }

  interface Groups {
    Group<IInferenceObject> I_INFERENCE_OBJECT = new GroupBuilder<IInferenceObject>().name("IInferenceObject").addFeatures(IInferenceObject.Features.ALL).build();
    Group<Inferer> INFERER = new GroupBuilder<Inferer>().name("Inferer").addInclude(() -> new IncludeBuilder<IInferenceObject>().group(() -> I_INFERENCE_OBJECT).build()).addFeatures(Inferer.Features.ALL).build();
    Group<Sensor> SENSOR = new GroupBuilder<Sensor>().name("Sensor").addInclude(() -> new IncludeBuilder<IInferenceObject>().group(() -> I_INFERENCE_OBJECT).build()).addFeatures(Sensor.Features.ALL).build();
    Group<AbstractNotification> ABSTRACT_NOTIFICATION = new GroupBuilder<AbstractNotification>().name("AbstractNotification").addFeatures(AbstractNotification.Features.ALL).build();
    Group<LNotification> L_NOTIFICATION = new GroupBuilder<LNotification>().name("LNotification").addInclude(() -> new IncludeBuilder<AbstractNotification>().group(() -> ABSTRACT_NOTIFICATION).build()).addFeatures(LNotification.Features.ALL).build();
    Group<ParameteredNotification<?>> PARAMETERED_NOTIFICATION = new GroupBuilder<ParameteredNotification<?>>().name("ParameteredNotification").addInclude(() -> new IncludeBuilder<AbstractNotification>().group(() -> ABSTRACT_NOTIFICATION).build()).addFeatures(ParameteredNotification.Features.ALL).addGenerics(Generics.PARAMETERED_NOTIFICATION.ALL).build();
    Group<Condition<?>> CONDITION = new GroupBuilder<Condition<?>>().name("Condition").addFeatures(Condition.Features.ALL).addGenerics(Generics.CONDITION.ALL).build();
    Group<LRule> L_RULE = new GroupBuilder<LRule>().name("LRule").concrete(true).addFeatures(LRule.Features.ALL).lmBuilder(new BuilderSupplier<>(LRuleBuilder::new)).build();
    List<Group<?>> ALL = List.of(I_INFERENCE_OBJECT, INFERER, SENSOR, ABSTRACT_NOTIFICATION, L_NOTIFICATION, PARAMETERED_NOTIFICATION, CONDITION, L_RULE);
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
    JavaWrapper<Class<?>> JAVA_CLASS = new JavaWrapperBuilder<Class<?>>().name("JavaClass").qualifiedClassName("java.lang.Class").build();
    List<JavaWrapper<?>> ALL = List.of(JAVA_CLASS);
  }
}
