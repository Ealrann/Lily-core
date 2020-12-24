package org.sheepy.lily.core.api.extender;

public interface IAdaptable
{
	IExtenderManager adapterManager();

	default <T extends IExtender> T adapt(Class<T> type)
	{
		return adapterManager().adapt(type);
	}

	default <T extends IExtender> T adapt(Class<T> type, String identifier)
	{
		return adapterManager().adapt(type, identifier);
	}
}
