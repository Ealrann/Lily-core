package org.sheepy.lily.core.allocation.children.manager;

import org.logoce.extender.api.IAdapterDescriptor;
import org.logoce.extender.api.IAdapterHandle;
import org.sheepy.lily.core.allocation.children.instance.ChildrenSupervisor;
import org.sheepy.lily.core.allocation.util.StructureObserver;
import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.sheepy.lily.core.api.allocation.annotation.InjectChildren;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public final class AllocationChildrenBuilder
{
	private final List<ChildrenSupervisor.Builder> preChildrenBuilders;
	private final List<ChildrenPreBuilder> postChildrenPreBuilders;

	public AllocationChildrenBuilder(final List<AllocationChild> childAnnotations)
	{
		final List<ChildrenPreBuilder> preList = new ArrayList<>();
		final List<ChildrenPreBuilder> postList = new ArrayList<>();
		for (int i = 0; i < childAnnotations.size(); i++)
		{
			final var annotation = childAnnotations.get(i);
			final var entry = buildEntry(annotation, i);
			final var trgList = annotation.allocateBeforeParent() ? preList : postList;
			trgList.add(entry);
		}

		preChildrenBuilders = preList.stream()
									 .map(b -> b.build(List.of()))
									 .toList();
		postChildrenPreBuilders = List.copyOf(postList);
	}

	private static ChildrenPreBuilder buildEntry(final AllocationChild childAnnotation, final int index)
	{
		return new ChildrenPreBuilder(childAnnotation, index);
	}

	public AllocationChildrenManager buildPreAllocation(final BuildContext buildContext)
	{
		final var childrenSupervisors = preChildrenBuilders.stream()
														   .map(buildContext::build)
														   .toList();

		return new AllocationChildrenManager(childrenSupervisors, null);
	}

	public AllocationChildrenManager buildPostAllocation(final BuildContext buildContext,
														 final Optional<IAllocationContext> providedContext,
														 final IAdapterDescriptor.ExtenderContext<?> extenderContext)
	{
		final var annotationHandles = extenderContext.annotationHandles()
													 .stream(InjectChildren.class)
													 .toList();

		final var postChildEntryBuilders = postChildrenPreBuilders.stream()
																  .map(preBuilder -> preBuilder.build(annotationHandles))
																  .toList();

		final var childrenSupervisors = postChildEntryBuilders.stream()
															  .map(buildContext::build)
															  .toList();

		return new AllocationChildrenManager(childrenSupervisors, providedContext);
	}

	public record BuildContext(Runnable whenBranchDirty, ILilyEObject target, IObservatoryBuilder observatoryBuilder)
	{
		public ChildrenSupervisor build(ChildrenSupervisor.Builder builder)
		{
			return builder.build(whenBranchDirty, observatoryBuilder, target);
		}
	}

	public record ChildrenPreBuilder(int index, StructureObserver structureObservatory)
	{
		public ChildrenPreBuilder(final AllocationChild childAnnotation, final int index)
		{
			this(index, buildStructureObserver(childAnnotation));
		}

		private static StructureObserver buildStructureObserver(final AllocationChild childAnnotation)
		{
			return new StructureObserver(childAnnotation.parent(), childAnnotation.features());
		}

		public ChildrenSupervisor.Builder build(final List<IAdapterHandle.AnnotatedHandle<InjectChildren>> annotationHandles)
		{
			final var childrenInjectors = new AnnotationFilter(annotationHandles, index).stream()
																						.map(ChildrenInjector::new)
																						.toList();

			return new ChildrenSupervisor.Builder(structureObservatory, childrenInjectors);
		}

		public record AnnotationFilter(List<IAdapterHandle.AnnotatedHandle<InjectChildren>> annotationHandles,
									   int index)
		{
			public Stream<IAdapterHandle.AnnotatedHandle<InjectChildren>> stream()
			{
				return annotationHandles.stream()
										.filter(this::match);
			}

			private boolean match(final IAdapterHandle.AnnotatedHandle<InjectChildren> h)
			{
				return h.annotation()
						.index() == index;
			}
		}
	}
}
