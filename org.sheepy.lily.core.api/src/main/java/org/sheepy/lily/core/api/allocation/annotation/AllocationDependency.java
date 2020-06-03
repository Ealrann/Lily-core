package org.sheepy.lily.core.api.allocation.annotation;

import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.extender.IExtender;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(value = AllocationDependency.AnnotationList.class)
public @interface AllocationDependency
{
	int[] features();
	Class<? extends ILilyEObject> parent() default ILilyEObject.class;
	Class<? extends IExtender> type();

	@Retention(RetentionPolicy.RUNTIME)
	@Target({ElementType.TYPE})
	@interface AnnotationList
	{
		AllocationDependency[] value();
	}
}
