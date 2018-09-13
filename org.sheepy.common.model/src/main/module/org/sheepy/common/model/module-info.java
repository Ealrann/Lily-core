/**
 *
 */
module org.sheepy.common.model
{
	requires transitive org.eclipse.emf.common;
	requires transitive org.eclipse.emf.ecore;

	exports org.sheepy.common.model.types;
	exports org.sheepy.common.model.types.impl;
	exports org.sheepy.common.model.types.util;
	
	exports org.sheepy.common.model.util.types;
}
