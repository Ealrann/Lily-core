package org.sheepy.lily.core.model.cadence.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.cadence.CadenceModelDefinition;
import org.sheepy.lily.core.model.cadence.PrintUPS;

public final class PrintUPSImpl extends FeaturedObject<PrintUPS.Features<?>> implements PrintUPS {
  private static final int FEATURE_COUNT = 1;
  private final ModelNotifier<PrintUPS.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private int printEveryMs;

  public PrintUPSImpl(final int printEveryMs) {
    this.printEveryMs = printEveryMs;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<PrintUPS.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public int printEveryMs() {
    return printEveryMs;
  }

  @Override
  public void printEveryMs(final int printEveryMs) {
    final var oldValue = this.printEveryMs;
    this.printEveryMs = printEveryMs;
    notifier.notifyInt(PrintUPS.FeatureIDs.PRINT_EVERY_MS, false, false, oldValue, printEveryMs);
  }

  @Override
  public Group<PrintUPS> lmGroup() {
    return CadenceModelDefinition.Groups.PRINTUPS;
  }

  @Override
  protected FeatureSetter<PrintUPS> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<PrintUPS> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case PrintUPS.FeatureIDs.PRINT_EVERY_MS -> 0;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<PrintUPS> GET_MAP = new FeatureGetter.Builder<PrintUPS>(FEATURE_COUNT, PrintUPSImpl::featureIndexStatic).add(PrintUPS.FeatureIDs.PRINT_EVERY_MS, PrintUPS::printEveryMs).build();
    private static final FeatureSetter<PrintUPS> SET_MAP = new FeatureSetter.Builder<PrintUPS>(FEATURE_COUNT, PrintUPSImpl::featureIndexStatic).add(PrintUPS.FeatureIDs.PRINT_EVERY_MS, (object, value) -> ((PrintUPSImpl) object).printEveryMs((int) value)).build();
  }
}
