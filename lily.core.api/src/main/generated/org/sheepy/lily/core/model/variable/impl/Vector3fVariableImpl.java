package org.sheepy.lily.core.model.variable.impl;

import org.joml.Vector3fc;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.variable.VariableModelDefinition;
import org.sheepy.lily.core.model.variable.Vector3fVariable;

public final class Vector3fVariableImpl extends FeaturedObject<Vector3fVariable.Features<?>> implements Vector3fVariable {
  private static final int FEATURE_COUNT = 2;
  private final ModelNotifier<Vector3fVariable.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private Vector3fc vector;

  public Vector3fVariableImpl(final String name) {
    this.name = name;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<Vector3fVariable.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public Vector3fc vector() {
    return vector;
  }

  @Override
  public void vector(final Vector3fc vector) {
    final var oldValue = this.vector;
    this.vector = vector;
    notifier.notify(Vector3fVariable.FeatureIDs.VECTOR, false, false, oldValue, vector);
  }

  @Override
  public Group<Vector3fVariable> lmGroup() {
    return VariableModelDefinition.Groups.VECTOR3F_VARIABLE;
  }

  @Override
  protected FeatureSetter<Vector3fVariable> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<Vector3fVariable> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case Vector3fVariable.FeatureIDs.NAME -> 0;
      case Vector3fVariable.FeatureIDs.VECTOR -> 1;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<Vector3fVariable> GET_MAP = new FeatureGetter.Builder<Vector3fVariable>(FEATURE_COUNT, Vector3fVariableImpl::featureIndexStatic).add(Vector3fVariable.FeatureIDs.NAME, Vector3fVariable::name).add(Vector3fVariable.FeatureIDs.VECTOR, Vector3fVariable::vector).build();
    private static final FeatureSetter<Vector3fVariable> SET_MAP = new FeatureSetter.Builder<Vector3fVariable>(FEATURE_COUNT, Vector3fVariableImpl::featureIndexStatic).add(Vector3fVariable.FeatureIDs.VECTOR, (object, value) -> ((Vector3fVariableImpl) object).vector((Vector3fc) value)).build();
  }
}
