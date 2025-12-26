package org.sheepy.lily.core.api.resource;

import org.logoce.lmf.core.api.model.IModelPackage;
import org.sheepy.lily.core.model.action.ActionModelPackage;
import org.sheepy.lily.core.model.application.ApplicationModelPackage;
import org.sheepy.lily.core.model.cadence.CadenceModelPackage;
import org.sheepy.lily.core.model.inference.InferenceModelPackage;
import org.sheepy.lily.core.model.maintainer.MaintainerModelPackage;
import org.sheepy.lily.core.model.presentation.PresentationModelPackage;
import org.sheepy.lily.core.model.resource.ResourceModelPackage;
import org.sheepy.lily.core.model.types.TypesModelPackage;
import org.sheepy.lily.core.model.ui.UIModelPackage;
import org.sheepy.lily.core.model.variable.VariableModelPackage;

import java.util.ArrayList;
import java.util.Collection;

public class CoreModelExtension implements IModelExtension
{
	@Override
	public Collection<IModelPackage> getEPackages()
	{
		final Collection<IModelPackage> res = new ArrayList<>();

		res.add(ActionModelPackage.Instance);
		res.add(ApplicationModelPackage.Instance);
		res.add(CadenceModelPackage.Instance);
		res.add(InferenceModelPackage.Instance);
		res.add(MaintainerModelPackage.Instance);
		res.add(PresentationModelPackage.Instance);
		res.add(ResourceModelPackage.Instance);
		res.add(TypesModelPackage.Instance);
		res.add(UIModelPackage.Instance);
		res.add(VariableModelPackage.Instance);

		return res;
	}
}

