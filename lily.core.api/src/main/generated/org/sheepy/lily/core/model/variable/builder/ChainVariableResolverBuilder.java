package org.sheepy.lily.core.model.variable.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.util.BuildUtils;
import org.sheepy.lily.core.model.variable.ChainResolver;
import org.sheepy.lily.core.model.variable.ChainVariableResolver;
import org.sheepy.lily.core.model.variable.ChainVariableResolver.Builder;
import org.sheepy.lily.core.model.variable.IVariableResolver;
import org.sheepy.lily.core.model.variable.impl.ChainVariableResolverImpl;

public final class ChainVariableResolverBuilder implements Builder {
  private Supplier<IVariableResolver> firstResolver;
  private final List<Supplier<ChainResolver>> subResolvers = new ArrayList<>();

  public ChainVariableResolverBuilder() {
  }

  @Override
  public ChainVariableResolverBuilder firstResolver(Supplier<IVariableResolver> firstResolver) {
    this.firstResolver = firstResolver;
    return this;
  }

  @Override
  public ChainVariableResolverBuilder addSubResolver(Supplier<ChainResolver> subResolver) {
    this.subResolvers.add(subResolver);
    return this;
  }

  @Override
  public ChainVariableResolverBuilder addSubResolvers(final List<ChainResolver> subResolvers) {
    subResolvers.forEach(value -> this.subResolvers.add(() -> value));
    return this;
  }

  @Override
  public ChainVariableResolver build() {
    final var builtSubResolvers = BuildUtils.collectSuppliers(subResolvers);
    final var built = new ChainVariableResolverImpl(firstResolver.get(), builtSubResolvers);
    return built;
  }

  @Override
  public <AttributeType> void push(final Attribute<?, ?, ?, ?> attribute,
      final AttributeType value) {
    Inserters.ATTRIBUTE_INSERTER.push(this, attribute.id(), value);
  }

  @Override
  public <RelationType extends LMObject> void push(final Relation<RelationType, ?, ?, ?> relation,
      final Supplier<RelationType> supplier) {
    Inserters.RELATION_INSERTER.push(this, relation.id(), supplier);
  }

  private static final class Inserters {
    private static final FeatureInserter<ChainVariableResolverBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<ChainVariableResolverBuilder>(0, Inserters::attributeIndex).build();
    private static final RelationLazyInserter<ChainVariableResolverBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<ChainVariableResolverBuilder>(2, Inserters::relationIndex).add(ChainVariableResolver.FeatureIDs.FIRST_RESOLVER, (builder, value) -> builder.firstResolver((Supplier<IVariableResolver>) value)).add(ChainVariableResolver.FeatureIDs.SUB_RESOLVERS, (builder, value) -> builder.addSubResolver((Supplier<ChainResolver>) value)).build();

    private static int attributeIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case ChainVariableResolver.FeatureIDs.FIRST_RESOLVER -> 0;
        case ChainVariableResolver.FeatureIDs.SUB_RESOLVERS -> 1;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
