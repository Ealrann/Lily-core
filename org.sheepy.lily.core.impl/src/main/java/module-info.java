import org.sheepy.lily.core.Extenders;
import org.sheepy.lily.core.adapter.handle.AdapterHandleFactory;
import org.sheepy.lily.core.api.cadence.IStatistics;
import org.sheepy.lily.core.api.extender.IExtenderDescriptorRegistry;
import org.sheepy.lily.core.api.extender.IExtenderHandleFactory;
import org.sheepy.lily.core.api.extender.IExtenderManagerFactory;
import org.sheepy.lily.core.api.extender.IExtenderProvider;
import org.sheepy.lily.core.api.resource.IResourceLoader;
import org.sheepy.lily.core.cadence.CadencerStatistics;
import org.sheepy.lily.core.extender.ExtenderDescriptorRegistry;
import org.sheepy.lily.core.extender.ExtenderManagerFactory;
import org.sheepy.lily.core.resource.ResourceLoader;

module org.sheepy.lily.core.impl {

	requires transitive org.sheepy.lily.core.api;

	provides IResourceLoader with ResourceLoader;
	provides IExtenderManagerFactory with ExtenderManagerFactory;
	provides IStatistics with CadencerStatistics;
	provides IExtenderDescriptorRegistry with ExtenderDescriptorRegistry;
	provides IExtenderProvider with Extenders;
	provides IExtenderHandleFactory with AdapterHandleFactory;

	opens org.sheepy.lily.core.application;
	opens org.sheepy.lily.core.variable;

	uses IExtenderProvider;
}
