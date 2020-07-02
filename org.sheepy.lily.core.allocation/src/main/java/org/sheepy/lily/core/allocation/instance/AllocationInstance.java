package org.sheepy.lily.core.allocation.instance;

import org.sheepy.lily.core.allocation.EAllocationStatus;
import org.sheepy.lily.core.allocation.children.AllocationChildrenManager;
import org.sheepy.lily.core.allocation.children.IAllocationChildrenManager;
import org.sheepy.lily.core.allocation.dependency.DependencyManager;
import org.sheepy.lily.core.allocation.dependency.DependencyResolver;
import org.sheepy.lily.core.allocation.description.AllocationDescriptor;
import org.sheepy.lily.core.allocation.parameter.AllocationParametersBuilder;
import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.core.api.allocation.IAllocationInstance;
import org.sheepy.lily.core.api.allocation.annotation.Free;
import org.sheepy.lily.core.api.allocation.annotation.ProvideContext;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderDescriptor;
import org.sheepy.lily.core.api.extender.IExtenderHandle;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.notification.observatory.IObservatory;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.core.api.notification.util.ConsumerListenerList;
import org.sheepy.lily.core.api.reflect.ConsumerHandle;
import org.sheepy.lily.core.api.reflect.SupplierHandle;
import org.sheepy.lily.core.api.util.AnnotationHandles;
import org.sheepy.lily.core.api.util.DebugUtil;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public final class AllocationInstance<Allocation extends IExtender> implements IAllocationInstance<Allocation>
{
	private final ILilyEObject target;
	private final IObservatory observatory;
	private final AllocationState state;
	private final DependencyManager dependencyManager;
	private final ConsumerListenerList<EAllocationStatus> listeners = new ConsumerListenerList<>();
	private final IAllocationChildrenManager preChildrenManager;
	private final IAllocationChildrenManager postChildrenManager;
	private final IExtenderDescriptor.ExtenderContext<Allocation> extenderContext;

	public AllocationInstance(final ILilyEObject target,
							  final AllocationDescriptor<Allocation> descriptor,
							  final AllocationParametersBuilder parameterBuilder,
							  final DependencyManager.Builder dependencyManagerBuilder,
							  final IAllocationContext context,
							  final Runnable whenUpdateNeeded,
							  final AllocationChildrenManager.Builder childrenManagerBuilder) throws ReflectiveOperationException
	{
		final var observatoryBuilder = IObservatoryBuilder.newObservatoryBuilder();
		this.target = target;
		this.state = new AllocationState(this::onStatusChange, whenUpdateNeeded);

		final var provideContext = descriptor.isProvidingContext();
		final var parameterResolvers = parameterBuilder.build(state, context);
		final var extenderDescriptor = descriptor.getExtenderDescriptor();
		final Supplier<IAllocationContext> contextProvider = provideContext ? this::getProvidedContext : null;
		final var config = new IAllocationChildrenManager.Configuration(state::markBranchDirty,
																		state::markDirty,
																		state::markObsolete,
																		observatoryBuilder);

		preChildrenManager = childrenManagerBuilder.buildPreAllocation(config);
		preChildrenManager.update(target, context);
		extenderContext = extenderDescriptor.newExtender(target, observatoryBuilder, parameterResolvers);
		postChildrenManager = childrenManagerBuilder.buildPostAllocation(config, contextProvider, extenderContext);

		final Runnable markObsolete = DebugUtil.DEBUG_ALLOCATION ? this::markObsoleteAndLog : state::markObsolete;
		dependencyManager = dependencyManagerBuilder.build(extenderContext, state::markDirty, markObsolete);
		observatory = observatoryBuilder.isEmpty() == false ? observatoryBuilder.build() : null;
		if (observatory != null) observatory.observe(target);
	}

	private void markObsoleteAndLog()
	{
		System.out.println(extenderContext.extender().getClass().getSimpleName() + " obsolete due to dependency");
		state.markObsolete();
	}

	public void load(final IAllocationContext context)
	{
		postChildrenManager.update(target, context);
	}

	@Override
	public void update(IAllocationContext context)
	{
		assert isDirty();
		assert isUpdatable();

		if (preChildrenManager.isDirty())
		{
			preChildrenManager.update(target, context);
		}

		dependencyManager.update(target);

		if (postChildrenManager.isDirty())
		{
			postChildrenManager.update(target, context);
		}

		state.setStatus(EAllocationStatus.Allocated);
		state.setBranchStatus(EAllocationStatus.Allocated);
	}

	@Override
	public void free(IAllocationContext context)
	{
		cleanup(context, true);
	}

	@Override
	public void cleanup(final IAllocationContext context)
	{
		cleanup(context, false);
	}

	public void cleanup(final IAllocationContext context, boolean freeEverything)
	{
		final boolean free = freeEverything || state.getStatus() == EAllocationStatus.Obsolete;

		if (free || postChildrenManager.isDirty())
		{
			postChildrenManager.cleanup(context, free);
		}

		if (free)
		{
			freeInternal(context);
		}

		if (free || preChildrenManager.isDirty())
		{
			preChildrenManager.cleanup(context, free);
		}
		if (free)
		{
			state.setStatus(EAllocationStatus.Free);
		}
	}

	private void freeInternal(IAllocationContext context)
	{
		if (observatory != null) observatory.shut(target);
		dependencyManager.free();

		annotatedHandles(Free.class).forEach(freeHandle -> ((ConsumerHandle) freeHandle.executionHandle()).invoke(
				context));

		state.setStatus(EAllocationStatus.Free);
	}

	private void onStatusChange(EAllocationStatus oldStatus, EAllocationStatus newStatus)
	{
		listeners.notify(newStatus);
	}

	public boolean isDirty()
	{
		return state.isDirty();
	}

	public boolean isUpdatable()
	{
		final var status = state.getStatus();
		final boolean updatableStatus = status != EAllocationStatus.Obsolete && status != EAllocationStatus.Free;
		return isUnlocked() && updatableStatus;
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
		private final AllocationChildrenManager.Builder childrenManagerBuilder;
		private final AllocationParametersBuilder allocationParametersBuilder;
		private final DependencyManager.Builder dependencyManagerBuilder;

		public Builder(final AllocationDescriptor<Allocation> descriptor,
					   final ILilyEObject target,
					   final List<DependencyResolver> resolvers)
		{
			this.descriptor = descriptor;
			this.target = target;
			childrenManagerBuilder = new AllocationChildrenManager.Builder(descriptor.getChildrenAnnotations(), target);
			allocationParametersBuilder = new AllocationParametersBuilder(resolvers);
			dependencyManagerBuilder = new DependencyManager.Builder(resolvers, target);
		}

		public AllocationInstance<Allocation> build(final IAllocationContext context,
													Runnable whenUpdateNeeded) throws ReflectiveOperationException
		{
			return new AllocationInstance<>(target,
											descriptor,
											allocationParametersBuilder,
											dependencyManagerBuilder,
											context,
											whenUpdateNeeded,
											childrenManagerBuilder);
		}
	}
}
