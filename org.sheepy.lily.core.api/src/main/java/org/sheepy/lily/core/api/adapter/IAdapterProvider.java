package org.sheepy.lily.core.api.adapter;

import java.util.List;

import org.sheepy.lily.core.api.service.IService;

public interface IAdapterProvider extends IService
{
	List<Class<? extends IAdapter>> classifiers();
}
