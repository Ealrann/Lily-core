package org.sheepy.lily.core.api.adapter.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.eclipse.emf.ecore.EObject;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Adapter
{
	Class<? extends EObject> scope();
	String name() default "";
	boolean lazy() default true;
	boolean scopeInheritance() default false;
}
