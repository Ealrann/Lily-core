package org.sheepy.lily.core.inference;

import org.logoce.adapter.api.Adapter;
import org.logoce.extender.api.ModelExtender;
import org.sheepy.lily.core.api.inference.IInferenceAdapter;
import org.sheepy.lily.core.api.inference.IInfererAdapter;
import org.sheepy.lily.core.model.inference.Inferer;

@ModelExtender(scope = Inferer.class, inherited = true)
@Adapter(singleton = true)
public class InfererAdapter implements IInfererAdapter
{
	@Override
	public void load(Inferer unit)
	{
		final var lInferenceObject = unit.lInferenceObject();
		final IInferenceAdapter adapter = lInferenceObject.adaptNotNull(IInferenceAdapter.class);
		adapter.addInferer(unit);
	}

	@Override
	public void dispose(Inferer unit)
	{
		final var lInferenceObject = unit.lInferenceObject();
		final IInferenceAdapter adapter = lInferenceObject.adaptNotNull(IInferenceAdapter.class);
		adapter.removeInferer(unit);
	}
}
