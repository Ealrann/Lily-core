package org.sheepy.lily.core.api.resource;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.EPackage;
import org.sheepy.lily.core.model.action.ActionPackage;
import org.sheepy.lily.core.model.application.ApplicationPackage;
import org.sheepy.lily.core.model.cadence.CadencePackage;
import org.sheepy.lily.core.model.inference.InferencePackage;
import org.sheepy.lily.core.model.presentation.PresentationPackage;
import org.sheepy.lily.core.model.resource.ResourcePackage;
import org.sheepy.lily.core.model.types.TypesPackage;
import org.sheepy.lily.core.model.ui.UiPackage;
import org.sheepy.lily.core.model.variable.VariablePackage;

public class CoreModelExtension implements IModelExtension
{
	@Override
	public Collection<EPackage> getEPackages()
	{
		final Collection<EPackage> res = new ArrayList<>();

		res.add(ActionPackage.eINSTANCE);
		res.add(ApplicationPackage.eINSTANCE);
		res.add(CadencePackage.eINSTANCE);
		res.add(InferencePackage.eINSTANCE);
		res.add(PresentationPackage.eINSTANCE);
		res.add(ResourcePackage.eINSTANCE);
		res.add(TypesPackage.eINSTANCE);
		res.add(UiPackage.eINSTANCE);
		res.add(VariablePackage.eINSTANCE);

		return res;
	}
}
