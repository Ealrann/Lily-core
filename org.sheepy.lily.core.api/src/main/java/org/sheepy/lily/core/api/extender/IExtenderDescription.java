package org.sheepy.lily.core.api.extender;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import java.lang.annotation.Annotation;
import java.util.stream.Stream;

public interface IExtenderDescription<T extends IExtender>
{
	Class<T> extenderClass();
	boolean isExtenderForType(Class<?> allocationAdapterType);
	boolean isApplicable(EObject target);
	boolean containsMethodAnnotation(Class<? extends Annotation> annotationClass);
	boolean containsClassAnnotation(Class<? extends Annotation> annotationClass);
	<A extends Annotation> Stream<A> streamMethodAnnotations(Class<A> annotationClass);
	EClass targetEClass();
}
