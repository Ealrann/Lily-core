package org.sheepy.lily.core.api.extender;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.extender.parameter.IParameterResolverBuilder;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.core.api.util.AnnotationHandles;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.stream.Stream;

public interface IExtenderDescriptor<T extends IExtender>
{
	Class<T> extenderClass();
	EClass targetEClass();
	boolean isExtenderForType(Class<?> allocationAdapterType);
	boolean isApplicable(EObject target);
	boolean containsMethodAnnotation(Class<? extends Annotation> annotationClass);
	boolean containsClassAnnotation(Class<? extends Annotation> annotationClass);
	<A extends Annotation> Stream<A> streamMethodAnnotations(Class<A> annotationClass);
	ExtenderContext<T> newExtender(ILilyEObject target,
								   IObservatoryBuilder observatory,
								   List<? extends IParameterResolverBuilder> resolvers) throws ReflectiveOperationException;

	record ExtenderContext<T extends IExtender>(T extender, List<? extends AnnotationHandles<?>>annotationHandles)
	{
	}
}
