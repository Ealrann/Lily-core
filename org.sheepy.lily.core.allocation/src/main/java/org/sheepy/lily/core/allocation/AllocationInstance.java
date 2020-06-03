package org.sheepy.lily.core.allocation;

import org.sheepy.lily.core.allocation.dependency.container.IDependencyContainer;
import org.sheepy.lily.core.allocation.description.DependencyPointer;
import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.core.api.allocation.annotation.Free;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderDescriptor;
import org.sheepy.lily.core.api.extender.IExtenderHandle;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.notification.observatory.IObservatory;
import org.sheepy.lily.core.api.reflect.ConsumerHandle;
import org.sheepy.lily.core.api.util.AnnotationHandles;
import org.sheepy.lily.core.api.util.DebugUtil;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.stream.Stream;

public final class AllocationInstance<Allocation extends IExtender>
{
	public final Allocation extender;
	private final IObservatory observatory;
	private final List<? extends AnnotationHandles<?>> annotationHandles;
	private final List<DependencyPointer> updatableDependencies;
	private final List<IDependencyContainer> criticalDependencies;
	private final AllocationConfigurator configurator;

	private EStatus status = EStatus.Allocated;

	public enum EStatus
	{
		Allocated,
		Dirty,
		Obsolete,
		Free
	}

	public AllocationInstance(IExtenderDescriptor.ExtenderContext<Allocation> extenderContext,
							  final IObservatory observatory,
							  AllocationConfigurator configurator,
							  List<DependencyPointer> updatableDependencies,
							  List<IDependencyContainer> criticalDependencies)
	{
		this.extender = extenderContext.extender();
		this.annotationHandles = extenderContext.annotationHandles();
		this.configurator = configurator;
		this.observatory = observatory;
		this.updatableDependencies = List.copyOf(updatableDependencies);
		this.criticalDependencies = List.copyOf(criticalDependencies);
	}

	public void maintains()
	{
		assert status == EStatus.Allocated;

		final boolean dirtyMethod = dirtyMethod();
		final var criticalDependencyChanged = criticalDependencies.stream()
																  .filter(IDependencyContainer::isAllocationDirty)
																  .findAny();

		if (DebugUtil.DEBUG_ALLOCATION)
		{
			if (dirtyMethod)
			{
				System.out.println(extender.getClass().getSimpleName() + " is now deprecated due to @Dirty method.");
			}
			if (criticalDependencyChanged.isPresent())
			{
				final var resolver = criticalDependencyChanged.get();
				System.out.println(extender.getClass()
										   .getSimpleName() + " is now deprecated due to " + resolver.toString());
			}
		}

		final var obsolete = dirtyMethod || criticalDependencyChanged.isPresent();

		if (obsolete)
		{
			status = EStatus.Obsolete;
		}
		else
		{
			final var updatableDependencyChanged = updatableDependencies.stream()
																		.filter(DependencyPointer::isDirty)
																		.findAny();

			if (updatableDependencyChanged.isPresent())
			{
				status = EStatus.Dirty;
			}
		}
	}

	private boolean dirtyMethod()
	{
		return configurator.isObsolete();
	}

	public boolean isDirtyUpdatable()
	{
		return status == EStatus.Dirty && isUnlocked();
	}

	private boolean isLocked()
	{
		return configurator.isLocked();
	}

	public boolean isUnlocked()
	{
		return !isLocked();
	}

	public EStatus getStatus()
	{
		return status;
	}

	public void load(ILilyEObject target)
	{
		if (observatory != null) observatory.observe(target);
	}

	public void dispose(ILilyEObject target)
	{
		if (observatory != null) observatory.shut(target);
	}

	public void update()
	{
		updatableDependencies.stream().filter(DependencyPointer::isDirty).forEach(DependencyPointer::update);
		status = EStatus.Allocated;
	}

	public void free(IAllocationContext context)
	{
		annotatedHandles(Free.class).forEach(freeHandle -> ((ConsumerHandle) freeHandle.executionHandle()).invoke(
				context));
	}

	@SuppressWarnings("unchecked")
	public <A extends Annotation> Stream<IExtenderHandle.AnnotatedHandle<A>> annotatedHandles(Class<A> annotationClass)
	{
		return annotationHandles.stream()
								.filter(h -> h.annotationClass().equals(annotationClass))
								.flatMap(h -> ((AnnotationHandles<A>) h).handles().stream());
	}

	public Allocation getAllocation()
	{
		return extender;
	}
}
