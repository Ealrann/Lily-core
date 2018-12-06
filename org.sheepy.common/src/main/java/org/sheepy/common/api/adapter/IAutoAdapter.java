package org.sheepy.common.api.adapter;

import org.eclipse.emf.ecore.EObject;

public interface IAutoAdapter extends ISingletonAdapter
{
	void load(EObject target);
	
	void dispose(EObject target);
}
