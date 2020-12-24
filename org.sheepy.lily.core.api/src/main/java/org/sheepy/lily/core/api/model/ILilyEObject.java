package org.sheepy.lily.core.api.model;

import org.eclipse.emf.ecore.InternalEObject;
import org.sheepy.lily.core.api.extender.IAdaptable;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderManager;
import org.sheepy.lily.core.api.notification.IEMFNotifier;

import java.util.stream.Stream;

public interface ILilyEObject extends InternalEObject, IEMFNotifier, IAdaptable
{
	Stream<ILilyEObject> streamChildren();
	Stream<ILilyEObject> streamTree();

	@Override
	<T extends IExtender> T adapt(Class<T> type);
	@Override
	<T extends IExtender> T adapt(Class<T> type, String identifier);
	<T extends IExtender> T adaptNotNull(Class<T> type);
	<T extends IExtender> T adaptNotNull(Class<T> type, String identifier);

	<T extends IExtender> T adaptGeneric(Class<? extends IExtender> type);
	<T extends IExtender> T adaptNotNullGeneric(Class<? extends IExtender> type);
}
