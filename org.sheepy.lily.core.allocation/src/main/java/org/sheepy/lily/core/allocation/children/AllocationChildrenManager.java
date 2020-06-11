package org.sheepy.lily.core.allocation.children;

import org.sheepy.lily.core.allocation.AllocationInstance;
import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.sheepy.lily.core.api.allocation.annotation.InjectChildren;
import org.sheepy.lily.core.api.extender.IExtenderDescriptor;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.core.api.util.AnnotationHandles;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class AllocationChildrenManager
{
	private final List<ChildEntryManager> childEntryManagers;

	public AllocationChildrenManager(List<ChildEntryManager> childEntryManagers)
	{
		this.childEntryManagers = List.copyOf(childEntryManagers);
	}

	public void update(final ILilyEObject target, AllocationInstance<?> parent)
	{
		for (final var childManager : childEntryManagers)
		{
			childManager.update(target, parent);
		}
	}

	public static final class Builder
	{
		private final List<AllocationChild> childAnnotations;
		private final ILilyEObject target;

		public Builder(List<AllocationChild> childAnnotations, final ILilyEObject target)
		{
			this.childAnnotations = List.copyOf(childAnnotations);
			this.target = target;
		}

		public AllocationChildrenManager build(final IExtenderDescriptor.ExtenderContext<?> extenderContext,
											   final IAllocationContext context,
											   final IObservatoryBuilder observatoryBuilder)
		{

			final int size = childAnnotations.size();
			final List<ChildEntryManager> res = new ArrayList<>(size);
			for (int i = 0; i < size; i++)
			{
				final ChildEntryManager result = buildChildEntryManager(extenderContext,
																		context,
																		observatoryBuilder,
																		i);
				res.add(result);
			}
			return new AllocationChildrenManager(res);
		}

		@SuppressWarnings("unchecked")
		private ChildEntryManager buildChildEntryManager(final IExtenderDescriptor.ExtenderContext<?> extenderContext,
														 final IAllocationContext context,
														 final IObservatoryBuilder observatoryBuilder,
														 final int index)
		{
			final var childAnnotation = childAnnotations.get(index);
			final var childrenInjectors = extenderContext.annotationHandles()
														 .stream()
														 .filter(h -> h.annotationClass() == InjectChildren.class)
														 .map(h -> (AnnotationHandles<InjectChildren>) h)
														 .flatMap(h -> h.handles().stream())
														 .filter(h -> h.annotation().index() == index)
														 .map(ChildrenInjector::new)
														 .collect(Collectors.toUnmodifiableList());

			return ChildEntryManager.newChildrenManager(target,
														observatoryBuilder,
														context,
														childAnnotation,
														childrenInjectors);
		}
	}
}
