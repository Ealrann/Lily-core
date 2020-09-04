package org.sheepy.lily.core.allocation;

import org.sheepy.lily.core.allocation.description.AllocationDescriptor;
import org.sheepy.lily.core.allocation.instance.AllocationInstance;
import org.sheepy.lily.core.allocation.operation.*;
import org.sheepy.lily.core.allocation.spliterator.CleanupTreeIterator;
import org.sheepy.lily.core.allocation.spliterator.UpdateTreeIterator;
import org.sheepy.lily.core.api.allocation.IAllocationHandle;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.notification.util.ListenerList;

import java.lang.annotation.Annotation;
import java.util.function.Consumer;
import java.util.stream.Stream;

public final class AllocationHandle<Allocation extends IExtender> implements IAllocationHandle<Allocation>
{
	private final ILilyEObject target;
	private final AllocationDescriptor<Allocation> descriptor;
	private final ListenerList<ExtenderListener<Allocation>> listeners = new ListenerList<>();

	private AllocationInstance<Allocation> mainAllocation = null;

	public AllocationHandle(ILilyEObject target, AllocationDescriptor<Allocation> descriptor)
	{
		this.target = target;
		this.descriptor = descriptor;
	}

	@Override
	public void load(final ILilyEObject target)
	{
	}

	@Override
	public void dispose(final ILilyEObject target)
	{
	}

	public BuildOperation<Allocation> newBuildOperation()
	{
		return new BuildOperation<>(descriptor.prepareBuild(target, () -> {}), this::setMainAllocation);
	}

	public BuildOperation<Allocation> newBuildOperation(Runnable whenUpdateNeeded,
														Consumer<AllocationInstance<Allocation>> postBuild)
	{
		final Consumer<AllocationInstance<Allocation>> afterBuild = newAllocation -> {
			setMainAllocation(newAllocation);
			postBuild.accept(newAllocation);
		};

		return new BuildOperation<>(descriptor.prepareBuild(target, whenUpdateNeeded), afterBuild);
	}

	public void setMainAllocation(final AllocationInstance<Allocation> allocation)
	{
		final var previousAllocation = getAllocationOrNull(mainAllocation);
		final var newAllocation = getAllocationOrNull(allocation);
		this.mainAllocation = allocation;
		onAllocationChange(previousAllocation, newAllocation);
	}

	public IOperation<UpdateTreeIterator> prepareIteratorUpdate(final AllocationInstance<Allocation> allocation)
	{
		return new UpdateOperation(target, allocation);
	}

	public IOperation<CleanupTreeIterator> prepareCleanupOperation(final AllocationInstance<Allocation> allocation)
	{
		return new CleanupOperation(allocation);
	}

	public IOperation<CleanupTreeIterator> prepareFreeOperation(final AllocationInstance<Allocation> allocation)
	{
		return new FreeOperation(target, allocation);
	}

	@Override
	public <A extends Annotation> Stream<AnnotatedHandle<A>> annotatedHandles(final Class<A> annotationClass)
	{
		return mainAllocation != null ? mainAllocation.annotatedHandles(annotationClass) : Stream.empty();
	}

	@Override
	public Class<Allocation> getExtenderClass()
	{
		return descriptor.extenderClass();
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

	public ILilyEObject getTarget()
	{
		return target;
	}
}
