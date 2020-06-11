package org.sheepy.lily.core.allocation.dependency;

import org.sheepy.lily.core.allocation.EAllocationStatus;
import org.sheepy.lily.core.allocation.dependency.container.IDependencyContainer;
import org.sheepy.lily.core.api.model.ILilyEObject;

import java.util.List;
import java.util.function.Consumer;

public final class DependencyManager
{
	private final List<DependencyUpdater> updatableDependencies;
	private final List<IDependencyContainer> criticalDependencies;
	private final Runnable onDirty;
	private final Runnable onObsolete;
	private final Consumer<EAllocationStatus> updatableDependencyChange = this::updatableDependencyChange;
	private final Consumer<EAllocationStatus> criticalDependencyChange = this::criticalDependencyChange;

	public DependencyManager(final List<DependencyUpdater> updatableDependencies,
							 final List<IDependencyContainer> criticalDependencies,
							 final Runnable onDirty,
							 final Runnable onObsolete)
	{
		this.updatableDependencies = List.copyOf(updatableDependencies);
		this.criticalDependencies = List.copyOf(criticalDependencies);
		this.onDirty = onDirty;
		this.onObsolete = onObsolete;

		for (final var dep : updatableDependencies)
		{
			dep.listen(updatableDependencyChange);
		}
		for (final var dep : criticalDependencies)
		{
			dep.listen(criticalDependencyChange);
		}
	}

	public void update(ILilyEObject target)
	{
		for (final var dep : updatableDependencies)
		{
			if (dep.isDirty())
			{
				dep.update(target);
			}
		}
	}

	public void free()
	{
		for (final var dep : updatableDependencies)
		{
			dep.sulk(updatableDependencyChange);
		}
		for (final var dep : criticalDependencies)
		{
			dep.sulk(criticalDependencyChange);
		}
	}

	private void updatableDependencyChange(EAllocationStatus newStatus)
	{
		if (newStatus != EAllocationStatus.Allocated)
		{
			onDirty.run();
		}
	}

	private void criticalDependencyChange(EAllocationStatus newStatus)
	{
		switch (newStatus)
		{
			case Dirty -> onDirty.run();
			case Obsolete, Free -> onObsolete.run();
		}
	}
}
