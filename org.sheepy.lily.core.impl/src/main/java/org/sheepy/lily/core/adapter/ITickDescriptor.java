package org.sheepy.lily.core.adapter;

public interface ITickDescriptor
{
	int getFrequency();

	void tick(long stepNs);

	String getName();

	int getPriority();
}
