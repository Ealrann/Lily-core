package org.sheepy.lily.core.adapter.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.resource.IModelExtension;
import org.sheepy.lily.core.api.util.ReflectUtils;
import org.sheepy.lily.core.model.types.LNamedElement;

public class AdapterDomain
{
	public final Class<? extends IAdapter> type;
	public final EClass targetClassifier;
	public final boolean inheritance;
	public final String targetName;
	public final Adapter adapterAnnotation;

	public AdapterDomain(Class<? extends IAdapter> type)
	{
		this.type = type;

		adapterAnnotation = ReflectUtils.gatherType(type, Adapter.class);

		final var classifier = adapterAnnotation.scope();
		inheritance = adapterAnnotation.scopeInheritance();
		targetClassifier = gatherEclass(classifier);
		targetName = adapterAnnotation.name();
	}

	private static EClass gatherEclass(Class<? extends EObject> classifier)
	{
		EClass res = null;

		final String name = classifier.getSimpleName();
		EXT_LOOP: for (final IModelExtension extension : IModelExtension.EXTENSIONS)
		{
			for (final EPackage ePackage : extension.getEPackages())
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
		return type.isAssignableFrom(this.type);
	}

	private static void eClassNotFoundError(String name) throws AssertionError
	{
		final String message = "Cannot find any EClass matching with %s";
		final String errorMessage = String.format(message, name);
		throw new AssertionError(errorMessage);
	}

	public boolean isApplicable(EObject eObject)
	{
		boolean res = false;
		final var eClass = eObject.eClass();

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