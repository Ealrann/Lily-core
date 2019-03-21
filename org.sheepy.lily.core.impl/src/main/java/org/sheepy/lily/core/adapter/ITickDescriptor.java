package org.sheepy.lily.core.adapter;

public interface ITickDescriptor
{
	int getFrequency();

	void tick(int frequencyToTick);

	String getName();
}
