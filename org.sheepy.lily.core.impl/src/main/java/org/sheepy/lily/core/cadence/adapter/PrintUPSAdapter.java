package org.sheepy.lily.core.cadence.adapter;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.cadence.ICadenceContext;
import org.sheepy.lily.core.api.cadence.ICadenceTaskAdapter;
import org.sheepy.lily.core.api.util.UPSMeter;
import org.sheepy.lily.core.model.cadence.ICadenceTask;
import org.sheepy.lily.core.model.cadence.PrintUPS;

@Statefull
@Adapter(scope = PrintUPS.class)
public final class PrintUPSAdapter implements ICadenceTaskAdapter
{
	private final UPSMeter meter;
	
	public PrintUPSAdapter(PrintUPS printUPS)
	{
		this.meter = new UPSMeter(printUPS.getPrintEveryMs());
	}
	
	@Override
	public void execute(ICadenceTask task, ICadenceContext context)
	{
		meter.tick();
	}
}
