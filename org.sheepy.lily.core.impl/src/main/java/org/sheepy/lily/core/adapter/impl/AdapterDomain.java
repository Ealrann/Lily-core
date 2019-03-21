package org.sheepy.lily.core.adapter.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.resource.IModelExtension;
import org.sheepy.lily.core.api.util.ClassHierarchyIterator;
import org.sheepy.lily.core.model.types.LNamedElement;

public class AdapterDomain
{
	public final Class<? extends IAdapter> type;
	public final EClass targetClassifier;
	public final boolean inheritance;
	public final String targetName;

	public AdapterDomain(Adapter adapterAnnotation, Class<? extends IAdapter> type)
	{
		this.type = type;

		var classifier = adapterAnnotation.scope();
		inheritance = adapterAnnotation.scopeInheritance();
		targetClassifier = gatherEclass(classifier);
		targetName = adapterAnnotation.name();
	}

	private static EClass gatherEclass(Class<? extends EObject> classifier)
	{
		EClass res = null;
		String name = classifier.getSimpleName();
		EXT_LOOP: for (IModelExtension extension : IModelExtension.EXTENSIONS)
		{
			for (EPackage ePackage : extension.getEPackages())
			{
				res = (EClass) ePackage.getEClassifier(name);
				if (res != null)
				{
					break EXT_LOOP;
				}
			}
		}

		if (res == null)
		{
			eClassNotFoundError(name);
		}

		return res;
	}

	public boolean isAdapterForType(Class<? extends IAdapter> type)
	{
		ClassHierarchyIterator it = new ClassHierarchyIterator(this.type);
		while (it.hasNext())
		{
			if (it.next() == type)
			{
				return true;
			}
		}

		return false;
	}

	private static void eClassNotFoundError(String name) throws AssertionError
	{
		String message = "Cannot find any EClass matching with %s";
		String errorMessage = String.format(message, name);
		throw new AssertionError(errorMessage);
	}

	public boolean isApplicable(EObject eObject)
	{
		boolean res = false;
		var eClass = eObject.eClass();

		if (inheritance)
		{
			res = targetClassifier.isSuperTypeOf(eClass);
		}
		else
		{
			res = eClass == targetClassifier;
		}

		if (res == true && targetName.isEmpty() == false)
		{
			if (eObject instanceof LNamedElement == false
					|| targetName.equals(((LNamedElement) eObject).getName()) == false)
			{
				res = false;
			}
		}

		return res;
	}
}