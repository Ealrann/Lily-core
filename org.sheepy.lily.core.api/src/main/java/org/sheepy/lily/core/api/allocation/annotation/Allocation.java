package org.sheepy.lily.core.api.allocation.annotation;

import org.sheepy.lily.core.api.allocation.IAllocationContext;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Allocation
{
	Class<? extends IAllocationContext> context() default IAllocationContext.class;
	boolean reuseDirtyAllocations() default false;
	int activator() default -1;
}
