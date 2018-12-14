package org.sheepy.common.api.util;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;

public class ResolvedVariableFeature extends VariableFeature
{
	public EPackage ePackage;
	public EClass eClass;
	public EStructuralFeature feature;

	public ResolvedVariableFeature(String def)
	{
		super(def);

		ePackage = EPackage.Registry.INSTANCE.getEPackage(nsURI);
		
		if(ePackage != null)
		{
			eClass = (EClass) ePackage.getEClassifier(className);
			feature = eClass.getEStructuralFeature(featureName);
		}
		else
		{
			System.err.println("Cannot resolve the nsURI [" + nsURI + "]");
		}
	}
}
