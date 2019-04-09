package org.sheepy.lily.core.api.util;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
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

	@SuppressWarnings("unchecked")
	public static <T extends EObject> List<T> gatherAllChildren(EObject root, Class<T> type)
	{
		final List<T> res = new ArrayList<>();
		final Deque<EObject> course = new ArrayDeque<>();

		course.add(root);

		while (course.isEmpty() == false)
		{
			final var currentEObject = course.pop();

			if (type.isInstance(currentEObject))
			{
				res.add((T) currentEObject);
			}

			gatherChildren(currentEObject, course);
		}

		return res;
	}

	public static void gatherChildren(EObject eo, Collection<EObject> gatherIn)
	{
		gatherChildren(eo, EObject.class, gatherIn);
	}

	@SuppressWarnings("unchecked")
	public static <T extends EObject> void gatherChildren(	EObject eo,
															Class<T> type,
															Collection<T> gatherIn)
	{
		final var containments = eo.eClass().getEAllContainments();
		for (int i = 0; i < containments.size(); i++)
		{
			final var eReference = containments.get(i);

			if (type == null
					|| type == EObject.class
					|| eReference.getEReferenceType().getInstanceClass().isAssignableFrom(type))
			{
				if (eReference.isMany())
				{
					final var values = (List<EObject>) eo.eGet(eReference);
					for (int j = 0; j < values.size(); j++)
					{
						final EObject value = values.get(j);
						if (value != null)
						{
							gatherIn.add((T) value);
						}
					}
				}
				else
				{
					final var value = (EObject) eo.eGet(eReference);
					if (value != null)
					{
						gatherIn.add((T) value);
					}
				}
			}
		}
	}
}
