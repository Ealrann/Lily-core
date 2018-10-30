package org.sheepy.common.api.service;

public interface IService {

	default int getPriority()
	{
		return 0;
	}
}
