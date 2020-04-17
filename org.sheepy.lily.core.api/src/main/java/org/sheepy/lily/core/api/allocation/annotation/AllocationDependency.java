package org.sheepy.lily.core.api.allocation.annotation;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.model.ILilyEObject;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(value = AllocationDependency.AnnotationList.class)
public @interface AllocationDependency
{
	int[] features() default {};
	Class<? extends ILilyEObject> parent() default ILilyEObject.class;
	Class<? extends IExtender> type();

	@Retention(RetentionPolicy.RUNTIME)
	@Target({ElementType.TYPE})
	@interface AnnotationList
	{
		AllocationDependency[] value();
	}
}
