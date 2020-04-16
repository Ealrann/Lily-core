import org.sheepy.lily.core.Adapters;
import org.sheepy.lily.core.adapter.AdapterManagerFactory;
import org.sheepy.lily.core.adapter.AdapterRegistry;
import org.sheepy.lily.core.adapter.observation.AdapterObserveService;
import org.sheepy.lily.core.api.adapter.IAdapterAnnotationService;
import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.core.api.adapter.IAdapterProvider;
import org.sheepy.lily.core.api.adapter.IAdapterRegistry;
import org.sheepy.lily.core.api.cadence.IStatistics;
import org.sheepy.lily.core.api.resource.IResourceLoader;
import org.sheepy.lily.core.cadence.CadencerStatistics;
import org.sheepy.lily.core.cadence.tick.CadencerAnnotationService;
import org.sheepy.lily.core.resource.ResourceLoader;

module org.sheepy.lily.core.impl {
	requires transitive org.sheepy.lily.core.api;

	provides IResourceLoader with ResourceLoader;
	provides IAdapterFactoryService with AdapterManagerFactory;
	provides IStatistics with CadencerStatistics;
	provides IAdapterRegistry with AdapterRegistry;

	opens org.sheepy.lily.core.application;
	opens org.sheepy.lily.core.variable;

	provides IAdapterProvider with Adapters;
	provides IAdapterAnnotationService with CadencerAnnotationService, AdapterObserveService;

	uses IAdapterProvider;
	uses IAdapterAnnotationService;
}
