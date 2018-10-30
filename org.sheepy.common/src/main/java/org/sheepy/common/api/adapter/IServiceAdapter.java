package org.sheepy.common.api.adapter;

import java.util.Iterator;
import java.util.ServiceLoader;

import org.eclipse.emf.ecore.EClass;
import org.sheepy.common.api.service.IStandaloneService;

public interface IServiceAdapter extends IStandaloneService, Cloneable
{

	boolean isAdapterForType(Class<? extends IServiceAdapter> type);

	boolean isApplicable(EClass eClass);

	IServiceAdapterFactory getAdapterFactory();

	void setAdapterFactory(IServiceAdapterFactory adapterFactory);

	IServiceAdapter clone();

	static Iterator<IServiceAdapter> getServices()
	{
		return ServiceLoader.load(IServiceAdapter.class).iterator();
	}
	
}
