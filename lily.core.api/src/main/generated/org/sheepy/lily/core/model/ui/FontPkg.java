package org.sheepy.lily.core.model.ui;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.core.model.ui.builder.FontPkgBuilder;

public interface FontPkg extends LMObject {
  static Builder builder() {
    return new FontPkgBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<Font> fonts();

  interface FeatureIDs {
    int FONTS = -2114944925;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Relation<Font, List<Font>, Listener<List<Font>>, Features<?>> FONTS = new RelationBuilder<Font, List<Font>, Listener<List<Font>>, Features<?>>().name("fonts").many(true).mandatory(true).contains(true).id(FontPkg.FeatureIDs.FONTS).concept(() -> UIModelDefinition.Groups.FONT).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(FONTS);
  }

  interface Builder extends IFeaturedObject.Builder<FontPkg> {
    Builder addFont(Supplier<Font> font);
    Builder addFonts(List<Font> fonts);
  }
}
