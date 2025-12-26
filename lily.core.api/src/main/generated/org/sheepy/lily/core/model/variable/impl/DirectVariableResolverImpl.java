package org.sheepy.lily.core.model.variable.impl;

import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.logoce.lmf.core.lang.LMObject;
import org.sheepy.lily.core.model.variable.DirectVariableResolver;
import org.sheepy.lily.core.model.variable.IDefinitionContainer;
import org.sheepy.lily.core.model.variable.VariableModelDefinition;

public final class DirectVariableResolverImpl extends FeaturedObject<DirectVariableResolver.Features<?>> implements DirectVariableResolver {
  private static final int FEATURE_COUNT = 2;
  private final ModelNotifier<DirectVariableResolver.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private String variableDefinition;
  private final Supplier<LMObject> target;

  public DirectVariableResolverImpl(final String variableDefinition,
      final Supplier<LMObject> target) {
    this.variableDefinition = variableDefinition;
    this.target = target;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<DirectVariableResolver.Features<?>> notifier() {
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
  public LMObject target() {
    return target.get();
  }

  @Override
  public Group<DirectVariableResolver> lmGroup() {
    return VariableModelDefinition.Groups.DIRECT_VARIABLE_RESOLVER;
  }

  @Override
  protected FeatureSetter<DirectVariableResolver> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<DirectVariableResolver> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case DirectVariableResolver.FeatureIDs.VARIABLE_DEFINITION -> 0;
      case DirectVariableResolver.FeatureIDs.TARGET -> 1;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<DirectVariableResolver> GET_MAP = new FeatureGetter.Builder<DirectVariableResolver>(FEATURE_COUNT, DirectVariableResolverImpl::featureIndexStatic).add(DirectVariableResolver.FeatureIDs.VARIABLE_DEFINITION, DirectVariableResolver::variableDefinition).add(DirectVariableResolver.FeatureIDs.TARGET, DirectVariableResolver::target).build();
    private static final FeatureSetter<DirectVariableResolver> SET_MAP = new FeatureSetter.Builder<DirectVariableResolver>(FEATURE_COUNT, DirectVariableResolverImpl::featureIndexStatic).add(DirectVariableResolver.FeatureIDs.VARIABLE_DEFINITION, (object, value) -> ((DirectVariableResolverImpl) object).variableDefinition((String) value)).build();
  }
}
