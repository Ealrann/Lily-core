package org.sheepy.lily.core.model.variable.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.variable.ChainResolver;
import org.sheepy.lily.core.model.variable.IDefinitionContainer;
import org.sheepy.lily.core.model.variable.VariableModelDefinition;

public final class ChainResolverImpl extends FeaturedObject<ChainResolver.Features<?>> implements ChainResolver {
  private static final int FEATURE_COUNT = 1;
  private final ModelNotifier<ChainResolver.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private String variableDefinition;

  public ChainResolverImpl(final String variableDefinition) {
    this.variableDefinition = variableDefinition;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<ChainResolver.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public String variableDefinition() {
    return variableDefinition;
  }

  @Override
  public void variableDefinition(final String variableDefinition) {
    final var oldValue = this.variableDefinition;
    this.variableDefinition = variableDefinition;
    notifier.notify(IDefinitionContainer.FeatureIDs.VARIABLE_DEFINITION, false, false, oldValue, variableDefinition);
  }

  @Override
  public Group<ChainResolver> lmGroup() {
    return VariableModelDefinition.Groups.CHAIN_RESOLVER;
  }

  @Override
  protected FeatureSetter<ChainResolver> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<ChainResolver> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case ChainResolver.FeatureIDs.VARIABLE_DEFINITION -> 0;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<ChainResolver> GET_MAP = new FeatureGetter.Builder<ChainResolver>(FEATURE_COUNT, ChainResolverImpl::featureIndexStatic).add(ChainResolver.FeatureIDs.VARIABLE_DEFINITION, ChainResolver::variableDefinition).build();
    private static final FeatureSetter<ChainResolver> SET_MAP = new FeatureSetter.Builder<ChainResolver>(FEATURE_COUNT, ChainResolverImpl::featureIndexStatic).add(ChainResolver.FeatureIDs.VARIABLE_DEFINITION, (object, value) -> ((ChainResolverImpl) object).variableDefinition((String) value)).build();
  }
}
