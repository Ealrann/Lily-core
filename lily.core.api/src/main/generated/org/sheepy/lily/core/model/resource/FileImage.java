package org.sheepy.lily.core.model.resource;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.core.model.resource.builder.FileImageBuilder;

public interface FileImage extends IRootResource, IImage {
  static Builder builder() {
    return new FileImageBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  FileResource file();
  void file(final FileResource file);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int FILE = 541887969;
  }

  interface Features<T extends Features<T>> extends IRootResource.Features<T>, IImage.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Relation<FileResource, FileResource, Listener<FileResource>, Features<?>> FILE = new RelationBuilder<FileResource, FileResource, Listener<FileResource>, Features<?>>().name("file").mandatory(true).contains(true).id(FileImage.FeatureIDs.FILE).concept(() -> ResourceModelDefinition.Groups.FILE_RESOURCE).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, FILE);
  }

  interface Builder extends IFeaturedObject.Builder<FileImage> {
    Builder name(String name);
    Builder file(Supplier<FileResource> file);
  }
}
