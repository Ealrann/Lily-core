package org.sheepy.lily.core.model.ui.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.resource.FileResource;
import org.sheepy.lily.core.model.types.ECharTable;
import org.sheepy.lily.core.model.ui.FontTable;
import org.sheepy.lily.core.model.ui.UIModelDefinition;

public final class FontTableImpl extends FeaturedObject<FontTable.Features<?>> implements FontTable {
  private static final int FEATURE_COUNT = 3;
  private final ModelNotifier<FontTable.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private FileResource file;
  private final List<ECharTable> charTables = newObservableList(FontTable.FeatureIDs.CHAR_TABLES, false, false);

  public FontTableImpl(final String name, final FileResource file,
      final List<ECharTable> charTables) {
    this.name = name;
    this.file = file;
    this.charTables.addAll(charTables);
    setContainer(file, FontTable.FeatureIDs.FILE);
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<FontTable.Features<?>> notifier() {
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
    setContainer(file, FontTable.FeatureIDs.FILE);
    beforeContainmentNotify(eventType, oldValue, file);
    notifier.notify(FontTable.FeatureIDs.FILE, true, false, eventType, oldValue, file);
    afterContainmentNotify(eventType, oldValue, file);
  }

  @Override
  public List<ECharTable> charTables() {
    return charTables;
  }

  @Override
  public Group<FontTable> lmGroup() {
    return UIModelDefinition.Groups.FONT_TABLE;
  }

  @Override
  protected FeatureSetter<FontTable> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<FontTable> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case FontTable.FeatureIDs.NAME -> 0;
      case FontTable.FeatureIDs.FILE -> 1;
      case FontTable.FeatureIDs.CHAR_TABLES -> 2;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<FontTable> GET_MAP = new FeatureGetter.Builder<FontTable>(FEATURE_COUNT, FontTableImpl::featureIndexStatic).add(FontTable.FeatureIDs.NAME, FontTable::name).add(FontTable.FeatureIDs.FILE, FontTable::file).add(FontTable.FeatureIDs.CHAR_TABLES, FontTable::charTables).build();
    private static final FeatureSetter<FontTable> SET_MAP = new FeatureSetter.Builder<FontTable>(FEATURE_COUNT, FontTableImpl::featureIndexStatic).add(FontTable.FeatureIDs.FILE, (object, value) -> ((FontTableImpl) object).file((FileResource) value)).build();
  }
}
