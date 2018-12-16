import org.sheepy.common.adapter.ServiceAdapterFactory;
import org.sheepy.common.api.adapter.IAdapter;
import org.sheepy.common.api.adapter.IServiceAdapterFactory;
import org.sheepy.common.api.cadence.IStatistics;
import org.sheepy.common.application.ApplicationAdapter;
import org.sheepy.common.cadence.CadencerStatistics;
import org.sheepy.common.variable.DirectVariableResolverAdapter;

module org.sheepy.common.impl
{
	requires transitive org.sheepy.common.api;

	exports org.sheepy.common.inference;
	exports org.sheepy.common.cadence.common;
	exports org.sheepy.common.cadence.execution;

	opens org.sheepy.common.application;
	opens org.sheepy.common.variable;

	provides IServiceAdapterFactory with ServiceAdapterFactory;
	provides IStatistics with CadencerStatistics;
	provides IAdapter with DirectVariableResolverAdapter, ApplicationAdapter;
}
