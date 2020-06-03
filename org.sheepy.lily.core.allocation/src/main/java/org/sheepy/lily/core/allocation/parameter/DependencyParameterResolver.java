package org.sheepy.lily.core.allocation.parameter;

import org.sheepy.lily.core.allocation.dependency.DependencyResolver;
import org.sheepy.lily.core.allocation.dependency.container.IDependencyContainer;
import org.sheepy.lily.core.api.extender.parameter.IParameterResolver;

import java.util.List;
import java.util.stream.Collectors;

public record DependencyParameterResolver(Class<?>parameterClass, DependencyResolver resolver) implements
																							   IParameterResolver
{
	@Override
	public Object resolve()
	{
		final var stream = resolver.streamDependencies().map(IDependencyContainer::get);
		if (parameterClass == List.class)
		{
			return stream.collect(Collectors.toUnmodifiableList());
		}
		else
		{
			return stream.findAny().orElse(null);
		}
	}
}
