package org.sheepy.common.api.util;

public class DurationMeter
{
	private final int tickBeforeReport;
	private final String name;
	
	private int tick = 0;
	private long duration = 0;
	
	private long timeStart = 0;

	public DurationMeter(String name, int tickBeforeReport)
	{
		this.name = name;
		this.tickBeforeReport = tickBeforeReport;
	}
	
	public void startRecord()
	{
		timeStart = System.currentTimeMillis();
	}
	
	public void endRecord()
	{
		duration += System.currentTimeMillis() - timeStart;
		tick ++;
		
		if(tick >= tickBeforeReport)
		{
			printDuration();
			reset();
		}
	}
	
	public void reset()
	{
		duration = 0;
		tick = 0;
	}
	
	private void printDuration()
	{
		float averageDuration = duration / tick;
		System.out.println(String.format("%s: :%d ms", name, (int) averageDuration));
	}
}
