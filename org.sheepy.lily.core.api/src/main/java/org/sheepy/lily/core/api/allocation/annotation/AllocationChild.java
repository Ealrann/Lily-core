package org.sheepy.lily.core.api.allocation.annotation;

import org.sheepy.lily.core.api.model.ILilyEObject;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(value = AllocationChild.AnnotationList.class)
public @interface AllocationChild
{
	int[] features();
	Class<? extends ILilyEObject> parent() default ILilyEObject.class;
	boolean allocateBeforeParent() default false;

	@Retention(RetentionPolicy.RUNTIME)
	@Target({ElementType.TYPE})
	@interface AnnotationList
	{
		AllocationChild[] value();
	}
}
