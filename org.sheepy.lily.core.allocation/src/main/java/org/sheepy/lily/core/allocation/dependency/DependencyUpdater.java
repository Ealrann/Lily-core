package org.sheepy.lily.core.allocation.dependency;

import org.sheepy.lily.core.allocation.dependency.container.DependencyContainer;
import org.sheepy.lily.core.api.allocation.annotation.UpdateDependency;
import org.sheepy.lily.core.api.extender.IExtenderHandle;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.core.api.reflect.ConsumerHandle;

import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;

public final class DependencyUpdater
{
	private final DependencyWatcher resolution;
	private final ConsumerHandle updateHandle;
	private final Method method;
	private final boolean many;

	public DependencyUpdater(final DependencyWatcher resolution,
							 final IExtenderHandle.AnnotatedHandle<UpdateDependency> updateHandle)
	{
		this.resolution = resolution;
		this.updateHandle = (ConsumerHandle) updateHandle.executionHandle();
		this.method = updateHandle.method();
		many = List.class == method.getParameterTypes()[0];
	}

	public boolean isDirty()
	{
		return resolution.isDirty();
	}

	public void update(ILilyEObject target)
	{
		assert isDirty() == true;
		resolution.update(target);
		try
		{
			if (many)
			{
				final var allocations = resolution.getResolvedAllocations()
												  .stream()
												  .map(DependencyContainer::get)
												  .collect(Collectors.toUnmodifiableList());
				updateHandle.invoke(allocations);
			}
			else
			{
				final var allocation = resolution.getResolvedAllocations().get(0).get();
				updateHandle.invoke(allocation);
			}
		}
		catch (Exception e)
		{
			throw new RuntimeException("Failed to call " + method, e);
		}
	}

	public void free()
	{
		resolution.free();
	}

	public static record Builder(DependencyWatcher.Builder resolutionBuilder, IExtenderHandle.AnnotatedHandle<UpdateDependency> updateHandle)
	{
		public DependencyUpdater build(final IObservatoryBuilder observatoryBuilder,
									   final Runnable onResolutionObsolete)
		{
			final var resolution = resolutionBuilder.build(observatoryBuilder,
														   onResolutionObsolete);
			return new DependencyUpdater(resolution, updateHandle);
		}
	}
}
