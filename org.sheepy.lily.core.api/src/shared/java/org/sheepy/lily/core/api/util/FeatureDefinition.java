package org.sheepy.lily.core.api.util;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;

public final class FeatureDefinition extends FeatureData
{
	public EPackage ePackage;
	public EClass eClass;
	public EStructuralFeature feature;

	public FeatureDefinition(String def)
	{
		super(def);

		try
		{
			ePackage = EPackage.Registry.INSTANCE.getEPackage(nsURI);
			eClass = (EClass) ePackage.getEClassifier(className);
			feature = eClass.getEStructuralFeature(featureName);
		} catch (final Exception e)
		{
			System.err.println("Cannot resolve the feature ref [" + def + "]");
			e.printStackTrace();
		}
	}

	public boolean match(Notification notification)
	{
		return notification.getFeature() == feature;
	}
}
