package org.sheepy.lily.core.api.resource;

import java.util.ServiceLoader;

import org.sheepy.lily.core.api.service.IService;

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

	static final IConfigurationService INSTANCE = ServiceLoader.load(IConfigurationService.class)
			.findFirst().get();
}
