import org.logoce.extender.api.IAdapterProvider;
import org.sheepy.lily.core.allocation.test.Extenders;
import org.sheepy.lily.core.allocation.test.modelextension.ModelExtension;
import org.sheepy.lily.core.api.resource.IModelExtension;

open module org.sheepy.lily.core.allocation.test {
	requires org.sheepy.lily.core.allocation;
	requires org.sheepy.lily.core.base;
	requires org.junit.jupiter.api;

	provides IAdapterProvider with Extenders;
	provides IModelExtension with ModelExtension;
}
