package org.sheepy.lily.core.model.maintainer;

import java.util.List;
import org.logoce.lmf.core.lang.Alias;
import org.logoce.lmf.core.lang.BoundType;
import org.logoce.lmf.core.lang.Enum;
import org.logoce.lmf.core.lang.Generic;
import org.logoce.lmf.core.lang.Group;
import org.logoce.lmf.core.lang.JavaWrapper;
import org.logoce.lmf.core.lang.Unit;
import org.logoce.lmf.core.lang.builder.GenericBuilder;
import org.logoce.lmf.core.lang.builder.GenericExtensionBuilder;
import org.logoce.lmf.core.lang.builder.GenericParameterBuilder;
import org.logoce.lmf.core.lang.builder.GroupBuilder;

public interface MaintainerModelDefinition {
  interface Generics {
    interface MAINTAINABLE {
      Generic<? extends Maintainable<?>> T = new GenericBuilder<Maintainable<?>>().name("T").extension(() -> new GenericExtensionBuilder().type(() -> MaintainerModelDefinition.Groups.MAINTAINABLE).addParameter(() -> new GenericParameterBuilder().type(() -> MaintainerModelDefinition.Generics.MAINTAINABLE.T).build()).boundType(BoundType.Extends).build()).build();
      List<Generic<?>> ALL = List.of(T);
    }

    interface MAINTAINER {
      Generic<? extends Maintainable<?>> T = new GenericBuilder<Maintainable<?>>().name("T").extension(() -> new GenericExtensionBuilder().type(() -> MaintainerModelDefinition.Groups.MAINTAINABLE).addParameter(() -> new GenericParameterBuilder().type(() -> MaintainerModelDefinition.Generics.MAINTAINER.T).build()).boundType(BoundType.Extends).build()).build();
      List<Generic<?>> ALL = List.of(T);
    }
  }

  interface Groups {
    Group<Maintainable<?>> MAINTAINABLE = new GroupBuilder<Maintainable<?>>().name("Maintainable").addFeatures(Maintainable.Features.ALL).addGenerics(Generics.MAINTAINABLE.ALL).build();
    Group<Maintainer<?>> MAINTAINER = new GroupBuilder<Maintainer<?>>().name("Maintainer").addFeatures(Maintainer.Features.ALL).addGenerics(Generics.MAINTAINER.ALL).build();
    List<Group<?>> ALL = List.of(MAINTAINABLE, MAINTAINER);
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
