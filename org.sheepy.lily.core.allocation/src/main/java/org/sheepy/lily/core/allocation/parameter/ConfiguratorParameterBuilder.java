package org.sheepy.lily.core.allocation.parameter;

import org.sheepy.lily.core.allocation.AllocationConfigurator;
import org.sheepy.lily.core.api.allocation.IAllocationConfigurator;
import org.sheepy.lily.core.api.extender.parameter.IParameterResolver;
import org.sheepy.lily.core.api.model.ILilyEObject;

import java.lang.annotation.Annotation;

public final class ConfiguratorParameterBuilder implements IParameterResolver
{
	private AllocationConfigurator configurator = null;

	@Override
	public boolean isApplicable(final Class<?> parameterClass, final Annotation parameterAnnotation)
	{
		return parameterClass == IAllocationConfigurator.class;
	}

	@Override
	public Object resolve(ILilyEObject target, Class<?> paramClass)
	{
		if (configurator == null)
		{
			configurator = new AllocationConfigurator();
		}
		return configurator;
	}

	public AllocationConfigurator getConfigurator()
	{
		return configurator;
	}
}
