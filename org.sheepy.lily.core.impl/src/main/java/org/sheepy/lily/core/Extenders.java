package org.sheepy.lily.core;

import org.logoce.extender.api.IAdapter;
import org.logoce.extender.api.IAdapterProvider;
import org.sheepy.lily.core.action.CloseApplicationActionAdapter;
import org.sheepy.lily.core.application.ApplicationAdapter;
import org.sheepy.lily.core.cadence.adapter.*;
import org.sheepy.lily.core.variable.*;
import org.sheepy.lily.core.variable.action.SetVariableActionAdapter;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class Extenders implements IAdapterProvider
{
	@Override
	public List<Class<? extends IAdapter>> classifiers()
	{
		return List.of(DirectVariableResolverAdapter.class,
					   ChainVariableResolverAdapter.class,
					   CloseApplicationActionAdapter.class,
					   BooleanChangeActionAdapter.class,
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

	@Override
	public MethodHandles.Lookup lookup()
	{
		return MethodHandles.lookup();
	}
}
