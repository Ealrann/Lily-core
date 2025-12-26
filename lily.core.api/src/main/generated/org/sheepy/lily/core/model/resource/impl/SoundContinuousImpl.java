package org.sheepy.lily.core.model.resource.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.resource.FileResource;
import org.sheepy.lily.core.model.resource.ResourceModelDefinition;
import org.sheepy.lily.core.model.resource.Sound;
import org.sheepy.lily.core.model.resource.SoundContinuous;

public final class SoundContinuousImpl extends FeaturedObject<SoundContinuous.Features<?>> implements SoundContinuous {
  private static final int FEATURE_COUNT = 4;
  private final ModelNotifier<SoundContinuous.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private FileResource file;
  private int attackMs;
  private int decayMs;

  public SoundContinuousImpl(final String name, final FileResource file, final int attackMs,
      final int decayMs) {
    this.name = name;
    this.file = file;
    this.attackMs = attackMs;
    this.decayMs = decayMs;
    setContainer(file, Sound.FeatureIDs.FILE);
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<SoundContinuous.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public FileResource file() {
    return file;
  }

  @Override
  public void file(final FileResource file) {
    final var oldValue = this.file;
    final var eventType = file == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.file = file;
    setContainer(file, Sound.FeatureIDs.FILE);
    beforeContainmentNotify(eventType, oldValue, file);
    notifier.notify(Sound.FeatureIDs.FILE, true, false, eventType, oldValue, file);
    afterContainmentNotify(eventType, oldValue, file);
  }

  @Override
  public int attackMs() {
    return attackMs;
  }

  @Override
  public void attackMs(final int attackMs) {
    final var oldValue = this.attackMs;
    this.attackMs = attackMs;
    notifier.notifyInt(SoundContinuous.FeatureIDs.ATTACK_MS, false, false, oldValue, attackMs);
  }

  @Override
  public int decayMs() {
    return decayMs;
  }

  @Override
  public void decayMs(final int decayMs) {
    final var oldValue = this.decayMs;
    this.decayMs = decayMs;
    notifier.notifyInt(SoundContinuous.FeatureIDs.DECAY_MS, false, false, oldValue, decayMs);
  }

  @Override
  public Group<SoundContinuous> lmGroup() {
    return ResourceModelDefinition.Groups.SOUND_CONTINUOUS;
  }

  @Override
  protected FeatureSetter<SoundContinuous> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<SoundContinuous> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case SoundContinuous.FeatureIDs.NAME -> 0;
      case SoundContinuous.FeatureIDs.FILE -> 1;
      case SoundContinuous.FeatureIDs.ATTACK_MS -> 2;
      case SoundContinuous.FeatureIDs.DECAY_MS -> 3;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<SoundContinuous> GET_MAP = new FeatureGetter.Builder<SoundContinuous>(FEATURE_COUNT, SoundContinuousImpl::featureIndexStatic).add(SoundContinuous.FeatureIDs.NAME, SoundContinuous::name).add(SoundContinuous.FeatureIDs.FILE, SoundContinuous::file).add(SoundContinuous.FeatureIDs.ATTACK_MS, SoundContinuous::attackMs).add(SoundContinuous.FeatureIDs.DECAY_MS, SoundContinuous::decayMs).build();
    private static final FeatureSetter<SoundContinuous> SET_MAP = new FeatureSetter.Builder<SoundContinuous>(FEATURE_COUNT, SoundContinuousImpl::featureIndexStatic).add(SoundContinuous.FeatureIDs.FILE, (object, value) -> ((SoundContinuousImpl) object).file((FileResource) value)).add(SoundContinuous.FeatureIDs.ATTACK_MS, (object, value) -> ((SoundContinuousImpl) object).attackMs((int) value)).add(SoundContinuous.FeatureIDs.DECAY_MS, (object, value) -> ((SoundContinuousImpl) object).decayMs((int) value)).build();
  }
}
