package org.sheepy.lily.core.api.allocation.annotation;

import org.logoce.lmf.core.api.model.IFeaturedObject;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(value = AllocationChild.AnnotationList.class)
public @interface AllocationChild
{
	int[] features();
	Class<? extends IFeaturedObject> parent() default IFeaturedObject.class;
	boolean allocateBeforeParent() default false;

	@Retention(RetentionPolicy.RUNTIME)
	@Target({ElementType.TYPE})
	@interface AnnotationList
	{
		AllocationChild[] value();
	}
}
