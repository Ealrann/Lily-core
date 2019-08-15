import org.sheepy.lily.core.allocation.AllocationService;
import org.sheepy.lily.core.api.allocation.IAllocationService;

module org.sheepy.lily.core.allocation
{
	requires transitive org.sheepy.lily.core.api;

	provides IAllocationService with AllocationService;
}
