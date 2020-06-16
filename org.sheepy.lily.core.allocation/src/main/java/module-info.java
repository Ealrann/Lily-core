import org.sheepy.lily.core.allocation.AllocationHandleFactory;
import org.sheepy.lily.core.allocation.AllocationService;
import org.sheepy.lily.core.api.allocation.IAllocationService;
import org.sheepy.lily.core.api.extender.IExtenderHandleFactory;

module org.sheepy.lily.core.allocation {
	requires transitive org.sheepy.lily.core.api;

	opens org.sheepy.lily.core.allocation;

	provides IExtenderHandleFactory with AllocationHandleFactory;
	provides IAllocationService with AllocationService;
}
