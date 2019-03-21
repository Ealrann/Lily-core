package org.sheepy.lily.core.adapter;

import java.util.Collection;

public interface ITickDescriptor
{
	boolean isTicker();

	Collection<Integer> getTickFrequencies();

	void tick(int frequencyToTick);

	String getName();
}
