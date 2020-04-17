package org.sheepy.lily.core.api.model;

import org.eclipse.emf.ecore.InternalEObject;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderManager;
import org.sheepy.lily.core.api.notification.IEMFNotifier;

import java.util.List;
import java.util.stream.Stream;

public interface ILilyEObject extends InternalEObject, IEMFNotifier
{
	List<Object> storage();

	Stream<ILilyEObject> streamChildren();
	Stream<ILilyEObject> streamAllChildren();

	<T extends IExtender> T adapt(Class<T> type);
	<T extends IExtender> T adaptNotNull(Class<T> type);

	<T extends IExtender> T adaptGeneric(Class<? extends IExtender> type);
	<T extends IExtender> T adaptNotNullGeneric(Class<? extends IExtender> type);

	IExtenderManager adapters();
}
