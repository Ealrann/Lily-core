package org.sheepy.lily.core.allocation;

import org.sheepy.lily.core.allocation.description.AllocationDescriptor;
import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.core.api.allocation.IAllocationHandle;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.notification.IEMFNotifier;
import org.sheepy.lily.core.api.notification.observatory.IObservatory;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.core.api.notification.util.ListenerList;

import java.lang.annotation.Annotation;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public final class AllocationHandle<Allocation extends IExtender> implements IAllocationHandle<Allocation>
{
	private final ILilyEObject target;
	private final AllocationDescriptor<Allocation> descriptor;
	private final ListenerList<BiConsumer<Allocation, Allocation>> listeners = new ListenerList<>();
	private final AllocationInstance.Builder<Allocation> instanceBuilder;
	private final IObservatory dependencyObservatory;

	private final Deque<AllocationInstance<Allocation>> dirtyAllocations = new ArrayDeque<>(1);
	private AllocationInstance<Allocation> mainAllocation = null;

	public AllocationHandle(ILilyEObject target, AllocationDescriptor<Allocation> extenderDescriptor)
	{
		final var observatoryBuilder = IObservatoryBuilder.newObservatoryBuilder();
		this.target = target;
		this.descriptor = extenderDescriptor;
		final var resolvers = descriptor.createResolvers(observatoryBuilder, target);
		instanceBuilder = new AllocationInstance.Builder<>(descriptor, target, resolvers);
		this.dependencyObservatory = observatoryBuilder.build();
	}

	@Override
	public void load(final ILilyEObject target, final IEMFNotifier notifier)
	{
		dependencyObservatory.observe(target);
	}

	@Override
	public void dispose(final ILilyEObject target, final IEMFNotifier notifier)
	{
		dependencyObservatory.shut(target);
	}

	@Override
	public boolean isExtenderChangeable()
	{
		return true;
	}

	@Override
	public <A extends Annotation> Stream<AnnotatedHandle<A>> annotatedHandles(final Class<A> annotationClass)
	{
		if (mainAllocation == null)
		{
			return Stream.empty();
		}
		else
		{
			return mainAllocation.annotatedHandles(annotationClass);
		}
	}

	public ILilyEObject getTarget()
	{
		return target;
	}

	@Override
	public Class<Allocation> getExtenderClass()
	{
		return descriptor.extenderClass();
	}

	@Override
	public Allocation getExtender()
	{
		return mainAllocation != null ? mainAllocation.getAllocation() : null;
	}

	public AllocationInstance<Allocation> getMainAllocation()
	{
		return mainAllocation;
	}

	public void ensureAllocation(AllocationInstance<? extends IExtender> parent, final IAllocationContext context)
	{
		if (mainAllocation == null || mainAllocation.getStatus() == EAllocationStatus.Obsolete)
		{
			allocateNew(parent, context);
		}
		else if (mainAllocation.getStatus() == EAllocationStatus.Dirty)
		{
			mainAllocation.update(target);
		}

		freeDeprecatedHandles(context);
	}

	public void free(final IAllocationContext context)
	{
		if (mainAllocation != null)
		{
			final var oldAllocation = mainAllocation.getAllocation();
			deprecateMainHandle();
			listeners.notify(listener -> listener.accept(oldAllocation, null));
		}

		freeDeprecatedHandles(context);
	}

	private void freeDeprecatedHandles(IAllocationContext context)
	{
		final var it = dirtyAllocations.iterator();
		while (it.hasNext())
		{
			final var allocation = it.next();
			allocation.free(context, target);

			if (allocation.getStatus() == EAllocationStatus.Free)
			{
				it.remove();
			}
		}
	}

	private void allocateNew(AllocationInstance<?> parent, final IAllocationContext context)
	{
		final var oldAllocation = mainAllocation != null ? mainAllocation.getAllocation() : null;
		if (mainAllocation != null)
		{
			deprecateMainHandle();
		}

		try
		{
			mainAllocation = instanceBuilder.build(parent, context);
			final var newAllocation = mainAllocation.getAllocation();
			listeners.notify(listener -> listener.accept(oldAllocation, newAllocation));
			mainAllocation.load(target);
		}
		catch (ReflectiveOperationException | AssertionError e)
		{
			e.printStackTrace();
		}
	}

	private void deprecateMainHandle()
	{
		dirtyAllocations.add(mainAllocation);
		mainAllocation = null;
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
}
