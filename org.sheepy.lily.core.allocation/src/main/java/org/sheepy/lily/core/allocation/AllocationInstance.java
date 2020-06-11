package org.sheepy.lily.core.allocation;

import org.sheepy.lily.core.allocation.children.AllocationChildrenManager;
import org.sheepy.lily.core.allocation.dependency.DependencyManager;
import org.sheepy.lily.core.allocation.dependency.DependencyResolvers;
import org.sheepy.lily.core.allocation.dependency.DependencyUpdater;
import org.sheepy.lily.core.allocation.dependency.container.IDependencyContainer;
import org.sheepy.lily.core.allocation.description.AllocationDescriptor;
import org.sheepy.lily.core.allocation.parameter.ConfiguratorParameterBuilder;
import org.sheepy.lily.core.allocation.parameter.ContextParameterResolverBuilder;
import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.core.api.allocation.IAllocationInstance;
import org.sheepy.lily.core.api.allocation.annotation.Free;
import org.sheepy.lily.core.api.allocation.annotation.UpdateDependency;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderDescriptor;
import org.sheepy.lily.core.api.extender.IExtenderHandle;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.notification.observatory.IObservatory;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.core.api.notification.util.ListenerList;
import org.sheepy.lily.core.api.reflect.ConsumerHandle;
import org.sheepy.lily.core.api.util.AnnotationHandles;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class AllocationInstance<Allocation extends IExtender> implements IAllocationInstance
{
	private final AllocationInstance<?> parent;
	private final Allocation extender;
	private final IObservatory observatory;
	private final List<? extends AnnotationHandles<?>> annotationHandles;
	private final AllocationConfigurator configurator;
	private final AllocationChildrenManager childrenManager;
	private final DependencyManager dependencyManager;
	private final ListenerList<Consumer<EAllocationStatus>> listeners = new ListenerList<>();

	private EAllocationStatus status = EAllocationStatus.Allocated;

	public AllocationInstance(AllocationInstance<?> parent,
							  IExtenderDescriptor.ExtenderContext<Allocation> extenderContext,
							  IObservatory observatory,
							  List<DependencyUpdater> updatableDependencies,
							  List<IDependencyContainer> criticalDependencies,
							  AllocationConfigurator configurator,
							  AllocationChildrenManager childrenManager)
	{
		this.parent = parent;
		this.extender = extenderContext.extender();
		this.annotationHandles = extenderContext.annotationHandles();
		this.observatory = observatory;
		this.configurator = configurator;
		this.childrenManager = childrenManager;
		this.dependencyManager = new DependencyManager(updatableDependencies,
													   criticalDependencies,
													   this::markDirty,
													   this::markObsolete);

		if (configurator != null)
		{
			configurator.setCallbacks(this::markObsolete);
		}
	}

	public void load(ILilyEObject target)
	{
		if (observatory != null) observatory.observe(target);
		childrenManager.update(target, this);
	}

	public void update(ILilyEObject target)
	{
		childrenManager.update(target, this);
		dependencyManager.update(target);
		status = EAllocationStatus.Allocated;
	}

	public void free(IAllocationContext context, ILilyEObject target)
	{
		if (observatory != null) observatory.shut(target);
		dependencyManager.free();
		childrenManager.update(target, this);

		annotatedHandles(Free.class).forEach(freeHandle -> ((ConsumerHandle) freeHandle.executionHandle()).invoke(
				context));

		status = EAllocationStatus.Free;
	}

	private void markObsolete()
	{
		status = EAllocationStatus.Obsolete;
		notifyStatusChange();
		if (parent != null) parent.markDirty();
	}

	private void markDirty()
	{
		if (status == EAllocationStatus.Allocated)
		{
			status = EAllocationStatus.Dirty;
			notifyStatusChange();
			if (parent != null) parent.markDirty();
		}
	}

	private void notifyStatusChange()
	{
		listeners.notify(listener -> listener.accept(status));
	}

	private boolean isLocked()
	{
		return configurator.isLocked();
	}

	public boolean isUnlocked()
	{
		return !isLocked();
	}

	public EAllocationStatus getStatus()
	{
		return status;
	}

	public void listen(Consumer<EAllocationStatus> listener)
	{
		listeners.listen(listener);
	}

	public void sulk(Consumer<EAllocationStatus> listener)
	{
		listeners.sulk(listener);
	}

	@SuppressWarnings("unchecked")
	public <A extends Annotation> Stream<IExtenderHandle.AnnotatedHandle<A>> annotatedHandles(Class<A> annotationClass)
	{
		return annotationHandles.stream()
								.filter(h -> h.annotationClass().equals(annotationClass))
								.flatMap(h -> ((AnnotationHandles<A>) h).handles().stream());
	}

	public Allocation getAllocation()
	{
		return extender;
	}

	public static final class Builder<Allocation extends IExtender>
	{
		private final AllocationDescriptor<Allocation> descriptor;
		private final ILilyEObject target;
		private final DependencyResolvers resolvers;
		private final AllocationChildrenManager.Builder childrenManagerBuilder;

		public Builder(final AllocationDescriptor<Allocation> descriptor,
					   final ILilyEObject target,
					   final DependencyResolvers resolvers)
		{
			this.descriptor = descriptor;
			this.target = target;
			this.resolvers = resolvers;
			childrenManagerBuilder = new AllocationChildrenManager.Builder(descriptor.getChildrenAnnotations(), target);
		}

		public AllocationInstance<Allocation> build(final AllocationInstance<?> parent,
													final IAllocationContext context) throws ReflectiveOperationException
		{
			final var observatoryBuilder = IObservatoryBuilder.newObservatoryBuilder();
			final var configuratorBuilder = new ConfiguratorParameterBuilder();
			final var resolverBuilders = List.of(new ContextParameterResolverBuilder(context),
												 configuratorBuilder,
												 resolvers.getParameterResolverBuilder());
			final var extenderContext = descriptor.getExtenderDescriptor()
												  .newExtender(target, observatoryBuilder, resolverBuilders);
			final var updatableDependencies = gatherUpdatableDependencies(extenderContext);
			final var criticalDependencies = filterCriticalDependencies(updatableDependencies);

			final var childrenManager = childrenManagerBuilder.build(extenderContext, context, observatoryBuilder);
			final var observatory = observatoryBuilder.isEmpty() == false ? observatoryBuilder.build() : null;
			return new AllocationInstance<>(parent,
											extenderContext,
											observatory,
											updatableDependencies,
											criticalDependencies,
											configuratorBuilder.getConfigurator(),
											childrenManager);
		}

		@SuppressWarnings("unchecked")
		private List<DependencyUpdater> gatherUpdatableDependencies(final IExtenderDescriptor.ExtenderContext<?> extenderContext)
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

		private List<IDependencyContainer> filterCriticalDependencies(final List<DependencyUpdater> updatableDependencies)
		{
			return resolvers.stream()
							.filter(resolver -> updatableDependencies.stream()
																	 .map(DependencyUpdater::resolver)
																	 .noneMatch(res -> res == resolver))
							.flatMap(resolver -> resolver.resolveDependencies(target))
							.collect(Collectors.toUnmodifiableList());
		}

		private DependencyUpdater newDependencyPointer(final IExtenderHandle.AnnotatedHandle<UpdateDependency> handle)
		{
			final var resolver = resolvers.get(handle.annotation().index());
			return new DependencyUpdater(resolver, target, (ConsumerHandle) handle.executionHandle());
		}
	}
}
