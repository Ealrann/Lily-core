package org.sheepy.lily.core.api.util;

import org.sheepy.lily.core.api.extender.IExtenderHandle;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.stream.Stream;

public record AnnotationHandles<T extends Annotation>(Class<T>annotationClass,
													  List<IExtenderHandle.AnnotatedHandle<T>>handles)
{
	public boolean match(Class<? extends Annotation> classifier)
	{
		return annotationClass == classifier;
	}

	public Stream<IExtenderHandle.AnnotatedHandle<T>> stream()
	{
		return handles.stream();
	}
}
