package org.sheepy.lily.core.model.action;

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
import org.sheepy.lily.core.model.action.builder.ActionListBuilder;
import org.sheepy.lily.core.model.action.builder.CloseApplicationActionBuilder;
import org.sheepy.lily.core.model.types.LNamedElement;
import org.sheepy.lily.core.model.types.TypesModelDefinition;

public interface ActionModelDefinition {
  interface Generics {
    interface ACTION_LIST {
      Generic<? extends Action> T = new GenericBuilder<Action>().name("T").extension(() -> new GenericExtensionBuilder().type(() -> ActionModelDefinition.Groups.ACTION).boundType(BoundType.Extends).build()).build();
      List<Generic<?>> ALL = List.of(T);
    }
  }

  interface Groups {
    Group<ActionList<?>> ACTION_LIST = new GroupBuilder<ActionList<?>>().name("ActionList").concrete(true).addFeatures(ActionList.Features.ALL).addGenerics(Generics.ACTION_LIST.ALL).lmBuilder(new BuilderSupplier<>(ActionListBuilder::new)).build();
    Group<Action> ACTION = new GroupBuilder<Action>().name("Action").addInclude(() -> new IncludeBuilder<LNamedElement>().group(() -> TypesModelDefinition.Groups.L_NAMED_ELEMENT).build()).addFeatures(Action.Features.ALL).build();
    Group<CloseApplicationAction> CLOSE_APPLICATION_ACTION = new GroupBuilder<CloseApplicationAction>().name("CloseApplicationAction").concrete(true).addInclude(() -> new IncludeBuilder<Action>().group(() -> ACTION).build()).addFeatures(CloseApplicationAction.Features.ALL).lmBuilder(new BuilderSupplier<>(CloseApplicationActionBuilder::new)).build();
    List<Group<?>> ALL = List.of(ACTION_LIST, ACTION, CLOSE_APPLICATION_ACTION);
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
    JavaWrapper<List<?>> JAVA_LIST = new JavaWrapperBuilder<List<?>>().name("JavaList").qualifiedClassName("java.util.List").build();
    List<JavaWrapper<?>> ALL = List.of(JAVA_LIST);
  }
}
