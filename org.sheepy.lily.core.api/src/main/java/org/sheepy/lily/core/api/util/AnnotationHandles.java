package org.sheepy.lily.core.api.util;

import org.sheepy.lily.core.api.extender.IExtenderHandle;

import java.lang.annotation.Annotation;
import java.util.List;

public record AnnotationHandles<T extends Annotation>(Class<T>annotationClass,
													  List<IExtenderHandle.AnnotatedHandle<T>>handles)
{
}
