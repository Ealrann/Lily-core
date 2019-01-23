package org.sheepy.lily.core.inference;

import org.eclipse.emf.ecore.EClass;
import org.sheepy.lily.core.api.adapter.impl.AbstractSingletonAdapter;
import org.sheepy.lily.core.api.inference.IInferenceAdapter;
import org.sheepy.lily.core.api.inference.IInfererAdapter;
import org.sheepy.lily.core.model.inference.InferencePackage;
import org.sheepy.lily.core.model.inference.Inferer;

public class InfererAdapter extends AbstractSingletonAdapter implements IInfererAdapter
{
	@Override
	public boolean isApplicable(EClass eClass)
	{
		return InferencePackage.Literals.INFERER.isSuperTypeOf(eClass);
	}

	@Override
	public void load(Inferer unit)
	{
		IInferenceAdapter adapter = adapterFactory.adapt(unit.lInferenceObject(), IInferenceAdapter.class);
		adapter.addInferer((Inferer) unit);
	}

	@Override
	public void dispose(Inferer unit)
	{
		IInferenceAdapter adapter = adapterFactory.adapt(unit.lInferenceObject(), IInferenceAdapter.class);
		adapter.removeInferer((Inferer) unit);
	}

}
