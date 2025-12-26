package org.sheepy.lily.core.model.cadence;

import java.util.List;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.IntListener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.sheepy.lily.core.model.cadence.builder.PrintUPSBuilder;

public interface PrintUPS extends ICadenceTask {
  static Builder builder() {
    return new PrintUPSBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  int printEveryMs();
  void printEveryMs(final int printEveryMs);

  interface FeatureIDs {
    int PRINT_EVERY_MS = 1639637688;
  }

  interface Features<T extends Features<T>> extends ICadenceTask.Features<T> {
    Attribute<Integer, Integer, IntListener, Features<?>> PRINT_EVERY_MS = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("printEveryMs").mandatory(true).defaultValue("2000").id(PrintUPS.FeatureIDs.PRINT_EVERY_MS).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(PRINT_EVERY_MS);
  }

  interface Builder extends IFeaturedObject.Builder<PrintUPS> {
    Builder printEveryMs(int printEveryMs);
  }
}
