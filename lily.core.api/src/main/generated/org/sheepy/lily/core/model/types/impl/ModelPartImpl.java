package org.sheepy.lily.core.model.types.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.logoce.lmf.core.lang.LMObject;
import org.sheepy.lily.core.model.types.ModelPart;
import org.sheepy.lily.core.model.types.TypesModelDefinition;

public final class ModelPartImpl extends FeaturedObject<ModelPart.Features<?>> implements ModelPart {
  private static final int FEATURE_COUNT = 5;
  private final ModelNotifier<ModelPart.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private final String domain;
  private final List<String> imports;
  private final List<String> metamodels;
  private final List<LMObject> children = newObservableList(ModelPart.FeatureIDs.CHILDREN, true, true);

  public ModelPartImpl(final String name, final String domain, final List<String> imports,
      final List<String> metamodels) {
    this.name = name;
    this.domain = domain;
    this.imports = List.copyOf(imports);
    this.metamodels = List.copyOf(metamodels);
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<ModelPart.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public String domain() {
    return domain;
  }

  @Override
  public List<String> imports() {
    return imports;
  }

  @Override
  public List<String> metamodels() {
    return metamodels;
  }

  @Override
  public List<LMObject> children() {
    return children;
  }

  @Override
  public Group<ModelPart> lmGroup() {
    return TypesModelDefinition.Groups.MODEL_PART;
  }

  @Override
  protected FeatureSetter<ModelPart> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<ModelPart> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case ModelPart.FeatureIDs.NAME -> 0;
      case ModelPart.FeatureIDs.DOMAIN -> 1;
      case ModelPart.FeatureIDs.IMPORTS -> 2;
      case ModelPart.FeatureIDs.METAMODELS -> 3;
      case ModelPart.FeatureIDs.CHILDREN -> 4;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<ModelPart> GET_MAP = new FeatureGetter.Builder<ModelPart>(FEATURE_COUNT, ModelPartImpl::featureIndexStatic).add(ModelPart.FeatureIDs.NAME, ModelPart::name).add(ModelPart.FeatureIDs.DOMAIN, ModelPart::domain).add(ModelPart.FeatureIDs.IMPORTS, ModelPart::imports).add(ModelPart.FeatureIDs.METAMODELS, ModelPart::metamodels).add(ModelPart.FeatureIDs.CHILDREN, ModelPart::children).build();
    private static final FeatureSetter<ModelPart> SET_MAP = new FeatureSetter.Builder<ModelPart>(FEATURE_COUNT, ModelPartImpl::featureIndexStatic).build();
  }
}
