package org.sheepy.lily.core.adapter;

import org.logoce.extender.api.IAdaptable;
import org.logoce.extender.ext.IAdaptableNameMatcher;
import org.sheepy.lily.core.model.types.LNamedElement;

public class AdaptableNameMatcher implements IAdaptableNameMatcher
{
	@Override
	public boolean match(final IAdaptable adaptable, final String name)
	{
		return adaptable instanceof LNamedElement namedElement && namedElement.getName()
																			  .equals(name);
	}
}
