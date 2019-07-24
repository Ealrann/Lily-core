package org.sheepy.lily.core.api.maintainer;

import org.eclipse.emf.ecore.EClass;
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
		final var maintainedEClass = (EClass) ModelUtil.resolveGenericType(maintainer,
				MAINTAINER_CLASS);

		final T res = (T) EcoreUtil.create(maintainedEClass);

		ModelUtil.copyFeatures(maintainer, res, maintainedEClass.getEAllStructuralFeatures());

		maintainer.getMaintained().add(res);

		return res;
	}
}
