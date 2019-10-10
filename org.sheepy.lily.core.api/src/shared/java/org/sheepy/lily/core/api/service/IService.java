package org.sheepy.lily.core.api.service;

public interface IService {

	default int getPriority()
	{
		return 0;
	}
}
