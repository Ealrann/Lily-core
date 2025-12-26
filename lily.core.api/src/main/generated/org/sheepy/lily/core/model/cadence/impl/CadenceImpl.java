package org.sheepy.lily.core.model.cadence.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.cadence.Cadence;
import org.sheepy.lily.core.model.cadence.CadenceModelDefinition;
import org.sheepy.lily.core.model.cadence.CadenceTaskPkg;
import org.sheepy.lily.core.model.cadence.ICadenceTask;

public final class CadenceImpl extends FeaturedObject<Cadence.Features<?>> implements Cadence {
  private static final int FEATURE_COUNT = 3;
  private final ModelNotifier<Cadence.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final List<ICadenceTask> tasks = newObservableList(CadenceTaskPkg.FeatureIDs.TASKS, true, true);
  private int frequency;
  private boolean printUPS;

  public CadenceImpl(final int frequency, final boolean printUPS) {
    this.frequency = frequency;
    this.printUPS = printUPS;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<Cadence.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public List<ICadenceTask> tasks() {
    return tasks;
  }

  @Override
  public int frequency() {
    return frequency;
  }

  @Override
  public void frequency(final int frequency) {
    final var oldValue = this.frequency;
    this.frequency = frequency;
    notifier.notifyInt(Cadence.FeatureIDs.FREQUENCY, false, false, oldValue, frequency);
  }

  @Override
  public boolean printUPS() {
    return printUPS;
  }

  @Override
  public void printUPS(final boolean printUPS) {
    final var oldValue = this.printUPS;
    this.printUPS = printUPS;
    notifier.notifyBoolean(Cadence.FeatureIDs.PRINTUPS, false, false, oldValue, printUPS);
  }

  @Override
  public Group<Cadence> lmGroup() {
    return CadenceModelDefinition.Groups.CADENCE;
  }

  @Override
  protected FeatureSetter<Cadence> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<Cadence> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case Cadence.FeatureIDs.TASKS -> 0;
      case Cadence.FeatureIDs.FREQUENCY -> 1;
      case Cadence.FeatureIDs.PRINTUPS -> 2;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<Cadence> GET_MAP = new FeatureGetter.Builder<Cadence>(FEATURE_COUNT, CadenceImpl::featureIndexStatic).add(Cadence.FeatureIDs.TASKS, Cadence::tasks).add(Cadence.FeatureIDs.FREQUENCY, Cadence::frequency).add(Cadence.FeatureIDs.PRINTUPS, Cadence::printUPS).build();
    private static final FeatureSetter<Cadence> SET_MAP = new FeatureSetter.Builder<Cadence>(FEATURE_COUNT, CadenceImpl::featureIndexStatic).add(Cadence.FeatureIDs.FREQUENCY, (object, value) -> ((CadenceImpl) object).frequency((int) value)).add(Cadence.FeatureIDs.PRINTUPS, (object, value) -> ((CadenceImpl) object).printUPS((boolean) value)).build();
  }
}
