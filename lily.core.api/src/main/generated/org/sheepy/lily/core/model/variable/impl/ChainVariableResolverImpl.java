package org.sheepy.lily.core.model.variable.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.variable.ChainResolver;
import org.sheepy.lily.core.model.variable.ChainVariableResolver;
import org.sheepy.lily.core.model.variable.IVariableResolver;
import org.sheepy.lily.core.model.variable.VariableModelDefinition;

public final class ChainVariableResolverImpl extends FeaturedObject<ChainVariableResolver.Features<?>> implements ChainVariableResolver {
  private static final int FEATURE_COUNT = 2;
  private final ModelNotifier<ChainVariableResolver.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private IVariableResolver firstResolver;
  private final List<ChainResolver> subResolvers = newObservableList(ChainVariableResolver.FeatureIDs.SUB_RESOLVERS, true, true);

  public ChainVariableResolverImpl(final IVariableResolver firstResolver,
      final List<ChainResolver> subResolvers) {
    this.firstResolver = firstResolver;
    this.subResolvers.addAll(subResolvers);
    setContainer(firstResolver, ChainVariableResolver.FeatureIDs.FIRST_RESOLVER);
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<ChainVariableResolver.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public IVariableResolver firstResolver() {
    return firstResolver;
  }

  @Override
  public void firstResolver(final IVariableResolver firstResolver) {
    final var oldValue = this.firstResolver;
    final var eventType = firstResolver == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.firstResolver = firstResolver;
    setContainer(firstResolver, ChainVariableResolver.FeatureIDs.FIRST_RESOLVER);
    beforeContainmentNotify(eventType, oldValue, firstResolver);
    notifier.notify(ChainVariableResolver.FeatureIDs.FIRST_RESOLVER, true, false, eventType, oldValue, firstResolver);
    afterContainmentNotify(eventType, oldValue, firstResolver);
  }

  @Override
  public List<ChainResolver> subResolvers() {
    return subResolvers;
  }

  @Override
  public Group<ChainVariableResolver> lmGroup() {
    return VariableModelDefinition.Groups.CHAIN_VARIABLE_RESOLVER;
  }

  @Override
  protected FeatureSetter<ChainVariableResolver> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<ChainVariableResolver> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case ChainVariableResolver.FeatureIDs.FIRST_RESOLVER -> 0;
      case ChainVariableResolver.FeatureIDs.SUB_RESOLVERS -> 1;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<ChainVariableResolver> GET_MAP = new FeatureGetter.Builder<ChainVariableResolver>(FEATURE_COUNT, ChainVariableResolverImpl::featureIndexStatic).add(ChainVariableResolver.FeatureIDs.FIRST_RESOLVER, ChainVariableResolver::firstResolver).add(ChainVariableResolver.FeatureIDs.SUB_RESOLVERS, ChainVariableResolver::subResolvers).build();
    private static final FeatureSetter<ChainVariableResolver> SET_MAP = new FeatureSetter.Builder<ChainVariableResolver>(FEATURE_COUNT, ChainVariableResolverImpl::featureIndexStatic).add(ChainVariableResolver.FeatureIDs.FIRST_RESOLVER, (object, value) -> ((ChainVariableResolverImpl) object).firstResolver((IVariableResolver) value)).build();
  }
}
