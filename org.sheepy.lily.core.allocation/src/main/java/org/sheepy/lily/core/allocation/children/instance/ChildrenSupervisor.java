package org.sheepy.lily.core.allocation.children.instance;

import org.sheepy.lily.core.allocation.EAllocationStatus;
import org.sheepy.lily.core.allocation.children.manager.IAllocationChildrenManager;
import org.sheepy.lily.core.allocation.children.util.AllocationChildrenList;
import org.sheepy.lily.core.allocation.children.util.ChildInstanceAllocators;
import org.sheepy.lily.core.allocation.instance.FreeContext;
import org.sheepy.lily.core.allocation.util.StructureObserver;
import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.util.IModelExplorer;
import org.sheepy.lily.core.api.util.ModelUtil;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public final class ChildrenSupervisor
{
	private final Deque<ChildInstanceAllocators> removedElements = new ArrayDeque<>();
	private final Runnable whenBranchDirty;
	private final AllocationChildrenList children;
	private final int index;

	private boolean addedElements = true;

	private ChildrenSupervisor(final StructureObserver observatoryBuilder,
							   final IModelExplorer modelExplorer,
							   final Runnable whenBranchDirty,
							   final Optional<Consumer<EAllocationStatus>> listener,
							   final int index)
	{
		this.index = index;
		observatoryBuilder.installListeners(this::add, this::remove);
		this.whenBranchDirty = whenBranchDirty;
		children = new AllocationChildrenList(whenBranchDirty, listener, modelExplorer);
	}

	public void cleanup(final FreeContext context)
	{
		freeRemovedElements(context);
		children.reverseStream()
				.flatMap(ChildInstanceAllocators::reverseStream)
				.forEach(child -> child.cleanup(context));
		if (context.freeEverything()) children.clear();
	}

	private void freeRemovedElements(final FreeContext context)
	{
		if (removedElements.isEmpty() == false)
		{
			final var subContext = context.encapsulate(true);
			while (removedElements.isEmpty() == false)
			{
				final var removed = removedElements.pop();
				removed.instanceAllocators().forEach(c -> c.cleanup(subContext));
				children.remove(removed);
			}
		}
	}

	public void update(ILilyEObject source, IAllocationContext context)
	{
		if (addedElements)
		{
			children.updateAllocationList(source);
			addedElements = false;
		}
		children.streamInstanceAllocators().forEach(c -> c.update(context));
	}

	public void add(List<ILilyEObject> children)
	{
		if (addedElements == false)
		{
			whenBranchDirty.run();
			addedElements = true;
		}
	}

	public void remove(List<ILilyEObject> removedChildren)
	{
		final boolean wasEmpty = removedElements.isEmpty();
		children.stream()
				.filter(a -> removedChildren.contains(a.target()))
				.collect(Collectors.toCollection(() -> removedElements));
		if (wasEmpty && removedElements.isEmpty() == false)
		{
			whenBranchDirty.run();
		}
	}

	public int getIndex()
	{
		return index;
	}

	public void markChildrenObsolete()
	{
		children.streamInstanceAllocators().forEach(ChildInstanceAllocator::markChildrenObsolete);
	}

	public static record Builder(int index, StructureObserver.Builder structureObservatoryBuilder, boolean buildStatusListener)
	{
		public Builder(final ILilyEObject source, final AllocationChild childAnnotation, int index)
		{
			this(index, buildStructureObserverBuilder(source, childAnnotation), childAnnotation.reportStateToParent());
		}

		private static StructureObserver.Builder buildStructureObserverBuilder(final ILilyEObject source,
																			   final AllocationChild childAnnotation)
		{
			final var parentClass = childAnnotation.parent();
			final var parentDistance = ModelUtil.parentDistance(source, parentClass);
			return new StructureObserver.Builder(parentDistance, childAnnotation.features());
		}

		public ChildrenSupervisor build(final IAllocationChildrenManager.Configuration config)
		{
			final var structureObserver = structureObservatoryBuilder.build(config.observatoryBuilder());
			final var modelExplorer = structureObservatoryBuilder.buildExplorer();
			final var statusListener = getStatusListener(config);

			return new ChildrenSupervisor(structureObserver,
										  modelExplorer,
										  config.whenBranchDirty(),
										  statusListener,
										  index);
		}

		private Optional<Consumer<EAllocationStatus>> getStatusListener(final IAllocationChildrenManager.Configuration config)
		{
			return buildStatusListener ? Optional.of(config::reactOnStatusChange) : Optional.empty();
		}
	}
}
