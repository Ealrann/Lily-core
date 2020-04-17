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

public final class AllocationDescriptor<Allocation extends IExtender>
{
	private final IExtenderDescriptor<Allocation> extenderDescriptor;
	private final List<DependencyResolver.Builder> builders;
	private final List<AllocationChild> childAnnotations;
	private final boolean provideContext;

	public AllocationDescriptor(IExtenderDescriptor<Allocation> extenderDescriptor)
	{
		this.extenderDescriptor = extenderDescriptor;
		builders = List.copyOf(createResolverBuilders());
		childAnnotations = List.of(extenderDescriptor.extenderClass().getAnnotationsByType(AllocationChild.class));
		provideContext = extenderDescriptor.streamMethodAnnotations(ProvideContext.class).findAny().isPresent();
	}

	public List<DependencyResolver> createResolvers(IObservatoryBuilder observatory, ILilyEObject source)
	{
		return builders.stream()
					   .map(builder -> builder.build(observatory, source))
					   .collect(Collectors.toUnmodifiableList());
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

	public List<AllocationChild> getChildrenAnnotations()
	{
		return childAnnotations;
	}

	public Class<Allocation> extenderClass()
	{
		return extenderDescriptor.extenderClass();
	}

	public IExtenderDescriptor<Allocation> getExtenderDescriptor()
	{
		return extenderDescriptor;
	}

	public boolean isProvidingContext()
	{
		return provideContext;
	}

	@Override
	public String toString()
	{
		return "AllocationDescriptor{" + extenderDescriptor.extenderClass().getSimpleName() + '}';
	}
}
