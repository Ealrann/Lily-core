package org.sheepy.lily.core.api.cadence;

public interface ITicker
{
	/**
	 * @param step
	 *            in ms
	 */
	void tick(long stepNano);

	String getLabel();

	default int getPriority()
	{
		return 0;
	}
}
