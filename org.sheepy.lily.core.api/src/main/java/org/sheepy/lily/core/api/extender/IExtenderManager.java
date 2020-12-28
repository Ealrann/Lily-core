package org.sheepy.lily.core.api.extender;

import java.util.stream.Stream;

public interface IExtenderManager
{
	<T extends IExtender> T adapt(Class<T> type);
	<T extends IExtender> T adapt(Class<T> type, String identifier);

	Stream<IExtenderDescriptor<?>> availableDescriptors();
	<T extends IExtender> IExtenderHandle<T> adaptHandle(IExtenderDescriptor<T> descriptor);
	<T extends IExtenderHandle<?>> Stream<T> adaptHandlesOfType(final Class<T> handleType);

	@SuppressWarnings("unchecked")
	default <T extends IExtender> Stream<IExtenderDescriptor<T>> availableDescriptors(Class<T> type)
	{
		return availableDescriptors().filter(descriptor -> descriptor.match(type))
									 .map(descriptor -> (IExtenderDescriptor<T>) descriptor);
	}

	default <T extends IExtender> Stream<IExtenderHandle<T>> adaptHandles(Class<T> type)
	{
		return availableDescriptors(type).map(this::adaptHandle);
	}

	interface Internal extends IExtenderManager
	{
		void load();
		void dispose();
	}
}
