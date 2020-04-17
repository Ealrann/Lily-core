package org.sheepy.lily.core.api.extender;

import java.util.List;

public interface IExtenderProvider
{
	List<Class<? extends IExtender>> classifiers();
}
