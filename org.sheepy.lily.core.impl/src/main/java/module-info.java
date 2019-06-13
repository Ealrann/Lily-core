import org.sheepy.lily.core.adapter.impl.BasicAdapterFactory;
import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.core.api.adapter.annotation.Adapters;
import org.sheepy.lily.core.api.cadence.IStatistics;
import org.sheepy.lily.core.api.resource.IResourceLoader;
import org.sheepy.lily.core.application.ApplicationAdapter;
import org.sheepy.lily.core.cadence.CadencerStatistics;
import org.sheepy.lily.core.resource.ResourceLoader;
import org.sheepy.lily.core.util.ModelAdapter;
import org.sheepy.lily.core.variable.ChainVariableResolverAdapter;
import org.sheepy.lily.core.variable.DirectVariableResolverAdapter;

@Adapters(classifiers = {
		DirectVariableResolverAdapter.class,
		ChainVariableResolverAdapter.class,
		ApplicationAdapter.class,
		ModelAdapter.class
})

module org.sheepy.lily.core.impl
{
	requires transitive org.sheepy.lily.core.api;

	provides IResourceLoader with ResourceLoader;
	provides IAdapterFactoryService with BasicAdapterFactory;
	provides IStatistics with CadencerStatistics;

	opens org.sheepy.lily.core.application;
	opens org.sheepy.lily.core.variable;
}
