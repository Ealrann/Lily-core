package org.sheepy.lily.core.model.presentation;

import java.util.List;
import org.logoce.lmf.core.api.model.BuilderSupplier;
import org.logoce.lmf.core.lang.Alias;
import org.logoce.lmf.core.lang.Enum;
import org.logoce.lmf.core.lang.Group;
import org.logoce.lmf.core.lang.JavaWrapper;
import org.logoce.lmf.core.lang.Unit;
import org.logoce.lmf.core.lang.builder.GroupBuilder;
import org.logoce.lmf.core.lang.builder.IncludeBuilder;
import org.sheepy.lily.core.model.presentation.builder.PresentationsBuilder;
import org.sheepy.lily.core.model.types.LNamedElement;
import org.sheepy.lily.core.model.types.TypesModelDefinition;

public interface PresentationModelDefinition {
  interface Generics {
  }

  interface Groups {
    Group<IPositionElement> I_POSITION_ELEMENT = new GroupBuilder<IPositionElement>().name("IPositionElement").addFeatures(IPositionElement.Features.ALL).build();
    Group<ISizedElement> I_SIZED_ELEMENT = new GroupBuilder<ISizedElement>().name("ISizedElement").addInclude(() -> new IncludeBuilder<IPositionElement>().group(() -> I_POSITION_ELEMENT).build()).addFeatures(ISizedElement.Features.ALL).build();
    Group<IPresentationPkg> I_PRESENTATION_PKG = new GroupBuilder<IPresentationPkg>().name("IPresentationPkg").addInclude(() -> new IncludeBuilder<LNamedElement>().group(() -> TypesModelDefinition.Groups.L_NAMED_ELEMENT).build()).addFeatures(IPresentationPkg.Features.ALL).build();
    Group<Presentations> PRESENTATIONS = new GroupBuilder<Presentations>().name("Presentations").concrete(true).addFeatures(Presentations.Features.ALL).lmBuilder(new BuilderSupplier<>(PresentationsBuilder::new)).build();
    List<Group<?>> ALL = List.of(I_POSITION_ELEMENT, I_SIZED_ELEMENT, I_PRESENTATION_PKG, PRESENTATIONS);
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
