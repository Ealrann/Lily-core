package org.sheepy.lily.core.model.maintainer;

import java.util.List;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.GenericParameterBuilder;
import org.logoce.lmf.core.lang.builder.RelationBuilder;

public interface Maintainable<T extends Maintainable<T>> extends LMObject {
  @Override
  IModelNotifier<? extends Features<?>> notifier();
  Maintainer<T> maintainer();
  void maintainer(final Maintainer<T> maintainer);

  interface FeatureIDs {
    int MAINTAINER = -226197043;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Relation<Maintainer<?>, Maintainer<?>, Listener<Maintainer<?>>, Features<?>> MAINTAINER = new RelationBuilder<Maintainer<?>, Maintainer<?>, Listener<Maintainer<?>>, Features<?>>().name("maintainer").id(Maintainable.FeatureIDs.MAINTAINER).concept(() -> MaintainerModelDefinition.Groups.MAINTAINER).addParameter(() -> new GenericParameterBuilder().type(() -> MaintainerModelDefinition.Generics.MAINTAINABLE.T).build()).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(MAINTAINER);
  }
}
