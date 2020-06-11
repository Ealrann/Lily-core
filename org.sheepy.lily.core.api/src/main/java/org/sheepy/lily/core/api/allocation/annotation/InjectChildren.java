package org.sheepy.lily.core.api.allocation.annotation;

import org.sheepy.lily.core.api.extender.IExtender;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface InjectChildren
{
	int index();
	Class<? extends IExtender> type();
}
