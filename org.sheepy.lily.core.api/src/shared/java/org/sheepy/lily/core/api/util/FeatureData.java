package org.sheepy.lily.core.api.util;

import java.util.regex.Pattern;

import org.eclipse.emf.ecore.EAttribute;

public class FeatureData
{
	public final String nsURI;
	public final String className;
	public final String featureName;
	public final String definition;

	public FeatureData(String def)
	{
		this.definition = def;
		String[] split = def.split(Pattern.quote("#"));
		nsURI = split[0];
		className = split[1];
		featureName = split[2];
	}

	public FeatureData(EAttribute attribute)
	{
		featureName = attribute.getName();
		className = attribute.getEContainingClass().getName();
		nsURI = attribute.getEContainingClass().getEPackage().getNsURI();

		definition = String.format("%s#%s#%s", nsURI, className, featureName);
	}
}
