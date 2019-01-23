package org.sheepy.lily.core.api.cadence;

public interface ICommandStack
{
	void add(EditingCommand command);
	void printStats();
}
