package org.sheepy.lily.core.model.variable;

import java.util.List;
import org.joml.Vector3fc;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.sheepy.lily.core.model.types.TypesModelDefinition;
import org.sheepy.lily.core.model.variable.builder.Vector3fVariableBuilder;

public interface Vector3fVariable extends IModelVariable {
  static Builder builder() {
    return new Vector3fVariableBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  Vector3fc vector();
  void vector(final Vector3fc vector);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int VECTOR = 694421167;
  }

  interface Features<T extends Features<T>> extends IModelVariable.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<Vector3fc, Vector3fc, Listener<Vector3fc>, Features<?>> VECTOR = new AttributeBuilder<Vector3fc, Vector3fc, Listener<Vector3fc>, Features<?>>().name("vector").id(Vector3fVariable.FeatureIDs.VECTOR).datatype(() -> TypesModelDefinition.JavaWrappers.VECTOR3F).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, VECTOR);
  }

  interface Builder extends IFeaturedObject.Builder<Vector3fVariable> {
    Builder name(String name);
    Builder vector(Vector3fc vector);
  }
}
