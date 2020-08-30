package org.sheepy.lily.core.allocation.dependency;

import org.sheepy.lily.core.allocation.dependency.container.DependencyContainer;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;

import java.util.List;
import java.util.stream.Collectors;

public final class DependencyWatcher
{
	private final DependencyResolver resolver;
	private final Runnable onResolutionObsolete;
	private List<DependencyContainer> currentAllocations = List.of();

	private boolean structureChanged = false;

	public DependencyWatcher(final DependencyResolver resolver,
							 final ILilyEObject target,
							 final IObservatoryBuilder observatoryBuilder,
							 final Runnable onResolutionObsolete)
	{
		this.resolver = resolver;
		this.onResolutionObsolete = onResolutionObsolete;
		resolve(target);
		resolver.installStructureListener(target, observatoryBuilder, this::structureChange);
	}

	public void update(ILilyEObject target)
	{
		resolve(target);
	}

	public List<DependencyContainer> getResolvedAllocations()
	{
		return currentAllocations;
	}

	public void free()
	{
		currentAllocations.forEach(DependencyContainer::free);
	}

	private void resolve(ILilyEObject target)
	{
		currentAllocations.forEach(DependencyContainer::free);
		currentAllocations = resolver.resolveDependencies(target, onResolutionObsolete)
									 .collect(Collectors.toUnmodifiableList());
		structureChanged = false;
	}

	public boolean isDirty()
	{
		return structureChanged || currentAllocations.stream().anyMatch(DependencyContainer::isDirty);
	}

	private void structureChange()
	{
		onResolutionObsolete.run();
		structureChanged = true;
	}

	public static record Builder(DependencyResolver resolver, ILilyEObject target)
	{
		public DependencyWatcher build(final IObservatoryBuilder observatoryBuilder,
									   final Runnable onResolutionObsolete)
		{
			return new DependencyWatcher(resolver, target, observatoryBuilder, onResolutionObsolete);
		}

		public int index()
		{
			return resolver.getIndex();
		}
	}
}
