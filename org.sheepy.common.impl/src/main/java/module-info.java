import org.sheepy.common.api.cadence.ICadencer;
import org.sheepy.common.cadence.common.BasicCadencer;

module org.sheepy.common.impl
{
	requires transitive org.sheepy.common.api;
	
	exports org.sheepy.common.action;
	exports org.sheepy.common.inference;
	
	provides ICadencer with BasicCadencer;
}
