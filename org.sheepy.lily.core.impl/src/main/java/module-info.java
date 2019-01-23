import org.sheepy.lily.core.adapter.ServiceAdapterFactory;
import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;
import org.sheepy.lily.core.api.cadence.IStatistics;
import org.sheepy.lily.core.api.resource.IResourceLoader;
import org.sheepy.lily.core.application.ApplicationAdapter;
import org.sheepy.lily.core.cadence.CadencerStatistics;
import org.sheepy.lily.core.resource.ResourceLoader;
import org.sheepy.lily.core.variable.ChainVariableResolverAdapter;
import org.sheepy.lily.core.variable.DirectVariableResolverAdapter;

module org.sheepy.lily.core.impl
{
	requires transitive org.sheepy.lily.core.api;

	exports org.sheepy.lily.core.inference;
	exports org.sheepy.lily.core.cadence.common;
	exports org.sheepy.lily.core.cadence.execution;

	opens org.sheepy.lily.core.application;
	opens org.sheepy.lily.core.variable;

	provides IResourceLoader with ResourceLoader;
	provides IServiceAdapterFactory with ServiceAdapterFactory;
	provides IStatistics with CadencerStatistics;
	provides IAdapter
			with DirectVariableResolverAdapter, ChainVariableResolverAdapter, ApplicationAdapter;
}
