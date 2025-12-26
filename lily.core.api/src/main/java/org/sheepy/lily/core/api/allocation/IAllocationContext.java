package org.sheepy.lily.core.api.allocation;

public interface IAllocationContext
{
	default void beforeChildrenAllocation() {}
	default void afterChildrenAllocation() {}
}
