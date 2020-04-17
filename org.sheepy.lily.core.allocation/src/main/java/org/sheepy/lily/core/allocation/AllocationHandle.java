package org.sheepy.lily.core.allocation;

import org.sheepy.lily.core.allocation.dependency.DependencyResolver;
import org.sheepy.lily.core.allocation.dependency.DependencyResolvers;
import org.sheepy.lily.core.allocation.util.AllocationChildrenManager;
import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.core.api.allocation.IAllocationHandle;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.notification.IEMFNotifier;
import org.sheepy.lily.core.api.notification.util.ListenerList;
import org.sheepy.lily.core.api.util.DebugUtil;

import java.lang.annotation.Annotation;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public final class AllocationHandle<Allocation extends IExtender> implements IAllocationHandle<Allocation>
{
	private final ListenerList<BiConsumer<Allocation, Allocation>> listeners = new ListenerList<>();
	private final ILilyEObject target;
	private final DependencyResolvers resolvers;
	private final AllocationDescriptor<Allocation> descriptor;
	private final AllocationChildrenManager children;

	private final Deque<AllocationExtenderContainer<Allocation>> deprecatedHandles = new ArrayDeque<>(1);
	private AllocationExtenderContainer<Allocation> mainHandle = null;

	public AllocationHandle(ILilyEObject target, AllocationDescriptor<Allocation> extenderDescriptor)
	{
		this.target = target;
		this.descriptor = extenderDescriptor;
		this.resolvers = descriptor.createResolvers();
		this.children = new AllocationChildrenManager(target, descriptor.extenderClass());
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
		if (mainHandle == null)
		{
			return Stream.empty();
		}
		else
		{
			return mainHandle.annotatedHandles(annotationClass);
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
		if (mainHandle == null)
		{
			throw new NoSuchElementException(descriptor.toString() + " is not allocated.");
		}
		else
		{
			return mainHandle.getAllocation();
		}
	}

	public void ensureAllocation(final IAllocationContext context)
	{
		try
		{
			children.ensureAllocation(context, target);
		}
		catch (Exception e)
		{
			throw new AssertionError("Failed to ensure allocation of " + descriptor.extenderClass().getSimpleName(), e);
		}

		if (resolvers.isStarted() == false)
		{
			resolvers.start(target);
		}

		final boolean deprecated = checkMainHandle();
		if (!deprecated)
		{
			resolvers.streamNotCriticalDirty().forEach(this::updateDependency);
		}
		else
		{
			allocateNew(target, context);
		}
	}

	private void updateDependency(final DependencyResolver resolver)
	{
		resolver.resolve();
		mainHandle.update(resolver);
	}

	private boolean checkMainHandle()
	{
		if (mainHandle != null)
		{
			final boolean dirtyMethod = mainHandle.isDirty();
			final var criticalDependencyChanged = resolvers.streamCriticalDirty().findAny();

			if (DebugUtil.DEBUG_ALLOCATION)
			{
				if (dirtyMethod)
				{
					System.out.println(descriptor.toString() + " is now deprecated due to @Dirty method.");
				}
				if (criticalDependencyChanged.isPresent())
				{
					final var resolver = criticalDependencyChanged.get();
					System.out.println(descriptor.toString() + " is now deprecated due to " + resolver.toString());
				}
			}

			return dirtyMethod || criticalDependencyChanged.isPresent();
		}
		else
		{
			return true;
		}
	}

	public void cleanup(final IAllocationContext context)
	{
		children.cleanup(context);
		freeDeprecatedHandles(context);
	}

	public void free(final IAllocationContext context)
	{
		if (mainHandle != null)
		{
			final var oldAllocation = mainHandle.getAllocation();
			deprecateMainHandle();
			listeners.notify(listener -> listener.accept(oldAllocation, null));
		}

		freeDeprecatedHandles(context);
		resolvers.stop(target);
		children.free(context, target);
	}

	private void deprecateMainHandle()
	{
		deprecatedHandles.add(mainHandle);
		mainHandle.dispose(target);
		mainHandle = null;
	}

	private void freeDeprecatedHandles(IAllocationContext context)
	{
		for (var handle : deprecatedHandles)
		{
			handle.free(context);
		}
		deprecatedHandles.clear();
	}

	private void allocateNew(final ILilyEObject target, final IAllocationContext context)
	{
		final var oldAllocation = mainHandle != null ? mainHandle.getAllocation() : null;
		if (mainHandle != null)
		{
			deprecateMainHandle();
		}

		try
		{
			resolvers.resolve();
			mainHandle = descriptor.newHandle(target, resolvers, context);
			mainHandle.load(target);
			final var newAllocation = mainHandle.getAllocation();
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
