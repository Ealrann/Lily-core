package org.sheepy.lily.core.api.maintainer;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.core.model.maintainer.Maintainable;
import org.sheepy.lily.core.model.maintainer.Maintainer;
import org.sheepy.lily.core.model.maintainer.MaintainerPackage;

public final class MaintainerUtil
{
	private static final EClass MAINTAINER_CLASS = MaintainerPackage.Literals.MAINTAINER;

	private MaintainerUtil()
	{}

	@SuppressWarnings("unchecked")
	public static <T extends Maintainable<T>> T instanciateMaintainer(Maintainer<T> maintainer)
	{
		final var maintainedEClass = (EClass) ModelUtil.resolveGenericType(maintainer, MAINTAINER_CLASS);

		final T res = (T) EcoreUtil.create(maintainedEClass);

		for (final var feature : maintainedEClass.getEAllStructuralFeatures())
		{
			final boolean isNonContainment = feature instanceof EAttribute
					|| (feature instanceof EReference && ((EReference) feature).isContainment() == false);

			if (isNonContainment)
			{
				if (feature.isMany() == false)
				{
					res.eSet(feature, maintainer.eGet(feature));
				}
				else
				{
					final var listSrc = (EList<Object>) maintainer.eGet(feature);
					final var listTrg = (EList<Object>) res.eGet(feature);

					listTrg.addAll(listSrc);
				}
			}
			else
			{
				if (feature.isMany() == false)
				{
					res.eSet(feature, EcoreUtil.copy((EObject) maintainer.eGet(feature)));
				}
				else
				{
					final var listSrc = (EList<EObject>) maintainer.eGet(feature);
					final var listTrg = (EList<EObject>) res.eGet(feature);

					for (final EObject element : listSrc)
					{
						listTrg.add(EcoreUtil.copy(element));
					}
				}

			}
		}

		maintainer.getMaintained().add(res);

		return res;
	}
}
