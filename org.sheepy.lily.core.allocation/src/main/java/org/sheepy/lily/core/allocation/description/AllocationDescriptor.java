package org.sheepy.lily.core.allocation.description;

import org.sheepy.lily.core.allocation.AllocationHandle;
import org.sheepy.lily.core.allocation.children.manager.AllocationChildrenBuilder;
import org.sheepy.lily.core.allocation.dependency.DependencyManager;
import org.sheepy.lily.core.allocation.dependency.DependencyResolver;
import org.sheepy.lily.core.allocation.instance.AllocationInstanceBuilder;
import org.sheepy.lily.core.allocation.instance.AllocationState;
import org.sheepy.lily.core.allocation.parameter.AllocationParametersBuilder;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.ProvideContext;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderDescriptor;
import org.sheepy.lily.core.api.extender.IExtenderHandle;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public record AllocationDescriptor<Allocation extends IExtender>(IExtenderDescriptor<Allocation> extenderDescriptor,
																 DependencyManager.Builder dependencyManagerBuilder,
																 AllocationChildrenBuilder allocationChildrenBuilder,
																 AllocationParametersBuilder allocationParametersBuilder,
																 int activator,
																 boolean provideContext,
																 boolean reuseDirtyAllocations)
{
	public AllocationInstanceBuilder<Allocation> prepareBuild(final ILilyEObject target,
															  final Runnable whenUpdateNeeded)
	{
		final var observatoryBuilder = IObservatoryBuilder.newObservatoryBuilder();
		final var state = new AllocationState(whenUpdateNeeded);
		final var buildContext = new AllocationChildrenBuilder.BuildContext(state::markBranchDirty,
																			target,
																			observatoryBuilder);
		final var preChildrenManager = allocationChildrenBuilder.buildPreAllocation(buildContext);
		final var preObservatory = observatoryBuilder.isEmpty() == false ? observatoryBuilder.build() : null;
		if (preObservatory != null) preObservatory.observe(target);

		return new AllocationInstanceBuilder<>(target, preChildrenManager, this, preObservatory, state);
	}

	public Stream<AllocationHandle<Allocation>> adaptHandles(Stream<ILilyEObject> objectStream)
	{
		return objectStream.filter(extenderDescriptor::isApplicable)
						   .map(extenderDescriptor::adapHandle)
						   .map(this::castHandle);
	}

	private AllocationHandle<Allocation> castHandle(IExtenderHandle<Allocation> handle)
	{
		return (AllocationHandle<Allocation>) handle;
	}

	@Override
	public boolean equals(final Object o)
	{
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final AllocationDescriptor<?> that = (AllocationDescriptor<?>) o;
		return extenderDescriptor.equals(that.extenderDescriptor);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(extenderDescriptor);
	}

	@Override
	public String toString()
	{
		return "AllocationDescriptor{" + extenderDescriptor.extenderClass().getSimpleName() + '}';
	}

	public static final class Builder<Allocation extends IExtender>
	{
		private final IExtenderDescriptor<Allocation> extenderDescriptor;

		public Builder(IExtenderDescriptor<Allocation> extenderDescriptor)
		{
			this.extenderDescriptor = extenderDescriptor;
		}

		public AllocationDescriptor<Allocation> build()
		{
			final var dependencyResolvers = List.copyOf(createResolverBuilders());
			final var childAnnotations = List.of(extenderDescriptor.extenderClass()
																   .getAnnotationsByType(AllocationChild.class));
			final var provideContext = extenderDescriptor.streamMethodAnnotations(ProvideContext.class)
														 .findAny()
														 .isPresent();
			final var annotation = extenderDescriptor.extenderClass()
													 .getAnnotation(org.sheepy.lily.core.api.allocation.annotation.Allocation.class);

			final var reuseDirtyAllocations = annotation.reuseDirtyAllocations();

			final var childrenManagerBuilder = new AllocationChildrenBuilder(childAnnotations);
			final var allocationParametersBuilder = new AllocationParametersBuilder(dependencyResolvers);
			final var dependencyManagerBuilder = new DependencyManager.Builder(dependencyResolvers);

			return new AllocationDescriptor<>(extenderDescriptor,
											  dependencyManagerBuilder,
											  childrenManagerBuilder,
											  allocationParametersBuilder,
											  annotation.activator(),
											  provideContext,
											  reuseDirtyAllocations);
		}

		private List<DependencyResolver> createResolverBuilders()
		{
			final var allocationClass = extenderDescriptor.extenderClass();
			final var dependencyAnnotations = allocationClass.getAnnotationsByType(AllocationDependency.class);
			final List<DependencyResolver> resolvers = new ArrayList<>(dependencyAnnotations.length);
			for (int i = 0; i < dependencyAnnotations.length; i++)
			{
				final var dependencyAnnotation = dependencyAnnotations[i];
				resolvers.add(new DependencyResolver(dependencyAnnotation, i));
			}
			return resolvers;
		}
	}
}
