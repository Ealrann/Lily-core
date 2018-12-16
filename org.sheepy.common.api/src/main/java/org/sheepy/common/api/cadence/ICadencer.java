package org.sheepy.common.api.cadence;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.common.api.action.context.ExecutionContext;
import org.sheepy.common.api.input.IInputManager;

public interface ICadencer
{
	// Tickers on cadencer clock
	// Step in ms
	void addTicker(ITicker ticker, int freq);
	void removeTicker(ITicker ticker, int freq);

	long getThreadId();

	ICommandStack getCommandStack();
	IInputManager getInputManager();

	void postAction(ExecutionContext ec);

	/**
	 * Delete with crossreferences
	 * 
	 * @param eo
	 * @TODO ne devrait plus être dans le cadencer
	 */
	void deleteObject(EObject eo);
}
