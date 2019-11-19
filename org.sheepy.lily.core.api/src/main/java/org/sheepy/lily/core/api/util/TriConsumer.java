package org.sheepy.lily.core.api.util;

@FunctionalInterface
public interface TriConsumer<T, U, V>
{
	void accept(T p1, U p2, V p3);
}
