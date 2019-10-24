package org.sheepy.lily.core.api.cadence;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.api.action.context.ActionExecutionContext;
import org.sheepy.lily.core.api.input.IInputManager;

public interface ICadencer
{
	// Tickers on cadencer clock
	// Step in ms
	void addTicker(ITicker ticker, ETickerClock clock, int frequency);
	void removeTicker(ITicker ticker, int freq);

	long getThreadId();

	ICommandStack getCommandStack();
	IInputManager getInputManager();

	void postAction(ActionExecutionContext ec);

	/**
	 * Delete with crossreferences
	 * 
	 * @param eo
	 * @TODO ne devrait plus être dans le cadencer
	 */
	void deleteObject(EObject eo);
}
