package org.sheepy.common.api.cadence;

import java.util.ServiceLoader;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.common.api.service.IService;
import org.sheepy.common.model.application.Application;

public interface ICadencer extends IService
{
	// Tickers on cadencer clock
	// Step in ms
	void addTicker(ITicker ticker, int freq);
	void removeTicker(ITicker ticker, int freq);
	
	long getThreadId();

	ICommandStack getCommandStack();

	void start(Application application);
	void stop();

	/**
	 * Delete with crossreferences
	 * 
	 * @param eo
	 * @TODO ne devrait plus être dans le cadencer
	 */
	void deleteObject(EObject eo);

	static ICadencer INSTANCE = ServiceLoader.load(ICadencer.class).findFirst().get();
}
