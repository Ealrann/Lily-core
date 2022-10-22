package org.sheepy.lily.core.allocation.dependency;

import org.sheepy.lily.core.allocation.dependency.container.DependencyContainer;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;

import java.util.Deque;

public final class DependencyWatcher
{
	private final Runnable onResolutionObsolete;
	private final DependencyResolutionManager resolutionManager;

	private boolean structureChanged = false;

	public DependencyWatcher(final DependencyResolver resolver,
							 final ILilyEObject target,
							 final IObservatoryBuilder observatoryBuilder,
							 final Runnable onResolutionObsolete)
	{
		this.onResolutionObsolete = onResolutionObsolete;
		resolutionManager = new DependencyResolutionManager(resolver, onResolutionObsolete);
		resolutionManager.resolve(target);
		resolver.installStructureListener(target, observatoryBuilder, this::structureChange);
	}

	public void update(ILilyEObject target)
	{
		resolutionManager.resolve(target);
		structureChanged = false;
	}

	public Deque<DependencyContainer> getResolvedAllocations()
	{
		return resolutionManager.getResolutions();
	}

	public void free()
	{
		resolutionManager.free();
	}

	public boolean isDirty()
	{
		return structureChanged || resolutionManager.isDirty();
	}

	private void structureChange()
	{
		onResolutionObsolete.run();
		structureChanged = true;
	}

	public record Builder(DependencyResolver resolver, ILilyEObject target)
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
