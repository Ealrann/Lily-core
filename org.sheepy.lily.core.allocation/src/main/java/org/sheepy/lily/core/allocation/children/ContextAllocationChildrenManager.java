package org.sheepy.lily.core.allocation.children;

import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.core.api.model.ILilyEObject;

import java.util.List;
import java.util.function.Supplier;

public final class ContextAllocationChildrenManager implements IAllocationChildrenManager
{
	private final Supplier<IAllocationContext> contextProvider;
	private final List<ChildrenInjector> childrenInjectors;
	private final AllocationChildrenManager childrenManager;

	ContextAllocationChildrenManager(final List<ChildEntryManager.Builder> childEntryManagers,
									 final Configuration config,
									 final Supplier<IAllocationContext> contextProvider,
									 final List<ChildrenInjector> childrenInjectors)
	{
		this.contextProvider = contextProvider;
		this.childrenManager = new AllocationChildrenManager(childEntryManagers, config);
		this.childrenInjectors = List.copyOf(childrenInjectors);
	}

	@Override
	public void update(final ILilyEObject source, final IAllocationContext context)
	{
		if (contextProvider != null)
		{
			final var providedContext = contextProvider.get();
			providedContext.beforeChildrenAllocation();
			childrenManager.update(source, providedContext);
			providedContext.afterChildrenAllocation();
		}
		else
		{
			childrenManager.update(source, context);
		}

		for (final var childInjector : childrenInjectors)
		{
			childInjector.inject(source);
		}
	}

	@Override
	public void cleanup(final IAllocationContext context, boolean freeEverything)
	{
		if (contextProvider != null)
		{
			final var providedContext = contextProvider.get();
			childrenManager.cleanup(providedContext, freeEverything);
		}
		else
		{
			childrenManager.cleanup(context, freeEverything);
		}
	}

	@Override
	public boolean isDirty()
	{
		return childrenManager.isDirty();
	}
}
