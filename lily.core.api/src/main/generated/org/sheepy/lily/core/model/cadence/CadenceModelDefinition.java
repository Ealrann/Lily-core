package org.sheepy.lily.core.model.cadence;

import java.util.List;
import org.logoce.lmf.core.api.model.BuilderSupplier;
import org.logoce.lmf.core.lang.Alias;
import org.logoce.lmf.core.lang.Enum;
import org.logoce.lmf.core.lang.Group;
import org.logoce.lmf.core.lang.JavaWrapper;
import org.logoce.lmf.core.lang.Unit;
import org.logoce.lmf.core.lang.builder.GroupBuilder;
import org.logoce.lmf.core.lang.builder.IncludeBuilder;
import org.sheepy.lily.core.model.application.ApplicationModelDefinition;
import org.sheepy.lily.core.model.application.ICadence;
import org.sheepy.lily.core.model.cadence.builder.CadenceBuilder;
import org.sheepy.lily.core.model.cadence.builder.CloseApplicationBuilder;
import org.sheepy.lily.core.model.cadence.builder.CountUntilBuilder;
import org.sheepy.lily.core.model.cadence.builder.ExecuteIfBuilder;
import org.sheepy.lily.core.model.cadence.builder.ExecuteWhileBuilder;
import org.sheepy.lily.core.model.cadence.builder.GenericCadenceBuilder;
import org.sheepy.lily.core.model.cadence.builder.HaveTimeBuilder;
import org.sheepy.lily.core.model.cadence.builder.PrintUPSBuilder;
import org.sheepy.lily.core.model.types.LNamedElement;
import org.sheepy.lily.core.model.types.TypesModelDefinition;

public interface CadenceModelDefinition {
  interface Generics {
  }

  interface Groups {
    Group<ICadenceTask> I_CADENCE_TASK = new GroupBuilder<ICadenceTask>().name("ICadenceTask").addFeatures(ICadenceTask.Features.ALL).build();
    Group<CadenceTaskPkg> CADENCE_TASK_PKG = new GroupBuilder<CadenceTaskPkg>().name("CadenceTaskPkg").addInclude(() -> new IncludeBuilder<ICadenceTask>().group(() -> I_CADENCE_TASK).build()).addFeatures(CadenceTaskPkg.Features.ALL).build();
    Group<Cadence> CADENCE = new GroupBuilder<Cadence>().name("Cadence").concrete(true).addInclude(() -> new IncludeBuilder<CadenceTaskPkg>().group(() -> CADENCE_TASK_PKG).build()).addInclude(() -> new IncludeBuilder<ICadence>().group(() -> ApplicationModelDefinition.Groups.I_CADENCE).build()).addFeatures(Cadence.Features.ALL).lmBuilder(new BuilderSupplier<>(CadenceBuilder::new)).build();
    Group<ExecuteWhile> EXECUTE_WHILE = new GroupBuilder<ExecuteWhile>().name("ExecuteWhile").concrete(true).addInclude(() -> new IncludeBuilder<CadenceTaskPkg>().group(() -> CADENCE_TASK_PKG).build()).addFeatures(ExecuteWhile.Features.ALL).lmBuilder(new BuilderSupplier<>(ExecuteWhileBuilder::new)).build();
    Group<ExecuteIf> EXECUTE_IF = new GroupBuilder<ExecuteIf>().name("ExecuteIf").concrete(true).addInclude(() -> new IncludeBuilder<CadenceTaskPkg>().group(() -> CADENCE_TASK_PKG).build()).addFeatures(ExecuteIf.Features.ALL).lmBuilder(new BuilderSupplier<>(ExecuteIfBuilder::new)).build();
    Group<PrintUPS> PRINTUPS = new GroupBuilder<PrintUPS>().name("PrintUPS").concrete(true).addInclude(() -> new IncludeBuilder<ICadenceTask>().group(() -> I_CADENCE_TASK).build()).addFeatures(PrintUPS.Features.ALL).lmBuilder(new BuilderSupplier<>(PrintUPSBuilder::new)).build();
    Group<ICadenceCondition> I_CADENCE_CONDITION = new GroupBuilder<ICadenceCondition>().name("ICadenceCondition").addFeatures(ICadenceCondition.Features.ALL).build();
    Group<HaveTime> HAVE_TIME = new GroupBuilder<HaveTime>().name("HaveTime").concrete(true).addInclude(() -> new IncludeBuilder<ICadenceCondition>().group(() -> I_CADENCE_CONDITION).build()).addFeatures(HaveTime.Features.ALL).lmBuilder(new BuilderSupplier<>(HaveTimeBuilder::new)).build();
    Group<CountUntil> COUNT_UNTIL = new GroupBuilder<CountUntil>().name("CountUntil").concrete(true).addInclude(() -> new IncludeBuilder<ICadenceCondition>().group(() -> I_CADENCE_CONDITION).build()).addFeatures(CountUntil.Features.ALL).lmBuilder(new BuilderSupplier<>(CountUntilBuilder::new)).build();
    Group<CloseApplication> CLOSE_APPLICATION = new GroupBuilder<CloseApplication>().name("CloseApplication").concrete(true).addInclude(() -> new IncludeBuilder<ICadenceTask>().group(() -> I_CADENCE_TASK).build()).addFeatures(CloseApplication.Features.ALL).lmBuilder(new BuilderSupplier<>(CloseApplicationBuilder::new)).build();
    Group<GenericCadence> GENERIC_CADENCE = new GroupBuilder<GenericCadence>().name("GenericCadence").concrete(true).addInclude(() -> new IncludeBuilder<ICadence>().group(() -> ApplicationModelDefinition.Groups.I_CADENCE).build()).addInclude(() -> new IncludeBuilder<LNamedElement>().group(() -> TypesModelDefinition.Groups.L_NAMED_ELEMENT).build()).addFeatures(GenericCadence.Features.ALL).lmBuilder(new BuilderSupplier<>(GenericCadenceBuilder::new)).build();
    List<Group<?>> ALL = List.of(I_CADENCE_TASK, CADENCE_TASK_PKG, CADENCE, EXECUTE_WHILE, EXECUTE_IF, PRINTUPS, I_CADENCE_CONDITION, HAVE_TIME, COUNT_UNTIL, CLOSE_APPLICATION, GENERIC_CADENCE);
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
