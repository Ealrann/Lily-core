package org.sheepy.lily.core.allocation.description;

import org.sheepy.lily.core.allocation.dependency.DependencyResolver;
import org.sheepy.lily.core.allocation.dependency.container.IDependencyContainer;
import org.sheepy.lily.core.api.reflect.ConsumerHandle;

import java.util.List;
import java.util.stream.Collectors;

public final class DependencyPointer
{
	private final DependencyResolver resolver;
	private final ConsumerHandle updateHandle;
	private List<IDependencyContainer> currentAllocations;

	public DependencyPointer(final DependencyResolver resolver, final ConsumerHandle updateHandle)
	{
		this.resolver = resolver;
		this.updateHandle = updateHandle;
		resolve();
	}

	public boolean isDirty()
	{
		return currentAllocations.stream().anyMatch(IDependencyContainer::isAllocationDirty);
	}

	public void update()
	{
		assert isDirty() == true;
		resolve();
		final var allocations = currentAllocations.stream()
												  .map(IDependencyContainer::get)
												  .collect(Collectors.toUnmodifiableList());
		updateHandle.invoke(allocations);
	}

	private void resolve()
	{
		currentAllocations = resolver.streamDependencies().collect(Collectors.toUnmodifiableList());
	}

	public DependencyResolver resolver()
	{
		return resolver;
	}
}
