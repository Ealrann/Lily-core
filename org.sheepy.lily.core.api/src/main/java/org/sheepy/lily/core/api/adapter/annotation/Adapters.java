package org.sheepy.lily.core.api.adapter.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.sheepy.lily.core.api.adapter.IAdapter;

@Target(ElementType.MODULE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Adapters
{
	Class<? extends IAdapter>[] classifiers();
}
