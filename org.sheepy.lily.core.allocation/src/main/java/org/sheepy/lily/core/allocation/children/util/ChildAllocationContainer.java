package org.sheepy.lily.core.allocation.children.util;

import org.sheepy.lily.core.allocation.children.instance.ChildInstanceAllocator;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.util.StreamUtil;

import java.util.List;
import java.util.stream.Stream;

public record ChildAllocationContainer(ILilyEObject target, List<ChildInstanceAllocator<?>>containers)
{
	public Stream<ChildInstanceAllocator<?>> streamContainers()
	{
		return containers.stream();
	}

	public Stream<ChildInstanceAllocator<?>> reverseStreamContainers()
	{
		return StreamUtil.reverseStream(containers);
	}
}
