package org.sheepy.lily.core.api.allocation.annotation;

import org.logoce.lmf.core.api.extender.IAdapter;
import org.logoce.lmf.core.api.model.IFeaturedObject;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(value = AllocationDependency.AnnotationList.class)
public @interface AllocationDependency
{
	int[] features() default {};
	Class<? extends IFeaturedObject> parent() default IFeaturedObject.class;
	Class<? extends IAdapter> type();

	@Retention(RetentionPolicy.RUNTIME)
	@Target({ElementType.TYPE})
	@interface AnnotationList
	{
		AllocationDependency[] value();
	}
}
