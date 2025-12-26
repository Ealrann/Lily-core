package org.sheepy.lily.core.model.variable;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.core.model.variable.builder.ChainVariableResolverBuilder;

public interface ChainVariableResolver extends IVariableResolver {
  static Builder builder() {
    return new ChainVariableResolverBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  IVariableResolver firstResolver();
  List<ChainResolver> subResolvers();
  void firstResolver(final IVariableResolver firstResolver);

  interface FeatureIDs {
    int FIRST_RESOLVER = -712461885;
    int SUB_RESOLVERS = -798708160;
  }

  interface Features<T extends Features<T>> extends IVariableResolver.Features<T> {
    Relation<IVariableResolver, IVariableResolver, Listener<IVariableResolver>, Features<?>> FIRST_RESOLVER = new RelationBuilder<IVariableResolver, IVariableResolver, Listener<IVariableResolver>, Features<?>>().name("firstResolver").mandatory(true).contains(true).id(ChainVariableResolver.FeatureIDs.FIRST_RESOLVER).concept(() -> VariableModelDefinition.Groups.I_VARIABLE_RESOLVER).build();
    Relation<ChainResolver, List<ChainResolver>, Listener<List<ChainResolver>>, Features<?>> SUB_RESOLVERS = new RelationBuilder<ChainResolver, List<ChainResolver>, Listener<List<ChainResolver>>, Features<?>>().name("subResolvers").many(true).mandatory(true).contains(true).id(ChainVariableResolver.FeatureIDs.SUB_RESOLVERS).concept(() -> VariableModelDefinition.Groups.CHAIN_RESOLVER).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(FIRST_RESOLVER, SUB_RESOLVERS);
  }

  interface Builder extends IFeaturedObject.Builder<ChainVariableResolver> {
    Builder firstResolver(Supplier<IVariableResolver> firstResolver);
    Builder addSubResolver(Supplier<ChainResolver> subResolver);
    Builder addSubResolvers(List<ChainResolver> subResolvers);
  }
}
