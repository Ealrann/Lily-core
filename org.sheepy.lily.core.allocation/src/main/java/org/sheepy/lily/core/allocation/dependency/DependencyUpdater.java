package org.sheepy.lily.core.allocation.dependency;

import org.sheepy.lily.core.allocation.EAllocationStatus;
import org.sheepy.lily.core.allocation.dependency.container.IDependencyContainer;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.reflect.ConsumerHandle;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public final class DependencyUpdater
{
	private final DependencyResolver resolver;
	private final ConsumerHandle updateHandle;
	private List<IDependencyContainer> currentAllocations = List.of();
	private Consumer<EAllocationStatus> statusListener;

	public DependencyUpdater(final DependencyResolver resolver, ILilyEObject target, final ConsumerHandle updateHandle)
	{
		this.resolver = resolver;
		this.updateHandle = updateHandle;
		resolve(target);
	}

	public boolean isDirty()
	{
		return currentAllocations.stream().anyMatch(IDependencyContainer::isAllocationDirty);
	}

	public void update(ILilyEObject target)
	{
		assert isDirty() == true;
		resolve(target);
		final var allocations = currentAllocations.stream()
												  .map(IDependencyContainer::get)
												  .collect(Collectors.toUnmodifiableList());
		updateHandle.invoke(allocations);
	}

	private void resolve(ILilyEObject target)
	{
		if (statusListener != null) sulk(statusListener);
		currentAllocations = resolver.resolveDependencies(target).collect(Collectors.toUnmodifiableList());
		if (statusListener != null) listen(statusListener);
	}

	public DependencyResolver resolver()
	{
		return resolver;
	}

	public void listen(final Consumer<EAllocationStatus> statusListener)
	{
		assert this.statusListener == null;
		this.statusListener = statusListener;
		for (final var allocation : currentAllocations)
		{
			allocation.listen(statusListener);
		}
	}

	public void sulk(final Consumer<EAllocationStatus> statusListener)
	{
		assert this.statusListener != null;
		for (final var allocation : currentAllocations)
		{
			allocation.sulk(statusListener);
		}
		this.statusListener = null;
	}
}
