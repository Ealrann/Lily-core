package org.sheepy.lily.core.api.extender;

import java.lang.invoke.MethodHandles;
import java.util.List;

public interface IExtenderProvider
{
	List<Class<? extends IExtender>> classifiers();
	MethodHandles.Lookup lookup();
}
