package org.sheepy.lily.core.api.adapter;

import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public interface IAdapterManager extends Adapter
{
	<T extends IAdapter> T adapt(EObject target, Class<T> type);

	void addListener(INotificationListener listener, List<EStructuralFeature> features);
	void removeListener(INotificationListener listener, List<EStructuralFeature> features);
}
