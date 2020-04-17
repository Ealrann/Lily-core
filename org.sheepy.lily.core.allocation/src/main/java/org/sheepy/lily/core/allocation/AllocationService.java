package org.sheepy.lily.core.allocation;

import org.sheepy.lily.core.allocation.instance.AllocationInstance;
import org.sheepy.lily.core.allocation.instance.FreeContext;
import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.core.api.allocation.IAllocationService;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderDescriptor;
import org.sheepy.lily.core.api.extender.IExtenderDescriptorRegistry;
import org.sheepy.lily.core.api.model.ILilyEObject;

public final class AllocationService implements IAllocationService
{
	@SuppressWarnings("unchecked")
	@Override
	public <T extends IExtender> AllocationInstance<T> allocate(ILilyEObject target,
																IAllocationContext context,
																Class<T> type)
	{
		final var descriptor = IExtenderDescriptorRegistry.INSTANCE.streamDescriptors()
																   .filter(de -> de.isExtenderForType(type))
																   .filter(de -> de.isApplicable(target))
																   .map(de -> (IExtenderDescriptor<T>) de)
																   .findAny();

		if (descriptor.isPresent())
		{
			final var handle = (AllocationHandle<T>) target.adapters().adaptHandleFromDescriptor(descriptor.get());
			return handle.allocateNew(context, () -> {
			});
		}
		else
		{
			return null;
		}
	}

	@Override
	public void updateAllocation(final ILilyEObject target,
								 final IAllocationContext context,
								 final Class<? extends IExtender> type)
	{
		final var descriptor = IExtenderDescriptorRegistry.INSTANCE.streamDescriptors()
																   .filter(de -> de.isExtenderForType(type))
																   .filter(de -> de.isApplicable(target))
																   .findAny();
		if (descriptor.isPresent())
		{
			final var handle = (AllocationHandle<?>) target.adapters().adaptHandleFromDescriptor(descriptor.get());
			final var allocation = handle.getMainAllocation();

			if (allocation.isDirty() && allocation.isUpdatable())
			{
				allocation.cleanup(new FreeContext(context, false));
				allocation.update(context);
			}
		}
	}
}
