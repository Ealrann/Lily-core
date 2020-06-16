package org.sheepy.lily.core.allocation.children;

import org.sheepy.lily.core.allocation.AllocationHandle;
import org.sheepy.lily.core.allocation.util.StructureObserverBuilder;
import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.core.api.util.IModelExplorer;
import org.sheepy.lily.core.api.util.ModelUtil;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public final class ChildEntryManager
{
	private final Deque<ILilyEObject> removedElements = new ArrayDeque<>();
	private final LinkedList<ILilyEObject> allocatedElements = new LinkedList<>();
	private final IModelExplorer modelExplorer;
	private final Runnable whenDirty;

	private ChildEntryManager(StructureObserverBuilder observatoryBuilder, Runnable whenDirty)
	{
		observatoryBuilder.installListeners(this::add, this::remove);
		modelExplorer = observatoryBuilder.buildExplorer();
		this.whenDirty = whenDirty;
	}

	public void cleanup(ILilyEObject source, IAllocationContext context, boolean freeEverything)
	{
		while (removedElements.isEmpty() == false)
		{
			final var removed = removedElements.removeFirst();
			removed.adapters().adaptHandlesOfType(AllocationHandle.class).forEach(h -> cleanupHandle(h, context, true));
		}

		modelExplorer.stream(source)
					 .forEach(element -> element.adapters()
												.adaptHandlesOfType(AllocationHandle.class)
												.forEach(handle -> cleanupHandle(handle, context, freeEverything)));

		if (freeEverything) allocatedElements.clear();
	}

	public void ensureAllocation(ILilyEObject source, IAllocationContext context)
	{
		allocatedElements.clear();

		modelExplorer.stream(source).forEach(element -> {
			element.adapters()
				   .adaptHandlesOfType(AllocationHandle.class)
				   .forEach(handle -> allocateHandle(handle, context));
			allocatedElements.add(element);
		});
	}

	private void allocateHandle(final AllocationHandle<?> handle, final IAllocationContext context)
	{
		handle.listenDirty(whenDirty);
		handle.ensureAllocation(context);
	}

	private void cleanupHandle(final AllocationHandle<?> handle,
							   final IAllocationContext context,
							   boolean freeEverything)
	{
		if (freeEverything) handle.sulkDirty(whenDirty);
		handle.cleanup(context, freeEverything);
	}

	public void add(List<ILilyEObject> children)
	{
		whenDirty.run();
	}

	public void remove(List<ILilyEObject> removedChildren)
	{
		for (final var removed : removedChildren)
		{
			if (allocatedElements.contains(removed))
			{
				removedElements.add(removed);
			}
		}
		whenDirty.run();
	}

	public IModelExplorer getModelExplorer()
	{
		return modelExplorer;
	}

	public static final class Builder
	{
		private final ILilyEObject source;
		private final IObservatoryBuilder observatoryBuilder;
		private final AllocationChild childAnnotation;

		public Builder(final ILilyEObject source,
					   IObservatoryBuilder observatoryBuilder,
					   final AllocationChild childAnnotation)
		{
			this.source = source;
			this.observatoryBuilder = observatoryBuilder;
			this.childAnnotation = childAnnotation;
		}

		public ChildEntryManager build(Runnable whenDirty)
		{
			final var parentClass = childAnnotation.parent();
			final var parentDistance = ModelUtil.parentDistance(source, parentClass);
			final var builder = new StructureObserverBuilder(observatoryBuilder,
															 parentDistance,
															 childAnnotation.features());
			return new ChildEntryManager(builder, whenDirty);
		}
	}
}