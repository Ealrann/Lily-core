package org.sheepy.lily.core.model.application.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.application.ApplicationModelDefinition;
import org.sheepy.lily.core.model.application.SpecialEffect;
import org.sheepy.lily.core.model.resource.FileResource;
import org.sheepy.lily.core.model.variable.IModelVariable;

public final class SpecialEffectImpl extends FeaturedObject<SpecialEffect.Features<?>> implements SpecialEffect {
  private static final int FEATURE_COUNT = 3;
  private final ModelNotifier<SpecialEffect.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private FileResource shader;
  private final List<IModelVariable> inputs = newObservableList(SpecialEffect.FeatureIDs.INPUTS, true, false);

  public SpecialEffectImpl(final String name, final FileResource shader) {
    this.name = name;
    this.shader = shader;
    setContainer(shader, SpecialEffect.FeatureIDs.SHADER);
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<SpecialEffect.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public FileResource shader() {
    return shader;
  }

  @Override
  public void shader(final FileResource shader) {
    final var oldValue = this.shader;
    final var eventType = shader == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.shader = shader;
    setContainer(shader, SpecialEffect.FeatureIDs.SHADER);
    beforeContainmentNotify(eventType, oldValue, shader);
    notifier.notify(SpecialEffect.FeatureIDs.SHADER, true, false, eventType, oldValue, shader);
    afterContainmentNotify(eventType, oldValue, shader);
  }

  @Override
  public List<IModelVariable> inputs() {
    return inputs;
  }

  @Override
  public Group<SpecialEffect> lmGroup() {
    return ApplicationModelDefinition.Groups.SPECIAL_EFFECT;
  }

  @Override
  protected FeatureSetter<SpecialEffect> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<SpecialEffect> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case SpecialEffect.FeatureIDs.NAME -> 0;
      case SpecialEffect.FeatureIDs.SHADER -> 1;
      case SpecialEffect.FeatureIDs.INPUTS -> 2;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<SpecialEffect> GET_MAP = new FeatureGetter.Builder<SpecialEffect>(FEATURE_COUNT, SpecialEffectImpl::featureIndexStatic).add(SpecialEffect.FeatureIDs.NAME, SpecialEffect::name).add(SpecialEffect.FeatureIDs.SHADER, SpecialEffect::shader).add(SpecialEffect.FeatureIDs.INPUTS, SpecialEffect::inputs).build();
    private static final FeatureSetter<SpecialEffect> SET_MAP = new FeatureSetter.Builder<SpecialEffect>(FEATURE_COUNT, SpecialEffectImpl::featureIndexStatic).add(SpecialEffect.FeatureIDs.SHADER, (object, value) -> ((SpecialEffectImpl) object).shader((FileResource) value)).build();
  }
}
