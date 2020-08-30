package org.sheepy.lily.core.allocation.test.adapters;

import org.sheepy.lily.core.api.allocation.IAllocationContext;

public final class TestContext implements IAllocationContext
{
	public final int level;

	private boolean prepared = false;

	public TestContext(final int level)
	{
		this.level = level;
	}

	@Override
	public void beforeChildrenAllocation()
	{
		prepared = true;
	}

	@Override
	public void afterChildrenAllocation()
	{
		prepared = false;
	}

	public boolean isPrepared()
	{
		return prepared;
	}
}
