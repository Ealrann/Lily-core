/**
 *
 */
module org.sheepy.common
{
	requires transitive org.eclipse.emf.common;
	requires transitive org.eclipse.emf.ecore;
	
	exports org.sheepy.common.api.adapter;
	exports org.sheepy.common.api.types;
	
	exports org.sheepy.common.model.types;
	exports org.sheepy.common.model.types.impl;
	exports org.sheepy.common.model.types.util;
}
