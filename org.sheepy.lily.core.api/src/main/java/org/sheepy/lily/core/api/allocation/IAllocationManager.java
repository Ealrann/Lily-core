package org.sheepy.lily.core.api.allocation;

public interface IAllocationManager<T extends IAllocationContext>
{
	void configure(T context);
	void allocate();
	void free();
	void freeDirtyElements();

	boolean isBranchDirty();
}
