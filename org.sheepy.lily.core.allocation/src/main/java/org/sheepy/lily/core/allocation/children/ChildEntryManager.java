package org.sheepy.lily.core.allocation.children;

import org.sheepy.lily.core.allocation.AllocationHandle;
import org.sheepy.lily.core.allocation.AllocationInstance;
import org.sheepy.lily.core.allocation.util.StructureObserverBuilder;
import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.core.api.util.IModelExplorer;
import org.sheepy.lily.core.api.util.ModelUtil;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public final class ChildEntryManager
{
	private final IAllocationContext context;
	private final Deque<ILilyEObject> addedElements = new ArrayDeque<>();
	private final Deque<ILilyEObject> removedElements = new ArrayDeque<>();
	private final List<ChildrenInjector> childrenInjectors;
	private final IModelExplorer modelExplorer;

	public static ChildEntryManager newChildrenManager(final ILilyEObject source,
													   IObservatoryBuilder observatoryBuilder,
													   IAllocationContext context,
													   final AllocationChild childAnnotation,
													   List<ChildrenInjector> childrenInjectors)
	{
		final var parentClass = childAnnotation.parent();
		final var parentDistance = ModelUtil.parentDistance(source, parentClass);
		final var builder = new StructureObserverBuilder(observatoryBuilder,
														 parentDistance,
														 childAnnotation.features());
		return new ChildEntryManager(context, builder, childrenInjectors);
	}

	private ChildEntryManager(IAllocationContext context,
							  StructureObserverBuilder observatoryBuilder,
							  List<ChildrenInjector> childrenInjectors)
	{
		this.context = context;
		this.childrenInjectors = List.copyOf(childrenInjectors);
		observatoryBuilder.installListeners(this::add, this::remove);
		modelExplorer = observatoryBuilder.buildExplorer();
	}

	public void update(final ILilyEObject target, AllocationInstance<?> allocationParent)
	{
		final boolean changed = removedElements.isEmpty() || addedElements.isEmpty();
		while (removedElements.isEmpty() == false)
		{
			final var removed = removedElements.removeFirst();
			removed.adapters().adaptHandlesOfType(AllocationHandle.class).forEach(handle -> handle.free(context));
		}
		while (addedElements.isEmpty() == false)
		{
			final var added = addedElements.removeFirst();
			added.adapters()
				 .adaptHandlesOfType(AllocationHandle.class)
				 .forEach(handle -> handle.ensureAllocation(allocationParent, context));
		}

		if (changed && childrenInjectors.isEmpty() == false)
		{
			final var children = modelExplorer.explore(target, ILilyEObject.class);
			for (final var childrenInjector : childrenInjectors)
			{
				childrenInjector.inject(children);
			}
		}
	}

	public void add(List<ILilyEObject> children)
	{
		removedElements.removeAll(children);
		addedElements.addAll(children);
	}

	public void remove(List<ILilyEObject> children)
	{
		addedElements.removeAll(children);
		removedElements.addAll(children);
	}
}