package org.sheepy.common.api.cadence;

public interface ICommandStack
{
	void add(EditingCommand command);
	void printStats();
}
