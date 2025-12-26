package org.sheepy.lily.core.model.resource.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.resource.FileResource;
import org.sheepy.lily.core.model.resource.Music;
import org.sheepy.lily.core.model.resource.ResourceModelDefinition;

public final class MusicImpl extends FeaturedObject<Music.Features<?>> implements Music {
  private static final int FEATURE_COUNT = 2;
  private final ModelNotifier<Music.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private FileResource file;

  public MusicImpl(final String name, final FileResource file) {
    this.name = name;
    this.file = file;
    setContainer(file, Music.FeatureIDs.FILE);
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<Music.Features<?>> notifier() {
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
    setContainer(file, Music.FeatureIDs.FILE);
    beforeContainmentNotify(eventType, oldValue, file);
    notifier.notify(Music.FeatureIDs.FILE, true, false, eventType, oldValue, file);
    afterContainmentNotify(eventType, oldValue, file);
  }

  @Override
  public Group<Music> lmGroup() {
    return ResourceModelDefinition.Groups.MUSIC;
  }

  @Override
  protected FeatureSetter<Music> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<Music> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case Music.FeatureIDs.NAME -> 0;
      case Music.FeatureIDs.FILE -> 1;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<Music> GET_MAP = new FeatureGetter.Builder<Music>(FEATURE_COUNT, MusicImpl::featureIndexStatic).add(Music.FeatureIDs.NAME, Music::name).add(Music.FeatureIDs.FILE, Music::file).build();
    private static final FeatureSetter<Music> SET_MAP = new FeatureSetter.Builder<Music>(FEATURE_COUNT, MusicImpl::featureIndexStatic).add(Music.FeatureIDs.FILE, (object, value) -> ((MusicImpl) object).file((FileResource) value)).build();
  }
}
