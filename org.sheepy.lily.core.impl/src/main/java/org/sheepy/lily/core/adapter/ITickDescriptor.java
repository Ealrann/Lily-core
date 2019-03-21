package org.sheepy.lily.core.adapter;

public interface ITickDescriptor
{
	int getFrequency();

	void tick(long stepNano);

	String getName();

	int getPriority();
}
