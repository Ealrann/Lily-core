package org.sheepy.lily.core.allocation.util;

import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.core.api.allocation.IAllocationManager;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.notification.observatory.IObservatory;
import org.sheepy.lily.core.api.util.ModelUtil;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.function.Consumer;

public final class AllocationChildrenManager
{
	private final List<ILilyEObject> elements = new ArrayList<>();
	private final Deque<ILilyEObject> removedElements = new ArrayDeque<>();
	private final IObservatory observatory;

	private boolean observing = false;

	public AllocationChildrenManager(final ILilyEObject source, Class<? extends IExtender> allocationClass)
	{
		observatory = newObservatory(source, allocationClass, this::add, this::remove);
	}

	private static IObservatory newObservatory(ILilyEObject source,
											   Class<?> allocationClass,
											   Consumer<ILilyEObject> onAdd,
											   Consumer<ILilyEObject> onRemove)
	{
		final var builder = new GatherObservatoryBuilder();
		for (var annotation : allocationClass.getAnnotationsByType(AllocationChild.class))
		{
			final var parentClass = annotation.parent();
			final var parentDescription = ModelUtil.parent(source, parentClass);
			builder.explore(parentDescription.distance(), annotation.features());
		}
		return builder.isEmpty() ? null : builder.build(onAdd, onRemove);
	}

	public void ensureAllocation(final IAllocationContext context, final ILilyEObject target)
	{
		if (observing == false)
		{
			try
			{
				if (observatory != null) observatory.observe(target);
			}
			catch (Exception e)
			{
				throw new IllegalArgumentException("Failed to observe AllocationChildren", e);
			}
			observing = true;

		}

		for (int i = 0; i < elements.size(); i++)
		{
			final var child = elements.get(i);
			IAllocationManager.INSTANCE.ensureAllocation(child, context);
		}
	}

	public void cleanup(final IAllocationContext context)
	{
		freeInternal(context, true);
	}

	public void free(final IAllocationContext context, ILilyEObject target)
	{
		freeInternal(context, false);
		if (observing && observatory != null) observatory.shut(target);
		observing = false;
	}

	private void freeInternal(final IAllocationContext context, boolean cleanupOnly)
	{
		while (removedElements.isEmpty() == false)
		{
			final var removedChild = removedElements.removeFirst();
			IAllocationManager.INSTANCE.free(removedChild, context);
			elements.remove(removedChild);
		}

		for (int i = elements.size() - 1; i >= 0; i--)
		{
			final var child = elements.get(i);
			if (cleanupOnly)
			{
				IAllocationManager.INSTANCE.cleanup(child, context);
			}
			else
			{
				IAllocationManager.INSTANCE.free(child, context);
			}
		}
	}

	public void add(ILilyEObject element)
	{
		elements.add(element);
	}

	public void remove(ILilyEObject element)
	{
		assert elements.contains(element);
		removedElements.add(element);
	}
}
