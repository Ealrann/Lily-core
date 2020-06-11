package org.sheepy.lily.core.allocation.description;

import org.sheepy.lily.core.allocation.dependency.DependencyResolver;
import org.sheepy.lily.core.allocation.dependency.DependencyResolvers;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderDescriptor;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;

import java.util.ArrayList;
import java.util.List;

public final class AllocationDescriptor<Allocation extends IExtender>
{
	private final IExtenderDescriptor<Allocation> extenderDescriptor;
	private final List<DependencyResolver.Builder> builders;
	private final List<AllocationChild> childAnnotations;

	public AllocationDescriptor(IExtenderDescriptor<Allocation> extenderDescriptor)
	{
		this.extenderDescriptor = extenderDescriptor;
		builders = List.copyOf(createResolverBuilders());
		childAnnotations = List.of(extenderDescriptor.extenderClass().getAnnotationsByType(AllocationChild.class));
	}

	public DependencyResolvers createResolvers(IObservatoryBuilder observatory, ILilyEObject source)
	{
		final List<DependencyResolver> resolvers = new ArrayList<>();
		for (final var builder : builders)
		{
			resolvers.add(builder.build(observatory, source));
		}
		return new DependencyResolvers(resolvers);
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

	@Override
	public String toString()
	{
		return "AllocationDescriptor{" + extenderDescriptor.extenderClass().getSimpleName() + '}';
	}
}
