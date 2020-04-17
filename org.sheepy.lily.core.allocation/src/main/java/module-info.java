import org.sheepy.lily.core.allocation.AllocationHandleFactory;
import org.sheepy.lily.core.allocation.AllocationManager;
import org.sheepy.lily.core.api.allocation.IAllocationManager;
import org.sheepy.lily.core.api.extender.IExtenderHandleFactory;

module org.sheepy.lily.core.allocation {
	requires transitive org.sheepy.lily.core.api;

	opens org.sheepy.lily.core.allocation;

	provides IExtenderHandleFactory with AllocationHandleFactory;
	provides IAllocationManager with AllocationManager;
}
