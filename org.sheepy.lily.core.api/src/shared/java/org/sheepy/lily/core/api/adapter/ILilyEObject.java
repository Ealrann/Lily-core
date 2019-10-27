package org.sheepy.lily.core.api.adapter;

import org.eclipse.emf.ecore.EObject;

public interface ILilyEObject extends EObject
{
	<T extends IAdapter> T adapt(Class<T> type);
	<T extends IAdapter> T adaptNotNull(Class<T> type);
}
