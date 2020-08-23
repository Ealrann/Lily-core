package org.sheepy.lily.core.allocation.instance;

import org.sheepy.lily.core.api.allocation.EAllocationStatus;
import org.sheepy.lily.core.allocation.children.manager.AllocationChildrenManager;
import org.sheepy.lily.core.allocation.children.manager.IAllocationChildrenManager;
import org.sheepy.lily.core.allocation.dependency.DependencyManager;
import org.sheepy.lily.core.allocation.dependency.DependencyResolver;
import org.sheepy.lily.core.allocation.description.AllocationDescriptor;
import org.sheepy.lily.core.allocation.parameter.AllocationParametersBuilder;
import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.core.api.allocation.annotation.ProvideContext;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderDescriptor;
import org.sheepy.lily.core.api.extender.IExtenderHandle;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.core.api.notification.util.ConsumerListenerList;
import org.sheepy.lily.core.api.reflect.SupplierHandle;
import org.sheepy.lily.core.api.util.DebugUtil;

import java.util.List;
import java.util.function.Supplier;

public class AllocationInstanceBuilder<Allocation extends IExtender>
{
	private final AllocationDescriptor<Allocation> descriptor;
	private final ILilyEObject target;
	private final AllocationChildrenManager.Builder childrenManagerBuilder;
	private final AllocationParametersBuilder allocationParametersBuilder;
	private final DependencyManager.Builder dependencyManagerBuilder;

	public AllocationInstanceBuilder(final AllocationDescriptor<Allocation> descriptor,
									 final ILilyEObject target,
									 final List<DependencyResolver> resolvers)
	{
		this.descriptor = descriptor;
		this.target = target;
		childrenManagerBuilder = new AllocationChildrenManager.Builder(descriptor.childAnnotations(), target);
		allocationParametersBuilder = new AllocationParametersBuilder(resolvers);
		dependencyManagerBuilder = new DependencyManager.Builder(resolvers, target);
	}

	public AllocationInstance<Allocation> build(final IAllocationContext context,
												final Runnable whenUpdateNeeded) throws ReflectiveOperationException
	{
		final var observatoryBuilder = IObservatoryBuilder.newObservatoryBuilder();
		final var listeners = new ConsumerListenerList<EAllocationStatus>();
		final var provideContext = descriptor.provideContext();
		final var extenderDescriptor = descriptor.extenderDescriptor();
		final var state = new AllocationState((oldStatus, newStatus) -> listeners.notify(newStatus), whenUpdateNeeded);
		final var parameterResolvers = allocationParametersBuilder.build(state, context);
		final var buildConfig = new IAllocationChildrenManager.Configuration(state::markBranchDirty,
																			 state::markDirty,
																			 state::markObsolete,
																			 observatoryBuilder);

		final var preChildrenManager = childrenManagerBuilder.buildPreAllocation(buildConfig);
		preChildrenManager.update(target, context);
		final var extenderContext = extenderDescriptor.newExtender(target, observatoryBuilder, parameterResolvers);
		final var contextProvider = provideContext ? contextProvider(extenderContext) : null;
		final var postChildrenManager = childrenManagerBuilder.buildPostAllocation(buildConfig,
																				   contextProvider,
																				   extenderContext);
		final var dependencyManager = buildDependencyManager(state, extenderContext);
		final var observatory = observatoryBuilder.isEmpty() == false ? observatoryBuilder.build() : null;

		installObsoleteListener(listeners, preChildrenManager, postChildrenManager);

		return new AllocationInstance<>(target,
										observatory,
										state,
										listeners,
										dependencyManager,
										preChildrenManager,
										postChildrenManager,
										extenderContext);
	}

	private DependencyManager buildDependencyManager(final AllocationState state,
													 final IExtenderDescriptor.ExtenderContext<Allocation> extenderContext)
	{
		final var alloctionName = extenderContext.extender().getClass().getSimpleName();
		final Runnable markObsolete = DebugUtil.DEBUG_ALLOCATION ? () -> markObsoleteAndLog(alloctionName,
																							state) : state::markObsolete;
		return dependencyManagerBuilder.build(extenderContext, state::markDirty, markObsolete);
	}

	public static Supplier<IAllocationContext> contextProvider(IExtenderDescriptor.ExtenderContext<?> extenderContext)
	{
		final var supplier = extenderContext.annotatedHandles(ProvideContext.class)
											.map(IExtenderHandle.AnnotatedHandle::executionHandle)
											.map(SupplierHandle.class::cast)
											.findAny()
											.orElseThrow();
		return () -> (IAllocationContext) supplier.invoke();
	}

	private static void installObsoleteListener(final ConsumerListenerList<EAllocationStatus> listeners,
												final IAllocationChildrenManager preChildrenManager,
												final IAllocationChildrenManager postChildrenManager)
	{
		listeners.listen(status -> {
			if (status == EAllocationStatus.Obsolete)
			{
				preChildrenManager.markChildrenObsolete();
				postChildrenManager.markChildrenObsolete();
			}
		});
	}

	private static void markObsoleteAndLog(String name, final AllocationState state)
	{
		System.out.println(name + " obsolete due to dependency");
		state.markObsolete();
	}
}
