package org.sheepy.lily.core.api.allocation.annotation;

import org.sheepy.lily.core.api.model.ILilyEObject;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(value = AllocationChild.List.class)
public @interface AllocationChild
{
	int[] features();
	Class<? extends ILilyEObject> parent() default ILilyEObject.class;

	@Retention(RetentionPolicy.RUNTIME)
	@Target({ElementType.TYPE})
	@interface List
	{
		AllocationChild[] value();
	}
}
