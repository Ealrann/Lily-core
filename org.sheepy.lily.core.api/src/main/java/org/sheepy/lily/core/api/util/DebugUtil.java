package org.sheepy.lily.core.api.util;

public class DebugUtil
{
	public static boolean DEBUG_ENABLED;
	static
	{
		final String debugProperty = System.getProperty("debug");
		DEBUG_ENABLED = debugProperty != null && debugProperty.equals("false") == false;
	}
}
