package org.sheepy.lily.core.allocation.instance;

import org.sheepy.lily.core.allocation.EAllocationStatus;
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

public final class AllocationInstance<Allocation extends IExtender> implements IAllocationInstance<Allocation>
{
	private final ILilyEObject target;
	private final IObservatory observatory;
	private final AllocationState state;
	private final List<ChildrenInjector> childrenInjectors;
	private final boolean provideContext;
	private final DependencyManager dependencyManager;
	private final ListenerList<Consumer<AllocationInstance<Allocation>>> listeners = new ListenerList<>();
	private final AllocationChildrenManager preChildrenManager;
	private final AllocationChildrenManager postChildrenManager;
	private final IExtenderDescriptor.ExtenderContext<Allocation> extenderContext;

	@SuppressWarnings("unchecked")
	public AllocationInstance(final ILilyEObject target,
							  final AllocationDescriptor<Allocation> descriptor,
							  final ChildrenInjector.Builder childrenInjectorBuilder,
							  final List<DependencyResolver> resolvers,
							  final IAllocationContext context,
							  final Runnable whenUpdateNeeded,
							  final AllocationChildrenManager.Builder childrenManagerBuilder) throws ReflectiveOperationException
	{
		final var observatoryBuilder = IObservatoryBuilder.newObservatoryBuilder();
		this.target = target;
		this.provideContext = descriptor.isProvidingContext();

		state = new AllocationState(this::onStatusChange, whenUpdateNeeded);

		final var parameterResolvers = new ArrayList<IParameterResolver>(resolvers.size() + 2);
		parameterResolvers.add(new ContextParameterResolverBuilder(context));
		parameterResolvers.addAll(resolvers);
		parameterResolvers.add(new ConfiguratorParameterBuilder(state));

		preChildrenManager = childrenManagerBuilder.build(state::markBranchDirty, true, observatoryBuilder);
		postChildrenManager = childrenManagerBuilder.build(state::markBranchDirty, false, observatoryBuilder);

		observatory = observatoryBuilder.isEmpty() == false ? observatoryBuilder.build() : null;
		if (observatory != null) observatory.observe(target);

		preChildrenManager.update(target, context);
		extenderContext = descriptor.getExtenderDescriptor()
									.newExtender(target, observatoryBuilder, parameterResolvers);

		childrenInjectors = extenderContext.annotationHandles()
										   .stream()
										   .filter(h -> h.match(InjectChildren.class))
										   .map(h -> (AnnotationHandles<InjectChildren>) h)
										   .flatMap(AnnotationHandles::stream)
										   .map(childrenInjectorBuilder::build)
										   .collect(Collectors.toUnmodifiableList());

		final var updatableDependencies = gatherUpdatableDependencies(resolvers, extenderContext);
		final var criticalDependencies = filterCriticalDependencies(resolvers, updatableDependencies);
		this.dependencyManager = new DependencyManager(updatableDependencies,
													   criticalDependencies,
													   state::markDirty,
													   state::markObsolete);
	}

	public void load(final IAllocationContext context)
	{
		updatePostChildren(context);
	}

	private void onStatusChange(EAllocationStatus oldStatus, EAllocationStatus newStatus)
	{
		listeners.notify(listener -> listener.accept(this));
	}

	private List<DependencyResolution.Builder> filterCriticalDependencies(final List<DependencyResolver> resolvers,
																		  final List<DependencyUpdater.Builder> updatableDependencies)
	{
		return resolvers.stream()
						.filter(resolver -> updatableDependencies.stream()
																 .map(DependencyUpdater.Builder::resolutionBuilder)
																 .map(DependencyResolution.Builder::resolver)
																 .noneMatch(res -> res == resolver))
						.map(resolver -> new DependencyResolution.Builder(resolver, target))
						.collect(Collectors.toUnmodifiableList());
	}

	@SuppressWarnings("unchecked")
	private List<DependencyUpdater.Builder> gatherUpdatableDependencies(final List<DependencyResolver> resolvers,
																		final IExtenderDescriptor.ExtenderContext<?> extenderContext)
	{
		final var updatableDependencies = extenderContext.annotationHandles()
														 .stream()
														 .filter(handle -> handle.annotationClass() == UpdateDependency.class)
														 .map(handle -> (AnnotationHandles<UpdateDependency>) handle)
														 .flatMap(handle -> handle.handles().stream())
														 .map(handle -> newDependencyUpdater(resolvers, handle))
														 .collect(Collectors.toUnmodifiableList());
		return updatableDependencies;
	}

	private DependencyUpdater.Builder newDependencyUpdater(final List<DependencyResolver> resolvers,
														   final IExtenderHandle.AnnotatedHandle<UpdateDependency> handle)
	{
		final var resolver = resolvers.get(handle.annotation().index());
		final var resolutionBuilder = new DependencyResolution.Builder(resolver, target);
		return new DependencyUpdater.Builder(resolutionBuilder, handle);
	}

	@Override
	public void update(IAllocationContext context)
	{
		assert isDirty() && isUpdatable();

		if (preChildrenManager.isDirty())
		{
			preChildrenManager.update(target, context);
		}

		dependencyManager.update(target);

		if (postChildrenManager.isDirty())
		{
			updatePostChildren(context);
		}

		state.setStatus(EAllocationStatus.Allocated);
		state.setBranchStatus(EAllocationStatus.Allocated);
	}

	private void updatePostChildren(final IAllocationContext context)
	{
		final var providedContext = provideContext ? getProvidedContext() : null;
		if (providedContext != null)
		{
			providedContext.beforeChildrenAllocation();
			postChildrenManager.update(target, providedContext);
			providedContext.afterChildrenAllocation();
		}
		else
		{
			postChildrenManager.update(target, context);
		}
		injectChildren();
	}

	private void injectChildren()
	{
		for (final var childInjector : childrenInjectors)
		{
			childInjector.inject(target);
		}
	}

	public void cleanup(final IAllocationContext context, boolean freeEverything)
	{
		if (freeEverything || postChildrenManager.isDirty())
		{
			final var childContext = provideContext ? getProvidedContext() : context;
			postChildrenManager.cleanup(childContext, freeEverything);
		}

		if (freeEverything || state.getStatus() == EAllocationStatus.Obsolete)
		{
			free(context);
		}

		if (freeEverything || postChildrenManager.isDirty())
		{
			preChildrenManager.cleanup(context, freeEverything);
		}
		if (freeEverything) state.setStatus(EAllocationStatus.Free);
	}

	@Override
	public void free(IAllocationContext context)
	{
		if (observatory != null) observatory.shut(target);
		dependencyManager.free();

		annotatedHandles(Free.class).forEach(freeHandle -> ((ConsumerHandle) freeHandle.executionHandle()).invoke(
				context));

		state.setStatus(EAllocationStatus.Free);
	}

	public boolean isDirty()
	{
		return state.isDirty();
	}

	public boolean isUpdatable()
	{
		return isUnlocked() && state.getStatus() == EAllocationStatus.Dirty;
	}

	public boolean isLocked()
	{
		return state.isLocked();
	}

	public boolean isUnlocked()
	{
		return !isLocked();
	}

	public EAllocationStatus getStatus()
	{
		return state.getStatus();
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
		return extenderContext.annotationHandles()
							  .stream()
							  .filter(h -> h.annotationClass().equals(annotationClass))
							  .flatMap(h -> ((AnnotationHandles<A>) h).handles().stream());
	}

	@Override
	public Allocation getAllocation()
	{
		return extenderContext.extender();
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
		private final AllocationChildrenManager.Builder childrenManagerBuilder;

		public Builder(final AllocationDescriptor<Allocation> descriptor,
					   final ILilyEObject target,
					   final List<DependencyResolver> resolvers)
		{
			this.descriptor = descriptor;
			this.target = target;
			this.resolvers = resolvers;
			childrenManagerBuilder = new AllocationChildrenManager.Builder(descriptor.getChildrenAnnotations(), target);
			childrenInjectorBuilder = new ChildrenInjector.Builder(childrenManagerBuilder);
		}

		public AllocationInstance<Allocation> build(final IAllocationContext context,
													Runnable whenUpdateNeeded) throws ReflectiveOperationException
		{
			return new AllocationInstance<>(target,
											descriptor,
											childrenInjectorBuilder,
											resolvers,
											context,
											whenUpdateNeeded,
											childrenManagerBuilder);
		}
	}
}
