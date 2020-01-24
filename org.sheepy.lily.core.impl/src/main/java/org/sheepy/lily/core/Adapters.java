package org.sheepy.lily.core;

import java.util.List;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.IAdapterProvider;
import org.sheepy.lily.core.application.ApplicationAdapter;
import org.sheepy.lily.core.cadence.adapter.CadenceAdapter;
import org.sheepy.lily.core.cadence.adapter.CloseApplicationAdapter;
import org.sheepy.lily.core.cadence.adapter.CountUntilAdapter;
import org.sheepy.lily.core.cadence.adapter.ExecuteIfAdapter;
import org.sheepy.lily.core.cadence.adapter.ExecuteWhileAdapter;
import org.sheepy.lily.core.cadence.adapter.HaveTimeAdapter;
import org.sheepy.lily.core.cadence.adapter.PrintUPSAdapter;
import org.sheepy.lily.core.variable.ChainVariableResolverAdapter;
import org.sheepy.lily.core.variable.DirectVariableResolverAdapter;

public class Adapters implements IAdapterProvider
{
	@Override
	public List<Class<? extends IAdapter>> classifiers()
	{
		return List.of(	DirectVariableResolverAdapter.class,
						ChainVariableResolverAdapter.class,
						ApplicationAdapter.class,
						ExecuteIfAdapter.class,
						ExecuteWhileAdapter.class,
						CadenceAdapter.class,
						PrintUPSAdapter.class,
						HaveTimeAdapter.class,
						CountUntilAdapter.class,
						CloseApplicationAdapter.class);
	}
}
