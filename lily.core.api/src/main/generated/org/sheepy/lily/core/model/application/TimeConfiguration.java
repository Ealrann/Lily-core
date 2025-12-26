package org.sheepy.lily.core.model.application;

import java.util.List;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.DoubleListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.api.notification.listener.LongListener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.sheepy.lily.core.model.application.builder.TimeConfigurationBuilder;
import org.sheepy.lily.core.model.types.ETimeUnit;
import org.sheepy.lily.core.model.types.TypesModelDefinition;

public interface TimeConfiguration extends LMObject {
  static Builder builder() {
    return new TimeConfigurationBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  long timeStep();
  ETimeUnit unit();
  double timeFactor();
  void timeStep(final long timeStep);
  void unit(final ETimeUnit unit);
  void timeFactor(final double timeFactor);

  interface FeatureIDs {
    int TIME_STEP = 2122901302;
    int UNIT = 1690806273;
    int TIME_FACTOR = -391092423;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Attribute<Long, Long, LongListener, Features<?>> TIME_STEP = new AttributeBuilder<Long, Long, LongListener, Features<?>>().name("timeStep").mandatory(true).defaultValue("1").id(TimeConfiguration.FeatureIDs.TIME_STEP).datatype(() -> LMCoreModelDefinition.Units.LONG).build();
    Attribute<ETimeUnit, ETimeUnit, Listener<ETimeUnit>, Features<?>> UNIT = new AttributeBuilder<ETimeUnit, ETimeUnit, Listener<ETimeUnit>, Features<?>>().name("unit").mandatory(true).defaultValue("SECONDS").id(TimeConfiguration.FeatureIDs.UNIT).datatype(() -> TypesModelDefinition.Enums.E_TIME_UNIT).build();
    Attribute<Double, Double, DoubleListener, Features<?>> TIME_FACTOR = new AttributeBuilder<Double, Double, DoubleListener, Features<?>>().name("timeFactor").mandatory(true).defaultValue("1").id(TimeConfiguration.FeatureIDs.TIME_FACTOR).datatype(() -> LMCoreModelDefinition.Units.DOUBLE).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(TIME_STEP, UNIT, TIME_FACTOR);
  }

  interface Builder extends IFeaturedObject.Builder<TimeConfiguration> {
    Builder timeStep(long timeStep);
    Builder unit(ETimeUnit unit);
    Builder timeFactor(double timeFactor);
  }
}
