package org.sheepy.lily.core.api.extender;

import java.util.stream.Stream;

public interface IExtenderManager
{
	<T extends IExtender> Stream<T> adapt(Class<T> type);
	<T extends IExtender> Stream<? extends IExtenderHandle<T>> adaptHandles(Class<T> type);

	<T extends IExtender> IExtenderHandle<T> adaptHandleFromDescriptor(IExtenderDescription<T> descriptor);
	<T extends IExtenderHandle<?>> Stream<T> adaptHandlesOfType(Class<T> handleType);

	interface Internal extends IExtenderManager
	{
		void deploy();
		void load();
		void dispose();
	}
}
