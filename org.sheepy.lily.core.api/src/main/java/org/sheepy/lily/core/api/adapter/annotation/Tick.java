package org.sheepy.lily.core.api.adapter.annotation;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Tick
{
	/**
	 * Frequency in ms (game clock)
	 * 
	 * 0 means tick every frame.
	 * 
	 * @return
	 */
	int frequency() default 0;

	int priority() default 0;
}
