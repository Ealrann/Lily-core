package org.sheepy.common.api.resource;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.EPackage;
import org.sheepy.common.model.action.ActionPackage;
import org.sheepy.common.model.application.ApplicationPackage;
import org.sheepy.common.model.inference.InferencePackage;
import org.sheepy.common.model.presentation.PresentationPackage;
import org.sheepy.common.model.resolver.ResolverPackage;
import org.sheepy.common.model.root.RootPackage;
import org.sheepy.common.model.types.TypesPackage;
import org.sheepy.common.model.ui.UiPackage;
import org.sheepy.common.model.variable.VariablePackage;

public class CoreModelExtension implements IModelExtension
{
	@Override
	public Collection<EPackage> getEPackages()
	{
		Collection<EPackage> res = new ArrayList<>();

		res.add(ActionPackage.eINSTANCE);
		res.add(ApplicationPackage.eINSTANCE);
		res.add(InferencePackage.eINSTANCE);
		res.add(PresentationPackage.eINSTANCE);
		res.add(ResolverPackage.eINSTANCE);
		res.add(RootPackage.eINSTANCE);
		res.add(TypesPackage.eINSTANCE);
		res.add(UiPackage.eINSTANCE);
		res.add(VariablePackage.eINSTANCE);

		return res;
	}
}
