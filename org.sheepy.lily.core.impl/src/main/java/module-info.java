import org.sheepy.lily.core.adapter.impl.AdapterManagerFactory;
import org.sheepy.lily.core.adapter.impl.AdapterRegistry;
import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.core.api.adapter.IAdapterRegistry;
import org.sheepy.lily.core.api.adapter.annotation.Adapters;
import org.sheepy.lily.core.api.cadence.IStatistics;
import org.sheepy.lily.core.api.resource.IResourceLoader;
import org.sheepy.lily.core.application.ApplicationAdapter;
import org.sheepy.lily.core.cadence.CadencerStatistics;
import org.sheepy.lily.core.cadence.adapter.CadenceAdapter;
import org.sheepy.lily.core.cadence.adapter.CloseApplicationAdapter;
import org.sheepy.lily.core.cadence.adapter.CountUntilAdapter;
import org.sheepy.lily.core.cadence.adapter.ExecuteIfAdapter;
import org.sheepy.lily.core.cadence.adapter.ExecuteWhileAdapter;
import org.sheepy.lily.core.cadence.adapter.HaveTimeAdapter;
import org.sheepy.lily.core.cadence.adapter.PrintUPSAdapter;
import org.sheepy.lily.core.resource.ResourceLoader;
import org.sheepy.lily.core.variable.ChainVariableResolverAdapter;
import org.sheepy.lily.core.variable.DirectVariableResolverAdapter;

@Adapters(classifiers = {
		DirectVariableResolverAdapter.class,
		ChainVariableResolverAdapter.class,
		ApplicationAdapter.class,
		ExecuteIfAdapter.class,
		ExecuteWhileAdapter.class,
		CadenceAdapter.class,
		PrintUPSAdapter.class,
		HaveTimeAdapter.class,
		CountUntilAdapter.class,
		CloseApplicationAdapter.class,
})

module org.sheepy.lily.core.impl
{
	requires transitive org.sheepy.lily.core.api;

	provides IResourceLoader with ResourceLoader;
	provides IAdapterFactoryService with AdapterManagerFactory;
	provides IStatistics with CadencerStatistics;
	provides IAdapterRegistry with AdapterRegistry;

	opens org.sheepy.lily.core.application;
	opens org.sheepy.lily.core.variable;
}
