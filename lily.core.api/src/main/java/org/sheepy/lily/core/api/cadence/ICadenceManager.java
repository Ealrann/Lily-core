package org.sheepy.lily.core.api.cadence;

import org.sheepy.lily.core.api.input.IInputManager;

public interface ICadenceManager
{
	// Tickers on cadencer clock
//	void addTicker(ITicker ticker, ETickerClock clock, int frequency);
//	void removeTicker(ITicker ticker, int freq);

	long getThreadId();

	ICommandStack getCommandStack();
	IInputManager getInputManager();
}
