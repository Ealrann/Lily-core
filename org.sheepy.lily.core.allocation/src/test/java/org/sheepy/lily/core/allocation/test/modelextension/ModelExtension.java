package org.sheepy.lily.core.allocation.test.modelextension;

import org.eclipse.emf.ecore.EPackage;
import org.sheepy.lily.core.allocation.test.testallocation.TestallocationPackage;
import org.sheepy.lily.core.api.resource.IModelExtension;

import java.util.Collection;
import java.util.List;

public final class ModelExtension implements IModelExtension
{
	@Override
	public Collection<EPackage> getEPackages()
	{
		return List.of(TestallocationPackage.eINSTANCE);
	}
}
