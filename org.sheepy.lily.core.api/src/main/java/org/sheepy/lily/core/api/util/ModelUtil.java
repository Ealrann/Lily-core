package org.sheepy.lily.core.api.util;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.core.model.application.ApplicationPackage;

public class ModelUtil
{
	public static final Application getApplication(EObject eObject)
	{
		while (eObject != null
				&& ApplicationPackage.Literals.APPLICATION.isInstance(eObject) == false)
		{
			eObject = eObject.eContainer();
		}

		return (Application) eObject;
	}

	public static void gatherChildEObjects(EObject eo, Collection<EObject> gatherIn)
	{
		var containments = eo.eClass().getEAllContainments();
		for (int i = 0; i < containments.size(); i++)
		{
			var eReference = containments.get(i);
			if (eReference.isMany())
			{
				@SuppressWarnings("unchecked")
				var values = (List<EObject>) eo.eGet(eReference);
				for (int j = 0; j < values.size(); j++)
				{
					EObject value = values.get(j);
					if (value != null)
					{
						gatherIn.add(eo);
					}
				}
			}
			else
			{
				var value = (EObject) eo.eGet(eReference);
				if (value != null)
				{
					gatherIn.add(eo);
				}
			}
		}
	}
}
