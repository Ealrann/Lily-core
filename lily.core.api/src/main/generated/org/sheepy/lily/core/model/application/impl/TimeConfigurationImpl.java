package org.sheepy.lily.core.model.application.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.application.ApplicationModelDefinition;
import org.sheepy.lily.core.model.application.TimeConfiguration;
import org.sheepy.lily.core.model.types.ETimeUnit;

public final class TimeConfigurationImpl extends FeaturedObject<TimeConfiguration.Features<?>> implements TimeConfiguration {
  private static final int FEATURE_COUNT = 3;
  private final ModelNotifier<TimeConfiguration.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private long timeStep;
  private ETimeUnit unit;
  private double timeFactor;

  public TimeConfigurationImpl(final long timeStep, final ETimeUnit unit, final double timeFactor) {
    this.timeStep = timeStep;
    this.unit = unit;
    this.timeFactor = timeFactor;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<TimeConfiguration.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public long timeStep() {
    return timeStep;
  }

  @Override
  public void timeStep(final long timeStep) {
    final var oldValue = this.timeStep;
    this.timeStep = timeStep;
    notifier.notifyLong(TimeConfiguration.FeatureIDs.TIME_STEP, false, false, oldValue, timeStep);
  }

  @Override
  public ETimeUnit unit() {
    return unit;
  }

  @Override
  public void unit(final ETimeUnit unit) {
    final var oldValue = this.unit;
    this.unit = unit;
    notifier.notify(TimeConfiguration.FeatureIDs.UNIT, false, false, oldValue, unit);
  }

  @Override
  public double timeFactor() {
    return timeFactor;
  }

  @Override
  public void timeFactor(final double timeFactor) {
    final var oldValue = this.timeFactor;
    this.timeFactor = timeFactor;
    notifier.notifyDouble(TimeConfiguration.FeatureIDs.TIME_FACTOR, false, false, oldValue, timeFactor);
  }

  @Override
  public Group<TimeConfiguration> lmGroup() {
    return ApplicationModelDefinition.Groups.TIME_CONFIGURATION;
  }

  @Override
  protected FeatureSetter<TimeConfiguration> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<TimeConfiguration> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case TimeConfiguration.FeatureIDs.TIME_STEP -> 0;
      case TimeConfiguration.FeatureIDs.UNIT -> 1;
      case TimeConfiguration.FeatureIDs.TIME_FACTOR -> 2;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<TimeConfiguration> GET_MAP = new FeatureGetter.Builder<TimeConfiguration>(FEATURE_COUNT, TimeConfigurationImpl::featureIndexStatic).add(TimeConfiguration.FeatureIDs.TIME_STEP, TimeConfiguration::timeStep).add(TimeConfiguration.FeatureIDs.UNIT, TimeConfiguration::unit).add(TimeConfiguration.FeatureIDs.TIME_FACTOR, TimeConfiguration::timeFactor).build();
    private static final FeatureSetter<TimeConfiguration> SET_MAP = new FeatureSetter.Builder<TimeConfiguration>(FEATURE_COUNT, TimeConfigurationImpl::featureIndexStatic).add(TimeConfiguration.FeatureIDs.TIME_STEP, (object, value) -> ((TimeConfigurationImpl) object).timeStep((long) value)).add(TimeConfiguration.FeatureIDs.UNIT, (object, value) -> ((TimeConfigurationImpl) object).unit((ETimeUnit) value)).add(TimeConfiguration.FeatureIDs.TIME_FACTOR, (object, value) -> ((TimeConfigurationImpl) object).timeFactor((double) value)).build();
  }
}
