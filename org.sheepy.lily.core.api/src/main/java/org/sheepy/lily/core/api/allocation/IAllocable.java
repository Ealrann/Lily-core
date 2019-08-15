package org.sheepy.lily.core.api.allocation;

public interface IAllocable<T extends IAllocationContext>
{
	void allocate(T context);
	void free(T context);

	default void configureAllocation(IAllocationConfiguration configuration, T context)
	{}
}
