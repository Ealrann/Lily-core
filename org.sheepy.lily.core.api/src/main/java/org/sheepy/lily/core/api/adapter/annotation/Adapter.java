package org.sheepy.lily.core.api.adapter.annotation;

import org.eclipse.emf.ecore.EObject;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Adapter
{
	Class<? extends EObject> scope();
	String name() default "";
	boolean lazy() default true;
	boolean scopeInheritance() default false;
}
