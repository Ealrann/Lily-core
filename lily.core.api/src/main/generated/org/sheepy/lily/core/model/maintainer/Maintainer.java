package org.sheepy.lily.core.model.maintainer;

import java.util.List;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.GenericParameterBuilder;
import org.logoce.lmf.core.lang.builder.RelationBuilder;

public interface Maintainer<T extends Maintainable<T>> extends LMObject {
  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<Maintainable<T>> maintained();

  interface FeatureIDs {
    int MAINTAINED = 1221120460;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Relation<Maintainable<?>, List<Maintainable<?>>, Listener<List<Maintainable<?>>>, Features<?>> MAINTAINED = new RelationBuilder<Maintainable<?>, List<Maintainable<?>>, Listener<List<Maintainable<?>>>, Features<?>>().name("maintained").many(true).id(Maintainer.FeatureIDs.MAINTAINED).concept(() -> MaintainerModelDefinition.Groups.MAINTAINABLE).addParameter(() -> new GenericParameterBuilder().type(() -> MaintainerModelDefinition.Generics.MAINTAINER.T).build()).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(MAINTAINED);
  }
}
