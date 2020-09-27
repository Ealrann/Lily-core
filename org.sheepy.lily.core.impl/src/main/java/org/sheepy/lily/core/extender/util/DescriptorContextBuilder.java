package org.sheepy.lily.core.extender.util;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderHandleFactory;
import org.sheepy.lily.core.extender.DescriptorContext;
import org.sheepy.lily.core.extender.ExtenderDescriptor;

import java.lang.reflect.MalformedParameterizedTypeException;

public record DescriptorContextBuilder<T extends IExtender>(ExtenderDescriptor<T> descriptor)
{
	public static <T extends IExtender> DescriptorContext<T> build(final ExtenderDescriptor<T> descriptor)
	{
		return new DescriptorContextBuilder<>(descriptor).build();
	}

	public DescriptorContext<T> build()
	{
		return IExtenderHandleFactory.FACTORIES.stream()
											   .filter(this::isFactoryApplicable)
											   .map(this::newContext)
											   .findAny()
											   .orElseThrow(this::throwNoSecondaryAnnotation);
	}

	private DescriptorContext<T> newContext(final IExtenderHandleFactory f)
	{
		final var handleBuilder = f.newBuilder(descriptor);
		return new DescriptorContext<>(descriptor, handleBuilder);
	}

	private boolean isFactoryApplicable(final IExtenderHandleFactory f)
	{
		return descriptor.containsClassAnnotation(f.describedBy());
	}

	private MalformedParameterizedTypeException throwNoSecondaryAnnotation()
	{
		return new MalformedParameterizedTypeException("Model extender " + descriptor.extenderClass()
																					 .getSimpleName() + " should define one handle annotation (e.g: @Adapter, @Allocation)");
	}
}
