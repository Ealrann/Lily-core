package org.sheepy.lily.core.api.extender;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ModelExtender
{
	Class<? extends IAdaptable> scope();
	String name() default "";
	String identifier() default "";
	boolean inherited() default false;
}
