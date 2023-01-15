package org.sheepy.lily.core.api.allocation.annotation;

import org.sheepy.lily.core.api.allocation.IAllocationContext;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Mark a {@link org.logoce.extender.api.ModelExtender} as an Allocation object.<p>
 * Allocation objects will be instanciated following the coder defined hierarchy by {@link AllocationChild}.<p>
 * Allocation objects will be freed when their allocation is obsolete and cannot be updated<p>
 * <p>
 * If you don't declare a @UpdateDependency for a dependency, this one will be considered as crictical: if its
 * allocation is dirty, we will be considered as obsolete, and freed.<p>
 * <p>
 * You can lock an allocation (add IAllocationState in the constructor), then it won't be freed until you unlock it.<p>
 * <p>
 * After a dirty allocation is unlocked, it will be freed, excet if reuseDirtyAllocations is set to true. In this
 * case, allocations will wait until they can be reused, and won't be free until the parent is free.
 * When an allocation is reused, methods with @Update will be called
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Allocation
{
	Class<? extends IAllocationContext> context() default IAllocationContext.class;
	boolean reuseDirtyAllocations() default false;
	int activator() default -1;
}
