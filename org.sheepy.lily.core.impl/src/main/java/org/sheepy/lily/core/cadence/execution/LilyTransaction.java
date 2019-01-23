package org.sheepy.common.cadence.execution;

public class LilyTransaction implements ILilyTransaction
{
	private final Thread owner;
	
	public LilyTransaction()
	{
		owner = Thread.currentThread();
	}
	
	@Override
	public Thread getOwner()
	{
		return owner;
	}
}
