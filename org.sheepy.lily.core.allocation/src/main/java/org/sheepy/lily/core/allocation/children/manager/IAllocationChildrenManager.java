package org.sheepy.lily.core.allocation.children.manager;

import org.sheepy.lily.core.api.allocation.EAllocationStatus;
import org.sheepy.lily.core.allocation.children.instance.ChildrenSupervisor;
import org.sheepy.lily.core.allocation.instance.FreeContext;
import org.sheepy.lily.core.allocation.util.StructureObserver;
import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.sheepy.lily.core.api.allocation.annotation.InjectChildren;
import org.sheepy.lily.core.api.extender.IExtenderDescriptor;
import org.sheepy.lily.core.api.extender.IExtenderHandle;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.core.api.util.AnnotationHandles;
import org.sheepy.lily.core.api.util.IModelExplorer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public interface IAllocationChildrenManager
{
	void update(ILilyEObject source, final IAllocationContext context);
	void cleanup(final FreeContext context);
	boolean isDirty();
	void markChildrenObsolete();

	final class Builder
	{
		private final ILilyEObject target;
		private final List<ChildrenSupervisor.Builder> preChildEntryBuilders;
		private final List<ChildrenSupervisor.Builder> postChildEntryBuilders;

		public Builder(final List<AllocationChild> childAnnotations, final ILilyEObject target)
		{
			this.target = target;

			final List<ChildrenSupervisor.Builder> preList = new ArrayList<>();
			final List<ChildrenSupervisor.Builder> postList = new ArrayList<>();
			for (int i = 0; i < childAnnotations.size(); i++)
			{
				final var annotation = childAnnotations.get(i);
				final var entry = buildEntry(annotation, i);
				final var trgList = annotation.allocateBeforeParent() ? preList : postList;
				trgList.add(entry);
			}

			preChildEntryBuilders = List.copyOf(preList);
			postChildEntryBuilders = List.copyOf(postList);
		}

		private ChildrenSupervisor.Builder buildEntry(final AllocationChild childAnnotation, int index)
		{
			return new ChildrenSupervisor.Builder(target, childAnnotation, index);
		}

		public IAllocationChildrenManager buildPreAllocation(final Configuration config)
		{
			return new AllocationChildrenManager(preChildEntryBuilders, config);
		}

		@SuppressWarnings("unchecked")
		public IAllocationChildrenManager buildPostAllocation(final Configuration config,
															  final Supplier<IAllocationContext> contextProvider,
															  final IExtenderDescriptor.ExtenderContext<?> extenderContext)
		{
			final var childrenInjectors = extenderContext.annotationHandles()
														 .stream()
														 .filter(h -> h.match(InjectChildren.class))
														 .map(h -> (AnnotationHandles<InjectChildren>) h)
														 .flatMap(AnnotationHandles::stream)
														 .map(this::buildChildrenInjector)
														 .collect(Collectors.toUnmodifiableList());

			if (contextProvider == null && childrenInjectors.isEmpty())
			{
				return new AllocationChildrenManager(postChildEntryBuilders, config);
			}
			else
			{
				return new ContextAllocationChildrenManager(postChildEntryBuilders,
															config,
															contextProvider,
															childrenInjectors);
			}
		}

		public ChildrenInjector buildChildrenInjector(IExtenderHandle.AnnotatedHandle<InjectChildren> handle)
		{
			final var childrenExplorer = getChildrenExplorer(handle.annotation().index());
			return new ChildrenInjector(handle, childrenExplorer);
		}

		public IModelExplorer getChildrenExplorer(final int index)
		{
			return postChildEntryBuilders.stream()
										 .filter(b -> b.index() == index)
										 .findAny()
										 .map(ChildrenSupervisor.Builder::structureObservatoryBuilder)
										 .map(StructureObserver.Builder::buildExplorer)
										 .orElse(null);
		}
	}

	record Configuration(Runnable whenBranchDirty, Runnable whenDirty, Runnable whenObsolete,
						 IObservatoryBuilder observatoryBuilder)
	{
		public void reactOnStatusChange(EAllocationStatus newStatus)
		{
			switch (newStatus)
			{
				case Dirty -> whenDirty.run();
				case Obsolete -> whenObsolete.run();
			}
		}
	}
}
