package org.sheepy.lily.core.allocation;

import org.sheepy.lily.core.allocation.children.AllocationChildrenManager;
import org.sheepy.lily.core.allocation.children.ChildrenInjector;
import org.sheepy.lily.core.allocation.dependency.DependencyManager;
import org.sheepy.lily.core.allocation.dependency.DependencyResolution;
import org.sheepy.lily.core.allocation.dependency.DependencyResolver;
import org.sheepy.lily.core.allocation.dependency.DependencyUpdater;
import org.sheepy.lily.core.allocation.description.AllocationDescriptor;
import org.sheepy.lily.core.allocation.parameter.ConfiguratorParameterBuilder;
import org.sheepy.lily.core.allocation.parameter.ContextParameterResolverBuilder;
import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.core.api.allocation.IAllocationInstance;
import org.sheepy.lily.core.api.allocation.annotation.Free;
import org.sheepy.lily.core.api.allocation.annotation.InjectChildren;
import org.sheepy.lily.core.api.allocation.annotation.ProvideContext;
import org.sheepy.lily.core.api.allocation.annotation.UpdateDependency;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderDescriptor;
import org.sheepy.lily.core.api.extender.IExtenderHandle;
import org.sheepy.lily.core.api.extender.parameter.IParameterResolver;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.notification.observatory.IObservatory;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.core.api.notification.util.ListenerList;
import org.sheepy.lily.core.api.reflect.ConsumerHandle;
import org.sheepy.lily.core.api.reflect.SupplierHandle;
import org.sheepy.lily.core.api.util.AnnotationHandles;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class AllocationInstance<Allocation extends IExtender> implements IAllocationInstance
{
	private final Allocation extender;
	private final IObservatory observatory;
	private final List<? extends AnnotationHandles<?>> annotationHandles;
	private final AllocationConfigurator configurator;
	private final List<ChildrenInjector> childrenInjectors;
	private final Runnable onUpdateNeeded;
	private final DependencyManager dependencyManager;
	private final ListenerList<Consumer<AllocationInstance<Allocation>>> listeners = new ListenerList<>();

	private EAllocationStatus status = EAllocationStatus.Allocated;

	public AllocationInstance(final IExtenderDescriptor.ExtenderContext<Allocation> extenderContext,
							  final IObservatory observatory,
							  final List<DependencyUpdater.Builder> updatableDependencies,
							  final List<DependencyResolution.Builder> criticalDependencies,
							  final AllocationConfigurator configurator,
							  final List<ChildrenInjector> childrenInjectors,
							  final Runnable whenUpdateNeeded)
	{
		this.extender = extenderContext.extender();
		this.annotationHandles = extenderContext.annotationHandles();
		this.observatory = observatory;
		this.configurator = configurator;
		this.childrenInjectors = childrenInjectors;
		this.onUpdateNeeded = whenUpdateNeeded;
		this.dependencyManager = new DependencyManager(updatableDependencies,
													   criticalDependencies,
													   this::markDirty,
													   this::markObsolete);

		if (configurator != null)
		{
			configurator.setCallbacks(this::markObsolete, this::whenUnlocked);
		}
	}

	public void load(ILilyEObject target)
	{
		if (observatory != null) observatory.observe(target);
	}

	public void injectChildren(ILilyEObject source)
	{
		for (final var childInjector : childrenInjectors)
		{
			childInjector.inject(source);
		}
	}

	public void update(ILilyEObject target)
	{
		dependencyManager.update(target);
		setStatus(EAllocationStatus.Allocated);
	}

	public void free(IAllocationContext context, ILilyEObject target)
	{
		if (observatory != null) observatory.shut(target);
		dependencyManager.free();

		annotatedHandles(Free.class).forEach(freeHandle -> ((ConsumerHandle) freeHandle.executionHandle()).invoke(
				context));

		setStatus(EAllocationStatus.Free);
	}

	private void whenUnlocked()
	{
		if (status != EAllocationStatus.Allocated)
		{
			onUpdateNeeded.run();
		}
	}

	private void markObsolete()
	{
		if (status != EAllocationStatus.Obsolete)
		{
			setStatus(EAllocationStatus.Obsolete);
			onUpdateNeeded.run();
		}
	}

	private void markDirty()
	{
		if (status == EAllocationStatus.Allocated)
		{
			setStatus(EAllocationStatus.Dirty);
			onUpdateNeeded.run();
		}
	}

	public boolean isLocked()
	{
		return configurator != null && configurator.isLocked();
	}

	public boolean isUnlocked()
	{
		return !isLocked();
	}

	private void setStatus(EAllocationStatus status)
	{
		this.status = status;
		listeners.notify(listener -> listener.accept(this));
	}

	public EAllocationStatus getStatus()
	{
		return status;
	}

	public void listen(Consumer<AllocationInstance<Allocation>> listener)
	{
		listeners.listen(listener);
	}

	public void sulk(Consumer<AllocationInstance<Allocation>> listener)
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

	public IAllocationContext getProvidedContext()
	{
		return annotatedHandles(ProvideContext.class).map(IExtenderHandle.AnnotatedHandle::executionHandle)
													 .map(SupplierHandle.class::cast)
													 .map(SupplierHandle::invoke)
													 .map(IAllocationContext.class::cast)
													 .findAny()
													 .orElse(null);
	}

	public static final class Builder<Allocation extends IExtender>
	{
		private final AllocationDescriptor<Allocation> descriptor;
		private final ILilyEObject target;
		private final List<DependencyResolver> resolvers;
		private final ChildrenInjector.Builder childrenInjectorBuilder;

		public Builder(final AllocationDescriptor<Allocation> descriptor,
					   final ILilyEObject target,
					   final List<DependencyResolver> resolvers,
					   final AllocationChildrenManager childrenManager)
		{
			this.descriptor = descriptor;
			this.target = target;
			this.resolvers = resolvers;
			childrenInjectorBuilder = new ChildrenInjector.Builder(childrenManager);
		}

		@SuppressWarnings("unchecked")
		public AllocationInstance<Allocation> build(final IAllocationContext context,
													Runnable whenUpdateNeeded) throws ReflectiveOperationException
		{
			final var observatoryBuilder = IObservatoryBuilder.newObservatoryBuilder();
			final var configuratorBuilder = new ConfiguratorParameterBuilder();
			final var parameterResolvers = new ArrayList<IParameterResolver>(this.resolvers.size() + 2);
			parameterResolvers.add(new ContextParameterResolverBuilder(context));
			parameterResolvers.add(configuratorBuilder);
			parameterResolvers.addAll(this.resolvers);
			final var extenderContext = descriptor.getExtenderDescriptor()
												  .newExtender(target, observatoryBuilder, parameterResolvers);
			final var updatableDependencies = gatherUpdatableDependencies(extenderContext);
			final var criticalDependencies = filterCriticalDependencies(updatableDependencies);

			final var childrenInjectors = extenderContext.annotationHandles()
														 .stream()
														 .filter(h -> h.match(InjectChildren.class))
														 .map(h -> (AnnotationHandles<InjectChildren>) h)
														 .flatMap(AnnotationHandles::stream)
														 .map(childrenInjectorBuilder::build)
														 .collect(Collectors.toUnmodifiableList());

			final var observatory = observatoryBuilder.isEmpty() == false ? observatoryBuilder.build() : null;
			return new AllocationInstance<>(extenderContext,
											observatory,
											updatableDependencies,
											criticalDependencies,
											configuratorBuilder.getConfigurator(),
											childrenInjectors,
											whenUpdateNeeded);
		}

		@SuppressWarnings("unchecked")
		private List<DependencyUpdater.Builder> gatherUpdatableDependencies(final IExtenderDescriptor.ExtenderContext<?> extenderContext)
		{
			final var updatableDependencies = extenderContext.annotationHandles()
															 .stream()
															 .filter(handle -> handle.annotationClass() == UpdateDependency.class)
															 .map(handle -> (AnnotationHandles<UpdateDependency>) handle)
															 .flatMap(handle -> handle.handles().stream())
															 .map(this::newDependencyUpdater)
															 .collect(Collectors.toUnmodifiableList());
			return updatableDependencies;
		}

		private List<DependencyResolution.Builder> filterCriticalDependencies(final List<DependencyUpdater.Builder> updatableDependencies)
		{
			return resolvers.stream()
							.filter(resolver -> updatableDependencies.stream()
																	 .map(DependencyUpdater.Builder::resolutionBuilder)
																	 .map(DependencyResolution.Builder::resolver)
																	 .noneMatch(res -> res == resolver))
							.map(resolver -> new DependencyResolution.Builder(resolver, target))
							.collect(Collectors.toUnmodifiableList());
		}

		private DependencyUpdater.Builder newDependencyUpdater(final IExtenderHandle.AnnotatedHandle<UpdateDependency> handle)
		{
			final var resolver = resolvers.get(handle.annotation().index());
			final var resolutionBuilder = new DependencyResolution.Builder(resolver, target);
			return new DependencyUpdater.Builder(resolutionBuilder, handle);
		}
	}
}
