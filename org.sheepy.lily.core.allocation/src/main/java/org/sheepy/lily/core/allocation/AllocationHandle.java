package org.sheepy.lily.core.allocation;

import org.sheepy.lily.core.allocation.description.AllocationDescriptor;
import org.sheepy.lily.core.allocation.instance.AllocationInstance;
import org.sheepy.lily.core.allocation.instance.AllocationInstanceBuilder;
import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.core.api.allocation.IAllocationHandle;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.notification.IEMFNotifier;
import org.sheepy.lily.core.api.notification.observatory.IObservatory;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.core.api.notification.util.ListenerList;

import java.lang.annotation.Annotation;
import java.util.stream.Stream;

public final class AllocationHandle<Allocation extends IExtender> implements IAllocationHandle<Allocation>
{
	private final AllocationDescriptor<Allocation> descriptor;
	private final ListenerList<ExtenderListener<Allocation>> listeners = new ListenerList<>();
	private final IObservatory observatory;
	private final AllocationInstanceBuilder<Allocation> instanceBuilder;

	private AllocationInstance<Allocation> mainAllocation = null;

	public AllocationHandle(ILilyEObject target, AllocationDescriptor<Allocation> descriptor)
	{
		final var observatoryBuilder = IObservatoryBuilder.newObservatoryBuilder();
		final var resolvers = descriptor.createResolvers(observatoryBuilder, target);

		this.descriptor = descriptor;
		instanceBuilder = new AllocationInstanceBuilder<>(descriptor, target, resolvers);
		this.observatory = observatoryBuilder.build();
	}

	@Override
	public void load(final ILilyEObject target, final IEMFNotifier notifier)
	{
		observatory.observe(target);
	}

	@Override
	public void dispose(final ILilyEObject target, final IEMFNotifier notifier)
	{
		observatory.shut(target);
	}

	public AllocationInstance<Allocation> allocateNew(final IAllocationContext context, Runnable whenUpdateNeeded)
	{
		try
		{
			final var previousAllocation = getAllocationOrNull(mainAllocation);
			mainAllocation = instanceBuilder.build(context, whenUpdateNeeded);
			mainAllocation.load(context);
			final var newAllocation = getAllocationOrNull(mainAllocation);
			onAllocationChange(previousAllocation, newAllocation);
			return mainAllocation;
		}
		catch (Exception e)
		{
			throw new AssertionError("Cannot build " + descriptor.extenderClass().getSimpleName(), e);
		}
	}

	public void setMainAllocation(final AllocationInstance<Allocation> allocation)
	{
		final var previousAllocation = getAllocationOrNull(mainAllocation);
		final var newAllocation = getAllocationOrNull(allocation);
		this.mainAllocation = allocation;
		onAllocationChange(previousAllocation, newAllocation);
	}

	@Override
	public <A extends Annotation> Stream<AnnotatedHandle<A>> annotatedHandles(final Class<A> annotationClass)
	{
		return mainAllocation != null ? mainAllocation.annotatedHandles(annotationClass) : Stream.empty();
	}

	@Override
	public Class<Allocation> getExtenderClass()
	{
		return descriptor.extenderDescriptor().extenderClass();
	}

	@Override
	public Allocation getExtender()
	{
		return getAllocationOrNull(mainAllocation);
	}

	private void onAllocationChange(Allocation oldAllocation, Allocation newAllocation)
	{
		listeners.notify(listener -> listener.accept(oldAllocation, newAllocation));
	}

	public AllocationInstance<Allocation> getMainAllocation()
	{
		return mainAllocation;
	}

	@Override
	public void listen(final ExtenderListener<Allocation> listener)
	{
		listeners.listen(listener);
	}

	@Override
	public void listenNoParam(final Runnable listener)
	{
		listeners.listenNoParam(listener);
	}

	@Override
	public void sulk(final ExtenderListener<Allocation> listener)
	{
		listeners.sulk(listener);
	}

	@Override
	public void sulkNoParam(final Runnable listener)
	{
		listeners.sulkNoParam(listener);
	}

	public AllocationDescriptor<Allocation> getDescriptor()
	{
		return descriptor;
	}

	private static <T extends IExtender> T getAllocationOrNull(AllocationInstance<T> instance)
	{
		return instance != null ? instance.getAllocation() : null;
	}
}
