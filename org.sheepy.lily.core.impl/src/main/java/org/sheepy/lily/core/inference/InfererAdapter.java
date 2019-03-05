package org.sheepy.lily.core.inference;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.inference.IInferenceAdapter;
import org.sheepy.lily.core.api.inference.IInfererAdapter;
import org.sheepy.lily.core.model.inference.Inferer;

@Adapter(scope = Inferer.class, scopeInheritance = true)
public class InfererAdapter implements IInfererAdapter
{
	@Override
	public void load(Inferer unit)
	{
		IInferenceAdapter adapter = IInferenceAdapter.adapt(unit.lInferenceObject());
		adapter.addInferer(unit);
	}

	@Override
	public void dispose(Inferer unit)
	{
		IInferenceAdapter adapter = IInferenceAdapter.adapt(unit.lInferenceObject());
		adapter.removeInferer(unit);
	}
}
