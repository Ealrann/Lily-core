package org.sheepy.lily.core.model.application.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.util.BuildUtils;
import org.sheepy.lily.core.model.application.SpecialEffect;
import org.sheepy.lily.core.model.application.SpecialEffect.Builder;
import org.sheepy.lily.core.model.application.impl.SpecialEffectImpl;
import org.sheepy.lily.core.model.resource.FileResource;
import org.sheepy.lily.core.model.variable.IModelVariable;

public final class SpecialEffectBuilder implements Builder {
  private String name;
  private Supplier<FileResource> shader;
  private final List<Supplier<IModelVariable>> inputs = new ArrayList<>();

  public SpecialEffectBuilder() {
  }

  @Override
  public SpecialEffectBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public SpecialEffectBuilder shader(Supplier<FileResource> shader) {
    this.shader = shader;
    return this;
  }

  @Override
  public SpecialEffectBuilder addInput(Supplier<IModelVariable> input) {
    this.inputs.add(input);
    return this;
  }

  @Override
  public SpecialEffectBuilder addInputs(final List<IModelVariable> inputs) {
    inputs.forEach(value -> this.inputs.add(() -> value));
    return this;
  }

  @Override
  public SpecialEffect build() {
    final var builtInputs = BuildUtils.collectSuppliers(inputs);
    final var built = new SpecialEffectImpl(name, shader.get());
    built.inputs().addAll(builtInputs);
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
    private static final FeatureInserter<SpecialEffectBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<SpecialEffectBuilder>(1, Inserters::attributeIndex).add(SpecialEffect.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).build();
    private static final RelationLazyInserter<SpecialEffectBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<SpecialEffectBuilder>(2, Inserters::relationIndex).add(SpecialEffect.FeatureIDs.SHADER, (builder, value) -> builder.shader((Supplier<FileResource>) value)).add(SpecialEffect.FeatureIDs.INPUTS, (builder, value) -> builder.addInput((Supplier<IModelVariable>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case SpecialEffect.FeatureIDs.NAME -> 0;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case SpecialEffect.FeatureIDs.SHADER -> 0;
        case SpecialEffect.FeatureIDs.INPUTS -> 1;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
