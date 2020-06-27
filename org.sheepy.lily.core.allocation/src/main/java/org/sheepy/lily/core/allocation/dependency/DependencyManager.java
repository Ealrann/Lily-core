package org.sheepy.lily.core.allocation.dependency;

import org.sheepy.lily.core.allocation.EAllocationStatus;
import org.sheepy.lily.core.api.model.ILilyEObject;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public final class DependencyManager
{
	private final List<DependencyUpdater> updatableDependencies;
	private final List<DependencyResolution> criticalDependencies;
	private final Runnable onDirty;
	private final Runnable onObsolete;
	private final Consumer<EAllocationStatus> updatableDependencyChange = this::updatableDependencyChange;
	private final Consumer<EAllocationStatus> criticalDependencyChange = this::criticalDependencyChange;

	public DependencyManager(final List<DependencyUpdater.Builder> updatableDependencies,
							 final List<DependencyResolution.Builder> criticalDependencies,
							 final Runnable onDirty,
							 final Runnable onObsolete)
	{
		this.updatableDependencies = updatableDependencies.stream()
														  .map(builder -> builder.build(updatableDependencyChange))
														  .collect(Collectors.toUnmodifiableList());
		this.criticalDependencies = criticalDependencies.stream()
														 .map(builder -> builder.build(criticalDependencyChange))
														 .collect(Collectors.toUnmodifiableList());
		this.onDirty = onDirty;
		this.onObsolete = onObsolete;
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
			dep.free();
		}
		for (final var dep : criticalDependencies)
		{
			dep.free();
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

	public static final class Builder
	{

	}
}
