import org.sheepy.lily.core.adapter.ServiceAdapterFactory;
import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;
import org.sheepy.lily.core.api.adapter.annotation.Adapters;
import org.sheepy.lily.core.api.cadence.IStatistics;
import org.sheepy.lily.core.api.resource.IResourceLoader;
import org.sheepy.lily.core.application.ApplicationAdapter;
import org.sheepy.lily.core.cadence.CadencerStatistics;
import org.sheepy.lily.core.resource.ResourceLoader;
import org.sheepy.lily.core.variable.ChainVariableResolverAdapter;
import org.sheepy.lily.core.variable.DirectVariableResolverAdapter;

@Adapters(classifiers = {
		DirectVariableResolverAdapter.class,
		ChainVariableResolverAdapter.class,
		ApplicationAdapter.class
})

module org.sheepy.lily.core.impl
{
	requires transitive org.sheepy.lily.core.api;

	exports org.sheepy.lily.core.cadence.common;
	exports org.sheepy.lily.core.cadence.execution;

	opens org.sheepy.lily.core.application to org.sheepy.lily.core.api;
	opens org.sheepy.lily.core.inference to org.sheepy.lily.core.api;
	opens org.sheepy.lily.core.variable to org.sheepy.lily.core.api;

	provides IResourceLoader with ResourceLoader;
	provides IServiceAdapterFactory with ServiceAdapterFactory;
	provides IStatistics with CadencerStatistics;
}
