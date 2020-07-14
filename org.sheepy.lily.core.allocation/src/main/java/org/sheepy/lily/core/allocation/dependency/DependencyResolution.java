package org.sheepy.lily.core.allocation.dependency;

import org.sheepy.lily.core.allocation.EAllocationStatus;
import org.sheepy.lily.core.allocation.dependency.container.IDependencyContainer;
import org.sheepy.lily.core.api.model.ILilyEObject;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public final class DependencyResolution
{
	private final DependencyResolver resolver;
	private final Runnable structureChange = this::structureChange;
	private final Consumer<EAllocationStatus> statusListener;
	private List<IDependencyContainer> currentAllocations = List.of();

	public DependencyResolution(final DependencyResolver resolver,
								final ILilyEObject target,
								final Consumer<EAllocationStatus> statusListener)
	{
		this.resolver = resolver;
		this.statusListener = statusListener;
		resolver.listen(structureChange);
		resolve(target);
	}

	public void update(ILilyEObject target)
	{
		resolve(target);
	}

	public List<IDependencyContainer> getResolvedAllocations()
	{
		return currentAllocations;
	}

	public void free()
	{
		resolver.sulk(structureChange);
		if (statusListener != null) sulk();
	}

	private void resolve(ILilyEObject target)
	{
		if (statusListener != null) sulk();
		currentAllocations = resolver.resolveDependencies(target).collect(Collectors.toUnmodifiableList());
		if (statusListener != null) listen();
	}

	public boolean isDirty()
	{
		return currentAllocations.stream().anyMatch(IDependencyContainer::isAllocationDirty);
	}

	private void structureChange()
	{
		if (statusListener != null) statusListener.accept(EAllocationStatus.Obsolete);
	}

	private void listen()
	{
		if (statusListener != null)
		{
			for (final var allocation : currentAllocations)
			{
				allocation.listen(statusListener);
			}
		}
	}

	public void sulk()
	{
		if (statusListener != null)
		{
			for (final var allocation : currentAllocations)
			{
				allocation.sulk(statusListener);
			}
		}
	}

	public static record Builder(DependencyResolver resolver, ILilyEObject target)
	{
		public DependencyResolution build(final Consumer<EAllocationStatus> statusListener)
		{
			return new DependencyResolution(resolver, target, statusListener);
		}

		public int index()
		{
			return resolver.getIndex();
		}
	}
}
