package org.sheepy.lily.core.allocation;

import org.sheepy.lily.core.allocation.dependency.DependencyResolver;
import org.sheepy.lily.core.allocation.dependency.DependencyResolvers;
import org.sheepy.lily.core.allocation.parameter.ContextParameterResolverBuilder;
import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.Dirty;
import org.sheepy.lily.core.api.allocation.annotation.UpdateDependency;
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
	private final boolean dirtyMethod;

	public AllocationDescriptor(IExtenderDescriptor<Allocation> extenderDescriptor)
	{
		this.extenderDescriptor = extenderDescriptor;
		dirtyMethod = extenderDescriptor.containsMethodAnnotation(Dirty.class);
		builders = List.copyOf(createResolverBuilders());
	}

	public AllocationExtenderContainer<Allocation> newHandle(final ILilyEObject target,
															 final DependencyResolvers resolvers,
															 final IAllocationContext context) throws ReflectiveOperationException
	{
		final var observatory = IObservatoryBuilder.newObservatoryBuilder();
		final var resolverBuilders = List.of(new ContextParameterResolverBuilder(context), resolvers.getBuilder());
		final var extenderContext = extenderDescriptor.newExtender(target, observatory, resolverBuilders);
		return new AllocationExtenderContainer<>(extenderContext, observatory.build(), hasDirtyMethod());
	}

	public DependencyResolvers createResolvers()
	{
		final List<DependencyResolver> resolvers = new ArrayList<>();
		for (final var builder : builders)
		{
			resolvers.add(builder.build());
		}
		return new DependencyResolvers(resolvers);
	}

	private List<DependencyResolver.Builder> createResolverBuilders()
	{
		final Class<Allocation> allocationClass = extenderDescriptor.extenderClass();
		final var dependencyAnnotations = allocationClass.getAnnotationsByType(AllocationDependency.class);
		final List<DependencyResolver.Builder> resolvers = new ArrayList<>(dependencyAnnotations.length);
		for (int i = 0; i < dependencyAnnotations.length; i++)
		{
			final var dependencyAnnotation = dependencyAnnotations[i];
			final var critical = !hasUpdateMethodForIndex(i);
			resolvers.add(new DependencyResolver.Builder(dependencyAnnotation, i, critical));
		}
		return resolvers;
	}

	public boolean hasDirtyMethod()
	{
		return dirtyMethod;
	}

	private boolean hasUpdateMethodForIndex(int index)
	{
		return extenderDescriptor.streamMethodAnnotations(UpdateDependency.class).anyMatch(a -> a.index() == index);
	}

	@Override
	public String toString()
	{
		return "AllocationDescriptor{" + extenderDescriptor.extenderClass().getSimpleName() + '}';
	}

	public Class<Allocation> extenderClass()
	{
		return extenderDescriptor.extenderClass();
	}
}
