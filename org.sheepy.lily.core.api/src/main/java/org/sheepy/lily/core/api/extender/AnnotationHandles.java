package org.sheepy.lily.core.api.extender;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.stream.Stream;

public final class AnnotationHandles<T extends Annotation>
{
	private final Class<T> annotationClass;
	private final List<IExtenderHandle.AnnotatedHandle<T>> handles;

	public AnnotationHandles(Class<T> annotationClass, List<IExtenderHandle.AnnotatedHandle<T>> handles)
	{
		this.annotationClass = annotationClass;
		this.handles = handles;
	}

	public Class<T> annotationClass()
	{
		return annotationClass;
	}

	public List<IExtenderHandle.AnnotatedHandle<T>> handles()
	{
		return handles;
	}

	public boolean match(Class<? extends Annotation> classifier)
	{
		return annotationClass == classifier;
	}

	public Stream<IExtenderHandle.AnnotatedHandle<T>> stream()
	{
		return handles.stream();
	}
}
