package org.sheepy.lily.core.api.util;

import org.logoce.lmf.core.lang.LMObject;
import org.sheepy.lily.core.model.application.Application;

public final class ModelUtil
{
	private ModelUtil()
	{
	}

	public static Application getApplication(LMObject object)
	{
		return findParent(object, Application.class);
	}

	public static <T> T findParent(LMObject object, Class<T> parentClassifier)
	{
		var current = object;
		while (current != null && !parentClassifier.isInstance(current))
		{
			current = current.lmContainer();
		}

		return parentClassifier.cast(current);
	}
}

