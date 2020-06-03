package org.sheepy.lily.core.allocation.parameter;

import org.sheepy.lily.core.allocation.AllocationConfigurator;
import org.sheepy.lily.core.api.allocation.annotation.InjectConfigurator;
import org.sheepy.lily.core.api.extender.parameter.IParameterResolver;
import org.sheepy.lily.core.api.extender.parameter.IParameterResolverBuilder;
import org.sheepy.lily.core.api.model.ILilyEObject;

import java.lang.annotation.Annotation;
import java.util.Optional;

public final class ConfiguratorParameterBuilder implements IParameterResolverBuilder, IParameterResolver
{
	private AllocationConfigurator configurator = null;

	@Override
	public Object resolve()
	{
		return configurator;
	}

	@Override
	public Optional<? extends IParameterResolver> tryBuild(final ILilyEObject target,
														   final Class<?> parameterClass,
														   final Annotation parameterAnnotation)
	{
		if (parameterAnnotation instanceof InjectConfigurator)
		{
			if (configurator == null)
			{
				configurator = new AllocationConfigurator();
			}
			return Optional.of(this);
		}
		else
		{
			return Optional.empty();
		}
	}

	public AllocationConfigurator getConfigurator()
	{
		return configurator;
	}
}
