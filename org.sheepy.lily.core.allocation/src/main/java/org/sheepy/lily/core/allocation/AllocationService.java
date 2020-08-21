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
	@Override
	public <T extends IExtender> AllocationInstance<T> allocate(final ILilyEObject target,
																final IAllocationContext context,
																final Class<T> type)
	{
		return new Allocator<>(target, context, type).allocate();
	}

	@Override
	public void updateAllocation(final ILilyEObject target,
								 final IAllocationContext context,
								 final Class<? extends IExtender> type)
	{
		new Updater(target, context, type).update();
	}

	private static record Allocator<T extends IExtender>(ILilyEObject target, IAllocationContext context, Class<T>type)
	{
		public AllocationInstance<T> allocate()
		{
			return IExtenderDescriptorRegistry.INSTANCE.streamDescriptors(target, type)
													   .map(this::adaptHandle)
													   .map(this::allocateHandle)
													   .findAny()
													   .orElse(null);
		}

		private AllocationInstance<T> allocateHandle(final AllocationHandle<T> handle)
		{
			return handle.allocateNew(context, () -> {});
		}

		private AllocationHandle<T> adaptHandle(final IExtenderDescriptor<T> descriptor)
		{
			return (AllocationHandle<T>) target.extenders().adaptHandleFromDescriptor(descriptor);
		}
	}

	private static record Updater(ILilyEObject target, IAllocationContext context, Class<? extends IExtender>type)
	{
		public void update()
		{
			IExtenderDescriptorRegistry.INSTANCE.streamDescriptors(target, type)
												.map(this::adaptHandle)
												.map(AllocationHandle::getMainAllocation)
												.filter(Updater::isUpdatable)
												.forEach(this::updateHandle);
		}

		private void updateHandle(final AllocationInstance<?> allocation)
		{
			allocation.cleanup(new FreeContext(context, false));
			allocation.update(context);
		}

		private AllocationHandle<?> adaptHandle(final IExtenderDescriptor<?> descriptor)
		{
			return (AllocationHandle<?>) target.extenders().adaptHandleFromDescriptor(descriptor);
		}

		private static boolean isUpdatable(final AllocationInstance<?> allocation)
		{
			return allocation.isDirty() && allocation.isUpdatable();
		}
	}
}
