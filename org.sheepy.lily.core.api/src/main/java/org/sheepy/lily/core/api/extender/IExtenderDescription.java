package org.sheepy.lily.core.api.extender;

import java.lang.annotation.Annotation;
import java.util.stream.Stream;

public interface IExtenderDescription<T extends IExtender>
{
	Class<T> extenderClass();
	boolean match(Class<? extends IExtender> classifier);
	boolean match(Class<? extends IExtender> classifier, String identifier);
	boolean isApplicable(Object target);
	boolean containsMethodAnnotation(Class<? extends Annotation> annotationClass);
	boolean containsClassAnnotation(Class<? extends Annotation> annotationClass);
	<A extends Annotation> Stream<A> streamMethodAnnotations(Class<A> annotationClass);
}
