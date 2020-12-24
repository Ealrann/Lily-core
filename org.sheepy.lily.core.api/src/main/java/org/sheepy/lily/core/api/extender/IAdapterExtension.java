package org.sheepy.lily.core.api.extender;

import org.sheepy.lily.core.api.extender.parameter.IParameterResolver;

import java.util.Optional;

public interface IAdapterExtension
{
	void load(final IAdaptable target);
	void dispose(final IAdaptable target);
	boolean isEmpty();

	@FunctionalInterface
	interface Descriptor
	{
		Builder newBuilder();
	}

	interface Builder
	{
		IAdapterExtension build(IExtenderDescriptor.ExtenderContext<?> context);
		Optional<IParameterResolver> parameterResolver();
	}
}
