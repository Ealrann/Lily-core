package org.sheepy.lily.core.allocation;

import org.sheepy.lily.core.allocation.instance.AllocationInstance;
import org.sheepy.lily.core.allocation.instance.FreeContext;
import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.core.api.allocation.IAllocationInstance;
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

	@SuppressWarnings("unchecked")
	@Override
	public <T extends IExtender> void setMainAllocation(final IAllocationInstance<T> allocation)
	{
		final var allocationInstance = (AllocationInstance<T>) allocation;
		final var target = allocationInstance.getTarget();
		final var type = allocationInstance.getAllocation().getClass();

		IExtenderDescriptorRegistry.INSTANCE.streamDescriptors(target, type)
											.findAny()
											.map(d -> (IExtenderDescriptor<T>) d)
											.map(d -> adaptHandle(d, target))
											.ifPresent(handle -> handle.setMainAllocation(allocationInstance));
	}

	private static <T extends IExtender> AllocationHandle<T> adaptHandle(final IExtenderDescriptor<T> descriptor,
																		 final ILilyEObject target)
	{
		return (AllocationHandle<T>) target.extenders().adaptHandleFromDescriptor(descriptor);
	}

	private static record Allocator<T extends IExtender>(ILilyEObject target, IAllocationContext context, Class<T> type)
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

	private static record Updater(ILilyEObject target, IAllocationContext context, Class<? extends IExtender> type)
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
