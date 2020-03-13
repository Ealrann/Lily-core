package org.sheepy.lily.core.api.adapter.annotation;

import java.lang.annotation.*;

/**
 * This method will be called when the object is loaded.
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Observe
{
}
