package org.sheepy.lily.core.model.cadence;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.BooleanListener;
import org.logoce.lmf.core.api.notification.listener.IntListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.sheepy.lily.core.model.application.ICadence;
import org.sheepy.lily.core.model.cadence.builder.CadenceBuilder;

public interface Cadence extends CadenceTaskPkg, ICadence {
  static Builder builder() {
    return new CadenceBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  int frequency();
  boolean printUPS();
  void frequency(final int frequency);
  void printUPS(final boolean printUPS);

  interface FeatureIDs {
    int TASKS = CadenceTaskPkg.FeatureIDs.TASKS;
    int FREQUENCY = 1226973032;
    int PRINTUPS = -2094338113;
  }

  interface Features<T extends Features<T>> extends CadenceTaskPkg.Features<T>, ICadence.Features<T> {
    Relation<ICadenceTask, List<ICadenceTask>, Listener<List<ICadenceTask>>, CadenceTaskPkg.Features<?>> TASKS = CadenceTaskPkg.Features.TASKS;
    Attribute<Integer, Integer, IntListener, Features<?>> FREQUENCY = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("frequency").mandatory(true).defaultValue("-1").id(Cadence.FeatureIDs.FREQUENCY).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    Attribute<Boolean, Boolean, BooleanListener, Features<?>> PRINTUPS = new AttributeBuilder<Boolean, Boolean, BooleanListener, Features<?>>().name("printUPS").mandatory(true).defaultValue("false").id(Cadence.FeatureIDs.PRINTUPS).datatype(() -> LMCoreModelDefinition.Units.BOOLEAN).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(TASKS, FREQUENCY, PRINTUPS);
  }

  interface Builder extends IFeaturedObject.Builder<Cadence> {
    Builder addTask(Supplier<ICadenceTask> task);
    Builder frequency(int frequency);
    Builder printUPS(boolean printUPS);
    Builder addTasks(List<ICadenceTask> tasks);
  }
}
