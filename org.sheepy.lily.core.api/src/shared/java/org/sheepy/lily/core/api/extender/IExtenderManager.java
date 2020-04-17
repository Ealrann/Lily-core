package org.sheepy.lily.core.api.extender;

import org.sheepy.lily.core.api.notification.IEMFNotifier;

import java.util.stream.Stream;

public interface IExtenderManager extends IEMFNotifier
{
	<T extends IExtender> Stream<T> adapt(Class<T> type);
	<T extends IExtender> Stream<? extends IExtenderHandle<T>> adaptHandles(Class<T> type);

	<T extends IExtender> IExtenderHandle<T> adaptHandleFromDescriptor(IExtenderDescriptor<T> descriptor);
	<T extends IExtenderHandle<?>> Stream<T> adaptHandlesOfType(Class<T> handleType);

	interface Internal extends IExtenderManager
	{
		void load();
		void dispose();
	}
}
