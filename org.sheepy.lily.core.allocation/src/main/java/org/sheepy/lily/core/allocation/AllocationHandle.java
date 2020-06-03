package org.sheepy.lily.core.allocation;

import org.sheepy.lily.core.allocation.dependency.DependencyResolvers;
import org.sheepy.lily.core.allocation.description.AllocationDescriptor;
import org.sheepy.lily.core.allocation.util.AllocationChildrenManager;
import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.core.api.allocation.IAllocationHandle;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.notification.IEMFNotifier;
import org.sheepy.lily.core.api.notification.util.ListenerList;

import java.lang.annotation.Annotation;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public final class AllocationHandle<Allocation extends IExtender> implements IAllocationHandle<Allocation>
{
	private final ILilyEObject target;
	private final AllocationDescriptor<Allocation> descriptor;
	private final DependencyResolvers resolvers;
	private final AllocationChildrenManager children;
	private final ListenerList<BiConsumer<Allocation, Allocation>> listeners = new ListenerList<>();

	private final Deque<AllocationInstance<Allocation>> dirtyAllocations = new ArrayDeque<>(1);
	private AllocationInstance<Allocation> mainAllocation = null;

	public AllocationHandle(ILilyEObject target, AllocationDescriptor<Allocation> extenderDescriptor)
	{
		this.target = target;
		this.descriptor = extenderDescriptor;
		this.resolvers = descriptor.createResolvers();
		this.children = AllocationChildrenManager.newChildrenManager(target, descriptor.extenderClass());
	}

	@Override
	public void load(final ILilyEObject target, final IEMFNotifier notifier)
	{
	}

	@Override
	public void dispose(final ILilyEObject target, final IEMFNotifier notifier)
	{
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
		if (mainAllocation == null)
		{
			throw new NoSuchElementException(descriptor.toString() + " is not allocated.");
		}
		else
		{
			return mainAllocation.getAllocation();
		}
	}

	public AllocationInstance<Allocation> getMainAllocation()
	{
		return mainAllocation;
	}

	public void ensureAllocation(final IAllocationContext context)
	{
		try
		{
			children.ensureAllocation(context, target);
		}
		catch (Exception e)
		{
			throw new AssertionError("Failed to ensure allocation of children of " + descriptor.extenderClass()
																							   .getSimpleName(), e);
		}

		if (resolvers.isStarted() == false)
		{
			// TODO mettre dans load()
			resolvers.start(target);
		}

		if (mainAllocation == null)
		{
			allocateNew(target, context);
		}
		else
		{
			maintainsMainHAndle(context);
		}
	}

	private void maintainsMainHAndle(final IAllocationContext context)
	{
		mainAllocation.maintains();
		if (mainAllocation.getStatus() != AllocationInstance.EStatus.Allocated)
		{
			deprecateMainHandle();

			if (tryRestoreHandle() == false)
			{
				allocateNew(target, context);
			}
		}
	}

	private boolean tryRestoreHandle()
	{
		assert mainAllocation == null;

		final var updatedHandle = dirtyAllocations.stream()
												  .filter(AllocationInstance::isDirtyUpdatable)
												  .findAny()
												  .map(this::updateInstance);

		if (updatedHandle.isPresent())
		{
			resolvers.resolve();
			mainAllocation = updatedHandle.get();
			return true;
		}
		else
		{
			return false;
		}
	}

	private AllocationInstance<Allocation> updateInstance(AllocationInstance<Allocation> instance)
	{
		instance.update();
		return instance;
	}

	public void cleanup(final IAllocationContext context)
	{
		children.cleanup(context);
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

		if (resolvers.isStarted())
		{
			// TODO mettre dans dispose()
			resolvers.stop(target);
		}
		children.free(context, target);
	}

	private void deprecateMainHandle()
	{
		dirtyAllocations.add(mainAllocation);
		mainAllocation.dispose(target);
		mainAllocation = null;
	}

	private void freeDeprecatedHandles(IAllocationContext context)
	{
		final var it = dirtyAllocations.iterator();
		for (var handle : dirtyAllocations)
		{
			handle.free(context);

			if (handle.getStatus() == AllocationInstance.EStatus.Free)
			{
				it.remove();
			}
		}
	}

	private void allocateNew(final ILilyEObject target, final IAllocationContext context)
	{
		final var oldAllocation = mainAllocation != null ? mainAllocation.getAllocation() : null;
		if (mainAllocation != null)
		{
			deprecateMainHandle();
		}

		try
		{
			resolvers.resolve();
			mainAllocation = descriptor.newHandle(target, resolvers, context);
			mainAllocation.load(target);
			final var newAllocation = mainAllocation.getAllocation();
			listeners.notify(listener -> listener.accept(oldAllocation, newAllocation));
		}
		catch (ReflectiveOperationException e)
		{
			e.printStackTrace();
		}
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
