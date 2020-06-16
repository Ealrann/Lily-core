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
import java.util.function.Consumer;
import java.util.stream.Stream;

public final class AllocationManager<Allocation extends IExtender>
{
	private final ILilyEObject target;
	private final AllocationInstance.Builder<Allocation> instanceBuilder;
	private final Consumer<AllocationInstance<Allocation>> allocationListener;
	private final BiConsumer<Allocation, Allocation> onAllocationChange;

	private final Deque<AllocationInstance<Allocation>> dirtyAllocations = new ArrayDeque<>(1);
	private AllocationInstance<Allocation> mainAllocation = null;

	public AllocationManager(ILilyEObject target,
							 AllocationInstance.Builder<Allocation> instanceBuilder,
							 Consumer<AllocationInstance<Allocation>> allocationStatusListener,
							 IExtenderHandle.ExtenderListener<Allocation> onAllocationChange)
	{
		this.target = target;
		this.instanceBuilder = instanceBuilder;
		this.allocationListener = allocationStatusListener;
		this.onAllocationChange = onAllocationChange;
	}

	public void cleanup(final IAllocationContext context, boolean freeEverything)
	{
		if (mainAllocation != null && (freeEverything || mainAllocation.getStatus() == EAllocationStatus.Obsolete))
		{
			final var oldAllocation = mainAllocation.getAllocation();
			deprecateMainHandle(context);
			onAllocationChange.accept(oldAllocation, null);
		}
		freeDeprecatedHandles(context);
	}

	public void update(final IAllocationContext context)
	{
		if (mainAllocation == null)
		{
			allocateNew(context);
		}
		else if (mainAllocation.getStatus() == EAllocationStatus.Dirty)
		{
			mainAllocation.update(target);
		}

		freeDeprecatedHandles(context);
	}

	public void injectChildren()
	{
		mainAllocation.injectChildren(target);
	}

	public <A extends Annotation> Stream<IExtenderHandle.AnnotatedHandle<A>> annotatedHandles(final Class<A> annotationClass)
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

	private void allocateNew(final IAllocationContext context)
	{
		final var oldAllocation = mainAllocation != null ? mainAllocation.getAllocation() : null;
		try
		{
			mainAllocation = instanceBuilder.build(context);
			mainAllocation.load(target);
			mainAllocation.listen(allocationListener);
			final var newAllocation = mainAllocation.getAllocation();
			onAllocationChange.accept(oldAllocation, newAllocation);
		}
		catch (ReflectiveOperationException | AssertionError e)
		{
			e.printStackTrace();
		}
	}

	private void deprecateMainHandle(final IAllocationContext context)
	{
		mainAllocation.sulk(allocationListener);
		mainAllocation.free(context, target);
		if (mainAllocation.getStatus() != EAllocationStatus.Free)
		{
			dirtyAllocations.add(mainAllocation);
		}
		mainAllocation = null;
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
}
