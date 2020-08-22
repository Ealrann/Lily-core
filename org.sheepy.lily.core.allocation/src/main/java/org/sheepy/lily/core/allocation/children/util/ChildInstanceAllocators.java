package org.sheepy.lily.core.allocation.children.util;

import org.sheepy.lily.core.allocation.children.instance.ChildInstanceAllocator;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.util.StreamUtil;

import java.util.List;
import java.util.stream.Stream;

public record ChildInstanceAllocators(ILilyEObject target, List<ChildInstanceAllocator<?>> instanceAllocators)
{
	public Stream<ChildInstanceAllocator<?>> stream()
	{
		return instanceAllocators().stream();
	}

	public Stream<ChildInstanceAllocator<?>> reverseStream()
	{
		return StreamUtil.reverseStream(instanceAllocators());
	}
}
