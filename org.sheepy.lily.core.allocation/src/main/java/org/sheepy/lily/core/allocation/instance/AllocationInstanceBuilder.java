package org.sheepy.lily.core.allocation.instance;

import org.sheepy.lily.core.allocation.children.manager.AllocationChildrenBuilder;
import org.sheepy.lily.core.allocation.children.manager.AllocationChildrenManager;
import org.sheepy.lily.core.allocation.dependency.DependencyManager;
import org.sheepy.lily.core.allocation.description.AllocationDescriptor;
import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.core.api.allocation.annotation.ProvideContext;
import org.logoce.extender.api.IAdapter;
import org.logoce.extender.api.IAdapterDescriptor;
import org.logoce.extender.api.IAdapterHandle;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.notification.observatory.IObservatory;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.logoce.extender.api.reflect.SupplierHandle;
import org.sheepy.lily.core.api.util.DebugUtil;

import java.util.Optional;

public final class AllocationInstanceBuilder<Allocation extends IAdapter>
{
	private final ILilyEObject target;
	private final AllocationChildrenManager preChildrenManager;
	private final AllocationDescriptor<Allocation> descriptor;
	private final IObservatory preObservatory;
	private final AllocationState state;
	private AllocationChildrenManager postChildrenManager;

	public AllocationInstanceBuilder(final ILilyEObject target,
									 final AllocationChildrenManager preChildrenManager,
									 final AllocationDescriptor<Allocation> descriptor,
									 final IObservatory preObservatory,
									 final AllocationState state)
	{
		this.target = target;
		this.preChildrenManager = preChildrenManager;
		this.descriptor = descriptor;
		this.preObservatory = preObservatory;
		this.state = state;
	}

	public AllocationInstance<Allocation> build(IAllocationContext context) throws ReflectiveOperationException
	{
		final var provideContext = descriptor.provideContext();
		final var extenderDescriptor = descriptor.extenderDescriptor();
		final var observatoryBuilder = IObservatoryBuilder.newObservatoryBuilder();
		final var parameterResolvers = descriptor.allocationParametersBuilder().build(state, context, observatoryBuilder);
		final var extenderContext = extenderDescriptor.newExtender(target, parameterResolvers);
		final var providedContext = provideContext ? contextProvider(extenderContext) : Optional.<IAllocationContext>empty();
		final var buildContext = new AllocationChildrenBuilder.BuildContext(state::markBranchDirty,
																			target,
																			observatoryBuilder);
		postChildrenManager = descriptor.allocationChildrenBuilder()
										.buildPostAllocation(buildContext, providedContext, extenderContext);
		final var dependencyManager = buildDependencyManager(observatoryBuilder, extenderContext);
		final var observatory = observatoryBuilder.isEmpty() == false ? observatoryBuilder.build() : null;

		return new AllocationInstance<>(target,
										preObservatory,
										observatory,
										state,
										dependencyManager,
										preChildrenManager,
										postChildrenManager,
										extenderContext);
	}

	private DependencyManager buildDependencyManager(final IObservatoryBuilder observatoryBuilder,
													 final IAdapterDescriptor.ExtenderContext<Allocation> extenderContext)
	{
		final var alloctionName = extenderContext.extender().getClass().getSimpleName();
		final Runnable markObsolete = DebugUtil.DEBUG_ALLOCATION ? () -> markObsoleteAndLog(alloctionName,
																							state) : state::markObsolete;
		return descriptor.dependencyManagerBuilder()
						 .build(target, observatoryBuilder, extenderContext, state::markDirty, markObsolete);
	}

	private static void markObsoleteAndLog(String name, final AllocationState state)
	{
		System.out.println(name + " obsolete due to dependency");
		state.markObsolete();
	}

	public ILilyEObject getTarget()
	{
		return target;
	}

	public AllocationChildrenManager preChildrenManager()
	{
		return preChildrenManager;
	}

	public AllocationChildrenManager postChildrenManager()
	{
		return postChildrenManager;
	}

	public static Optional<IAllocationContext> contextProvider(IAdapterDescriptor.ExtenderContext<?> extenderContext)
	{
		final var supplier = extenderContext.annotationHandles()
											.stream(ProvideContext.class)
											.map(IAdapterHandle.AnnotatedHandle::executionHandle)
											.map(SupplierHandle.class::cast)
											.findAny()
											.orElseThrow();
		return Optional.of((IAllocationContext) supplier.invoke());
	}
}
