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

public final class SoundImpl extends FeaturedObject<Sound.Features<?>> implements Sound {
  private static final int FEATURE_COUNT = 2;
  private final ModelNotifier<Sound.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private FileResource file;

  public SoundImpl(final String name, final FileResource file) {
    this.name = name;
    this.file = file;
    setContainer(file, Sound.FeatureIDs.FILE);
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<Sound.Features<?>> notifier() {
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
  public Group<Sound> lmGroup() {
    return ResourceModelDefinition.Groups.SOUND;
  }

  @Override
  protected FeatureSetter<Sound> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<Sound> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case Sound.FeatureIDs.NAME -> 0;
      case Sound.FeatureIDs.FILE -> 1;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<Sound> GET_MAP = new FeatureGetter.Builder<Sound>(FEATURE_COUNT, SoundImpl::featureIndexStatic).add(Sound.FeatureIDs.NAME, Sound::name).add(Sound.FeatureIDs.FILE, Sound::file).build();
    private static final FeatureSetter<Sound> SET_MAP = new FeatureSetter.Builder<Sound>(FEATURE_COUNT, SoundImpl::featureIndexStatic).add(Sound.FeatureIDs.FILE, (object, value) -> ((SoundImpl) object).file((FileResource) value)).build();
  }
}
