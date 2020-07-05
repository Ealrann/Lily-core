package org.sheepy.lily.core.allocation.children;

import org.sheepy.lily.core.allocation.instance.FreeContext;
import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.core.api.model.ILilyEObject;

import java.util.List;
import java.util.stream.Collectors;

public final class AllocationChildrenManager implements IAllocationChildrenManager
{
	private final List<ChildEntryManager> childEntryManagers;
	private final Configuration encapsulatedConfig;
	private final Runnable whenBranchDirty;

	private boolean dirty = true;

	AllocationChildrenManager(final List<ChildEntryManager.Builder> childEntryManagerBuilders,
							  final Configuration config)
	{
		whenBranchDirty = config.whenBranchDirty();
		encapsulatedConfig = new Configuration(this::setDirty,
											   config.whenDirty(),
											   config.whenObsolete(),
											   config.observatoryBuilder());

		childEntryManagers = childEntryManagerBuilders.stream()
													  .map(this::buildChildEntryManager)
													  .collect(Collectors.toUnmodifiableList());
	}

	private ChildEntryManager buildChildEntryManager(ChildEntryManager.Builder builder)
	{
		return builder.build(encapsulatedConfig);
	}

	@Override
	public void update(ILilyEObject source, final IAllocationContext context)
	{
		for (final var childManager : childEntryManagers)
		{
			childManager.update(source, context);
		}
		dirty = false;
	}

	@Override
	public void cleanup(final FreeContext context)
	{
		final int size = childEntryManagers.size();
		for (int i = size - 1; i >= 0; i--)
		{
			final var childManager = childEntryManagers.get(i);
			childManager.cleanup(context);
		}
	}

	private void setDirty()
	{
		if (dirty == false)
		{
			whenBranchDirty.run();
			dirty = true;
		}
	}

	@Override
	public boolean isDirty()
	{
		return dirty;
	}
}
