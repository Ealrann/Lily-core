import org.sheepy.common.action.ActionDispatcher;
import org.sheepy.common.api.action.IActionDispatcher;
import org.sheepy.common.api.adapter.ISingletonAdapter;
import org.sheepy.common.api.cadence.ICadencer;
import org.sheepy.common.api.cadence.IStatistics;
import org.sheepy.common.cadence.CadencerStatistics;
import org.sheepy.common.cadence.common.BasicCadencer;
import org.sheepy.common.variable.DirectVariableResolverAdapter;

module org.sheepy.common.impl
{
	requires transitive org.sheepy.common.api;
	
	exports org.sheepy.common.action;
	exports org.sheepy.common.inference;
	opens org.sheepy.common.variable;
	
	provides IActionDispatcher with ActionDispatcher;
	provides ICadencer with BasicCadencer;
	provides IStatistics with CadencerStatistics;
	provides ISingletonAdapter with DirectVariableResolverAdapter;
}
