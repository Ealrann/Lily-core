package org.sheepy.lily.core.api.util;

public class DebugUtil
{
	public static boolean DEBUG_ENABLED;
	public static boolean DEBUG_VERBOSE_ENABLED;
	static
	{
		final String debugVerboseProperty = System.getProperty("debugVerbose");
		final String debugProperty = System.getProperty("debug");
		DEBUG_VERBOSE_ENABLED = debugVerboseProperty != null
				&& debugVerboseProperty.equals("false") == false;
		DEBUG_ENABLED = (debugProperty != null && debugProperty.equals("false") == false)
				|| DEBUG_VERBOSE_ENABLED;
	}
}
