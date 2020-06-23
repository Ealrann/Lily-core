package org.sheepy.lily.core.allocation.util;

import org.sheepy.lily.core.allocation.AllocationInstance;
import org.sheepy.lily.core.allocation.EAllocationStatus;
import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderHandle;
import org.sheepy.lily.core.api.model.ILilyEObject;

import java.lang.annotation.Annotation;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public final class AllocationManager<Allocation extends IExtender>
{
	private final ILilyEObject target;
	private final AllocationInstance.Builder<Allocation> instanceBuilder;
	private final Runnable whenUpdateNeeded;
	private final BiConsumer<Allocation, Allocation> onAllocationChange;

	private final Deque<AllocationInstance<Allocation>> dirtyAllocations = new ArrayDeque<>(1);
	private AllocationInstance<Allocation> mainAllocation = null;

	public AllocationManager(ILilyEObject target,
							 AllocationInstance.Builder<Allocation> instanceBuilder,
							 Runnable whenUpdateNeeded,
							 IExtenderHandle.ExtenderListener<Allocation> onAllocationChange)
	{
		this.target = target;
		this.instanceBuilder = instanceBuilder;
		this.whenUpdateNeeded = whenUpdateNeeded;
		this.onAllocationChange = onAllocationChange;
	}

	public void cleanup(final IAllocationContext context, boolean freeEverything)
	{
		if (mainAllocation != null)
		{
			final boolean obsolete = mainAllocation.getStatus() == EAllocationStatus.Obsolete;
			final boolean dirtyLocked = mainAllocation.getStatus() == EAllocationStatus.Dirty && mainAllocation.isLocked();

			if (freeEverything || obsolete || dirtyLocked)
			{
				final var oldAllocation = mainAllocation.getAllocation();
				deprecateMainHandle();
				onAllocationChange.accept(oldAllocation, null);
			}
		}
		freeDeprecatedHandles(context);
	}

	public void update(final IAllocationContext context)
	{
		if (mainAllocation == null)
		{
			mainAllocation = dirtyAllocations.stream()
											 .filter(AllocationManager::isAllocationDirtyUnlocked)
											 .map(this::updateAllocation)
											 .findAny()
											 .orElseGet(() -> allocateNew(context));
			mainAllocation.update(target);
			onAllocationChange.accept(null, mainAllocation.getAllocation());
		}
		else if (mainAllocation.getStatus() == EAllocationStatus.Dirty)
		{
			mainAllocation.update(target);
		}
	}

	private AllocationInstance<Allocation> updateAllocation(AllocationInstance<Allocation> allocation)
	{
		allocation.update(target);
		return allocation;
	}

	public void injectChildren()
	{
		mainAllocation.injectChildren(target);
	}

	private void deprecateMainHandle()
	{
		dirtyAllocations.add(mainAllocation);
		mainAllocation = null;
	}

	private void freeDeprecatedHandles(IAllocationContext context)
	{
		final var it = dirtyAllocations.iterator();
		while (it.hasNext())
		{
			final var allocation = it.next();
			if (allocation.getStatus() == EAllocationStatus.Obsolete && allocation.isUnlocked())
			{
				allocation.free(context, target);
				it.remove();
			}
		}
	}

	private AllocationInstance<Allocation> allocateNew(final IAllocationContext context)
	{
		try
		{
			final var newAllocationInstance = instanceBuilder.build(context, whenUpdateNeeded);
			newAllocationInstance.load(target);
			return newAllocationInstance;
		}
		catch (ReflectiveOperationException | AssertionError e)
		{
			throw new AssertionError(e);
		}
	}

	public <A extends Annotation> Stream<IExtenderHandle.AnnotatedHandle<A>> allAnnotatedHandles(final Class<A> annotationClass)
	{
		final var otherStream = dirtyAllocations.stream().filter(this::isAllocationAlive);
		final var mainStream = mainAllocation != null ? Stream.of(mainAllocation) : Stream.<AllocationInstance<Allocation>>empty();
		final var fullStream = Stream.concat(mainStream, otherStream);
		return fullStream.flatMap(allocation -> allocation.annotatedHandles(annotationClass));
	}

	private boolean isAllocationAlive(final AllocationInstance<Allocation> allocation)
	{
		final var status = allocation.getStatus();
		return status == EAllocationStatus.Allocated || status == EAllocationStatus.Dirty;
	}

	public Allocation getExtender()
	{
		return mainAllocation != null ? mainAllocation.getAllocation() : null;
	}

	public AllocationInstance<Allocation> getMainAllocation()
	{
		return mainAllocation;
	}

	public IAllocationContext getProvidedContext()
	{
		return mainAllocation.getProvidedContext();
	}

	private static boolean isAllocationDirtyUnlocked(AllocationInstance<?> allocation)
	{
		return allocation.getStatus() == EAllocationStatus.Dirty && allocation.isUnlocked();
	}
}
