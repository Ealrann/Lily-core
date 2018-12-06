package org.sheepy.common.api.adapter.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.sheepy.common.api.adapter.internal.ServiceAdapterFactory;

public class AutoEContentAdapter extends EContentAdapter
{
	@Override
	protected void setTarget(EObject target)
	{
		ServiceAdapterFactory.INSTANCE.loadAutoAdapters(target);
		super.setTarget(target);
	}
	
	@Override
	protected void unsetTarget(EObject target)
	{
		super.unsetTarget(target);
		ServiceAdapterFactory.INSTANCE.disposeAutoAdapters(target);
	}
}
