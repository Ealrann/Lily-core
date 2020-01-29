package org.sheepy.lily.core.api.cadence;

public interface ITicker
{
	/**
	 * @param stepNs
	 */
	void tick(long stepNs);

	String getLabel();
	@SuppressWarnings("SameReturnValue")
	default int getPriority()
	{
		return 0;
	}
}
