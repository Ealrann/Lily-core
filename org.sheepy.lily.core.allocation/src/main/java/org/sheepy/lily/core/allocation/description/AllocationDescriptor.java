package org.sheepy.lily.core.allocation.description;

import org.sheepy.lily.core.allocation.AllocationInstance;
import org.sheepy.lily.core.allocation.dependency.DependencyResolvers;
import org.sheepy.lily.core.allocation.dependency.DependencyResolver;
import org.sheepy.lily.core.allocation.dependency.container.IDependencyContainer;
import org.sheepy.lily.core.allocation.parameter.ContextParameterResolverBuilder;
import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.DirtyAllocation;
import org.sheepy.lily.core.api.allocation.annotation.LockAllocation;
import org.sheepy.lily.core.api.allocation.annotation.UpdateDependency;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderDescriptor;
import org.sheepy.lily.core.api.extender.IExtenderHandle;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.core.api.reflect.ConsumerHandle;
import org.sheepy.lily.core.api.util.AnnotationHandles;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class AllocationDescriptor<Allocation extends IExtender>
{
	private final IExtenderDescriptor<Allocation> extenderDescriptor;
	private final List<DependencyResolver.Builder> builders;
	private final boolean hasDirtyMethod;
	private final boolean hasLockMethod;

	public AllocationDescriptor(IExtenderDescriptor<Allocation> extenderDescriptor)
	{
		this.extenderDescriptor = extenderDescriptor;
		hasDirtyMethod = extenderDescriptor.containsMethodAnnotation(DirtyAllocation.class);
		hasLockMethod = extenderDescriptor.containsMethodAnnotation(LockAllocation.class);
		builders = List.copyOf(createResolverBuilders());
	}

	public AllocationInstance<Allocation> newHandle(final ILilyEObject target,
													final DependencyResolvers resolvers,
													final IAllocationContext context) throws ReflectiveOperationException
	{
		final var builder = new InstanceBuilder<>(this, target, resolvers, context);
		return builder.build();
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

	@Override
	public String toString()
	{
		return "AllocationDescriptor{" + extenderDescriptor.extenderClass().getSimpleName() + '}';
	}

	public Class<Allocation> extenderClass()
	{
		return extenderDescriptor.extenderClass();
	}

	private static final class InstanceBuilder<Allocation extends IExtender>
	{
		private final AllocationDescriptor<Allocation> descriptor;
		private final ILilyEObject target;
		private final DependencyResolvers resolvers;
		private final IAllocationContext context;

		private InstanceBuilder(final AllocationDescriptor<Allocation> descriptor,
								final ILilyEObject target,
								final DependencyResolvers resolvers,
								final IAllocationContext context)
		{
			this.descriptor = descriptor;
			this.target = target;
			this.resolvers = resolvers;
			this.context = context;
		}

		public AllocationInstance<Allocation> build() throws ReflectiveOperationException
		{
			final var observatory = IObservatoryBuilder.newObservatoryBuilder();
			final var resolverBuilders = List.of(new ContextParameterResolverBuilder(context),
												 resolvers.getParameterResolverBuilder());
			final var extenderContext = descriptor.extenderDescriptor.newExtender(target,
																				  observatory,
																				  resolverBuilders);
			final var updatableDependencies = gatherUpdatableDependencies(extenderContext);
			final var criticalDependencies = filterCriticalDependencies(updatableDependencies);

			return new AllocationInstance<>(extenderContext,
											observatory.build(),
											descriptor.hasDirtyMethod,
											descriptor.hasLockMethod,
											updatableDependencies,
											criticalDependencies);
		}

		private List<IDependencyContainer> filterCriticalDependencies(final List<DependencyPointer> updatableDependencies)
		{
			return resolvers.stream()
							.filter(resolver -> updatableDependencies.stream()
																	 .map(DependencyPointer::resolver)
																	 .noneMatch(res -> res == resolver))
							.flatMap(DependencyResolver::streamDependencies)
							.collect(Collectors.toUnmodifiableList());
		}

		@SuppressWarnings("unchecked")
		private List<DependencyPointer> gatherUpdatableDependencies(final IExtenderDescriptor.ExtenderContext<?> extenderContext)
		{
			final var updatableDependencies = extenderContext.annotationHandles()
															 .stream()
															 .filter(handle -> handle.annotationClass() == UpdateDependency.class)
															 .map(handle -> (AnnotationHandles<UpdateDependency>) handle)
															 .flatMap(handle -> handle.handles().stream())
															 .map(this::newDependencyPointer)
															 .collect(Collectors.toUnmodifiableList());
			return updatableDependencies;
		}

		private DependencyPointer newDependencyPointer(final IExtenderHandle.AnnotatedHandle<UpdateDependency> handle)
		{
			final var resolver = resolvers.get(handle.annotation().index());
			return new DependencyPointer(resolver, (ConsumerHandle) handle.executionHandle());
		}
	}
}
