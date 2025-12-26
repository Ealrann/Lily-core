package org.sheepy.lily.core.model.resource.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.resource.FileImage;
import org.sheepy.lily.core.model.resource.FileResource;
import org.sheepy.lily.core.model.resource.ResourceModelDefinition;

public final class FileImageImpl extends FeaturedObject<FileImage.Features<?>> implements FileImage {
  private static final int FEATURE_COUNT = 2;
  private final ModelNotifier<FileImage.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private FileResource file;

  public FileImageImpl(final String name, final FileResource file) {
    this.name = name;
    this.file = file;
    setContainer(file, FileImage.FeatureIDs.FILE);
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<FileImage.Features<?>> notifier() {
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
    setContainer(file, FileImage.FeatureIDs.FILE);
    beforeContainmentNotify(eventType, oldValue, file);
    notifier.notify(FileImage.FeatureIDs.FILE, true, false, eventType, oldValue, file);
    afterContainmentNotify(eventType, oldValue, file);
  }

  @Override
  public Group<FileImage> lmGroup() {
    return ResourceModelDefinition.Groups.FILE_IMAGE;
  }

  @Override
  protected FeatureSetter<FileImage> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<FileImage> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case FileImage.FeatureIDs.NAME -> 0;
      case FileImage.FeatureIDs.FILE -> 1;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<FileImage> GET_MAP = new FeatureGetter.Builder<FileImage>(FEATURE_COUNT, FileImageImpl::featureIndexStatic).add(FileImage.FeatureIDs.NAME, FileImage::name).add(FileImage.FeatureIDs.FILE, FileImage::file).build();
    private static final FeatureSetter<FileImage> SET_MAP = new FeatureSetter.Builder<FileImage>(FEATURE_COUNT, FileImageImpl::featureIndexStatic).add(FileImage.FeatureIDs.FILE, (object, value) -> ((FileImageImpl) object).file((FileResource) value)).build();
  }
}
