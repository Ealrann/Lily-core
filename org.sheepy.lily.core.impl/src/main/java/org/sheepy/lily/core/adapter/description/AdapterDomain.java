package org.sheepy.lily.core.adapter.description;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.resource.IModelExtension;
import org.sheepy.lily.core.model.types.LNamedElement;

import java.util.List;

public final class AdapterDomain<T extends IAdapter>
{
	public final Class<T> type;
	public final EClass targetClassifier;
	public final boolean inheritance;
	public final String targetName;
	public final Adapter adapterAnnotation;
	public final boolean lazy;

	public AdapterDomain(Class<T> type,
						 EClass targetClassifier,
						 boolean inheritance,
						 String targetName,
						 Adapter adapterAnnotation,
						 boolean lazy)
	{
		this.targetClassifier = targetClassifier;
		this.inheritance = inheritance;
		this.targetName = targetName;
		this.adapterAnnotation = adapterAnnotation;
		this.lazy = lazy;
		assert type != null;
		this.type = type;
	}

	public boolean isAdapterForType(Class<? extends IAdapter> type)
	{
		return type.isAssignableFrom(this.type);
	}

	public boolean isApplicable(EObject eObject)
	{
		final boolean res = isClassApplicable(eObject.eClass());

		if (res == true && targetName.isEmpty() == false)
		{
			if (eObject instanceof LNamedElement == false ||
				targetName.equals(((LNamedElement) eObject).getName()) == false)
			{
				return false;
			}
		}

		return res;
	}

	private boolean isClassApplicable(EClass eClass)
	{
		final boolean res;
		if (inheritance)
		{
			res = targetClassifier.isSuperTypeOf(eClass);
		}
		else
		{
			res = eClass == targetClassifier;
		}
		return res;
	}

	public static final class Builder
	{
		public static <T extends IAdapter> AdapterDomain<T> build(final Class<T> type,
																  final Adapter adapterAnnotation,
																  final boolean isSingleton,
																  final boolean forceLoad,
																  final List<NotifyConfiguration> notifyConfigurations)
		{
			final var classifier = adapterAnnotation.scope();
			final boolean inheritance = adapterAnnotation.scopeInheritance();
			final EClass targetClassifier = gatherEClass(classifier);
			final String targetName = adapterAnnotation.name();

			final boolean auto = forceLoad ||
								 adapterAnnotation.lazy() == false ||
								 (isSingleton && notifyConfigurations.isEmpty() == false);

			return new AdapterDomain<>(type, targetClassifier, inheritance, targetName, adapterAnnotation, !auto);
		}

		private static EClass gatherEClass(Class<? extends EObject> classifier)
		{
			EClass res = null;

			final String name = classifier.getSimpleName();
			final String pkgName = classifier.getPackageName();
			EXT_LOOP:
			for (final IModelExtension extension : IModelExtension.EXTENSIONS)
			{
				for (final EPackage ePackage : extension.getEPackages())
				{
					final var epkg = ePackage.getClass().getPackageName().replaceAll(".impl", "");
					if (pkgName.equals(epkg))
					{
						res = (EClass) ePackage.getEClassifier(name);
						if (res != null)
						{
							break EXT_LOOP;
						}
					}
				}
			}

			if (res == null)
			{
				res = (EClass) EcorePackage.eINSTANCE.getEClassifier(name);
			}

			if (res == null)
			{
				eClassNotFoundError(name);
			}

			return res;
		}

		private static void eClassNotFoundError(String name) throws AssertionError
		{
			final String message = "Cannot find any EClass matching with %s";
			final String errorMessage = String.format(message, name);
			throw new AssertionError(errorMessage);
		}
	}
}
