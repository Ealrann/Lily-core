package org.sheepy.lily.core;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderProvider;
import org.sheepy.lily.core.application.ApplicationAdapter;
import org.sheepy.lily.core.cadence.adapter.*;
import org.sheepy.lily.core.variable.*;
import org.sheepy.lily.core.variable.action.SetVariableActionAdapter;

import java.util.List;

public class Extenders implements IExtenderProvider
{
	@Override
	public List<Class<? extends IExtender>> classifiers()
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
