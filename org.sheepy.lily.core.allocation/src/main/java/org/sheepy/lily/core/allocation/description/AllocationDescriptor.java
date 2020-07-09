package org.sheepy.lily.core.allocation.description;

import org.sheepy.lily.core.allocation.dependency.DependencyResolver;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.ProvideContext;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderDescriptor;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public record AllocationDescriptor<Allocation extends IExtender>(IExtenderDescriptor<Allocation>extenderDescriptor,
																 List<DependencyResolver.Builder>dependencyResolverBuilders,
																 List<AllocationChild>childAnnotations,
																 boolean provideContext,
																 boolean reuseDirtyAllocations)
{
	public List<DependencyResolver> createResolvers(IObservatoryBuilder observatory, ILilyEObject source)
	{
		return dependencyResolverBuilders.stream()
										 .map(builder -> builder.build(observatory, source))
										 .collect(Collectors.toUnmodifiableList());
	}

	public Class<Allocation> extenderClass()
	{
		return extenderDescriptor.extenderClass();
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
			final var builders = List.copyOf(createResolverBuilders());
			final var childAnnotations = List.of(extenderDescriptor.extenderClass()
																   .getAnnotationsByType(AllocationChild.class));
			final var provideContext = extenderDescriptor.streamMethodAnnotations(ProvideContext.class)
														 .findAny()
														 .isPresent();
			final var annotation = extenderDescriptor.extenderClass()
													 .getAnnotation(org.sheepy.lily.core.api.allocation.annotation.Allocation.class);
			final var reuseDirtyAllocations = annotation.reuseDirtyAllocations();

			return new AllocationDescriptor<>(extenderDescriptor,
											  builders,
											  childAnnotations,
											  provideContext,
											  reuseDirtyAllocations);
		}

		private List<DependencyResolver.Builder> createResolverBuilders()
		{
			final var allocationClass = extenderDescriptor.extenderClass();
			final var dependencyAnnotations = allocationClass.getAnnotationsByType(AllocationDependency.class);
			final List<DependencyResolver.Builder> resolvers = new ArrayList<>(dependencyAnnotations.length);
			for (int i = 0; i < dependencyAnnotations.length; i++)
			{
				final var dependencyAnnotation = dependencyAnnotations[i];
				resolvers.add(new DependencyResolver.Builder(dependencyAnnotation, i));
			}
			return resolvers;
		}
	}
}
