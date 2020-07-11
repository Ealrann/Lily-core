package org.sheepy.lily.core.allocation.instance;

import org.sheepy.lily.core.allocation.EAllocationStatus;
import org.sheepy.lily.core.api.allocation.IAllocationContext;

public record FreeContext(IAllocationContext context, boolean freeEverything)
{
	public FreeContext encapsulate(boolean forceFree)
	{
		if (freeEverything == false && forceFree)
		{
			return new FreeContext(context, true);
		}
		else
		{
			return this;
		}
	}

	public boolean freeIfObsoleteUnlocked(final AllocationInstance<?> allocation)
	{
		final var obsolete = allocation.getStatus() == EAllocationStatus.Obsolete;
		final var unlocked = allocation.isUnlocked();
		if (freeEverything || (obsolete && unlocked))
		{
			allocation.cleanup(encapsulate(true));
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean freeIfUnlocked(final AllocationInstance<?> allocation)
	{
		final var unlocked = allocation.isUnlocked();
		if (freeEverything || unlocked)
		{
			allocation.cleanup(encapsulate(true));
			return true;
		}
		else
		{
			return false;
		}
	}
}