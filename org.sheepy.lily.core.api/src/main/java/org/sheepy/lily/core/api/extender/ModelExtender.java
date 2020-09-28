package org.sheepy.lily.core.api.extender;

import org.eclipse.emf.ecore.EObject;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ModelExtender
{
	Class<? extends EObject> scope();
	String name() default "";
	String identifier() default "";
	boolean inherited() default false;
}
