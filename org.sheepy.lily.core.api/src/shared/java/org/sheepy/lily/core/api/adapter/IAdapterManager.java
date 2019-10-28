package org.sheepy.lily.core.api.adapter;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;

public interface IAdapterManager extends Adapter
{
	<T extends IAdapter> T adapt(EObject target, Class<T> type);
}
