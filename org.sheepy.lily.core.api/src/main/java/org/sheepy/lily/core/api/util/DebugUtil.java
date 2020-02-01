package org.sheepy.lily.core.api.util;

public final class DebugUtil
{
	public static boolean DEBUG_ENABLED;
	@SuppressWarnings("CanBeFinal")
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

	public static void parseMainArgs(String[] args)
	{
		for (var arg : args)
		{
			if ("debug".equals(arg))
			{
				DebugUtil.DEBUG_ENABLED = true;
			}
			if ("debugVerbose".equals(arg))
			{
				DebugUtil.DEBUG_ENABLED = true;
				DebugUtil.DEBUG_VERBOSE_ENABLED = true;
			}
		}
	}
}
