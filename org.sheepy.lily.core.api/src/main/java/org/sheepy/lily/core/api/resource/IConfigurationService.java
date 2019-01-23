package org.sheepy.lily.core.api.resource;

import org.sheepy.lily.core.api.service.IService;
import org.sheepy.lily.core.api.service.ServiceManager;

public interface IConfigurationService extends IService
{
	boolean isDebug();

	String getDataPath();

	String getDefinitionPath();

	@Deprecated
	// TODO ça n'est pas du core...
	String getSavePath();

	@Deprecated
	// TODO ça n'est pas du core...
	String getMusicPath();

	@Deprecated
	// TODO ça n'est pas du core...
	String getAssetsPath();

	static IConfigurationService getService()
	{
		return ServiceManager.getService(IConfigurationService.class);
	}
}
