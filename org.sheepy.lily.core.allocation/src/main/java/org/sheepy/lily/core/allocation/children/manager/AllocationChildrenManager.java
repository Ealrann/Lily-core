package org.sheepy.lily.core.allocation.children.manager;

import org.sheepy.lily.core.allocation.children.instance.ChildrenSupervisor;
import org.sheepy.lily.core.allocation.instance.FreeContext;
import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.core.api.model.ILilyEObject;

import java.util.List;
import java.util.stream.Collectors;

public final class AllocationChildrenManager implements IAllocationChildrenManager
{
	private final List<ChildrenSupervisor> childrenSupervisors;
	private final Configuration encapsulatedConfig;
	private final Runnable whenBranchDirty;

	private boolean dirty = true;

	AllocationChildrenManager(final List<ChildrenSupervisor.Builder> childEntryManagerBuilders,
							  final Configuration config)
	{
		whenBranchDirty = config.whenBranchDirty();
		encapsulatedConfig = new Configuration(this::setDirty,
											   config.whenDirty(),
											   config.whenObsolete(),
											   config.observatoryBuilder());

		childrenSupervisors = childEntryManagerBuilders.stream()
													   .map(this::buildChildEntryManager)
													   .collect(Collectors.toUnmodifiableList());
	}

	private ChildrenSupervisor buildChildEntryManager(ChildrenSupervisor.Builder builder)
	{
		return builder.build(encapsulatedConfig);
	}

	@Override
	public void markChildrenObsolete()
	{
		for (final var child : childrenSupervisors)
		{
			child.markChildrenObsolete();
		}
	}

	@Override
	public void update(ILilyEObject source, final IAllocationContext context)
	{
		for (final var childManager : childrenSupervisors)
		{
			childManager.update(source, context);
		}
		dirty = false;
	}

	@Override
	public void cleanup(final FreeContext context)
	{
		final int size = childrenSupervisors.size();
		for (int i = size - 1; i >= 0; i--)
		{
			final var childManager = childrenSupervisors.get(i);
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
