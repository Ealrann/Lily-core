package org.sheepy.lily.core;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.IAdapterProvider;
import org.sheepy.lily.core.application.ApplicationAdapter;
import org.sheepy.lily.core.cadence.adapter.*;
import org.sheepy.lily.core.variable.*;
import org.sheepy.lily.core.variable.action.SetVariableActionAdapter;

import java.util.List;

public class Adapters implements IAdapterProvider
{
	@Override
	public List<Class<? extends IAdapter>> classifiers()
	{
		return List.of(DirectVariableResolverAdapter.class,
					   ChainVariableResolverAdapter.class,
					   ApplicationAdapter.class,
					   ExecuteIfAdapter.class,
					   ExecuteWhileAdapter.class,
					   CadenceAdapter.class,
					   PrintUPSAdapter.class,
					   HaveTimeAdapter.class,
					   CountUntilAdapter.class,
					   CloseApplicationAdapter.class,
					   DurationVariableAdapter.class,
					   IntVariableAdapter.class,
					   FloatVariableAdapter.class,
					   Vector3fVariableAdapter.class,
					   SetVariableActionAdapter.class);
	}
}
