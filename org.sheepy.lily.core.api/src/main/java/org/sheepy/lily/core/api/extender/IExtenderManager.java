package org.sheepy.lily.core.api.extender;

import java.util.stream.Stream;

public interface IExtenderManager
{
	<T extends IExtender> T adapt(Class<T> type);
	<T extends IExtender> T adapt(Class<T> type, String identifier);
	<T extends IExtender> Stream<? extends IExtenderHandle<T>> adaptHandles(Class<T> type);

	<T extends IExtender> IExtenderHandle<T> adaptHandleFromDescriptor(IExtenderDescription<T> descriptor);
	<T extends IExtenderHandle<?>> Stream<T> adaptHandlesOfType(Class<T> handleType);

	interface Internal extends IExtenderManager
	{
		void load();
		void dispose();
	}
}
