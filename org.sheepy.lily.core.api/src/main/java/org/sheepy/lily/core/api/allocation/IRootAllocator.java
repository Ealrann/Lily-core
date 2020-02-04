package org.sheepy.lily.core.api.allocation;

public interface IRootAllocator<T extends IAllocationContext>
{
	void allocate();
	void free();
	boolean isAllocationDirty();
	void reloadDirtyElements();
	boolean isAllocated();
}
