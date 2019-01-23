package org.sheepy.common.api.resource;

import org.sheepy.common.api.service.IService;
import org.sheepy.common.api.service.ServiceManager;

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
