package org.sheepy.lily.core.allocation.dependency;

import org.sheepy.lily.core.allocation.EAllocationStatus;
import org.sheepy.lily.core.allocation.dependency.container.IDependencyContainer;
import org.sheepy.lily.core.api.allocation.annotation.UpdateDependency;
import org.sheepy.lily.core.api.extender.IExtenderHandle;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.reflect.ConsumerHandle;

import java.lang.reflect.Method;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public final class DependencyUpdater
{
	private final DependencyResolution resolution;
	private final ConsumerHandle updateHandle;
	private final Method method;
	private final boolean many;

	public DependencyUpdater(final DependencyResolution resolution,
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
												  .map(IDependencyContainer::get)
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

	public static record Builder(DependencyResolution.Builder resolutionBuilder,
								 IExtenderHandle.AnnotatedHandle<UpdateDependency>updateHandle)
	{
		public DependencyUpdater build(final Consumer<EAllocationStatus> statusListener)
		{
			final var resolution = resolutionBuilder.build(statusListener);
			return new DependencyUpdater(resolution, updateHandle);
		}
	}
}
