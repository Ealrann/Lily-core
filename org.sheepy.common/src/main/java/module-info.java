import org.sheepy.common.api.adapter.IServiceAdapter;

/**
 *
 */
module org.sheepy.common
{
	requires transitive org.eclipse.emf.common;
	requires transitive org.eclipse.emf.ecore;

	requires com.google.common;

	exports org.sheepy.common.api.adapter;
	exports org.sheepy.common.api.adapter.impl;
	exports org.sheepy.common.api.types;
	exports org.sheepy.common.api.util;
	
	exports org.sheepy.common.model.types;
	exports org.sheepy.common.model.types.impl;
	
	uses IServiceAdapter;
}
