package org.sheepy.lily.core.api.cadence;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.api.input.IInputManager;

public interface ICadenceManager
{
//	// Tickers on cadencer clock
//	// Step in ms
//	void addTicker(ITicker ticker, ETickerClock clock, int frequency);
//	void removeTicker(ITicker ticker, int freq);

	long getThreadId();

	ICommandStack getCommandStack();
	IInputManager getInputManager();
}
