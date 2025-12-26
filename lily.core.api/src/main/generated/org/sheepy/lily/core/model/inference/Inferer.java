package org.sheepy.lily.core.model.inference;

import java.util.List;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.RelationBuilder;

public interface Inferer extends IInferenceObject {
  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<LRule> rules();

  default IInferenceObject lExecutor() {
    throw new UnsupportedOperationException("Operation 'lExecutor' is not implemented");
  }

  interface FeatureIDs {
    int RULES = 1892420213;
  }

  interface Features<T extends Features<T>> extends IInferenceObject.Features<T> {
    Relation<LRule, List<LRule>, Listener<List<LRule>>, Features<?>> RULES = new RelationBuilder<LRule, List<LRule>, Listener<List<LRule>>, Features<?>>().name("rules").many(true).contains(true).id(Inferer.FeatureIDs.RULES).concept(() -> InferenceModelDefinition.Groups.L_RULE).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(RULES);
  }
}
