package org.sheepy.lily.core.extender;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderDescriptor;
import org.sheepy.lily.core.api.extender.IExtenderHandle;
import org.sheepy.lily.core.api.extender.IExtenderHandleBuilder;
import org.sheepy.lily.core.api.model.ILilyEObject;

public record DescriptorContext<T extends IExtender>(IExtenderDescriptor<T> descriptor,
													 IExtenderHandleBuilder<T> handleBuilder)
{
	public IExtenderHandle<T> newHandle(ILilyEObject target)
	{
		return handleBuilder.build(target);
	}
}
