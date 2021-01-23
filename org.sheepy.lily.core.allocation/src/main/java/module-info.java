import org.logoce.extender.ext.IAdapterHandleFactory;
import org.sheepy.lily.core.allocation.AllocationHandleFactory;
import org.sheepy.lily.core.allocation.AllocationService;
import org.sheepy.lily.core.api.allocation.IAllocationService;

module org.sheepy.lily.core.allocation {
	requires transitive org.sheepy.lily.core.api;

	opens org.sheepy.lily.core.allocation;

	provides IAdapterHandleFactory with AllocationHandleFactory;
	provides IAllocationService with AllocationService;
}
