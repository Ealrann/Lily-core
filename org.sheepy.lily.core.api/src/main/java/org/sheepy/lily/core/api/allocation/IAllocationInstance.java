package org.sheepy.lily.core.api.allocation;

import org.sheepy.lily.core.api.extender.IExtender;

public interface IAllocationInstance<Allocation extends IExtender>
{
	void update(IAllocationContext context);
	void cleanup(IAllocationContext context);
	void free(IAllocationContext context);
	Allocation getAllocation();
	boolean isDirty();
}
