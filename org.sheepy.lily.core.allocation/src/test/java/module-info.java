import org.sheepy.lily.core.allocation.test.Extenders;
import org.sheepy.lily.core.allocation.test.modelextension.ModelExtension;
import org.sheepy.lily.core.api.extender.IExtenderProvider;
import org.sheepy.lily.core.api.resource.IModelExtension;

open module org.sheepy.lily.core.allocation.test {
	requires org.sheepy.lily.core.allocation;
	requires org.sheepy.lily.core.base;
	requires org.junit.jupiter.api;

	provides IExtenderProvider with Extenders;
	provides IModelExtension with ModelExtension;
}
