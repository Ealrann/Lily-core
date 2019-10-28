package org.sheepy.lily.core.api.adapter;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public interface ILilyEObject extends EObject
{
	<T extends IAdapter> T adapt(Class<T> type);
	<T extends IAdapter> T adaptNotNull(Class<T> type);

	<T extends IAdapter> T adaptGeneric(Class<? extends IAdapter> type);
	<T extends IAdapter> T adaptNotNullGeneric(Class<? extends IAdapter> type);

	void addListener(INotificationListener listener, List<EStructuralFeature> features);
	void removeListener(INotificationListener listener, List<EStructuralFeature> features);
}
