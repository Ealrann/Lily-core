package org.sheepy.lily.core.adapter;

import org.logoce.lmf.core.api.extender.IAdaptable;
import org.logoce.lmf.core.api.extender.ext.IAdaptableNameMatcher;
import org.sheepy.lily.core.model.types.LNamedElement;

import java.util.Objects;

public class AdaptableNameMatcher implements IAdaptableNameMatcher
{
	@Override
	public boolean match(final IAdaptable adaptable, final String name)
	{
		return adaptable instanceof LNamedElement namedElement && Objects.equals(namedElement.name(), name);
	}
}
